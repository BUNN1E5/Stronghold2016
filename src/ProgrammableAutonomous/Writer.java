package ProgrammableAutonomous;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Wrapper.XboxController;

/** TODO: Create formatted string of all necessary controller data.
 * Writes controller data to text files to be used for autonomous mode later.
 * Change this code and I WILL KILL YOU!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
 * @author Ghjf544912
 * 
 */
public class Writer {
	
	public static void main(String[] args){
		writeController();
	}
	
	public static void writeController(){
		try {
			Date rhrn = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_HH-mm-ss");
			String timeStamp = dateFormat.format(rhrn), path = System.getProperty("user.home")+"\\Desktop\\ControllerWrite_"+timeStamp+".txt";
			File out = new File(path);
			out.createNewFile();
			BufferedWriter write = new BufferedWriter(new FileWriter(out.getAbsolutePath()));
			//XboxController xbox = new XboxController(1);
			String inputs;
			System.out.println("Begin Writing! t=15 seconds");
			for(int t=15000;t>=0;t--){
				inputs="<formatted string>";
				write.write(inputs);
				write.newLine();
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("Complete! File located at: C:\\Users\\CurrentUser\\ControllerWrites\\"+timeStamp+".txt");
			write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}
}
