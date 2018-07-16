//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2018 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
package de.esoco.lib.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

import java.util.Objects;


/********************************************************************
 * Contains additional mathematical functions.
 *
 * @author eso
 */
public class MathUtil
{
	//~ Static fields/initializers ---------------------------------------------

	/** {@link BigDecimal} constant for the value 2 without scale. */
	public static final BigDecimal TWO = new BigDecimal(2);

	/** {@link BigDecimal} constant for the value 100 without scale. */
	public static final BigDecimal HUNDRED = new BigDecimal(100);

	/** {@link BigDecimal} constant for the value 1000 without scale. */
	public static final BigDecimal THOUSAND = new BigDecimal(1_000);

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Private, only static use.
	 */
	private MathUtil()
	{
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Calculates the square root of a {@link BigDecimal} value with a maximum
	 * scale of 10.
	 *
	 * @param  dValue The value to calculate the square root of
	 *
	 * @return A big decimal containing the square root value
	 */
	public static BigDecimal sqrt(BigDecimal dValue)
	{
		return sqrt(dValue, 10);
	}

	/***************************************
	 * Calculate the square root of a {@link BigDecimal} with the <a
	 * href="https://en.wikipedia.org/wiki/Methods_of_computing_square_roots#Babylonian_method">
	 * Babylonian method</a>. See <a
	 * href="https://stackoverflow.com/questions/13649703/square-root-of-bigdecimal-in-java">
	 * this StackOverflow question</a> for additional infos.
	 *
	 * @param  dValue The value to calculate the square root of
	 * @param  nScale The maximum scale of the result
	 *
	 * @return
	 */
	public static BigDecimal sqrt(BigDecimal dValue, int nScale)
	{
		Objects.requireNonNull(dValue);

		if (dValue.signum() == -1)
		{
			throw new IllegalArgumentException("Value must not be negative");
		}

		// increase scale by 1 for better rounding precision in last digit
		nScale++;

		BigDecimal x0 = BigDecimal.ZERO;
		BigDecimal x1 = dValue.divide(TWO, nScale, RoundingMode.FLOOR);

		while (x0.compareTo(x1) != 0)
		{
			x0 = x1;
			x1 = dValue.divide(x0, nScale, RoundingMode.HALF_UP);
			x1 = x1.add(x0);
			x1 = x1.divide(TWO, nScale, RoundingMode.HALF_UP);
		}

		return x1.setScale(nScale - 1, RoundingMode.HALF_UP);
	}
}
