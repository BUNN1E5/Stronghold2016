package org.usfirst.frc.team4738.robot;

import java.io.IOException;

import autonomousIO.DataFormatter;
import autonomousIO.DataParser;
import autonomousIO.DummyXbox;
import autonomousIO.FileManager;
import autonomousIO.Filer;
import autonomousIO.FileManager.FileType;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import wrapper.XboxController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	//TODO fix crashing robot code
	
	private FileManager fileManager;
	public XboxController xbox;
	public DummyXbox dbox;
	public Drive drive;
	public DataParser parse;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	xbox = new XboxController(0);
		fileManager = new FileManager("test", FileType.GP, false);
    	dbox = new DummyXbox(fileManager);
    	drive = new Drive(0, 1);
    }
        
	/** 
	 * This function is called once before autonomous
	 */
    public void autonomousInit() {
    	fileManager.updateArrayList();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	dbox.updateData();
    	drive.linearTank(dbox.getLeftStick().getY(), dbox.getRightStick().getY());
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
    	SmartDashboard.putBoolean("Stop Recording Autonomous?", false);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	drive.linearTank(xbox.getLeftStick().getY(), xbox.getRightStick().getY());
    	
    	if(fileManager.writeOpen){
    		fileManager.writeToFile(xbox.toString());
    	}
    	
    	if(SmartDashboard.getBoolean("Stop Recording Autonomous?")){
    		fileManager.closeWrite();
    	}
    	
    }
    
}