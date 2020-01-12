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
package de.esoco.lib.model;

/********************************************************************
 * An event class that describes change events in a data model. There are
 * different types of events that are defined by the Type enumeration. For each
 * type, the element index of an event defines the data element that is affected
 * by the action that caused the event. For the event type ELEMENT_REMOVED the
 * index will point to the position where the removed element had been before
 * removal. If the index value is -1 it means that either identifying changed
 * elements is not supported by the model implementation or that all (or many)
 * elements are affected.
 *
 * @author eso
 * @see    de.esoco.lib.model.DataModelListener
 */
public class DataModelEvent {

	//~ Enums ------------------------------------------------------------------

	/********************************************************************
	 * The possible event types.
	 */
	public enum Type { ELEMENT_MODIFIED, ELEMENT_ADDED, ELEMENT_REMOVED }

	//~ Instance fields --------------------------------------------------------

	private final Type		   eType;
	private final int		   nElementIndex;
	private final DataModel<?> rSource;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates and initializes a new instance.
	 *
	 * @param rSource       The data model that caused the event
	 * @param eType         The event type
	 * @param nElementIndex The index of the changed model element or -1 if it
	 *                      could not be detected
	 */
	public DataModelEvent(DataModel<?> rSource, Type eType, int nElementIndex) {
		this.rSource	   = rSource;
		this.eType		   = eType;
		this.nElementIndex = nElementIndex;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the index of the changed element.
	 *
	 * @return The element index
	 */
	public final int getElementIndex() {
		return nElementIndex;
	}

	/***************************************
	 * Returns the event type.
	 *
	 * @return The event type
	 */
	public final Type getType() {
		return eType;
	}

	/***************************************
	 * Returns the data element from which the event originates.
	 *
	 * @return The source data model
	 */
	final DataModel<?> getSource() {
		return rSource;
	}
}
