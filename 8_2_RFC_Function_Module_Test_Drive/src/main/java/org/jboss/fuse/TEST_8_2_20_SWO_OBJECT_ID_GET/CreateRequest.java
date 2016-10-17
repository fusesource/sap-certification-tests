package org.jboss.fuse.TEST_8_2_20_SWO_OBJECT_ID_GET;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:SWO_OBJECT_ID_GET", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		// Retrive Object Handle from Exchange
		Integer objectHandle = exchange.getProperty("org.jboss.fuse.TEST_8_2_18_SWO_INVOKE.OBJECT_HANDLE", Integer.class);

		request.put("OBJECT", objectHandle);

		exchange.getIn().setBody(request);
	}

}
