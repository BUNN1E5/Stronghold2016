package Measurements;

/**
 * 
 * @author Ghjf544912
 *
 */
public class Speed {
	
	public double rawSpeed;
	/**
	 * 
	 * @param rawSpeed The encoder's raw speed value.
	 */
	public Speed(double rawSpeed){
		this.rawSpeed=rawSpeed;
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
}
