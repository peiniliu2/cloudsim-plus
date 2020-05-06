package org.tianchi.results.evaluation;

import java.lang.management.GarbageCollectorMXBean;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.naming.event.NamespaceChangeListener;

import org.apache.commons.collections4.Put;
import org.tianchi.results.csv.TianchiResult;
import org.tianchi.results.evaluation.obj.AppGroupCounter;
import org.tianchi.trace.obj.GroupMaxInstancePerHost;
import org.tianchi.trace.obj.Pod;
import org.tianchi.trace.obj.ReplicasMaxInstancePerHost;
import org.tianchi.trace.obj.RuleSource;
import org.tianchi.trace.obj.SingleNodeState;

/**
 * This metric measures the distribution
 * @author peini liu
 *
 */
public class DistributionMetric implements Metrics {
	
	private TianchiResult tianchiresult;//input
	
	private RuleSource ruleSource;//input
	
	private float score = 0;//output
	
	public DistributionMetric(TianchiResult tianchiresult, RuleSource ruleSource) {
		super();
		this.tianchiresult = tianchiresult;
		this.ruleSource = ruleSource;
	}
	
	//key groupname, value nodenamelist
	private HashMap<String,List<String>> appGroupNodes = new HashMap<String, List<String>>();

	private List<AppGroupCounter> appGroupCounters  = new ArrayList<AppGroupCounter>();
	
	@Override
	public float getScore() {
		// TODO Auto-generated method stub
		//calculate the distribution by appgroup
		computeAppGroupCounter();
		
		//add constraints
		int defaultMaxInstancePerHost = ruleSource.getDefaultMaxInstancePerHost();
		int timeLimitInMins = ruleSource.getTimeLimitInMins();		
		//satisfy rule
		int maxInstancePerHost = defaultMaxInstancePerHost;
		
		for(AppGroupCounter appGroupCounter : appGroupCounters) {
			//rule1
			List<GroupMaxInstancePerHost> rule1  = ruleSource.getGroupMaxInstancePerHosts().stream()
					.filter(grouprule -> grouprule.getGroup().equals(appGroupCounter.getGroup()))
					.collect(Collectors.toList());
			maxInstancePerHost = rule1.get(0).getMaxInstancePerHost();
			
			//rule2
			List<ReplicasMaxInstancePerHost> rule2 = ruleSource.getReplicasMaxInstancePerHosts().stream()
					.sorted(Comparator.comparing(ReplicasMaxInstancePerHost::getReplicas))
					.filter(grouprule -> {
							if (grouprule.getRestrain() == "le") { //less equal
								appGroupCounter.getReplicas() <= grouprule.getReplicas();
							}else if (grouprule.getRestrain() == "ge") { //geater equal
								
							}
						})
					.collect(Collectors.toList());
			
			
		}
		
		
			appGroupCounter.getDistribution().forEach((node,n_ctn) -> {
				if(maxInstancePerHost == 1 && n_ctn > 1) {
					score = -1;
					System.out.println("maxInstancePerHost is 1, but node "+node+"  has  "+n_ctn+ "  containers.") ;
					return;
				}else {
					if(groupMaxInstancePerHost.isCompactness()) { //the more the better
					} else { //the less the better
						
				}
			});
			
			groupMaxInstancePerHost.getMaxInstancePerHost();
		}
	
		return score;
	}
	
	private void computeAppGroupCounter() {
		//mapping -> applicationgroup -> their containers' running node
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
		
		//applicationgroupcounters
		appGroupNodes.forEach((group, nodelist) -> {
			AppGroupCounter appGroupCounter = new AppGroupCounter();
			appGroupCounter.setGroup(group);
			appGroupCounter.setReplicas(nodelist.size());//dynamic calculated, can be read from the application obj
			Map<Object, Long> distribution = nodelist.stream().collect(Collectors.groupingBy(nodename -> nodename, Collectors.counting()));
			appGroupCounter.setDistribution(distribution);
			appGroupCounters.add(appGroupCounter);
		});
	}




}
