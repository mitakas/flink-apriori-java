package com.mitakas.flink.apriori;

import org.apache.flink.api.common.functions.ReduceFunction;

public class ItemSetReduceFunction implements ReduceFunction<ItemSet> {

	private static final long serialVersionUID = 1L;

	/**
	 * Returns a new ItemSet instance with 'frequency' as the sum of
	 * the two input ItemSets
	 *
	 */
	@Override
	public ItemSet reduce(ItemSet arg0, ItemSet arg1) throws Exception {
		ItemSet item = new ItemSet(arg0.items);
		item.setNumberOfTransactions(arg0.getNumberOfTransactions() + arg1.getNumberOfTransactions());

		return item;
	}

}
