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

import java.util.function.Consumer;
import java.util.function.Supplier;


/********************************************************************
 * A {@link Supplier} extension that maps any occurring exception to a runtime
 * {@link FunctionException}.
 *
 * @author eso
 */
@FunctionalInterface
public interface ThrowingConsumer<T> extends Consumer<T> {

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Factory method that allows to declare a throwing consumer from a lambda
	 * expression that is mapped to a regular consumer. Otherwise an anonymous
	 * inner class expression would be needed because of the similar signatures
	 * of throwing and non-throwing consumers.
	 *
	 * @param  fThrowing The throwing consumer expression
	 *
	 * @return The resulting function
	 */
	public static <T> Consumer<T> of(ThrowingConsumer<T> fThrowing) {
		return fThrowing;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Overridden to forward the invocation to the actual function
	 * implementation in {@link #tryAccept(Object)} and to convert occurring
	 * exceptions into {@link FunctionException}.
	 *
	 * @see Consumer#accept(Object)
	 */
	@Override
	default public void accept(T rValue) {
		try {
			tryAccept(rValue);
		} catch (RuntimeException e) {
			throw e;
		} catch (Exception e) {
			throw new FunctionException(this, e);
		}
	}

	/***************************************
	 * Replaces {@link #accept(Object)} and allows implementations to throw any
	 * kind of exception.
	 *
	 * @param  rValue The value to consume
	 *
	 * @throws Exception If the invocation fails
	 */
	public void tryAccept(T rValue) throws Exception;
}
