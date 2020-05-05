package org.tianchi.trace.obj;

import java.util.List;

public abstract class AllNodesStatus {
	
	private List<SingleNodeStatus> sources;

	public List<SingleNodeStatus> getSources() {
		return sources;
	}

	public void setSources(List<SingleNodeStatus> sources) {
		this.sources = sources;
	}
	

}
