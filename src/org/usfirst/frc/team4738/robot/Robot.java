package org.usfirst.frc.team4738.robot;

import autonomousIO.DummyGamepad;
import autonomousIO.DummyXbox;
import autonomousIO.FileManager;
import autonomousIO.FileManager.FileType;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import wrapper.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
	
	public Camera cam;
	public FileManager manager;
	public SendableChooser chooser ;
	
	
	RobotControl robot;
	
	DummyXbox dbox;
	XboxController xbox;
	    
	DummyGamepad dummypad;
	Gamepad gamepad;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    	chooser = new SendableChooser(); 
    	cam = new Camera();
    	cam.startCapture();
    	manager = new FileManager();
    	
    	robot = new RobotControl();
    	
    	//FIXME: Check if this works!!! try catch statement is temporary!!
    	try{
    		chooser.addDefault("Autonomous Items", manager.getAutonomousFiles(false));
    		SmartDashboard.putData("Autonomous Items", chooser);
    	} catch(Exception e){
    		//I dunno what type of exception it would throw
    		System.err.println(e.toString());
    	}

    }
    
	/** 
	 * This function is called once before autonomous
	 */    
    public void autonomousInit() {
    	manager = new FileManager(SmartDashboard.getString("Autonomous Selector"), FileType.GP, false);
    	
    	dbox = new DummyXbox(0, manager);
    	dummypad = new DummyGamepad(1, manager);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	robot.move(dbox, dummypad, cam);
    }
    
    ToggleButton toggle;
    
    /**
	 * This function is called once before during operator control
	 */
    public void teleopInit() {
    	toggle = new ToggleButton();
    	manager = new FileManager();
    }
       
     /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	robot.move(xbox, gamepad, cam);
    	
    	if(SmartDashboard.getBoolean("Start Recording")){
    		if(toggle.getDown(SmartDashboard.getBoolean("Start Recording"))){
    			manager.createNewFile(SmartDashboard.getString("Autonomous Selector"), FileType.GP, false);
    		}
    		manager.writeToFile(xbox.toString() + "\n" + gamepad.toString());
    	}
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