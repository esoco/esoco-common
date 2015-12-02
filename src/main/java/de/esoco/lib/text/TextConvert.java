//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
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
package de.esoco.lib.text;

/********************************************************************
 * A utility class that contains static methods for text conversions.
 *
 * @author eso
 */
public class TextConvert
{
	//~ Static fields/initializers ---------------------------------------------

	/** A default separator string between collection elements (','). */
	public static final String DEFAULT_COLLECTION_SEPARATOR = ",";

	/** A default separator string between map keys and values ('='). */
	public static final String DEFAULT_KEY_VALUE_SEPARATOR = "=";

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Package-internal, only static method use.
	 */
	TextConvert()
	{
	}

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * Creates a capitalized string. This is done by splitting the input string
	 * at whitespace (regular expression '\s'), underscores ('_'), or dots and
	 * concatenating the resulting words capitalized and separated by the given
	 * separator string.
	 *
	 * @param  sText      The input string
	 * @param  sSeparator The separator string or NULL for none
	 *
	 * @return The capitalized identifier string
	 */
	public static String capitalize(String sText, String sSeparator)
	{
		return capitalize(sText, sSeparator, false);
	}

	/***************************************
	 * Creates a capitalized string. This is done by splitting the input string
	 * at whitespace (regular expression '\s'), underscores ('_'), or dots and
	 * concatenating the resulting words capitalized and separated by the given
	 * separator string.
	 *
	 * @param  sText               The input string
	 * @param  sSeparator          The separator string or NULL for none
	 * @param  bFirstWordLowerCase TRUE to keep the first word in lower case
	 *
	 * @return The capitalized identifier string
	 */
	public static String capitalize(String  sText,
									String  sSeparator,
									boolean bFirstWordLowerCase)
	{
		if (sText != null)
		{
			StringBuilder aResult = new StringBuilder(sText.length());

			String[] aWords = sText.split("[\\s_.]");
			int		 nLast  = aWords.length - 1;

			for (int i = 0; i <= nLast; i++)
			{
				String sWord = aWords[i];

				if (i > 0 || !bFirstWordLowerCase)
				{
					aResult.append(capitalizedWord(sWord));
				}
				else
				{
					aResult.append(sWord.toLowerCase());
				}

				if (sSeparator != null && i < nLast)
				{
					aResult.append(sSeparator);
				}
			}

			sText = aResult.toString();
		}

		return sText;
	}

	/***************************************
	 * Creates a capitalized identifier from a string. This method invokes
	 * {@link #capitalize(String, String)} without a separator string. If the
	 * input string has the correct format already it will be returned
	 * unchanged. The counterpart is {@link #uppercaseIdentifier(String)}.
	 *
	 * <p>Examples:</p>
	 *
	 * <ul>
	 *   <li>'foo bar' becomes FooBar</li>
	 *   <li>FOO_BAZ_BAR becomes FooBazBar</li>
	 * </ul>
	 *
	 * @param  sIdentifier The string to create the identifier from
	 *
	 * @return The capitalized identifier string
	 */
	public static String capitalizedIdentifier(String sIdentifier)
	{
		if (sIdentifier != null && !sIdentifier.matches("([A-Z][a-z0-9]+)*"))
		{
			sIdentifier = capitalize(sIdentifier, null);
		}

		return sIdentifier;
	}

	/***************************************
	 * Shortcut method that returns the {@link #capitalizedIdentifier(String)}
	 * after applying {@link #lastElementOf(String)} to an input string.
	 *
	 * @param  sInput The input string
	 *
	 * @return The resulting identifier
	 */
	public static String capitalizedLastElementOf(String sInput)
	{
		return capitalizedIdentifier(lastElementOf(sInput));
	}

	/***************************************
	 * Capitalizes a word.
	 *
	 * @param  sWord The word to capitalize
	 *
	 * @return sWord[0].toUpperCase + sWord[1..length-1].toLowerCase
	 */
	public static String capitalizedWord(String sWord)
	{
		if (sWord.length() > 0)
		{
			sWord =
				sWord.substring(0, 1).toUpperCase() +
				sWord.substring(1).toLowerCase();
		}

		return sWord;
	}

