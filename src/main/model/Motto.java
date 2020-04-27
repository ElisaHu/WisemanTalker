package model;

import interactionException.EmptyMotto;

import java.util.Objects;

public class Motto {
    protected String motto;
    Wiseman wiseman;

    public Motto(String motto) {
        this.motto = motto;
    }

    //MODIFIES: this, wiseman
    //EFFECTS: add wiseman to this
    public void addWiseman(Wiseman wiseman) throws EmptyMotto {
        if (this.wiseman != null && this.wiseman != wiseman) {
            this.wiseman.removeMotto(this);
        }
        this.wiseman = wiseman;
        if (this.wiseman != null) {
            this.wiseman.addMotto(this);
        }
    }

    //MODIFIES: this, wiseman
    //EFFECTS: remove wiseman from this
    public void removeWiseman() throws EmptyMotto {
        wiseman.removeMotto(this);
        addWiseman(null);
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public Wiseman getWiseman() {
        return wiseman;
    }

    public void setWiseman(Wiseman wiseman) {
        this.wiseman = wiseman;
    }


    //MODIFIES: this
    //EFFECTS: transfer the object to string
    @Override
    public String toString() {
        return motto;
    }

}
