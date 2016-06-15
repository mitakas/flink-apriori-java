package com.mitakas.flink.apriori;

import java.util.ArrayList;
import java.util.Collection;

import org.apache.flink.api.common.functions.RichMapFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.configuration.Configuration;

public class ItemSetCalculateFrequency extends RichMapFunction<ItemSet, ItemSet> {

	private static final long serialVersionUID = 1L;
	private Collection<Tuple2<Integer, ArrayList<Integer>>> transactions;

	@Override
	public void open(Configuration parameters) throws Exception {
		this.transactions = getRuntimeContext().getBroadcastVariable("transactions");
	}

	@Override
	public ItemSet map(ItemSet arg0) throws Exception {

		ItemSet out = new ItemSet(arg0.items);
		int numberOfTransactions = 0;

		for (Tuple2<Integer, ArrayList<Integer>> transaction : this.transactions) {
			if (transaction.f1.containsAll(arg0.items)) {
				numberOfTransactions++;
			}
		}

		out.setNumberOfTransactions(numberOfTransactions);
		return out;
	}

}
