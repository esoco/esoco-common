//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// WorkflowManager2 Source File
// Copyright (c) 2017 by Thomas Kuechenthal / LEMARIT GmbH
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package de.esoco.lib.ui.event;

/********************************************************************
 * The event handling interface for UI component. It consists of a single method
 * that will be invoked for all events that the handler instance has been
 * registered for on components and other event-generating objects (like menu
 * items).
 *
 * @author eso
 */
@FunctionalInterface
public interface UiEventHandler
{
	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * This method will be invoked to handle events.
	 *
	 * @param rEvent The event that occurred
	 */
	public void handleEvent(UiEvent rEvent);
}
