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

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class to define type-safe name constants for properties. The type parameter
 * allows to create type-safe mappings by using the type parameter in the
 * signatures of generic methods. Instances are created through the static
 * factory methods.
 */
public class PropertyName<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final Map<String, PropertyName<?>> nameRegistry =
		new HashMap<String, PropertyName<?>>();

	private final String name;

	private final Class<?> datatype;

	private final Class<?>[] elementDatatypes;

	/**
	 * Internal constructor to creates a new instance with a certain name and
	 * datatype. Instances must always be created through one of the public
	 * factory methods.
	 *
	 * @param name             The name of this instance
	 * @param datatype         The class of the name's datatype
	 * @param elementDatatypes The optional datatypes for collection
	 *                         properties
	 * @throws IllegalArgumentException If the given name has already been used
	 */
	PropertyName(String name, Class<?> datatype,
		Class<?>... elementDatatypes) {
		this.name = name;
		this.datatype = datatype;
		this.elementDatatypes = elementDatatypes;

		if (nameRegistry.containsKey(name)) {
			throw new IllegalArgumentException(
				"Property name already exists: " + name);
		}

		nameRegistry.put(name, this);
	}

	/**
	 * Factory method to create a new property name with a boolean datatype.
	 *
	 * @param name The name
	 * @return A new instance with the given name
	 */
	public static PropertyName<Boolean> newBooleanName(String name) {
		return newName(name, Boolean.class);
	}

	/**
	 * Factory method to create a new property name with a boolean datatype.
	 *
	 * @param name The name
	 * @return A new instance with the given name
	 */
	public static PropertyName<Date> newDateName(String name) {
		return newName(name, Date.class);
	}

	/**
	 * Factory method to create a new property name with an enum datatype.
	 *
	 * @param name      The name
	 * @param enumClass The enum class of the property
	 * @return A new instance with the given name
	 */
	public static <E extends Enum<E>> PropertyName<E> newEnumName(String name,
		Class<E> enumClass) {
		return newName(name, enumClass);
	}

	/**
	 * Factory method to create a new name with an integer datatype.
	 *
	 * @param name The name
	 * @return A new instance with the given name
	 */
	public static PropertyName<Integer> newIntegerName(String name) {
		return newName(name, Integer.class);
	}

	/**
	 * Factory method to create a new property name with a list datatype.
	 *
	 * @param name        The name
	 * @param elementType The datatype of the list elements
	 * @return A new instance with the given name
	 */
	public static <E> PropertyName<List<E>> newListName(String name,
		Class<E> elementType) {
		return new PropertyName<List<E>>(name, List.class, elementType);
	}

	/**
	 * Factory method to create a new property name with a map datatype.
	 *
	 * @param name      The name
	 * @param keyType   The datatype of the map keys
	 * @param valueType The datatype of the map values
	 * @return A new instance with the given name
	 */
	public static <K, V> PropertyName<Map<K, V>> newMapName(String name,
		Class<K> keyType, Class<V> valueType) {
		return new PropertyName<Map<K, V>>(name, Map.class, keyType,
			valueType);
	}

	/**
	 * Factory method to create a new property name with a certain datatype.
	 *
	 * @param name     The name
	 * @param datatype The class of the datatype
	 * @return A new instance with the given name and datatype
	 */
	public static <T> PropertyName<T> newName(String name, Class<T> datatype) {
		return new PropertyName<T>(name, datatype);
	}

	/**
	 * Factory method to create a new property name with a list datatype.
	 *
	 * @param name        The name
	 * @param elementType The datatype of the list elements
	 * @return A new instance with the given name
	 */
	public static <E> PropertyName<Set<E>> newSetName(String name,
		Class<E> elementType) {
		return new PropertyName<Set<E>>(name, Set.class, elementType);
	}

	/**
	 * Factory method to create a new property name with a string datatype.
	 *
	 * @param name The name
	 * @return A new instance with the given name
	 */
	public static PropertyName<String> newStringName(String name) {
		return newName(name, String.class);
	}

	/**
	 * Returns the instance that has been registered with a certain name.
	 *
	 * @param name The name of the instance
	 * @return The instance with the given name or NULL if no such name has
	 * been
	 * registered
	 */
	public static PropertyName<?> valueOf(String name) {
		return nameRegistry.get(name);
	}

	/**
	 * Returns the class of this property name's datatype.
	 *
	 * @return The datatype class
	 */
	@SuppressWarnings("unchecked")
	public final Class<T> getDatatype() {
		return (Class<T>) datatype;
	}

	/**
	 * Returns the classes of a collection property name's element datatype
	 * or a
	 * maps key and values datatypes.
	 *
	 * @return The element datatype class or classes
	 */
	public final Class<?>[] getElementDatatypes() {
		return elementDatatypes;
	}

	/**
	 * Returns the name of this instance.
	 *
	 * @return The name
	 */
	public final String getName() {
		return name;
	}

	/**
	 * Returns the name of this instance.
	 *
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Returns the instance for the given name.
	 *
	 * @return The resolved property name instance
	 */
	Object readResolve() {
		PropertyName<?> key = nameRegistry.get(name);

		if (key == null) {
			throw new IllegalStateException("Undefined property name: " + name);
		}

		return key;
	}
}
