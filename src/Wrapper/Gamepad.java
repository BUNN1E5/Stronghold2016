package Wrapper;

import edu.wpi.first.wpilibj.Joystick;
	
public class Gamepad extends Joystick{
	
	ToggleButton buttons[];
	
	public Gamepad(int port) {
		super(port);
		buttons = new ToggleButton[this.getButtonCount()];
	}
	
	public boolean getToggle(int button){
		return buttons[button].getDownToggle(this.getRawButton(button));
	}
	
	public boolean getButtonDown(int button) {
		return buttons[button].getDown(this.getRawButton(button));
	}
	
	public boolean getButtonUp(int button) {
		return buttons[button].getUp(this.getRawButton(button));
	}
}

