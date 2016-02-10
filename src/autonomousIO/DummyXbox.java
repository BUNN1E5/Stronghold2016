package autonomousIO;

import java.util.Collections;

import Enums.*;
import interfaces.XboxController;
import wrapper.Axes;

/**
 * Congratulations, we are now the proud owners of a robot that can drive itself :) almost...
 * @author Ghjf544912
 */
public class DummyXbox extends DummyGamepad implements  XboxController{
	
	private FileManager fileManager;
	private DataParser parse;
	private String s;
	private int index = 0;
		
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
	public Axes getLeftStick(){
		return new Axes(parse.axes.get(0), parse.axes.get(1));
	}
	
	/**
	 * @return Returns axis values of the right stick.
	 */
	public Axes getRightStick(){
		return new Axes(parse.axes.get(4), parse.axes.get(5));
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
	public boolean getButton(XboxButtons button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getButtonDown(XboxButtons button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getButtonUp(XboxButtons button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getDPad(Directions direction) {
		// TODO Auto-generated method stub
		return false;
	}	
}