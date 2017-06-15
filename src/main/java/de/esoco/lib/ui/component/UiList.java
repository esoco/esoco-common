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
package de.esoco.lib.ui.component;

import de.esoco.lib.ui.UiListControl;


/********************************************************************
 * A list component that displays a scrollable list of values.
 *
 * @author eso
 */
public interface UiList extends UiListControl
{
	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Sets the rows that should be visible.
	 *
	 * @param nRows The visible rows
	 */
	public void setVisibleRows(int nRows);
}
