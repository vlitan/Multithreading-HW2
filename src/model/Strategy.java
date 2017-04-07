package model;

import java.util.ArrayList;

public interface Strategy {
	public void setThreshold(int t);
	public void addTask(ArrayList<Server> servers, Task t, boolean allowedToCreateNew);
}
