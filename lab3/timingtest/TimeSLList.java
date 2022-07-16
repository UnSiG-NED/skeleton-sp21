package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

import java.util.List;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();
        int OP = 10000;

        int[] input = new int[]{1000, 2000, 4000, 8000, 16000, 32000, 64000, 128000};
        for (int N : input) {
            SLList<Integer> list = new SLList<>();
            for (int i = 1; i <= N; i++) {
                list.addLast(i);
            }

            Stopwatch timer = new Stopwatch();
            int opCount = 0;
            for (int i = 1; i <= OP; i++) {
                list.getLast();
                opCount++;
            }
            Double time  = timer.elapsedTime();
            times.addLast(time);
            Ns.addLast(N);
            opCounts.addLast(opCount);
        }

        printTimingTable(Ns, times, opCounts);
    }

}
