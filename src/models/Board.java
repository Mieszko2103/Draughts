package models;

public class Board {
    Field[][] fields = new Field[8][4];


    public Field getField (int column, int row ) {
        return fields[column][row];
    }

    public Board() {
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < 4; j++) {
                fields[i][j]= new Field(null,i,j);
                if (i<2) fields[i][j].setOccupatedBy(new Figure(true,fields[i][j]));
                else if (i>5) fields[i][j].setOccupatedBy(new Figure(false,fields[i][j]));

            }
        }
    }

    public void show (){
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                if (i%2==0) System.out.print("   ");
                if (fields[i][j].getOccupatedBy()==null) System.out.print("[ ]");
                else System.out.print("["+fields[i][j].getOccupatedBy().getIcon()+"]");
                if (i%2==1) System.out.print("   ");
            }
            System.out.println();
        }
    }
}
