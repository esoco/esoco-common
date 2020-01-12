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
package de.esoco.lib.datatype;

/********************************************************************
 * A {@link Tuple} subclass that holds three generically typed values.
 *
 * @author eso
 */
public class Triple<F, S, T> extends Tuple {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance.
	 *
	 * @param rFirst  The first value
	 * @param rSecond The second value
	 * @param rThird  The third value
	 */
	public Triple(F rFirst, S rSecond, T rThird) {
		super(rFirst, rSecond, rThird);
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Factory method to creates a new instance. This method provides a semantic
	 * alternative to the constructor or the {@link #t(Object, Object, Object)}
	 * method.
	 *
	 * @param  rFirst  The first value
	 * @param  rSecond The second value
	 * @param  rThird  The third value
	 *
	 * @return A new pair instance
	 */
	public static <F, S, T> Triple<F, S, T> of(F rFirst, S rSecond, T rThird) {
		return new Triple<>(rFirst, rSecond, rThird);
	}

	/***************************************
	 * Factory method to creates a new instance. This method is intended to be
	 * used with static imports to provide a short syntax for defining
	 * triple-value tuples.
	 *
	 * @param  rFirst  The first value
	 * @param  rSecond The second value
	 * @param  rThird  The third value
	 *
	 * @return A new pair instance
	 */
	public static <F, S, T> Triple<F, S, T> t(F rFirst, S rSecond, T rThird) {
		return Triple.of(rFirst, rSecond, rThird);
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the first value.
	 *
	 * @return The first value
	 */
	@SuppressWarnings("unchecked")
	public final F first() {
		return (F) get(0);
	}

	/***************************************
	 * Returns the second value.
	 *
	 * @return The second value
	 */
	@SuppressWarnings("unchecked")
	public final S second() {
		return (S) get(1);
	}

	/***************************************
	 * Returns the third value.
	 *
	 * @return The third value
	 */
	@SuppressWarnings("unchecked")
	public final T third() {
		return (T) get(2);
	}
}
