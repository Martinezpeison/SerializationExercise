package org.example.model;

import java.io.Serializable;

public class Session implements Serializable {
    private int duration;
    private int room;

    public Session(int duration, int room) {
        this.duration = duration;
        this.room = room;
    }

    public int getDayTime() {
        return duration;
    }

    public void setDayTime(int duration) {
        this.duration = duration;
    }

    public int getRoom() {
        return room;
    }

    public void setRoom(int room) {
        this.room = room;
    }
}
