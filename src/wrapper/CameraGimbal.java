package wrapper;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class CameraGimbal {
	
	private Servo panServo, tiltServo;
	public AnalogGyro gyro;
	
	public CameraGimbal(int panPort, int tiltPort){
		panServo = new Servo(panPort);		
		tiltServo = new Servo(tiltPort);
	}
	
	/**
	 * 
	 * @param panPort
	 * @param tiltPort
	 * @param gyroPort GYRO IS IN THE ANALOG PORT!!!!
	 */
	public CameraGimbal(int panPort, int tiltPort, int gyroPort){
		panServo = new Servo(panPort);		
		tiltServo = new Servo(tiltPort);
		gyro = new AnalogGyro(gyroPort);
		
	}
	
	
	public void setPan(double pan){
		panServo.set((pan + 1) / 2);
	}
	
	public void setTilt(double tilt){
		tiltServo.set(((tilt) + 1) / 2);
	}
	
	public void setPosition(double pan, double tilt){
		this.setTilt(tilt);
		this.setPan(pan);
	}
	
	
	public double getPan(){
		return panServo.get();
	}
	
	public double getTilt(){
		return tiltServo.get();
	}
	
	/**
	 * Run this ONLY if you have a Gyro
	 */
	public void setTiltBasedOnGyro(){
		try{
			setTilt((gyro.getAngle() / 90));
		} catch(NullPointerException e){
			System.err.println("I FRICKEN SAID DON'T RUN THIS IF YOU DON'T HAVE A GYRO YOU IDIOT!!!!");
		}
		
	}
	
}
