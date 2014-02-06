/*
 * Copyright 2005-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ws.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.EndpointInterceptor;

public class DummyInterceptor implements EndpointInterceptor {

	@Autowired
	private DummyInterceptorDependency autowiredDependency;

	private DummyInterceptorDependency propertyDependency;

	public void setPropertyDependency(DummyInterceptorDependency propertyDependency) {
		this.propertyDependency = propertyDependency;
	}

	public DummyInterceptorDependency getPropertyDependency() {
		return propertyDependency;
	}

	public DummyInterceptorDependency getAutowiredDependency() {
		return autowiredDependency;
	}

	public boolean handleRequest(MessageContext messageContext, Object endpoint)
			throws Exception {
		return true;
	}

	public boolean handleResponse(MessageContext messageContext, Object endpoint)
			throws Exception {
		return true;
	}

	public boolean handleFault(MessageContext messageContext, Object endpoint)
			throws Exception {
		return true;
	}

	public void afterCompletion(MessageContext messageContext, Object endpoint,
			Exception ex) throws Exception {
	}
}