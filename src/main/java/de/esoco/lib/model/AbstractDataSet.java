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

/**
 * A base class for data set implementations that manages all information
 * besides the actual data.
 *
 * @author eso
 */
public abstract class AbstractDataSet<T> extends StringProperties
	implements DataSet<T>, Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> rowLabels;

	private List<String> columnLabels;

	private String rowAxisLabel;

	private String valueAxisLabel;

	private String columnAxisLabel;

	/**
	 * Default constructor for GWT serialization.
	 */
	protected AbstractDataSet() {
	}

	/**
	 * Creates a new instance with certain data. The list arguments will be
	 * stored directly and will not be copied.
	 *
	 * @param rowLabels       A list of row labels
	 * @param columnLabels    A list of column labels
	 * @param rowAxisLabel    The label for the row (x) axis or NULL
	 * @param valueAxisLabel  The label for the value (y) axis or NULL
	 * @param columnAxisLabel The label for the column (z) axis or NULL
	 */
	protected AbstractDataSet(List<String> rowLabels,
		List<String> columnLabels,
		String rowAxisLabel, String valueAxisLabel, String columnAxisLabel) {
		this.rowLabels = rowLabels;
		this.columnLabels = columnLabels;
		this.rowAxisLabel = rowAxisLabel;
		this.valueAxisLabel = valueAxisLabel;
		this.columnAxisLabel = columnAxisLabel;
	}

	/**
	 * Adds a new row to this data set.
	 *
	 * @param label   The label for the row or NULL for none
	 * @param rowData The row data values
	 */
	@SuppressWarnings("unchecked")
	public void addRow(String label, T... rowData) {
		addRow(getRowCount(), label, rowData);
	}

	/**
	 * Inserts a new column into this data set.
	 *
	 * @param beforeRow The index of the column before which to insert the new
	 *                  one
	 * @param label     The label for the row or NULL for none
	 * @param rowData   The row data values
	 * @throws IndexOutOfBoundsException If the given column doesn't exist
	 */
	@SuppressWarnings("unchecked")
	public void addRow(int beforeRow, String label, T... rowData) {
		rowLabels.add(beforeRow, label);
		add(beforeRow, rowData);
	}

	/**
	 * @see DataSet#getColumnAxisLabel()
	 */
	@Override
	public final String getColumnAxisLabel() {
		return columnAxisLabel;
	}

	/**
	 * @see DataSet#getColumnLabel(int)
	 */
	@Override
	public final String getColumnLabel(int column) {
		return getLabel(column, getColumnCount(), columnLabels);
	}

	/**
	 * @see DataSet#getRowAxisLabel()
	 */
	@Override
	public final String getRowAxisLabel() {
		return rowAxisLabel;
	}

	/**
	 * @see DataSet#getRowCount()
	 */
	@Override
	public final int getRowCount() {
		return getDataRows().size();
	}

	/**
	 * @see DataSet#getRowLabel(int)
	 */
	@Override
	public final String getRowLabel(int row) {
		return getLabel(row, getRowCount(), rowLabels);
	}

	/**
	 * @see DataSet#getValueAxisLabel()
	 */
	@Override
	public final String getValueAxisLabel() {
		return valueAxisLabel;
	}

	/**
	 * Removes a certain column from this data set.
	 *
	 * @param column The column to remove
	 * @throws IndexOutOfBoundsException If the given column doesn't exist
	 */
	public void removeRow(int column) {
		columnLabels.remove(column);
		getDataRows().remove(column);
	}

	/**
	 * @see de.esoco.lib.property.AbstractStringProperties#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + rowLabels;
	}

	/**
	 * Must be implemented by subclasses to support the dynamic addition of
	 * data.
	 *
	 * @param beforeRow The row before which to insert the data
	 * @param rowData   The new row data
	 */
	protected abstract void add(int beforeRow, T[] rowData);

	/**
	 * Must be implemented by subclasses to return list of data rows.
	 *
	 * @return The list containing the data rows
	 */
	protected abstract List<?> getDataRows();

	/**
	 * Internal method to return a certain label from a list of strings.
	 * Returns
	 * NULL if an index is used that for which no label is stored.
	 *
	 * @param index  The label index
	 * @param max    The maximum value for the index
	 * @param labels The list of label strings
	 * @return The label string or NULL for none
	 * @throws IndexOutOfBoundsException If the index is invalid
	 */
	private final String getLabel(int index, int max, List<String> labels) {
		String label = null;

		if (index > max) {
			throw new IndexOutOfBoundsException(
				"Invalid index: " + index + " > " + max);
		}

		if (labels != null && index < labels.size()) {
			label = labels.get(index);
		}

		return label;
	}
}
