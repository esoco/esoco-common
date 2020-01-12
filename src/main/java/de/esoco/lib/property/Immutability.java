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
 * Implementing this interface declares an object to support immutability. This
 * is a special property as it can only be set once by invoking the method
 * {@link #setImmutable()} and cannot be reverted afterwards. Implementations
 * must prevent any further modifications of their data after this method had
 * been invoked. They must not implement any mechanism to revert this invocation
 * because that would contradict the concept of immutability.
 *
 * @author eso
 */
public interface Immutability {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Sets this object to be immutable. Afterwards, the object must not allow
	 * further modification of it's internal state.
	 */
	public void setImmutable();
}
