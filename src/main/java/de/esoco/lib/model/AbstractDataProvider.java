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
package de.esoco.lib.model;

import de.esoco.lib.property.HasAttributeFilter;
import de.esoco.lib.property.HasAttributeSorting;
import de.esoco.lib.property.SortDirection;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


/********************************************************************
 * A base class for {@link DataProvider} implementations that handles the
 * management of filter and sort constraints.
 *
 * @author eso
 */
public abstract class AbstractDataProvider<T>
	implements DataProvider<T>, HasAttributeFilter<T>, HasAttributeSorting<T> {

	//~ Instance fields --------------------------------------------------------

	private Map<Function<? super T, ?>, Predicate<?>> aAttributeFilters =
		new LinkedHashMap<>();

	private Map<Function<? super T, ? extends Comparable<?>>, SortDirection> aAttributeSortings =
		new LinkedHashMap<>();

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <V> void applyFilter(
		Function<? super T, V> rAttribute,
		Predicate<? super V>   pCriteria) {
		if (pCriteria == null) {
			aAttributeFilters.remove(rAttribute);
		} else {
			aAttributeFilters.put(rAttribute, pCriteria);
		}

		updateFilter(aAttributeFilters);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <V extends Comparable<V>> void applySorting(
		Function<? super T, V> rAttribute,
		SortDirection		   eDirection) {
		if (eDirection == null) {
			aAttributeSortings.remove(rAttribute);
		} else {
			aAttributeSortings.put(rAttribute, eDirection);
		}

		updateSorting(aAttributeSortings);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <V> Predicate<? super V> getFilter(
		Function<? super T, V> rAttribute) {
		return (Predicate<? super V>) aAttributeFilters.get(rAttribute);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public SortDirection getSortDirection(Function<? super T, ?> rAttribute) {
		return aAttributeSortings.get(rAttribute);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasActiveFilter() {
		return !aAttributeFilters.isEmpty();
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public boolean hasActiveSorting() {
		return !aAttributeSortings.isEmpty();
	}

	/***************************************
	 * Removes all attribute filters.
	 */
	public void removeAllFilters() {
		aAttributeFilters.clear();
		updateFilter(aAttributeFilters);
	}

	/***************************************
	 * Removes all attribute sortings.
	 */
	public void removeAllSortings() {
		aAttributeSortings.clear();
		updateSorting(aAttributeSortings);
	}

	/***************************************
	 * Will be called when the filter has changed and needs to be updated by the
	 * implementation.
	 *
	 * @param rFilters The updated filters
	 */
	protected abstract void updateFilter(
		Map<Function<? super T, ?>, Predicate<?>> rFilters);

	/***************************************
	 * Will be called when the sorting has changed and needs to be updated by
	 * the implementation.
	 *
	 * @param rSortings rAttributeFilters The updated sortings
	 */
	protected abstract void updateSorting(
		Map<Function<? super T, ? extends Comparable<?>>, SortDirection> rSortings);

	/***************************************
	 * Returns the attribute filters.
	 *
	 * @return A mapping from attributes to filter predicates
	 */
	protected final Map<Function<? super T, ?>, Predicate<?>>
	getAttributeFilters() {
		return aAttributeFilters;
	}

	/***************************************
	 * Returns the attribute order criteria.
	 *
	 * @return A mapping from attributes to order directions
	 */
	protected final Map<Function<? super T, ? extends Comparable<?>>,
						SortDirection> getAttributeSortings() {
		return aAttributeSortings;
	}
}
