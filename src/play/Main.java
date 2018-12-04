package play;

import models.Board;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.show();

        System.out.println(board.getField(1,2).getOccupatedBy().move(board.getField(2,2)));

        board.show();


        System.out.println(board.getField(6,0).getOccupatedBy().move(board.getField(5,1)));
        board.show();
    }

}
