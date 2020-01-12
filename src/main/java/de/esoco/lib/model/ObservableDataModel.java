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
 * Extended data model interface that allows clients to be notified of changes
 * in the data structure by registering a {@link DataModelListener}. The base
 * type of the contained data elements can be constrained by providing the
 * corresponding type as the generic parameter T.
 *
 * @author eso
 */
public interface ObservableDataModel<T> extends DataModel<T> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Registers a data model listener that must be notified of data and
	 * structure changes by the model implementation.
	 *
	 * @param rListener The listener to register
	 */
	public void addModelListener(DataModelListener rListener);

	/***************************************
	 * Unregisters a data model listener from this model.
	 *
	 * @param rListener The listener to register
	 */
	public void removeModelListener(DataModelListener rListener);
}
