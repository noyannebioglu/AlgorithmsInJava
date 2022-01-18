import java.util.Scanner;
 
class MatrixMultiplication
{
  public static void main(String args[])
  {
	// Dimensions of the first matrix
    int numberOfRowsFirstMatrix;
	int numberOfColumnsFirstMatrix;	
	
	// Dimensions of the second matrix
	int numberOfRowsSecondMatrix;
	int numberOfColumnsSecondMatrix;
	
	int sum = 0;
	
	// Row and column boundaries when we do matrix multiplication
	int m;
	int n;
	int o;
 
	// Prompt to define the dimensions of the first matrix from the user and populate it
    Scanner input = new Scanner(System.in);
    System.out.println("Please enter the number of rows and columns of the first matrix (e.g. \"2 3\" creates a 2x3 matrix): ");
    numberOfRowsFirstMatrix = input.nextInt();
    numberOfColumnsFirstMatrix = input.nextInt();
 
	// Two dimensional array representing our first matrix
    int matrix1[][] = new int[numberOfRowsFirstMatrix][numberOfColumnsFirstMatrix];
 
    // Populating the matrix with input from the user
    System.out.println("Please enter the numbers you would like the first matrix to have: ");
	System.out.println("(e.g. Typing in \"1 2 3 4 5 6\" will create");
	System.out.println("|1 2 3|");
	System.out.println("|4 5 6|");
	System.out.println("if it is a 2x3 matrix)");
 	
    for (m = 0; m < numberOfRowsFirstMatrix; m++)
    {
		for (n = 0; n < numberOfColumnsFirstMatrix; n++)
        {
			matrix1[m][n] = input.nextInt();
		}
	}
 
	// Prompt to define the dimensions of the second matrix from the user and populate it
	System.out.println();
    System.out.println("Please enter the number of rows and columns of the second matrix (e.g. \"3 2\" creates a 3x2 matrix): ");	
	
    numberOfRowsSecondMatrix = input.nextInt();
    numberOfColumnsSecondMatrix = input.nextInt();
 
	/* If the number of columns of the first matrix is not equal to the number of rows in the second matrix, then matrix
	multiplication is not possible */
    if (numberOfColumnsFirstMatrix != numberOfRowsSecondMatrix)
    {
		System.out.println("Error. Matrix multiplication of these two matrices is not possible.");
	}
    else
    {
	  // Two dimensional array representing our second matrix
      int matrix2[][] = new int[numberOfRowsSecondMatrix][numberOfColumnsSecondMatrix];
	  
	  // Two dimensional array representing our product matrix
      int product[][] = new int[numberOfRowsFirstMatrix][numberOfColumnsSecondMatrix];
 
	  // Populating the matrix with input from the user
      System.out.println("Please enter the numbers you would like the second matrix to have: ");
	  System.out.println("(e.g. Typing in \"1 2 3 4 5 6\" will create");
	  System.out.println("|1 2|");
	  System.out.println("|3 4|");
	  System.out.println("|5 6|");
	  System.out.println("if it is a 3x2 matrix)");
 
      for (m = 0; m < numberOfRowsSecondMatrix; m++)
	  {
		  for (n = 0; n < numberOfColumnsSecondMatrix; n++)
		  {
			  matrix2[m][n] = input.nextInt();
		  }          
	  }        
 
	  /* In order to multiply the first matrix by the second matrix we have to find the "dot product" of the rows and columns meaning
	  that we multiply the elements in each row and each column that correspond to each other and add up all of the products. We
	  iterate through the elements of the matrices with a for loop. */
      for (m = 0; m < numberOfRowsFirstMatrix; m++)
	  {
        for (n = 0; n < numberOfColumnsSecondMatrix; n++)
		{
          for (o = 0; o < numberOfRowsSecondMatrix; o++)
          {
			  sum = sum + matrix1[m][o] * matrix2[o][n];
		  }
 
          product[m][n] = sum;
          sum = 0;
        }
      }
 
	  // Notice that the product matrix has the number of rows of the first matrix and the number of columns of the second matrix.
	  System.out.println();
      System.out.println("The product of these two matrices are...");
 
	  System.out.println();
 
      for (m = 0; m < numberOfRowsFirstMatrix; m++)
	  {
		System.out.print("\t" + "|");
		
        for (n = 0; n < numberOfColumnsSecondMatrix; n++)
		{
			System.out.print(product[m][n] + "\t");
		}          
		System.out.print("|");
        System.out.print("\n");
		
		if (m == (m / 2))
		{
			System.out.print("=");
		}
      }
    }
  }
}
