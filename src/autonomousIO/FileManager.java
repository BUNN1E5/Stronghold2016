package autonomousIO;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class FileManager {

	private final String ROBORIO_PATH ="/home/lvuser/Data/";
	private final String USB_PATH = "/U/RobotData/";
	
	public enum FileType {GP, PID};
	
	private File file;
	private String path;	
	
	private BufferedReader br;
	private FileReader fr;
	
	private BufferedWriter bw;
	private FileWriter fw;
	
	public ArrayList<String> lines = new ArrayList<>();
	
	
	public boolean writeOpen;
	public boolean readOpen;
	
	public FileManager(String name, FileType type, boolean overwite, boolean usb){
		
		createNewFile(name, type, usb, overwite);
		
		updateArrayList();
		readOpen = true;
		writeOpen = true;
	}
	
	public FileManager(){
		readOpen = true;
		writeOpen = true;
	}
	
	public String readLine(){
		try {
			return br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public File[] getAutonomousFiles(boolean usb){
		File autoPath;

		try{
			if(usb){
				autoPath = new File(USB_PATH);
			} else{
				autoPath = new File(ROBORIO_PATH);
			}
		} catch(Exception e){
			System.err.println("Error can't find directory: " + e.toString());
			return null;
		}
		return autoPath.listFiles();
	}
	
	public String[] getAutonomousFileNames(boolean usb){
		File[] files = getAutonomousFiles(usb);
		String[] returnData = new String[files.length];

		for(int i = 0; i < returnData.length; i++){
			returnData[i] = files[i].getName();
		}
		
		return returnData;
	}
	
	public void setFile(String name, FileType type, boolean usb){
		try{
			if(usb){
				file = new File(USB_PATH + name + "." + type.toString());
			} else{
				file = new File(ROBORIO_PATH + name + "." + type.toString());
			}			
			
			path = file.getPath();
			
			//fw = new FileWriter(file);
			//bw = new BufferedWriter(fw);
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			
			updateArrayList();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void createNewFile(String name, FileType type, boolean usb, boolean overwrite){
		try{
			if(usb){
				file = new File(USB_PATH + "/" + name + "." + type.toString());
			} else{
				file = new File(ROBORIO_PATH + name + "." + type.toString());
			}
			
			if(overwrite){
				file.createNewFile();
			} else{
				if(!file.exists());
					file.createNewFile();
			}
			
			path = file.getPath();
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			updateArrayList();
		} catch(Exception e){
			System.err.println(e.toString());
		}
	}

	//TODO: Find out why this code is unable to read the file
	//		is it looking at the wrong file? Maybe the file
	//		doesn't exist? From what I can tell, the Buffered
	//		Writer br calls the lines function should return
	//		a stream of strings with add of the lines
	public void updateArrayList(){
		lines.addAll(br.lines().collect(Collectors.toList()));
	}
	
	Thread fileWrite;
	
	public void writeToFile(String data){
		new Thread(new Runnable() {
			public void run() {
				try{
					System.out.println(data);
					bw.write(data);
					bw.newLine();
				} catch(Exception e){
					System.err.println("Whoa something went wrong!! \n" + e.toString());
				}
			}
		}).start();
	}
	
	public void closeWrite(){
		try{
			bw.close();
			writeOpen = false;
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void closeRead(){
		try{
			br.close();
			readOpen = false;
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
