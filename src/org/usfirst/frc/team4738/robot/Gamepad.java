package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.Joystick;

public class Gamepad extends Joystick{

	ToggleButton buttons[];
	
	public Gamepad(int port) {
		super(port);
		buttons = new ToggleButton[this.getButtonCount()];
	}
	
	public boolean getButtonDown(int button){
		return buttons[button].getToggle(this.getRawButton(button));
	}
}

