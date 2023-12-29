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
package de.esoco.lib.text;

import java.util.Arrays;
import java.util.Collection;

/**
 * A utility class that contains static methods for text conversions.
 *
 * @author eso
 */
public class TextConvert {

	/**
	 * Enumeration of the styles for the conversion of identifier strings.
	 *
	 * <ul>
	 *   <li>{@link #CAMELCASE}: Concatenated words, all starting with an
	 *     uppercase letter.</li>
	 *   <li>{@link #LOWER_CAMELCASE}: Like camel case but with a lowercase
	 *     first letter of the first word.</li>
	 *   <li>{@link #UPPERCASE}: All letters uppercase, words separated by
	 *     underscores.</li>
	 * </ul>
	 */
	public enum IdentifierStyle {CAMELCASE, LOWER_CAMELCASE, UPPERCASE}

	/**
	 * A default separator string between collection elements (',').
	 */
	public static final String DEFAULT_COLLECTION_SEPARATOR = ",";

	/**
	 * A default separator string between map keys and values ('=').
	 */
	public static final String DEFAULT_KEY_VALUE_SEPARATOR = "=";

	/**
	 * Package-internal, only static method use.
	 */
	TextConvert() {
	}

	/**
	 * Creates a capitalized string. This is done by splitting the input string
	 * at whitespace (regular expression '\s'), underscores ('_'), or dots and
	 * concatenating the resulting words capitalized and separated by the given
	 * separator string.
	 *
	 * @param text      The input string
	 * @param separator The separator string or NULL for none
	 * @return The capitalized identifier string
	 */
	public static String capitalize(String text, String separator) {
		return capitalize(text, separator, false);
	}

	/**
	 * Creates a capitalized string. This is done by splitting the input string
	 * at whitespace (regular expression '\s'), underscores ('_'), or dots and
	 * concatenating the resulting words capitalized and separated by the given
	 * separator string.
	 *
	 * @param text               The input string
	 * @param separator          The separator string or NULL for none
	 * @param firstWordLowerCase TRUE to keep the first word in lower case
	 * @return The capitalized identifier string
	 */
	public static String capitalize(String text, String separator,
		boolean firstWordLowerCase) {
		if (text != null) {
			StringBuilder result = new StringBuilder(text.length());

			String[] words = text.split("[\\s_.]");
			int last = words.length - 1;

			for (int i = 0; i <= last; i++) {
				String word = words[i];

				if (i > 0 || !firstWordLowerCase) {
					result.append(capitalizedWord(word));
				} else {
					result.append(word.toLowerCase());
				}

				if (separator != null && i < last) {
					result.append(separator);
				}
			}

			text = result.toString();
		}

		return text;
	}

	/**
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
	 * @param identifier The string to create the identifier from
	 * @return The capitalized identifier string
	 */
	public static String capitalizedIdentifier(String identifier) {
		if (identifier != null && !identifier.matches("([A-Z][a-z0-9]+)*")) {
			identifier = capitalize(identifier, null);
		}

		return identifier;
	}

	/**
	 * Shortcut method that returns the {@link #capitalizedIdentifier(String)}
	 * after applying {@link #lastElementOf(String)} to an input string.
	 *
	 * @param input The input string
	 * @return The resulting identifier
	 */
	public static String capitalizedLastElementOf(String input) {
		return capitalizedIdentifier(lastElementOf(input));
	}

	/**
	 * Capitalizes a word.
	 *
	 * @param word The word to capitalize
	 * @return word[0].toUpperCase + word[1..length-1].toLowerCase
	 */
	public static String capitalizedWord(String word) {
		if (!word.isEmpty()) {
			word = word.substring(0, 1).toUpperCase() +
				word.substring(1).toLowerCase();
		}

		return word;
	}

	/**
	 * Converts an identifier into a different naming style.
	 *
	 * @param style      The style to convert to
	 * @param identifier The identifier to convert
	 * @return The converted identifier
	 */
	public static String convertTo(IdentifierStyle style, String identifier) {
		switch (style) {
			case CAMELCASE:
				return capitalizedIdentifier(identifier);

			case LOWER_CAMELCASE:
				identifier = capitalizedIdentifier(identifier);

				return Character.toLowerCase(identifier.charAt(0)) +
					identifier.substring(1);

			case UPPERCASE:
				return uppercaseIdentifier(identifier);

			default:
				return identifier;
		}
	}

