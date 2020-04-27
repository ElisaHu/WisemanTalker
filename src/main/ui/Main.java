package ui;

import model.*;

import java.io.IOException;
import java.util.ArrayList;


public class Main {


    //private static RetrieveName retrieveName;

    //Effect: Start the program
    public static void main(String[] args) {

        ArrayList<String> dreamList = new ArrayList<>();
        ArrayList<Motto> mottos = new ArrayList<>();

        Motto motto1 = new Motto("It is not the length of life, but depth of life.");
        Motto motto2 = new Motto("No pain, no gain.");
        mottos.add(motto1);
        mottos.add(motto2);

        NaiveKid kid2 = new NaiveKid("Tom");
        NaiveKid kid1 = new NaiveKid("Jerry");

        Wiseman wiseman = new Wiseman(209,"ordinary",mottos);
        Wiseman2 wiseman2 = new Wiseman2(999,"kind",dreamList);
        Wiseman3 wiseman3 = new Wiseman3(10,"stunning");

        wiseman2.addObserver(kid2);
        wiseman2.addObserver(kid1);

//        retrieveName = new RetrieveName();
//        retrieveName.addretrieve(wiseman.getStatus(),wiseman);
//        retrieveName.addretrieve(wiseman2.getStatus(),wiseman2);
//        System.out.println("test");
//        int aggge = retrieveName.getWisemanFromName(wiseman.getStatus()).getAge();
//        System.out.println(aggge);

        new Scanning(wiseman, wiseman2, wiseman3);
    }
}

// test random
//int randomNum = ThreadLocalRandom.current().nextInt(0,  7 + 1);
//System.out.println(randomNum);
//double x = Math.random() * 100;
//System.out.println(x);
