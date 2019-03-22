package euler;

public class TwoDigitNumber {
    private int value;
    private String firstPart;
    private String lastPart;

    public TwoDigitNumber(int value) {
        this.value = value;
        this.firstPart = Integer.toString(value).substring(0, 2);
        this.lastPart = Integer.toString(value).substring(2, 4);
    }

    public int getValue() {
        return this.value;
    }

    public String getFirst() {
        return this.firstPart;
    }

    public String getLast() {
        return this.lastPart;
    }
}

