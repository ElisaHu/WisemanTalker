package model;

//import observer.Subject;

import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public abstract class WisemanModel extends Subject {


    protected int age;

    protected String status;

    //MODIFIES: this
    //EFFECTS: print message, change this
    public String wisemanInfo() {
//
//        System.out.println("Wiseman is a " + this.getStatus() + " person");
//
//        System.out.println("Wiseman is " + this.getAge() + " years old");
//
//        gettingOlder(5);

        return "Wiseman is a " + this.getStatus() + " person. " + "Wiseman is "
                + this.getAge() + " years old";

    }

    //REQUIRES: i > 0
    //MODIFIES: this
    //EFFECTS: increase age, return i
//    public int gettingOlder(int i) {
//        this.age = this.age + i;
//        i++;
//        return i;
//    }

    //MODIFIES: this and list
    //EFFECTS: print each element in list
    public String printResult(List list) {
        String result = "";
        if (list.size() == 0) {
            return "";
        } else {
            for (int i = 0; i < list.size(); i++) {
                result = result + list.get(i) + "\n";
            }
        }
        return result;
    }

    //EFFECTS: print dash line
    public void printDashLine() {
        print("----------------------------");
    }

    //REQUIRES: s is not null
    //EFFECTS: print the given string
    public void print(String s) {
        System.out.println(s);
    }

    public String getStatus() {
        return this.status;
    }

    public int getAge() {
        return this.age;
    }




}
