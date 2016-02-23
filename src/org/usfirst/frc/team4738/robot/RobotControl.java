package org.usfirst.frc.team4738.robot;

import Enums.ControllerType;
import Enums.Directions;
import Enums.XboxButtons;
import edu.wpi.first.wpilibj.VictorSP;
import interfaces.Gamepad;
import interfaces.XboxController;
import wrapper.Camera;
import wrapper.CameraGimbal;
import wrapper.Constants;
import wrapper.Drive;

public class RobotControl {
	
	Drive drive;
	VictorSP intakeMotor;
	VictorSP rampMotor;
	Pickup pickup;
	
	boolean lookingForward = true;
	boolean overrideCam = false;
	
	public RobotControl(){
		drive = new Drive(Constants.PWM_PORT[0], Constants.PWM_PORT[1]);
		intakeMotor = new VictorSP(Constants.PWM_PORT[2]);
		rampMotor = new VictorSP(Constants.PWM_PORT[3]);
		
		pickup = new Pickup(intakeMotor, rampMotor);
	}
	
	public void updateControl(XboxController xbox, Gamepad gamepad){
		//start Drive controller code
		lookingForward = xbox.getToggle(XboxButtons.A);
		
		if(lookingForward){
			drive.parabolicArcade(xbox.getLeftStick().getX(), xbox.getLeftStick().getY());
		} else{
			drive.parabolicArcade(-xbox.getLeftStick().getX(), -xbox.getLeftStick().getY());
		}
		//End Drive controller code
		
		
		
		// Start Second controller code ---------------------------------------
		
		pickup.intakeMotor(gamepad);
		if(gamepad.getControllerType().equals(ControllerType.Attack3)){
			pickup.setPosition(gamepad.getAxis(2));
		} else if(gamepad.getControllerType().equals(ControllerType.X3D)){
			pickup.setPosition(gamepad.getAxis(2));
		} else{
			pickup.setPosition(0);
		}
		//End second Controller Code-------------------------------------------
		
		
	}
	
	public void updateControl(XboxController xbox, Gamepad gamepad, CameraGimbal gimbal){
		updateControl(xbox, gamepad);
		gimbal.setPan(xbox.getRightStick().getX());
	}
	
	public void updateControl(XboxController xbox, Gamepad gamepad, Camera cam){
		updateControl(xbox, gamepad);
		if(!overrideCam){
			if(lookingForward && xbox.getButton(XboxButtons.A)){
				cam.changeCamera(0);
			} else if(xbox.getButton(XboxButtons.A)){
				cam.changeCamera(1);	
			}
		}
		
		for(int i = 0; i < cam.camCount(); i++){
			if(cam.camCount() < 4){
				if(xbox.getDPad(Directions.values()[i * 2])){
					cam.changeCamera(i);
				}
			}else{
				if(xbox.getDPad(Directions.values()[i])){
					cam.changeCamera(i);
				}
			}
		}
	}
	
}
