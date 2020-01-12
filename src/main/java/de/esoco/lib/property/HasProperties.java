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

import java.util.Collection;


/********************************************************************
 * An interface that defines the read access to named properties. The property
 * access methods have a default value parameter that is returned if an instance
 * doesn't contain a property value for a particular property name.
 *
 * <p>It is up to subclasses to implement the storing of properties. This means
 * that it depends on the implementation, which datatypes are supported to be
 * stored. Trying to store or access unsupported types may cause an exception.
 * </p>
 *
 * @author eso
 */
public interface HasProperties {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * A convenience method that returns the value of a property as an int.
	 *
	 * @param  rName    The name of the property
	 * @param  nDefault The default value if no such property exists
	 *
	 * @return The int property value or the default value
	 */
	public int getIntProperty(PropertyName<Integer> rName, int nDefault);

	/***************************************
	 * Returns the value of a particular property.
	 *
	 * @param  rName    The name of the property
	 * @param  rDefault The default value if no such property exists
	 *
	 * @return The property value or the default value
	 */
	public <T> T getProperty(PropertyName<T> rName, T rDefault);

	/***************************************
	 * Returns the number of properties stored in this instance.
	 *
	 * @return The number of properties
	 */
	public int getPropertyCount();

	/***************************************
	 * Returns a collection containing the names of the properties that are set
	 * in this instance.
	 *
	 * @return A collection of the property names
	 */
	public Collection<PropertyName<?>> getPropertyNames();

	/***************************************
	 * A convenience method to query a boolean property with a default value of
	 * FALSE.
	 *
	 * @param  rName The name of the boolean property
	 *
	 * @return TRUE if the property exists and is set to TRUE
	 */
	public boolean hasFlag(PropertyName<Boolean> rName);

	/***************************************
	 * Checks whether this instance contains a certain property.
	 *
	 * @param  rName The name of the property to check
	 *
	 * @return TRUE if the property exists
	 */
	public boolean hasProperty(PropertyName<?> rName);
}
