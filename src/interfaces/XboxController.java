package interfaces;

import wrapper.Gamepad;
import Enums.Directions;
import Enums.XboxButtons;
import wrapper.Axes;

public interface XboxController {

	Axes getLeftStick();
	Axes getRightStick();
	double getRightTrigger();
	double getLeftTrigger();
	boolean getButton(XboxButtons button);
	boolean getButtonDown(XboxButtons button);
	boolean getButtonUp(XboxButtons button);
	boolean getDPad(Directions direction);
	
}
