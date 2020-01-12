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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


/********************************************************************
 * A simple data model implementation that is based on a list. A name can be
 * assigned to instances so that they can be rendered directly in certain user
 * interface elements.
 *
 * @author eso
 */
public class ListDataModel<T> implements DataModel<T>, Serializable {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	private static final ListDataModel<?> EMPTY_MODEL =
		new ListDataModel<Object>("EMPTY", new ArrayList<Object>());

	//~ Instance fields --------------------------------------------------------

	private String  sName;
	private List<T> rData;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance from a list of data. The list will be used
	 * directly (i.e. without copying their contents) so that changes to the
	 * list data will modify the model too. If this is not desired a copy of the
	 * original list should be used as the argument instead.
	 *
	 * @param sName The name of this model
	 * @param rData The model's data
	 */
	public ListDataModel(String sName, List<T> rData) {
		this.sName = sName;
		this.rData = rData;
	}

	/***************************************
	 * Creates a new instance that contains the given elements.
	 *
	 * @param sName     The name of this model
	 * @param rElements The elements this data model shall contain
	 */
	@SafeVarargs
	public ListDataModel(String sName, T... rElements) {
		this(sName, Arrays.asList(rElements));
	}

	/***************************************
	 * Default constructor for serialization.
	 */
	ListDataModel() {
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Returns a singleton instance of an empty model.
	 *
	 * @return An empty singleton instance
	 */
	@SuppressWarnings("unchecked")
	public static <T> ListDataModel<T> emptyModel() {
		return (ListDataModel<T>) EMPTY_MODEL;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object rObj) {
		if (this == rObj) {
			return true;
		}

		if (rObj == null || getClass() != rObj.getClass()) {
			return false;
		}

		ListDataModel<?> rOther = (ListDataModel<?>) rObj;

		if (sName == null) {
			if (rOther.sName != null) {
				return false;
			}
		} else if (!sName.equals(rOther.sName)) {
			return false;
		}

		if (rData == null) {
			if (rOther.rData != null) {
				return false;
			}
		} else if (!rData.equals(rOther.rData)) {
			return false;
		}

		return true;
	}

	/***************************************
	 * @see DataModel#getElement(int)
	 */
	@Override
	public T getElement(int nIndex) {
		return rData.get(nIndex);
	}

	/***************************************
	 * @see DataModel#getElementCount()
	 */
	@Override
	public int getElementCount() {
		return rData.size();
	}

	/***************************************
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int nHashCode = 1;

		nHashCode = 37 * nHashCode + ((rData == null) ? 0 : rData.hashCode());
		nHashCode = 37 * nHashCode + ((sName == null) ? 0 : sName.hashCode());

		return nHashCode;
	}

	/***************************************
	 * @see Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return rData.iterator();
	}

	/***************************************
	 * Returns the name of this model instance.
	 *
	 * @return The model name
	 */
	@Override
	public String toString() {
		return sName;
	}

	/***************************************
	 * A method for subclasses to set the data of this model. This method should
	 * be used by subclasses that need to initialize the model data after the
	 * model instance has been created.
	 *
	 * @param rData The model data
	 */
	protected void setData(List<T> rData) {
		this.rData = rData;
	}
}
