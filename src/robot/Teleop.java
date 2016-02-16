package robot;

import com.ni.vision.NIVision;

import Enums.XboxButtons;
import Utils.Mathd;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.USBCamera;
import wrapper.Camera;
import wrapper.CameraGimbal;
import wrapper.Drive;
import wrapper.XboxController;

public class Teleop extends IterativeRobot{
	
	XboxController controller;
	Drive drive;
	CameraGimbal gimbal;
	public void teleopInit(){
		controller = new XboxController(0);
		drive = new Drive(0, 1);
		gimbal = new CameraGimbal(2, 3, 0);
		controller = new XboxController(0);
		gimbal.startGyroStabilization();
	}
	
	public void teleopPeriodic(){
	
		drive.parabolicArcade(controller.getLeftStick().getX(), controller.getLeftStick().getY());
		
		if(controller.getButtonDown(XboxButtons.A)){
			RobotInit.cam.cycleCamera();
		}
	}
	
}