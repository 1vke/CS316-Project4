import java.util.concurrent.Callable;

class SimulationTask implements Callable<Integer> {
	private final int numPoints;

	public SimulationTask(int numPoints) {
		this.numPoints = numPoints;
	}

	@Override
	public Integer call() {
		// TODO: Finish this
		return 0;
	}
}
