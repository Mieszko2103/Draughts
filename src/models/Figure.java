package models;

public class Figure {
    private boolean isWhite;
    private String icon;
    private Field courrentField;

    public Figure(boolean isWhite, Field courrentField) {
        this.isWhite = isWhite;
        this.courrentField = courrentField;
        if (isWhite) this.icon = "[o]";
        else this.icon = "[x]";
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Field getCourrentField() {
        return courrentField;
    }


    public boolean move(Field moveTo) {
        if (moveTo.getOccupatedBy() != null && !moveTo.isActive()) {
            System.out.println("Wrong move coordinates");
            return false;
        } else if (isWhite) {
            if ((moveTo.getColumn() == (courrentField.getColumn() + 1)) &&
                    (moveTo.getRow() == (courrentField.getRow() - 1)) ||
                    (moveTo.getColumn() == courrentField.getColumn() - 1) &&
                            (moveTo.getRow() == courrentField.getRow() - 1)) {
                courrentField.setOccupatedBy(null);
                moveTo.setOccupatedBy(this);
                this.courrentField = moveTo;
                return true;
            } else return false;

        } else if (((moveTo.getColumn() == courrentField.getColumn() + 1) &&
                (moveTo.getRow() == courrentField.getRow() + 1)) ||
                ((moveTo.getColumn() == courrentField.getColumn() - 1) &&
                        (moveTo.getRow() == courrentField.getRow() + 1))) {

            courrentField.setOccupatedBy(null);
            moveTo.setOccupatedBy(this);
            this.courrentField = moveTo;
            return true;
        }
        return false;
    }

    public boolean attack(Field moveTo, Field attackOver) {
        if (moveTo.getOccupatedBy() != null ||
                !moveTo.isActive() ||
                attackOver.getOccupatedBy() != null &&
                attackOver.getOccupatedBy().isWhite == this.isWhite) {
            System.out.println("You can't attack like that");
            return false;
        } else if (((moveTo.getColumn() == (courrentField.getColumn() + 2)) && (moveTo.getRow() == (courrentField.getRow() - 2))) ||
                ((moveTo.getColumn() == (courrentField.getColumn() + 2)) && (moveTo.getRow() == (courrentField.getRow() + 2))) ||
                ((moveTo.getColumn() == (courrentField.getColumn() - 2)) && (moveTo.getRow() == (courrentField.getRow() - 2))) ||
                ((moveTo.getColumn() == (courrentField.getColumn() - 2)) && (moveTo.getRow() == (courrentField.getRow() + 2)))) {
            courrentField.setOccupatedBy(null);
            attackOver.setOccupatedBy(null);
            moveTo.setOccupatedBy(this);
            this.courrentField = moveTo;
            return true;
        } return false;

    }

}
