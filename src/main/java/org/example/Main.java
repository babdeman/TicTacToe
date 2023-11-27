package org.example;

public class Main {
    public static void test0(Game game) throws PlayerWon {;
        game.startGame();
        game.placeMarker(0, 0);
        game.placeMarker(0, 1);
        game.placeMarker(1, 0);
        game.placeMarker(1, 1);
        game.placeMarker(2, 0);
        game.placeMarker(2, 1);
    }
    public static void test1(Game game) throws PlayerWon {
        game.startGame();
        game.placeMarker(0, 1);
        game.placeMarker(0, 0);
        game.placeMarker(1, 2);
        game.placeMarker(1, 1);
        game.placeMarker(2, 0);
        game.placeMarker(2, 2);
    }
    public static void main(String[] args) {
        Game game = new Game();
        try{
            test1(game);
        }
        catch(PlayerWon playerWon){
            System.out.println(playerWon.getPlayer() + " won");
        }
        finally{
            System.out.println(game);
        }
    }
}