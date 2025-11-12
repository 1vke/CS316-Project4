import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

class SimulationTask implements Callable<Long> {
	private final Long numPoints;

	public SimulationTask(long numPoints) {
		this.numPoints = numPoints;
	}

	@Override
	public Long call() {
		Long insideCircle = 0L;

		// If `i` is of int type here, it will cause an infinite loop
		// with a large number of points
		for (long i = 0; i < numPoints; i++) {
			double x = ThreadLocalRandom.current().nextDouble();
			double y = ThreadLocalRandom.current().nextDouble();
			if (x * x + y * y <= 1) {
				insideCircle++;
			}
		}
		return insideCircle;
	}
}
