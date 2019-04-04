package polimi.deib.streamperformance.examples;

import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.TimeWindow;
import org.apache.flink.util.Collector;

public class MinimalTimeWindowFunction implements AllWindowFunction<String, String, TimeWindow> {

	int c = 0;

	public void apply(TimeWindow window, Iterable<String> values, Collector<String> out) throws Exception {
		Thread.sleep(10);
		c = c + 1;
		System.out.println(c);
		out.collect(window.toString());
	}

}
