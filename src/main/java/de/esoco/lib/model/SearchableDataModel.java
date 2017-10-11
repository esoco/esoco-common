//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2017 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//	  http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package de.esoco.lib.model;

import java.util.Map;


/********************************************************************
 * An extended data model that allows to sort the contained data elements by
 * setting constraint values for certain fields.
 *
 * @author eso
 */
public interface SearchableDataModel<T> extends DataModel<T>
{
	//~ Static fields/initializers ---------------------------------------------

	/** A constant to allow searching for NULL values. */
	public static final String NULL_CONSTRAINT_VALUE = "NULL!";

	/**
	 * The possible comparison characters for constraints (\u2260,\u2264,\u2265:
	 * ≠,≤,≥). '~' means "almost equal" and is used for fuzzy searches. '#'
	 * means "element of' and can be followed by a comma-separated list of
	 * values.
	 */
	public static final String CONSTRAINT_COMPARISON_CHARS =
		"=\u2260~#<>\u2264\u2265";

	/**
	 * The prefix character for constraints that should be combined with a
	 * logical AND.
	 */
	public static final char CONSTRAINT_AND_PREFIX = '&';

	/**
	 * The prefix character for constraints that should be combined with a
	 * logical OR.
	 */
	public static final char CONSTRAINT_OR_PREFIX = '|';

	/**
	 * The separator string to concatenate multiple constraints for a certain
	 * field with.
	 */
	public static final String CONSTRAINT_SEPARATOR = "¶";

	/**
	 * An escape string that must be used to replace all natural occurrences of
	 * {@link #CONSTRAINT_SEPARATOR} in constraints with. This string must
	 * therefore not occur in constraints or else it will be replaced with the
	 * separator.
	 */
	public static final String CONSTRAINT_SEPARATOR_ESCAPE = "<°>";

	/** The date format pattern string for date values in search constraints. */
	public static final String CONSTRAINT_DATE_FORMAT_PATTERN = "yyyy-MM-dd";

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the search constraint for a certain field of the data in this
	 * model.
	 *
	 * @param  sFieldId The ID of the data field to get the constraint for
	 *
	 * @return The search constraint string for the given field or NULL for none
	 */
	public String getConstraint(String sFieldId);

	/***************************************
	 * Returns all search constraint that are set in this data model as a
	 * mapping from field IDs to constraints. A caller should assume that it is
	 * not allowed to modify the returned map unless stated otherwise by the
	 * implementation.
	 *
	 * @return A mapping from field ID strings to search constraint strings
	 */
	public Map<String, String> getConstraints();

	/***************************************
	 * Removes all search constraints from this model.
	 */
	public void removeConstraints();

	/***************************************
	 * Sets the search constraint for a certain field. If the constraint
	 * parameter is NULL an existing constraint for the given field will be
	 * removed. The constraint will be concatenated with a logical AND
	 * expression if the first character is {@link #CONSTRAINT_AND_PREFIX} and
	 * with a logical OR if it is {@link #CONSTRAINT_OR_PREFIX}.
	 *
	 * <p>It is possible to set multiple constraints on a field by concatenating
	 * them with a {@link #CONSTRAINT_SEPARATOR} in between. Any occurrences of
	 * the separator string in a constraint must therefore be escaped by
	 * replacing them with the {@link #CONSTRAINT_SEPARATOR_ESCAPE}.</p>
	 *
	 * <p>If the first character of the constraint is one of the characters in
	 * the constant {@link #CONSTRAINT_COMPARISON_CHARS} the corresponding
	 * comparison will be applied to the constraint value that follows after the
	 * character. If omitted an equals comparison will be used.</p>
	 *
	 * <p>Besides simple text the constraint value may contain expressions,
	 * placeholders, and wildcards to allow searches that cover a range of
	 * values as shown below. The wildcard characters '*' and '?' can be
	 * combined. Attention: not all implementations may support value
	 * expressions, some may even only support simple string matching.</p>
	 *
	 * <ul>
	 *   <li>&lt;[Value]: Matches all values that are less than the given
	 *     value</li>
	 *   <li>&gt;[Value]: Matches all values that are greater than the given
	 *     value</li>
	 *   <li>[Value]*: Matches any string that starts with the given value.</li>
	 *   <li>*[Value]: Matches any string that ends with the given value.</li>
	 *   <li>*[Value]*: Matches any string that contains the given value.</li>
	 *   <li>[Va]?[ue]: The question mark is a wildcard for an arbitrary
	 *     character; multiple question marks are allowed.</li>
	 *   <li>![Value]: Matches any string that does NOT match the given value.
	 *     The value may contain wildcard characters.</li>
	 * </ul>
	 *
	 * @param sFieldId    The ID of the data field to set the constraint for
	 * @param sConstraint The constraint value or NULL to remove a constraint
	 */
	public void setConstraint(String sFieldId, String sConstraint);

	/***************************************
	 * Sets the search constraints of this model. This will remove any existing
	 * constraints.
	 *
	 * @param rConstraints A mapping from field ID strings to search constraint
	 *                     strings
	 */
	public void setConstraints(Map<String, String> rConstraints);
}
