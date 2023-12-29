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
 * Interface for objects that can be selected and allow to query the actual
 * selection state.
 *
 * @author eso
 */
public interface Selectable {

	/**
	 * Returns the selection state of this instance.
	 *
	 * @return TRUE if this instance is selected
	 */
	boolean isSelected();

	/**
	 * Sets the selection state of this instance.
	 *
	 * @param selected The new selected state of this instance
	 */
	void setSelected(boolean selected);
}
