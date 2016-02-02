package org.usfirst.frc.team4738.robot;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;

public class Camera {
	
	int[] sessions;
	Image frame;
	String[] camNames;
	int camIndex = 0;
	NIVision.Rect rect;
	
	public Camera(String... camNames){
		this.camNames = camNames;
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
		NIVision.IMAQdxCloseCamera(sessions[camIndex]);
		camIndex++;
		if(camIndex >= sessions.length){
			camIndex = 0;
		}
		updateCapture();
	}
}
