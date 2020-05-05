package org.tianchi.trace.obj;

import java.util.List;

/**
 * Status of one node
 * @author peini liu
 *
 */
public class SingleNodeState {
	
	private Node node;
	
	private List<Pod> pods;

	public Node getNode() {
		return node;
	}

	public void setNode(Node node) {
		this.node = node;
	}

	public List<Pod> getPods() {
		return pods;
	}

	public void setPods(List<Pod> pods) {
		this.pods = pods;
	}
	
	

}
