package org.usfirst.frc.team4738.robot;

import java.io.IOException;

import Enums.XboxButtons;
import autonomousIO.DataFormatter;
import autonomousIO.DataParser;
import autonomousIO.DummyXbox;
import autonomousIO.FileManager;
import autonomousIO.Filer;
import autonomousIO.FileManager.FileType;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import robot.Autonomous;
import robot.Disabled;
import robot.RobotInit;
import robot.Teleop;
import robot.Test;
import wrapper.Camera;
import wrapper.Drive;
import wrapper.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	private Autonomous autonomous;
	private Teleop teleop;
	private Test test;
	private RobotInit robotInit;
	private Disabled disabled;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	robotInit = new RobotInit();
    	robotInit.robotInit();
    }
        
	/** 
	 * This function is called once before autonomous
	 */
    public void autonomousInit() {
    	autonomous = new Autonomous();
    	autonomous.autonomousInit();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	autonomous.autonomousPeriodic();
    }
    
    /**
	 * This function is called once before during operator control
	 */
    public void teleopInit() {
    	teleop = new Teleop();
    	teleop.teleopInit();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	teleop.teleopPeriodic();
    }
    
    public void testInit(){
    	test = new Test();
    	test.testInit();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	test.teleopPeriodic();
    }
    
    public void disabledInit(){
    	disabled = new Disabled();
    	disabled.disabledInit();
    }
    
    public void diabledPeriodic(){
    	disabled.disabledPeriodic();
    }
    
}