package models;

public class Field {

    private Figure occupatedBy;
    private int row;
    private int column;
    private boolean isActive;


    public Field(Figure occupatedBy, int row, int column, boolean isActive) {
        this.occupatedBy = occupatedBy;
        this.column = column;
        this.row = row;
        this.isActive = isActive;
    }

    public void setOccupatedBy(Figure occupatedBy) {
        this.occupatedBy = occupatedBy;
    }

    public Figure getOccupatedBy() {
        return occupatedBy;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }


    public boolean isActive() {
        return isActive;
    }
}
