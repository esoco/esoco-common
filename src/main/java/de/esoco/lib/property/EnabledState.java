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
 * Property interface for elements that can be enabled or disabled.
 *
 * @author eso
 */
public interface EnabledState {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Sets the state of this object to disabled.
	 */
	default public void disable() {
		setEnabled(false);
	}

	/***************************************
	 * Sets the state of this object to enabled.
	 */
	default public void enable() {
		setEnabled(true);
	}

	/***************************************
	 * Returns the enabled state of the element.
	 *
	 * @return TRUE if the element is enabled, FALSE if disabled
	 */
	public boolean isEnabled();

	/***************************************
	 * Sets the enabled state of the element. This state controls whether the
	 * element will allow and react to user input.
	 *
	 * @param bEnabled TRUE to enable the element, FALSE to disable it
	 */
	public void setEnabled(boolean bEnabled);
}
