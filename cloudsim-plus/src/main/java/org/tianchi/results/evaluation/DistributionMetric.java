package org.tianchi.results.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.tianchi.results.csv.TianchiResult;
import org.tianchi.results.evaluation.obj.AppGroupCounter;
import org.tianchi.trace.obj.Pod;
import org.tianchi.trace.obj.SingleNodeState;

/**
 * This metric measures the distribution
 * @author peini liu
 *
 */
public class DistributionMetric implements Metrics {
	
	private TianchiResult tianchiresult;//input
	
	private float score;//output
	
	public DistributionMetric(TianchiResult tianchiresult) {
		super();
		this.tianchiresult = tianchiresult;
	}
	
	//key groupname, value nodenamelist
	private HashMap<String,List<String>> appGroupNodes = new HashMap<String, List<String>>();

	private List<AppGroupCounter> appGroupCounters  = new ArrayList<AppGroupCounter>();
	
	@Override
	public float getScore() {
		// TODO Auto-generated method stub
		for (SingleNodeState singleNodeState : tianchiresult.getStates()) {
			String sn = singleNodeState.getNode().getSn(); //node name	
			for (Pod pod : singleNodeState.getPods()) {
				String key = pod.getGroup(); //application group name
				if(appGroupNodes.containsKey(key)) {
					appGroupNodes.get(key).add(sn);
				}else {
					appGroupNodes.put(key, List.of(sn));
				}
			}
		}
		
		appGroupNodes.forEach((group, nodelist) -> {
			AppGroupCounter appGroupCounter = new AppGroupCounter();
			appGroupCounter.setGroup(group);
			appGroupCounter.setReplicas(nodelist.size());
			Map<Object, Long> distribution = nodelist.stream().collect(Collectors.groupingBy(nodename -> nodename, Collectors.counting()));
			appGroupCounter.setDistribution(distribution);
			appGroupCounters.add(appGroupCounter);
		});
		
		
	
		return score;
	}




}
