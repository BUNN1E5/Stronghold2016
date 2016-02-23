package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.VictorSP;
import interfaces.Gamepad;
import wrapper.Constants;

public class Pickup {

	VictorSP intakeMotor;
	VictorSP rampMotor;
	
	public Pickup(VictorSP intakeMotor, VictorSP rampMotor){
		this.intakeMotor = intakeMotor;
		this.rampMotor = rampMotor;
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
	
	public void setPosition(double position){
		double currentSpeed = rampMotor.getSpeed() * Constants.MAX_RAMP_SPEED;
		
		
	}
	
}
