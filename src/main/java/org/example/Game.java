package org.example;

import java.util.Arrays;

public class Game {
    private final Marker[][] board = new Marker[3][3];
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
    private boolean isArrayHomogenous(Marker[] markers){
        Marker first = markers[0];
        for(int i=1;i< markers.length;i++){
            if(markers[i] != first){
                return false;
            }
        }
        return true;
    }
    private Marker checkHorizontal(){
        for(Marker[] markers : board){
            if(markers[0] != Marker.empty && isArrayHomogenous(markers)){
                return markers[0];
            }
        }
        return Marker.empty;
    }
    private Marker[] makeVertical(Marker[][] markers, int x){

    }
    private Marker checkVertical(){
        for(int i=0;i<board[0].length;i++){
            Marker[] markers = makeVertical(board, i);
            if(markers[0] != Marker.empty && isArrayHomogenous(markers)){
                return markers[0];
            }
        }
        return Marker.empty;
    }
    private void checkIfWon(){

    }
    public boolean placeMarker(int x, int y){
        if(!gameStarted){
            return false;
        }
        if(board[y][x] != Marker.empty){
            return false;
        }
        board[y][x] = currentPlayer;
        checkIfWon();
        switchPlayer();
        return true;
    }
}
