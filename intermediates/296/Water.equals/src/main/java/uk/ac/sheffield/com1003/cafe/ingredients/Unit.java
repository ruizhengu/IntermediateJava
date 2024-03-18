package uk.ac.sheffield.com1003.cafe.ingredients;

public enum Unit {
    UNDEFINED, GR, ML;

    public boolean equals(Unit another) {
        return another != null && this == another;
    }
}
