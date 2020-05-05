package org.tianchi.trace.obj;

import java.util.List;

/**
 * 
 * @author peini liu
 *
 */
public class Node {
	
	private String sn;
	
	private String smName;
	
	private int gpu;
	
	private int cpu;
	
	private int disk;
	
	private int ram;
	
	private int eni;
	
	private List<Topology> topologies;
	
	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getSmName() {
		return smName;
	}

	public void setSmName(String smName) {
		this.smName = smName;
	}

	public int getGpu() {
		return gpu;
	}

	public void setGpu(int gpu) {
		this.gpu = gpu;
	}

	public int getCpu() {
		return cpu;
	}

	public void setCpu(int cpu) {
		this.cpu = cpu;
	}

	public int getDisk() {
		return disk;
	}

	public void setDisk(int disk) {
		this.disk = disk;
	}

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getEni() {
		return eni;
	}

	public void setEni(int eni) {
		this.eni = eni;
	}

	public List<Topology> getTopologies() {
		return topologies;
	}

	public void setTopologies(List<Topology> topologies) {
		this.topologies = topologies;
	}

}
