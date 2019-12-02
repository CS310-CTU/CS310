/**
 *
 * @author  Trevor Cullingsworth
 *          CS310 - Mobile App Programming
 *          Take home quiz - Question # 3 - folding paper program
 *          Purpose:
 *          	- Assume that the thickness of a sheet of paper is about .004 inches 
 *          	- Assume that the distance from the Earth to the Moon is about 238,900 Miles (15136704000 inches).
 *          	- Write a program to calculate how many times you would need to fold (e.g., you’re 
 *		          doubling the thickness) that sheet of paper before you actually surpass the 
 *			      distance between the Earth and the Moon
 *				- Have your program output the following message once it figures it out:
 *					- "Calculation Complete."
 *					- "The number of time you would need to fold a piece of paper <thickness> thick"
 *					  "to surpass the distance between the Earth and the Moon is: <your Answer>"
 * 
 */

public class CS310PaperFoldingProgram 
{	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		// Set up the variables used in program
		double paperThickness = .004;
		double foldedPaperThickness = paperThickness;
		long distanceToMoonMiles = 238900;
		long distanceToMoonInches = 15136704000L;
		int folds = 0;
		boolean continueFolding = true;

		System.out.print("Calculating...");
		// If boolean continueFolding is true keep doing while loop
		while(continueFolding)
		{
			// Fold the paper - i.e. double its thickness
			foldedPaperThickness = foldedPaperThickness*2;
			folds++;
			
			// Check if folded thickness is greater than distance to the Moon in inches
			if(foldedPaperThickness > distanceToMoonInches)
			{
				// If folded thickness is greater than distance to Moon in inches stop looping
				// This is done by setting boolean continueFolding to false
				continueFolding = false;
			} 
			// Else continue the loop - i.e. continue folding the paper
		}
		
		// Output the required text
		System.out.println("Calculation Complete.");
		System.out.println();
		System.out.println("The number of time you would need to fold a piece of paper " + paperThickness + 
				           " inches thick to surpass the distance between the Earth and " +
				           "the Moon ( " + distanceToMoonMiles + " miles ) is: " + folds + " folds.");
	}
}
