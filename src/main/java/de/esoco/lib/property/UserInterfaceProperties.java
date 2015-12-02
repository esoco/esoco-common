//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2015 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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

/********************************************************************
 * A collection of {@link PropertyName} constants for typical user interface
 * properties.
 *
 * @author eso
 */
public class UserInterfaceProperties
{
	//~ Enums ------------------------------------------------------------------

	/********************************************************************
	 * An enumeration of event notification types.
	 */
	public enum NotificationType { MESSAGE, POPUP, MODAL_POPUP, DIALOG }

	/********************************************************************
	 * An indication of the type of content stored by an element that will
	 * influence the rendering of the content. What exactly that means and which
	 * content types are supported depends on the respective element
	 * implementation. The following types are available:
	 *
	 * <ul>
	 *   <li>{@link #PHONE_NUMBER}: a phone number.</li>
	 *   <li>{@link #PASSWORD}: a password or other sensitive information which
	 *     should not be visible.</li>
	 *   <li>{@link #PROGRESS}: a value that indicates the progress of an
	 *     operation.</li>
	 *   <li>{@link #DATE_TIME}: a date value of which the time should also be
	 *     displayed.</li>
	 *   <li>{@link #WEBSITE}: a URL to be displayed in-line.</li>
	 *   <li>{@link #HYPERLINK}: a URI to be visualized as a hyperlink.</li>
	 *   <li>{@link #RELATIVE_URL}: a URL which is relative to the current
	 *     context (and therefore possibly needs to be expanded into an absolute
	 *     URL).</li>
	 *   <li>{@link #ABSOLUTE_URL}: a URL which is independent of the current
	 *     context.</li>
	 *   <li>{@link #FILE_UPLOAD}: the content will be created from a file
	 *     upload.</li>
	 * </ul>
	 */
	public enum ContentType
	{
		PHONE_NUMBER, PASSWORD, PROGRESS, DATE_TIME, WEBSITE, HYPERLINK,
		RELATIVE_URL, ABSOLUTE_URL, FILE_UPLOAD
	}

	/********************************************************************
	 * The possible input modes for interactive input elements. If set and
	 * supported by the data element UI input will be sent to the server based
	 * on the input mode value. If it is {@link #ACTION} the input will be sent
	 * each time a specific input action occurs in the respective input user
	 * interface. The type of action depends on the actual user interface
	 * component. It can be the press of the enter key and/or a double click. If
	 * the mode is {@link #CONTINUOUS} each input event (e.g. the change of a
	 * selection) will be sent back to the server. The mode {@link #BOTH}
	 * combines action and continuous events.
	 */
	public enum InteractiveInputMode { NONE, ACTION, CONTINUOUS, BOTH }

	/********************************************************************
	 * The style in which list elements should be displayed. The following
	 * values are available:
	 *
	 * <ul>
	 *   <li>{@link #LIST}: a (scrollable) list with selectable elements.</li>
	 *   <li>{@link #DROP_DOWN}: a drop-down box that displays only the
	 *     currently selected element.</li>
	 *   <li>{@link #EDITABLE}: an input field that displays list of suggested
	 *     values.</li>
	 *   <li>{@link #DISCRETE}: separate controls for each element (e.g. radio
	 *     buttons or checkboxes)</li>
	 *   <li>{@link #IMMEDIATE}: separate controls for each element that.
	 *     immediately cause an action when selected (e.g. buttons or
	 *     hyperlinks).</li>
	 * </ul>
	 */
	public enum ListStyle { LIST, DROP_DOWN, EDITABLE, DISCRETE, IMMEDIATE }

	//~ Static fields/initializers ---------------------------------------------

	/** Integer: the number of rows to display. */
	public static final PropertyName<Integer> ROWS =
		PropertyName.newIntegerName("ROWS");

	/** Integer: the number of columns to display. */
	public static final PropertyName<Integer> COLUMNS =
		PropertyName.newIntegerName("COLUMNS");

	/** Integer: the number of rows that an element spans in a grid or table. */
	public static final PropertyName<Integer> ROW_SPAN =
		PropertyName.newIntegerName("ROW_SPAN");

	/**
	 * Integer: the number of columns that an element spans in a grid or table.
	 */
	public static final PropertyName<Integer> COLUMN_SPAN =
		PropertyName.newIntegerName("COLUMN_SPAN");

	/** Integer: the number of rows to display in a table. */
	public static final PropertyName<Integer> TABLE_ROWS =
		PropertyName.newIntegerName("TABLE_ROWS");

	/** Integer: the display width in pixels. */
	public static final PropertyName<Integer> WIDTH =
		PropertyName.newIntegerName("WIDTH");

	/** Integer: the display height in pixels. */
	public static final PropertyName<Integer> HEIGHT =
		PropertyName.newIntegerName("HEIGHT");

	/** String: the display width in HTML units. */
	public static final PropertyName<String> HTML_WIDTH =
		PropertyName.newStringName("HTML_WIDTH");

	/** String: the display height in HTML units. */
	public static final PropertyName<String> HTML_HEIGHT =
		PropertyName.newStringName("HTML_HEIGHT");

	/** Integer: the minimum number of characters to display. */
	public static final PropertyName<Integer> MIN_CHARS =
		PropertyName.newIntegerName("MIN_CHARS");

	/** Integer: the maximum number of characters to display. */
	public static final PropertyName<Integer> MAX_CHARS =
		PropertyName.newIntegerName("MAX_CHARS");

