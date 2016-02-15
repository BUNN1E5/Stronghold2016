package wrapper;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.vision.USBCamera;

/**
 * @author Jacob
 */
public class Camera{
	
	int[] sessions;
	Image frame;
	int camIndex = 0;
	NIVision.Rect rect;
	
	boolean cameraStarted = false;
	
	Thread camThread;
	
	/**
	 * TODO: Remove camNames.
	 * @param camNames Names of cameras I guess.
	 */
	public Camera(String... camNames){
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB_U64, 0);
		sessions = new int[camNames.length];
		rect = new NIVision.Rect(10, 10, 100, 100);
		for(int i = 0; i < camNames.length; i++){
			sessions[i] = NIVision.IMAQdxOpenCamera(camNames[i],  NIVision.IMAQdxCameraControlMode.CameraControlModeController);
			//Can cause crashing!!!
			//NIVision.IMAQdxSetAttributeU32(sessions[i], "AcquisitionAttributes::VideoMode" , 0);
		}
		NIVision.IMAQdxStartAcquisition(sessions[camIndex]);
		NIVision.IMAQdxConfigureGrab(sessions[camIndex]);
		//startCapture();
		//run();
	}
	
	public void updateCapture(){
		NIVision.IMAQdxGrab(sessions[camIndex], frame, 1);
		//NIVision.imaqDrawShapeOnImage(frame, frame, rect, DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
		CameraServer.getInstance().setImage(frame);
	}
	
	public void startCapture(){
		cameraStarted = true;
		
		camThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(cameraStarted){
					try{
					updateCapture();
					System.out.println("Camera Updated");
					} catch(Exception e){
						System.out.println("HOLY SHIZZLE WHY DA FAQ DO YOU NOT WANNA WORK YOU LITTLE BITCH!!!");
						System.out.println(e.toString());
					}
				}
			}
		});
		camThread.setName("CamThread");
		camThread.start();
	}
	
	public void stopCapture(){
		cameraStarted = false;
	}
	
	public void changeCamera(int index){
		NIVision.IMAQdxStopAcquisition(sessions[camIndex]);
		//NIVision.IMAQdxCloseCamera(sessions[camIndex]);

		this.camIndex = index;
		if(camIndex >= sessions.length){
			camIndex = 0;
		}
		NIVision.IMAQdxConfigureGrab(sessions[camIndex]);
		updateCapture();
	}
	
	public void cycleCamera(){
		changeCamera(camIndex+1);
	}	
}