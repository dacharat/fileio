package ku.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.management.RuntimeErrorException;

/**
 * Copy InputStream to the OutputStream.
 * 
 * @author Dacharat Pankong
 *
 */
public class FileUtil {
	
	/**
	 * Copy InputStream to OutputStream one byte at a time
	 * 
	 * @param in is the InputStream that file will read.
	 * @param out is the OutputStream that file will write.
	 * @throws RuntimeException if it cannot copy file to OutputStream.
	 */
	static void copy(InputStream in,OutputStream out) {
		try{
			while(true){
				int c = in.read();
				if(c < 0 ) break;
				out.write(c);
			}
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	/**
	 * Copy InputStream to OutputStream by byte array of blocksize.
	 * 
	 * @param in is the InputStream that file will read.
	 * @param out is the OutputStream that file will write.
	 * @param blocksize is how many byte to copy at time.
	 * @throws RuntimeException if it cannot copy file to OutputStream.
	 */
	static void copy(InputStream in, OutputStream out, int blocksize) {
		try{
			byte[] buffer = new byte[blocksize];
			while(true){
				int count = in.read(buffer);
				if(count <= 0) break;
				out.write(count);
			}
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
		
	}
	
	/**
	 * Copy InputStream to OutputStream by using BufferedReader and PrintWriter.
	 * 
	 * @param in is the InputStream that file will read.
	 * @param out is the OutputStream that file will write.
	 * @throws RuntimeException if it cannot copy file to OutputStream.
	 */
	static void bcopy(InputStream in, OutputStream out){
		BufferedReader breader = new BufferedReader( new InputStreamReader(in));
		PrintWriter print = new PrintWriter(out);
		try{
			while(true){
				String count = breader.readLine();
				if(count == null) break;
				print.println(count);
			}
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}		
	}
	
	/**
	 * Copy InputStream to OutputStream by using BufferedWriter and BufferedReader.
	 * 
	 * @param in is the InputStream that file will read.
	 * @param out is the OutputStream that file will write.
	 * @param blocksize is how many byte to copy at time.
	 * @throws RuntimeException if it cannot copy file to OutputStream.
	 */
	static void copyChar(InputStream in, OutputStream out, int blocksize){
		BufferedReader breader = new BufferedReader(new InputStreamReader(in));
		BufferedWriter print = new BufferedWriter(new OutputStreamWriter(out));
		char[] charArr = new char[blocksize];
		try{
			while(breader.ready()){
				int check = breader.read(charArr);
				print.write(check);
			}
			in.close();
			out.close();
		}catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}
