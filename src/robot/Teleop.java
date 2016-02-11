package robot;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.CameraGimbal;

public class Teleop extends IterativeRobot{
	
	//AnalogGyro gyro;
	CameraGimbal gimbal; 
	
	public void teleopInit(){
		//gyro = new AnalogGyro(0);
		gimbal = new CameraGimbal(2, 3, 0);
	}
	
	public void teleopPeriodic(){
		SmartDashboard.putDouble("Gyro", gimbal.gyro.getAngle());
		SmartDashboard.putDouble("Gyro Normalized", (gimbal.gyro.getAngle() / 90));
		gimbal.setTiltBasedOnGyro();
		//gimbal.setTilt((gyro.getAngle() / 90));
	}
	
}