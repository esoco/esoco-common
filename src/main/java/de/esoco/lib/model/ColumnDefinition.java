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
package de.esoco.lib.model;

import de.esoco.lib.property.MutableProperties;

import java.io.Serializable;


/********************************************************************
 * The definition of a column in table or tree-table components.
 *
 * @author eso
 */
public interface ColumnDefinition extends MutableProperties, Serializable {

	//~ Static fields/initializers ---------------------------------------------

	/** The standard prefix for column resource keys */
	public static final String STD_COLUMN_PREFIX = "$col";

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the datatype of the column values. For wider serialization
	 * support it is a string containing the simple name of the datatype class
	 * (see {@link Class#getSimpleName()}).
	 *
	 * @return The column datatype
	 */
	public String getDatatype();

	/***************************************
	 * Returns the column identifier. This value is application-dependent. It
	 * can be something like an integer column index or a database column name,
	 * for example. It must be unique so that it can be used to unambiguously
	 * identify the referenced column in the model.
	 *
	 * @return The column identifier
	 */
	public String getId();

	/***************************************
	 * Returns the column title.
	 *
	 * @return The column title
	 */
	public String getTitle();
}
