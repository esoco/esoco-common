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

import java.io.Serializable;

/**
 * This class implements a property mapping that encodes all property values as
 * strings. See the implemented interface {@link MutableProperties} for
 * details.
 *
 * @author eso
 */
public class StringProperties extends AbstractStringProperties
	implements MutableProperties, Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Creates a new instance.
	 */
	public StringProperties() {
	}

	/**
	 * Copy constructor that creates a new instance from another properties
	 * object. Invokes the {@link #setProperties(HasProperties, boolean)}
	 * method.
	 *
	 * @param other The instance to copy the properties from
	 */
	public StringProperties(HasProperties other) {
		setProperties(other, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void clearFlag(PropertyName<Boolean> name) {
		if (hasProperty(name)) {
			removeProperty(name);
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void clearProperties() {
		setPropertyMap(null);
	}

	/**
	 * Overridden as public.
	 *
	 * @see MutableProperties#removeProperty(PropertyName)
	 */
	@Override
	public void removeProperty(PropertyName<?> name) {
		super.removeProperty(name);
	}

	/**
	 * Overridden as public.
	 *
	 * @see MutableProperties#setFlag(PropertyName)
	 */
	@Override
	public final void setFlag(PropertyName<Boolean> name) {
		setProperty(name, true);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void setProperties(HasProperties other, boolean replace) {
		if (other.getPropertyCount() > 0) {
			ensurePropertyMapExists();

			for (PropertyName<?> name : other.getPropertyNames()) {
				if (replace || !hasProperty(name)) {
					Object value = other.getProperty(name, null);

					if (value != null) {
						getPropertyMap().put(name, convertValue(value));
					}
				}
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> void setProperty(PropertyName<T> name, T value) {
		super.setProperty(name, value);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setProperty(PropertyName<Boolean> name, boolean value) {
		setProperty(name, Boolean.valueOf(value));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public final void setProperty(PropertyName<Integer> name, int value) {
		setProperty(name, Integer.valueOf(value));
	}
}
