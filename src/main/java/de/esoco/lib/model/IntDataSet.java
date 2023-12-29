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

import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of the {@link DataSet} interface that contains integer
 * values.
 *
 * @author eso
 */
public class IntDataSet extends AbstractDataSet<Integer> {

	private static final long serialVersionUID = 1L;

	private List<int[]> data;

	/**
	 * Creates a new instance without data. Data can then be added through the
	 * addRow() methods. The row list instance will be stored directly and will
	 * not be copied.
	 *
	 * @see IntDataSet#IntDataSet(List, List, List, String, String, String)
	 */
	public IntDataSet(List<String> columnLabels, String rowAxisLabel,
		String valueAxisLabel, String columnAxisLabel) {
		this(new ArrayList<int[]>(), new ArrayList<String>(), columnLabels,
			rowAxisLabel, valueAxisLabel, columnAxisLabel);
	}

	/**
	 * Creates a new instance from existing data. The data and list arguments
	 * will be stored directly and will not be copied. The first array in the
	 * two-dimensional data array must contain arrays with the column data
	 * which
	 * in turn contain the single values, indexed by row.
	 *
	 * @param data The data matrix
	 * @see AbstractDataSet#AbstractDataSet(List, List, String, String, String)
	 */
	public IntDataSet(List<int[]> data, List<String> rowLabels,
		List<String> columnLabels, String rowAxisLabel, String valueAxisLabel,
		String columnAxisLabel) {
		super(rowLabels, columnLabels, rowAxisLabel, valueAxisLabel,
			columnAxisLabel);

		data = data;
	}

	/**
	 * Default constructor for GWT serialization.
	 */
	IntDataSet() {
	}

	/**
	 * @see DataSet#getColumnCount()
	 */
	@Override
	public final int getColumnCount() {
		return data.size() > 0 ? data.get(0).length : 0;
	}

	/**
	 * @see DataSet#getValue(int, int)
	 */
	@Override
	@SuppressWarnings("boxing")
	public final Integer getValue(int row, int column) {
		return data.get(row)[column];
	}

	/**
	 * @see AbstractDataSet#add(int, Object[])
	 */
	@Override
	protected void add(int beforeRow, Integer[] rowData) {
		int[] newRow = new int[rowData.length];
		int column = 0;

		for (Integer value : rowData) {
			newRow[column++] = value.intValue();
		}

		data.add(beforeRow, newRow);
	}

	/**
	 * @see AbstractDataSet#getDataRows()
	 */
	@Override
	protected List<?> getDataRows() {
		return data;
	}
}
