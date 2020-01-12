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
 * An enumeration of the possible styles for displaying UI navigation menus. Not
 * all styles may be supported by an UI implementation in which case it should
 * revert to a reasonable default if possible. Typically for the types other
 * than {@link #FIXED} some kind of activator (menu button) must exist in the
 * UI.
 *
 * <ul>
 *   <li>{@link #FIXED}: A fixed menu that is always visible.</li>
 *   <li>{@link #CARD}: A menu card that is just as big as the menu
 *     content.</li>
 *   <li>{@link #PUSH}: A menu that pushes the other UI aside on
 *     appearance.</li>
 *   <li>{@link #PUSH_CONTENT}: A menu that pushes the other UI content aside on
 *     appearance but not the header.</li>
 *   <li>{@link #OVERLAY}: A menu that overlays the other UI.</li>
 *   <li>{@link #OVERLAY_CONTENT}: A menu that overlays the other UI content but
 *     not the header.</li>
 *   <li>{@link #SMALL}: A small menu that typically only contains icons.</li>
 *   <li>{@link #SMALL_EXPANDING}: A fixed small menu that only contains icons
 *     but expands to a larger menu with text.</li>
 * </ul>
 */
public enum NavigationMenuStyle {
	FIXED, CARD, PUSH, PUSH_CONTENT, OVERLAY, OVERLAY_CONTENT, SMALL,
	SMALL_EXPANDING
}
