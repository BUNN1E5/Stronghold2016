package Wrapper;

public class Timer {
	
	double deltaTime = 0, startTime ;
	
	public void start() {//sorry but i didn't like using an object to do the start functino
		startTime = System.currentTimeMillis();	
	}
	
	/**
	 * 
	 * @return The current time on the timer.
	 */
	public double getTime(){
		return System.currentTimeMillis() - startTime;
	}
	
	
	public double getDeltaTime(){
		return deltaTime;
	}
	
	/**
	 * @author Ghjf544912
	 */
	public void updateDeltaTime(){
		deltaTime=startTime-getTime();
	}
	
	public void reset(){
		startTime = System.currentTimeMillis();
	}
	
	/**
	 * TODO: Add descriptions for the doc here.
	 * @param time
	 * @return
	 */
	public boolean wait(double time){
		if (time >= getTime())
			return true;
		return false;
	}
	
}