	/**
	 * A varargs variant of {@link #format(String, Collection)}.
	 *
	 * @see #format(String, Collection)
	 */
	public static String format(String format, Object... args) {
		return format(format, Arrays.asList(args));
	}

	/**
	 * A simplified version of {@link String#format(String, Object...)} that is
	 * also available in constrained environments like GWT but only supports
	 * string values. It replaces all occurrences of placeholders (%s) with the
	 * toString() representations of the argument objects. Placeholders may be
	 * indexed (e.g. %1$s) in which case they can also occur multiple times. If
	 * not enough placeholders occur in the text string any surplus values will
	 * be ignored.
	 *
	 * @param format The format string
	 * @param args   The values to place in the format string
	 * @return The formatted result string
	 */
	public static String format(String format, Collection<Object> args) {
		int index = 0;

		for (Object arg : args) {
			String indexedPlaceholder = "%" + index++ + "$s";
			String value = (arg != null ? arg.toString() : "null");

			if (format.contains(indexedPlaceholder)) {
				format = format.replace(indexedPlaceholder, value);
			} else {
				format = format.replaceFirst("%s", value);
			}
		}

		return format;
	}

	/**
	 * To convert a integer value between 0 and 15 into the corresponding
	 * character of the hexadecimal representation (0-9,A-F). This method is
	 * very simple and does no validation so that using values outside the
	 * allowed range will yield no reasonable result.
	 *
	 * @param value The value to convert, in the range 0 to 15
	 * @return The corresponding hex character (letters are upper case)
	 */
	public static char hexChar(int value) {
		return (char) ((value < 10) ? (48 + value) : (55 + value));
	}

	/**
	 * To create a hexadecimal string representation of a byte array. Each byte
	 * will be displayed as a two-character upper case hexadecimal value. The
	 * two-char values will be separated by the given fill string. The size of
	 * the resulting string will be <code>(bytes.length x (2 + fill.length()) -
	 * fill.length()</code> .
	 *
	 * @param bytes The byte array to display (the values will not be changed)
	 * @param fill  A String to be inserted between the two-char hex values
	 * @return The resulting hexadecimal string
	 */
	public static String hexString(byte[] bytes, String fill) {
		return hexString(bytes, 0, bytes.length, fill);
	}

	/**
	 * To create a hexadecimal string representation of a byte array. Each byte
	 * will be displayed as a two-character upper case hexadecimal value. The
	 * two-char values will be separated by the given fill string. The size of
	 * the resulting string will be <code>(bytes.length x (2 + fill.length()) -
	 * fill.length()</code> .
	 *
	 * <p>The method will always read a maximum of (bytes.length - offset)
	 * bytes from the array even if the value of offset + count is larger .</p>
	 *
	 * @param bytes  The byte array to display (the values will not be changed)
	 * @param offset The position to start reading bytes from
	 * @param count  The number of bytes to display
	 * @param fill   A String to be inserted between the two-char hex values
	 * @return The resulting hexadecimal string
	 */
	public static String hexString(byte[] bytes, int offset, int count,
		String fill) {
		count = Math.min(count, bytes.length - offset);

		int max = offset + count;
		int length = (fill.length() + 2) * count;
		StringBuilder buf = new StringBuilder(length);

		for (int i = offset; i < max; i++) {
			byte b = bytes[i];

			buf.append(hexChar((b >> 4) & 0x0F));
			buf.append(hexChar(b & 0x0F));
			buf.append(fill);
		}

		buf.setLength(length - fill.length());

		return buf.toString();
	}

	/**
	 * Interleaves a string with a fill string in certain intervals.
	 *
	 * @param value     The value to interleave with the fill string
	 * @param fill      The string to insert between the value chunks
	 * @param chunkSize The size of the chunks between the fill string shall be
	 *                  inserted (negative to start from the string end)
	 * @return The resulting string
	 */
	public static String interleave(String value, String fill, int chunkSize) {
		if (value.length() > chunkSize) {
			StringBuilder result = new StringBuilder(value);
			int length = value.length();

			if (chunkSize > 0) {
				length += chunkSize - (length % chunkSize);
				chunkSize = -chunkSize;
			}

			for (int i = length + chunkSize; i > 0; i += chunkSize) {
				result.insert(i, fill);
			}

			value = result.toString();
		}

		return value;
	}

