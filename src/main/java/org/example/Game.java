package org.example;

import java.util.Arrays;

public class Game {
    private Marker[][] board = new Marker[3][3];
    private boolean gameStarted = false;
    private Marker currentPlayer = Marker.X;
    public boolean startGame(Marker firstPlayer){
        if(gameStarted){
            return false;
        }
        currentPlayer = firstPlayer;
        for(Marker[] markers : board){
            Arrays.fill(markers, Marker.empty);
        }
        gameStarted = true;
        return true;
    }
    public boolean startGame(){
        return startGame(Marker.X);
    }
    private void switchPlayer(){
        if(currentPlayer == Marker.X){
            currentPlayer = Marker.O;
            return;
        }
        currentPlayer = Marker.X;
    }
    public boolean placeMarker(int x, int y){
        if(!gameStarted){
            return false;
        }
        if(board[x][y] != Marker.empty){
            return false;
        }
        board[x][y] = currentPlayer;
        switchPlayer();
        return true;
    }
}
