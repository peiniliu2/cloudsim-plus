package org.tianchi.trace.obj;

import java.util.List;

public class Pod {
	
	private String appName;
	
	private String group;
	
	private int gpu;
	
	private int cpu;
	
	private int ram;
	
	private int disk;
	
	private List<Integer> cpuids;

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
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

	public int getRam() {
		return ram;
	}

	public void setRam(int ram) {
		this.ram = ram;
	}

	public int getDisk() {
		return disk;
	}

	public void setDisk(int disk) {
		this.disk = disk;
	}

	public List<Integer> getCpuids() {
		return cpuids;
	}

	public void setCpuids(List<Integer> cpuids) {
		this.cpuids = cpuids;
	}
	
	
	
}
