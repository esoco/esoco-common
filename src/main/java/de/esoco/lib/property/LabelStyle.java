package de.esoco.lib.property;

/********************************************************************
 * An enumeration of the styles for displaying UI labels. Not all styles may
 * be supported by an UI implementation in which case it should revert to a
 * reasonable default if possible.
 *
 * <ul>
 *   <li>{@link #DEFAULT}: The default label style.</li>
 *   <li>{@link #INLINE}: A label that should explicitly be displayed
 *     in-line with other UI elements.</li>
 *   <li>{@link #FORM}: A label that serves as a label for another UI
 *     element in a form panel.</li>
 *   <li>{@link #TITLE}: A title for other UI elements.</li>
 *   <li>{@link #BRAND}: A brand description, typically in the main
 *     navigation menu</li>
 *   <li>{@link #ICON}: The label text will be mapped to a corresponding
 *     icon.</li>
 * </ul>
 */
public enum LabelStyle { DEFAULT, INLINE, FORM, TITLE, BRAND, ICON }