package autonomousIO;

import java.util.*;

/**
 * Class dedicated to parsing data from data files to be used to control the robot.
 * @author Ghjf544912
 */
public class DataParser {

	private Scanner sc;
	public ArrayList<Double> axes;
	public ArrayList<Boolean> buttons;
	public ArrayList<Double> encoders;
	
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
	
}