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
		if(pan<0)
			panServo.set(-1*(Math.abs(pan)+1)/2); 
		else
			panServo.set((pan+1)/2); 
	}
	
	public void setTilt(double tilt){
		if(tilt<0)
			tiltServo.set(-1*(Math.abs(tilt)+1)/2);
		else
			tiltServo.set((tilt+1)/2); 
	}
	
	public void setPos(double pan, double tilt){
		this.setTilt(tilt);
		this.setPan(pan);
	}
	
	public void setDeltaPan(double pan){
		if(pan>0){
		panServo.set(panServo.get()+(pan+1)/2);
		}else{
			panServo.set(panServo.get()+(Math.abs(pan)+1)/2);
		}
	}
	
	public void setDeltaTilt(double tilt){
		if(tilt>0){
			tiltServo.set(tiltServo.get()+(tilt+1)/2);
		}else{
			tiltServo.set(tiltServo.get()-(Math.abs(tilt)+1)/2);
		}	
	}
	
	public void setDeltaPos(double pan, double tilt){
		this.setDeltaPan(pan);
		this.setDeltaTilt(tilt);
	}
	
	public double getPan(){
		return panServo.get();
	}
	
	public double getTilt(){
		return tiltServo.get();
	}
	
}
