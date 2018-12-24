import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class XMLFileValidator {
    private static ArrayList<String> lines = new ArrayList<>();

    public static void main( String[] args ) {
        validate( "example.xml" );
    }

    public static void validate( String p ) {
        File f = new File( p );

        try {
            Scanner sc = new Scanner( f );
            while ( sc.hasNext() ) {
                lines.add( sc.nextLine() );
            }
        } catch ( Exception e ) {
            System.out.println( e );
        }
        for ( int i = lines.size() - 1; i >= 0; i-- ) {
            if ( lines.get( i ).trim().length() <= 0 ) {
                lines.remove( i );
            } 
        }
        for ( String line : lines ) {
            checkLine( line, lines.indexOf( line ) + 1 );
        }
    }

    public static void checkLine( String line, int lineNumber ) {
        if ( lineNumber == 0 ) {}
    }
}