	/***************************************
	 * To convert a integer value between 0 and 15 into the corresponding
	 * character of the hexadecimal representation (0-9,A-F). This method is
	 * very simple and does no validation so that using values outside the
	 * allowed range will yield no reasonable result.
	 *
	 * @param  nValue The value to convert, in the range 0 to 15
	 *
	 * @return The corresponding hex character (letters are upper case)
	 */
	public static char hexChar(int nValue)
	{
		return (char) ((nValue < 10) ? (48 + nValue) : (55 + nValue));
	}

	/***************************************
	 * To create a hexadecimal string representation of a byte array. Each byte
	 * will be displayed as a two-character upper case hexadecimal value. The
	 * two-char values will be separated by the given fill string. The size of
	 * the resulting string will be <code>(rBytes.length x (2 + sFill.length())
	 * - sFill.length()</code> .
	 *
	 * @param  rBytes The byte array to display (the values will not be changed)
	 * @param  sFill  A String to be inserted between the two-char hex values
	 *
	 * @return The resulting hexadecimal string
	 */
	public static String hexString(byte[] rBytes, String sFill)
	{
		return hexString(rBytes, 0, rBytes.length, sFill);
	}

	/***************************************
	 * To create a hexadecimal string representation of a byte array. Each byte
	 * will be displayed as a two-character upper case hexadecimal value. The
	 * two-char values will be separated by the given fill string. The size of
	 * the resulting string will be <code>(rBytes.length x (2 + sFill.length())
	 * - sFill.length()</code> .
	 *
	 * <p>The method will always read a maximum of (rBytes.length - nOffset)
	 * bytes from the array even if the value of nOffset + nCount is larger.</p>
	 *
	 * @param  rBytes  The byte array to display (the values will not be
	 *                 changed)
	 * @param  nOffset The position to start reading bytes from
	 * @param  nCount  The number of bytes to display
	 * @param  sFill   A String to be inserted between the two-char hex values
	 *
	 * @return The resulting hexadecimal string
	 */
	public static String hexString(byte[] rBytes,
								   int    nOffset,
								   int    nCount,
								   String sFill)
	{
		nCount = Math.min(nCount, rBytes.length - nOffset);

		int			  max    = nOffset + nCount;
		int			  length = (sFill.length() + 2) * nCount;
		StringBuilder buf    = new StringBuilder(length);

		for (int i = nOffset; i < max; i++)
		{
			byte b = rBytes[i];

			buf.append(hexChar((b >> 4) & 0x0F));
			buf.append(hexChar(b & 0x0F));
			buf.append(sFill);
		}

		buf.setLength(length - sFill.length());

		return buf.toString();
	}

	/***************************************
	 * Extracts the last element of a string that is separated by dots ('.'). If
	 * the input string does not contain dots it is returned unchanged.
	 *
	 * @param  sInput The input string
	 *
	 * @return The resulting string
	 */
	public static String lastElementOf(String sInput)
	{
		return sInput.substring(sInput.lastIndexOf('.') + 1);
	}

	/***************************************
	 * To return a right-aligned string with a certain maximum length. If the
	 * string's length is less than the target length it will be aligned to the
	 * right of the resulting string and the left will be filled with the given
	 * fill character.
	 *
	 * @param  sString The string to be converted
	 * @param  nWidth  The length of the result string
	 * @param  cFill   The fill character
	 *
	 * @return The resulting string
	 */
	public static String padLeft(String sString, int nWidth, char cFill)
	{
		if (nWidth > sString.length())
		{
			StringBuilder sb = new StringBuilder(nWidth);

			for (int i = sString.length(); i < nWidth; i++)
			{
				sb.append(cFill);
			}

			sb.append(sString);
			sb.setLength(nWidth);

			return sb.toString();
		}
		else
		{
			return sString;
		}
	}

	/***************************************
	 * To return a left-aligned string with a certain maximum length. If the
	 * string's length is less than the target length it will be aligned to the
	 * left of the resulting string and the right will be filled with the given
	 * fill character.
	 *
	 * @param  sString The string to be converted
	 * @param  nWidth  The length of the result string
	 * @param  cFill   The fill character
	 *
	 * @return The resulting string
	 */
	public static String padRight(String sString, int nWidth, char cFill)
	{
		if (nWidth > sString.length())
		{
			StringBuilder sb = new StringBuilder(nWidth);

			sb.append(sString);

			for (int i = sString.length(); i < nWidth; i++)
			{
				sb.append(cFill);
			}

			return sb.toString();
		}
		else
		{
			return sString;
		}
	}

