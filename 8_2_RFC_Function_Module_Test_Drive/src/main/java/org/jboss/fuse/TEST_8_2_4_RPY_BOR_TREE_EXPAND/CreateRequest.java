package org.jboss.fuse.TEST_8_2_4_RPY_BOR_TREE_EXPAND;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;

public class CreateRequest {

	public void createRequest(Exchange exchange) throws Exception {

		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint("sap-srfc-destination:quickstartDest:RPY_BOR_TREE_EXPAND", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		
		Structure objectTypeId = request.get("OBJECT_TYPE_ID", Structure.class);
		objectTypeId.put("OBJTYPE_ID", "BUS2005");
		
		Structure filterRelationships = request.get("FILTER_RELATIONSHIPS", Structure.class);
		filterRelationships.put("ALLRELSHIP", "X");
		filterRelationships.put("INHSUB", "X");
		filterRelationships.put("COMPPART", "X");

		exchange.getIn().setBody(request);
	}

}
