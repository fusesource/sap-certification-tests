package org.jboss.fuse.unicode.test;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;

public class CreateRfcReadTableRequest {

	public void printTableData(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:RFC_READ_TABLE", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("QUERY_TABLE", "RFCDOC");
		
		exchange.getIn().setBody(request);
	}

}
