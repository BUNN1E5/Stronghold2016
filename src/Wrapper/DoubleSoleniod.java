package Wrapper;


public class DoubleSoleniod extends edu.wpi.first.wpilibj.DoubleSolenoid{
	ToggleButton tbd = new ToggleButton();
	public DoubleSoleniod(int moduleNumber, int forwardChannel, int reverseChannel) {
		super(moduleNumber, forwardChannel, reverseChannel);
	}
	
	public DoubleSoleniod(int forwardChannel, int reverseChannel) {
		super(forwardChannel, reverseChannel);
	}

	public void onHold(boolean button){
		 if(tbd.getDown(button)){
			 this.set(Value.kForward);
		 }
		 else if(tbd.getUp(button)){
			 this.set(Value.kReverse);
		 }
	}
}
