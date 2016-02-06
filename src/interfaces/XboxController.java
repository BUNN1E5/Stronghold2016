package interfaces;

import wrapper.Gamepad;
import wrapper.Stick;

public interface XboxController {

	Stick getLeftStick();
	Stick getRightStick();
	double getRightTrigger();
	double getLeftTrigger();
	boolean getButton(wrapper.XboxController.Button button);
	boolean getPOV(Gamepad.Direction direction);
	
}
