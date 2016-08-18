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

import java.util.Set;


/********************************************************************
 * Defines typical state {@link PropertyName Properties}.
 *
 * @author eso
 */
public interface StateProperties
{
	//~ Static fields/initializers ---------------------------------------------

	/** Integer: the (initial) position of the text input caret. */
	public static final PropertyName<Integer> CARET_POSITION =
		PropertyName.newIntegerName("CARET_POSITION");

	/** Boolean: TRUE to explicitly disable an element. */
	public static final PropertyName<Boolean> DISABLED =
		PropertyName.newBooleanName("DISABLED");

	/** Boolean: TRUE to hide an element. */
	public static final PropertyName<Boolean> HIDDEN =
		PropertyName.newBooleanName("HIDDEN");

	/**
	 * Boolean: TRUE to prevent the locking of an element during interactions
	 * with a server.
	 */
	public static final PropertyName<Boolean> NO_INTERACTION_LOCK =
		PropertyName.newBooleanName("NO_INTERACTION_LOCK");

	/**
	 * Boolean: TRUE to mark the element that should receive the input focus.
	 * This flag should only occur once in an user interface definition. The
	 * behavior for multiple occurrences is undefined.
	 */
	public static final PropertyName<Boolean> FOCUSED =
		PropertyName.newBooleanName("FOCUSED");

	/** Integer: the current selection index of a multiple-data element. */
	public static final PropertyName<Integer> CURRENT_SELECTION =
		PropertyName.newIntegerName("CURRENT_SELECTION");

	/** Boolean: indicates that the value of an element has changed. */
	public static final PropertyName<Boolean> VALUE_CHANGED =
		PropertyName.newBooleanName("VALUE_CHANGED");

	/** Enum: the input mode for interactive input elements. */
	public static final PropertyName<InteractiveInputMode> INTERACTIVE_INPUT_MODE =
		PropertyName.newEnumName("INTERACTIVE_INPUT_MODE",
								 InteractiveInputMode.class);

	/**
	 * Set of enums: the event types to be listened to in interactive user
	 * interfaces.
	 */
	public static final PropertyName<Set<InteractionEventType>> INTERACTION_EVENT_TYPES =
		PropertyName.newSetName("INTERACTION_EVENT_TYPES",
								InteractionEventType.class);

	/**
	 * An optional data value for interaction events. If this value is available
	 * in an event it's string representation will be transferred to the server
	 * in this property.
	 */
	public static final PropertyName<String> INTERACTION_EVENT_DATA =
		PropertyName.newStringName("INTERACTION_EVENT_DATA");

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
}
