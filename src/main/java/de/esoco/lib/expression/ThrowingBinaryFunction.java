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
package de.esoco.lib.expression;

import java.util.function.BiFunction;


/********************************************************************
 * A sub-interface that allows implementations to throw checked exceptions. If
 * an exception occurs it will be converted into a runtime exception of the type
 * {@link FunctionException}.
 *
 * @author eso
 */
@FunctionalInterface
public interface ThrowingBinaryFunction<L, R, O> extends BiFunction<L, R, O> {

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Factory method that allows to declare a throwing function from a lambda
	 * expression that is mapped to a regular function. Otherwise an anonymous
	 * inner class expression would be needed because of the similar signatures
	 * of throwing and non-throwing functions.
	 *
	 * @param  fThrowing The throwing function expression
	 *
	 * @return The resulting function
	 */
	public static <L, R, O> BiFunction<L, R, O> of(
		ThrowingBinaryFunction<L, R, O> fThrowing) {
		return fThrowing;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * The version of {@link #apply(Object, Object)} that allows implementations
	 * to throw an exception.
	 *
	 * @param  rLeft  The left argument
	 * @param  rRight The right argument
	 *
	 * @return The function result
	 *
	 * @throws Exception Any kind of exception may be thrown
	 */
	public O tryApply(L rLeft, R rRight) throws Exception;

	// ~ Methods ------------------------------------------------------------

	/***************************************
	 * Overridden to forward the invocation to the actual function
	 * implementation in {@link #tryApply(Object, Object)} and to convert
	 * occurring exceptions into {@link FunctionException}.
	 *
	 * @see BiFunction#apply(Object, Object)
	 */
	@Override
	default O apply(L rLeft, R rRight) {
		try {
			return tryApply(rLeft, rRight);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new FunctionException(this, e);
		}
	}
}
