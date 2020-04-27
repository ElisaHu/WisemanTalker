package model;

import observer.Subject;
import java.util.ArrayList;
import java.util.List;

public abstract class WisemanModel extends Subject {
    protected int age;
    protected String status;

    //MODIFIES: this
    //EFFECTS: print message, change this
    public String wisemanInfo() {
        return "Wiseman is a " + this.getStatus() + " person. " + "Wiseman is "
                + this.getAge() + " years old";
    }

    //MODIFIES: this and list
    //EFFECTS: print each element in list
    public String getResult(List list) {
        String result = "";
        for (int i = 0; i < list.size(); i++) {
            result = result + list.get(i) + "\n";
        }
        return result;
    }

    //EFFECTS: print dash line for simplicity
    public void printDashLine() {
        System.out.println("----------------------------");
    }

    public String getStatus() {
        return this.status;
    }

    public int getAge() {
        return this.age;
    }

}
