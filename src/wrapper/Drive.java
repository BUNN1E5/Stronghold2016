package wrapper;

import java.util.*;
import edu.wpi.first.wpilibj.*;

/**
 * @author Everyone
 */
public class Drive {

	private static ArrayList<Talon> motors = new ArrayList<Talon>();
	
	/** 
	 * This is a constructor you idiot - <3 Jacob
	 * @author Stephen Barrack (who forgot what a constructor was)
	 * @param ports switches between left and right motors for each input
	 */
	public Drive(int... ports){
		for (int port : ports) {
			motors.add(new Talon(port));
		}
	}
	
	/**
	 * @param xAxis x-axis of the joystick
	 * @param yAxis y-axis of the joystick
	 */
	public static void linearArcade(double xAxis, double yAxis){
		for (int i = 0; i < motors.size(); i+=2) {
			motors.get(i).set(yAxis + xAxis);
			motors.get(i+1).set(yAxis - xAxis);
		}
	}
	
	/**
	 * @param leftStick y-axis for left joystick
	 * @param rightStick y-axis for left joystick
	 */
	public void linearTank(double leftStick, double rightStick){
		for (int i=0;i<motors.size();i+=2){
			motors.get(i).set(leftStick);
			motors.get(i+1).set(rightStick);
		}
	}
	
	/**
	 * @param leftStick y-axis for left joystick
	 * @param rightStick x-axis for right joystick
	 */
	public void parabolicTank(double leftStick, double rightStick){
		for(int i=0;i<motors.size();i+=2){
			motors.get(i).set(leftStick*Math.abs(leftStick));
			motors.get(i+1).set(rightStick*Math.abs(rightStick));
		}
	}
	
	/**
	 * @param xAxis x-axis for the joystick
	 * @param yAxis y-axis for the joystick
	 */
	public static void parabolicArcade(double xAxis, double yAxis){
		for (int i=0;i<motors.size();i+=2){
			motors.get(i).set((yAxis+xAxis)*Math.abs(yAxis+xAxis));
			motors.get(i+1).set((yAxis-xAxis)*Math.abs(yAxis-xAxis));
		}
	}
	
}
