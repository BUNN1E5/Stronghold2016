package Measurements;

/**
 * 
 * @author Ghjf544912
 *
 */
public class Distance {
	
	public double rawDistance;
	public double treadLength;
	
	/**
	 * 
	 * @param rawDistance The encoder's raw distance value.
	 */
	public Distance(double rawDistance){
		this.rawDistance=rawDistance;
	}
	
	/**
	 * 
	 * @param rawDistance The encoder's raw distance value.
	 * @param treadLength The length of the treads on the row boat.
	 */
	public Distance(double rawDistance, double treadLength){
		this.rawDistance=rawDistance;
		this.treadLength=treadLength;
	}
	
	/**
	 * TODO: Add math to change raw distance to actual distance, remove rawDistance as return variable.
	 * @return Returns the raw distance value.
	 */
	public double getRawDistance(){
		
		return rawDistance;
	}
	
	/**
	 * TODO: Add math to change raw distance to actual distance, remove rawDistance as return variable.
	 * @return Distance in meters.
	 */
	public double getMeters(){
		
		return rawDistance;
	}
	
	/**
	 * TODO: Add math to change raw distance to actual distance, remove rawDistance as return variable.
	 * @return Distance in feet.
	 */
	public double getFeet(){
		
		return rawDistance;
	}
	
	/**
	 * TODO: Add math to change raw distance to actual distance, remove rawDistance as return variable.
	 * @return Distance in inches.
	 */
	public double getInches(){
		
		return rawDistance;
	}
	
	/**
	 * TODO: Add math to change raw distance to actual distance, remove rawDistance as return variable.
	 * @return Distance in terms of the number of times the treads have cycled.
	 */
	public double getTreadCycles(){
		
		return rawDistance;
	}
}
