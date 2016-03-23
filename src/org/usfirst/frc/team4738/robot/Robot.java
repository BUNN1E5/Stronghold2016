package org.usfirst.frc.team4738.robot;

import java.util.HashMap;
import java.util.TimerTask;

import autonomousIO.DummyGamepad;
import autonomousIO.DummyXbox;
import autonomousIO.FileManager;
import autonomousIO.FileManager.FileType;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables.NetworkTableKeyNotDefined;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.tables.ITable;
import enums.DefenceNames;
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
	public SendableChooser chooser;
	
	public SendableChooser[] autoNameGen = new SendableChooser[3];
	
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
    	for(int i = 0; i < autoNameGen.length; i++){
    		autoNameGen[i] = new SendableChooser();
    	}
    	
    	chooser = new SendableChooser();
    	try{
    		cam = new Camera();
    		cam.startCapture();
    	} catch(Exception e){System.out.println("Cam Broke or not found");};
    	manager = new FileManager();
    	
    	robot = new RobotControl();
    	
    	//FIXME: Check if this works!!! try catch statement is temporary!!
    	try{
    		for(int i = 0; i < autoNameGen.length; i++){
    			autoNameGen[i].addDefault("AutoNameGen" + i, DefenceNames.getNames()[0]);
    			for (int j = 0; j < DefenceNames.values().length; j++) {
    				autoNameGen[i].addObject("AutoNameGen" + i, DefenceNames.getNames()[i]);
        		}
    			SmartDashboard.putData("AutoNameGen", autoNameGen[i]);
    		}
    		
    		String[] files = manager.getAutonomousFileNames(false);
    		chooser.addDefault("AutonomousItems", files[0]);
    		for (int i = 0; i < autoNameGen.length; i++) {
        		chooser.addObject("AutonomousItems", files[i]);
        	}
    		SmartDashboard.putData("AutonomousItems", chooser);
    		
    	} catch(Exception e){
    		//I dunno what type of exception it would throw
    		System.err.println(e.toString());
    	}

    }
    
    BackupAuto backupAuto;
    
	/** 
	 * This function is called once before autonomous
	 */    
    public void autonomousInit() {
    	//----------Backup
    	Encoder encoder = new Encoder(0, 1, (2.75 / 2));
    	Encoder encoder2 = new Encoder(2, 3, (2.75 / 2));
    	backupAuto = new BackupAuto(robot.drive, encoder, encoder2);
    	//Backup Auto
    	
    	
    	//manager = new FileManager("Autonomous", FileType.GP, false, false);
    	//return;
        
    	//if(!((String)(chooser.getSelected())).equals("Backup"))
    	//	manager.setFile((String)(chooser.getSelected()), FileType.GP, false);
    	//dbox = new DummyXbox(0, manager);
    	//dummypad = new DummyGamepad(1, manager);
    	/**
    	manager.setFile("Autonomous", FileType.GP, false);
    	dbox = new DummyXbox(0, manager);
    	dummypad = new DummyGamepad(1, manager);
    	**/
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	//return;
    	backupAuto.updateBackup();
    	
    	//return;
    	
    	/**if(!chooser.getSelected().toString().equals("Backup"))
    	{
	    	dbox.updateData();
	    	dummypad.updateData();
	    	robot.move(xbox, dummypad, cam);
    	}**/
    	//dbox.updateData();
    	//dummypad.updateData();
    	//robot.move(xbox, dummypad, cam);
   	}
    
    
    
    ToggleButton toggle;
    
    /**
	 * This function is called once before during operator control
	 */
    public void teleopInit() {
    	toggle = new ToggleButton();
    	xbox = new XboxController(0);
    	gamepad = new Gamepad(1);
    }
       
     /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
    	robot.move(xbox, gamepad, cam);
    	
    	if(SmartDashboard.getBoolean("StartRecording", false)){
    		if(toggle.getDown(SmartDashboard.getBoolean("StartRecording", false))){
    			/**String fileName = 
    					SmartDashboard.getData("AutoNameGen1").toString() + 
    					SmartDashboard.getData("AutoNameGen2").toString() + 
    					SmartDashboard.getData("AutoNameGen3").toString();*/
    			
    			/**String fileName = "";
    			for(int i = 0; i < autoNameGen.length; i++){
    				fileName += autoNameGen[i].getSelected().toString();
    			}*/
    			manager.createNewFile("Autonomous", FileType.GP, false, true);
    		}
    		manager.writeToFile(xbox.toString() + "\n" + gamepad.toString());
    	}
    }
    
    
    public void testInit(){
    	
    }

    public void testPeriodic() {
    	
    }
    
    public void disabledInit(){
    	
    }
}