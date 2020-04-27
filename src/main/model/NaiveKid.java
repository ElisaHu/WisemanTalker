package model;


import observer.Observer;

public class NaiveKid implements Observer {
    String name;

    public NaiveKid(String name) {
        this.name = name;
    }

    public void update(String dream) {
        update();
        System.out.println(getName() + "I achieved the dream " + dream + " ! Yay me!");
    }

    //EFFECTS: print string
    @Override
    public void update() {
        System.out.println(getName() + "I achieved the dream ");
    }

    public String getName() {
        return name;
    }
}
