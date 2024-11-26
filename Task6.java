import java.util.ArrayList;
import java.util.stream.IntStream;

public class Task6 {
    public static void main(String[] args) {
        ArrayList<Integer> counts = new ArrayList<>();

        // Using count()
        long start = System.currentTimeMillis();
        long count = IntStream.rangeClosed(1, 100_000)
                .parallel()
                .map(Integer::reverseBytes)
                .filter(val -> val >= 0)
                .count();
        long end = System.currentTimeMillis();
        System.out.println("cnt== " + count + " in " + (end - start) + " ms");

        // Using forEach()
        for (int i = 0; i < 10; i++) {
            counts.clear();
            long startForEach = System.currentTimeMillis();
            IntStream.rangeClosed(1, 100_000)
                    .parallel()
                    .map(Integer::reverseBytes)
                    .filter(val -> val >= 0)
                    .forEach(val -> counts.add(1));
            long endForEach = System.currentTimeMillis();
            System.out.println("cnt== " + counts.size() + " in " + (endForEach - startForEach) + " ms.");
        }
    }
}
