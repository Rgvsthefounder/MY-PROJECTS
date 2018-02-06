package FileListingApp;
import java.io.*;
import java.util.*;

public class FileListingApp {
	
	public static void main(String[] args) {

		System.out.println("enter your path");
		Scanner sc = new Scanner(System.in);       // INPUT PATH OF THE TEXT FILE FROM USER 
		
		String filepath = sc.nextLine();  //IT WILL READ THE FIRST PATH (C:\\Users\\hp_pro\\Desktop\\abc.txt) FROM TEXT FILE

		File file = new File(filepath); 

		FileInputStream in = null;

		try {
			in = new FileInputStream(file);
			int newline_count = 0;
			int a;
			String b = "";
			String c = "";
			String path = "", path1 = "";
			  while ((a = in.read()) != -1) {
				if (a == 10) {                // NEW LINE CHARACTER
					newline_count++;
				}
				if (newline_count == 0) {
					b = b + (char) a;
					path = b.substring(0, b.length() - 1);
				}
				if (newline_count == 1) {
					c = c + (char) a;
				}
			}
			path1 = c.substring(1, c.length() );

			File path2 = new File(path);                 // THE PATH FOR CSV FILE IS FETCHED

			File files[] = path2.listFiles();

			Listf(files, path, path1);
			System.out.println(path);                 //WILL PRINT THE FIRST PATH
			System.out.println(path1);                //WILL PRINT THE SECOND PATH(OF CSV FILE)
			System.out.println("      YOUR LIST OF FILES IS PRESENT AT output.csv     ");
		} catch (Exception e) {
			System.out.println("error occured");
			
		} finally {
		}
		if (in != null) {
			
		}
	}


	public static void Listf(File files1[], String path, String path1) throws IOException {

		ArrayList<File> List = new ArrayList<File>();
		Iterator<File> itr = null;
		BufferedWriter b = null;
		FileOutputStream fileout = null;

		for (int i = 0; i < files1.length; i++) {
			if (files1[i].isFile()) {
				List.add(files1[i]);
				

			} else if (files1[i].isDirectory()) {
				File files2[] = files1[i].listFiles();
				Listf(files2, path, path1);
			}
		}
		try {
			fileout = new FileOutputStream(path1, true);
			b = new BufferedWriter(new OutputStreamWriter(fileout));

			itr = List.iterator();
			while (itr.hasNext()) {
				File f = itr.next();
				b.write("file name:-" + f.getName());
				b.newLine();
				b.write("path:-" + f.getAbsolutePath());
				b.newLine();
			}
		} catch (Exception e) {
			System.out.println(e + "Error occured");
		} finally {
			if (b != null) {
				b.close();
			}
		}
	}

}



