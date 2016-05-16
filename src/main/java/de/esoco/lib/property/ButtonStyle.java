package de.esoco.lib.property;

/********************************************************************
 * An enumeration of the possible styles for displaying UI buttons. Not all
 * styles may be supported by an UI implementation in which case it should
 * revert to a reasonable default if possible.
 *
 * <ul>
 *   <li>{@link #DEFAULT}: The default (push) button style.</li>
 *   <li>{@link #FLAT}: Display only the button outline.</li>
 *   <li>{@link #FLAT}: A flat display style.</li>
 *   <li>{@link #FLOAT}: Display button over other content.</li>
 *   <li>{@link #LINK}: Display buttons as (hyper-) links.</li>
 * </ul>
 */
public enum ButtonStyle { DEFAULT, OUTLINE, FLAT, FLOAT, LINK }