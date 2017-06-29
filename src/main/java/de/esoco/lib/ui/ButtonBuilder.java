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

import de.esoco.lib.ui.component.UiPushButton;


/********************************************************************
 * A builder interface for the creation of buttons.
 *
 * @author eso
 */
public interface ButtonBuilder extends UiElement
{
	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Adds a new check box component. The label can be provided either as an
	 * enum value or as an arbitrary object that will be converted to a string
	 * by means of {@link Object#toString()}.
	 *
	 * @param  rButtonLabel The button label
	 *
	 * @return The new component
	 */
	public UiPushButton addCheckBox(Object rButtonLabel);

	/***************************************
	 * Adds a new button component. The label can be provided either as an enum
	 * value or as an arbitrary object that will be converted to a string by
	 * means of {@link Object#toString()}.
	 *
	 * @param  rButtonLabel The button label
	 *
	 * @return The new component
	 */
	public UiPushButton addPushButton(Object rButtonLabel);

	/***************************************
	 * Adds a new radio button component. The label can be provided either as an
	 * enum value or as an arbitrary object that will be converted to a string
	 * by means of {@link Object#toString()}.
	 *
	 * @param  rButtonLabel The button label
	 *
	 * @return The new component
	 */
	public UiPushButton addRadioButton(Object rButtonLabel);
}
