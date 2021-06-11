package com.techlab.test;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class FileOperationsTest {

	public static final String delimiter = ",";

	public static void readAndWrite(String csvFile) {
		try {
			File file = new File(csvFile);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			File writeFile = new File("D:\\test\\copyemp.csv");
			FileWriter fw = new FileWriter(writeFile);
			BufferedWriter bw = new BufferedWriter(fw);
			String line = "";
			String[] tempArr;
			while ((line = br.readLine()) != null) {
				tempArr = line.split(delimiter);
				int i = 0;
				for (String tempStr : tempArr) {
					if(tempStr.equalsIgnoreCase("KING")) {
						tempArr[i] = "SIDDHESH";
						tempStr = tempArr[i];
					}
					System.out.print(tempStr + " ");
					bw.write(tempStr + " ");
					i++;
				}
				System.out.println();
				bw.newLine();
			}
			br.close();
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws IOException {
		String csvFile1 = "D:\\test\\emp.csv";
//		String csvFile2 = "D:\\test\\copyemp.csv";
		FileOperationsTest.readAndWrite(csvFile1);
	}
}
