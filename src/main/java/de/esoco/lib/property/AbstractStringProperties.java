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


/********************************************************************
 * A base class for classes that provide access to string-based properties. A
 * directly usable implementation that provides mutable properties can be found
 * in the class {@link StringProperties}.
 *
 * <p>The internal property map of the base implementation will initially be
 * NULL to save space for empty property objects. Subclasses must handle the
 * case of a NULL map returned by {@link #getPropertyMap()} appropriately and
 * may explicitly set the map to NULL (through {@link #setPropertyMap(Map)} to
 * indicate an empty map. The method {@link #ensurePropertyMapExists()} can be
 * invoked to force the creation of a property map before accessing it.</p>
 *
 * @author eso
 */
public abstract class AbstractStringProperties implements HasProperties,
														  Serializable {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	//~ Instance fields --------------------------------------------------------

	private Map<PropertyName<?>, String> aPropertyMap = null;

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public boolean equals(Object rObj) {
		if (this == rObj) {
			return true;
		}

		return rObj != null && getClass() == rObj.getClass() &&
			   hasEqualProperties((AbstractStringProperties) rObj);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public int getIntProperty(PropertyName<Integer> rName, int nDefault) {
		String sProperty = getRawProperty(rName);

		return sProperty != null ? Integer.parseInt(sProperty) : nDefault;
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <T> T getProperty(PropertyName<T> rName, T rDefault) {
		String sRawValue = getRawProperty(rName);
		T	   rValue    = rDefault;

		if (sRawValue != null) {
			rValue =
				parseValue(
					sRawValue,
					rName.getDatatype(),
					rName.getElementDatatypes());
		}

		return rValue;
	}

	/***************************************
	 * @see MutableProperties#getPropertyCount()
	 */
	@Override
	public int getPropertyCount() {
		return aPropertyMap != null ? aPropertyMap.size() : 0;
	}

	/***************************************
	 * @see MutableProperties#getPropertyNames()
	 */
	@Override
	public Collection<PropertyName<?>> getPropertyNames() {
		return aPropertyMap != null ? aPropertyMap.keySet()
									: Collections.<PropertyName<?>>emptySet();
	}

	/***************************************
	 * Checks whether this instance has equal properties as another instance.
	 *
	 * @param  rOther The other properties object
	 *
	 * @return TRUE if the properties are equal
	 */
	public boolean hasEqualProperties(AbstractStringProperties rOther) {
		return Objects.equals(aPropertyMap, rOther.aPropertyMap);
	}

	/***************************************
	 * @see MutableProperties#hasFlag(PropertyName)
	 */
	@Override
	public boolean hasFlag(PropertyName<Boolean> rName) {
		String sProperty = getRawProperty(rName);

		return sProperty != null ? Boolean.parseBoolean(sProperty) : false;
	}

	/***************************************
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return 37 + ((aPropertyMap == null) ? 0 : aPropertyMap.hashCode());
	}

	/***************************************
	 * @see MutableProperties#hasProperty(PropertyName)
	 */
	@Override
	public boolean hasProperty(PropertyName<?> rName) {
		return aPropertyMap != null && aPropertyMap.containsKey(rName);
	}

	/***************************************
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() +
			   (aPropertyMap != null ? aPropertyMap : "[]");
	}

	/***************************************
	 * Converts a collection into a string to be stored in this instance.
	 *
	 * @param  rCollection The collection to convert
	 *
	 * @return The resulting string
	 */
	protected String convertCollection(Collection<?> rCollection) {
		StringBuilder aResult = new StringBuilder();

		for (Object rElement : rCollection) {
			String sElement = convertValue(rElement);

			aResult.append(
				unicodeEncode(sElement, DEFAULT_COLLECTION_SEPARATOR));
			aResult.append(DEFAULT_COLLECTION_SEPARATOR);
		}

		int nResultLength = aResult.length();

		if (nResultLength > 0) {
			aResult.setLength(nResultLength - 1);
		}

		return aResult.toString();
	}

	/***************************************
	 * Converts a map into a string to be stored in this instance.
	 *
	 * @param  rMap The map to convert
	 *
	 * @return The resulting string
	 */
	protected String convertMap(Map<?, ?> rMap) {
		StringBuilder aResult = new StringBuilder();

		if (rMap.size() > 0) {
			for (Entry<?, ?> rEntry : rMap.entrySet()) {
				String sKey   = convertValue(rEntry.getKey());
				String sValue = convertValue(rEntry.getValue());

				assert sKey.indexOf(DEFAULT_COLLECTION_SEPARATOR) < 0 &&
					   sKey.indexOf(DEFAULT_KEY_VALUE_SEPARATOR) < 0;

				aResult.append(sKey);
				aResult.append(DEFAULT_KEY_VALUE_SEPARATOR);
				aResult.append(
					unicodeEncode(sValue, DEFAULT_COLLECTION_SEPARATOR));
				aResult.append(DEFAULT_COLLECTION_SEPARATOR);
			}

			aResult.setLength(
				aResult.length() - DEFAULT_COLLECTION_SEPARATOR.length());
		}

		return aResult.toString();
	}

	/***************************************
	 * Converts a value into a string to be stored in this instance.
	 *
	 * @param  rValue The value to convert
	 *
	 * @return The resulting string
	 */
	protected String convertValue(Object rValue) {
		String sValue;

		if (rValue instanceof Date) {
			sValue = Long.toString(((Date) rValue).getTime());
		} else if (rValue instanceof Collection) {
			sValue = convertCollection(((Collection<?>) rValue));
		} else if (rValue instanceof Map) {
			sValue = convertMap(((Map<?, ?>) rValue));
		} else {
			sValue = rValue.toString();
		}

		return sValue;
	}

	/***************************************
	 * Creates the property map if it doesn't exist yet.
	 */
	protected final void ensurePropertyMapExists() {
		if (aPropertyMap == null) {
			aPropertyMap = new HashMap<PropertyName<?>, String>();
		}
	}

	/***************************************
	 * Finds a certain value by it's string representation.
	 *
	 * @param  rValues The values to search
	 * @param  sName   The value's name (i.e. Object{@link #toString()} result)
	 *                 to search for
	 *
	 * @return The matching value or NULL if not found
	 */
	protected <T> T findValue(T[] rValues, String sName) {
		for (T rValue : rValues) {
			if (rValue.toString().equals(sName)) {
				return rValue;
			}
		}

		return null;
	}

	/***************************************
	 * Returns the property map of this instance. The returned value may be NULL
	 * if no properties have been set in this instance. Invoking method must
	 * handle this case accordingly.
	 *
	 * @return The property map or NULL for none
	 */
	protected final Map<PropertyName<?>, String> getPropertyMap() {
		return aPropertyMap;
	}

	/***************************************
	 * Parses the elements of a collection from the raw property string.
	 *
	 * @param  rCollectionType The type of collection to parse
	 * @param  sRawElements    The raw string containing all list elements
	 * @param  rElementType    The datatype of the collection elements
	 *
	 * @return A new collection of the given type containing the parsed entries
	 */
	@SuppressWarnings("unchecked")
	protected <T, C extends Collection<T>> C parseCollection(
		Class<C> rCollectionType,
		String   sRawElements,
		Class<T> rElementType) {
		String[] rElements   = sRawElements.split(DEFAULT_COLLECTION_SEPARATOR);
		C		 rCollection;

		if (rCollectionType == (Class<?>) List.class) {
			rCollection = (C) new ArrayList<T>();
		} else {
			rCollection = (C) new HashSet<T>();
		}

		for (int i = 0; i < rElements.length; i++) {
			String sValue =
				unicodeDecode(rElements[i], DEFAULT_COLLECTION_SEPARATOR);

			rCollection.add(parseValue(sValue, rElementType, null));
		}

		return rCollection;
	}

	/***************************************
	 * Parses the entries of a map from a raw string.
	 *
	 * @param  sRawEntries The raw string containing all map entries
	 * @param  rKeyType    The key datatype
	 * @param  rValueType  The value datatype
	 *
	 * @return A new map containing the parsed entries
	 */
	protected <K, V> Map<K, V> parseMap(String   sRawEntries,
										Class<K> rKeyType,
										Class<V> rValueType) {
		Map<K, V> aMap     = new HashMap<>();
		String[]  rEntries = sRawEntries.split(DEFAULT_COLLECTION_SEPARATOR);

		for (String sEntry : rEntries) {
			int nKeyEnd = sEntry.indexOf(DEFAULT_KEY_VALUE_SEPARATOR);

			if (nKeyEnd > 0) {
				String sKey = sEntry.substring(0, nKeyEnd);

				String sValue =
					sEntry.substring(
						nKeyEnd + DEFAULT_KEY_VALUE_SEPARATOR.length());

				sValue = unicodeDecode(sValue, DEFAULT_COLLECTION_SEPARATOR);

				aMap.put(
					parseValue(sKey, rKeyType, null),
					parseValue(sValue, rValueType, null));
			}
		}

		return aMap;
	}

	/***************************************
	 * Parses a raw string value into a certain datatype if possible.
	 *
	 * @param  sRawValue     The raw string value
	 * @param  rDatatype     The target datatype
	 * @param  rElementTypes The element datatype(s) for collection properties
	 *                       or NULL for none
	 *
	 * @return The parsed valued object
	 */
	@SuppressWarnings("unchecked")
	protected <T, E> T parseValue(String	 sRawValue,
								  Class<T>   rDatatype,
								  Class<?>[] rElementTypes) {
		T rValue = null;

		if (rDatatype == String.class) {
			rValue = (T) sRawValue;
		} else if (rDatatype.isEnum()) {
			rValue = findValue(rDatatype.getEnumConstants(), sRawValue);
		} else if (rDatatype == Date.class) {
			rValue = (T) new Date(Long.parseLong(sRawValue));
		} else if (rDatatype == Long.class) {
			rValue = (T) Long.valueOf(sRawValue);
		} else if (rDatatype == Integer.class) {
			rValue = (T) Integer.valueOf(sRawValue);
		} else if (rDatatype == Boolean.class) {
			rValue = (T) Boolean.valueOf(sRawValue);
		} else if (rDatatype == Color.class) {
			rValue = (T) Color.valueOf(sRawValue);
		} else if (rDatatype == List.class || rDatatype == Set.class) {
			Class<E> rElementType = (Class<E>) rElementTypes[0];

			rValue =
				(T) parseCollection(
					(Class<? extends Collection<E>>) rDatatype,
					sRawValue,
					rElementType);
		} else if (rDatatype == Map.class) {
			rValue =
				(T) parseMap(sRawValue, rElementTypes[0], rElementTypes[1]);
		}

		return rValue;
	}

	/***************************************
	 * Default implementation of {@link
	 * MutableProperties#removeProperty(PropertyName)}.
	 *
	 * @param rName The property to remove
	 */
	protected void removeProperty(PropertyName<?> rName) {
		Map<PropertyName<?>, String> rPropertyMap = getPropertyMap();

		if (rPropertyMap != null) {
			rPropertyMap.remove(rName);

			if (rPropertyMap.isEmpty()) {
				setPropertyMap(null);
			}
		}
	}

	/***************************************
	 * Default implementation of {@link
	 * MutableProperties#setProperty(PropertyName, Object)}. Creates the
	 * property map if necessary and removes properties if the value is NULL.
	 *
	 * @param rName  The property to set or remove
	 * @param rValue The property value or NULL to remove
	 */
	protected <T> void setProperty(PropertyName<T> rName, T rValue) {
		if (rValue != null) {
			ensurePropertyMapExists();
			getPropertyMap().put(rName, convertValue(rValue));
		} else {
			removeProperty(rName);
		}
	}

	/***************************************
	 * Sets the property map of this instance.
	 *
	 * @param rProperties The new property map
	 */
	protected final void setPropertyMap(
		Map<PropertyName<?>, String> rProperties) {
		aPropertyMap = rProperties;
	}

	/***************************************
	 * Returns the unparsed (raw) value of a property as a string.
	 *
	 * @param  rName The name of the property
	 *
	 * @return The string property value or the default value
	 */
	private final String getRawProperty(PropertyName<?> rName) {
		return aPropertyMap != null ? aPropertyMap.get(rName) : null;
	}
}
