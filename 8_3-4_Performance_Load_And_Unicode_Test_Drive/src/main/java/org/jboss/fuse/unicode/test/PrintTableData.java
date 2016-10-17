package org.jboss.fuse.unicode.test;

import java.util.List;
import java.util.ArrayList;

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
		
		List<Integer> offsets = new ArrayList<Integer>(); 
		List<Integer> lengths = new ArrayList<Integer>(); 
		int lineWidth = 0;
		for (Structure row : fields) {
			String fieldName = row.get("FIELDNAME", String.class);
			int offset = Integer.parseInt(row.get("OFFSET", String.class));
			int length = Integer.parseInt(row.get("LENGTH", String.class));
			offsets.add(offset);
			lengths.add(length);
			lineWidth += length;
			int padding = length - fieldName.length();
			buffer.append(fieldName);
			while(padding-- > 0) {
				buffer.append(" ");
			}
			buffer.append("\t");
		}
		buffer.append("\n");
		
		for (int i = 0; i < lineWidth; i++) {
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
			appendFormattedLine(buffer, wa, offsets, lengths);
		}

		exchange.getIn().setBody(buffer.toString());
	}
	
	private void appendFormattedLine(StringBuffer buffer, String line, List<Integer> offsets, List<Integer> lengths) {
		for (int i = 0; i < offsets.size(); i++) {
			int offset = offsets.get(i);
			int length = lengths.get(i);
			if (offset >= line.length()) {
				break;
			}
			if (offset + length > line.length()) {
				buffer.append(line.substring(offset, line.length()));
			} else {
				String value = line.substring(offset, offset + length);
				buffer.append(line.substring(offset, offset + length));
			}
			buffer.append("\t");
		}
		buffer.append("\n");
	}

}
