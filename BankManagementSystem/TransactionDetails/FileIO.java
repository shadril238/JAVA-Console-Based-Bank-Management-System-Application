package BankManagementSystem.TransactionDetails;

import java.io.*;

public class FileIO {
	private File file;				
	private FileWriter fw;		
	private FileReader fr;		
	private BufferedReader br;
	
	public FileIO() {
		file=new File("BankManagementSystem\\TransactionDetails\\Transaction.txt");
		try {
			file.createNewFile();
		}catch(IOException e) {
			System.out.println("File can not be created...");
		}
		
	}
	
	public void WriteInFile(String str) {
		try {
			fw=new FileWriter(file,true);
			fw.write(str+"\n");
		}catch(IOException e) {
			System.out.println("Can not write in file...");
		}finally {
			try {
				fw.close();
			}catch(IOException ex) {
				System.out.println("Can not close the file...");
			}
		}
	}
	public void ReadFromFile() {
		try {
			fr=new FileReader(file);
			br=new BufferedReader(fr);
			String line="";
			while((line=br.readLine())!=null){
				System.out.println(line);
			}
		}catch(IOException ex) {
			System.out.println("Can not read from file...");
		}finally {
			try {
				br.close();
			}catch(IOException ex) {
				System.out.println("Can not close the file...");
			}
		}
	}
	
}
