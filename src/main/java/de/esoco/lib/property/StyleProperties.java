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

import java.util.Map;

/**
 * Defines typical style {@link PropertyName Properties}.
 *
 * @author eso
 */
public interface StyleProperties {

	/**
	 * Integer: the number of rows to display in a table.
	 */
	PropertyName<Integer> TABLE_ROWS =
		PropertyName.newIntegerName("TABLE_ROWS");

	/**
	 * Integer: the minimum number of characters to display.
	 */
	PropertyName<Integer> MIN_CHARS = PropertyName.newIntegerName("MIN_CHARS");

	/**
	 * Integer: the maximum number of characters to display.
	 */
	PropertyName<Integer> MAX_CHARS = PropertyName.newIntegerName("MAX_CHARS");

	/**
	 * Integer: the size of a splitter in a split layout.
	 */
	PropertyName<Integer> SPLITTER_SIZE =
		PropertyName.newIntegerName("SPLITTER_SIZE");

	/**
	 * Integer: the duration of an UI animation.
	 */
	PropertyName<Integer> ANIMATION_DURATION =
		PropertyName.newIntegerName("ANIMATION_DURATION");

	/**
	 * String: a list of disabled elements, e.g. of buttons in a list with
	 * discrete or immediate style.
	 */
	PropertyName<String> DISABLED_ELEMENTS =
		PropertyName.newStringName("DISABLED_ELEMENTS");

	/**
	 * Enum: The visual orientation of an element.
	 */
	PropertyName<Orientation> ORIENTATION =
		PropertyName.newEnumName("ORIENTATION", Orientation.class);

	/**
	 * Boolean: TRUE for the hierarchical display of data.
	 */
	PropertyName<Boolean> HIERARCHICAL =
		PropertyName.newBooleanName("HIERARCHICAL");

	/**
	 * Boolean: TRUE to hide the label when displaying the element.
	 */
	PropertyName<Boolean> HIDE_LABEL =
		PropertyName.newBooleanName("HIDE_LABEL");

	/**
	 * Boolean: TRUE to explicitly show the label of an element.
	 */
	PropertyName<Boolean> SHOW_LABEL =
		PropertyName.newBooleanName("SHOW_LABEL");

	/**
	 * Boolean: TRUE if an element should be hidden automatically.
	 */
	PropertyName<Boolean> AUTO_HIDE = PropertyName.newBooleanName("AUTO_HIDE");

	/**
	 * Boolean: TRUE to display the label of an element as a header instead
	 * of a
	 * prefix.
	 */
	PropertyName<Boolean> HEADER_LABEL =
		PropertyName.newBooleanName("HEADER_LABEL");

	/**
	 * Boolean: TRUE to wrap data or sub-elements in an element.
	 */
	PropertyName<Boolean> WRAP = PropertyName.newBooleanName("WRAP");

	/**
	 * Boolean: TRUE to disabled the wrapping in an element.
	 */
	PropertyName<Boolean> NO_WRAP = PropertyName.newBooleanName("NO_WRAP");

	/**
	 * Boolean: TRUE to mark an element as editable.
	 */
	PropertyName<Boolean> EDITABLE = PropertyName.newBooleanName("EDITABLE");

	/**
	 * Boolean: TRUE to mark an element as searchable.
	 */
	PropertyName<Boolean> SEARCHABLE =
		PropertyName.newBooleanName("SEARCHABLE");

	/**
	 * Boolean: TRUE to mark an element as sortable.
	 */
	PropertyName<Boolean> SORTABLE = PropertyName.newBooleanName("SORTABLE");

	/**
	 * Boolean: TRUE to mark an element as executable.
	 */
	PropertyName<Boolean> EXECUTABLE =
		PropertyName.newBooleanName("EXECUTABLE");

	/**
	 * Boolean: allow the selection of multiple elements.
	 */
	PropertyName<Boolean> MULTI_SELECTION =
		PropertyName.newBooleanName("MULTI_SELECTION");

	/**
	 * Boolean: indicates that the values of an element should be sorted.
	 */
	PropertyName<Boolean> SORT = PropertyName.newBooleanName("SORT");

	/**
	 * Boolean: marks a user interface element to be rendered with image if
	 * applicable.
	 */
	PropertyName<Boolean> HAS_IMAGES =
		PropertyName.newBooleanName("HAS_IMAGES");

	/**
	 * String: an application-specific style string (e.g. a CSS class name).
	 */
	PropertyName<String> STYLE = PropertyName.newStringName("STYLE");

	/**
	 * A map property that contains CSS styles and their values.
	 */
	PropertyName<Map<String, String>> CSS_STYLES =
		PropertyName.newMapName("CSS_STYLES", String.class, String.class);

	/**
	 * Enum: the display style for buttons.
	 */
	PropertyName<ButtonStyle> BUTTON_STYLE =
		PropertyName.newEnumName("BUTTON_STYLE", ButtonStyle.class);

	/**
	 * Enum: the display style for check boxes.
	 */
	PropertyName<CheckBoxStyle> CHECK_BOX_STYLE =
		PropertyName.newEnumName("CHECK_BOX_STYLE", CheckBoxStyle.class);

	/**
	 * Enum: the style in which a readonly text data element should be
	 * displayed.
	 */
	PropertyName<LabelStyle> LABEL_STYLE =
		PropertyName.newEnumName("LABEL_STYLE", LabelStyle.class);

	/**
	 * Enum: the type in which a list data element should be displayed.
	 */
	PropertyName<ListStyle> LIST_STYLE =
		PropertyName.newEnumName("LIST_STYLE", ListStyle.class);

	/**
	 * Enum: the type in which a list data element should be displayed.
	 */
	PropertyName<TableStyle> TABLE_STYLE =
		PropertyName.newEnumName("TABLE_STYLE", TableStyle.class);

	/**
	 * Enum: the type in which a text input box should be displayed.
	 */
	PropertyName<TextFieldStyle> TEXT_FIELD_STYLE =
		PropertyName.newEnumName("TEXT_BOX_STYLE", TextFieldStyle.class);

	/**
	 * The style of a list layout.
	 */
	PropertyName<ListLayoutStyle> LIST_LAYOUT_STYLE =
		PropertyName.newName("LIST_LAYOUT_STYLE", ListLayoutStyle.class);

	/**
	 * The style of a navigation menu.
	 */
	PropertyName<NavigationMenuStyle> NAVIGATION_MENU_STYLE =
		PropertyName.newName("NAVIGATION_MENU_STYLE",
			NavigationMenuStyle.class);

	/**
	 * String: the background color of an element as a HTML color definition.
	 */
	PropertyName<Color> BACKGROUND_COLOR =
		PropertyName.newName("BACKGROUND_COLOR", Color.class);

	/**
	 * String: the foreground color of an element as a HTML color definition.
	 */
	PropertyName<Color> FOREGROUND_COLOR =
		PropertyName.newName("FOREGROUND_COLOR", Color.class);

	/**
	 * String: the icon color of an {@link ContentProperties#ICON} as a HTML
	 * color definition.
	 */
	PropertyName<Color> ICON_COLOR =
		PropertyName.newName("ICON_COLOR", Color.class);

	/**
	 * Boolean: TRUE to use a standard UI component instead of some variant.
	 */
	PropertyName<Boolean> USE_STANDARD_COMPONENT =
		PropertyName.newBooleanName("USE_STANDARD_COMPONENT");
}
