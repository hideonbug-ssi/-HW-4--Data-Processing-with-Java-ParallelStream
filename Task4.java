import java.util.stream.IntStream;

public class Task4 {
    public static void main(String[] args) {
        int range_size = 1_000_000; // Fixed input size
        int runs = 5; // Number of runs
        System.out.println("\nTask 4.1: Fixed Input Size = " + range_size);

        // Sequential Stream
        long totalSequentialTime = 0;
        for (int i = 0; i < runs; i++) {
            long startSeq = System.currentTimeMillis();
            long countSeq = IntStream.rangeClosed(1, range_size)
                    .sequential()
                    .map(Integer::reverseBytes)
                    .filter(val -> val >= 0)
                    .count();
            long endSeq = System.currentTimeMillis();
            totalSequentialTime += (endSeq - startSeq);
            System.out.println("Sequential Run " + (i + 1) + ": Count = " + countSeq + ", Time = " + (endSeq - startSeq) + " ms");
        }
        System.out.println("Average Sequential Time = " + (totalSequentialTime / runs) + " ms");

        // Parallel Stream
        long totalParallelTime = 0;
        for (int i = 0; i < runs; i++) {
            long startPar = System.currentTimeMillis();
            long countPar = IntStream.rangeClosed(1, range_size)
                    .parallel()
                    .map(Integer::reverseBytes)
                    .filter(val -> val >= 0)
                    .count();
            long endPar = System.currentTimeMillis();
            totalParallelTime += (endPar - startPar);
            System.out.println("Parallel Run " + (i + 1) + ": Count = " + countPar + ", Time = " + (endPar - startPar) + " ms");
        }
        System.out.println("Average Parallel Time = " + (totalParallelTime / runs) + " ms");

        int[] sizes = {10_000, 100_000, 1_000_000, 10_000_000}; // Varying input sizes
        System.out.println("\nTask 4.2: Varying Input Sizes");

        for (int size : sizes) {
            System.out.println("\nInput Size: " + size);

            // Sequential Stream
            long startSeq = System.currentTimeMillis();
            long countSeq = IntStream.rangeClosed(1, size)
                    .sequential()
                    .map(Integer::reverseBytes)
                    .filter(val -> val >= 0)
                    .count();
            long endSeq = System.currentTimeMillis();
            System.out.println("Sequential Count = " + countSeq + ", Time = " + (endSeq - startSeq) + " ms");

            // Parallel Stream
            long startPar = System.currentTimeMillis();
            long countPar = IntStream.rangeClosed(1, size)
                    .parallel()
                    .map(Integer::reverseBytes)
                    .filter(val -> val >= 0)
                    .count();
            long endPar = System.currentTimeMillis();
            System.out.println("Parallel Count = " + countPar + ", Time = " + (endPar - startPar) + " ms");
        }
    }
}
