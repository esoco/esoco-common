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
 * An interface for objects that are ordered in some way. This interface defines
 * the method {@link #ordinal()} from which the order of instances can be
 * determined. The method decalaration is identical to {@link Enum#ordinal()} so
 * that this interface can be implemented directly by enums.
 *
 * @author eso
 */
public interface HasOrder {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the ordinal number of this instance.
	 *
	 * @return The ordinal number
	 */
	public int ordinal();
}
