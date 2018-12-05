package models;

import java.util.Scanner;

public class Board {
    Field[][] fields = new Field[9][9];
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

    public void turn() {
        if (isWhiteTurn) {

        }
    }

    public Figure chooseFigure(Field[][] fields) {
        String input;
        int row = 0;
        int column = 0;

        while ((column + row) % 2 == 0) {
            if ((column + row) % 2 == 1) System.out.println("Wrong coordinates");
            System.out.println("Choose column(A-H) and  row(1-8). expl ('A 1')");
            Scanner in = new Scanner(System.in);
            input = in.nextLine();
            row = ((input.charAt(0)) - 65);
            column = 8 - Integer.parseInt(input.substring(2, 3));
            System.out.println(column + " " + row);
        }
        return fields[column % 2][row].getOccupatedBy();
    }
}
