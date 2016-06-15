package com.mitakas.flink.apriori;

import org.apache.flink.api.java.io.TextOutputFormat.TextFormatter;

public class ItemSetTextFormatter implements TextFormatter<ItemSet> {

	private static final long serialVersionUID = 1L;

	@Override
	public String format(ItemSet value) {
		return value.textFormat();
	}

}
