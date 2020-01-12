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

import java.util.Map;

import static de.esoco.lib.property.PropertyName.newIntegerName;
import static de.esoco.lib.property.PropertyName.newMapName;


/********************************************************************
 * Contains property name declarations for the access of persistent data
 * storages.
 *
 * @author eso
 */
public interface StorageProperties {

	//~ Static fields/initializers ---------------------------------------------

	/** Integer: the starting index of a storage query. */
	public static final PropertyName<Integer> QUERY_START =
		newIntegerName("QUERY_START");

	/** Integer: the maximum result size of a storage query. */
	public static final PropertyName<Integer> QUERY_LIMIT =
		newIntegerName("QUERY_LIMIT");

	/** Integer: the maximum depth of a hierarchical storage query. */
	public static final PropertyName<Integer> QUERY_DEPTH =
		newIntegerName("QUERY_DEPTH");

	/**
	 * Map&lt;String, String&gt;: a mapping from storage fields to filter
	 * criteria.
	 */
	public static final PropertyName<Map<String, String>> QUERY_SEARCH =
		newMapName("QUERY_SEARCH", String.class, String.class);

	/**
	 * Map&lt;String, String&gt;: a mapping from storage fields to sort
	 * directions.
	 */
	public static final PropertyName<Map<String, SortDirection>> QUERY_SORT =
		newMapName("QUERY_SORT", String.class, SortDirection.class);

	//~ Static methods ---------------------------------------------------------

	/***************************************
	 * This method should be invoked to initialize the property name constants
	 * for de-serialization.
	 */
	public static void init() {
	}
}
