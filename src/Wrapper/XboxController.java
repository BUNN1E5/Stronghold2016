package Wrapper;

public class XboxController extends Gamepad {
	
	public enum Button { A, B, X, Y, LeftBumper, rightBumper, Back, Start, L3, R3};
	public enum Direction {N, NE, E, SE, S, SW, W, NW};
	
	public XboxController(int port) {
		super(port);
	}
	
	public Stick getLeftStick(){
		return new Stick(this.getRawAxis(0), this.getRawAxis(1));
	}
	
	public Stick getRightStick(){
		return new Stick(this.getRawAxis(4), this.getRawAxis(5));
	}
	
	public double getLeftTrigger(){ 
		return this.getRawAxis(2);
	}
	
	public double getRightTrigger(){ 
		return this.getRawAxis(3);
	}
	
	public boolean getButton(XboxController.Button button){
		return this.getRawButton(button.ordinal());
	}
	
	public boolean getDPad(XboxController.Direction direction){
	    		
		if(this.getPOV() == direction.ordinal() * 45){
			return true;
		}
		
		return false;
	}
}
	
	

	