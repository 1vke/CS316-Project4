import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		long totalPoints = 1_000_000L;
		int numThreads = 4;
		long pointsPerTask = totalPoints / numThreads;

		ExecutorService executor = Executors.newFixedThreadPool(numThreads);
		List<Future<Long>> futures = new ArrayList<>();

		Instant start = Instant.now();

		for (int i = 0; i < numThreads; i++) {
			Callable<Long> task = new SimulationTask(pointsPerTask);
			futures.add(executor.submit(task));
		}

		int totalInsideCircle = 0;
		for (Future<Long> future : futures) {
			totalInsideCircle += future.get();
		}

		executor.shutdown();

		Instant finish = Instant.now();
        long runtime = Duration.between(start, finish).toMillis();

		double piEstimate = 4.0 * totalInsideCircle / totalPoints;

		System.out.println("Total points: " + totalPoints);
		System.out.println("Points inside circle: " + totalInsideCircle);
		System.out.println("Pi estimate: " + piEstimate);
		System.out.println("Runtime: " + runtime + " ms");
	}
}