	/**
	 * Extracts the last element of a string that is separated by dots ('.') .
	 * If the input string does not contain dots it is returned unchanged.
	 *
	 * @param input The input string
	 * @return The resulting string
	 */
	public static String lastElementOf(String input) {
		return input.substring(input.lastIndexOf('.') + 1);
	}

	/**
	 * Converts an integer value into a descriptive English string in lower
	 * case
	 * (e.g. 1 = "one"). If a number cannot be mapped NULL will be returned.
	 * The
	 * current implementation only supports the numbers from 0 (zero) to 20
	 * (twenty).
	 *
	 * @param number The number to convert
	 * @return The resulting string or NULL if no conversion was possible
	 */
	public static String numberString(int number) {
		switch (number) {
			case 0:
				return "zero";
			case 1:
				return "one";
			case 2:
				return "two";
			case 3:
				return "three";
			case 4:
				return "four";
			case 5:
				return "five";
			case 6:
				return "six";
			case 7:
				return "seven";
			case 8:
				return "eight";
			case 9:
				return "nine";
			case 10:
				return "ten";
			case 11:
				return "eleven";
			case 12:
				return "twelve";
			case 13:
				return "thirteen";
			case 14:
				return "fourteen";
			case 15:
				return "fifteen";
			case 16:
				return "sixteen";
			case 17:
				return "seventeen";
			case 18:
				return "eighteen";
			case 19:
				return "nineteen";
			case 20:
				return "twenty";
			default:
				return null;
		}
	}

	/**
	 * Returns a string that is centered within a certain maximum length. If
	 * the
	 * input string's length is less than the target length it will be aligned
	 * at the center of the resulting string and the left and right will be
	 * padded with the given fill character. If the length of the string to pad
	 * is uneven padding on the right side takes precedence so that the string
	 * will be aligned one character farther to the left.
	 *
	 * @param string The string to be padded
	 * @param width  The length of the result string
	 * @param fill   The fill character
	 * @return The resulting string
	 */
	public static String padCenter(String string, int width, char fill) {
		if (width > string.length()) {
			StringBuilder sb = new StringBuilder(string);

			for (int i = string.length(); i < width; i += 2) {
				sb.append(fill);

				if (sb.length() < width) {
					sb.insert(0, fill);
				}
			}

			string = sb.toString();
		}

		return string;
	}

	/**
	 * Returns a right-aligned string with a certain maximum length. If the
	 * input string's length is less than the target length it will be aligned
	 * to the right of the resulting string and the left will be filled with
	 * the
	 * given fill character.
	 *
	 * @param string The string to be padded
	 * @param width  The length of the result string
	 * @param fill   The fill character
	 * @return The resulting string
	 */
	public static String padLeft(String string, int width, char fill) {
		if (width > string.length()) {
			StringBuilder sb = new StringBuilder(width);

			for (int i = string.length(); i < width; i++) {
				sb.append(fill);
			}

			sb.append(string);
			sb.setLength(width);

			string = sb.toString();
		}

		return string;
	}

	/**
	 * Returns a left-aligned string with a certain maximum length. If the
	 * input
	 * string's length is less than the target length it will be aligned to the
	 * left of the resulting string and the right will be filled with the given
	 * fill character.
	 *
	 * @param string The string to be padded
	 * @param width  The length of the result string
	 * @param fill   The fill character
	 * @return The resulting string
	 */
	public static String padRight(String string, int width, char fill) {
		if (width > string.length()) {
			StringBuilder sb = new StringBuilder(width);

			sb.append(string);

			for (int i = string.length(); i < width; i++) {
				sb.append(fill);
			}

			string = sb.toString();
		}

		return string;
	}

