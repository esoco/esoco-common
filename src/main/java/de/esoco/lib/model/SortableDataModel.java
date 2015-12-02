//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
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
package de.esoco.lib.model;

/********************************************************************
 * An extended data model that allows to sort the contained data elements by
 * their fields.
 *
 * @author eso
 */
public interface SortableDataModel<T> extends DataModel<T>
{
	//~ Enums ------------------------------------------------------------------

	/********************************************************************
	 * Enumeration of the possible sort modes. May be extended in future
	 * versions with additional sort options.
	 */
	public enum SortMode { ASCENDING, DESCENDING }

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the sort mode for a certain field of the data in this model.
	 *
	 * @param  sFieldId The ID of the field to return the sort mode for
	 *
	 * @return The sort mode for the given field or NULL for none
	 */
	public SortMode getSortMode(String sFieldId);

	/***************************************
	 * Removes all sort criteria from this model.
	 */
	public void removeSorting();

	/***************************************
	 * Sets the sort mode for a certain field of the data in this model.
	 *
	 * @param sFieldId The ID of the field to set the sort mode for
	 * @param rMode    The sort mode or NULL to disable the sort criterion for
	 *                 the given field
	 */
	public void setSortMode(String sFieldId, SortMode rMode);
}
