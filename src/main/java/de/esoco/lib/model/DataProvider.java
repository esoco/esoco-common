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

import java.util.Collection;


/********************************************************************
 * An interface for objects that provide access to indexed data.
 *
 * @author eso
 */
public interface DataProvider<T> {

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Returns a new data provider that contains a certain collection of data
	 * objects.
	 *
	 * @param  rData The collection of data objects
	 *
	 * @return The new data provider
	 */
	public static <T> DataProvider<T> of(Collection<T> rData) {
		return new ListDataProvider<>(rData);
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns a subset of data objects from this provider. If less data then
	 * requested is available the returned collection may contain less elements
	 * then nCount. It may even be empty but it will never be NULL.
	 *
	 * @param  nStart The starting index of the first data object to return
	 * @param  nCount The number of data objects to return
	 *
	 * @return A collection of data objects (may be empty but will never be
	 *         NULL)
	 */
	public Collection<T> getData(int nStart, int nCount);

	/***************************************
	 * Returns the number of data objects that are available from this provider.
	 *
	 * @return The count of available data objects
	 */
	public int size();
}
