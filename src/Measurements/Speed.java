package Measurements;

/**
 * 
 * @author Ghjf544912
 *
 */
public class Speed {
	
	public double rawSpeed;
	public double treadLength;
	
	/**
	 * 
	 * @param rawSpeed The encoder's raw speed value.
	 */
	public Speed(double rawSpeed){
		this.rawSpeed=rawSpeed;
	}
	
	/**
	 * 
	 * @param rawSpeed The encoder's raw speed value.
	 * @param treadLength The length of the treads on the row boat.
	 */
	public Speed(double rawSpeed, double treadLength){
		this.rawSpeed=rawSpeed;
		this.treadLength=treadLength;
	}
	
	/**
	 * 
	 * @return Returns the raw speed value.
	 */
	public double getRawSpeed(){
		
		return rawSpeed;
	}

	/**
	 * TODO: Add math to change raw speed to actual speed, remove rawSpeed as return variable.
	 * @return Speed in RPMs.
	 */
	public double getRPM(){
		
		return rawSpeed;
	}
	
	/**
	 * TODO: Add math to change raw speed to actual speed, remove rawSpeed as return variable.
	 * @return Speed in meters/sec.
	 */
	public double getMPS(){
		
		return rawSpeed;
	}
	
	/**
	 * TODO: Add math to change raw speed to actual speed, remove rawSpeed as return variable.
	 * @return Speed in mph.
	 */
	public double getMPH(){
		
		return rawSpeed;
	}
	
	/**
	 * TODO: Add math to change raw speed to actual speed, remove rawSpeed as return variable.
	 * @return Speed in ft/sec.
	 */
	public double getFtPS(){
		
		return rawSpeed;
	}
	
	/**
	 * TODO: Add math to change raw speed to actual speed, remove rawSpeed as return variable.
	 * @return Speed in in/sec.
	 */
	public double getInPS(){
		
		return rawSpeed;
	}
	
	/**
	 * TODO: Add math to change raw speed to actual speed, remove rawSpeed as return variable.
	 * @return Speed in terms of the number of tread cycles per minute.
	 */
	public double getTreadCyclesPM(){
		
		return rawSpeed;
	}
}
