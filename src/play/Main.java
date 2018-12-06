package play;

import models.Board;
import models.Field;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.show();

        System.out.println(board.getField(3,3).getOccupatedBy().move(board.getField(4,2)));

        board.show();

        System.out.println(board.getField(4,2).getOccupatedBy().move(board.getField(5,3)));

        board.show();

        System.out.println(board.getField(6,2).getOccupatedBy().attack(board.getField(4,4),board.getField(5,3)));
        board.show();

        System.out.println(board.getField(3,5).getOccupatedBy().attack(board.getField(5,3),board.getField(4,4)));
        board.show();

        System.out.println(board.getField(7,3).getOccupatedBy().attack(board.getField(5, 5),board.getField(6,4)));
        board.show();
        //System.out.println(board.getField(6,0).getOccupatedBy().move(board.getField(5,1)));
        // board.show();
    }

}
