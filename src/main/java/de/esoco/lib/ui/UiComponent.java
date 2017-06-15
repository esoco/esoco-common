//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2017 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
package de.esoco.lib.ui;

import de.esoco.lib.property.VisibilityState;
import de.esoco.lib.ui.event.UiEventHandler;
import de.esoco.lib.ui.event.UiEventType;


/********************************************************************
 * The base interface for all UI components.
 *
 * @author eso
 */
public interface UiComponent extends UiElement, VisibilityState
{
	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Registers an event handler for events of a certain type. Not all UI
	 * implementations may support the registration of event handlers on
	 * components but only on {@link UiControl} and it's descendants.
	 *
	 * @param eType         The event type
	 * @param rEventHandler The event handler
	 */
	public void onEvent(UiEventType eType, UiEventHandler rEventHandler);
}
