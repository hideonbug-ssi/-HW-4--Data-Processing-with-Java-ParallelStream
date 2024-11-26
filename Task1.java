import java.util.stream.IntStream;

public class Task1 {
    public static void main(String[] args) {
        // 1.1 Number of processor cores
        int cores = Runtime.getRuntime().availableProcessors();
        System.out.println("Available processor cores: " + cores);

        // 1.2 Print thread name in sequential stream
        System.out.println("Sequential Stream:");
        int ssum = IntStream.rangeClosed(1, 10)
                .map(val -> {
                    System.out.println("Processed by thread: " + Thread.currentThread().getName());
                    return val;
                })
                .sum();
        System.out.println("Sequential Sum = " + ssum);

        // 1.3 Print thread name in parallel stream
        System.out.println("\nParallel Stream:");
        int psum = IntStream.rangeClosed(1, 10)
                .parallel()
                .map(val -> {
                    System.out.println("Processed by thread: " + Thread.currentThread().getName());
                    return val;
                })
                .sum();
        System.out.println("Parallel Sum = " + psum);
    }
}