	/***************************************
	 * Returns the English plural of a certain name.
	 *
	 * @param  sName The name to convert
	 *
	 * @return The resulting plural name
	 */
	public static String toPlural(String sName)
	{
		sName = sName.substring(sName.lastIndexOf('.') + 1);

		if (sName.endsWith("y"))
		{
			sName =  sName.substring(0, sName.length() - 1);
			sName += "ies";
		}
		else if (sName.endsWith("s"))
		{
			sName += "es";
		}
		else
		{
			sName += "s";
		}

		return sName;
	}

	/***************************************
	 * Decodes all occurrences of the Java and JavaScript unicode escape
	 * representation with the un-escaped token.
	 *
	 * @param  sValue The value string to escape the occurrences of
	 * @param  sToken The separator string to escape
	 *
	 * @return The escaped string
	 */
	public static String unicodeDecode(String sValue, String sToken)
	{
		return sValue.replaceAll(unicodeEncode(sToken), sToken);
	}

	/***************************************
	 * Encodes each character of a string with it's unicode escape sequence.
	 *
	 * @param  sValue The value to encode
	 *
	 * @return The encoded value
	 */
	public static String unicodeEncode(String sValue)
	{
		StringBuilder aEncodedValue = new StringBuilder();
		int			  nLength	    = sValue.length();

		for (int i = 0; i < nLength; i++)
		{
			int nTokenChar = sValue.charAt(i);

			aEncodedValue.append("\\\\u");
			aEncodedValue.append(hexChar(nTokenChar >> 12 & 0x0F));
			aEncodedValue.append(hexChar(nTokenChar >> 8 & 0x0F));
			aEncodedValue.append(hexChar(nTokenChar >> 4 & 0x0F));
			aEncodedValue.append(hexChar(nTokenChar & 0x0F));
		}

		return aEncodedValue.toString();
	}

	/***************************************
	 * Encodes all occurrences of a token string in a value string with their
	 * Java and JavaScript unicode escape representation.
	 *
	 * @param  sValue The value string to escape the occurrences of
	 * @param  sToken The separator string to escape
	 *
	 * @return The escaped string
	 */
	public static Object unicodeEncode(String sValue, String sToken)
	{
		int nPos = sValue.indexOf(sToken);

		if (nPos >= 0)
		{
			sValue = sValue.replaceAll(sToken, unicodeEncode(sToken));
		}

		return sValue;
	}

	/***************************************
	 * Creates an upper case identifier from a string. This is done by inserting
	 * underscores ('_') at single upper case letters or after sequences of such
	 * and by converting the resulting string to upper case. Whitespace
	 * characters will also be replaced with underscores. This method is the
	 * counterpart to {@link #capitalizedIdentifier(String)}.
	 *
	 * <p>Examples:</p>
	 *
	 * <ul>
	 *   <li>Foobar, foobar, and FOOBAR become FOOBAR</li>
	 *   <li>FooBar becomes FOO_BAR</li>
	 *   <li>aFooBar becomes A_FOO_BAR</li>
	 *   <li>FooBAZBar becomes FOO_BAZ_BAR</li>
	 *   <li>Foo_Bar becomes FOO_BAR</li>
	 *   <li>Foo Bar becomes FOO_BAR</li>
	 * </ul>
	 *
	 * @param  sIdentifier The string to create the upper case identifier from
	 *
	 * @return The upper case identifier string
	 */
	public static String uppercaseIdentifier(String sIdentifier)
	{
		String		  s		 = sIdentifier.replaceAll("\\s", "_");
		StringBuilder sb     = new StringBuilder(s.length() + 5);
		int			  nMax   = s.length() - 1;
		int			  nStart = 0;
		boolean		  bSkip  = false;

		for (int nPos = 0; nPos <= nMax; nPos++)
		{
			char    c	   = s.charAt(nPos);
			boolean bSplit = Character.isUpperCase(c);

			if (bSplit && (nPos - nStart) > 0)
			{
				if (!bSkip ||
					(nPos < nMax && Character.isLowerCase(s.charAt(nPos + 1))))
				{
					sb.append(s.substring(nStart, nPos));

					if (sb.charAt(sb.length() - 1) != '_')
					{
						sb.append('_');
					}

					nStart = nPos;
				}
			}

			// do not split at sequences of uppercase letters and also skip
			// underscores or digits in such sequences
			bSkip = (bSplit || (bSkip && (c == '_' || Character.isDigit(c))));
		}

		sb.append(s.substring(nStart));

		return sb.toString().toUpperCase();
	}
}
