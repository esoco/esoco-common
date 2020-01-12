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
 * Interface for data models that represent an indexed set of data elements. The
 * base type of the contained data elements is defined by the generic parameter
 * T.
 *
 * @author eso
 */
public interface DataModel<T> extends Iterable<T> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the data element at a certain position. The position index must
	 * be in the range from 0 (zero) to {@link #getElementCount()} - 1, else an
	 * {@link IndexOutOfBoundsException} will be thrown.
	 *
	 * @param  nIndex The position of the element to return
	 *
	 * @return The data element at the given position
	 *
	 * @throws IndexOutOfBoundsException If the given index is invalid
	 */
	public T getElement(int nIndex);

	/***************************************
	 * Returns the size of this data model.
	 *
	 * @return The number of data elements this model contains
	 */
	public int getElementCount();
}
