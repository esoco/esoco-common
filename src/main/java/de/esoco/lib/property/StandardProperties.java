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

import java.util.Date;


/********************************************************************
 * This class defines several standard property names. Whenever possible these
 * property names should be preferred over self-defined ones because they allow
 * to access common properties in a generic way.
 *
 * @author eso
 */
public class StandardProperties {

	//~ Static fields/initializers ---------------------------------------------

	/** Integer: a unique integer identifier of an element. */
	public static final PropertyName<Integer> INTEGER_ID =
		PropertyName.newIntegerName("INTEGER_ID");

	/** String: the unique identifier of an element. */
	public static final PropertyName<String> ID =
		PropertyName.newStringName("ID");

	/** String: the name of an element. */
	public static final PropertyName<String> NAME =
		PropertyName.newStringName("NAME");

	/** String: a title. */
	public static final PropertyName<String> TITLE =
		PropertyName.newStringName("TITLE");

	/** String: a description. */
	public static final PropertyName<String> DESCRIPTION =
		PropertyName.newStringName("DESCRIPTION");

	/** Integer: a numeric count value. */
	public static final PropertyName<Integer> COUNT =
		PropertyName.newIntegerName("COUNT");

	/** Boolean: flag to mark an object as immutable. */
	public static final PropertyName<Boolean> READONLY =
		PropertyName.newBooleanName("READONLY");

	//- Date and Calendar related -----------------------------------

	/** Date: a date and/or time. */
	public static final PropertyName<Date> DATE =
		PropertyName.newDateName("DATE");

	/** Date: the start date of an event or period. */
	public static final PropertyName<Date> START_DATE =
		PropertyName.newDateName("START_DATE");

	/** Date: the end date of an event or period. */
	public static final PropertyName<Date> END_DATE =
		PropertyName.newDateName("END_DATE");

	/** Date: the next date of an event or period. */
	public static final PropertyName<Date> NEXT_DATE =
		PropertyName.newDateName("NEXT_DATE");

	/** Date: the reminder date for an event. */
	public static final PropertyName<Date> REMINDER_DATE =
		PropertyName.newDateName("REMINDER_DATE");

	/** String: the name of a location, e.g. of an calendar event. */
	public static final PropertyName<String> LOCATION =
		PropertyName.newStringName("LOCATION");

	/** Boolean: flag to indicate an calendar event with start and end times. */
	public static final PropertyName<Boolean> ALL_DAY =
		PropertyName.newBooleanName("ALL_DAY");

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Private, only static use.
	 */
	private StandardProperties() {
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * This method should be invoked to initialize the property name constants
	 * for de-serialization.
	 */
	public static void init() {
	}
}
