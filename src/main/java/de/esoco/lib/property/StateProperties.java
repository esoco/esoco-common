//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2018 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
	 * Boolean: TRUE to prevent the propagation of component events to it's
	 * parent hierarchy.
	 */
	public static final PropertyName<Boolean> NO_EVENT_PROPAGATION =
		PropertyName.newBooleanName("NO_EVENT_PROPAGATION");

	/**
	 * Boolean: fire action events only if a component that implements {@link
	 * ActiveState} has been activated, but not if deactivated.
	 */
	public static final PropertyName<Boolean> ACTION_EVENT_ON_ACTIVATION_ONLY =
		PropertyName.newBooleanName("ACTION_EVENT_ON_ACTIVATION_ONLY");

	/**
	 * Boolean: TRUE to mark the element that should receive the input focus.
	 * This flag should only occur once in an user interface definition. The
	 * behavior for occurrences on multiple elements depends on the underlying
	 * platform.
	 */
	public static final PropertyName<Boolean> FOCUSED =
		PropertyName.newBooleanName("FOCUSED");

	/** Integer: the current selection index of a multiple-data element. */
	public static final PropertyName<Integer> CURRENT_SELECTION =
		PropertyName.newIntegerName("CURRENT_SELECTION");

	/**
	 * String map: filter criteria of an element (e.g. a table). The key denotes
	 * the filtered attribute and the value the criterion.
	 */
	public static final PropertyName<Map<String, String>> FILTER_CRITERIA =
		PropertyName.newMapName("FILTER_CRITERIA", String.class, String.class);

	/** Enum: if present, defines the sort direction for ordered data. */
	public static final PropertyName<SortDirection> SORT_DIRECTION =
		PropertyName.newEnumName("SORT_DIRECTION", SortDirection.class);

	/** Boolean: indicates that the value of an element has changed. */
	public static final PropertyName<Boolean> VALUE_CHANGED =
		PropertyName.newBooleanName("VALUE_CHANGED");

	/**
	 * Boolean: indicates that one or more properties of an element have
	 * changed.
	 */
	public static final PropertyName<Boolean> PROPERTIES_CHANGED =
		PropertyName.newBooleanName("PROPERTIES_CHANGED");

	/** Boolean: indicates that the structure of an element has changed. */
	public static final PropertyName<Boolean> STRUCTURE_CHANGED =
		PropertyName.newBooleanName("STRUCTURE_CHANGED");

	/** Enum: the input mode for interactive input elements. */
	public static final PropertyName<InteractiveInputMode> INTERACTIVE_INPUT_MODE =
		PropertyName.newEnumName("INTERACTIVE_INPUT_MODE",
								 InteractiveInputMode.class);

	/**
	 * Boolean: whether an element should be explicitly disabled if it causes an
	 * interaction.
	 */
	public static final PropertyName<Boolean> DISABLE_ON_INTERACTION =
		PropertyName.newBooleanName("DISABLE_ON_INTERACTION");

	/**
	 * Integer: a delay in milliseconds to postpone the event handling for an
	 * element with.
	 */
	public static final PropertyName<Integer> EVENT_HANDLING_DELAY =
		PropertyName.newIntegerName("EVENT_HANDLING_DELAY");

	/**
	 * Set of enums: the event types to be listened to in interactive user
	 * interfaces.
	 */
	public static final PropertyName<Set<InteractionEventType>> INTERACTION_EVENT_TYPES =
		PropertyName.newSetName("INTERACTION_EVENT_TYPES",
								InteractionEventType.class);

	/**
	 * String: an optional data value for interaction events. If this value is
	 * available in an event it's string representation will be transferred to
	 * the server in this property.
	 */
	public static final PropertyName<String> INTERACTION_EVENT_DATA =
		PropertyName.newStringName("INTERACTION_EVENT_DATA");

	/**
	 * String: the identifier of a target element to be activated or modified by
	 * the element it is set upon.
	 */
	public static final PropertyName<String> TARGET_ID =
		PropertyName.newStringName("TARGET_ID");

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
