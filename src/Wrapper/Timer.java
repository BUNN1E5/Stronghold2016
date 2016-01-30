package Wrapper;

public class Timer {
	
	double deltaTime = 0, startTime ;
	
	public Timer () {
		startTime = System.currentTimeMillis();	
	}
	
	public double getTime(){
		return System.currentTimeMillis() - startTime;
	}
	
	public double getDeltaTime(){
		return deltaTime;
	}
	
	public void reset(){
		startTime = System.currentTimeMillis();
	}
	
	public boolean wait(double time){
		if (time >= getTime())
			return true;
		return false;
	}
	
}
