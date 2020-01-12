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

import java.io.Serializable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;


/********************************************************************
 * A class that contains value tuples. Tuples are immutable and cannot be
 * changed after creation.
 *
 * @author eso
 */
public class Tuple implements Iterable<Object>, Serializable {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	//~ Instance fields --------------------------------------------------------

	private final List<Object> aValues;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance.
	 *
	 * @param rValues The tuple values
	 */
	protected Tuple(Object... rValues) {
		aValues = Arrays.asList(rValues);
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Creates a new {@link Tuple}. This factory method is intended to be used
	 * with static imports to provide a short syntax for defining value tuples.
	 * If more specific value datatypes are needed a corresponding subclass
	 * should be used (or created if necessary).
	 *
	 * @param  rValues The tuple values
	 *
	 * @return A new tuple instance
	 */
	public static Tuple t(Object... rValues) {
		return new Tuple(rValues);
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object rObj) {
		if (rObj == this) {
			return true;
		}

		if (!(rObj instanceof Tuple)) {
			return false;
		}

		Tuple rOther = (Tuple) rObj;

		if (rOther.size() != size()) {
			return false;
		}

		return aValues.equals(rOther.aValues);
	}

	/***************************************
	 * Returns a certain value from this tuple.
	 *
	 * @param  i The index of the value (0 &lt;= i &lt; {@link #size()})
	 *
	 * @return The value at the given index
	 */
	public Object get(int i) {
		return aValues.get(i);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public int hashCode() {
		int nHashCode = 37;

		for (Object rValue : aValues) {
			nHashCode =
				nHashCode * (rValue != null ? rValue.hashCode() : 0) + 17;
		}

		return nHashCode;
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public Iterator<Object> iterator() {
		return aValues.iterator();
	}

	/***************************************
	 * Returns the size of this tuple.
	 *
	 * @return The tuple size
	 */
	public int size() {
		return aValues.size();
	}

	/***************************************
	 * Returns a {@link Stream} of the values in this tuple.
	 *
	 * @return The value stream
	 */
	public Stream<Object> stream() {
		return aValues.stream();
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public String toString() {
		return aValues.toString();
	}
}
