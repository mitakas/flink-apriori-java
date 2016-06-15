package com.mitakas.flink.apriori;

import java.util.ArrayList;

import org.apache.flink.api.common.functions.CrossFunction;

public class ItemSetCrossFunction implements CrossFunction<ItemSet, ItemSet, ItemSet> {

	private static final long serialVersionUID = 1L;

	@Override
	public ItemSet cross(ItemSet arg0, ItemSet arg1) throws Exception {
		// create a new ArrayList of items
		ArrayList<Integer> items = arg0.items;

		// only add new items
		for (Integer item : arg1.items) {
			if (!items.contains(item)) {
				items.add(item);
			}
		}

		// create a new ItemSet
		ItemSet newItemSet = new ItemSet(items);
		// set a temporary number of transactions
		newItemSet.setNumberOfTransactions(arg0.getNumberOfTransactions());

		return newItemSet;
	}

}
