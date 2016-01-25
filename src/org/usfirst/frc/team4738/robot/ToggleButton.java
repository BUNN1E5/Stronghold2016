package org.usfirst.frc.team4738.robot;

public class ToggleButton {
	
	boolean lastPress = false;
	boolean toggle = false;
	
	public boolean getToggle(boolean state){
		
		if(state && !lastPress){
			toggle = !toggle;
			lastPress = true;
		} else if(!state){
			lastPress = false;
		}
		
		return toggle;
	}
}
