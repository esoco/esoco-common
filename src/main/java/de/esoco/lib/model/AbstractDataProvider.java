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
package de.esoco.lib.model;

import de.esoco.lib.property.HasAttributeFilter;
import de.esoco.lib.property.HasAttributeOrdering;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;


/********************************************************************
 * A base class for {@link DataProvider} implementations that handles the
 * management of filter and order constraints.
 *
 * @author eso
 */
public abstract class AbstractDataProvider<T> implements DataProvider<T>,
														 HasAttributeFilter<T>,
														 HasAttributeOrdering<T>
{
	//~ Instance fields --------------------------------------------------------

	private Map<Function<? super T, ?>, Predicate<?>> aAttributeFilters =
		new LinkedHashMap<>();

	private Map<Function<? super T, ? extends Comparable<?>>, OrderDirection> aAttributeOrders =
		new LinkedHashMap<>();

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <V> void applyFilter(
		Function<? super T, V> rAttribute,
		Predicate<? super V>   pCriteria)
	{
		if (pCriteria == null)
		{
			aAttributeFilters.remove(rAttribute);
		}
		else
		{
			aAttributeFilters.put(rAttribute, pCriteria);
		}

		applyConstraints();
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <V extends Comparable<V>> void applyOrder(
		Function<? super T, V> rAttribute,
		OrderDirection		   eDirection)
	{
		if (eDirection == null)
		{
			aAttributeOrders.remove(rAttribute);
		}
		else
		{
			aAttributeOrders.put(rAttribute, eDirection);
		}

		applyConstraints();
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	@SuppressWarnings("unchecked")
	public <V> Predicate<? super V> getFilter(Function<? super T, V> rAttribute)
	{
		return (Predicate<? super V>) aAttributeFilters.get(rAttribute);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public OrderDirection getOrder(Function<? super T, ?> rAttribute)
	{
		return aAttributeOrders.get(rAttribute);
	}

	/***************************************
	 * Must be implemented by subclasses to apply (or reset) the filter and
	 * order constraints that have been set on this instance.
	 */
	protected abstract void applyConstraints();

	/***************************************
	 * Returns the attribute filters.
	 *
	 * @return A mapping from attributes to filter predicates
	 */
	protected final Map<Function<? super T, ?>, Predicate<?>> getAttributeFilters()
	{
		return aAttributeFilters;
	}

	/***************************************
	 * Returns the attribute order criteria.
	 *
	 * @return A mapping from attributes to order directions
	 */
	protected final Map<Function<? super T, ? extends Comparable<?>>,
						OrderDirection> getAttributeOrders()
	{
		return aAttributeOrders;
	}
}
