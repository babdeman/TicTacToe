package org.example;

public class PlayerWon extends Exception{
    private Marker player;
    public PlayerWon(Marker player){
        this.player = player;
    }
    public Marker getPlayer(){
        return player;
    }
}
