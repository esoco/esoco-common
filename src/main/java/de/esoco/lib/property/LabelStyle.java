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
 * An enumeration of the styles for displaying UI labels. Not all styles may be
 * supported by an UI implementation in which case it should revert to a
 * reasonable default if possible.
 *
 * <ul>
 *   <li>{@link #DEFAULT}: The default label style.</li>
 *   <li>{@link #INLINE}: A label that should explicitly be displayed in-line
 *     with other UI elements.</li>
 *   <li>{@link #FORM}: A label that serves as a label for another UI element in
 *     a form panel.</li>
 *   <li>{@link #TITLE}: A title for other UI elements.</li>
 *   <li>{@link #BRAND}: A brand description, typically in the main navigation
 *     menu</li>
 *   <li>{@link #ICON}: The label text will be mapped to a corresponding
 *     icon.</li>
 *   <li>{@link #IMAGE}: The label text references an image file.</li>
 * </ul>
 */
public enum LabelStyle { DEFAULT, INLINE, FORM, TITLE, BRAND, ICON, IMAGE }
