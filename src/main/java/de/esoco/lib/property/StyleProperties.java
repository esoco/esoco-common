//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// esoco-common source file
// Copyright (c) 2016 by Elmar Sonnenschein / esoco GmbH
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package de.esoco.lib.property;

import java.util.Map;


/********************************************************************
 * Defines typical style {@link PropertyName Properties}.
 *
 * @author eso
 */
public interface StyleProperties
{
	//~ Static fields/initializers ---------------------------------------------

	/** Integer: the number of rows to display in a table. */
	public static final PropertyName<Integer> TABLE_ROWS =
		PropertyName.newIntegerName("TABLE_ROWS");

	/** Integer: the minimum number of characters to display. */
	public static final PropertyName<Integer> MIN_CHARS =
		PropertyName.newIntegerName("MIN_CHARS");

	/** Integer: the maximum number of characters to display. */
	public static final PropertyName<Integer> MAX_CHARS =
		PropertyName.newIntegerName("MAX_CHARS");

	/**
	 * String: a list of disabled elements, e.g. of buttons in a list with
	 * discrete or immediate style.
	 */
	public static final PropertyName<String> DISABLED_ELEMENTS =
		PropertyName.newStringName("DISABLED_ELEMENTS");

	/**
	 * Boolean: TRUE for an element that has a vertical orientation instead of
	 * horizontal.
	 */
	public static final PropertyName<Boolean> VERTICAL =
		PropertyName.newBooleanName("VERTICAL");

	/** Boolean: TRUE for the hierarchical display of data. */
	public static final PropertyName<Boolean> HIERARCHICAL =
		PropertyName.newBooleanName("HIERARCHICAL");

	/** Boolean: TRUE to hide the label when displaying the element. */
	public static final PropertyName<Boolean> HIDE_LABEL =
		PropertyName.newBooleanName("HIDE_LABEL");

	/**
	 * Boolean: TRUE to display the label of an element as a header instead of a
	 * prefix.
	 */
	public static final PropertyName<Boolean> HEADER_LABEL =
		PropertyName.newBooleanName("HEADER_LABEL");

	/** Boolean: TRUE to wrap data or sub-elements in an element. */
	public static final PropertyName<Boolean> WRAP =
		PropertyName.newBooleanName("WRAP");

	/** Boolean: TRUE to disabled the wrapping in an element. */
	public static final PropertyName<Boolean> NO_WRAP =
		PropertyName.newBooleanName("NO_WRAP");

	/** Boolean: TRUE to mark an element as editable. */
	public static final PropertyName<Boolean> EDITABLE =
		PropertyName.newBooleanName("EDITABLE");

	/** Boolean: TRUE to mark an element as searchable. */
	public static final PropertyName<Boolean> SEARCHABLE =
		PropertyName.newBooleanName("SEARCHABLE");

	/** Boolean: TRUE to mark an element as sortable. */
	public static final PropertyName<Boolean> SORTABLE =
		PropertyName.newBooleanName("SORTABLE");

	/** Boolean: TRUE to mark an element as executable. */
	public static final PropertyName<Boolean> EXECUTABLE =
		PropertyName.newBooleanName("EXECUTABLE");

	/** Boolean: indicates that the values of an element should be sorted. */
	public static final PropertyName<Boolean> SORT =
		PropertyName.newBooleanName("SORT");

	/**
	 * Boolean: marks a user interface element to be rendered with image if
	 * applicable.
	 */
	public static final PropertyName<Boolean> HAS_IMAGES =
		PropertyName.newBooleanName("HAS_IMAGES");

	/** String: an application-specific style string (e.g. a CSS class name). */
	public static final PropertyName<String> STYLE =
		PropertyName.newStringName("STYLE");

	/** A map property that contains CSS styles and their values. */
	public static final PropertyName<Map<String, String>> CSS_STYLES =
		PropertyName.newMapName("CSS_STYLES", String.class, String.class);

	/**
	 * Enum: the type in which buttons created from a data element should be
	 * displayed.
	 */
	public static final PropertyName<ButtonStyle> BUTTON_STYLE =
		PropertyName.newEnumName("BUTTON_STYLE", ButtonStyle.class);

	/**
	 * Enum: the style in which a readonly text data element should be
	 * displayed.
	 */
	public static final PropertyName<LabelStyle> LABEL_STYLE =
		PropertyName.newEnumName("LABEL_STYLE", LabelStyle.class);

	/** Enum: the type in which a list data element should be displayed. */
	public static final PropertyName<ListStyle> LIST_STYLE =
		PropertyName.newEnumName("LIST_STYLE", ListStyle.class);

	/** Integer: the RGB background color of an element. */
	public static final PropertyName<Integer> BACKGROUND_COLOR =
		PropertyName.newIntegerName("BACKGROUND_COLOR");

	/** Integer: the RGB foreground color of an element. */
	public static final PropertyName<Integer> FOREGROUND_COLOR =
		PropertyName.newIntegerName("FOREGROUND_COLOR");

	/** Enum: The scaling of an {@link ContentProperties#ICON}. */
	PropertyName<RelativeScale> ICON_SIZE =
		PropertyName.newEnumName("ICON_SIZE", RelativeScale.class);

	/** Integer: the RGB icon color of an {@link ContentProperties#ICON}. */
	PropertyName<Integer> ICON_COLOR =
		PropertyName.newIntegerName("ICON_COLOR");

	/** Integer: the alignment of an {@link ContentProperties#ICON} within it's container. */
	PropertyName<Alignment> ICON_ALIGNMENT =
		PropertyName.newEnumName("ICON_ALIGNMENT", Alignment.class);
}
