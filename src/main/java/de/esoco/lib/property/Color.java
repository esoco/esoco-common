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
package de.esoco.lib.property;

import de.esoco.lib.text.TextConvert;

/**
 * An immutable datatype that encapsulates RGB color data and provides
 * conversions to other color data formats like HTML strings. Instances of this
 * classes are created through the different
 * {@link #valueOf(int, int, int) valueOf()} methods.
 */
public class Color {

	/**
	 * black
	 */
	public static final Color BLACK = valueOf(0x0);

	/**
	 * dark gray
	 */
	public static final Color DARK_GRAY = valueOf(0x0404040);

	/**
	 * medium gray
	 */
	public static final Color MEDIUM_GRAY = valueOf(0x0808080);

	/**
	 * light gray
	 */
	public static final Color LIGHT_GRAY = valueOf(0x0C0C0C0);

	/**
	 * 10 percent gray
	 */
	public static final Color GRAY_10 = valueOf(0x01A1A1A);

	/**
	 * 20 percent gray
	 */
	public static final Color GRAY_20 = valueOf(0x0333333);

	/**
	 * 30 percent gray
	 */
	public static final Color GRAY_30 = valueOf(0x04D4D4D);

	/**
	 * 33 percent gray
	 */
	public static final Color GRAY_33 = valueOf(0x0555555);

	/**
	 * 40 percent gray
	 */
	public static final Color GRAY_40 = valueOf(0x0666666);

	/**
	 * 50 percent gray
	 */
	public static final Color GRAY_50 = MEDIUM_GRAY;

	/**
	 * 60 percent gray
	 */
	public static final Color GRAY_60 = valueOf(0x0999999);

	/**
	 * 66 percent gray
	 */
	public static final Color GRAY_66 = valueOf(0x0AAAAAA);

	/**
	 * 70 percent gray
	 */
	public static final Color GRAY_70 = valueOf(0x0B3B3B3);

	/**
	 * 80 percent gray
	 */
	public static final Color GRAY_80 = valueOf(0x0CCCCCC);

	/**
	 * 90 percent gray
	 */
	public static final Color GRAY_90 = valueOf(0x0E6E6E6);

	/**
	 * Color white
	 */
	public static final Color WHITE = valueOf(0x0FFFFFF);

	/**
	 * blue
	 */
	public static final Color BLUE = valueOf(0x0000FF);

	/**
	 * dark blue
	 */
	public static final Color DARK_BLUE = valueOf(0x000080);

	/**
	 * red
	 */
	public static final Color RED = valueOf(0x0FF0000);

	/**
	 * dark red
	 */
	public static final Color DARK_RED = valueOf(0x0800000);

	/**
	 * green
	 */
	public static final Color GREEN = valueOf(0x00FF00);

	/**
	 * dark green
	 */
	public static final Color DARK_GREEN = valueOf(0x008000);

	/**
	 * cyan
	 */
	public static final Color CYAN = valueOf(0x00FFFF);

	/**
	 * dark cyan
	 */
	public static final Color DARK_CYAN = valueOf(0x008080);

	/**
	 * yellow
	 */
	public static final Color YELLOW = valueOf(0x0FFFF00);

	/**
	 * dark yellow
	 */
	public static final Color DARK_YELLOW = valueOf(0x0808000);

	/**
	 * magenta
	 */
	public static final Color MAGENTA = valueOf(0x0FF00FF);

	/**
	 * dark magenta
	 */
	public static final Color DARK_MAGENTA = valueOf(0x0800080);

	private final int red;

	private final int green;

	private final int blue;

