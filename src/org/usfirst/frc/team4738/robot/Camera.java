package org.usfirst.frc.team4738.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;

/**
 * TODO: Javadoc description on the constructor parameter please!
 * @author idk who but I bet Jacob
 *
 */
public class Camera {
	
	int[] sessions;
	Image frame;
	int camIndex = 0;
	NIVision.Rect rect;
	
	/**
	 * 
	 * @param camNames
	 */
	public Camera(String... camNames){
		sessions = new int[camNames.length];
		
		rect = new NIVision.Rect(10, 10, 100, 100);
		
		for(int i = 0; i > camNames.length; i++){
			sessions[i] = NIVision.IMAQdxOpenCamera(camNames[i],  NIVision.IMAQdxCameraControlMode.CameraControlModeController);
		}
	}
	
	public void updateCapture(){
		NIVision.IMAQdxGrab(sessions[camIndex], frame, 1);
		NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
		CameraServer.getInstance().setImage(frame);
	}
	
	public void changeCamera(int index){
		NIVision.IMAQdxCloseCamera(sessions[camIndex]);
		this.camIndex = index;
		updateCapture();
	}
	
	public void cycleCamera(){
		changeCamera(camIndex++);
		if(camIndex >= sessions.length){
			camIndex = 0;
		}
		updateCapture();
	}
}
