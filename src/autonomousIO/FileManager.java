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
	
	private BufferedReader br;
	private FileReader fr;
	
	private BufferedWriter bw;
	private FileWriter fw;
	
	public ArrayList<String> lines = new ArrayList<>();
	
	public boolean writeOpen;
	public boolean readOpen;
	
	
	public FileManager(String name, FileType type, boolean usb){
		
		createNewFile(name, type, usb);
		
		updateArrayList();
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
	
	public void createNewFile(String name, FileType type, boolean usb){
		try{
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd");
			SimpleDateFormat hourFormat = new SimpleDateFormat("HH.mm");
			if(usb){
				file = new File(USB_PATH + "/" + name + "." + type.toString());
			} else{
				file = new File(ROBORIO_PATH + name + "." + type.toString());
			}
			
			file.createNewFile();
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			fr = new FileReader(file);
			br = new BufferedReader(fr);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void updateArrayList(){
		lines.addAll(br.lines().collect(Collectors.toList()));
	}
	
	Thread fileWrite;
	
	public void writeToFile(String data){
		fileWrite = new Thread(new Runnable() {
			public void run() {
				try{
					bw.write(data);
					bw.newLine();
				} catch(Exception e){
					
				}
			}
		});
		fileWrite.start();
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
