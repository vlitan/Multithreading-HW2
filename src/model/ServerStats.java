package model;

public class ServerStats {
	
	private int	totalWaitingTime = 0;
	private int	totalTaskCount = 0;
	private int	peakWaitingTime = 0;
	private int id;
	
	public ServerStats(int id){
		this.id = id;
	}
	
	public ServerStats(ServerStats s){
		totalWaitingTime = s.getTotalWaitingTime();
		totalTaskCount = s.getTotalTaskCount();
		peakWaitingTime = s.getPeakWaitingTime();
		id = s.getId();
	}
	
	public int getId() {
		return id;
	}

	
	@Override
	public String toString(){
		return ("Stats for server " + this.id + ": Average waiting time : " + getAverageWaitingTime() + ", peak waiting time : " + getPeakWaitingTime() + ", total task count : " + getTotalTaskCount());
	}
	
	public String toFormatedString(){
		return ("<html>Stats for server " + this.id + "<br>Average waiting time : " + getAverageWaitingTime() + "<br>Peak waiting time : " + getPeakWaitingTime() + "<br>total task count : " + getTotalTaskCount() + "</html>");
	}
	
	public void incTaskCount(){
		totalTaskCount++;
	}
	
	public void setMax(int candidate){
		if (candidate > peakWaitingTime){
			peakWaitingTime = candidate;
		}
	}
	
	public void addToTotalWaitingTime(int add){
		totalWaitingTime += add;
	}
	
	public float getAverageWaitingTime(){
		return (totalWaitingTime / totalTaskCount);
	}
	
	public int	getPeakWaitingTime(){
		return (peakWaitingTime);
	}
	
	public int getProcessedTasksCount(){
		return (totalTaskCount);
	}
	public int getTotalTaskCount() {
		return totalTaskCount;
	}

	public void setTotalTaskCount(int totalTaskCount) {
		this.totalTaskCount = totalTaskCount;
	}

	public void setPeakWaitingTime(int peakWaitingTime) {
		this.peakWaitingTime = peakWaitingTime;
	}

	public int getTotalWaitingTime() {
		return totalWaitingTime;
	}

	public void setTotalWaitingTime(int totalWaitingTime) {
		this.totalWaitingTime = totalWaitingTime;
	}
}
