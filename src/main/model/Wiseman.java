package model;

import interactionexception.EmptyMotto;

import java.util.ArrayList;
import java.util.List;

public class Wiseman extends WisemanModel {

    private ArrayList<Motto> mottos;


    public Wiseman(int age, String status, ArrayList<Motto> mottos) {
        this.age = age;
        this.status = status;
        this.mottos = mottos;
    }

    // EFFECT: print information of wiseman1
    @Override
    public String wisemanInfo() {
//        print("This is mottoWiseman");
//        super.wisemanInfo();
//        print("MottoWiseman have a lot to tell you");
//        printDashLine();
        return "This is mottoWiseman" + "\n" + super.wisemanInfo() + "\n" + "MottoWiseman have a lot to tell you";
    }
//
//    //MODIFIES: THIS
//    //EFFECT: change the age, return a integer.
//
//    public int gettingOlder() {
//        int i = 1;           // Using local variable
//        this.age = this.age + i;
//        i++;
//        return i;
//
//    }


    //MODIFIES: this, motto
    //EFFECTS: add motto to this
    public void addMotto(Motto motto) {
        if (!mottos.contains(motto)) {
            mottos.add(motto);
            motto.addWiseman(this);
        }
    }

    //MODIFIES: this, motto
    //EFFECTS: remove motto to this
    public void removeMotto(Motto motto) {
        if (mottos.contains(motto)) {
            mottos.remove(motto);
            motto.removeWiseman();

        }
    }
//    public void addMotto(String s) throws EmptyMotto {
//        if (s.equals("")) {
//            throw new EmptyMotto();
//        }
//            motto.add(s);
//        }
//    }

    //EFFECTS:print string
    public void print(Motto m) {
        print(m.toString());
    }

    // effect: print out the motto
//    public String printMotto() {
//        String sentence = "";
//        for (Motto s : mottos) {
//            sentence = sentence + s + "\n";
//        }
//        return sentence;
//    }

    //REQUIRES: mottos is not null
    //EFFECTS: print mottos
    public String printMotto() {
        return printResult(mottos);
    }


    public ArrayList<Motto> getMotto() {
        return mottos;
    }

//    public ArrayList<String> getMotto() {
//        return motto;
//    }


}

