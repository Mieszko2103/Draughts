package models;

import java.util.Scanner;

public class Board {
    static Field[][] fields = new Field[9][9];
    boolean isWhiteTurn = true;

    public Board() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == 0 || j == 0) fields[i][j] = new Field(null, i, j, false);
                else if ((i + j) % 2 == 1) fields[i][j] = new Field(null, i, j, false);
                else fields[i][j] = new Field(null, i, j, true);
                if (fields[i][j].isActive() && i < 4) fields[i][j].setOccupatedBy(new Figure(false, fields[i][j]));
                else if (fields[i][j].isActive() && i > 5) fields[i][j].setOccupatedBy(new Figure(true, fields[i][j]));

            }
        }
    }

    public Field getField(int row, int column) {
        return fields[row][column];
    }

    public Field[][] getFields() {
        return fields;
    }

    public void show() {
        System.out.println("    A  B  C  D  E  F  G  H");
        for (int i = 8; i > 0; i--) {
            System.out.print(" " + i + " ");

            for (int j = 1; j < 9; j++) {

                if (fields[i][j].isActive() && fields[i][j].getOccupatedBy() == null) System.out.print("[ ]");
                else if (fields[i][j].getOccupatedBy() != null)
                    System.out.print(fields[i][j].getOccupatedBy().getIcon());
                else System.out.print("   ");
            }
            System.out.print(" " + i + " ");
            System.out.println();
        }
        System.out.println("    A  B  C  D  E  F  G  H");
    }

    public void turn(boolean isWhiteTurn) {
        if (isWhiteTurn) {


            chooseFigure(isWhiteTurn);


        }
    }

    public Figure chooseFigure(boolean isWhiteTurn) {
        int row = 0;
        int column = 0;
        while (fields[row][column].getOccupatedBy() != null && fields[row][column].getOccupatedBy().isWhite() == isWhiteTurn) {
            if (isWhiteTurn) System.out.println("White's turn!");
            else System.out.println("Black's turn!");
            System.out.println("Choose row: ");
            Scanner in = new Scanner(System.in);
            row = in.nextInt();
            System.out.println("Choose column: ");
            column = in.nextInt();
        }
        return fields[row][column].getOccupatedBy();
    }
}
