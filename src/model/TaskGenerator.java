package model;

import java.util.Random;

import controller.IDGenerator;

public class TaskGenerator {
	private static TaskGenerator instance;
	
	public static TaskGenerator instance(){
		if (instance == null){
			instance = new TaskGenerator();
		}
		return (instance);
	}
	
	public Task getNext(int min, int max){
		Random r = new Random();
		return (new Task((min + r.nextInt(max - min)) , IDGenerator.getNextTaskID()));
	}
}
