package polimi.deib.streamperformance.examples;

import java.util.concurrent.TimeUnit;

import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class MinimalExample {

	public static void main(String args[]) throws Exception {

		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		env.setParallelism(1);

		DataStream<String> text = env.socketTextStream("localhost", 9999);

		DataStream<String> counts = text.timeWindowAll(Time.seconds(5)).apply(new MinimalWindowFunction());

		JobExecutionResult result = env.execute();
		System.out.println("EXECUTION TIME: " + result.getNetRuntime(TimeUnit.MILLISECONDS));

	}
}
