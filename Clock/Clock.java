import java.util.InputMismatchException;
import java.util.Scanner;

public class Clock {

    private static int[] mTimes = new int[24];
    private static int mCurrentTime;

    public static void main( String[] args ) {
        
        for ( int i = 0; i < 24; i++ ) {
            mTimes[i] = i;
        }

        try {
            Scanner sc = new Scanner( System.in );
            System.out.print( "Current time (0-24): " );
            mCurrentTime = sc.nextInt();
            if ( mCurrentTime > 24 || mCurrentTime < 0 ) {
                throw new InputMismatchException( "Time cannot be outside of bounds 0-24" );
            }
            
            while ( true ) {
                int ffRR;
                System.out.print( "Fast foward/rewind how many hours? ");
                ffRR = sc.nextInt();
                mCurrentTime = timeAfter( ffRR );
                System.out.println( "Time after " + ffRR + " hours: " + mCurrentTime );
            }
        } catch ( Exception e ) {
            System.out.println( e );
        }
    }

    public static int timeAfter( int nextTime ) {
        return mTimes[ trimToTimesSize( nextTime + mCurrentTime ) ];
    }

    public static int trimToTimesSize( int toTrim ) {
        if ( toTrim >= mTimes.length ) {
            return trimToTimesSize( toTrim - mTimes.length );
        } else if ( toTrim < 0 ) {
            return trimToTimesSize( mTimes.length - toTrim );
        }
        return toTrim;
    }
}