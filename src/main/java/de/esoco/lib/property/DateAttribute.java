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
 * Property interface for elements that implement a {@link Date} attribute.
 *
 * @author eso
 */
public interface DateAttribute {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the element's date.
	 *
	 * @return The date
	 */
	public Date getDate();

	/***************************************
	 * Sets the element's date.
	 *
	 * @param rDate The new date
	 */
	public void setDate(Date rDate);
}
