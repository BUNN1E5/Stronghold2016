package autonomousIO;

import java.io.IOException;
import java.util.ArrayList;

import org.usfirst.frc.team4738.robot.Drive;

import wrapper.Encoder;
import wrapper.XboxController;
import edu.wpi.first.wpilibj.IterativeRobot;

/**
 * Congratulations, we are now the proud owners of a robot that can drive itself :)
 * @author Ghjf544912
 */
public class DummyXboxDrive extends IterativeRobot{

	private ArrayList<Double> axes;
	public XboxController xbox;
	
    public void autonomousInit() {
    	try {
			Filer.startRead(Filer.getLastPath());
			Encoder.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}    	
    }

    public void autonomousPeriodic() {
    	try {
			axes = DataParser.getNextAxes(Filer.readNextLine());
	    	Drive.parabolicArcade(axes.get(0), axes.get(1));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testInit(){
    	try {
        	Filer.setDefaultPath(Filer.fileType.GP);
			Filer.makeFile();
	    	DataFormatter.firstLine();
	    	Encoder.reset();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    public void testPeriodic(){
    	try {
			Filer.writeNextController(xbox);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}