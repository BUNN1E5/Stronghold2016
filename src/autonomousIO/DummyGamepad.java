package autonomousIO;

import java.util.Collections;

import Enums.ControllerType;
import Enums.Directions;
import interfaces.Gamepad;
import wrapper.ToggleButton;

public class DummyGamepad implements Gamepad{

	protected ToggleButton[] buttons;
	
	protected FileManager fileManager;
	protected DataParser parse;
	protected String s;
	protected int index = 0;

	public DummyGamepad(FileManager fileManager){
		this.fileManager = fileManager;
		parse = new DataParser();
		
		updateData();
		
		buttons = new ToggleButton[parse.buttons.size() + 1];
		for (int i = 0; i <= buttons.length; i++) {
			buttons[i] = new ToggleButton();
		}
	}
	
	public void updateData(){
		if(index < fileManager.lines.size() - 1){
			s = fileManager.lines.get(index);
			parse.getNextAxes(s);
			parse.getNextButtons(s);
			parse.getNextPOV(s);
			
			index++;
		}else{
			Collections.fill(parse.axes, 0.0);
			Collections.fill(parse.buttons, false);
		}
	}
	
	public void resetIndex(){
		index = 0;
	}
	
	@Override
	public double getAxis(int axis) {
		return parse.axes.get(axis);
	}

	@Override
	public boolean getButton(int button) {
		return parse.buttons.get(button);
	}

	@Override
	public boolean getButtonUp(int button) {
		return buttons[button].getUp(parse.buttons.get(button));
	}

	@Override
	public boolean getButtonDown(int button) {
		return buttons[button].getDown(parse.buttons.get(button));
	}

	@Override
	public boolean getPOV(Directions direction){
		return (parse.pov == direction.ordinal() * 45);
	}

	@Override
	public ControllerType getControllerType(){
		if(buttons == null){
			return ControllerType.GP;
		}
		
		for(ControllerType type : ControllerType.values()){
			if(type.getButtonCount() == parse.buttons.size()){
				return type;
			}
		}
		return ControllerType.GP;
	}

}
