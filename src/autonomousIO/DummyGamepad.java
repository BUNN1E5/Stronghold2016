package autonomousIO;

import Enums.Directions;
import interfaces.Gamepad;

public class DummyGamepad implements Gamepad{

	@Override
	public double getAxis(int axis) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getButton(int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getButtonUp(int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getButtonDown(int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPOV(Directions direction) {
		// TODO Auto-generated method stub
		return false;
	}

}
