
import java.io.*;
import java.util.*;

public class FileManger {

	private String path;
	private ArrayList<String> lines = new ArrayList<>();
	private File file;
	
	public FileManger(String path){
		this.path = path;
		file = new File(path);
	}
	
	public void setPath(String path){
		this.path = path;
		file = new File(path);
	}
	
	public void readFile(){
		try{
			if(!file.exists()){
				return;
			}
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String tmp;
			while((tmp = br.readLine()) != null){
				addData(tmp);
			}
			
			br.close();
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
			
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			
			for(String data : lines){
				bw.write(data);
				bw.newLine();
			}
			
			bw.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void appendToFile(String data){
		try{	
			FileWriter fw = new FileWriter(file, true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			addData(data);
			bw.write(data);
			bw.newLine();
			
			bw.close();
			
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public String getLine(int lineNum){
		return lines.get(lineNum);
	}
	
	public int lineCount(){
		return lines.size();
	}
	
	public String[] parse(String data){
		return data.split(",");
	}
	
}
