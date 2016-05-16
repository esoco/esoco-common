package de.esoco.lib.property;

/********************************************************************
 * The possible input modes for interactive input elements. If set and
 * supported by the data element UI input will be sent to the server based
 * on the input mode value. If it is {@link #ACTION} the input will be sent
 * each time a specific input action occurs in the respective input user
 * interface. The type of action depends on the actual user interface
 * component. It can be the press of the enter key and/or a double click. If
 * the mode is {@link #CONTINUOUS} each input event (e.g. the change of a
 * selection) will be sent back to the server. The mode {@link #BOTH}
 * combines action and continuous events.
 */
public enum InteractiveInputMode { NONE, ACTION, CONTINUOUS, BOTH }