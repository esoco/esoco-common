//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'gewt' project.
// Copyright 2015 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
package de.esoco.lib.ui.event;

import de.esoco.lib.text.TextConvert;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;


/********************************************************************
 * Enumerated values that describe the possible key codes of keyboard events.
 *
 * @author eso
 */
@SuppressWarnings("boxing")
public enum UiKeyCode
{
	// --- Special Keys -------------------------------

	NONE(0), UNKNOWN(0), SHIFT(16), CAPS_LOCK(20), CONTROL(17), ALT(18),
	META(91), CONTEXT_MENU(93), ENTER(13), ESCAPE(27), BACKSPACE(8), DELETE(46),
	INSERT(45), TAB(9), HOME(36), END(35), PAGE_UP(33), PAGE_DOWN(34), DOWN(40),
	UP(38), LEFT(37), RIGHT(39), NUM_LOCK(144), SCROLL_LOCK(145),
	PRINT_SCREEN(44), PAUSE(19),

	// --- Printable characters -----------------------

	SPACE(' '), A('A'), B('B'), C('C'), D('D'), E('E'), F('F'), G('G'), H('H'),
	I('I'), J('J'), K('K'), L('L'), M('M'), N('N'), O('O'), P('P'), Q('Q'),
	R('R'), S('S'), T('T'), U('U'), V('V'), W('W'), X('X'), Y('Y'), Z('Z'),

	// --- Numbers ------------------------------------

	KEY_0('0'), KEY_1('1'), KEY_2('2'), KEY_3('3'), KEY_4('4'), KEY_5('5'),
	KEY_6('6'), KEY_7('7'), KEY_8('8'), KEY_9('9'),

	// --- Numeric keypad -----------------------------

	NUMPAD_0(96), NUMPAD_1(97), NUMPAD_2(98), NUMPAD_3(99), NUMPAD_4(100),
	NUMPAD_5(101), NUMPAD_6(102), NUMPAD_7(103), NUMPAD_8(104), NUMPAD_9(105),
	NUMPAD_DIVIDE(111), NUMPAD_MULTIPLY(106), NUMPAD_MINUS(109),
	NUMPAD_PLUS(107), NUMPAD_ENTER(0), NUMPAD_DECIMAL(110),

	// --- Special characters -------------------------

	COMMA(','), PERIOD('.'), COLON(':'), EXCLAMATION_MARK('!'),
	DOUBLE_QUOTE('"'), SINGLE_QUOTE('\''), PARAGRAPH('\u00A7'), DOLLAR('$'),
	PERCENT('%'), AMPERSAND('&'), LEFT_PARENTHESIS('('), RIGHT_PARENTHESIS(')'),
	EQUALS('='), PLUS('+'), MINUS('-'), STAR('*'), DIVIDE('/'), POUND('#'),
	BACKSLASH('\\'), SEMICOLON(';'), UNDERSCORE('_'), TILDE('~'), AT('@'),
	LESS('<'), GREATER('>'), ACUTE('\u00B4'), CIRCUMFLEX('^'),

	// --- Function Keys ------------------------------

	F1(112), F2(113), F3(114), F4(115), F5(116), F6(117), F7(118), F8(119),
	F9(120), F10(121), F11(122), F12(123), F13(124), F14(125), F15(126);

	/** A set containing all function key codes */
	public static final EnumSet<UiKeyCode> FUNCTION_KEYS =
		EnumSet.of(F1,
				   F2,
				   F3,
				   F4,
				   F5,
				   F6,
				   F7,
				   F8,
				   F9,
				   F10,
				   F11,
				   F12,
				   F13,
				   F14,
				   F15);

	private static Map<Integer, UiKeyCode>   KEYCODE_MAP =
		new HashMap<Integer, UiKeyCode>();
	private static Map<Character, UiKeyCode> KEYCHAR_MAP =
		new HashMap<Character, UiKeyCode>();

