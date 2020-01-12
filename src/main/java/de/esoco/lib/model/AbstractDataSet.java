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

import de.esoco.lib.property.StringProperties;

import java.io.Serializable;

import java.util.List;


/********************************************************************
 * A base class for data set implementations that manages all information
 * besides the actual data.
 *
 * @author eso
 */
public abstract class AbstractDataSet<T> extends StringProperties
	implements DataSet<T>, Serializable {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	//~ Instance fields --------------------------------------------------------

	private List<String> aRowLabels;
	private List<String> aColumnLabels;
	private String		 sRowAxisLabel;
	private String		 sValueAxisLabel;
	private String		 sColumnAxisLabel;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Default constructor for GWT serialization.
	 */
	protected AbstractDataSet() {
	}

	/***************************************
	 * Creates a new instance with certain data. The list arguments will be
	 * stored directly and will not be copied.
	 *
	 * @param rRowLabels       A list of row labels
	 * @param rColumnLabels    A list of column labels
	 * @param sRowAxisLabel    The label for the row (x) axis or NULL
	 * @param sValueAxisLabel  The label for the value (y) axis or NULL
	 * @param sColumnAxisLabel The label for the column (z) axis or NULL
	 */
	protected AbstractDataSet(List<String> rRowLabels,
							  List<String> rColumnLabels,
							  String	   sRowAxisLabel,
							  String	   sValueAxisLabel,
							  String	   sColumnAxisLabel) {
		this.aRowLabels		  = rRowLabels;
		this.aColumnLabels    = rColumnLabels;
		this.sRowAxisLabel    = sRowAxisLabel;
		this.sValueAxisLabel  = sValueAxisLabel;
		this.sColumnAxisLabel = sColumnAxisLabel;
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Adds a new row to this data set.
	 *
	 * @param sLabel   The label for the row or NULL for none
	 * @param rRowData The row data values
	 */
	@SuppressWarnings("unchecked")
	public void addRow(String sLabel, T... rRowData) {
		addRow(getRowCount(), sLabel, rRowData);
	}

	/***************************************
	 * Inserts a new column into this data set.
	 *
	 * @param  nBeforeRow The index of the column before which to insert the new
	 *                    one
	 * @param  sLabel     The label for the row or NULL for none
	 * @param  rRowData   The row data values
	 *
	 * @throws IndexOutOfBoundsException If the given column doesn't exist
	 */
	@SuppressWarnings("unchecked")
	public void addRow(int nBeforeRow, String sLabel, T... rRowData) {
		aRowLabels.add(nBeforeRow, sLabel);
		add(nBeforeRow, rRowData);
	}

	/***************************************
	 * @see DataSet#getColumnAxisLabel()
	 */
	@Override
	public final String getColumnAxisLabel() {
		return sColumnAxisLabel;
	}

	/***************************************
	 * @see DataSet#getColumnLabel(int)
	 */
	@Override
	public final String getColumnLabel(int nColumn) {
		return getLabel(nColumn, getColumnCount(), aColumnLabels);
	}

	/***************************************
	 * @see DataSet#getRowAxisLabel()
	 */
	@Override
	public final String getRowAxisLabel() {
		return sRowAxisLabel;
	}

	/***************************************
	 * @see DataSet#getRowCount()
	 */
	@Override
	public final int getRowCount() {
		return getDataRows().size();
	}

	/***************************************
	 * @see DataSet#getRowLabel(int)
	 */
	@Override
	public final String getRowLabel(int nRow) {
		return getLabel(nRow, getRowCount(), aRowLabels);
	}

	/***************************************
	 * @see DataSet#getValueAxisLabel()
	 */
	@Override
	public final String getValueAxisLabel() {
		return sValueAxisLabel;
	}

	/***************************************
	 * Removes a certain column from this data set.
	 *
	 * @param  nColumn The column to remove
	 *
	 * @throws IndexOutOfBoundsException If the given column doesn't exist
	 */
	public void removeRow(int nColumn) {
		aColumnLabels.remove(nColumn);
		getDataRows().remove(nColumn);
	}

	/***************************************
	 * @see de.esoco.lib.property.AbstractStringProperties#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + aRowLabels;
	}

	/***************************************
	 * Must be implemented by subclasses to support the dynamic addition of
	 * data.
	 *
	 * @param nBeforeRow The row before which to insert the data
	 * @param rRowData   The new row data
	 */
	protected abstract void add(int nBeforeRow, T[] rRowData);

	/***************************************
	 * Must be implemented by subclasses to return list of data rows.
	 *
	 * @return The list containing the data rows
	 */
	protected abstract List<?> getDataRows();

	/***************************************
	 * Internal method to return a certain label from a list of strings. Returns
	 * NULL if an index is used that for which no label is stored.
	 *
	 * @param  nIndex  The label index
	 * @param  nMax    The maximum value for the index
	 * @param  rLabels The list of label strings
	 *
	 * @return The label string or NULL for none
	 *
	 * @throws IndexOutOfBoundsException If the index is invalid
	 */
	private final String getLabel(int nIndex, int nMax, List<String> rLabels) {
		String sLabel = null;

		if (nIndex > nMax) {
			throw new IndexOutOfBoundsException(
				"Invalid index: " + nIndex +
				" > " + nMax);
		}

		if (rLabels != null && nIndex < rLabels.size()) {
			sLabel = rLabels.get(nIndex);
		}

		return sLabel;
	}
}
