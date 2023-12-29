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

/**
 * An interface for objects that provide write access to named properties.
 * Type-specific access methods allow to set and retrieve the properties. See
 * the base class for further information.
 *
 * @author eso
 */
public interface MutableProperties extends HasProperties {

	/**
	 * Convenience method to set a boolean property to FALSE.
	 *
	 * @param name The name of the boolean property
	 */
	void clearFlag(PropertyName<Boolean> name);

	/**
	 * Removes all properties from this instance.
	 */
	void clearProperties();

	/**
	 * Removes a certain property.
	 *
	 * @param name The name of the property to remove
	 */
	void removeProperty(PropertyName<?> name);

	/**
	 * Convenience method to set a boolean property to TRUE.
	 *
	 * @param name The name of the boolean property
	 */
	void setFlag(PropertyName<Boolean> name);

	/**
	 * Sets all properties from another properties object in this instance. The
	 * boolean parameter controls whether existing properties will be replaced
	 * or ignored.
	 *
	 * <p>It depends on the actual implementations whether all properties from
	 * the other instance can be copied correctly into the target instance. It
	 * is therefore recommended to use this method only with properties objects
	 * of the same or a compatible type. Implementations should indicate
	 * incompatible data formats by throwing a runtime exception.</p>
	 *
	 * @param other   The instance to copy the properties from
	 * @param replace TRUE to replace existing value, FALSE to only add
	 *                non-existing values
	 */
	void setProperties(HasProperties other, boolean replace);

	/**
	 * Sets a particular property. Setting a value of NULL will remove the
	 * property from this instance.
	 *
	 * @param name  The name of the property
	 * @param value The value of the property (NULL removes the property)
	 */
	<T> void setProperty(PropertyName<T> name, T value);

	/**
	 * Convenience method to set boolean properties.
	 *
	 * @see #setProperty(PropertyName, boolean)
	 */
	void setProperty(PropertyName<Boolean> name, boolean value);

	/**
	 * Convenience method to set integer properties.
	 *
	 * @see #setProperty(PropertyName, int)
	 */
	void setProperty(PropertyName<Integer> name, int value);
}
