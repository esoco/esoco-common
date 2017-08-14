//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
// This file is a part of the 'esoco-common' project.
// Copyright 2017 Elmar Sonnenschein, esoco GmbH, Flensburg, Germany
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
import java.util.Collection;
import java.util.List;


/********************************************************************
 * A {@link DataProvider} implementation that is backed by a {@link List}.
 *
 * @author eso
 */
public class ListDataProvider<T> implements DataProvider<T>
{
	//~ Instance fields --------------------------------------------------------

	private final List<T> aData;

	//~ Constructors -----------------------------------------------------------

	/***************************************
	 * Creates a new instance.
	 *
	 * @param rData A collection containing the provider data
	 */
	public ListDataProvider(Collection<T> rData)
	{
		aData = new ArrayList<>(rData);
	}

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public Collection<T> getData(int nStart, int nCount)
	{
		if (nStart > aData.size())
		{
			nStart = aData.size();
		}

		int nEnd = nStart + nCount;

		if (nEnd > aData.size())
		{
			nEnd = aData.size();
		}

		return aData.subList(nStart, nEnd);
	}

	/***************************************
	 * {@inheritDoc}
	 */
	@Override
	public int size()
	{
		return aData.size();
	}
}
