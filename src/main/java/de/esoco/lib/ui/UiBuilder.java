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

import de.esoco.lib.ui.component.UiDateField;
import de.esoco.lib.ui.component.UiLabel;
import de.esoco.lib.ui.component.UiPanel;
import de.esoco.lib.ui.component.UiTextField;


/********************************************************************
 * The builder interface to be used to create instances of the components.
 *
 * @author eso
 */
public interface UiBuilder extends UiElement, ButtonBuilder
{
	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Adds a date input field.
	 *
	 * @return The new component
	 */
	public UiDateField addDateField();

	/***************************************
	 * Adds a text label.
	 *
	 * @param  sText The label text
	 *
	 * @return The new component
	 */
	public UiLabel addLabel(String sText);

	/***************************************
	 * Adds a panel container.
	 *
	 * @return The new component
	 */
	public UiPanel addPanel();

	/***************************************
	 * Adds a multi-line text input field.
	 *
	 * @return The new component
	 */
	public UiTextField addTextArea();

	/***************************************
	 * Adds a single-line text input field.
	 *
	 * @return The new component
	 */
	public UiTextField addTextField();
}
