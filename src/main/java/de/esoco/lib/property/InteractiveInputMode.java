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
 * The possible input modes for interactive input elements. If set and supported
 * by the data element UI input will be sent to the server based on the input
 * mode value. If it is {@link #ACTION} the input will be sent each time a
 * specific input action occurs in the respective input user interface. The type
 * of action depends on the actual user interface component. It can be the press
 * of the enter key and/or a double click. If the mode is {@link #CONTINUOUS}
 * each input event (e.g. the change of a selection) will be sent back to the
 * server. The mode {@link #BOTH} combines action and continuous events.
 */
public enum InteractiveInputMode { ACTION, CONTINUOUS, BOTH }
