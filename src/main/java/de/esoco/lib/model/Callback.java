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
 * A callback interface for asynchronous (remote) method executions. It provides
 * two methods: {@link #onSuccess(Object)} will be called if the execution was
 * successful while {@link #onError(Throwable)} will be invoked if an exception
 * was thrown. The generic type defines the result that will be available in the
 * case of a successful invocation.
 *
 * @author eso
 */
public interface Callback<T> {

	//~ Methods ----------------------------------------------------------------

	/***************************************
	 * Will be invoked if the asynchronous execution caused an error.
	 *
	 * @param eError The exception that signaled the error
	 */
	public void onError(Throwable eError);

	/***************************************
	 * Will be invoked if the asynchronous execution was successful.
	 *
	 * @param rResult The result of the execution
	 */
	public void onSuccess(T rResult);
}
