package autonomousIO;

import java.io.*;
import java.util.*;

/**
 * FIXME Delete this crap and remake it.
 * @author Jake
 *
 */
public class FileManger {

	//FIXME make fr and br global vars

	@SuppressWarnings("unused")
	private ArrayList<String> lines = new ArrayList<>();
/*SMB*/private String path;
/*"*/private File file;
/*"*/public FileReader fr;
/*"*/public BufferedReader br;
/*"*/private FileWriter fw;
/*"*/private BufferedWriter bw;
	
/*SMB*/public FileManger(String path){
		this.path = path;
		file = new File(path);
	}
	
/*SMB*/public void setPath(String path){
		this.path = path;
		file = new File(path);
	}
	
	public void readFile(){
		try{
			if(!file.exists()){
				return;
			}
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String tmp;
			while((tmp = br.readLine()) != null){
				addData(tmp);
			}
			
			br.close();
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
	//TODO write this method
	public String readLine(){
		return "";
	}
	
	//TODO write this horribly inefficient method
	public String readLine(int line){
		return "";
	}
	
	public void appendToFile(String data){
		try{	
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			
			addData(data);
			bw.write(data);
			bw.newLine();
			
			bw.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void addData(String data){
		lines.add(data);
	}
	
	public void writeToFile(){
		try{
			file.delete();
			file.createNewFile();
			
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			
			for(String data : lines){
				bw.write(data);
				bw.newLine();
			}
			
			bw.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
/*SMB?*/public String getLine(int lineNum){
		return lines.get(lineNum);
	}
	
/*SMB?*/public int lineCount(){
		return lines.size();
	}
	
/*SMB*/public String[] parse(String data){
		return data.split(",");
	}
	
}
