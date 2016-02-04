package autonomousIO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TODO A lot of stuff.
 * Class for saving/reading data to our data files (like a file cabinet).
 * @author Ghjf544912
 */
public class Filer {
	
	private String path;
	private File file;
	public enum fileType {GP, PID};
	public enum diskType {RIO, USB};
	public FileReader fr;
	public BufferedReader br;
	private FileWriter fw;
	private BufferedWriter bw;
	
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
	 */
	public void setDefaultPath(fileType a){
		Date rhrn = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy HH_mm_ss");
		this.path = "/home/lvuser/Data/"+dateFormat.format(rhrn)+" "+a+".auto";
		file = new File(path);
	}

}
