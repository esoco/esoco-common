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

/**
 * Enumeration of alignment constants.
 *
 * @author eso
 */
public enum Alignment implements HasCssName {
	BEGIN("start") {
		@Override
		public int calcAlignedPosition(int start, int freeSpace,
			boolean leftToRight) {
			return start + (leftToRight ? 0 : freeSpace);
		}
	}, CENTER("center") {
		@Override
		public int calcAlignedPosition(int start, int freeSpace,
			boolean leftToRight) {
			return start + freeSpace / 2;
		}
	}, END("end") {
		@Override
		public int calcAlignedPosition(int start, int freeSpace,
			boolean leftToRight) {
			return start + (leftToRight ? freeSpace : 0);
		}
	}, FILL("stretch") {
		@Override
		public int calcAlignedPosition(int start, int freeSpace,
			boolean leftToRight) {
			return start + (leftToRight ? 0 : freeSpace);
		}
	};

	private final String cssName;

	/**
	 * Creates a new instance.
	 *
	 * @param cssName The CSS name of this instance
	 */
	Alignment(String cssName) {
		this.cssName = cssName;
	}

	/**
	 * Returns the alignment instance that is identified by a certain
	 * character.
	 * The character must be the first letter of the instance name.
	 *
	 * @param cChar The alignment character (case-sensitive)
	 * @return The matching alignment instance
	 * @throws IllegalArgumentException If the character doesn't represent an
	 *                                  alignment instance
	 */
	public static Alignment valueOf(char cChar) {
		for (Alignment a : values()) {
			if (a.getCharacter() == cChar) {
				return a;
			}
		}

		throw new IllegalArgumentException("No valid Alignment char: " + cChar);
	}

	/**
	 * Calculates and returns a coordinate aligned according to this alignment
	 * based on the starting position and the remaining free space of the area
	 * to align in.
	 *
	 * @param start       The starting coordinate of the area to align in
	 * @param freeSpace   The free space available for alignment
	 * @param leftToRight TRUE for left-to-right display
	 * @return The calculated aligned coordinate
	 */
	public abstract int calcAlignedPosition(int start, int freeSpace,
		boolean leftToRight);

	/**
	 * Calculates and returns a coordinate aligned according to this alignment
	 * based on the starting position, the size of the element to align, and
	 * the
	 * full size of the are to align the element in.
	 *
	 * @param start     The starting coordinate of the area to align in
	 * @param fullSize  The full size (i.e. width or height) of the area
	 * @param alignSize The size of the element to align
	 * @return The calculated aligned coordinate
	 */
	public int calcAlignedPosition(int start, int fullSize, int alignSize) {
		return calcAlignedPosition(start, fullSize - alignSize, true);
	}

	/**
	 * Returns the character representation of this instance.
	 *
	 * @return The character describing this instance
	 */
	public final char getCharacter() {
		return name().charAt(0);
	}

	/**
	 * Returns the CSS name of this alignment. This is the standard name
	 * that is
	 * used in modern CSS mechanisms like grid layout for alignment and
	 * justification.
	 *
	 * @return The CSS name
	 */
	@Override
	public String getCssName() {
		return cssName;
	}
}
