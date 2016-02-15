package robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import wrapper.CameraGimbal;
import wrapper.XboxController;

public class Test extends IterativeRobot{
		XboxController controller;
		CameraGimbal gimble;
	public void testInit(){
		controller = new XboxController(0);
		gimble = new CameraGimbal(2, 3);
	}
	
	public void testPeriodic(){
		gimble.setPosition(-controller.getRightStick().getX(), controller.getRightStick().getY());
	}
	
}