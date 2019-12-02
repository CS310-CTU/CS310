/**
 *
 * @author  Trevor Cullingsworth
 *          CS310 - Mobile App Programming
 *          Take home quiz - Question # 1 - file copier program
 *          Purpose:
 *          	- It will contain a Class named "FileCopier"
 *          	- 	It will also contain a Class named "RunFileCopier"
 *          	- Contents of "FileCopier" Class:
 *          		- It will create the following variables and data types:
 *          			- Datatype/Variable Name			Type
 *          			  "arrayFileContents"				ArrayList
 *						  "inputFileName"					String
 *						  "outputFileName"					String
 *					- It will have a Constructor that will have a string parameter 
 *					  passed in to it named inFileName and assign it to the class' 
 *					  string variable named inputFileName (listed above). 
 *					  The constructor will then call the "readFile()" and pass the 
 *				      variable "inputFileName" into it.
 *					- It will contain a method named "readFile()" that will have 
 *					  a string (named "inputFileName") passed into it. This Method 
 *					  will then call the Method "writeFile()".
 *					- It will contain a method called "writeFile()" that will also have 
 *					  a string (named "outputFileName") passed into it.
 *					- It will contain a method called "printResults()" that will print 
 *					  the results of the arrayList out to the screen.
 *					- What the Methods (of the class named “FileCopier”)will do:
 *						- The "readFile()" Method:
 *							- It will use a Java file I/O read method in order to read 
 *							  the contents of the filename stored in the "inputFileName" string.
 *							  It will then store the contents into the ArrayList named "arrayFileContents".
 *							  This method will return nothing.
 *						- The "writeFile()" Method:
 *							- This method will use the contents of the ArrayList named: "arryFileContents", 
 *							  and write the contents of that arrayList out into the external file name 
 *							  stored in the variable "outputFileName".
 *						- The "printResults()" Method:
 *							- This method will print the contents of the arrayList "arryFileContents" out
 *							  to the screen.
 *				- Contents of the "RunFileCopier" Class:
 *					- It will create the following variables and data types:
 *          			- Datatype/Variable Name			Type
 *          			  "externalFileName"				String
 *          			  "fileCopierObj" 					FileCopier
 *          		- This Class will do the following:
 *          			- Query the user to input in the name of the text file (for this assignment, you 
 *          			  will be given a text file named "LordOfTheRings.txt"), and assign that text file 
 *          			  name to the class’ variable named "externalFileName".
 *          			- It will instantiate the object of type "FileCopier" and named "fileCopierObj", and
 *          			  you will pass the string variable named "externalFileName" into that object’s Constructor.
 *          			- This constructor will then call the "fileCopierObj" object’s "printResults()" Method. 
 * 
 */

import java.io.*;
import java.util.Scanner;

public class CS310FileCopierProgram // RunFileCopier” Class
{

	public static void main(String[] args) throws IOException
	{
		// TODO Auto-generated method stub
		// Set up variables
		// Using System.getProperty("user.dir") to get user's current working directory
		String currentDirectory = System.getProperty("user.dir");
		String inFileName = "";
		String externalFileName = "";
		Scanner input = new Scanner(System.in);
		boolean fileExists = false;
		int noInputFileCounter = 0;
		
		// Checking to see if input file entered by user exists
		// Give user 5 chances to enter a valid input filename
		while (fileExists == false)
		{
			System.out.print("Please enter an input file name : ");
			inFileName = input.nextLine().trim();
			File inputFileCheck = new File(inFileName);      
		    
			if (inputFileCheck.exists())
			{
				fileExists = true;
			} else
			{	noInputFileCounter++;
				System.out.println("File " + inFileName + " not found in " + currentDirectory);
				System.out.println();
				
				// If no valid input file is given in 5 chances end the script
				if (noInputFileCounter >= 5)
				{
					System.out.println();
					System.out.println("You DOLT! You did not enter a valid input file that exists!");
					System.out.println("I gave you 5 chances and you failed.  Script will exit now");
					System.out.println();
					System.exit(1);
				}
			}
		}
		
		// Ask user for an output file to write to
		System.out.print("Please enter an output file name: ");
		externalFileName = input.nextLine().trim();
		File outputFileCheck = new File(externalFileName);
		
		// Checking to see if output file exists
		// In this case if output file does not exist then create it for the user
		// If file does exist the file will be "cleaned" out so that we can start
		// from a fresh file
		if (outputFileCheck.createNewFile())
		{
			System.out.println();
			System.out.println("Output file was not found so a new file with name " + outputFileCheck + 
					           " under " + currentDirectory + " was created.");
		} else
		{
			FileWriter outputFileWriter = new FileWriter(externalFileName);
			outputFileWriter.write("");
			outputFileWriter.close();
		}

		System.out.println();
		
		// instantiate the object of type "FileCopier" and named "fileCopierObj"
		// Passing String inFileName and String externalFileNam
		FileCopier fileCopierObj = new FileCopier(inFileName, externalFileName, currentDirectory);
		
		// Call object's printResults which will display the elements in ArrayList
		fileCopierObj.printResults();
	}

}
