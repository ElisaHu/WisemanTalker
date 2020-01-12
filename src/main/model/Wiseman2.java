package model;

import interactionexception.EmptyDream;

import java.io.IOException;
import java.util.ArrayList;

public class Wiseman2 extends WisemanModel {

    private DreamDealer dreamDealer;

    public Wiseman2(int age, String status, ArrayList<String> dream) {

        dreamDealer = new DreamDealer(this);
        this.age = age;
        this.status = status;
        //this.dream = dream;
        dreamDealer.setDream(dream);
    }

    // EFFECT: return personal wiseman info
    @Override
    public String wisemanInfo() {
//        print("This is dreamWiseman");
//        super.wisemanInfo();
//        System.out.println("If you tell me a dream, it is more likely to come true!");
//        printDashLine();
        return "This is dreamWiseman" + "\n" + super.wisemanInfo() + "\n"
                + "If you tell me a dream, it is more likely to come true!";
    }



    //MODIFIES: this
    //EFFECTS: add dream to dream list, throw exception if it is an empty string
    public void addDream(String s) {
        dreamDealer.addDream(s);
    }

    //EFFECTS: print dream
    public String printDream() {
        return dreamDealer.printDream();
    }

    public ArrayList<String> getDream() {
        return dreamDealer.getDream();
    }


    //EFFECTS: call save in dreamDealer
    public void save() throws IOException {
        dreamDealer.save();
    }

    //EFFECTS: run load in dreamDealer
    public String load() throws IOException {
        return dreamDealer.load();
    }


}
