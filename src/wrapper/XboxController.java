package wrapper;

/**
 * @author Owen
 */
public class XboxController extends Gamepad implements interfaces.XboxController {
	
	public enum Button { A, B, X, Y, L, R, Select, Start, L3, R3};
	
	/**
	 * @param port Port the controller is in.
	 */
	public XboxController(int port) {
		super(port);
	}
	
	/**
	 * @return Returns the axis values of the left stick.
	 */
	public Stick getLeftStick(){
		return new Stick(this.getRawAxis(0), this.getRawAxis(1));
	}
	
	/**
	 * @return Returns axis values of the right stick.
	 */
	public Stick getRightStick(){
		return new Stick(this.getRawAxis(4), this.getRawAxis(5));
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
	public boolean getButton(XboxController.Button button){
		return this.getRawButton(button.ordinal());
	}
	
	/**
	 * @author Stephen
	 * @param button The button being released.
	 * @return Returns the state of the button being released.
	 */
	public boolean getButtonUp(XboxController.Button button){
		return this.getButtonUp(button.ordinal() + 1);
	}
	
	/**
	 * @author Ghjf544912
	 * @param button The button being pressed.
	 * @return Returns the state of the button being pressed.
	 */
	public boolean getButtonDown(XboxController.Button button){
		return this.getButtonDown(button.ordinal());
	}
	
	/**
	 * @param direction The direction the d-pad is being pressed.
	 * @return If direction being pressed is direction it returns true, otherwise false.
	 */
	public boolean getDPad(Gamepad.Direction direction){
		return this.getPOV(direction);
	}
	
}