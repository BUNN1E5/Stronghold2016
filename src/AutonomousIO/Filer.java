package autonomousIO;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import wrapper.*;

/**
 * TODO Add the grabber methods then delete FileManager and on to make the DataParser class.
 * Class for saving/reading data to & from our data files (like a file cabinet).
 * @author Ghjf544912
 */
public class Filer {
	
	private String path;
	private File file;
	public enum fileType {GP, PID};
	public FileReader fr;
	public BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;
	
	/**
	 * Appends a line of encoder data to the file you're writing to.
	 * @param encoders The hash map of encoders you're using.
	 * @throws IOException 
	 */
	public void encodersToFile(HashMap<String,Encoder> encoders) throws IOException{
		bw.write(DataFormatter.encoderData(encoders));
		bw.newLine();
	}
	
	/**
	 * Appends a line of controller data to the file you're writing to.
	 * @param xbox
	 * @throws IOException
	 */
	public void controllerToFile(XboxController xbox) throws IOException{
		bw.write(xbox.toString());
		bw.newLine();
	}
	
	/**
	 * Makes a new data file.
	 * @throws IOException 
	 */
	public void makeFile() throws IOException{
		if(file.exists())
			file.delete();
		if(!file.mkdir())
			file.mkdir();
		file.createNewFile();
		fw = new FileWriter(file);
		bw = new BufferedWriter(fw);
		bw.write(DataFormatter.firstLine());
		bw.newLine();
	}
	
	/**
	 * @param path File path to save/read the data from.
	 */
	public void path(String path){
		this.path = path;
		file = new File(path);
	}
	
	/**
	 * Sets the path automatically to save the data file.
	 * @param a GP for a controller or PID for an encoder.
	 * @param usb Enter true if using a flash drive.
	 */
	public void setDefaultPath(fileType a, boolean usb){
		Date rhrn = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		if(usb)
			this.path = "/U/RobotData/"+dateFormat.format(rhrn)+" "+a+".auto";
		else
			this.path = "/home/lvuser/Data/"+dateFormat.format(rhrn)+" "+a+".auto";
		file = new File(path);
	}
	
	/**
	 * Sets the path automatically to save the data file.
	 * @param a GP for a controller or PID for an encoder.
	 */
	public void setDefaultPath(fileType a){
		Date rhrn = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		this.path = "/home/lvuser/Data/"+dateFormat.format(rhrn)+" "+a+".auto";
		file = new File(path);
	}

}
