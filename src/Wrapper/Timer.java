package Wrapper;

public class Timer {
	
	double deltaTime = 0, startTime ;
	
	public void start() {
		startTime = System.currentTimeMillis();	
	}
	
	/**
	 * 
	 * @return The current time on the timer.
	 */
	public double getTime(){
		return System.currentTimeMillis() - startTime;
	}
	
	/**
	 * 
	 * @return The change in time.
	 */
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
	 * @param time Time to wait.
	 * @return Returns true if it's still waiting, false if the wait period is over.
	 */
	public boolean wait(double time){
		if (time >= getTime())
			return true;
		return false;
	}
	
}
