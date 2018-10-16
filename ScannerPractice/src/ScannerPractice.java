import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerPractice {
	
    private static String favFood = "nothing yet";
    private static int amount = 0;
    private static double liking = 0.0;
    private static int total = 0;

    static Scanner sc = null;
    public static void main(String[] args) {
        try {
            System.out.print( "Your favorite food is " + getFavFood() + ".\nYou eat " + getFavFood() + " " + ( ( int )( ( amount/( double )( total/2 ) ) * 100 ) + "% of the time." ) );
        }
        catch ( Exception e ) {
            System.out.println( e );
        }
        finally {
            if ( sc != null ) {
                sc.close();
            }
        }
    }
    
    public static String getFavFood() {
        String fav = "";
        int amt = 0;
        double like = 0.0;
        File f = new File( "./src/foods.txt" );
        try {
            sc = new Scanner( f );
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }        
        while ( sc.hasNext() ) {
        	fav = sc.nextLine();
        	amt = sc.nextInt();
        	total += amt;
        	like = sc.nextDouble();
        	if ( like > liking ) {
        	    favFood = fav;
        	    amount = amt;
        	    liking = like;
        	}
        	sc.nextLine();
        	
        }
        return favFood;
    }
}
