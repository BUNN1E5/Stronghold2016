package wrapper;

import Enums.*;

/**
 * @author Owen
 */
public class XboxController extends Gamepad implements interfaces.XboxController {

	public XboxController(int port) {
		super(port);
	}

	@Override
	public Axes getLeftStick() {
		return new Axes(this.getAxis(0), this.getAxis(1));
	}

	@Override
	public Axes getRightStick() {
		return new Axes(this.getAxis(4), this.getAxis(5));
	}

	@Override
	public double getRightTrigger() {
		return this.getAxis(2);
	}

	@Override
	public double getLeftTrigger() {
		return this.getAxis(3);
	}

	@Override
	public boolean getButton(XboxButtons button) {
		return this.getButton(button.ordinal() + 1);
	}

	@Override
	public boolean getButtonDown(XboxButtons button) {
		return this.getButtonDown(button.ordinal() +1);
	}

	@Override
	public boolean getButtonUp(XboxButtons button) {
		return this.getButtonUp( button.ordinal() + 1);
	}

	@Override
	public boolean getDPad(Directions direction) {
		return this.getDPad(direction);
	}
	
	
}