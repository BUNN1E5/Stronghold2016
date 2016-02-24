package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.VictorSP;
import interfaces.Gamepad;
import wrapper.Constants;
import wrapper.Timer;

public class Pickup {

	VictorSP 
		intakeMotor,
		rampMotor;
	Timer timer;
	double currentPosition;
	DigitalInput 
		topSwitch,
		bottomSwitch;
	public Pickup(VictorSP intakeMotor, VictorSP rampMotor, DigitalInput topSwitch, DigitalInput bottomSwitch){
		this.intakeMotor = intakeMotor;
		this.rampMotor = rampMotor;
		timer = new Timer();
		this.topSwitch = topSwitch;
		this.bottomSwitch = bottomSwitch;
	}
	
	public void intakeMotor(Gamepad gamepad){
		for (int i = 0; i < gamepad.getButtonCount(); i++) {
			if(gamepad.getButton(i)){
				if(i % 2 == 0){
					intakeMotor.set(1);
				} else {
					intakeMotor.set(-1);
				}
			}
			else{
				intakeMotor.set(0);
			}
		}
	}
	
	//NOTE: I do now know if this is the correct math
	//TODO: Check if this math is correct
	public void setPosition(double position){
		double setSpeed;
		
		if(Math.abs(position) > 1){
			position = 1;
		}
		
		
		
		currentPosition += ((rampMotor.getSpeed() * Constants.MAX_RAMP_SPEED) * (timer.getDeltaTime() + (Math.random() / 100)));
		
		setSpeed = ((position * Constants.MAX_RAMP_ANGLE) - currentPosition) / Constants.MAX_RAMP_ANGLE;
		
		if(topSwitch.get()){
			currentPosition = Constants.MAX_RAMP_ANGLE;
			if(setSpeed > 0)
				setSpeed = 0;
		} else if(bottomSwitch.get()){
			currentPosition = Constants.MIN_RAMP_ANGLE;	
			if(setSpeed < 0)
				setSpeed = 0;		
		}
		
		rampMotor.set(setSpeed);		
	}
	
}