	static
	{
		// Initialization of reverse lookup maps

		for (UiKeyCode rKeyCode : UiKeyCode.values())
		{
			if (rKeyCode.cKeyChar != 0)
			{
				Object o = KEYCHAR_MAP.put(rKeyCode.cKeyChar, rKeyCode);

				assert o == null : "Duplicate mapping of char " +
					   rKeyCode.cKeyChar + " in " + o + " & " + rKeyCode;
			}
			else if (rKeyCode.nKeyCode != 0)
			{
				Object o = KEYCODE_MAP.put(rKeyCode.nKeyCode, rKeyCode);

				assert o == null : "Duplicate mapping of code " +
					   rKeyCode.cKeyChar + " in " + o + " & " + rKeyCode;
			}
		}
	}

	private final int  nKeyCode;
	private final char cKeyChar;

	/***************************************
	 * Creates a new instance that is not associated with a printable character.
	 *
	 * @param nCode The integer key code or zero if unknown
	 */
	private UiKeyCode(int nCode)
	{
		nKeyCode = nCode;
		cKeyChar = 0;
	}

	/***************************************
	 * Creates a new instance that is associated with a certain (printable)
	 * character.
	 *
	 * @param cKey The character to be associated with this instance
	 */
	private UiKeyCode(char cKey)
	{
		cKeyChar = cKey;
		nKeyCode = 0;
	}

	/***************************************
	 * Allows to retrieve the KeyCode instance that is associated with a certain
	 * (printable) character. If no such association exist this method will
	 * return NULL. The argument character is always converted to upper case
	 * prior to the lookup.
	 *
	 * @param  cKey The character to lookup the key code for
	 *
	 * @return The matching KeyCode instance or NULL if no association exists
	 */
	public static UiKeyCode forChar(char cKey)
	{
		return KEYCHAR_MAP.get(Character.toUpperCase(cKey));
	}

	/***************************************
	 * Allows to retrieve the KeyCode instance that is associated with a certain
	 * integer key code. If no such association exist this method will return
	 * NULL.
	 *
	 * @param  nCode Key The integer code to lookup the key code for
	 *
	 * @return The matching KeyCode instance or NULL if no association exists
	 */
	public static UiKeyCode forCode(int nCode)
	{
		return KEYCODE_MAP.get(nCode);
	}

	/***************************************
	 * Returns the character value for a certain key code. This method exists
	 * mainly to provide a compatible way to convert key codes on different EWT
	 * versions.
	 *
	 * @param  rKeyCode The key to convert to a character
	 *
	 * @return The resulting character value
	 *
	 * @see    #getChar()
	 */
	public static char toChar(UiKeyCode rKeyCode)
	{
		return rKeyCode.getChar();
	}

	/***************************************
	 * Returns the (printable) character value that is associated with this key
	 * code. This is not necessarily the same character that has been input on
	 * the keyboard. Instead, it represents the keyboard key that has been
	 * pressed. For example, if the input value is 'a', the key character
	 * returned by this method will be 'A'. If no such character exists the
	 * returned value is 0 (zero).
	 *
	 * @return The character value associated with the key code
	 */
	public final char getChar()
	{
		return cKeyChar;
	}

	/***************************************
	 * Returns the digit key.
	 *
	 * @return The digit key
	 */
	public boolean isDigitKey()
	{
		return (nKeyCode >= NUMPAD_0.nKeyCode &&
				nKeyCode <= NUMPAD_9.nKeyCode) ||
			   (cKeyChar >= '0' && cKeyChar <= '9');
	}

	/***************************************
	 * Returns a resource string representing this key code instance. If this
	 * key code has either an associated character (and is not SPACE) or is a
	 * function key it will be returned. Otherwise a resource key will be
	 * constructed from the capitalized instance name prefixed with "$Key". For
	 * example, the resource string for the instance PAGE_UP will be
	 * "$KeyPageUp", for SPACE it will be "$KeySpace". The resource string for A
	 * will simply be "A".
	 *
	 * @return The resource string for this key code
	 */
	public String toResourceString()
	{
		StringBuilder sb = new StringBuilder();

		if (this != SPACE && cKeyChar != 0)
		{
			sb.append(cKeyChar);
		}
		else if (FUNCTION_KEYS.contains(this))
		{
			sb.append(this);
		}
		else
		{
			sb.append('$').append("Key")
			  .append(TextConvert.capitalizedIdentifier(name()));
		}

		return sb.toString();
	}
}
