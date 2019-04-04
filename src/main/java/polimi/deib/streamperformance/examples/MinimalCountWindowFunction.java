package polimi.deib.streamperformance.examples;

import org.apache.flink.api.java.tuple.Tuple;
import org.apache.flink.streaming.api.functions.windowing.AllWindowFunction;
import org.apache.flink.streaming.api.windowing.windows.GlobalWindow;
import org.apache.flink.util.Collector;

public class MinimalCountWindowFunction implements AllWindowFunction<String, String, GlobalWindow> {

	int c = 0;

	public void apply(GlobalWindow window, Iterable<String> values, Collector<String> out) throws Exception {
		Thread.sleep(10);
		c = c + 1;
		System.out.println(c);
		out.collect(window.toString());
	}

}
