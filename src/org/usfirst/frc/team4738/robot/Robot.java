package org.usfirst.frc.team4738.robot;

import java.io.IOException;

import autonomousIO.DataFormatter;
import autonomousIO.DataParser;
import autonomousIO.DummyXbox;
import autonomousIO.Filer;
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
	
	private Filer filer;
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
    	filer = new Filer();
    	dbox = new DummyXbox();
    	drive = new Drive(0, 1);
    	parse = new DataParser();
    }
        
	/** 
	 * This function is called once before autonomous
	 */
    public void autonomousInit() {
    	try {
			filer.startRead(filer.getLastPath());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	try {
			dbox.updateData();
	    	drive.linearTank(parse.axes.get(0), parse.axes.get(4));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			SmartDashboard.putString("Errors", e.toString());
		}
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
    	try {
    		filer.setDefaultPath(Filer.fileType.GP);
			filer.makeFile();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    	try {
    		drive.linearTank(xbox.getRawAxis(1), xbox.getRawAxis(5));
			filer.writeNextController(xbox);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			SmartDashboard.putString("Errors", e.toString());
		}
    }
    
}