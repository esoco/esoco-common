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

import java.util.function.Function;


/********************************************************************
 * Indicates that the implementing object allows to sort it's content by certain
 * attributes of the underlying data objects.
 *
 * @author eso
 */
public interface HasAttributeSorting<T> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Sets or removes the sorting of a certain attribute and then applies it to
	 * this instance. The order in which sortings are applied defines their
	 * precedence, with the first sorting having the highest.
	 *
	 * @param rAttribute The binding describing the attribute
	 * @param eDirection The sort direction or NULL to remove sorting
	 */
	public <V extends Comparable<V>> void applySorting(
		Function<? super T, V> rAttribute,
		SortDirection		   eDirection);

	/***************************************
	 * Returns the sort direction for a particular attribute. If no sorting has
	 * been set for the given attribute NULL will be returned.
	 *
	 * @param  rAttribute The attribute to query the order of
	 *
	 * @return The attribute sort direction or NULL for none
	 */
	public SortDirection getSortDirection(Function<? super T, ?> rAttribute);

	/***************************************
	 * Checks if one or more attribute sort orders are active.
	 *
	 * @return TRUE if at least one attribute is sorted
	 */
	public boolean hasActiveSorting();
}
