package org.example;

import java.util.Arrays;

public class Game {
    private final Marker[][] board = new Marker[3][3];
    private boolean gameStarted = false;
    private Marker currentPlayer = Marker.X;
    private Marker playerWon;
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
    public Marker getCurrentPlayer(){
        return currentPlayer;
    }
    public Marker getWinner(){
        return playerWon;
    }
    public Marker readBoard(int x, int y){
        return board[y][x];
    }
    @Override
    public String toString(){
        return Arrays.deepToString(board);
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
        Marker[] vertical = new Marker[markers[0].length];
        for(int i=0;i<vertical.length;i++){
            vertical[i] = markers[i][x];
        }
        return vertical;
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
    private Marker checkDiagonal(){
        if((board[0][0] == Marker.X && board[1][1] == Marker.X && board[2][2] == Marker.X) ||
                (board[0][2] == Marker.X && board[1][1] == Marker.X && board[2][0] == Marker.X)){
            return Marker.X;
        }
        if((board[0][0] == Marker.O && board[1][1] == Marker.O && board[2][2] == Marker.O) ||
                (board[0][2] == Marker.O && board[1][1] == Marker.O && board[2][0] == Marker.O)){
            return Marker.O;
        }
        return Marker.empty;
    }
    private Marker checkIfWon(){
        Marker horizontal = checkHorizontal();
        if(horizontal != Marker.empty){
            return horizontal;
        }
        Marker vertical = checkVertical();
        if(vertical != Marker.empty){
            return vertical;
        }
        Marker diagonal = checkDiagonal();
        if(diagonal != Marker.empty){
            return diagonal;
        }
        return Marker.empty;
    }
    public boolean placeMarker(int x, int y) throws PlayerWon {
        if(!gameStarted){
            return false;
        }
        if(board[y][x] != Marker.empty){
            return false;
        }
        board[y][x] = currentPlayer;
        Marker playerWon = checkIfWon();
        if(playerWon != Marker.empty){
            gameStarted = false;
            this.playerWon = playerWon;
            throw new PlayerWon(playerWon);
        }
        switchPlayer();
        return true;
    }
}
