package mlsched.events;

import mlsched.simulator.Main;
import mlsched.workload.Job;
import mlsched.workload.Statistics;

public class JobCompleted extends Event {

	public JobCompleted(double timeStamp, Job j) {
		super(timeStamp, j);
	}

	@Override
	public void eventHandler() {
		
		Main.jobList.remove(j);
		
		Statistics statObj = Main.jobStats.get(j.jobId); 
		statObj.jobEndTime = timeStamp;
		Main.jobStats.put(j.jobId, statObj);
		
		// If not SLAQ then do this - 
		if(!Main.epochScheduling) {
			Main.eventQueue.add(new ComputeLogicalFairShare(Main.currentTime));
		}
	}
}
