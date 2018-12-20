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

    public boolean isWhite() {
        return isWhite;
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

    public boolean canattack() {
        if (this.getCourrentField().getRow() < 8 && this.getCourrentField().getColumn() < 8 &&
                Board.fields[this.getCourrentField().getRow() + 1][this.getCourrentField().getColumn() + 1].getOccupatedBy() != null &&
                Board.fields[this.getCourrentField().getRow() + 1][this.getCourrentField().getColumn() + 1].getOccupatedBy().isWhite != this.isWhite &&
                Board.fields[this.getCourrentField().getRow() + 2][this.getCourrentField().getColumn() + 2].isActive() &&
                Board.fields[this.getCourrentField().getRow() + 2][this.getCourrentField().getColumn() + 2].getOccupatedBy() == null)
            return true;

        if (this.getCourrentField().getRow() > 1 && this.getCourrentField().getColumn() < 8 &&
                Board.fields[this.getCourrentField().getRow() - 1][this.getCourrentField().getColumn() + 1].getOccupatedBy() != null &&
                Board.fields[this.getCourrentField().getRow() - 1][this.getCourrentField().getColumn() + 1].getOccupatedBy().isWhite != this.isWhite &&
                Board.fields[this.getCourrentField().getRow() - 2][this.getCourrentField().getColumn() + 2].isActive() &&
                Board.fields[this.getCourrentField().getRow() - 2][this.getCourrentField().getColumn() + 2].getOccupatedBy() == null)
            return true;

        if (this.getCourrentField().getRow() > 1 && this.getCourrentField().getColumn() > 1 &&
                Board.fields[this.getCourrentField().getRow() - 1][this.getCourrentField().getColumn() - 1].getOccupatedBy() != null &&
                Board.fields[this.getCourrentField().getRow() - 1][this.getCourrentField().getColumn() - 1].getOccupatedBy().isWhite != this.isWhite &&
                Board.fields[this.getCourrentField().getRow() - 2][this.getCourrentField().getColumn() - 2].isActive() &&
                Board.fields[this.getCourrentField().getRow() - 2][this.getCourrentField().getColumn() - 2].getOccupatedBy() == null)
            return true;

        if (this.getCourrentField().getRow() < 8 && this.getCourrentField().getColumn() > 1 &&
                Board.fields[this.getCourrentField().getRow() + 1][this.getCourrentField().getColumn() - 1].getOccupatedBy() != null &&
                Board.fields[this.getCourrentField().getRow() + 1][this.getCourrentField().getColumn() - 1].getOccupatedBy().isWhite != this.isWhite &&
                Board.fields[this.getCourrentField().getRow() + 2][this.getCourrentField().getColumn() - 2].isActive() &&
                Board.fields[this.getCourrentField().getRow() + 2][this.getCourrentField().getColumn() - 2].getOccupatedBy() == null)
            return true;
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
        }
        return false;

    }


}
