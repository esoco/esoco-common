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
 * A base interface for classes that implement fluent method invocations, i.e.
 * methods that return the instance they are invoked on.
 *
 * @author eso
 */
public interface Fluent<T extends Fluent<T>> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * A helper method for implementations that handles the repetitive task of
	 * returning this instance after applying some action to it. This method is
	 * intended to be used by subclasses for more specific method
	 * implementations only, but because interface methods are always public it
	 * has been named with a leading underscore to emphasize this usage.
	 *
	 * <p>Invoking this method externally won't harm but typically doesn't make
	 * sense because the action is provided as a runnable which can only have
	 * access to the invoked instance if it is created in it's context (or
	 * captures it). Using this method for other purposes is therefore
	 * discouraged as it may harm code readability.</p>
	 *
	 * @param  fUpdate The function that performs the fluent action
	 *
	 * @return This instance for fluent invocation
	 */
	@SuppressWarnings("unchecked")
	default T _with(Runnable fUpdate) {
		fUpdate.run();

		return (T) this;
	}
}
