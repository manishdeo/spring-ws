/*
 * Copyright 2005-2010 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.ws.server.endpoint.mapping;

import javax.xml.namespace.QName;

import junit.framework.TestCase;
import org.springframework.ws.MockWebServiceMessage;
import org.springframework.ws.MockWebServiceMessageFactory;
import org.springframework.ws.context.DefaultMessageContext;
import org.springframework.ws.context.MessageContext;

public class PayloadRootQNameEndpointMappingTest extends TestCase {

    private PayloadRootQNameEndpointMapping mapping;

    @Override
    protected void setUp() throws Exception {
        mapping = new PayloadRootQNameEndpointMapping();
    }

    public void testResolveQNames() throws Exception {
        MockWebServiceMessage request = new MockWebServiceMessage("<root/>");
        MessageContext context = new DefaultMessageContext(request, new MockWebServiceMessageFactory());

        QName qName = mapping.resolveQName(context);
        assertNotNull("mapping returns null", qName);
        assertEquals("mapping returns invalid qualified name", new QName("root"), qName);
    }

    public void testGetQNameNameNamespace() throws Exception {
        MockWebServiceMessage request = new MockWebServiceMessage("<prefix:localname xmlns:prefix=\"namespace\"/>");
        MessageContext context = new DefaultMessageContext(request, new MockWebServiceMessageFactory());

        QName qName = mapping.resolveQName(context);
        assertNotNull("mapping returns null", qName);
        assertEquals("mapping returns invalid method name", new QName("namespace", "localname", "prefix"), qName);
    }
}