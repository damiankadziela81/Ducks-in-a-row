package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static int ducksTotalWidth = 0;
    static int ducksTotalHeight = 0;
    static int maxRowWidth = 50;

    public static void main(String[] args) {

        System.out.println("Enter max width: ");
        Scanner scanner = new Scanner(System.in);
        maxRowWidth = scanner.nextInt();

        List<Duck> ducks = generateDucks();
        System.out.println("\nHere's the duck list:");
        ducks.forEach(System.out::println);

        List<Duck> bestDucks = selectBestDucks(ducks);
        System.out.println("\nHere's the list of chosen ducks: ");
        bestDucks.forEach(System.out::println);
        ducksTotalHeight = bestDucks.stream().map(Duck::getHeight).reduce(0, Integer::sum);
        ducksTotalWidth = bestDucks.stream().map(Duck::getWidth).reduce(0, Integer::sum);
        System.out.println("\nTotal height of selected ducks is: " + ducksTotalHeight);
        System.out.println("Total width of selected ducks is: " + ducksTotalWidth);
        System.out.println("Total number of ducks is: " + bestDucks.size());
    }

    static List<Duck> generateDucks(){
        List<Duck> listOfDucks = new ArrayList<>();
        listOfDucks.add(new Duck(3,2));
        listOfDucks.add(new Duck(5,4));
        listOfDucks.add(new Duck(7,6));
        listOfDucks.add(new Duck(2,1));
        listOfDucks.add(new Duck(8,5));
        listOfDucks.add(new Duck(4,3));
        listOfDucks.add(new Duck(6,7));
        listOfDucks.add(new Duck(9,9));
        listOfDucks.add(new Duck(1,2));
        listOfDucks.add(new Duck(5,4));
        listOfDucks.add(new Duck(7,6));
        listOfDucks.add(new Duck(8,8));
        listOfDucks.add(new Duck(3,3));
        listOfDucks.add(new Duck(4,5));
        listOfDucks.add(new Duck(6,7));
        listOfDucks.add(new Duck(2,1));
        listOfDucks.add(new Duck(1,2));
        listOfDucks.add(new Duck(5,4));
        listOfDucks.add(new Duck(8,6));
        listOfDucks.add(new Duck(9,8));
        return listOfDucks;
    }

    static List<Duck> selectBestDucks(List<Duck> list) {
        int totalWidth=0;
        int totalHeight=0;
        list.sort(new DuckRatioComparator());
        List<Duck> bestDucks = new ArrayList<>();
        for (Duck duck : list) {
            totalHeight += duck.getHeight();
            totalWidth += duck.getWidth();
            if (totalWidth <= maxRowWidth) bestDucks.add(duck);
            else {
                totalHeight -= duck.getHeight();
                totalWidth -= duck.getWidth();
            }
        }
        return bestDucks;
    }

}