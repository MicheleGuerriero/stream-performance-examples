package polimi.deib.streamperformance.examples;

import java.util.concurrent.TimeUnit;

import org.apache.flink.api.common.JobExecutionResult;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.windowing.time.Time;

public class MinimalExample {

	public static void main(String args[]) throws Exception {

		String windowType="count";
		int windowLength = 5;
		int sourceSocketPort = 9999;
		String sourceSocketIp = "localhost";
		
		final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

		env.setParallelism(1);

		DataStream<String> text = env.socketTextStream(sourceSocketIp, sourceSocketPort);

		if(windowType.equals("count")) {
			DataStream<String> counts = text.countWindowAll(windowLength).apply(new MinimalCountWindowFunction());

			JobExecutionResult result = env.execute();
			System.out.println("EXECUTION TIME: " + result.getNetRuntime(TimeUnit.MILLISECONDS));
		}else {
			DataStream<String> counts = text.timeWindowAll(Time.seconds(windowLength)).apply(new MinimalTimeWindowFunction());

			JobExecutionResult result = env.execute();
			System.out.println("EXECUTION TIME: " + result.getNetRuntime(TimeUnit.MILLISECONDS));
		}


	}
}