	/**
	 * Converts a string of hexadecimal digits into a byte array of half the
	 * length.
	 *
	 * @param hexValue The hexadecimal string to convert
	 * @return The resulting byte array
	 * @throws IllegalArgumentException If the argument string is NULL or
	 * has an
	 *                                  uneven length
	 * @throws NumberFormatException    If the string contains characters that
	 *                                  cannot be parsed into bytes
	 */
	public static byte[] toBytes(String hexValue) {
		int length = hexValue.length();

		if ((length & 0x1) == 1) {
			throw new IllegalArgumentException(
				"Even number of hex digits required: " + hexValue);
		}

		byte[] result = new byte[length / 2];

		for (int i = 0; i < length; i += 2) {
			int upper = Character.digit(hexValue.charAt(i), 16);
			int lower = Character.digit(hexValue.charAt(i + 1), 16);

			if (upper >= 0 && lower >= 0) {
				result[i / 2] = (byte) ((upper << 4) + lower);
			}
		}

		return result;
	}

	/**
	 * Returns the English plural of a certain name.
	 *
	 * @param name The name to convert
	 * @return The resulting plural name
	 */
	public static String toPlural(String name) {
		name = name.substring(name.lastIndexOf('.') + 1);

		if (name.endsWith("s")) {
			name += "es";
		} else if (name.endsWith("y") &&
			!(name.endsWith("ay") || name.endsWith("ey") ||
				name.endsWith("oy") || name.endsWith("uy"))) {
			name = name.substring(0, name.length() - 1);
			name += "ies";
		} else {
			name += "s";
		}

		return name;
	}

	/**
	 * Decodes all occurrences of the Java and JavaScript unicode escape
	 * representation with the un-escaped token.
	 *
	 * @param value The value string to escape the occurrences of
	 * @param token The separator string to escape
	 * @return The escaped string
	 */
	public static String unicodeDecode(String value, String token) {
		return value.replaceAll(unicodeEncode(token), token);
	}

	/**
	 * Encodes each character of a string with it's unicode escape sequence.
	 *
	 * @param value The value to encode
	 * @return The encoded value
	 */
	public static String unicodeEncode(String value) {
		StringBuilder encodedValue = new StringBuilder();
		int length = value.length();

		for (int i = 0; i < length; i++) {
			int tokenChar = value.charAt(i);

			encodedValue.append("\\\\u");
			encodedValue.append(hexChar(tokenChar >> 12 & 0x0F));
			encodedValue.append(hexChar(tokenChar >> 8 & 0x0F));
			encodedValue.append(hexChar(tokenChar >> 4 & 0x0F));
			encodedValue.append(hexChar(tokenChar & 0x0F));
		}

		return encodedValue.toString();
	}

	/**
	 * Encodes all occurrences of a token string in a value string with their
	 * Java and JavaScript unicode escape representation.
	 *
	 * @param value The value string to escape the occurrences of
	 * @param token The separator string to escape
	 * @return The escaped string
	 */
	public static Object unicodeEncode(String value, String token) {
		int pos = value.indexOf(token);

		if (pos >= 0) {
			value = value.replaceAll(token, unicodeEncode(token));
		}

		return value;
	}

	/**
	 * Creates an upper case identifier from a string. This is done by
	 * inserting
	 * underscores ('_') at single upper case letters or after sequences of
	 * such
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
	 * @param identifier The string to create the upper case identifier from
	 * @return The upper case identifier string
	 */
	public static String uppercaseIdentifier(String identifier) {
		String s = identifier.replaceAll("\\s", "_");
		StringBuilder sb = new StringBuilder(s.length() + 5);
		int max = s.length() - 1;
		int start = 0;
		boolean skip = false;

		for (int pos = 0; pos <= max; pos++) {
			char c = s.charAt(pos);
			boolean upper = Character.isUpperCase(c);

			if (upper && (pos - start) > 0 && (!skip ||
				(pos < max && Character.isLowerCase(s.charAt(pos + 1))))) {
				sb.append(s, start, pos);

				if (sb.charAt(sb.length() - 1) != '_') {
					sb.append('_');
				}

				start = pos;
			}

			// do not split at sequences of uppercase letters and also skip
			// underscores or digits in such sequences
			skip = (upper || (skip && (c == '_' || Character.isDigit(c))));
		}

		sb.append(s.substring(start));

		return sb.toString().toUpperCase();
	}
}
