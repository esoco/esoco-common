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

/**
 * A special runtime exception subclass for function errors. As functions are
 * not allowed to throw checked exceptions this class provides a way to throw
 * exceptions from functions. It is intended to be used always as a wrapper
 * around another (checked) exception and therefore only contains a single
 * constructor for that purpose. Application code should unwrap the causing
 * exception with {@link #getCause()} to analyze the actual problem that
 * occurred. It is also possible to query the function that caused the problem
 * with the method {@link #getCausingFunction()}.
 *
 * @author eso
 */
public class FunctionException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final Object causingFunction;

	/**
	 * Creates a new instance. The function argument is of type object so that
	 * it can contain the different function types of Java 8.
	 *
	 * @param causingFunction The function that caused this exception
	 * @param cause           The checked exception that caused this function
	 *                        exception
	 */
	public FunctionException(Object causingFunction, Throwable cause) {
		super(cause.getMessage(), cause);

		this.causingFunction = causingFunction;
	}

	/**
	 * Returns the function instance that caused this exception.
	 *
	 * @return The causing function
	 */
	public final Object getCausingFunction() {
		return causingFunction;
	}
}
