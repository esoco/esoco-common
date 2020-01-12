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

/********************************************************************
 * Enumeration of list layout styles.
 *
 * <ul>
 *   <li>{@link #SIMPLE}: A simple list a component for each row.</li>
 *   <li>{@link #EXPAND}: Each row can be expanded by clicking on it, revealing
 *     a complex list item component.</li>
 *   <li>{@link #POPOUT}: Like {@link #EXPAND} but with an additional pop-out
 *     effect upon selection of a list item.</li>
 * </ul>
 */
public enum ListLayoutStyle { SIMPLE, EXPAND, POPOUT }
