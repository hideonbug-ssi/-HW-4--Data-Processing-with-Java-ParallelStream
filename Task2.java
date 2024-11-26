import java.util.stream.IntStream;

public class Task2 {
    public static void main(String[] args) {
        IntStream.rangeClosed(888, 898)
                .sequential()
                .map(val -> {
                    System.out.println("Sequential - Processed by: " + Thread.currentThread().getName());
                    return Integer.reverseBytes(val);
                })
                .filter(val -> val < 0)
                .forEach(System.out::println);

        IntStream.rangeClosed(888, 898)
                .parallel()
                .map(val -> {
                    System.out.println("Parallel - Processed by: " + Thread.currentThread().getName());
                    return Integer.reverseBytes(val);
                })
                .filter(val -> val < 0)
                .forEach(System.out::println);
    }
}
