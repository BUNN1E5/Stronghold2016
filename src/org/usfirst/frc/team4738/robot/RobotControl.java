package org.usfirst.frc.team4738.robot;

import interfaces.Gamepad;
import interfaces.XboxController;
import wrapper.CameraGimbal;
import wrapper.Constants;
import wrapper.Drive;

public class RobotControl {
	
	Drive drive;
	
	public RobotControl(){
		drive = new Drive(Constants.PWM_PORT[0], Constants.PWM_PORT[1]);
	}
	
	public void updateControl(XboxController xbox, Gamepad gamepad){
		drive.parabolicArcade(xbox.getLeftStick().getX(), xbox.getLeftStick().getY());

		for (int i = 0; i < gamepad.getButtonCount(); i++) {
			
		}
		
	}
	
	public void updateControl(XboxController xbox, Gamepad gamepad, CameraGimbal gimbal){
		updateControl(xbox, gamepad);
		gimbal.setPan(xbox.getRightStick().getX());
	}
	
}
