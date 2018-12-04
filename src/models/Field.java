package models;

public class Field {

    private Figure occupatedBy;

    private int column;
    private int row;

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setOccupatedBy(Figure occupatedBy) {
        this.occupatedBy = occupatedBy;
    }


    public Field(Figure occupatedBy, int column, int row) {
        this.occupatedBy = occupatedBy;
        this.column = column;
        this.row = row;
    }

    public Figure getOccupatedBy() {
        return occupatedBy;
    }

}
