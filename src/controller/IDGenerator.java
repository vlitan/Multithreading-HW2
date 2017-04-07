package controller;

public class IDGenerator {
	static int taskID = 0;
	static int serverID = 0;
	
	public static int getNextTaskID(){
		return (taskID++);
	}
	
	public static int getNextServerID(){
		return (serverID++);
	}
}
