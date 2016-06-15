package com.mitakas.flink.apriori;

import org.apache.flink.api.common.functions.FilterFunction;

public class ItemSetFrequencyFilter implements FilterFunction<ItemSet> {

	private static final long serialVersionUID = 1L;

	private final long minNumberOfTransactions;

	public ItemSetFrequencyFilter(long minNumberOfTransactions) {
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
