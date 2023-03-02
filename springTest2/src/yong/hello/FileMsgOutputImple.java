package yong.hello;

import java.io.*;

public class FileMsgOutputImple implements MsgOutput {

	private String filename;
	
	

	
	public FileMsgOutputImple(String filename) {
		super();
		this.filename = filename;
	}




	@Override
	public void output(String msg) throws Exception {
		
		FileWriter fw=new FileWriter(filename);
		fw.write(msg);
		
		fw.close();
	}

}
