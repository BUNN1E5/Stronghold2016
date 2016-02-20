package org.usfirst.frc.team4738.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import wrapper.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public Timer timer;
	public Camera cam;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	timer = new Timer();
    	cam = new Camera("cam0", "cam1");
    	cam.startCapture();
    }
        
	/** 
	 * This function is called once before autonomous
	 */
    public void autonomousInit() {
    	
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }
    
    /**
	 * This function is called once before during operator control
	 */
    public void teleopInit() {
    	
    	
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	
    }
    
    public void testInit(){
    	
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	
    }
    
    public void disabledInit(){
    	
    }
    
    public void diabledPeriodic(){
    	
    }
}