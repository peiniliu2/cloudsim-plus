package org.tianchi.trace.obj;

import java.util.List;
/**
 * 
 * @author peini liu
 *
 */
public class RuleSource {
	
	private int timeLimitInMins; //time limitation 60min
	
	private int defaultMaxInstancePerHost; //every app_group has two instances as default
	
	private List<GroupMaxInstancePerHost> groupMaxInstancePerHosts; //group's constraint [group like add or saperate? the maximum containers]

	private List<ReplicasMaxInstancePerHost> replicasMaxInstancePerHosts; // a conditional group's constraint [the maximum containers]

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
