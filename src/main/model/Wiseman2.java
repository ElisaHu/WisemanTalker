package model;

import interactionException.EmptyDream;
import java.io.IOException;
import java.lang.annotation.Native;
import java.util.ArrayList;

public class Wiseman2 extends WisemanModel {

    private DreamDealer dreamDealer;

    public Wiseman2(int age, String status, ArrayList<String> dream) {
        dreamDealer = new DreamDealer(this);
        this.age = age;
        this.status = status;
        dreamDealer.setDream(dream);
    }

    // EFFECT: return personal wiseman info
    @Override
    public String wisemanInfo() {
        return "This is dreamWiseman" + "\n" + super.wisemanInfo() + "\n"
                + "If you tell me a dream, I will make it come true!";
    }

    //MODIFIES: this
    //EFFECTS: add dream to dream list, throw exception if it is an empty string
    public void addDream(String s) throws EmptyDream {
        if (s == null) throw new EmptyDream();
        dreamDealer.addDream(s);
    }

    public void addObserver(NaiveKid c) {
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
