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


/********************************************************************
 * A simple implementation of the {@link ColumnDefinition} interface.
 *
 * @author eso
 */
public class SimpleColumnDefinition extends StringProperties
	implements ColumnDefinition {

	//~ Static fields/initializers ---------------------------------------------

	private static final long serialVersionUID = 1L;

	//~ Instance fields --------------------------------------------------------

	private String sId;
	private String sTitle;
	private String sDatatype;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance with a certain ID, datatype, default title,
	 * unlimited length, and all flags set to TRUE. The default title will be
	 * created from the ID by prefixing it with {@link #STD_COLUMN_PREFIX}.
	 *
	 * @param sId       The column identifier
	 * @param sDatatype The column datatype
	 */
	public SimpleColumnDefinition(String sId, String sDatatype) {
		this(sId, null, sDatatype);
	}

	/***************************************
	 * Creates a new instance with a certain ID, title, datatype, unlimited
	 * length and all flags set to TRUE.
	 *
	 * @param sId       The column identifier
	 * @param sTitle    The column title
	 * @param sDatatype The column datatype
	 */
	public SimpleColumnDefinition(String sId, String sTitle, String sDatatype) {
		this(sId, sTitle, sDatatype, true, true, true);
	}

	/***************************************
	 * Creates a new instance.
	 *
	 * @param sId         The column identifier
	 * @param sTitle      The column title or NULL for the ID prefixed with
	 *                    {@link #STD_COLUMN_PREFIX}
	 * @param sDatatype   The column datatype
	 * @param bSortable   The sortable state
	 * @param bSearchable The searchable state
	 * @param bEditable   The editable state
	 */
	public SimpleColumnDefinition(String  sId,
								  String  sTitle,
								  String  sDatatype,
								  boolean bSortable,
								  boolean bSearchable,
								  boolean bEditable) {
		this.sId	   = sId;
		this.sTitle    = sTitle != null ? sTitle : STD_COLUMN_PREFIX + sId;
		this.sDatatype = sDatatype;

		if (bSearchable) {
			setProperty(UserInterfaceProperties.SEARCHABLE, bSearchable);
		}

		if (bSortable) {
			setProperty(UserInterfaceProperties.SORTABLE, bSortable);
		}

		if (bEditable) {
			setProperty(UserInterfaceProperties.EDITABLE, bEditable);
		}
	}

	/***************************************
	 * Default constructor for serialization.
	 */
	protected SimpleColumnDefinition() {
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * TODO: DOCUMENT ME!
	 *
	 * @param      rObj TODO: DOCUMENT ME!
	 *
	 * @return     TODO: DOCUMENT ME!
	 *
	 * @inheritDoc }
	 */
	@Override
	public boolean equals(Object rObj) {
		if (this == rObj) {
			return true;
		}

		if (getClass() != rObj.getClass()) {
			return false;
		}

		SimpleColumnDefinition rOther = (SimpleColumnDefinition) rObj;

		return hasEqualProperties(rOther) && Objects.equals(sId, rOther.sId) &&
			   Objects.equals(sTitle, rOther.sTitle) &&
			   Objects.equals(sDatatype, rOther.sDatatype);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public String getDatatype() {
		return sDatatype;
	}

	/***************************************
	 * @see ColumnDefinition#getId()
	 */
	@Override
	public String getId() {
		return sId;
	}

	/***************************************
	 * @see ColumnDefinition#getTitle()
	 */
	@Override
	public String getTitle() {
		return sTitle;
	}

	/***************************************
	 * @see Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int nHashCode = super.hashCode();

		nHashCode =
			37 * nHashCode + ((sDatatype == null) ? 0 : sDatatype.hashCode());
		nHashCode = 37 * nHashCode + ((sId == null) ? 0 : sId.hashCode());
		nHashCode = 37 * nHashCode + ((sTitle == null) ? 0
													   : sTitle.hashCode());

		return nHashCode;
	}

	/***************************************
	 * Returns the column title.
	 *
	 * @see Object#toString()
	 */
	@Override
	public String toString() {
		return sTitle;
	}
}
