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

import java.util.Collection;


/********************************************************************
 * An interface for objects that can have an arbitrary number of flags set on
 * them. The flags can be of arbitrary types (typically strings or enums) and
 * their existence can be queries with {@link #hasFlag(Object)}.
 *
 * @author eso
 */
public interface Flags<F> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the flags of this object. The returned collection may be empty
	 * but will never be NULL.
	 *
	 * @return A collection containing the flags
	 */
	public Collection<F> getFlags();

	/***************************************
	 * Checks whether a certain flag is set in this object.
	 *
	 * @param  rFlag The flag to check
	 *
	 * @return TRUE if the flag is set
	 */
	public boolean hasFlag(F rFlag);
}
