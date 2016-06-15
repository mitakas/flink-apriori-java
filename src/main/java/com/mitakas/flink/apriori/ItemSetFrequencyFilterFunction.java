package com.mitakas.flink.apriori;

import org.apache.flink.api.common.functions.FilterFunction;

public class ItemSetFrequencyFilterFunction implements FilterFunction<ItemSet> {

	private static final long serialVersionUID = 1L;

	private final long minNumberOfTransactions;

	public ItemSetFrequencyFilterFunction(long minNumberOfTransactions) {
		this.minNumberOfTransactions = minNumberOfTransactions;
	}

	/**
	 * Filters ItemSets with frequency < minNumberOfTransactions
	 *
	 */
	@Override
	public boolean filter(ItemSet arg0) throws Exception {
		return arg0.getNumberOfTransactions() >= this.minNumberOfTransactions;
	}

}
