//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2017 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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

import de.esoco.lib.model.AttributeBinding;


/********************************************************************
 * Indicates that the implementing object allows to order it's content by
 * certain attributes of the underlying data objects.
 *
 * @author eso
 */
@FunctionalInterface
public interface HasAttributeOrdering<T>
{
	//~ Enums ------------------------------------------------------------------

	/********************************************************************
	 * Enumeration of the possible sort modes. May be extended in future
	 * versions with additional sort options.
	 */
	public enum OrderDirection { ASCENDING, DESCENDING }

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Applies or removes the ordering of a certain attribute. The order in
	 * which orderings are applied defines their precedence, with the first
	 * ordering having the highest.
	 *
	 * @param rAttribute The binding describing the attribute
	 * @param eDirection The order direction or NULL to remove the ordering
	 */
	public <V extends Comparable<V>> void applyOrder(
		AttributeBinding<T, V> rAttribute,
		OrderDirection		   eDirection);
}