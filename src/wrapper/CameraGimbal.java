package wrapper;

import com.ni.vision.NIVision.RawData;

import edu.wpi.first.wpilibj.Servo;

public class CameraGimbal {
	
	Servo panServo, tiltServo;
	
	public CameraGimbal(int panPort, int tiltPort){
		panServo = new Servo(panPort);		
		tiltServo = new Servo(tiltPort);
	}
	
	public void setPan(double pan){
		panServo.set((pan + 1) / 2);
	}
	
	public void setTilt(double tilt){
		tiltServo.set((tilt + 1) / 2);
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
	
}
