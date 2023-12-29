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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Set;

import static de.esoco.lib.text.TextConvert.DEFAULT_COLLECTION_SEPARATOR;
import static de.esoco.lib.text.TextConvert.DEFAULT_KEY_VALUE_SEPARATOR;
import static de.esoco.lib.text.TextConvert.unicodeDecode;
import static de.esoco.lib.text.TextConvert.unicodeEncode;

/**
 * A base class for classes that provide access to string-based properties. A
 * directly usable implementation that provides mutable properties can be found
 * in the class {@link StringProperties}.
 *
 * <p>
 * The internal property map of the base implementation will initially be NULL
 * to save space for empty property objects. Subclasses must handle the case of
 * a NULL map returned by {@link #getPropertyMap()} appropriately and may
 * explicitly set the map to NULL (through {@link #setPropertyMap(Map)} to
 * indicate an empty map. The method {@link #ensurePropertyMapExists()} can be
 * invoked to force the creation of a property map before accessing it.
 * </p>
 *
 * @author eso
 */
public abstract class AbstractStringProperties
	implements HasProperties, Serializable {

	// ~ Static fields/initializers
	// ---------------------------------------------

	private static final long serialVersionUID = 1L;

	// ~ Instance fields
	// --------------------------------------------------------

	private Map<PropertyName<?>, String> propertyMap = null;

	// ~ Methods
	// ----------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		return obj != null && getClass() == obj.getClass() &&
			hasEqualProperties((AbstractStringProperties) obj);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getIntProperty(PropertyName<Integer> name, int defaultValue) {
		String property = getRawProperty(name);

		return property != null ? Integer.parseInt(property) : defaultValue;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public <T> T getProperty(PropertyName<T> name, T defaultValue) {
		String rawValue = getRawProperty(name);
		T value = defaultValue;

		if (rawValue != null) {
			value = parseValue(rawValue, name.getDatatype(),
				name.getElementDatatypes());
		}

		return value;
	}

	/**
	 * @see MutableProperties#getPropertyCount()
	 */
	@Override
	public int getPropertyCount() {
		return propertyMap != null ? propertyMap.size() : 0;
	}

	/**
	 * @see MutableProperties#getPropertyNames()
	 */
	@Override
	public Collection<PropertyName<?>> getPropertyNames() {
		return propertyMap != null ?
		       propertyMap.keySet() :
		       Collections.emptySet();
	}

	/**
	 * Checks whether this instance has equal properties as another instance.
	 *
	 * @param other The other properties object
	 * @return TRUE if the properties are equal
	 */
	public boolean hasEqualProperties(AbstractStringProperties other) {
		return Objects.equals(propertyMap, other.propertyMap);
	}

	/**
	 * @see MutableProperties#hasFlag(PropertyName)
	 */
	@Override
	public boolean hasFlag(PropertyName<Boolean> name) {
		String property = getRawProperty(name);

		return Boolean.parseBoolean(property);
	}

	/**
	 * @see MutableProperties#hasProperty(PropertyName)
	 */
	@Override
	public boolean hasProperty(PropertyName<?> name) {
		return propertyMap != null && propertyMap.containsKey(name);
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 37 + ((propertyMap == null) ? 0 : propertyMap.hashCode());
	}

	/**
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() +
			(propertyMap != null ? propertyMap : "[]");
	}

	/**
	 * Converts a collection into a string to be stored in this instance.
	 *
	 * @param collection The collection to convert
	 * @return The resulting string
	 */
	protected String convertCollection(Collection<?> collection) {
		StringBuilder result = new StringBuilder();

		for (Object value : collection) {
			String element = convertValue(value);

			result.append(unicodeEncode(element,
				DEFAULT_COLLECTION_SEPARATOR));
			result.append(DEFAULT_COLLECTION_SEPARATOR);
		}

		int resultLength = result.length();

		if (resultLength > 0) {
			result.setLength(resultLength - 1);
		}

		return result.toString();
	}

	/**
	 * Converts a map into a string to be stored in this instance.
	 *
	 * @param map The map to convert
	 * @return The resulting string
	 */
	protected String convertMap(Map<?, ?> map) {
		StringBuilder result = new StringBuilder();

		if (map.size() > 0) {
			for (Entry<?, ?> entry : map.entrySet()) {
				String key = convertValue(entry.getKey());
				String value = convertValue(entry.getValue());

				assert key.indexOf(DEFAULT_COLLECTION_SEPARATOR) < 0 &&
					key.indexOf(DEFAULT_KEY_VALUE_SEPARATOR) < 0;

				result.append(key);
				result.append(DEFAULT_KEY_VALUE_SEPARATOR);
				result.append(
					unicodeEncode(value, DEFAULT_COLLECTION_SEPARATOR));
				result.append(DEFAULT_COLLECTION_SEPARATOR);
			}

			result.setLength(
				result.length() - DEFAULT_COLLECTION_SEPARATOR.length());
		}

		return result.toString();
	}

	/**
	 * Converts a value into a string to be stored in this instance.
	 *
	 * @param value The value to convert
	 * @return The resulting string
	 */
	protected String convertValue(Object value) {
		if (value instanceof Date) {
			return Long.toString(((Date) value).getTime());
		} else if (value instanceof Collection) {
			return convertCollection(((Collection<?>) value));
		} else if (value instanceof Map) {
			return convertMap(((Map<?, ?>) value));
		} else {
			return value.toString();
		}
	}

	/**
	 * Creates the property map if it doesn't exist yet.
	 */
	protected final void ensurePropertyMapExists() {
		if (propertyMap == null) {
			propertyMap = new HashMap<PropertyName<?>, String>();
		}
	}

	/**
	 * Finds a certain value by it's string representation.
	 *
	 * @param values The values to search
	 * @param name   The value's name (i.e. Object{@link #toString()}
	 *                 result) to
	 *               search for
	 * @return The matching value or NULL if not found
	 */
	protected <T> T findValue(T[] values, String name) {
		for (T value : values) {
			if (value.toString().equals(name)) {
				return value;
			}
		}

		return null;
	}

	/**
	 * Returns the property map of this instance. The returned value may be
	 * NULL
	 * if no properties have been set in this instance. Invoking method must
	 * handle this case accordingly.
	 *
	 * @return The property map or NULL for none
	 */
	protected final Map<PropertyName<?>, String> getPropertyMap() {
		return propertyMap;
	}

	/**
	 * Parses the elements of a collection from the raw property string.
	 *
	 * @param collectionType The type of collection to parse
	 * @param rawElements    The raw string containing all list elements
	 * @param elementType    The datatype of the collection elements
	 * @return A new collection of the given type containing the parsed entries
	 */
	@SuppressWarnings("unchecked")
	protected <T, C extends Collection<T>> C parseCollection(
		Class<C> collectionType, String rawElements, Class<T> elementType) {
		String[] elements = rawElements.split(DEFAULT_COLLECTION_SEPARATOR);
		C collection;

		if (List.class.isAssignableFrom(collectionType)) {
			collection = (C) new ArrayList<T>();
		} else {
			collection = (C) new HashSet<T>();
		}

		for (int i = 0; i < elements.length; i++) {
			String value =
				unicodeDecode(elements[i], DEFAULT_COLLECTION_SEPARATOR);

			collection.add(parseValue(value, elementType, null));
		}

		return collection;
	}

	/**
	 * Parses the entries of a map from a raw string.
	 *
	 * @param rawEntries The raw string containing all map entries
	 * @param keyType    The key datatype
	 * @param valueType  The value datatype
	 * @return A new map containing the parsed entries
	 */
	protected <K, V> Map<K, V> parseMap(String rawEntries, Class<K> keyType,
		Class<V> valueType) {
		Map<K, V> map = new HashMap<>();
		String[] entries = rawEntries.split(DEFAULT_COLLECTION_SEPARATOR);

		for (String entry : entries) {
			int keyEnd = entry.indexOf(DEFAULT_KEY_VALUE_SEPARATOR);

			if (keyEnd > 0) {
				String key = entry.substring(0, keyEnd);

				String value = entry.substring(
					keyEnd + DEFAULT_KEY_VALUE_SEPARATOR.length());

				value = unicodeDecode(value, DEFAULT_COLLECTION_SEPARATOR);

				map.put(parseValue(key, keyType, null),
					parseValue(value, valueType, null));
			}
		}

		return map;
	}

	/**
	 * Parses a raw string value into a certain datatype if possible.
	 *
	 * @param rawValue     The raw string value
	 * @param datatype     The target datatype
	 * @param elementTypes The element datatype(s) for collection properties or
	 *                     NULL for none
	 * @return The parsed valued object
	 */
	@SuppressWarnings("unchecked")
	protected <T, E> T parseValue(String rawValue, Class<T> datatype,
		Class<?>[] elementTypes) {
		T value = null;

		if (datatype == String.class) {
			value = (T) rawValue;
		} else if (datatype.isEnum()) {
			value = findValue(datatype.getEnumConstants(), rawValue);
		} else if (datatype == Date.class) {
			value = (T) new Date(Long.parseLong(rawValue));
		} else if (datatype == Long.class) {
			value = (T) Long.valueOf(rawValue);
		} else if (datatype == Integer.class) {
			value = (T) Integer.valueOf(rawValue);
		} else if (datatype == Boolean.class) {
			value = (T) Boolean.valueOf(rawValue);
		} else if (datatype == Color.class) {
			value = (T) Color.valueOf(rawValue);
		} else if (datatype == List.class || datatype == Set.class) {
			Class<E> elementType = (Class<E>) elementTypes[0];

			value =
				(T) parseCollection((Class<? extends Collection<E>>) datatype,
					rawValue, elementType);
		} else if (datatype == Map.class) {
			value = (T) parseMap(rawValue, elementTypes[0], elementTypes[1]);
		}

		return value;
	}

	/**
	 * Default implementation of
	 * {@link MutableProperties#removeProperty(PropertyName)}.
	 *
	 * @param name The property to remove
	 */
	protected void removeProperty(PropertyName<?> name) {
		Map<PropertyName<?>, String> propertyMap = getPropertyMap();

		if (propertyMap != null) {
			propertyMap.remove(name);

			if (propertyMap.isEmpty()) {
				setPropertyMap(null);
			}
		}
	}

	/**
	 * Default implementation of
	 * {@link MutableProperties#setProperty(PropertyName, Object)}. Creates the
	 * property map if necessary and removes properties if the value is NULL.
	 *
	 * @param name  The property to set or remove
	 * @param value The property value or NULL to remove
	 */
	protected <T> void setProperty(PropertyName<T> name, T value) {
		if (value != null) {
			ensurePropertyMapExists();
			getPropertyMap().put(name, convertValue(value));
		} else {
			removeProperty(name);
		}
	}

	/**
	 * Sets the property map of this instance.
	 *
	 * @param properties The new property map
	 */
	protected final void setPropertyMap(
		Map<PropertyName<?>, String> properties) {
		propertyMap = properties;
	}

	/**
	 * Returns the unparsed (raw) value of a property as a string.
	 *
	 * @param name The name of the property
	 * @return The string property value or the defaultValue value
	 */
	private final String getRawProperty(PropertyName<?> name) {
		return propertyMap != null ? propertyMap.get(name) : null;
	}
}
