package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.VictorSP;
import interfaces.Gamepad;
import wrapper.Constants;
import wrapper.Timer;

public class Pickup {

	VictorSP intakeMotor;
	VictorSP rampMotor;
	Timer timer;
	double currentPosition;
	
	public Pickup(VictorSP intakeMotor, VictorSP rampMotor){
		this.intakeMotor = intakeMotor;
		this.rampMotor = rampMotor;
		timer = new Timer();
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
		currentPosition += ((rampMotor.getSpeed() * Constants.MAX_RAMP_SPEED) * timer.getDeltaTime());
		rampMotor.set(((position * Constants.MAX_RAMP_ANGLE) - currentPosition) / Constants.MAX_RAMP_ANGLE);
	}
	
}
