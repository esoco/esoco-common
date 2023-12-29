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

/**
 * A {@link DataProvider} implementation that is backed by a {@link List}. It
 * also implements ordering and filtering on attributes of the contained data.
 *
 * @author eso
 */
public class ListDataProvider<T> extends AbstractDataProvider<T> {

	private final List<T> originalData;

	private List<T> visibleData;

	/**
	 * Creates a new instance with a copy of a collection of data objects.
	 *
	 * @param data A collection containing the data objects
	 */
	public ListDataProvider(Collection<T> data) {
		originalData = new ArrayList<>(data);

		updateVisibleData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<T> getData(int start, int count) {
		if (start > visibleData.size()) {
			start = visibleData.size();
		}

		int end = start + count;

		if (end > visibleData.size()) {
			end = visibleData.size();
		}

		return visibleData.subList(start, end);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int size() {
		return visibleData.size();
	}

	/**
	 * Compares the values of an attribute in two data objects according to the
	 * specification of the {@link Comparable} interface.
	 *
	 * @param t1        The first data object
	 * @param t2        The second data object
	 * @param attribute The attribute to compare
	 * @param direction The order direction
	 * @return The comparison value as defined by {@link Comparable}
	 */
	protected <V extends Comparable<V>> int compareAttributeValues(T t1, T t2,
		Function<? super T, V> attribute, SortDirection direction) {
		V v1 = attribute.apply(t1);
		V v2 = attribute.apply(t2);

		int comparison;

		if (v1 == null || v2 == null) {
			comparison =
				(v1 == null ? (v2 == null ? 0 : 1) : (v2 == null ? 0 : -1));
		} else {
			comparison = (direction == SortDirection.ASCENDING ?
			              v1.compareTo(v2) :
			              v2.compareTo(v1));
		}

		return comparison;
	}

	/**
	 * Compares two data objects and returns a result that is compliant with
	 * the
	 * {@link Comparable} interface.
	 *
	 * @param t1 The first object to compare
	 * @param t2 The second object to compare
	 * @return The comparison result
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected int compareDataObjects(T t1, T t2) {
		int comparison = -1;

		for (Entry<Function<? super T, ? extends Comparable<?>>,
			SortDirection> ordering : getAttributeSortings().entrySet()) {
			Function<? super T, ? extends Comparable> attribute =
				ordering.getKey();

			SortDirection direction = ordering.getValue();

			comparison = compareAttributeValues(t1, t2, attribute, direction);

			if (comparison != 0) {
				break;
			}
		}

		return comparison;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void updateFilter(
		Map<Function<? super T, ?>, Predicate<?>> filters) {
		updateVisibleData();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void updateSorting(
		Map<Function<? super T, ? extends Comparable<?>>, SortDirection> sortings) {
		updateVisibleData();
	}

	/**
	 * Resets the visible data to the original (full) data set.
	 */
	protected void updateVisibleData() {
		Stream<T> dataStream = originalData.stream();

		for (Entry<Function<? super T, ?>, Predicate<?>> filter :
			getAttributeFilters().entrySet()) {
			Function<? super T, ?> attribute = filter.getKey();

			@SuppressWarnings("unchecked")
			Predicate<Object> filterPredicate =
				(Predicate<Object>) filter.getValue();

			dataStream = dataStream.filter(t -> {
				return filterPredicate.test(attribute.apply(t));
			});
		}

		if (!getAttributeSortings().isEmpty()) {
			dataStream = dataStream.sorted(this::compareDataObjects);
		}

		visibleData = dataStream.collect(Collectors.toList());
	}
}
