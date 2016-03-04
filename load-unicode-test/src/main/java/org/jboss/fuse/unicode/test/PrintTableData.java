package org.jboss.fuse.unicode.test;

import org.apache.camel.Exchange;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.fusesource.camel.component.sap.model.rfc.Table;

public class PrintTableData {

	public void printTableData(Exchange exchange) throws Exception {

		Structure rfcGetTableResponse = exchange.getIn().getBody(Structure.class);

		if (rfcGetTableResponse == null) {
			return;
		}

		StringBuffer buffer = new StringBuffer();

		@SuppressWarnings("unchecked")
		Table<Structure> fields = rfcGetTableResponse.get("FIELDS", Table.class);
		if (fields == null) {
			return;
		}
		for (Structure row : fields) {
			String fieldName = row.get("FIELDNAME", String.class);
			int offset = Integer.parseInt(row.get("OFFSET", String.class));
			for (int i = 0; i < offset; i++) {
				buffer.append(" ");
			}
			buffer.append(fieldName);
			buffer.append("\n");
		}
		
		for (int i = 0; i < 177 + 72; i++) {
			buffer.append("=");
		}
		buffer.append("\n");

		@SuppressWarnings("unchecked")
		Table<Structure> data = rfcGetTableResponse.get("DATA", Table.class);
		if (data == null) {
			return;
		}
		for (Structure row : data) {
			String wa = row.get("WA", String.class);
			buffer.append(wa).append("\n");
		}

		exchange.getIn().setBody(buffer.toString());
	}

}
