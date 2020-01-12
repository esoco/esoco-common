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


/********************************************************************
 * A class to define type-safe name constants for properties. The type parameter
 * allows to create type-safe mappings by using the type parameter in the
 * signatures of generic methods. Instances are created through the static
 * factory methods.
 */
public class PropertyName<T> implements Serializable {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	private static Map<String, PropertyName<?>> aNameRegistry =
		new HashMap<String, PropertyName<?>>();

	//~ Instance fields --------------------------------------------------------

	private final String     sName;
	private final Class<?>   rDatatype;
	private final Class<?>[] rElementDatatypes;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Internal constructor to creates a new instance with a certain name and
	 * datatype. Instances must always be created through one of the public
	 * factory methods.
	 *
	 * @param  sName             The name of this instance
	 * @param  rDatatype         The class of the name's datatype
	 * @param  rElementDatatypes The optional datatypes for collection
	 *                           properties
	 *
	 * @throws IllegalArgumentException If the given name has already been used
	 */
	PropertyName(String		 sName,
				 Class<?>    rDatatype,
				 Class<?>... rElementDatatypes) {
		this.sName			   = sName;
		this.rDatatype		   = rDatatype;
		this.rElementDatatypes = rElementDatatypes;

		if (aNameRegistry.containsKey(sName)) {
			throw new IllegalArgumentException(
				"Property name already exists: " +
				sName);
		}

		aNameRegistry.put(sName, this);
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Factory method to create a new property name with a boolean datatype.
	 *
	 * @param  sName The name
	 *
	 * @return A new instance with the given name
	 */
	public static PropertyName<Boolean> newBooleanName(String sName) {
		return newName(sName, Boolean.class);
	}

	/***************************************
	 * Factory method to create a new property name with a boolean datatype.
	 *
	 * @param  sName The name
	 *
	 * @return A new instance with the given name
	 */
	public static PropertyName<Date> newDateName(String sName) {
		return newName(sName, Date.class);
	}

	/***************************************
	 * Factory method to create a new property name with an enum datatype.
	 *
	 * @param  sName      The name
	 * @param  rEnumClass The enum class of the property
	 *
	 * @return A new instance with the given name
	 */
	public static <E extends Enum<E>> PropertyName<E> newEnumName(
		String   sName,
		Class<E> rEnumClass) {
		return newName(sName, rEnumClass);
	}

	/***************************************
	 * Factory method to create a new name with an integer datatype.
	 *
	 * @param  sName The name
	 *
	 * @return A new instance with the given name
	 */
	public static PropertyName<Integer> newIntegerName(String sName) {
		return newName(sName, Integer.class);
	}

	/***************************************
	 * Factory method to create a new property name with a list datatype.
	 *
	 * @param  sName        The name
	 * @param  rElementType The datatype of the list elements
	 *
	 * @return A new instance with the given name
	 */
	public static <E> PropertyName<List<E>> newListName(
		String   sName,
		Class<E> rElementType) {
		return new PropertyName<List<E>>(sName, List.class, rElementType);
	}

	/***************************************
	 * Factory method to create a new property name with a map datatype.
	 *
	 * @param  sName      The name
	 * @param  rKeyType   The datatype of the map keys
	 * @param  rValueType The datatype of the map values
	 *
	 * @return A new instance with the given name
	 */
	public static <K, V> PropertyName<Map<K, V>> newMapName(
		String   sName,
		Class<K> rKeyType,
		Class<V> rValueType) {
		return new PropertyName<Map<K, V>>(
			sName,
			Map.class,
			rKeyType,
			rValueType);
	}

	/***************************************
	 * Factory method to create a new property name with a certain datatype.
	 *
	 * @param  sName     The name
	 * @param  rDatatype The class of the datatype
	 *
	 * @return A new instance with the given name and datatype
	 */
	public static <T> PropertyName<T> newName(
		String   sName,
		Class<T> rDatatype) {
		return new PropertyName<T>(sName, rDatatype);
	}

	/***************************************
	 * Factory method to create a new property name with a list datatype.
	 *
	 * @param  sName        The name
	 * @param  rElementType The datatype of the list elements
	 *
	 * @return A new instance with the given name
	 */
	public static <E> PropertyName<Set<E>> newSetName(
		String   sName,
		Class<E> rElementType) {
		return new PropertyName<Set<E>>(sName, Set.class, rElementType);
	}

	/***************************************
	 * Factory method to create a new property name with a string datatype.
	 *
	 * @param  sName The name
	 *
	 * @return A new instance with the given name
	 */
	public static PropertyName<String> newStringName(String sName) {
		return newName(sName, String.class);
	}

	/***************************************
	 * Returns the instance that has been registered with a certain name.
	 *
	 * @param  sName The name of the instance
	 *
	 * @return The instance with the given name or NULL if no such name has been
	 *         registered
	 */
	public static PropertyName<?> valueOf(String sName) {
		return aNameRegistry.get(sName);
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the class of this property name's datatype.
	 *
	 * @return The datatype class
	 */
	@SuppressWarnings("unchecked")
	public final Class<T> getDatatype() {
		return (Class<T>) rDatatype;
	}

	/***************************************
	 * Returns the classes of a collection property name's element datatype or a
	 * maps key and values datatypes.
	 *
	 * @return The element datatype class or classes
	 */
	public final Class<?>[] getElementDatatypes() {
		return rElementDatatypes;
	}

	/***************************************
	 * Returns the name of this instance.
	 *
	 * @return The name
	 */
	public final String getName() {
		return sName;
	}

	/***************************************
	 * Returns the name of this instance.
	 *
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return sName;
	}

	/***************************************
	 * Returns the instance for the given name.
	 *
	 * @return The resolved property name instance
	 */
	Object readResolve() {
		PropertyName<?> rKey = aNameRegistry.get(sName);

		if (rKey == null) {
			throw new IllegalStateException(
				"Undefined property name: " +
				sName);
		}

		return rKey;
	}
}
