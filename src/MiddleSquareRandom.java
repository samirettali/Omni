public class MiddleSquareRandom {

    private long seed;
    private int length;

    public MiddleSquareRandom(long seed) {
        this.seed = seed;
        this.length = Long.toString(seed).length();
    }

    public long next() {
        this.seed = (long) Math.pow(this.seed, 2);
        int index = (Long.toString(seed).length() - this.length) / 2;
        this.seed = Long.parseLong(Long.toString(seed).substring(index, length - index));
        return seed;
    }
}
