package AutonomousIO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Wrapper.Encoder;

//import Wrapper.XboxController;

/** TODO: Create formatted string method of all encoder data.
 * @author Ghjf544912
 * 
 */
public class Writer {
	
	public static void main(String[] args) throws IOException{
		writeData();
	}
	
	public static String timeStamp(){
		Date rhrn = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
		return dateFormat.format(rhrn);
	}
	
	public static File createFile(){
		String path = System.getProperty("user.home")+"\\Desktop\\ControllerWrite_"+timeStamp()+".txt";
		File out = new File(path);
		try {
			out.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return out;
	}
	
	public static  String formattedData(){
		Encoder encoder1 = new Encoder(0,1),encoder2=new Encoder(2,3);
		return Double.toString(encoder1.getAngle())+","+Double.toString(encoder1.getDistance())+","+Double.toString(encoder1.getSpeed())+","+Double.toString(encoder2.getAngle())+","+Double.toString(encoder2.getDistance())+","+Double.toString(encoder2.getSpeed());
	}
	
	public static void writeData() throws IOException{
		BufferedWriter write = new BufferedWriter(new FileWriter(createFile().getAbsolutePath()));
		System.out.println("Begin Writing! t=15 seconds");
		for(int t=15000;t>=0;t--){
			write.write(formattedData());
			write.newLine();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("Complete! File located at: C:\\Users\\CurrentUser\\ControllerWrites\\"+timeStamp()+".txt");
		write.close();
	}
}
