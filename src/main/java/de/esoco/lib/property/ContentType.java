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
 * An indication of the type of content stored by an element that will influence
 * the rendering of the content. What exactly that means and which content types
 * are supported depends on the respective element implementation. The following
 * types are available:
 *
 * <ul>
 *   <li>{@link #HTML}: HTML code that should be rendered as such.</li>
 *   <li>{@link #PHONE_NUMBER}: a phone number.</li>
 *   <li>{@link #PROGRESS}: a value that indicates the progress of an
 *     operation.</li>
 *   <li>{@link #DATE_TIME}: a date value of which the time should also be
 *     displayed.</li>
 *   <li>{@link #WEBSITE}: a URL to be displayed in-line.</li>
 *   <li>{@link #HYPERLINK}: a URI to be visualized as a hyperlink.</li>
 *   <li>{@link #RELATIVE_URL}: a URL which is relative to the current context
 *     (and therefore possibly needs to be expanded into an absolute URL).</li>
 *   <li>{@link #ABSOLUTE_URL}: a URL which is independent of the current
 *     context.</li>
 *   <li>{@link #FILE_UPLOAD}: the content will be created from a file
 *     upload.</li>
 * </ul>
 */
public enum ContentType {
	HTML, PHONE_NUMBER, PROGRESS, DATE_TIME, WEBSITE, HYPERLINK, RELATIVE_URL,
	ABSOLUTE_URL, FILE_UPLOAD
}
