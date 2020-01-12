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

import de.esoco.lib.property.SortDirection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/********************************************************************
 * A {@link DataProvider} implementation that is backed by a {@link List}. It
 * also implements ordering and filtering on attributes of the contained data.
 *
 * @author eso
 */
public class ListDataProvider<T> extends AbstractDataProvider<T> {

	//~ Instance fields --------------------------------------------------------

	private final List<T> aOriginalData;
	private List<T>		  aVisibleData;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance with a copy of a collection of data objects.
	 *
	 * @param rData A collection containing the data objects
	 */
	public ListDataProvider(Collection<T> rData) {
		aOriginalData = new ArrayList<>(rData);

		updateVisibleData();
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public Collection<T> getData(int nStart, int nCount) {
		if (nStart > aVisibleData.size()) {
			nStart = aVisibleData.size();
		}

		int nEnd = nStart + nCount;

		if (nEnd > aVisibleData.size()) {
			nEnd = aVisibleData.size();
		}

		return aVisibleData.subList(nStart, nEnd);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return aVisibleData.size();
	}

	/***************************************
	 * Compares the values of an attribute in two data objects according to the
	 * specification of the {@link Comparable} interface.
	 *
	 * @param  t1         The first data object
	 * @param  t2         The second data object
	 * @param  rAttribute The attribute to compare
	 * @param  eDirection The order direction
	 *
	 * @return The comparison value as defined by {@link Comparable}
	 */
	protected <V extends Comparable<V>> int compareAttributeValues(
		T					   t1,
		T					   t2,
		Function<? super T, V> rAttribute,
		SortDirection		   eDirection) {
		V v1 = rAttribute.apply(t1);
		V v2 = rAttribute.apply(t2);

		int nComparison;

		if (v1 == null || v2 == null) {
			nComparison =
				(v1 == null ? (v2 == null ? 0 : 1) : (v2 == null ? 0 : -1));
		} else {
			nComparison =
				(eDirection == SortDirection.ASCENDING ? v1.compareTo(v2)
													   : v2.compareTo(v1));
		}

		return nComparison;
	}

	/***************************************
	 * Compares two data objects and returns a result that is compliant with the
	 * {@link Comparable} interface.
	 *
	 * @param  t1 The first object to compare
	 * @param  t2 The second object to compare
	 *
	 * @return The comparison result
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int compareDataObjects(T t1, T t2) {
		int nComparison = -1;

		for (Entry<Function<? super T, ? extends Comparable<?>>, SortDirection> rOrdering :
			 getAttributeSortings().entrySet()) {
			Function<? super T, ? extends Comparable> rAttribute =
				rOrdering.getKey();

			SortDirection eDirection = rOrdering.getValue();

			nComparison =
				compareAttributeValues(t1, t2, rAttribute, eDirection);

			if (nComparison != 0) {
				break;
			}
		}

		return nComparison;
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	protected void updateFilter(
		Map<Function<? super T, ?>, Predicate<?>> rFilters) {
		updateVisibleData();
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	protected void updateSorting(
		Map<Function<? super T, ? extends Comparable<?>>, SortDirection> rSortings) {
		updateVisibleData();
	}

	/***************************************
	 * Resets the visible data to the original (full) data set.
	 */
	protected void updateVisibleData() {
		Stream<T> aDataStream = aOriginalData.stream();

		for (Entry<Function<? super T, ?>, Predicate<?>> rFilter :
			 getAttributeFilters().entrySet()) {
			Function<? super T, ?> rAttribute = rFilter.getKey();

			@SuppressWarnings("unchecked")
			Predicate<Object> pFilter = (Predicate<Object>) rFilter.getValue();

			aDataStream =
				aDataStream.filter(
					t -> { return pFilter.test(rAttribute.apply(t)); });
		}

		if (!getAttributeSortings().isEmpty()) {
			aDataStream = aDataStream.sorted(this::compareDataObjects);
		}

		aVisibleData = aDataStream.collect(Collectors.toList());
	}
}
