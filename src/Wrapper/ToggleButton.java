package Wrapper;

public class ToggleButton {
	boolean lastPress = false;
	boolean lastPressToggle = false;
	boolean toggle = false;
	
	public boolean getDownToggle(boolean state){
		
		if(state && !lastPressToggle){
			toggle = !toggle;
			lastPressToggle = true;
		} else if(!state){
			lastPressToggle = false;
		}
		
		return toggle;
	}
	
	public boolean getUp(boolean state){
		if(lastPress == true && state == false){ //check when the button was pressed, but is not being pressed now 
			lastPress = false; //set last press false.
			return true; //
		}
		lastPress = state; //update lastPress to the current press (state) for next check
		return false;
	}
	
	public boolean getDown(boolean state){
		
		if(lastPress == false && state == true){ //check for when but yet, this button ne'er t'was press'd, yea t'is truly press'd now,
			lastPress = true; //set last press true.
			return true; //
		}
		lastPress = state; //update lastPress to the current press (state) for next check
		return false;
	}
	
}
