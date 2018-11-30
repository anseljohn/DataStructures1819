import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.TreeMap;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class ThanksgivingMaps {
    
    public static void main( String[] args ) {
        ArrayList<String> foods = new ArrayList<>();

        Map<String, Integer> foodMap = map1();
        Object[] foodArray = foodMap.keySet().toArray();
        System.out.println("Map 1:");
        for ( int i = 0; i < foodMap.keySet().size(); i++ ) {
            System.out.println( foodArray[i] + ": " + foodMap.get( foodArray[i] ) );
        }
        System.out.println("\n\n\nMap 2:");

        Map<Integer, ArrayList<String>> foodMap2 = map2();
        Object[] foodArray2 = foodMap2.keySet().toArray();
        for ( int i = 0; i < foodMap2.keySet().size(); i++ ) {
            System.out.println( foodArray2[i] + ": " + foodMap2.get( foodArray2[i] ) );
        }

    }

    public static Map<String, Integer> map1() {
        ArrayList<String> foods = getFoods();

        Map<String, Integer> foodMap = new TreeMap<>();
        for ( int i = 0; i < foods.size(); i++ ) {
            if ( foodMap.get( foods.get( i ) ) != null ) {
                foodMap.put( foods.get( i ), foodMap.get( foods.get( i ) ) + 1 );
            }
            foodMap.putIfAbsent( foods.get( i ), 1 );
        }
        return foodMap;
    }

    public static Map<Integer, ArrayList<String>> map2() {
        Map<String, Integer> foodMap = map1();
        Map<Integer, ArrayList<String>> newFoodMap = new TreeMap<>();
        ArrayList<String> foods = getFoods();

        Set<String> nonRepetFoods = new LinkedHashSet<>( foods );
        foods = new ArrayList<>( nonRepetFoods );

        for ( int i = 0; i < foodMap.keySet().size(); i++ ) {
            if ( newFoodMap.get( foodMap.get( foods.get( i ) ) ) != null ) {
                newFoodMap.get( foodMap.get( foods.get( i ) ) ).add( foods.get( i ) );
                newFoodMap.put( foodMap.get( foods.get( i ) ),  newFoodMap.get( foodMap.get( foods.get( i ) ) ) );
            }
            ArrayList<String> foodsForScore = new ArrayList<>();
            foodsForScore.add( foods.get( i ) );
            newFoodMap.putIfAbsent( foodMap.get( foods.get( i ) ),  foodsForScore );
        }
        return newFoodMap;
    }

    public static ArrayList<String> getFoods() {
        ArrayList<String> foods = new ArrayList<>();
        File f = new File( "Foods.txt" );
        try {
            Scanner sc = new Scanner( f );
            
            while ( sc.hasNext() ) {
                foods.add( sc.nextLine() );
            }
            return foods;
        } catch ( FileNotFoundException e ) {
            System.out.println( "No file bro" );
        }
        return null;
    }
}