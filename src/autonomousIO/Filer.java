package autonomousIO;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import wrapper.*;

/**
 * Class for saving/reading data to & from our data files (like a file cabinet).
 * @author Ghjf544912
 */
public class Filer {
	
	public enum fileType {GP, PID};
	private String path;
	private static String lastPath;
	private static File file;
	private static FileReader fr;
	private static BufferedReader br;
	private static FileWriter fw;
	private static BufferedWriter bw;
	
	/**
	 * @return Returns the next line of data in the file or null if there's none left.
	 * @throws IOException
	 */
	public static String readNextLine() throws IOException{
		String s;
		if((s = br.readLine()) != null)
			return s;
		else{
			br.close();
			return null;
		}
	}
	
	/**
	 * @deprecated
	 * @throws IOException
	 */
	public void finishReading() throws IOException{
		br.close();
	}
	
	/**
	 * @param path Path of the file to read from.
	 * @return True if the file exists, false otherwise.
	 * @throws IOException
	 */
	public static boolean startRead(String path) throws IOException{
		if(file.exists()){
			fr = new FileReader(path);
			br = new BufferedReader(fr);
			br.readLine();			
			return true;
		}
		return false;
	}
	
	/**
	 * Appends a line of encoder data to the file you're writing to.
	 * @param encoders The hash map of encoders you're using.
	 * @throws IOException 
	 */
	public void writeNextEncoders(HashMap<String,Encoder> encoders) throws IOException{
		bw.write(DataFormatter.encoderData(encoders));
		bw.newLine();
	}
	
	/**
	 * Appends a line of controller data to the file you're writing to.
	 * @param xbox
	 * @throws IOException
	 */
	public static void writeNextController(XboxController xbox) throws IOException{
		bw.write(xbox.toString());
		bw.newLine();
	}
	
	/**
	 * @deprecated
	 * @throws IOException
	 */
	public void finishWriting() throws IOException{
		bw.close();
	}
	
	/**
	 * Makes a new data file.
	 * @throws IOException 
	 */
	public static void makeFile() throws IOException{
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
	 * @return The path currently being used
	 */
	public String getPath(){
		return this.path;
	}
	
	/**
	 * @return The path that was last used to write a file.
	 */
	public static String getLastPath(){
		return lastPath;
	}
	
	/**
	 * @param path File path to save/read the data from.
	 */
	public void setPath(String path){
		this.path = path;
		file = new File(path);
		Filer.lastPath = this.path;
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
			Filer.lastPath = "/U/RobotData/"+dateFormat.format(rhrn)+"."+a;
		else
			Filer.lastPath = "/home/lvuser/Data/"+dateFormat.format(rhrn)+"."+a;
		file = new File(lastPath);
	}
	
	/**
	 * Sets the path automatically to save the data file.
	 * @param a GP for a controller or PID for an encoder.
	 */
	public static void setDefaultPath(fileType a){
		Date rhrn = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		Filer.lastPath = "/home/lvuser/Data/"+dateFormat.format(rhrn)+"."+a;
		file = new File(lastPath);
	}

}
