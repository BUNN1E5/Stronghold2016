package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.VictorSP;
import interfaces.Gamepad;
import interfaces.XboxController;
import wrapper.CameraGimbal;
import wrapper.Constants;
import wrapper.Drive;

public class RobotControl {
	
	Drive drive;
	VictorSP intakeMotor;
	VictorSP rampMotor;
	Pickup pickup;
	
	public RobotControl(){
		drive = new Drive(Constants.PWM_PORT[0], Constants.PWM_PORT[1]);
		intakeMotor = new VictorSP(Constants.PWM_PORT[2]);
		rampMotor = new VictorSP(Constants.PWM_PORT[3]);
		
		pickup = new Pickup(intakeMotor, rampMotor);
	}
	
	public void updateControl(XboxController xbox, Gamepad gamepad){
		//start Drive controller code
		drive.parabolicArcade(xbox.getLeftStick().getX(), xbox.getLeftStick().getY());

		//End Drive controller code
		
		// Start Second controller code ---------------------------------------
		
		//End second Controller Code-------------------------------------------
		
		
	}
	
	public void updateControl(XboxController xbox, Gamepad gamepad, CameraGimbal gimbal){
		updateControl(xbox, gamepad);
		gimbal.setPan(xbox.getRightStick().getX());
	}
	
}
