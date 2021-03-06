package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Writer {

	private BufferedWriter writer;
	
	public Writer() {
		
	}
	
	public Writer(String fileName) {
		open("", fileName);
	}
	
	public void open(String filePath, String fileName) {
		try {
			writer = new BufferedWriter(new FileWriter(filePath + fileName));
		} catch (IOException e) {
			System.err.println("writerOpen(): FATAL ERROR");
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	public void writeln(String txt) {
		try {
			writer.write(txt);
			writer.newLine();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("writeLogln(): FATAL ERROR");
			System.exit(-1);
		}
	}
	
	public void close() {
		try {
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("writerClose(): FATAL ERROR");
			System.exit(-1);
		}
	}
}