	/** Integer: the (initial) position of the text input caret. */
	public static final PropertyName<Integer> CARET_POSITION =
		PropertyName.newIntegerName("CARET_POSITION");

	/**
	 * String: a list of disabled elements, e.g. of buttons in a list with
	 * discrete or immediate style.
	 */
	public static final PropertyName<String> DISABLED_ELEMENTS =
		PropertyName.newStringName("DISABLED_ELEMENTS");

	/** Boolean: TRUE to explicitly disable an element. */
	public static final PropertyName<Boolean> DISABLED =
		PropertyName.newBooleanName("DISABLED");

	/** Boolean: TRUE to hide an element. */
	public static final PropertyName<Boolean> HIDDEN =
		PropertyName.newBooleanName("HIDDEN");

	/**
	 * Boolean: TRUE for an element that has a vertical orientation instead of
	 * horizontal.
	 */
	public static final PropertyName<Boolean> VERTICAL =
		PropertyName.newBooleanName("VERTICAL");

	/**
	 * Boolean: TRUE to prevent the locking of an element during interactions
	 * with a server.
	 */
	public static final PropertyName<Boolean> NO_INTERACTION_LOCK =
		PropertyName.newBooleanName("NO_INTERACTION_LOCK");

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

	/**
	 * Boolean: TRUE to mark the element that should receive the initial UI
	 * focus. This flag should only occur once in a set of elements. The
	 * behavior for multiple occurrences is undefined.
	 */
	public static final PropertyName<Boolean> INITIAL_FOCUS =
		PropertyName.newBooleanName("INITIAL_FOCUS");

	/** Boolean: indicates that the values of an element should be sorted. */
	public static final PropertyName<Boolean> SORT =
		PropertyName.newBooleanName("SORT");

	/**
	 * Boolean: TRUE to indicate that an element contains a resource. This
	 * typically means that the element must expand text before displaying it.
	 */
	public static final PropertyName<Boolean> RESOURCE =
		PropertyName.newBooleanName("RESOURCE");

	/**
	 * Boolean: marks a user interface element to be rendered with image if
	 * applicable.
	 */
	public static final PropertyName<Boolean> HAS_IMAGES =
		PropertyName.newBooleanName("HAS_IMAGES");

	/** String: a resource ID for the target object. */
	public static final PropertyName<String> RESOURCE_ID =
		PropertyName.newStringName("RESOURCE_ID");

	/** String: an application-specific style string (e.g. a CSS class name). */
	public static final PropertyName<String> STYLE =
		PropertyName.newStringName("STYLE");

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

	/** Integer: the current selection index of a multiple-data element. */
	public static final PropertyName<Integer> CURRENT_SELECTION =
		PropertyName.newIntegerName("CURRENT_SELECTION");

	/** Boolean: indicates that the value of an element has changed. */
	public static final PropertyName<Boolean> VALUE_CHANGED =
		PropertyName.newBooleanName("VALUE_CHANGED");

	/**
	 * Enum: the type in which a list data element should be displayed (must
	 * contain a value from {@link ListStyle}.
	 */
	public static final PropertyName<ListStyle> LIST_STYLE =
		PropertyName.newEnumName("LIST_STYLE", ListStyle.class);

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
	 * Enum: the input mode for interactive input elements. If supported by the
	 * element and not NONE the input element will send input interactively to
	 * the receiver as defined by the mode value.
	 */
	public static final PropertyName<InteractiveInputMode> INTERACTIVE_INPUT_MODE =
		PropertyName.newEnumName("INTERACTIVE_INPUT_MODE",
								 InteractiveInputMode.class);

	/**
	 * Boolean: a layout hint that indicates that an element should be displayed
	 * in the same row as the previous data element(s).
	 */
	public static final PropertyName<Boolean> SAME_ROW =
		PropertyName.newBooleanName("SAME_ROW");

	/**
	 * String: a comma-separated list of the names of user interface elements
	 * that have a (mutual) dependency on the selection of the target element.
	 * The exact meaning of this depends on the implementation of the user
	 * interface elements but possible variants would be:
	 *
	 * <ul>
	 *   <li>Lists and similar selectable elements: their selection is mutually
	 *     exclusive. If a selection occurs in one element, the others are
	 *     unselected and vice versa.</li>
	 *   <li>Other elements: if the target element is selected the enabled state
	 *     of the dependent components is modified. Buttons and lists will
	 *     toggle the state while checkboxes and radio buttons directly
	 *     represent the selection state of the elements. If the element list
	 *     starts with the string {@link #SELECTION_DEPENDENCY_REVERSE_PREFIX}
	 *     the dependent elements will be enabled if the toggle button is not
	 *     selected.</li>
	 * </ul>
	 */
	public static final PropertyName<String> SELECTION_DEPENDENCY =
		PropertyName.newStringName("SELECTION_DEPENDENCY");

	/**
	 * A prefix to be added to reverse the effect of the user interface property
	 * {@link #SELECTION_DEPENDENCY} for toggle buttons.
	 */
	public static final String SELECTION_DEPENDENCY_REVERSE_PREFIX = "!";

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Private, only static use.
	 */
	private UserInterfaceProperties()
	{
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * This method should be invoked to initialize the property name constants
	 * for de-serialization.
	 */
	public static void init()
	{
	}
}
