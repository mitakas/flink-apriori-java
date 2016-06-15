package com.mitakas.flink.apriori;

import java.util.ArrayList;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class TransactionReducer
implements GroupReduceFunction<Tuple2<Integer, Integer>, Tuple2<Integer, ArrayList<Integer>>> {

	private static final long serialVersionUID = 1L;

	@Override
	public void reduce(Iterable<Tuple2<Integer, Integer>> arg0, Collector<Tuple2<Integer, ArrayList<Integer>>> arg1)
			throws Exception {
		ArrayList<Integer> items = new ArrayList<>();
		Integer tid = null;
		for (Tuple2<Integer, Integer> transaction : arg0) {
			items.add(transaction.f1);
			tid = transaction.f0;
		}
		arg1.collect(new Tuple2<Integer, ArrayList<Integer>>(tid, items));
	}

}
