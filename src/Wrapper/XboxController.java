package Wrapper;

/**
 * 
 * @author Owen (and a little bit of Stephen)
 *
 */
public class XboxController extends Gamepad {
	
	public enum Button { A, B, X, Y, L, R, Select, Start, L3, R3};
	public enum Direction {N, NE, E, SE, S, SW, W, NW};
	
	/**
	 * 
	 * @param port Port the controller is in.
	 */
	public XboxController(int port) {
		super(port);
	}
	
	/**
	 * 
	 * @return Returns the axis values of the left stick.
	 */
	public Stick getLeftStick(){
		return new Stick(this.getRawAxis(0), this.getRawAxis(1));
	}
	
	/**
	 * 
	 * @return Returns axis values of the right stick.
	 */
	public Stick getRightStick(){
		return new Stick(this.getRawAxis(4), this.getRawAxis(5));
	}
	
	/**
	 * 
	 * @return Returns the axis value of the left trigger button.
	 */
	public double getLeftTrigger(){ 
		return this.getRawAxis(2);
	}
	
	/**
	 * 
	 * @return Returns the axis value of the right trigger button.
	 */
	public double getRightTrigger(){ 
		return this.getRawAxis(3);
	}
	
	/**
	 * 
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
		return this.getButtonUp(button.ordinal());
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
	 * 
	 * @param direction The direction the d-pad is being pressed.
	 * @return If direction being pressed is direction it returns true, otherwise false.
	 */
	public boolean getDPad(XboxController.Direction direction){
	    		
		if(this.getPOV() == direction.ordinal() * 45){
			return true;
		}
		
		return false;
	}
}
	
	

	