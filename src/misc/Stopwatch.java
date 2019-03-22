package misc;

public class Stopwatch {

    private long start;

    public Stopwatch() {

    }

    public void start() {
        start = System.nanoTime();
    }

    public long elapsedNano() {
        return System.nanoTime() - start;
    }

    public long elapsedMicro() {
        return elapsedNano() / 1000;
    }

    public long elapsedMilli() {
        return elapsedNano() / 1000000;
    }

    public long elapsedSeconds() {
        return elapsedNano() / 1000000000;
    }

    public void printNano(String s) {
        System.out.println(s + " " + elapsedNano() + " ns.");
    }

    public void printMicro(String s) {
        System.out.println(s + " " + elapsedMicro() + " Ms.");
    }

    public void printMilli(String s) {
        System.out.println(s + " " + elapsedMilli() + " ms.");
    }

    public void printNano() {
        printNano("Execution time:");
    }

    public void printMicro() {
        printMicro("Execution time:");
    }

    public void printMilli() {
        printMilli("Execution time:");
    }


}
