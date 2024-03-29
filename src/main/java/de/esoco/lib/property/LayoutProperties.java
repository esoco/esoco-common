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
 * Defines typical layout {@link PropertyName Properties}.
 *
 * @author eso
 */
public interface LayoutProperties {

	/**
	 * Integer: override the default ordering of elements in a layout.
	 */
	PropertyName<Integer> ORDER = PropertyName.newIntegerName("ORDER");

	/**
	 * Integer: the layout row to place an element at.
	 */
	PropertyName<Integer> ROW = PropertyName.newIntegerName("ROW");

	/**
	 * Integer: the layout column to place an element at.
	 */
	PropertyName<Integer> COLUMN = PropertyName.newIntegerName("COLUMN");

	/**
	 * Integer: the number of rows an element shall display.
	 */
	PropertyName<Integer> ROWS = PropertyName.newIntegerName("ROWS");

	/**
	 * Integer: the number of columns and element shall display.
	 */
	PropertyName<Integer> COLUMNS = PropertyName.newIntegerName("COLUMNS");

	/**
	 * Integer: the number of rows that an element spans in a layout.
	 */
	PropertyName<Integer> ROW_SPAN = PropertyName.newIntegerName("ROW_SPAN");

	/**
	 * Integer: the number of columns that an element spans in a layout.
	 */
	PropertyName<Integer> COLUMN_SPAN =
		PropertyName.newIntegerName("COLUMN_SPAN");

	/**
	 * Integer: the number of columns that an element spans in a responsive
	 * layout with reduced (medium) layout space. This complements
	 * {@link #COLUMN_SPAN} which defines the maximum layout size.
	 */
	PropertyName<Integer> MEDIUM_COLUMN_SPAN =
		PropertyName.newIntegerName("MEDIUM_COLUMN_SPAN");

	/**
	 * Integer: the number of columns that an element spans in a responsive
	 * layout with minimal (= small) layout space. This complements
	 * {@link #COLUMN_SPAN} which defines the maximum layout size.
	 */
	PropertyName<Integer> SMALL_COLUMN_SPAN =
		PropertyName.newIntegerName("SMALL_COLUMN_SPAN");

	/**
	 * Integer: the display width in pixels.
	 */
	PropertyName<Integer> WIDTH = PropertyName.newIntegerName("WIDTH");

	/**
	 * Integer: the display height in pixels.
	 */
	PropertyName<Integer> HEIGHT = PropertyName.newIntegerName("HEIGHT");

	/**
	 * String: the display width in HTML units.
	 */
	PropertyName<String> HTML_WIDTH = PropertyName.newStringName("HTML_WIDTH");

	/**
	 * String: the display height in HTML units.
	 */
	PropertyName<String> HTML_HEIGHT =
		PropertyName.newStringName("HTML_HEIGHT");

	/**
	 * {@link LayoutType}: The layout of an element.
	 */
	PropertyName<LayoutType> LAYOUT =
		PropertyName.newEnumName("LAYOUT", LayoutType.class);

	/**
	 * String: The name of the layout are an element should be placed in (e.g.
	 * in a CSS grid layout).
	 */
	PropertyName<String> LAYOUT_AREA =
		PropertyName.newStringName("LAYOUT_AREA");

	/**
	 * {@link LayoutVisibility}: The visibility of an element in the responsive
	 * rendering of layouts.
	 */
	PropertyName<LayoutVisibility> LAYOUT_VISIBILITY =
		PropertyName.newEnumName("LAYOUT_VISIBILITY", LayoutVisibility.class);

	/**
	 * {@link ViewDisplayType}: The display style of a view.
	 */
	PropertyName<ViewDisplayType> VIEW_DISPLAY_TYPE =
		PropertyName.newEnumName("VIEW_DISPLAY_TYPE", ViewDisplayType.class);

	/**
	 * Enum: a relative width constant.
	 */
	PropertyName<RelativeSize> RELATIVE_WIDTH =
		PropertyName.newEnumName("RELATIVE_WIDTH", RelativeSize.class);

	/**
	 * Enum: a relative height constant.
	 */
	PropertyName<RelativeSize> RELATIVE_HEIGHT =
		PropertyName.newEnumName("RELATIVE_HEIGHT", RelativeSize.class);

	/**
	 * Boolean: a layout hint that indicates that an element should be
	 * displayed
	 * in the same row as the previous data element(s).
	 */
	PropertyName<Boolean> SAME_ROW = PropertyName.newBooleanName("SAME_ROW");

	/**
	 * {@link Alignment}: defines that an element should float above other
	 * content with the given alignment. Which alignments are supported depends
	 * on the implementation.
	 */
	PropertyName<Alignment> FLOAT =
		PropertyName.newEnumName("FLOAT", Alignment.class);

	/**
	 * {@link Alignment}: the horizontal alignment of an element.
	 */
	PropertyName<Alignment> HORIZONTAL_ALIGN =
		PropertyName.newEnumName("HORIZONTAL_ALIGN", Alignment.class);

	/**
	 * {@link Alignment}: the horizontal alignment of an element.
	 */
	PropertyName<Alignment> VERTICAL_ALIGN =
		PropertyName.newEnumName("VERTICAL_ALIGN", Alignment.class);

	/**
	 * {@link Alignment}: the alignment of text within an element.
	 */
	PropertyName<Alignment> TEXT_ALIGN =
		PropertyName.newEnumName("TEXT_ALIGN", Alignment.class);

	/**
	 * {@link Alignment}: the alignment of an icon within an element.
	 */
	PropertyName<Alignment> ICON_ALIGN =
		PropertyName.newEnumName("ICON_ALIGN", Alignment.class);

	/**
	 * Enum: The relative scale of an {@link ContentProperties#ICON}.
	 */
	PropertyName<RelativeScale> ICON_SIZE =
		PropertyName.newEnumName("ICON_SIZE", RelativeScale.class);

	/**
	 * Enum: The relative scale of an {@link ContentProperties#ICON}.
	 */
	PropertyName<RelativeScale> BUTTON_SIZE =
		PropertyName.newEnumName("BUTTON_SIZE", RelativeScale.class);

	/**
	 * Enum: The layout direction of an element.
	 */
	PropertyName<Orientation> DIRECTION =
		PropertyName.newEnumName("DIRECTION", Orientation.class);
}
