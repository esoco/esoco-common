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
import java.util.function.Predicate;


/********************************************************************
 * A base class for {@link DataProvider} implementations that handles the
 * management of filter and order constraints.
 *
 * @author eso
 */
public abstract class AbstractDataProvider<T>
	implements DataProvider<T>, HasAttributeOrdering<T>, HasAttributeFilter<T>
{
	//~ Instance fields --------------------------------------------------------

	private Map<AttributeBinding<T, ? extends Comparable<?>>, OrderDirection> aOrderCriteria =
		new LinkedHashMap<>();

	private Map<AttributeBinding<T, ?>, Predicate<?>> aFilters =
		new LinkedHashMap<>();

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <V> void applyFilter(
		AttributeBinding<T, V> rAttribute,
		Predicate<? super V>   pCriteria)
	{
		if (pCriteria == null)
		{
			aFilters.remove(rAttribute);
		}
		else
		{
			aFilters.put(rAttribute, pCriteria);
		}

		applyConstraints();
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <V extends Comparable<V>> void applyOrder(
		AttributeBinding<T, V> rAttribute,
		OrderDirection		   eDirection)
	{
		if (eDirection == null)
		{
			aOrderCriteria.remove(rAttribute);
		}
		else
		{
			aOrderCriteria.put(rAttribute, eDirection);
		}

		applyConstraints();
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
	protected final Map<AttributeBinding<T, ?>, Predicate<?>> getFilters()
	{
		return aFilters;
	}

	/***************************************
	 * Returns the attribute order criteria.
	 *
	 * @return A mapping from attributes to order directions
	 */
	protected final Map<AttributeBinding<T, ? extends Comparable<?>>,
						OrderDirection> getOrderCriteria()
	{
		return aOrderCriteria;
	}
}
