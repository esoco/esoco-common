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
 * An enumeration of the possible styles for displaying UI check boxes. Not all
 * styles may be supported by an UI implementation in which case it should
 * revert to a reasonable default if possible.
 *
 * <ul>
 *   <li>{@link #DEFAULT}: The default check box style.</li>
 *   <li>{@link #SOLID}: A solid display style.</li>
 *   <li>{@link #SWITCH}: Display as a on/off switch.</li>
 * </ul>
 */
public enum CheckBoxStyle { DEFAULT, SOLID, SWITCH }
