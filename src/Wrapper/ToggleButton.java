package Wrapper;

/**
 * 
 * @author Garret & Owen
 *
 */
public class ToggleButton {
	boolean lastPress = false;
	boolean lastPressToggle = false;
	boolean toggle = false;
	
	/**
	 * 
	 * @param state Input button state.
	 * @return The toggle's state.
	 */
	public boolean getDownToggle(boolean state){
		
		if(state && !lastPressToggle){
			toggle = !toggle;
			lastPressToggle = true;
		} else if(!state){
			lastPressToggle = false;
		}
		
		return toggle;
	}
	
	/**
	 * 
	 * @param state State of the button being released.
	 * @return Returns true on the button's release.
	 */
	public boolean getUp(boolean state){
		if(lastPress == true && state == false){ //check when the button was pressed, but is not being pressed now 
			lastPress = false; //set last press false.
			return true; //
		}
		lastPress = state; //update lastPress to the current press (state) for next check
		return false;
	}
	
	/**
	 * 
	 * @param state State of the button being pressed down.
	 * @return Returns true on the button press.
	 */
	public boolean getDown(boolean state){
		
		if(lastPress == false && state == true){ //check for when but yet, this button ne'er t'was press'd, yea t'is truly press'd now,
			lastPress = true; //set last press true.
			return true; //
		}
		lastPress = state; //update lastPress to the current press (state) for next check
		return false;
	}
	
}
