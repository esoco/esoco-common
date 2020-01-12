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

import java.util.List;

import static de.esoco.lib.property.PropertyName.newBooleanName;
import static de.esoco.lib.property.PropertyName.newEnumName;
import static de.esoco.lib.property.PropertyName.newListName;
import static de.esoco.lib.property.PropertyName.newStringName;


/********************************************************************
 * Defines typical content {@link PropertyName Properties}.
 *
 * @author eso
 */
public interface ContentProperties {

	//~ Static fields/initializers ---------------------------------------------

	/**
	 * String: an identifier for the target object (e.g. an HTML element ID).
	 */
	public static final PropertyName<String> ELEMENT_ID =
		newStringName("ELEMENT_ID");

	/**
	 * Boolean: TRUE to indicate that an element contains a resource. This
	 * typically means that the element must expand text before displaying it.
	 */
	public static final PropertyName<Boolean> RESOURCE =
		newBooleanName("RESOURCE");

	/** String: a resource ID for the target object. */
	public static final PropertyName<String> RESOURCE_ID =
		newStringName("RESOURCE_ID");

	/** String: a descriptive label string for the target object. */
	public static final PropertyName<String> LABEL = newStringName("LABEL");

	/** String: the tooltip to be displayed for the target object. */
	public static final PropertyName<String> TOOLTIP = newStringName("TOOLTIP");

	/** String: a placeholder to be displayed for empty objects. */
	public static final PropertyName<String> PLACEHOLDER =
		newStringName("PLACEHOLDER");

	/** String: a URL that affects the appearance or function of an element. */
	public static final PropertyName<String> URL = newStringName("URL");

	/** String: a file name. */
	public static final PropertyName<String> FILE_NAME =
		newStringName("FILE_NAME");

	/**
	 * String: an format definition. The value depends on the target value to
	 * format and the available formatting options on the client.
	 */
	public static final PropertyName<String> FORMAT = newStringName("FORMAT");

	/**
	 * String list: the arguments to be handed to a format string, similar to
	 * <code>String.format()</code>, but limited to string values.
	 */
	public static final PropertyName<List<String>> FORMAT_ARGUMENTS =
		newListName("FORMAT_ARGUMENTS", String.class);

	/** String: an input constraint, typically a regular expression. */
	public static final PropertyName<String> INPUT_CONSTRAINT =
		newStringName("INPUT_CONSTRAINT");

	/** String: a descriptive string to be used to render NULL values. */
	public static final PropertyName<String> NULL_VALUE =
		newStringName("NULL_VALUE");

	/** String: a comma-separated list of allowed values. */
	public static final PropertyName<String> ALLOWED_VALUES =
		newStringName("ALLOWED_VALUES");

	/** String: a resource prefix for values. */
	public static final PropertyName<String> VALUE_RESOURCE_PREFIX =
		newStringName("VALUE_RESOURCE_PREFIX");

	/** Boolean: TRUE to suppress an automatically generated resource prefix. */
	public static final PropertyName<Boolean> NO_RESOURCE_PREFIX =
		newBooleanName("NO_RESOURCE_PREFIX");

	/** Enum: defines the type of an event notification. */
	public static final PropertyName<NotificationType> NOTIFICATION_TYPE =
		newEnumName("NOTIFICATION_TYPE", NotificationType.class);

	/** Enum: The type of content stored by an element. */
	public static final PropertyName<ContentType> CONTENT_TYPE =
		newEnumName("CONTENT_TYPE", ContentType.class);

	/** String: The MIME type of the content stored by an element. */
	public static final PropertyName<String> MIME_TYPE =
		newStringName("MIME_TYPE");

	/**
	 * String: The URI of an image that should be displayed in the target
	 * object.
	 */
	public static final PropertyName<String> IMAGE = newStringName("IMAGE");

	/**
	 * String: The name of an icon that should be displayed in the target
	 * object.
	 */
	public static final PropertyName<String> ICON = newStringName("ICON");
}
