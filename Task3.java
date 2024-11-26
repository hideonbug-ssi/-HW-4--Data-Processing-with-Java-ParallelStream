import java.util.stream.IntStream;

public class Task3 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        long count = IntStream.rangeClosed(1, 1_000_000)
                .parallel()
                .map(Integer::reverseBytes)
                .filter(val -> val >= 0)
                .count();
        long end = System.currentTimeMillis();

        System.out.println("Count = " + count);
        System.out.println("Time taken = " + (end - start) + " ms");
    }
}
