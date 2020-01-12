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
 * An enumeration of relative sizes that can be applied to UI elements.
 */
public enum RelativeSize {
	FULL, HALF, THIRD, QUARTER, FIFTH, SIXTH, SEVENTH, EIGHTH, NINETH, TENTH,
	TWO_THIRDS(2, 3), THREE_QUARTERS(3, 4), TWO_FIFTH(2, 5), THREE_FIFTHS(3, 5),
	FOUR_FIFTH(4, 5), FIVE_SIXTH(5, 6);

	//~ Instance fields --------------------------------------------------------

	private int nMultiplier;
	private int nDivider;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance.
	 */
	private RelativeSize() {
		nMultiplier = 1;
		nDivider    = ordinal() + 1;
	}

	/***************************************
	 * Creates a new instance.
	 *
	 * @param nMultiplier The multiplier for size calculations
	 * @param nDivider    The divider for size calculations
	 */
	private RelativeSize(int nMultiplier, int nDivider) {
		this.nMultiplier = nMultiplier;
		this.nDivider    = nDivider;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Calculates an absolute size value from a full size for this instance.
	 *
	 * @param  nFullSize The full size to calculate the size from
	 *
	 * @return The calculated absolute size value
	 */
	public int calcSize(int nFullSize) {
		return nFullSize * nMultiplier / nDivider;
	}
}
