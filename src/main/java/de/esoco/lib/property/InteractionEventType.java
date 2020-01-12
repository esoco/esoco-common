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
 * Enumeration of abstract event types for user interface interactions. The
 * values are:
 *
 * <ul>
 *   <li>{@link #UPDATE}: The value of an element has been updated.</li>
 *   <li>{@link #ACTION}: An action has been triggered for an element.</li>
 *   <li>{@link #FOCUS_LOST}: An element has lost the input focus.</li>
 * </ul>
 */
public enum InteractionEventType { UPDATE, ACTION, FOCUS_LOST }
