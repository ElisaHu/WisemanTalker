package model;

import network.ReadWebPage;
//import observer.Subject;

import java.io.IOException;

public class Wiseman3 extends WisemanModel {
    protected int age;
    protected String status;

    public Wiseman3(int age, String status)  {
        this.age = age;
        this.status = status;
    }

    //EFFECTS: print the information of wiseman 3
    @Override
    public String wisemanInfo() {
        return "This is weather wiseman" + "\n" + super.wisemanInfo() + "\n"
                + "Give me the city and the country, I can predict the weather!" + "\n"
                + "For instance: London,uk | Vancouver,ca" + "\n";
    }

    //MODIFIES: this
    //EFFECTS: create constructor and call method in instance
    public String predict(String city) throws IOException {
        ReadWebPage web = new ReadWebPage();
        return web.accessWeb(city);
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getStatus() {
        return status;
    }
}

