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
import de.esoco.lib.property.UserInterfaceProperties;

import java.util.Objects;

/**
 * A simple implementation of the {@link ColumnDefinition} interface.
 *
 * @author eso
 */
public class SimpleColumnDefinition extends StringProperties
	implements ColumnDefinition {

	private static final long serialVersionUID = 1L;

	private String id;

	private String title;

	private String datatype;

	/**
	 * Creates a new instance with a certain ID, datatype, default title,
	 * unlimited length, and all flags set to TRUE. The default title will be
	 * created from the ID by prefixing it with {@link #STD_COLUMN_PREFIX}.
	 *
	 * @param id       The column identifier
	 * @param datatype The column datatype
	 */
	public SimpleColumnDefinition(String id, String datatype) {
		this(id, null, datatype);
	}

	/**
	 * Creates a new instance with a certain ID, title, datatype, unlimited
	 * length and all flags set to TRUE.
	 *
	 * @param id       The column identifier
	 * @param title    The column title
	 * @param datatype The column datatype
	 */
	public SimpleColumnDefinition(String id, String title, String datatype) {
		this(id, title, datatype, true, true, true);
	}

	/**
	 * Creates a new instance.
	 *
	 * @param id         The column identifier
	 * @param title      The column title or NULL for the ID prefixed with
	 *                   {@link #STD_COLUMN_PREFIX}
	 * @param datatype   The column datatype
	 * @param sortable   The sortable state
	 * @param searchable The searchable state
	 * @param editable   The editable state
	 */
	public SimpleColumnDefinition(String id, String title, String datatype,
		boolean sortable, boolean searchable, boolean editable) {
		this.id = id;
		this.title = title != null ? title : STD_COLUMN_PREFIX + id;
		this.datatype = datatype;

		if (searchable) {
			setProperty(UserInterfaceProperties.SEARCHABLE, searchable);
		}

		if (sortable) {
			setProperty(UserInterfaceProperties.SORTABLE, sortable);
		}

		if (editable) {
			setProperty(UserInterfaceProperties.EDITABLE, editable);
		}
	}

	/**
	 * Default constructor for serialization.
	 */
	protected SimpleColumnDefinition() {
	}

	/**
	 * TODO: DOCUMENT ME!
	 *
	 * @param obj TODO: DOCUMENT ME!
	 * @return TODO: DOCUMENT ME!
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (getClass() != obj.getClass()) {
			return false;
		}

		SimpleColumnDefinition other = (SimpleColumnDefinition) obj;

		return hasEqualProperties(other) && Objects.equals(id, other.id) &&
			Objects.equals(title, other.title) &&
			Objects.equals(datatype, other.datatype);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getDatatype() {
		return datatype;
	}

	/**
	 * @see ColumnDefinition#getId()
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * @see ColumnDefinition#getTitle()
	 */
	@Override
	public String getTitle() {
		return title;
	}

	/**
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int hashCode = super.hashCode();

		hashCode =
			37 * hashCode + ((datatype == null) ? 0 : datatype.hashCode());
		hashCode = 37 * hashCode + ((id == null) ? 0 : id.hashCode());
		hashCode = 37 * hashCode + ((title == null) ? 0 : title.hashCode());

		return hashCode;
	}

	/**
	 * Returns the column title.
	 *
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return title;
	}
}
