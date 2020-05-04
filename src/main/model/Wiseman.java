package model;

import interactionException.EmptyMotto;

import java.util.ArrayList;

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
        return "This is mottoWiseman" + "\n" + super.wisemanInfo() + "\n" + "MottoWiseman have a lot to tell you";
    }

    //MODIFIES: this, motto
    //EFFECTS: add motto to this
    public void addMotto(Motto motto) throws EmptyMotto {
        if (motto == null) throw new EmptyMotto();
        if (!mottos.contains(motto)) {
            mottos.add(motto);
            motto.addWiseman(this);
        }
    }

    //MODIFIES: this, motto
    //EFFECTS: remove motto to this
    public void removeMotto(Motto motto) throws EmptyMotto {
        if (mottos.contains(motto)) {
            mottos.remove(motto);
            motto.removeWiseman();
        }
    }
//
//    //EFFECTS:print string
//    public void print(Motto m) {
//        print(m.toString());
//    }

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
        return getResult(mottos);
    }

    public ArrayList<Motto> getMotto() {
        return mottos;
    }



}

