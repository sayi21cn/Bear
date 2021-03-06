package com.lmc.filtersourcefile;

import java.io.IOException;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class FilterReduce extends Reducer<Text, Text, NullWritable, Text> {
	public void reduce(Text key, Iterable<Text> values, Context context)
			throws IOException, InterruptedException {
		if (key != null && !key.equals("") && values!=null){
			context.write(NullWritable.get(), new Text(key.toString() + "\7"
					+ values.iterator().next().toString()));
		}
	}
}
