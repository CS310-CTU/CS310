import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.io.*;

public class FileCopier 
{
	// Declare Attributes
	public ArrayList<String> arrayFileContents;
	public String inputFileName;
	public String outputFileName;
	public String currentDirectory;
	
	// Constructor - initialize values to default values
	public FileCopier() throws IOException
	{
		arrayFileContents = new ArrayList<String>();
        inputFileName = "";
        outputFileName = "";
        currentDirectory = "";
    }
	
	// Constructor - pass values to the attributes
	public FileCopier(String inFileName, String outFileName, String workingDirectory) throws IOException
	{
		inputFileName = inFileName;
		outputFileName = outFileName;
		currentDirectory = workingDirectory;
		
		readFile(inputFileName);
	}
	    
    //======================================================================
    // readFile
	//	- reads in the input file entered by the user into the ArrayList
	//    named arrayFileContents
    //======================================================================
	
    public void readFile(String inputFileName) throws IOException
    {
    	arrayFileContents = new ArrayList<String>();
    	
    	try (BufferedReader bufferReadFile = new BufferedReader(new FileReader(inputFileName)))
    	{
    		while (bufferReadFile.ready())
    		{
    			arrayFileContents.add(bufferReadFile.readLine());
    		}
    	}
    	
    	writeFile(arrayFileContents, outputFileName, currentDirectory);
    }
    
    //======================================================================
    // writeFile
	//	- writes the ArrayList named arrayFileContents to the output file 
    //    entered by the user
    //======================================================================
    
    public void writeFile(ArrayList<String> arrayFileContents, String outputFileName, String currentDirectory) throws IOException
    {
    	FileWriter outputFileWriter = new FileWriter(outputFileName);
    	
    	System.out.println("|---------------------------------------------------------");
    	System.out.println("| Writing ArrayList arrayFileContents to output file ");
    	System.out.println("| name " + outputFileName + " located here:");
    	System.out.println("| " + currentDirectory);
    	System.out.println("|---------------------------------------------------------");
    	System.out.println();
    	
    	for (String fileLine: arrayFileContents)
    	{
    		outputFileWriter.write(fileLine + System.lineSeparator());
    	}
    	
    	outputFileWriter.close();
    }
    
    //======================================================================
    // printResults
    //	- prints/outputs the contents of the ArrayList named arrayFileContent
    //    to the screen
    //======================================================================
    public void printResults()
	{
    	String continueOutput = "";
    	Scanner input = new Scanner(System.in);
    	Iterator<String> iterationCounter = arrayFileContents.iterator(); 
    	int lineCounter = 0;
    	
    	System.out.println("|---------------------------------------------------------");
    	System.out.println("| ArrayList arrayFileContents output");
    	System.out.println("|---------------------------------------------------------");
    	System.out.println();
		while (iterationCounter.hasNext()) 
		{ 
            System.out.println(iterationCounter.next() );
            
            // Because the ArrayList might have many lines the user is asked if they want to 
            // continue output after every 10 lines (this can be modified) and if user answers
            // yes output will continue
            // If user answers no script will exit
            lineCounter++;
            if (lineCounter >= 10)
            {
            	System.out.println();
            	System.out.print("Do you wish to continue output of ArrayList? (Y / N) ");
            	continueOutput = input.nextLine();
                if (continueOutput.equals("n") || continueOutput.equals("N"))
                {
                	System.out.println("Thank you. Have a good day");
                	System.exit(0);
                } else
                {
                	lineCounter = 0;
                }
            }
        }
	}
}
