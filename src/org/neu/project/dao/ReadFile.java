package org.neu.project.dao;

import java.io.*;

/**
@author Neha
**/

public abstract class ReadFile {

	public void ReadFileHelper(String fileName) {
		
		try {
			FileReader fr;
			fr = new FileReader(fileName);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String line;

			while ((line = br.readLine()) != null){
				ReadFileLine(line);
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public abstract void ReadFileLine(String line);
}
