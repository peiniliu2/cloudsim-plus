package org.tianchi.trace.obj;

import java.util.List;

/**
 * 
 * @author peini liu
 *
 */
public abstract class AllNodesStates {
	
	private List<SingleNodeState> states;

	public List<SingleNodeState> getStates() {
		return states;
	}

	public void setStates(List<SingleNodeState> states) {
		this.states = states;
	}
	

}
