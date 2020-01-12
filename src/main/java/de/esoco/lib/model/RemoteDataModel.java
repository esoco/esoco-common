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
 * An extended data model interface that is optimized for remote access. Because
 * the communication with remote systems can be affected by delays or
 * interruptions a remote data model provides additional methods to support
 * asynchronous communication. This allows the calling code to continue with
 * other tasks like UI updates without being blocked by the data model query.
 * This is achieved by providing a window into the remote data that can be
 * accessed through the methods of this interface. This window typically only
 * contains a subset of the full data in the remote model.
 *
 * <p>The method {@link #setWindow(int, int, Callback)} must be invoked to
 * request remote data. The callback given to this method will be called as soon
 * as the data has been retrieved from the remote system. Only the requested
 * range of data can then be read from the model. Therefore application code
 * must always prepare the model data before accessing it. Furthermore iterators
 * returned by a remote model only iterate over the prepared data of the
 * model.</p>
 *
 * <p>The result of the method {@link #getElementCount()} should only be
 * expected to be available after the model window has been prepared once.
 * Depending on the model implementation the element count may only be an
 * estimation. For example, if the remote data is based on a database query the
 * amount of data available may change during subsequent model accesses.
 * Therefore an application must not rely on this value and consequently also
 * not on the expected number of prepared data records. Instead it must
 * explicitly check the actual amount of records that have been prepared by the
 * last call to the method {@link #setWindow(int, int, Callback)}, either by
 * invoking {@link #getAvailableElementCount()} or by iterating through the
 * model. The actual number of prepared records may even be 0, e.g. if data has
 * been deleted on the remote side.</p>
 *
 * @author eso
 */
public interface RemoteDataModel<T> extends DataModel<T> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the number of elements that are effectively available after a
	 * previous call to the method {@link #setWindow(int, int, Callback)}. The
	 * number returned may be lower than the window size of this model if the
	 * remote model contains less elements after the starting index.
	 *
	 * @return The number of prepared data elements
	 */
	public int getAvailableElementCount();

	/***************************************
	 * Returns the size of the window to the remote data that is read by a call
	 * to {@link #setWindow(int, int, Callback)}.
	 *
	 * @return The size of the remote data window
	 */
	public int getWindowSize();

	/***************************************
	 * Returns the starting index of the window to the remote data that is read
	 * by a call to {@link #setWindow(int, int, Callback)}.
	 *
	 * @return The starting index of the remote data window
	 */
	public int getWindowStart();

	/***************************************
	 * Sets the window into remote data for retrieval through the methods of the
	 * base interface {@link DataModel}. This call is performed asynchronously
	 * and will notify the given {@link Callback} object when the preparation of
	 * the data window has finished (either successful or with an error). The
	 * given starting index must be inside the full size of the data model as
	 * returned by {@link DataModel#getElementCount()} or else an error will
	 * occur.
	 *
	 * @param nStart    The starting index of the first element to retrieve
	 * @param nSize     nStart The number of elements to be retrieved
	 * @param rCallback The callback to be notified if the data is available
	 */
	public void setWindow(int						   nStart,
						  int						   nSize,
						  Callback<RemoteDataModel<T>> rCallback);
}
