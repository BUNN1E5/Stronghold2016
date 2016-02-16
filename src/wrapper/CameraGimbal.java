package wrapper;

import edu.wpi.first.wpilibj.Servo;

public class CameraGimbal {
	
	Servo panServo, tiltServo;
	
	public CameraGimbal(int panPort, int tiltPort){
		panServo = new Servo(panPort);		
		tiltServo = new Servo(tiltPort);
	}
}
