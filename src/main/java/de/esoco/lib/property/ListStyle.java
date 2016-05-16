package de.esoco.lib.property;

/********************************************************************
 * The style in which list elements should be displayed. The following
 * values are available:
 *
 * <ul>
 *   <li>{@link #LIST}: a (scrollable) list with selectable elements.</li>
 *   <li>{@link #DROP_DOWN}: a drop-down box that displays only the
 *     currently selected element.</li>
 *   <li>{@link #EDITABLE}: an input field that displays list of suggested
 *     values.</li>
 *   <li>{@link #DISCRETE}: separate controls for each element (e.g. radio
 *     buttons or checkboxes)</li>
 *   <li>{@link #IMMEDIATE}: separate controls for each element that.
 *     immediately cause an action when selected (e.g. buttons or
 *     hyperlinks).</li>
 * </ul>
 */
public enum ListStyle { LIST, DROP_DOWN, EDITABLE, DISCRETE, IMMEDIATE }