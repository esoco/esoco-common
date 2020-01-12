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
 * A collection of {@link PropertyName} constants for typical user interface
 * properties.
 *
 * @author eso
 */
public class UserInterfaceProperties implements ContentProperties,
												LayoutProperties,
												StateProperties,
												StyleProperties {

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Private, only static use.
	 */
	private UserInterfaceProperties() {
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * This method should be invoked to initialize the property name constants
	 * for de-serialization.
	 */
	public static void init() {
		// necessary for GWT because otherwise the constants are not initialized
		// correctly; the exact values seems to be of no importance but it must
		// be one from each implemented interface
		@SuppressWarnings("unused")
		PropertyName<?>[] rInitDummy =
			new PropertyName<?>[] {
				ContentProperties.RESOURCE, LayoutProperties.WIDTH,
				StateProperties.DISABLED, StyleProperties.WRAP
			};
	}
}
