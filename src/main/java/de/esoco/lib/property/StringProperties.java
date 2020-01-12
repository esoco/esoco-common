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

import java.io.Serializable;


/********************************************************************
 * This class implements a property mapping that encodes all property values as
 * strings. See the implemented interface {@link MutableProperties} for details.
 *
 * @author eso
 */
public class StringProperties extends AbstractStringProperties
	implements MutableProperties, Serializable {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance.
	 */
	public StringProperties() {
	}

	/***************************************
	 * Copy constructor that creates a new instance from another properties
	 * object. Invokes the {@link #setProperties(HasProperties, boolean)}
	 * method.
	 *
	 * @param rOther The instance to copy the properties from
	 */
	public StringProperties(HasProperties rOther) {
		setProperties(rOther, true);
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public final void clearFlag(PropertyName<Boolean> rName) {
		if (hasProperty(rName)) {
			removeProperty(rName);
		}
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public void clearProperties() {
		setPropertyMap(null);
	}

	/***************************************
	 * Overridden as public.
	 *
	 * @see MutableProperties#removeProperty(PropertyName)
	 */
	@Override
	public void removeProperty(PropertyName<?> rName) {
		super.removeProperty(rName);
	}

	/***************************************
	 * Overridden as public.
	 *
	 * @see MutableProperties#setFlag(PropertyName)
	 */
	@Override
	public final void setFlag(PropertyName<Boolean> rName) {
		setProperty(rName, true);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public void setProperties(HasProperties rOther, boolean bReplace) {
		if (rOther.getPropertyCount() > 0) {
			ensurePropertyMapExists();

			for (PropertyName<?> rName : rOther.getPropertyNames()) {
				if (bReplace || !hasProperty(rName)) {
					Object rValue = rOther.getProperty(rName, null);

					if (rValue != null) {
						getPropertyMap().put(rName, convertValue(rValue));
					}
				}
			}
		}
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public <T> void setProperty(PropertyName<T> rName, T rValue) {
		super.setProperty(rName, rValue);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public final void setProperty(PropertyName<Boolean> rName, boolean bValue) {
		setProperty(rName, Boolean.valueOf(bValue));
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public final void setProperty(PropertyName<Integer> rName, int nValue) {
		setProperty(rName, Integer.valueOf(nValue));
	}
}