	/**
	 * Internal constructor to create a new instance with certain RGB parts.
	 *
	 * @param red   The red part
	 * @param green The green part
	 * @param blue  The blue part
	 */
	private Color(int red, int green, int blue) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}

	/**
	 * Returns a color instance for a combined RGB integer value. The single
	 * color components are considered to be in the range of (0 - 255), i.e. a
	 * byte for each.
	 *
	 * @param rgbColor The integer value containing the RGB value bytes
	 * @return The color instance
	 */
	public static Color valueOf(int rgbColor) {
		int r = (rgbColor & 0x00FF0000) >> 16;
		int g = (rgbColor & 0x0000FF00) >> 8;
		int b = (rgbColor & 0x000000FF);

		return valueOf(r, g, b);
	}

	/**
	 * Converts an HTML color string into a color object.
	 *
	 * @param htmlColor The HTML color string (a leading '#' will be ignored)
	 * @return The color instance
	 */
	public static Color valueOf(String htmlColor) {
		if (htmlColor.charAt(0) == '#') {
			htmlColor = htmlColor.substring(1);
		}

		return valueOf(Integer.parseInt(htmlColor, 16));
	}

	/**
	 * Returns a color instance from RGB integer values.
	 *
	 * @param red   The red component
	 * @param green The green component
	 * @param blue  The blue component
	 * @return A new color instance
	 */
	public static Color valueOf(int red, int green, int blue) {
		return new Color(red, green, blue);
	}

	/**
	 * Returns a color value that is 10 percent brighter than this instance by
	 * invoking the {@link #changeBrightness(int)} method.
	 *
	 * @return The brighter color
	 */
	public Color brighter() {
		return changeBrightness(10);
	}

	/**
	 * Calculates the brightest RGB value that can be created from this
	 * instance. That will be the color where all color components have been
	 * multiplied with the factor that converts the brightest component to the
	 * maximum value of 255.
	 *
	 * @return The resulting color
	 */
	public Color brightest() {
		// normalize components to color value * 256 and add 256 to get the
		// range 1 to 256 to prevent division by zero
		int r = (red << 8) + 256;
		int g = (green << 8) + 256;
		int b = (blue << 8) + 256;

		int max = Math.max(r, Math.max(g, b)) >> 8;

		// scale values and reset to range 0 to 255
		r = r / max - 1;
		g = g / max - 1;
		b = b / max - 1;

		return valueOf(r, g, b);
	}

	/**
	 * Returns a derived color with a brightness that has been changed by the
	 * given percentage. Negative values decrease the brightness.
	 *
	 * @param percent The brightness change factor in percent (positive for a
	 *                lighter, negative for a darker color)
	 * @return The resulting color
	 */
	public Color changeBrightness(int percent) {
		int change = 255 * percent / 100;

		int r = red + change;
		int g = green + change;
		int b = blue + change;

		r = r < 0 ? 0 : (r <= 255 ? r : 255);
		g = g < 0 ? 0 : (g <= 255 ? g : 255);
		b = b < 0 ? 0 : (b <= 255 ? b : 255);

		return valueOf(r, g, b);
	}

	/**
	 * Returns a color value that is 10 percent darker than this instance by
	 * invoking the {@link #changeBrightness(int)} method.
	 *
	 * @return The darker color
	 */
	public Color darker() {
		return changeBrightness(-10);
	}

	/**
	 * Returns the blue part of this color.
	 *
	 * @return The blue part
	 */
	public final int getBlue() {
		return blue;
	}

	/**
	 * Returns the green part of this color.
	 *
	 * @return The green part
	 */
	public final int getGreen() {
		return green;
	}

	/**
	 * Returns the red part of this color.
	 *
	 * @return The red part
	 */
	public final int getRed() {
		return red;
	}

	/**
	 * Converts this color to a hexadecimal RGB string as used in HTML and CSS,
	 * including the '#' prefix.
	 *
	 * @return The HTML color string
	 */
	public String toHtml() {
		return "#" + TextConvert.padLeft(Integer.toHexString(toRGB()), 6, '0');
	}

	/**
	 * Converts this color into the corresponding RGB integer value.
	 *
	 * @return An RGB integer value
	 */
	public int toRGB() {
		return (red << 16) + (green << 8) + blue;
	}

	/**
	 * Returns the same as {@link #toHtml()}.
	 *
	 * @return TODO: DOCUMENT ME!
	 */
	@Override
	public String toString() {
		return toHtml();
	}
}
