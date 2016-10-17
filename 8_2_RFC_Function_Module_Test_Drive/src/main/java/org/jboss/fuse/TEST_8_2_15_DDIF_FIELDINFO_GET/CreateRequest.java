package org.jboss.fuse.TEST_8_2_15_DDIF_FIELDINFO_GET;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:DDIF_FIELDINFO_GET", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		request.put("TABNAME", "SWOTBASDAT");
		request.put("FIELDNAME", "");
		request.put("LFIELDNAME", "");
		request.put("LANGU", "EN");
		request.put("ALL_TYPES", "X");

		exchange.getIn().setBody(request);
	}

}
