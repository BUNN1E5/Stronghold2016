package autonomousIO;

import java.util.*;

import enums.ControllerTypes;

/**
 * Class dedicated to parsing data from data files to be used to control the robot.
 * @author Ghjf544912
 */
public class DataParser {

	private Scanner sc;
	public ArrayList<Double> axes;
	public ArrayList<Boolean> buttons;
	public ArrayList<Double> encoders;
	public int pov;
	
	public ControllerTypes getControllerType(){
		if(buttons.size()==10)
			return ControllerTypes.Xbox;
		else if(buttons.size()==11)
			return ControllerTypes.Attack3;
		else if(buttons.size()==12)
			return ControllerTypes.X3D;
		else
			return ControllerTypes.GP;
	}
	
	/**
	 * @param s String from Filer.readNextLine() to parse.
	 * @return An array list of doubles to be used as axis values.
	 */
	public ArrayList<Double> getNextAxes(String s){
		axes = new ArrayList<Double>();
		if(!axes.isEmpty())
			axes.removeAll(axes);
		sc = new Scanner(s);
		sc.useDelimiter(",");
		while(sc.hasNextDouble()){
			axes.add(sc.nextDouble());
		}
		sc.close();
		return axes;
	}
	
	/**
	 * @param s String from Filer.readNextLine() to parse.
	 * @return An array list of booleans to be used as button values.
	 */
	public ArrayList<Boolean> getNextButtons(String s){
		buttons = new ArrayList<Boolean>();
		if(!buttons.isEmpty())
			buttons.removeAll(buttons);
		sc = new Scanner(s);
		sc.useDelimiter(",");
		while(sc.hasNextInt()){
			if(sc.nextInt() == 1)
				buttons.add(true);
			else
				buttons.add(false);
		}
		sc.close();
		return buttons;
	}
	
	/**
	 * @param s String from Filer.readNextLine() to parse.
	 * @return An array list of doubles to be used as encoder speeds.
	 */
	public ArrayList<Double> getNextEncoders(String s){
		encoders = new ArrayList<Double>();
		if(!encoders.isEmpty())
			encoders.removeAll(encoders);
		sc = new Scanner(s);
		sc.useDelimiter(",");
		while(sc.hasNextDouble()){
			encoders.add(sc.nextDouble());
		}
		sc.close();
		return encoders;
	}
	
	/**
	 * 
	 * @param s String from Filer.readNextLine() to parse.
	 * @return An array list of int to be used as POV switch.
	 */
	public int getNextPOV(String s){
		
		sc = new Scanner(s);
		sc.useDelimiter(",");
		pov = sc.nextInt();
		sc.close();
		return pov;
	}
	
}