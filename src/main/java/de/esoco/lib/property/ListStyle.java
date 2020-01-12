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
 * The style in which list elements should be displayed. The following values
 * are available:
 *
 * <ul>
 *   <li>{@link #LIST}: a (scrollable) list with selectable elements.</li>
 *   <li>{@link #DROP_DOWN}: a drop-down box of all values that displays the
 *     currently selected element.</li>
 *   <li>{@link #EDITABLE}: an editable input field that can display a list of
 *     suggested values.</li>
 *   <li>{@link #DISCRETE}: separate controls for each element (e.g. radio
 *     buttons or checkboxes)</li>
 *   <li>{@link #IMMEDIATE}: separate controls for each element that immediately
 *     cause an action when selected (e.g. buttons or hyperlinks).</li>
 * </ul>
 */
public enum ListStyle { LIST, DROP_DOWN, EDITABLE, DISCRETE, IMMEDIATE }
