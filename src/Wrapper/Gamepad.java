package wrapper;

import edu.wpi.first.wpilibj.Joystick;

/**
 * Sorry Garett, I have a coworker who spells his name with double R single T so my bad. -Stephen
 * @author Garett Davis
 */
public class Gamepad extends Joystick{
	
	ToggleButton buttons[];
	
	/**
	 * @param port Port of the controller in the DS.
	 */
	public Gamepad(int port) {
		super(port);
		buttons = new ToggleButton[this.getButtonCount()];
	}
	
	/**
	 * @param button Button to be toggled.
	 * @return Returns opposite state from when button was previously toggled.
	 */
	public boolean getToggle(int button){
		return buttons[button].getDownToggle(this.getRawButton(button));
	}
	
	/**
	 * @param button Button being pressed down.
	 * @return Returns true on the button press.
	 */
	public boolean getButtonDown(int button) {
		return buttons[button].getDown(this.getRawButton(button));
	}
	
	/**
	 * @param button Button being released.
	 * @return Returns true on the button's release.
	 */
	public boolean getButtonUp(int button) {
		return buttons[button].getUp(this.getRawButton(button));
	}
	
	/**
	 * @author Ghjf544912
	 * @return The controller values in a formatted String.
	 */
	public String toString(){
		String stuff="";
		for(int i = 0; i < this.getAxisCount(); i++){
			stuff += this.getRawAxis(i) + ",";
		}
		for(int i = 0; i < this.getButtonCount(); i++){
			stuff += ((this.getRawButton(i)) ? 1 : 0) + ",";
		}
		return stuff;
	}
}

