package org.usfirst.frc.team4738.robot;

import Utils.Mathd;
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
	
	public void setRampPosition(double position){
		double currentSpeed = rampMotor.getSpeed() * Constants.DEGREES_PER_MILLISECONDS;
		double velocity = currentSpeed * Constants.DEGREES_PER_MILLISECONDS;
		currentPosition += velocity * timer.getDeltaTime();
		
		rampMotor.set(position - Mathd.normalize(currentPosition, Constants.MAX_RAMP_SPEED_DEGREES));
	}
	
}
