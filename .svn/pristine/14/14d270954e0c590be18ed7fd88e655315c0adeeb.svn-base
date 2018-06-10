package extra.io;

import java.io.*;
import java.util.*;

public final class ReadWrite {

	public static void copyFromFileToFile(String fileIn, String fileOut){
		int c;
		FileReader frIn = null;
		FileWriter frOut = null;
		try{
			frIn = new FileReader(fileIn);
			frOut = new FileWriter(fileOut);
			while((c=frIn.read())!=-1){
				frOut.append((char)c);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(frIn!=null){
					frIn.close();
				}
				if(frOut!=null){
					frOut.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
	}

	// http://www.javapractices.com/topic/TopicAction.do?Id=42

	public static String readFromFileReader(String fileIn){
		BufferedReader bufferedReader = null;
		String result = null;
		try {
			bufferedReader = new BufferedReader(new FileReader(fileIn));
			StringBuilder sb = new StringBuilder();
			String line = bufferedReader.readLine();

			while (line != null) {
				sb.append(line);
				sb.append("\n");
				line = bufferedReader.readLine();
			}
			result = sb.toString();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(bufferedReader!=null){
					bufferedReader.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String readFromFileInputStream(String fileIn){
		FileInputStream fis = null;
		String result = null;
		try {
			fis = new FileInputStream(fileIn);
			StringBuilder sb = new StringBuilder();
			int ch = fis.read();
			while (ch != -1) {
				sb.append((char)ch);
				ch = fis.read();
			}
			result = sb.toString();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(fis!=null){
					fis.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public static String readFromFileBufferedInputStream(String fileIn){
		BufferedInputStream bis = null;
		String result = null;
		try {
			bis = new BufferedInputStream(new FileInputStream(fileIn));
			StringBuilder sb = new StringBuilder();
			int ch = bis.read();
			while (ch != -1) {
				sb.append((char)ch);
				ch = bis.read();
			}
			result = sb.toString();
		} 
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try{
				if(bis!=null){	
					bis.close();
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}

	public static void duplicateFileContent(String fileName) {
		int i=0;
		RandomAccessFile raf = null;
		String path = null;
		try {
			path = new java.io.File(".").getCanonicalPath();
			raf = new RandomAccessFile(path+"\\"+fileName, "rw");
			System.out.println(path);
			System.out.println(path+"\\"+fileName);
			List<String> words = new ArrayList<String>();
			while (raf.getFilePointer() < raf.length()) {
				words.add(raf.readLine());
			}
			raf.seek(0);
			raf.writeBytes("double");
			raf.writeBytes(System.getProperty("line.separator"));
			for (i = 0; i < words.size(); i++) {
				raf.writeBytes(words.get(i));
				raf.writeBytes(System.getProperty("line.separator"));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try{
				if(raf!=null){
					raf.close();
				}
			}
			catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String args[]){
		//ReadWrite.copyFromFileToFile("inout/pgadmin.log", "inout/pgadmin.txt");
		//System.out.println(ReadWrite.readFromFileReader("inout/pgadmin.log"));
		//System.out.println(ReadWrite.readFromFileInputStream("inout/pgadmin.log"));
		//System.out.println(ReadWrite.readFromFileBufferedInputStream("inout/pgadmin.log"));
		ReadWrite.duplicateFileContent("inout\\pgadmin.log");
	}
}
