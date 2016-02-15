package robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.vision.USBCamera;
import wrapper.Camera;
/**
 * 
 * @author Ghjf544912 with lots of grr moments from Jake
 *
 */
public class RobotInit extends IterativeRobot{
	
	public static Camera cam;
	
	public void robotInit(){
		cam = new Camera("cam0", "cam1");
		cam.startCapture();
	}
	
}
