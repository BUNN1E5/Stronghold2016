package interfaces;

import Enums.Directions;

public interface Gamepad {
	
	public double getAxis(int axis);
	public boolean getButton(int button);
	public boolean getButtonUp(int button);
	public boolean getButtonDown(int button);
	public boolean getPOV(Directions direction);
	public String toString();
}
