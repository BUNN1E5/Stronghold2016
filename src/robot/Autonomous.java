package robot;

import java.util.concurrent.TimeUnit;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.CameraGimbal;
import wrapper.Timer;

public class Autonomous extends IterativeRobot{
	
	CameraGimbal gimbal;
	
	public void autonomousInit(){
		gimbal = new CameraGimbal(2, 3, 0);
	}
	
	public void autonomousPeriodic(){
		while(gimbal.getPan() < 0.49 && gimbal.getTilt() < 0.49){
			gimbal.setPosition(0.5, 0.5);
			SmartDashboard.putDouble("x", gimbal.getPan());
			SmartDashboard.putDouble("y", gimbal.getTilt());
		}
		
		while(gimbal.getPan() > -0.49 && gimbal.getTilt() > -0.49){
			gimbal.setPosition(-0.5, -0.5);
			SmartDashboard.putDouble("x", gimbal.getPan());
			SmartDashboard.putDouble("x", gimbal.getTilt());
		}
	}
	
}
