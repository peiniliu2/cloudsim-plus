package org.tianchi.trace.obj;

import java.util.List;

public class RuleSource {
	
	private int timeLimitInMins; //time limitation 60min
	
	private int defaultMaxInstancePerHost;
	
	private List<GroupMaxInstancePerHost> groupMaxInstancePerHosts;

	private List<ReplicasMaxInstancePerHost> replicasMaxInstancePerHosts;

	public int getTimeLimitInMins() {
		return timeLimitInMins;
	}

	public void setTimeLimitInMins(int timeLimitInMins) {
		this.timeLimitInMins = timeLimitInMins;
	}

	public int getDefaultMaxInstancePerHost() {
		return defaultMaxInstancePerHost;
	}

	public void setDefaultMaxInstancePerHost(int defaultMaxInstancePerHost) {
		this.defaultMaxInstancePerHost = defaultMaxInstancePerHost;
	}

	public List<GroupMaxInstancePerHost> getGroupMaxInstancePerHosts() {
		return groupMaxInstancePerHosts;
	}

	public void setGroupMaxInstancePerHosts(List<GroupMaxInstancePerHost> groupMaxInstancePerHosts) {
		this.groupMaxInstancePerHosts = groupMaxInstancePerHosts;
	}

	public List<ReplicasMaxInstancePerHost> getReplicasMaxInstancePerHosts() {
		return replicasMaxInstancePerHosts;
	}

	public void setReplicasMaxInstancePerHosts(List<ReplicasMaxInstancePerHost> replicasMaxInstancePerHosts) {
		this.replicasMaxInstancePerHosts = replicasMaxInstancePerHosts;
	}
	
}
