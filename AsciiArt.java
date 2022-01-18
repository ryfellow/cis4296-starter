public class AsciiArt {
	public static final int SIZE = 8;
	public static void main(String[] args) {
		//Top rocket
		drawTriangle();
		//1st part rocket
		drawSepLine();
		drawUp();
		drawDown();
		//2nd part rocket
		drawSepLine();
		drawUp();
		drawDown();
		//Bottom rocket
		drawSepLine();
		drawTriangle();
		System.out.println();
		//Extra Credit
		//parking lot
		drawLine();
		drawRepeat();
		System.out.println();
		//stadium
		drawStadium();
	}
	
	//ASCII Art
	
	/* draw Triangle
   
       /^^\			row1	space 8 slash 1		spaces = -row+(2*SIZE+3)
      //^^\\		row2	space 7 slash 2		slashes = row
     ///^^\\\		row3	space 6	slash 3		
	
	 */
	public static void drawTriangle() {
		//Loop for rows
		for (int row = 1; row <= SIZE*2; row++) {
			//Loop for spaces
			for (int spaces = 1; spaces < -row+(SIZE*2+3); spaces++) {
				System.out.print(" ");
			}
			//Loop for forward slashes
			for (int slashes = 1; slashes <= row; slashes++) {
				System.out.print("/");
			}
			System.out.print("^^");
			//Loop for reverse slashes
			for (int rslashes = 1; rslashes <= row; rslashes++) {
				System.out.print("\\");
			}
			System.out.println();
		}
	}
	/* draw Separate Line

*=============*

	 */
	public static void drawSepLine() {
		System.out.print("*");
		for(int x = 1; x <= SIZE*4+4; x++) {
			System.out.print("=");
		}
		System.out.println("*");
	}
	/* draw Up part

|.../\....../\...|	row 1 dot 3 tri 1		dots = -row+(SIZE+1)
|../\/\..../\/\..|	row 2 dot 2	tri 2		tri = row
|./\/\/\../\/\/\.|	row 3 dot 1 tri 3

	 */
	public static void drawUp() {
			for(int row = 1; row <= SIZE; row++) {
				System.out.print("|");
				// Repeat the ../\..
				for (int rep = 1; rep <= 2; rep++) {
					for(int dots = 1; dots <= -row+SIZE+1; dots++)
						System.out.print(".");
					for(int tri = 1; tri <= row; tri++) //print the tri
						System.out.print("/\\");
					for(int dots = 1; dots <= -row+SIZE+1; dots++)  //print the dots
						System.out.print(".");
				}
				System.out.print("|");
				System.out.println();
			}
	}
	/* draw Down part

|.\/\/\/..\/\/\/.|	row 1 dot 1 tri 3		 	dots = row
|..\/\/....\/\/..|	row 2 dot 2 tri 2			tri = -row+(SIZE+1)
|...\/......\/...|	row 3 dot 3 tri 1		

	 */
	public static void drawDown() {
		for(int row = 1; row <= SIZE; row++) {
			System.out.print("|");
			for (int rep = 1; rep <= 2; rep++) {
				for(int dots = 1; dots <= row; dots++)
					System.out.print(".");
				for(int tri = 1; tri <= -row+SIZE+1; tri++)
					System.out.print("\\/");
				for(int dots = 1; dots <= row; dots++)
					System.out.print(".");
			}
			System.out.print("|");
			System.out.println();
		}
	}
	
	//PARKING LOT
	public static void drawLine() {
		System.out.print(" ");
		for(int x = 1; x <= SIZE*4+1; x++) {
			System.out.print("_");
		}
		System.out.println(" ");
	}
	public static void drawRepeat() {
		for(int row = 1; row <= SIZE*4; row++) {
			//Repeat again
			for (int rep = 1; rep <= 2; rep++) {
				System.out.print("|");
				for (int unders = 1; unders <= SIZE*2; unders++)
				System.out.print("_");
			}
			System.out.println("|");
		}
	}
	
	//STADIUM
	
	//drawTopLine
	
	public static void drawStadium() {
    System.out.print(" ");
    for (int underS = 1; underS <= SIZE*8+2; underS++) {
    	System.out.print("_");
    }
    System.out.println(" ");   
    // draw second line with underscores
    System.out.print("|");
    for (int i = 1; i <= SIZE*8+2; i++) { //Total symbols in a row, i stands for number of a character
    	if(i > SIZE*4 && i <= SIZE*4+2) {
    		System.out.print("_");                                 
        }
    	else
    		System.out.print(" ");
    }
    System.out.println("|");
    
    // draw Top Part
    
    for (int row = 1; row <= SIZE*2; row++ ) {
    	System.out.print("|");
    	for(int spaces = 1; spaces <= SIZE*4 - row*2; spaces++) // Loop for spaces and _/
    		System.out.print(" ");
            System.out.print("_/");
            //Printing dots or stars inside
            for (int i = 1; i <= (row*4)-2; i++) { //Total symbols in a row, i stands for number of a character
            	if(row > SIZE && (i >= row*2-SIZE && i < row*2+SIZE))
            		System.out.print("*");                                 
            	else
            		System.out.print(".");
            }
            System.out.print("\\_");
            //Printing spaces after
            for(int spaces = 1; spaces <= (SIZE*4)-(row*2); spaces++) {
                System.out.print(" ");
            }
            System.out.println("|");
    }
    
    // draw Bottom Part
    
    for (int row = SIZE*2-1; row >= 0 ; row-- ) {
    	System.out.print("|");
    	for(int spaces = SIZE * 4; spaces > row*2+1; spaces--) // Loop for spaces and \_
            System.out.print(" ");
            System.out.print("\\_");
            //Printing dots or stars inside
            for (int i = 0; i < row*4; i++) {
            	if(row >= SIZE && (i >= row*2-SIZE && i < row*2+SIZE))
                    System.out.print("*");                                 
                else
                	System.out.print(".");
            }
            System.out.print("_/");
            //Printing spaces after
            for(int spaces = 1; spaces < (SIZE*4)-(row*2); spaces++) { //Total symbols in a row, i stands for number of a character
                System.out.print(" ");
            }
            System.out.println("|");
    }
    
    // draw last line
    
    System.out.print("|");
    for (int underS = 1; underS <= SIZE*8+2; underS++) {
    	System.out.print("_");
    }
    System.out.println("|");   
	}
}