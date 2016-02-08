package interfaces;

import Enums.Directions;

public interface Gamepad {
	public float getAxis(int axis);
	public boolean getButton(int button);
	public boolean getUp(int button);
	public boolean getDown(int button);
	public boolean getPOV(Directions direction);
}
