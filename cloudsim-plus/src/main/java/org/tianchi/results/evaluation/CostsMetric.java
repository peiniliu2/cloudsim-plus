package org.tianchi.results.evaluation;

import java.util.List;

import org.cloudbus.cloudsim.vms.VmCost;
import org.tianchi.results.csv.TianchiResult;
import org.tianchi.trace.obj.Pod;
import org.tianchi.trace.obj.SingleNodeState;

/**
 * This metric measures the costs
 * @author peini liu
 *
 */
public class CostsMetric implements Metrics{

	private TianchiResult tianchiresult;//input
	
	private float costs;//output
	
	public CostsMetric(TianchiResult tianchiresult) {
		super();
		this.tianchiresult = tianchiresult;
	}

	@Override
	public float getScore() {
		// TODO Auto-generated method stub
		for (SingleNodeState singleNodeState : tianchiresult.getStates()) {
			//gpu:10/ka ; cpu:2/core ; ram:1/GB
			int gpu = singleNodeState.getNode().getGpu();
			int cpu = singleNodeState.getNode().getCpu();
			int ram = singleNodeState.getNode().getRam();		
			int machinecost  = 10 * gpu + 2 * cpu + 1 * ram; 
			//cost if the machine has containers
			List<Pod> pods = singleNodeState.getPods();
			if(pods != null) {
				costs = costs + machinecost;
			}
		}
		return costs;
	}

}
