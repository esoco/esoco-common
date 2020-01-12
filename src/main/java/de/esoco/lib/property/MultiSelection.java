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

/********************************************************************
 * Property interface for indexed composite objects that provide a way to select
 * multiple of their elements in their structure. For objects that only support
 * the selection of single elements see {@link SingleSelection}.
 *
 * @author eso
 */
public interface MultiSelection {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the indices of the currently selected values.
	 *
	 * @return The selection indices
	 */
	public int[] getSelectionIndices();

	/***************************************
	 * Selects the elements with the indices contained in the argument array.
	 *
	 * @param rIndices An array with the indices of the elements to select
	 */
	public void setSelection(int[] rIndices);

	/***************************************
	 * Selects all elements within the given range.
	 *
	 * @param nStart The start index (inclusive)
	 * @param nEnd   The end index (inclusive)
	 */
	public void setSelection(int nStart, int nEnd);
}
