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
 * An extension of the {@link Flags} interface that allows to set and clear
 * flags on the implementing object.
 *
 * @author eso
 */
public interface Flaggable<F> extends Flags<F> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Clears a certain flag.
	 *
	 * @param rFlag The flag to clear
	 */
	public void clearFlag(F rFlag);

	/***************************************
	 * Sets a certain flag.
	 *
	 * @param rFlag The flag to set
	 */
	public void setFlag(F rFlag);
}
