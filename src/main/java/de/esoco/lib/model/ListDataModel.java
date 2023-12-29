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

/**
 * A simple data model implementation that is based on a list. A name can be
 * assigned to instances so that they can be rendered directly in certain user
 * interface elements.
 *
 * @author eso
 */
public class ListDataModel<T> implements DataModel<T>, Serializable {

	private static final long serialVersionUID = 1L;

	private static final ListDataModel<?> EMPTY_MODEL =
		new ListDataModel<Object>("EMPTY", new ArrayList<Object>());

	private String name;

	private List<T> data;

	/**
	 * Creates a new instance from a list of data. The list will be used
	 * directly (i.e. without copying their contents) so that changes to the
	 * list data will modify the model too. If this is not desired a copy of
	 * the
	 * original list should be used as the argument instead.
	 *
	 * @param name The name of this model
	 * @param data The model's data
	 */
	public ListDataModel(String name, List<T> data) {
		this.name = name;
		this.data = data;
	}

	/**
	 * Creates a new instance that contains the given elements.
	 *
	 * @param name     The name of this model
	 * @param elements The elements this data model shall contain
	 */
	@SafeVarargs
	public ListDataModel(String name, T... elements) {
		this(name, Arrays.asList(elements));
	}

	/**
	 * Default constructor for serialization.
	 */
	ListDataModel() {
	}

	/**
	 * Returns a singleton instance of an empty model.
	 *
	 * @return An empty singleton instance
	 */
	@SuppressWarnings("unchecked")
	public static <T> ListDataModel<T> emptyModel() {
		return (ListDataModel<T>) EMPTY_MODEL;
	}

	/**
	 * @see Object#equals(Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		ListDataModel<?> other = (ListDataModel<?>) obj;

		if (name == null) {
			if (other.name != null) {
				return false;
			}
		} else if (!name.equals(other.name)) {
			return false;
		}

		if (data == null) {
			return other.data == null;
		} else
			return data.equals(other.data);
	}

	/**
	 * @see DataModel#getElement(int)
	 */
	@Override
	public T getElement(int index) {
		return data.get(index);
	}

	/**
	 * @see DataModel#getElementCount()
	 */
	@Override
	public int getElementCount() {
		return data.size();
	}

	/**
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = 1;

		hashCode = 37 * hashCode + ((data == null) ? 0 : data.hashCode());
		hashCode = 37 * hashCode + ((name == null) ? 0 : name.hashCode());

		return hashCode;
	}

	/**
	 * @see Iterable#iterator()
	 */
	@Override
	public Iterator<T> iterator() {
		return data.iterator();
	}

	/**
	 * Returns the name of this model instance.
	 *
	 * @return The model name
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * A method for subclasses to set the data of this model. This method
	 * should
	 * be used by subclasses that need to initialize the model data after the
	 * model instance has been created.
	 *
	 * @param data The model data
	 */
	protected void setData(List<T> data) {
		this.data = data;
	}
}
