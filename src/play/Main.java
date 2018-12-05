package play;

import models.Board;
import models.Field;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.show();

//        board.getField(3,3).getOccupatedBy().setIcon("[G]");
//        System.out.println(board.getField(3,3).getOccupatedBy().move(board.getField(4,2)));
//
//        board.show();


        //System.out.println(board.getField(6,0).getOccupatedBy().move(board.getField(5,1)));
        // board.show();
    }

}
