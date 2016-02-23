package wrapper;

import java.util.ArrayList;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.Image;
import edu.wpi.first.wpilibj.CameraServer;

import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.ShapeMode;

/**
 * @author Jacob
 */
@SuppressWarnings("unused")
public class Camera{
	
	int maxOffSet = 5;
	ArrayList<Integer> sessions = new ArrayList<>();
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
		rect = new NIVision.Rect(10, 10, 100, 100);
		for(int i = 0; i < camNames.length; i++){
			sessions.add(NIVision.IMAQdxOpenCamera(camNames[i],  NIVision.IMAQdxCameraControlMode.CameraControlModeController));
		}
		NIVision.IMAQdxStartAcquisition(sessions.get(camIndex));
		NIVision.IMAQdxConfigureGrab(sessions.get(camIndex));
	}
	
	public Camera(){
		int offset = 0;
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB_U64, 0);
		rect = new NIVision.Rect(10, 10, 100, 100);
		for(int i = 0; i < maxOffSet; i++){
			sessions.set(i, 0);
			while(sessions.get(i) == 0 && offset < maxOffSet){
				try{
					sessions.set(i ,NIVision.IMAQdxOpenCamera("cam" + (i + offset),  NIVision.IMAQdxCameraControlMode.CameraControlModeController));
				} catch(Exception e){
					System.err.println("cam" + (i + offset) + " not found now trying cam" + (i + offset + 1));
					sessions.set(i, 0);
					offset++;
				}
			}
		}
		NIVision.IMAQdxStartAcquisition(sessions.get(camIndex));
		NIVision.IMAQdxConfigureGrab(sessions.get(camIndex));
	}
	
	public void updateCapture(){
		NIVision.IMAQdxGrab(sessions.get(camIndex), frame, 1);
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
						System.err.println("HOLY SHIZZLE WHY DA FAQ DO YOU NOT WANNA WORK YOU LITTLE BITCH!!!");
						System.err.println(e.toString());
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
		NIVision.IMAQdxStopAcquisition(sessions.get(camIndex));
		//NIVision.IMAQdxCloseCamera(sessions.get(camIndex));

		this.camIndex = index;
		if(camIndex >= sessions.size()){
			camIndex = 0;
		}
		NIVision.IMAQdxConfigureGrab(sessions.get(camIndex));
		updateCapture();
	}
	
	public void cycleCamera(){
		changeCamera(camIndex+1);
	}	
	
	public int camCount(){
		return sessions.size();
	}
}
