//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// esoco-common source file
// Copyright (c) 2016 by Elmar Sonnenschein / esoco GmbH
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package de.esoco.lib.property;

/********************************************************************
 * Defines typical content {@link PropertyName Properties}.
 *
 * @author eso
 */
public interface ContentProperties
{
	//~ Static fields/initializers ---------------------------------------------

	/**
	 * Boolean: TRUE to indicate that an element contains a resource. This
	 * typically means that the element must expand text before displaying it.
	 */
	public static final PropertyName<Boolean> RESOURCE =
		PropertyName.newBooleanName("RESOURCE");

	/** String: a resource ID for the target object. */
	public static final PropertyName<String> RESOURCE_ID =
		PropertyName.newStringName("RESOURCE_ID");

	/** String: a descriptive label string for the target object. */
	public static final PropertyName<String> LABEL =
		PropertyName.newStringName("LABEL");

	/** String: the tooltip to be displayed for the target object. */
	public static final PropertyName<String> TOOLTIP =
		PropertyName.newStringName("TOOLTIP");

	/** String: a placeholder to be displayed for empty objects. */
	public static final PropertyName<String> PLACEHOLDER =
		PropertyName.newStringName("PLACEHOLDER");

	/** String: a URL that affects the appearance or function of an element. */
	public static final PropertyName<String> URL =
		PropertyName.newStringName("URL");

	/**
	 * String: an format definition. The value depends on the target value to
	 * format and the available formatting options on the client.
	 */
	public static final PropertyName<String> FORMAT =
		PropertyName.newStringName("FORMAT");

	/** String: an input constraint, typically a regular expression. */
	public static final PropertyName<String> INPUT_CONSTRAINT =
		PropertyName.newStringName("INPUT_CONSTRAINT");

	/** String: a comma-separated list of allowed values. */
	public static final PropertyName<String> ALLOWED_VALUES =
		PropertyName.newStringName("ALLOWED_VALUES");

	/** String: a resource prefix for values. */
	public static final PropertyName<String> VALUE_RESOURCE_PREFIX =
		PropertyName.newStringName("VALUE_RESOURCE_PREFIX");

	/** Boolean: TRUE to suppress an automatically generated resource prefix. */
	public static final PropertyName<Boolean> NO_RESOURCE_PREFIX =
		PropertyName.newBooleanName("NO_RESOURCE_PREFIX");

	/** Enum: defines the type of an event notification. */
	public static final PropertyName<NotificationType> NOTIFICATION_TYPE =
		PropertyName.newEnumName("NOTIFICATION_TYPE", NotificationType.class);

	/** Enum: The type of content stored by an element. */
	public static final PropertyName<ContentType> CONTENT_TYPE =
		PropertyName.newEnumName("CONTENT_TYPE", ContentType.class);

	/** String: The MIME type of the content stored by an element. */
	public static final PropertyName<String> MIME_TYPE =
		PropertyName.newStringName("MIME_TYPE");

	/**
	 * String: The name of an icon that should be displayed for the target
	 * object.
	 */
	public static final PropertyName<String> ICON =
		PropertyName.newStringName("ICON");

	/** Enum: The scaling of an {@link #ICON}. */
	public static final PropertyName<RelativeScale> ICON_SIZE =
		PropertyName.newEnumName("ICON_SIZE", RelativeScale.class);

	/** Integer: the RGB icon color of an {@link #ICON}. */
	public static final PropertyName<Integer> ICON_COLOR =
		PropertyName.newIntegerName("ICON_COLOR");

	/** Integer: the alignment of an {@link #ICON} within it's container. */
	public static final PropertyName<Alignment> ICON_ALIGNMENT =
		PropertyName.newEnumName("ICON_ALIGNMENT", Alignment.class);
}
