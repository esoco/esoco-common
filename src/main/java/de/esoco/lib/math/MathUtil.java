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
package de.esoco.lib.math;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

/**
 * Contains additional mathematical functions.
 *
 * @author eso
 */
public class MathUtil {

	/**
	 * Enumeration of metric prefixes.
	 */
	public enum MetricPrefix {
		YOTTA(24), ZETTA(21), EXA(18), PETA(15), TERA(12), GIGA(9), MEGA(6),
		KILO(3), HECTO(2), DECA(1), DECI(-1), CENTI(-2), MILLI(-3), MICRO(-6),
		NANO(-9), PICO(-12), FEMTO(-15), ATTO(-18), ZEPTO(-21), YOCTO(-24);

		private final int exponent;

		private final BigDecimal decimalValue;

		/**
		 * Creates a new instance.
		 *
		 * @param exponent the value of the exponent
		 */
		MetricPrefix(int exponent) {
			this.exponent = exponent;

			if (exponent > 0) {
				decimalValue = BigDecimal.TEN.pow(exponent);
			} else {
				decimalValue =
					BigDecimal.ONE.divide(BigDecimal.TEN.pow(-exponent));
			}
		}

		/**
		 * Returns the decimal representation of this prefix, i.e. the value
		 * 10<sup>exponent</sup>.
		 *
		 * @return The decimal value of this prefix
		 */
		public BigDecimal decimal() {
			return decimalValue;
		}

		/**
		 * Returns the decimal exponent of this prefix.
		 *
		 * @return The decimal exponent
		 */
		public int exponent() {
			return exponent;
		}
	}

	/**
	 * {@link BigDecimal} constant for the value 2 without scale.
	 */
	public static final BigDecimal TWO = new BigDecimal(2);

	/**
	 * {@link BigDecimal} constant for the value 100 without scale.
	 */
	public static final BigDecimal HUNDRED = new BigDecimal(100);

	/**
	 * {@link BigDecimal} constant for the value 1000 without scale.
	 */
	public static final BigDecimal THOUSAND = new BigDecimal(1_000);

	/**
	 * Private, only static use.
	 */
	private MathUtil() {
	}

	/**
	 * Calculates the square root of a {@link BigDecimal} value with a maximum
	 * scale of 16 digits.
	 *
	 * @param value The value to calculate the square root of
	 * @return A big decimal containing the square root value
	 */
	public static BigDecimal sqrt(BigDecimal value) {
		return sqrt(value, 16);
	}

	/**
	 * Calculate the square root of a {@link BigDecimal} with the <a
	 * href="https://en.wikipedia.org/wiki/Methods_of_computing_square_roots
	 * #Babylonian_method"> Babylonian method</a>. See <a
	 * href="https://stackoverflow
	 * .com/questions/13649703/square-root-of-bigdecimal-in-java"> this
	 * StackOverflow question</a> for additional infos.
	 *
	 * @param value The value to calculate the square root of
	 * @param scale The maximum scale of the result
	 * @return A big decimal containing the square root value
	 */
	public static BigDecimal sqrt(BigDecimal value, int scale) {
		Objects.requireNonNull(value);

		if (value.signum() == -1) {
			throw new IllegalArgumentException("Value must not be negative");
		}

		// increase scale by 1 for better rounding precision in last digit
		scale++;

		BigDecimal x0 = BigDecimal.ZERO;
		BigDecimal x1 = value.divide(TWO, scale, RoundingMode.FLOOR);

		while (x0.compareTo(x1) != 0) {
			x0 = x1;
			x1 = value.divide(x0, scale, RoundingMode.HALF_UP);
			x1 = x1.add(x0);
			x1 = x1.divide(TWO, scale, RoundingMode.HALF_UP);
		}

		return x1.setScale(scale - 1, RoundingMode.HALF_UP);
	}
}
