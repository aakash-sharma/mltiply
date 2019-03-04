package mlsched.events;

import mlsched.simulator.Main;
import mlsched.workload.Job;

public class JobArrived extends Event {
	
	public JobArrived(double timeStamp, Job j) {
		super(timeStamp, j);
	}

	@Override
	public void eventHandler() {
		Main.interJobScheduler.allocGPUs(this.j);
	}
}
