### Readme

To compile the project run:

```sh
$ mvn clean package    
```

To run the project use Flnk 1.6. Start the Flink cluster locally with a single 
task manager and one task slot. The submit the .jar file to Flink:
```sh
$ ./start-cluster.sh
$ ./flink run examples-0.0.1-SNAPSHOT.jar
```

Beware that the example application currently need the socket server from where it gets input tuples to be up and running before the applicaton is launched.

You can download Flink from [here](http://it.apache.contactlab.it/flink/flink-1.6.4/flink-1.6.4-bin-scala_2.11.tgz)

Due to the fact that currently our very minimal example prints the count of the windows produced to the standard output, you can find this counting into the file in which the task manager writes its standard output in the 'log' folder of Flink (for example, flink-1.6.4/log/flink-warmik-taskexecutor.out).

