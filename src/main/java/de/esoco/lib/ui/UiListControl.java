//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2017 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
package de.esoco.lib.ui;

import de.esoco.lib.property.SingleSelection;


/********************************************************************
 * The base interface for UI components that display a list of values to select
 * one or more values from.
 *
 * @author eso
 */
public interface UiListControl extends UiControl, SingleSelection
{
	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Adds a string value to this component.
	 *
	 * @param sValue The value
	 */
	public void addValue(String sValue);

	/***************************************
	 * Removes all values.
	 */
	public void clear();

	/***************************************
	 * Returns the value at a certain index.
	 *
	 * @param  nIndex The index
	 *
	 * @return The value at the given index or NULL for none
	 */
	public String getValue(int nIndex);
}
