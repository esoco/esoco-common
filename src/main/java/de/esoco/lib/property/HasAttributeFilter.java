//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2020 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
package de.esoco.lib.property;

import java.util.function.Function;
import java.util.function.Predicate;


/********************************************************************
 * Indicates that the implementing object allows to filter it's content by
 * certain attributes of the underlying data objects.
 *
 * @author eso
 */
public interface HasAttributeFilter<T> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Sets or removes a filter for a certain attribute and then applies the
	 * resulting filter to this instance.
	 *
	 * @param rAttribute The binding describing the attribute
	 * @param pCriteria  A predicate containing the filter criteria or NULL to
	 *                   remove a filter
	 */
	public <V> void applyFilter(
		Function<? super T, V> rAttribute,
		Predicate<? super V>   pCriteria);

	/***************************************
	 * Returns the filter for a particular attribute. If no filter has been set
	 * for the given attribute NULL will be returned.
	 *
	 * @param  rAttribute The attribute to query the filter predicate for
	 *
	 * @return The attribute filter predicate or NULL for none
	 */
	public <V> Predicate<? super V> getFilter(
		Function<? super T, V> rAttribute);

	/***************************************
	 * Checks if one or more attribute filters are active.
	 *
	 * @return TRUE if at least one filter criterion has been set
	 */
	public boolean hasActiveFilter();
}
