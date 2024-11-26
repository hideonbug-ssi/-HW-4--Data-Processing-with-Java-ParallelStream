import java.util.stream.IntStream;

public class Task5 {
    public static final int NUM_CORES = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        IntStream.range(0, 3 * NUM_CORES)
                .parallel()
                .map(val -> {
                    System.out.println(val + " processed by: " + Thread.currentThread().getName());
                    return Integer.reverseBytes(val);
                })
                .filter(val -> val >= 0)
                .count();
    }
}
