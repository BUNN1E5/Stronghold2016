package robot;

import java.util.ArrayList;
import java.util.HashMap;

import edu.wpi.first.wpilibj.IterativeRobot;
import wrapper.Encoder;

/**
 * 
 * @author Ghjf544912 with lots of grr moments from Jake
 *
 */
public class RobotInit extends IterativeRobot{

	public static ArrayList<Encoder> encodersIO = new ArrayList<>();
	public static HashMap<String,Encoder> encoders = new HashMap<>();
	
	public void createMatchingEncodersList(){
		
	}
	
	public void robotInit(){
		this.createMatchingEncodersList();
	}
	
	public void addEncoder(String name, Encoder encoder){
		encoders.put(name, encoder);
		encodersIO.add(encoder);	
	}
	
}
