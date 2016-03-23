package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.*;

public class BackupAuto {

	Encoder 
		rightEncoder,
		leftEncoder;
	
	Drive drive;
	double motorSpeed = .2;
	
	double driveToValue = 60; //inches
	
	
	//Put this is the autonomous periodic
	public BackupAuto(Drive drive, Encoder left, Encoder right){
		this.drive = drive;
		leftEncoder = left;
		rightEncoder = right;
	}
	
	public void updateBackup(){
		if(leftEncoder.getDistance() < -driveToValue){
			SmartDashboard.putDouble("Encoder",leftEncoder.getDistance());
			//drive.linearTank(motorSpeed, calculateRightMotorSpeed());
			drive.linearTank(calculateLeftMotorSpeed(), motorSpeed);
		}
	}
	
	public double calculateLeftMotorSpeed(){
		double rightSpeed = rightEncoder.getSpeed();
		double leftSpeed = leftEncoder.getSpeed();
		double offset = rightSpeed - leftSpeed;
		
		return motorSpeed + offset;
	}
	
}