package models;

public class Figure {
    private boolean isWhite;
    private char icon;
    private Field courrentField;

    public Field getCourrentField() {
        return courrentField;
    }

    public char getIcon() {
        return icon;
    }

    public Figure(boolean isWhite, Field courrentField) {
        this.isWhite = isWhite;
        this.courrentField = courrentField;
        if (isWhite) this.icon = 'o';
        else this.icon = 'x';
    }

    public boolean move(Field moveTo) {
        if (moveTo.getOccupatedBy() != null) return false;
        else if (isWhite) {
            if ((moveTo.getColumn() == (courrentField.getColumn() + 1)) && (moveTo.getRow() == (courrentField.getRow() + 1)) ||
                    (moveTo.getColumn() == courrentField.getColumn() + 1) && (moveTo.getRow() == courrentField.getRow())) {
                courrentField.setOccupatedBy(null);
                moveTo.setOccupatedBy(this);
                this.courrentField = moveTo;
                return true;
            } else return false;
        } else if ((moveTo.getColumn() == courrentField.getColumn() - 1) && (moveTo.getRow() == courrentField.getRow() + 1) ||
                (moveTo.getColumn() == courrentField.getColumn() - 1) && (moveTo.getRow() == courrentField.getRow())) {

            courrentField.setOccupatedBy(null);
            moveTo.setOccupatedBy(this);
            this.courrentField = moveTo;
            return true;
        }
        return false;
    }

}
