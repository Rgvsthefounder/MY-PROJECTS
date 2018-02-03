import java.io.*;
import java.util.*;

public class FileListingApp {
	static	int count=0;
public static void main(String[] args) throws IOException{
	
    File file = new File("myfile.txt"); //path of a txt file in which user has input paths 
	FileReader in = null;
try {
	in = new FileReader(file);             //reading paths entered in abc.txt
    int a;
    System.out.println("PATHS ENTERED BY USER");
	   while((a=in.read())!=-1) {
		
		System.out.print((char)a);                      //printing the paths given in file of given path
	    }
    
   Scanner s = new Scanner(file);            //for reading the first path
   String path1 = s.nextLine();
   File newpath = new File(path1);
    	
   File files[] = newpath.listFiles();     // for creating an array of files and directories in the given path.
    	 System.out.println("");
    	 System.out.println("");
    	    System.out.println("NAME OF FILES IN DIRECTORY AND THEIR PATHS:");
         	
    	for (int i=0;i<files.length;i++) {
    	if(files[i].isFile()) {
    	 count++;
         System.out.println(count+"  FILE NAME: "+files[i].getName());
         System.out.println("   File Path: " +files[i].getPath());
    		
   }else{
    check(files , path1);
   }		
    		
  }
      
     }catch(Exception e) {
    	 System.out.println("error has occured");
     }
    	in.close(); 
 		  }

   public static void check(File file2[] , String path1) {      /*to check if any other directory is present in the given directory
                                                                *then it will print all the files of that folder or directory */
    
    	for(int i=0 ; i<file2.length; i++){ 
    	 
    	if(file2[i].isDirectory())            //is there any other directory in the given directory
{
      File files2[] = file2[i].listFiles();
       System.out.println();
       System.out.println(" Folder name - "+file2[i].getName() + " Folder Path - "+file2[i].getAbsolutePath());

check(files2 , path1);                 
}
  else if(file2[i].isFile())
	count++;                    
  System.out.println(count+ "  FILE NAME: "+file2[i].getName());
  System.out.println("   FILE PATH: "+file2[i].getAbsolutePath());			 

		}
	}
}