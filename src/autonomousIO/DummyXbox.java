package autonomousIO;

import java.io.IOException;

import interfaces.XboxController;
import wrapper.Gamepad.Direction;
import wrapper.Stick;
import wrapper.XboxController.Button;

/**
 * Congratulations, we are now the proud owners of a robot that can drive itself :) almost...
 * @author Ghjf544912
 */
public class DummyXbox implements  XboxController{
	
	private DataParser parse;
	private Filer filer;
	private String s;
	
	public void updateData() throws IOException{
		s = filer.readNextLine();
		parse.getNextAxes(s);
		parse.getNextButtons(s);
	}
	
	/**
	 * @return Returns the axis values of the left stick.
	 */
	public Stick getLeftStick(){
		return new Stick(parse.axes.get(0), parse.axes.get(0));
	}
	
	/**
	 * @return Returns axis values of the right stick.
	 */
	public Stick getRightStick(){
		return new Stick(parse.axes.get(4), parse.axes.get(5));
	}
	
	/**
	 * @return Returns the axis value of the left trigger button.
	 */
	public double getLeftTrigger(){ 
		return parse.axes.get(2);
	}
	
	/**
	 * @return Returns the axis value of the right trigger button.
	 */
	public double getRightTrigger(){ 
		return parse.axes.get(3);
	}
	
	/**
	 * @param button The button in question.
	 * @return Returns the button state.
	 */
	public boolean getButton(int index){
		return parse.buttons.get(index);
	}

	@Override
	public boolean getButton(Button button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getPOV(Direction direction) {
		// TODO Auto-generated method stub
		return false;
	}
	
}