package wrapper;

import Enums.Directions;
import Enums.XboxButtons;

/**
 * @author Owen
 */
public class XboxController extends Gamepad implements interfaces.XboxController {
	
	/**
	 * @param port Port the controller is in.
	 */
	public XboxController(int port) {
		super(port);
	}
	
	/**
	 * @return Returns the axis values of the left stick.
	 */
	public Axes getLeftStick(){
		return new Axes(this.getRawAxis(0), this.getRawAxis(1));
	}
	
	/**
	 * @return Returns axis values of the right stick.
	 */
	public Axes getRightStick(){
		return new Axes(this.getRawAxis(4), this.getRawAxis(5));
	}
	
	/**
	 * @return Returns the axis value of the left trigger button.
	 */
	public double getLeftTrigger(){ 
		return this.getRawAxis(2);
	}
	
	/**
	 * @return Returns the axis value of the right trigger button.
	 */
	public double getRightTrigger(){ 
		return this.getRawAxis(3);
	}
	
	/**
	 * @param button The button in question.
	 * @return Returns the button state.
	 */
	public boolean getButton(XboxButtons button){
		return this.getRawButton(button.ordinal() + 1);
	}
	
	/**
	 * @author Stephen
	 * @param button The button being released.
	 * @return Returns the state of the button being released.
	 */
	public boolean getButtonUp(XboxButtons button){
		return this.getButtonUp(button.ordinal() + 1);
	}
	
	/**
	 * @author Ghjf544912
	 * @param button The button being pressed.
	 * @return Returns the state of the button being pressed.
	 */
	public boolean getButtonDown(XboxButtons button){
		return this.getButtonDown(button.ordinal() + 1);
	}
	
	/**
	 * @param direction The direction the d-pad is being pressed.
	 * @return If direction being pressed is direction it returns true, otherwise false.
	 */
	public boolean getDPad(Directions direction){
		return this.getPOV(direction);
	}	
}