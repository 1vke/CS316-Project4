import java.util.concurrent.Callable;

class SimulationTask implements Callable<Long> {
	private final Long numPoints;

	public SimulationTask(long numPoints) {
		this.numPoints = numPoints;
	}

	@Override
	public Long call() {
		Long insideCircle = 0L;
		for (long i = 0; i < numPoints; i++) {
			double x = Math.random();
			double y = Math.random();
			if (x * x + y * y <= 1) {
				insideCircle++;
			}
		}
		return insideCircle;
	}
}
