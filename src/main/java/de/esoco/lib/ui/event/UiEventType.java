//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'gewt' project.
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
package de.esoco.lib.ui.event;

/********************************************************************
 * An enumeration of all GEWT event types for which event listeners can be
 * registered on components. Focus and pointer events are supported by all
 * components. Which other event types are supported can be found out from the
 * documentation of the respective component.
 *
 * @author eso
 */
public enum UiEventType
{
	ACTION, SELECTION, VALUE_CHANGED,

	// --- Focus events ---------------
	FOCUS_GAINED, FOCUS_LOST,

	// --- Key events -----------------

	KEY_PRESSED, KEY_RELEASED, KEY_TYPED,

	// --- Pointer events -------------
	POINTER_MOVED, POINTER_DRAGGED, POINTER_ENTERED, POINTER_EXITED,
	POINTER_HOVER, POINTER_CLICKED, POINTER_DOUBLE_CLICKED, POINTER_PRESSED,
	POINTER_RELEASED, POINTER_WHEEL,

	// --- Element events -------------

	ELEMENT_SELECTED, ELEMENT_CREATED, ELEMENT_DELETED, ELEMENT_OPENED,
	ELEMENT_UPDATED,

	// --- View events ----------------

	VIEW_CLOSING
}
