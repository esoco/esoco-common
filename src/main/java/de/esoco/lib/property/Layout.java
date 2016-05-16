package de.esoco.lib.property;

/********************************************************************
 * Enumeration of the layouts for UI element containers. The layout defines
 * how elements will be arranged in the generated user interface. Not all
 * layouts may be supported by an implementation but in that case it should
 * fall back to a reasonable default placement of elements. The possible
 * values are:
 *
 * <ul>
 *   <li>{@link #TABLE}: Data elements are placed in the cells of a
 *     table-like structure.</li>
 *   <li>{@link #DOCK}: Elements are arranged around the edges of a center
 *     element. The size and orientation (horizontal or vertical) of the
 *     surrounding must be set as UI properties.</li>
 *   <li>{@link #SPLIT}: Like {@link #DOCK} but with resizable side areas.
 *   </li>
 *   <li>{@link #TABS}: A panel with selectable tabs for each contained data
 *     element.</li>
 *   <li>{@link #STACK}: Like {@link #TABS} but arranged as a vertical stack
 *     of collapsing stacks for each element child.</li>
 *   <li>{@link #DECK}: Like {@link #TABS} but without an UI for selecting
 *     child elements. Selection must occur programmatically.</li>
 *   <li>{@link #FILL}: A single UI elements fills the available area.</li>
 *   <li>{@link #FLOW}: UI elements flow in the natural order defined by the
 *     UI context.</li>
 *   <li>{@link #GRID}: Like FLOW but elements are placed in a grid
 *     structure according to their properties.</li>
 *   <li>{@link #GRID_ROW}: A row in a {@link #GRID} layout.</li>
 *   <li>{@link #GRID_COLUMN}: A column in a {@link #GRID_ROW}.</li>
 *   <li>{@link #LIST}: Places elements in a list.</li>
 *   <li>{@link #LIST_ITEM}: A single element in a {@link #LIST}
 *     layout.</li>
 *   <li>{@link #CARD}: A structured card with specific elements like title,
 *     content, actions.</li>
 *   <li>{@link #FORM}: Arranges elements according to their properties like
 *     in a {@link #GRID} but in some implementations (e.g. HTML-based) with
 *     a structure that defines an explicit input form.</li>
 *   <li>{@link #GROUP}: Arranges elements in a distinctive group, typically
 *     inside a {@link #FORM}.</li>
 *   <li>{@link #MENU}: A menu or some other kind of navigation
 *     structure.</li>
 *   <li>{@link #HEADER}: The header area of an application.</li>
 *   <li>{@link #CONTENT}: The main content area of an application.</li>
 *   <li>{@link #FOOTER}: The footer area of an application.</li>
 *   <li>{@link #INLINE}: Do not use a separate layout for this element but
 *     render it in-line with it's parent.</li>
 * </ul>
 */
public enum Layout
{
	TABLE, DOCK, SPLIT, TABS, STACK, DECK, FILL, FLOW, GRID, GRID_ROW,
	GRID_COLUMN, LIST, LIST_ITEM, CARD, FORM, GROUP, MENU, HEADER, CONTENT,
	FOOTER, INLINE
}