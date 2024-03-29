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

/**
 * An interface for objects that provide the possibility to select values.
 * Multi-selection can be represented by using a collection as the generic
 * type.
 *
 * <p>Other than {@link SingleSelection} and {@link MultiSelection} this
 * interface is based on the value datatype, not on selection indexes. If
 * necessary both interface types can be used in parallel.</p>
 *
 * @author eso
 */
public interface HasSelection<T> {

	/**
	 * Returns the selection.
	 *
	 * @return The selection (will be NULL for no selection)
	 */
	T getSelection();

	/**
	 * Sets the selection.
	 *
	 * @param newSelection The new selection or NULL for none
	 */
	void setSelection(T newSelection);
}
