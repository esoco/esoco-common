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
package de.esoco.lib.model;

import de.esoco.lib.property.HasProperties;


/********************************************************************
 * An interface that defines a set of data for charting or similar purposes. A
 * data set basically is a table of values that is organized in rows and columns
 * as shown in the diagram below. The most simple form of data set consists of
 * only one column and would be used for simple diagrams that have only one
 * value dimension like pie charts.
 *
 * <pre>
       Col0  Col1  Col2
     +------------------
Row0 | V0.0  V0.1  V0.2
Row1 | V1.0  V1.1  V1.2
Row2 | V2.0  V2.1  V2.2
Row3 | V3.0  V3.1  V3.2
 * </pre>
 *
 * <p>Each column and each row can have labels assigned, either for each row and
 * column, only for some or for none at all. Furthermore the axes of the table
 * can have labels assigned too, as well as the value axis that represents the
 * cell values in the tables. Which of these informations are used or required
 * depends on the chart used to render the data set. A data set like the one
 * above could for example be rendered as a multi-column bar chart like this:
 * </p>
 *
 * <pre>
Value Axis            +-Column Axis-+
   ^                  |# Column 0   |
   |  %               |% Column 1   |
10 |  % +  # %        |+ Column 2   |
   |# % +  # % +      +-------------+
 5 |# % +  # % + ...
   +----------------&gt; Row Axis
    Row 0  Row 1
 * </pre>
 *
 * <p>In this example each column of three values in the data set would be
 * rendered as three differently colored adjacent bars (#, %, and + above).
 * Because the rendering is not three-dimensional the column axis label is used
 * as the title for the legend and the column labels are used for the legend
 * enumeration. Alternatively each column could be rendered as a line in a
 * two-dimensional diagram or the data could be displayed in form of a
 * three-dimensional bar or band chart.</p>
 *
 * <p>The</p>
 *
 * @author eso
 */
public interface DataSet<T> extends HasProperties {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Returns the label for the column (x) axis of this data set. If no label
	 * is available the result will be NULL.
	 *
	 * @return The column axis label
	 */
	public String getColumnAxisLabel();

	/***************************************
	 * Returns the number of columns in this set.
	 *
	 * @return The column count
	 */
	public int getColumnCount();

	/***************************************
	 * Returns the label for a certain data column or NULL if no label is
	 * available.
	 *
	 * @param  nColumn The column
	 *
	 * @return The label
	 *
	 * @throws IndexOutOfBoundsException If the given column doesn't exist
	 */
	public String getColumnLabel(int nColumn);

	/***************************************
	 * Returns the label for the row (z) axis of this data set. If no label is
	 * available the result will be NULL.
	 *
	 * @return The row axis label
	 */
	public String getRowAxisLabel();

	/***************************************
	 * Returns the number of data rows in this set.
	 *
	 * @return The row count
	 */
	public int getRowCount();

	/***************************************
	 * Returns the label for a certain data row or NULL if no label is
	 * available.
	 *
	 * @param  nRow The row
	 *
	 * @return The label
	 *
	 * @throws IndexOutOfBoundsException If the given row doesn't exist
	 */
	public String getRowLabel(int nRow);

	/***************************************
	 * Returns the value.
	 *
	 * @param  nRow    The value
	 * @param  nColumn The value
	 *
	 * @return The value
	 *
	 * @throws IndexOutOfBoundsException If the either given row or column
	 *                                   doesn't exist
	 */
	public T getValue(int nRow, int nColumn);

	/***************************************
	 * Returns the label for the value (y) axis of this data set. If no label is
	 * available the result will be NULL.
	 *
	 * @return The value axis label
	 */
	public String getValueAxisLabel();
}
