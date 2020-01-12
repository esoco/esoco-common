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
 * a single element in their structure.
 *
 * @author eso
 */
public interface SingleSelection {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the index of the currently selected element. If the object also
	 * supports multiple selections (see {@link MultiSelection}) this method
	 * returns the index of the first selected item.
	 *
	 * @return The index of the current selection or -1 for none
	 */
	public int getSelectionIndex();

	/***************************************
	 * Sets the index of the currently selected element. For implementations
	 * that allow complete deselection an index value of -1 will deselect all
	 * elements.
	 *
	 * @param nIndex The index of the new selected element or -1 for none
	 */
	public void setSelection(int nIndex);
}
