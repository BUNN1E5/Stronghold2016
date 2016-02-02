
package org.usfirst.frc.team4738.robot;

import Wrapper.Encoder;
import Wrapper.Gamepad;
import Wrapper.XboxController;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



//TODO: replace Encoder with wrapper encoder

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	
	Gamepad controller;
	
	Drive drive; 
	
	Encoder encoder;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	controller = new Gamepad(0);
    	drive = new Drive(0, 1);
    	encoder = new Encoder(0, 1, 0.25); //Inches
    }
    
    
	/**
	 * 
	 * This function is called once before autonomous
	 * 
	 */
    public void autonomousInit() {

    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	
    }
    
    
    /**
	 * 
	 * This function is called once before during operator control
	 * 
	 */
    public void teleopInit() {
    	encoder.reset();
    }

    
    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    	drive.parabolicTank(0, controller.getRawAxis(1));
    	
    	SmartDashboard.putDouble("Encoder Angle in Degrees", encoder.getAngle());
    	SmartDashboard.putDouble("Rotations", encoder.getDistance());
    	SmartDashboard.putDouble("Speed", encoder.getSpeed());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
