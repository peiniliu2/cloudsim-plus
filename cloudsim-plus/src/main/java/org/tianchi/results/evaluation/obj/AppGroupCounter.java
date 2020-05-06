package org.tianchi.results.evaluation.obj;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author peini liu
 *
 */
public class AppGroupCounter {
	
	private String group;
	
	private int replicas;
	
	private Map<Object,Long> distribution; 
	
	private int maxInstancePerHost = 2;
	
	private boolean requirment = false;

	public int getReplicas() {
		return replicas;
	}

	public void setReplicas(int replicas) {
		this.replicas = replicas;
	}

	public AppGroupCounter() {
		super();
	}
	
	public String getGroup() {
		return group;
	}
	
	public void setGroup(String group) {
		this.group = group;
	}

	public Map<Object,Long> getDistribution() {
		return distribution;
	}

	public void setDistribution(Map<Object,Long> distribution) {
		this.distribution = distribution;
	}

	public int getMaxInstancePerHost() {
		return maxInstancePerHost;
	}

	public void setMaxInstancePerHost(int maxInstancePerHost) {
		this.maxInstancePerHost = maxInstancePerHost;
	}

	public boolean isRequirment() {
		return requirment;
	}

	public void setRequirment(boolean requirment) {
		this.requirment = requirment;
	}



	
}