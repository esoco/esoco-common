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
package de.esoco.lib.model;

import java.util.function.Function;


/********************************************************************
 * A function that reads attributes from an object T and also allows to query
 * the datatype of the attribute values from {@link #getValueType()}.
 *
 * @author eso
 */
public interface AttributeBinding<T, V> extends Function<T, V>
{
	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the datatype of the values that this binding returns. The generic
	 * type is relaxed to <code>? super V</code> to allow to define bindings to
	 * other generic types like collections.
	 *
	 * @return The value datatype
	 */
	public Class<? super V> getValueType();
}
