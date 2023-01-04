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

/**
 * A {@link Tuple} subclass that holds a pair of two generically typed values.
 *
 * @author eso
 */
public class Pair<F, S> extends Tuple {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance.
	 *
	 * @param first  The first object
	 * @param second The second object
	 */
	public Pair(F first, S second) {
		super(first, second);
	}

	/**
	 * Factory method to creates a new instance. This method provides a semantic
	 * alternative to the constructor or the {@link #t(Object, Object)} method.
	 *
	 * @param first  The first value
	 * @param second The second value
	 * @return A new pair instance
	 */
	public static <F, S> Pair<F, S> of(F first, S second) {
		return new Pair<>(first, second);
	}

	/**
	 * Factory method to creates a new instance. This method is intended to be
	 * used with static imports to provide a short syntax for defining
	 * dual-value tuples, especially in varargs lists.
	 *
	 * @param first  The first value
	 * @param second The second value
	 * @return A new pair instance
	 */
	public static <F, S> Pair<F, S> t(F first, S second) {
		return Pair.of(first, second);
	}

	/**
	 * Returns the first value.
	 *
	 * @return The first value
	 */
	@SuppressWarnings("unchecked")
	public final F first() {
		return (F) get(0);
	}

	/**
	 * Returns the second value.
	 *
	 * @return The second value
	 */
	@SuppressWarnings("unchecked")
	public final S second() {
		return (S) get(1);
	}
}
