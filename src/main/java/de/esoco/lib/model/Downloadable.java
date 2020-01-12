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

/********************************************************************
 * An interface for objects (typically {@link DataModel DataModels}) that allow
 * their content to be downloaded.
 *
 * @author eso
 */
public interface Downloadable {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Prepares this object's content for download. The resulting value is a
	 * reference to the downloadable document. This is typically a URI or URL
	 * that must be resolved to initiate the download. The actual meaning
	 * maximum download size value depends on the content. For example, it could
	 * be the number of bytes of a binary download or the number of rows of
	 * table data.
	 *
	 * @param sFileName The file name to assign to the download
	 * @param nMaxSize  The maximum download size
	 * @param rCallback The callback to be notified of the download reference
	 */
	public void prepareDownload(String			 sFileName,
								int				 nMaxSize,
								Callback<String> rCallback);
}
