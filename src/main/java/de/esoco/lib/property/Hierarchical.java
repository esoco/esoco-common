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
 * an interface that defines hierarchical data structures with a parent-child
 * relationship. It is an extension of the {@link Iterable} interface which
 * provides access to the children of a hierarchical element.
 *
 * @author eso
 */
public interface Hierarchical<T> extends Iterable<T> {

	/**
	 * Returns the parent element of this item or NULL if this is the root
	 * element.
	 *
	 * @return The parent element or NULL for the root
	 */
	T getParent();
}
