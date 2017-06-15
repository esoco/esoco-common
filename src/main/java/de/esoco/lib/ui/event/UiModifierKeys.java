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

/********************************************************************
 * An enumeration of keyboard modifiers and their combinations.
 *
 * @author eso
 */
public enum UiModifierKeys
{
	// Attention: the order (and therefore the enum ordinal number) represents
	// the bit combination for the modifiers and must not be changed
	NONE, SHIFT, CTRL, SHIFT_CTRL, ALT, SHIFT_ALT, CTRL_ALT, SHIFT_CTRL_ALT,
	META, SHIFT_META, CTRL_META, SHIFT_CTRL_META, ALT_META, SHIFT_ALT_META,
	CTRL_ALT_META, SHIFT_CTRL_ALT_META;

	//~ Static fields/initializers ---------------------------------------------

	/** Shift key */
	public static final int SHIFT_BIT = 0x01;

	/** Ctrl key */
	public static final int CTRL_BIT = 0x02;

	/** Alt key */
	public static final int ALT_BIT = 0x04;

	/** Meta key */
	public static final int META_BIT = 0x08;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance for a particular combination of modifier bits.
	 */
	private UiModifierKeys()
	{
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Returns the corresponding singleton instance for a certain combination of
	 * modifier bits.
	 *
	 * @param  nBits The modifier bits of the instance
	 *
	 * @return The corresponding instance
	 */
	public static UiModifierKeys valueOf(int nBits)
	{
		return values()[nBits];
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Checks if this modifiers instance contains all the bits of another
	 * modifiers instance, e.g. contains(ModifierKeys.SHIFT).
	 *
	 * @param  rOther The other instance to compare with
	 *
	 * @return TRUE if this instance contains the other
	 */
	public boolean contains(UiModifierKeys rOther)
	{
		return (ordinal() & rOther.ordinal()) == rOther.ordinal();
	}

	/***************************************
	 * Returns a string representation of this modifier combination by
	 * concatenating the string representations of all modifier bits in a fixed
	 * order (Shift, Ctrl, Alt, Meta). Between each bit string the separator
	 * string will be inserted.
	 *
	 * @param  sSeparator The separator string to insert between the bits
	 *
	 * @return The string representing this modifier combination
	 */
	public String toString(String sSeparator)
	{
		StringBuilder sb = new StringBuilder();

		if ((ordinal() & SHIFT_BIT) != 0)
		{
			sb.append("Shift").append(sSeparator);
		}

		if ((ordinal() & CTRL_BIT) != 0)
		{
			sb.append("Ctrl").append(sSeparator);
		}

		if ((ordinal() & ALT_BIT) != 0)
		{
			sb.append("Alt").append(sSeparator);
		}

		if ((ordinal() & META_BIT) != 0)
		{
			sb.append("Meta").append(sSeparator);
		}

		if (sb.length() > 0)
		{
			sb.setLength(sb.length() - sSeparator.length());
		}

		return sb.toString();
	}
}
