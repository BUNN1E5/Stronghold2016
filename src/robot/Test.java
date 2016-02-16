package robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import wrapper.*;

public class Test extends IterativeRobot{
		
	XboxController controller;
	CameraGimbal gimbal;
	
	public void testInit(){
		gimbal = new CameraGimbal(2, 3);
		controller = new XboxController(1);
	}
	
	public void testPeriodic(){
		gimbal.setPosition(-controller.getRightStick().getX(), controller.getRightStick().getY());
	
	}
	
}