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
 * An extended enumeration of alignment constants (see also {@link Alignment})
 * as used in layout mechanisms like CSS grid.
 */
public enum ContentAlignment implements HasCssName {
	START("start"), CENTER("center"), END("end"), STRETCH("stretch"),
	SPACE_AROUND("space-around"), SPACE_BETWEEN("space-between"),
	SPACE_EVENLY("space-evenly");

	//~ Instance fields --------------------------------------------------------

	private final String sCssName;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance.
	 *
	 * @param sCssName The CSS name of this instance
	 */
	private ContentAlignment(String sCssName) {
		this.sCssName = sCssName;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public String getCssName() {
		return sCssName;
	}
}
