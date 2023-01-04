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

/********************************************************************
 * A data model extension for hierarchical data structures. It provides methods
 * to access the parent and child models of the data model implementation.
 *
 * @author eso
 */
public interface HierarchicalDataModel<T> extends DataModel<T> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns a data model of the children of this data model.
	 *
	 * @return A list of this model's children (may be NULL or empty if no
	 *         children exists)
	 */
	DataModel<? extends DataModel<T>> getChildModels();
}
