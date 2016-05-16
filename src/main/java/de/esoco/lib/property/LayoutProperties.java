//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2016 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
 * Defines typical layout {@link PropertyName Properties}.
 *
 * @author eso
 */
public interface LayoutProperties
{
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

	/** {@link Layout}: The layout of an elements. */
	public static final PropertyName<Layout> LAYOUT =
		PropertyName.newEnumName("LAYOUT", Layout.class);

	/** {@link ViewDisplayType}: The display style of a view. */
	public static final PropertyName<ViewDisplayType> VIEW_DISPLAY_TYPE =
		PropertyName.newEnumName("VIEW_DISPLAY_TYPE", ViewDisplayType.class);

	/** Enum: a relative width constant. */
	public static final PropertyName<RelativeSize> RELATIVE_WIDTH =
		PropertyName.newEnumName("RELATIVE_WIDTH", RelativeSize.class);

	/** Enum: a relative height constant. */
	public static final PropertyName<RelativeSize> RELATIVE_HEIGHT =
		PropertyName.newEnumName("RELATIVE_HEIGHT", RelativeSize.class);

	/**
	 * Boolean: a layout hint that indicates that an element should be displayed
	 * in the same row as the previous data element(s).
	 */
	public static final PropertyName<Boolean> SAME_ROW =
		PropertyName.newBooleanName("SAME_ROW");
}