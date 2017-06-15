//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// WorkflowManager2 Source File
// Copyright (c) 2017 by Thomas Kuechenthal / LEMARIT GmbH
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
package de.esoco.lib.ui.event;

/********************************************************************
 * Instances of this interface contain UI event information. There is no
 * hierarchical event tree, all event information will be propagated in these
 * objects. Which fields of an event actually contain information depends on the
 * type of event that occurred (e.g. pointer coordinates will only be available
 * from pointer-related events).
 *
 * @author eso
 */
public abstract class UiEvent
{
	//~ Instance fields --------------------------------------------------------

	private final Object	  rSource;
	private final Object	  rElement;
	private final UiEventType rEventType;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Internal constructor, instance creation is controlled by the factory
	 * method {@link #getEvent(Object, Object, UiEventType, int, int, UiKeyCode,
	 * UiModifierKeys)}.
	 *
	 * @param rSource  The source of the event
	 * @param rElement The element affected by this event or NULL for none
	 * @param rType    The event type
	 */
	private UiEvent(Object rSource, Object rElement, UiEventType rType)
	{
		this.rSource    = rSource;
		this.rElement   = rElement;
		this.rEventType = rType;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Cancels the event to prevent further processing. What exactly this call
	 * does and for which event types it has an effect depends on the underlying
	 * implementation. In general it can be assumed that it will work for input
	 * events like keyboard input and that it allows to prevent the input to go
	 * into the component that caused the event.
	 */
	public abstract void cancel();

	/***************************************
	 * Returns the typed character in case of keyboard events. For KEY_TYPED
	 * events this method will always return a valid character but for
	 * KEY_PRESSED and KEY_RELEASED events which can also occur for
	 * non-printable characters the result of this method will be zero.
	 *
	 * @return The typed character of the keyboard event or 0 (zero) if not
	 *         available
	 */
	public abstract char getKeyChar();

	/***************************************
	 * Returns the key code in case of KEY_PRESSED and KEY_RELEASED events. For
	 * KEY_TYPED events this method will always return KeyCode.NONE.
	 *
	 * @return The key code of the keyboard event or KeyCode.NONE if not
	 *         available
	 */
	public abstract UiKeyCode getKeyCode();

	/***************************************
	 * Return the state of the modifier keys at event time.
	 *
	 * @return One of the enumerated instances of the {@link UiModifierKeys}
	 *         class describing the modifier key states
	 */
	public abstract UiModifierKeys getModifiers();

	/***************************************
	 * Returns the pointer button that caused the pointer event.
	 *
	 * @return The number of the pointer button pressed, starting at 1
	 */
	public abstract int getPointerButton();

	/***************************************
	 * Returns the horizontal screen position of the pointer at event time (for
	 * pointer-related events).
	 *
	 * @return The horizontal pointer position or {@link Integer#MIN_VALUE} if
	 *         not available
	 */
	public abstract int getPointerX();

	/***************************************
	 * Returns the vertical screen position of the pointer at event time (for
	 * pointer-related events).
	 *
	 * @return The vertical pointer position or {@link Integer#MIN_VALUE} if not
	 *         available
	 */
	public abstract int getPointerY();

	/***************************************
	 * Returns TRUE if this event has been canceled by a previous call to the
	 * method {@link #cancel()}.
	 *
	 * @return TRUE if this event has been canceled
	 */
	public abstract boolean isCanceled();

	/***************************************
	 * Returns the element that is affected by this event. What exactly such an
	 * element is depends on the event source. Typically this will be an element
	 * of components that are composed of multiple elements, like lists or
	 * trees.
	 *
	 * @return The element affected by this event (NULL for none)
	 */
	public final Object getElement()
	{
		return rElement;
	}

	/***************************************
	 * Returns the object that caused this event.
	 *
	 * @return The event source
	 */
	public final Object getSource()
	{
		return rSource;
	}

	/***************************************
	 * Returns the type of this event.
	 *
	 * @return The event type
	 */
	public final UiEventType getType()
	{
		return rEventType;
	}

	/***************************************
	 * Returns a string description of this event.
	 *
	 * @return A string describing this instance
	 */
	@Override
	public String toString()
	{
		return "UiEvent[" + rEventType + ',' + rSource + ',' + getPointerX() +
			   ',' + getPointerY() + ',' + getModifiers() + ',' + getKeyCode() +
			   ']';
	}
}
