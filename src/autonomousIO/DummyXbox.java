package autonomousIO;

import java.io.IOException;
import java.util.Collections;
import java.util.function.UnaryOperator;

import interfaces.XboxController;
import wrapper.Gamepad.Direction;
import wrapper.Stick;
import wrapper.XboxController.Button;

/**
 * Congratulations, we are now the proud owners of a robot that can drive itself :) almost...
 * @author Ghjf544912
 */
public class DummyXbox implements  XboxController{
	
	private FileManager fileManager;
	private DataParser parse;
	private String s;
	private int index = 0;
	
	private boolean firstEnd = true;
	
	public DummyXbox(FileManager fileManager){
		this.fileManager = fileManager;
		parse = new DataParser();
	}
	
	public void updateData(){
		if(index < fileManager.lines.size() - 1){
			s = fileManager.lines.get(index);
			parse.getNextAxes(s);
			parse.getNextButtons(s);
			
			index++;
		}else{
			Collections.fill(parse.axes, 0.0);
			Collections.fill(parse.buttons, false);
		}
	}
	
	public void resetIndex(){
		index = 0;
	}
	
	/**
	 * @return Returns the axis values of the left stick.
	 */
	public Stick getLeftStick(){
		return new Stick(parse.axes.get(0), parse.axes.get(1));
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