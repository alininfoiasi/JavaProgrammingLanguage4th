package ch3;

final class SortMetrics implements Cloneable {

    public long probeCnt, // simple data probes
            compareCnt, // comparing two elements
            swapCnt; // swapping two elements

    public void init() {
        probeCnt = swapCnt = compareCnt = 0;
    }

    @Override
    public String toString() {
        return probeCnt + " probes "
                + compareCnt + " compares "
                + swapCnt + " swaps";
    }

    /**
     * This class supports clone
     */
    @Override
    public SortMetrics clone() {
        try {
            // default mechanism works
            return (SortMetrics) super.clone();
        } catch (CloneNotSupportedException e) {
            // can't happen: this and Object both clone
            throw new InternalError(e.toString());
        }
    }
}

abstract class SortDouble {

    private double[] values;
    private final SortMetrics curMetrics = new SortMetrics();

    /**
     * Invoked to do the full sort
     */
    public final SortMetrics sort(double[] data) {
        values = data;
        curMetrics.init();
        doSort();
        return getMetrics();
    }

    public final SortMetrics getMetrics() {
        return curMetrics.clone();
    }

    /**
     * For extended classes to know the number of elements
     */
    protected final int getDataLength() {
        return values.length;
    }

    /**
     * For extended classes to probe elements
     */
    protected final double probe(int i) {
        curMetrics.probeCnt++;
        return values[i];
    }

    /**
     * For extended classes to compare elements
     */
    protected final int compare(int i, int j) {
        curMetrics.compareCnt++;
        double d1 = values[i];
        double d2 = values[j];
        if (d1 == d2) {
            return 0;
        } else {
            return (d1 < d2 ? -1 : 1);
        }
    }

    /**
     * For extended classes to swap elements
     */
    protected final void swap(int i, int j) {
        curMetrics.swapCnt++;
        double tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    /**
     * Extended classes implement this -- used by sort
     */
    protected abstract void doSort();
}

class SimpleSortDouble extends SortDouble {

    @Override
    protected void doSort() {
        for (int i = 0; i < getDataLength(); i++) {
            for (int j = i + 1; j < getDataLength(); j++) {
                if (compare(i, j) > 0) {
                    swap(i, j);
                }
            }
        }
    }
}

public class TestSort {

    static double[] testData = {
        //0.3, 1.3e-2, 7.9, 3.17
        0.3, 0.1, 0.9, 0.8, 0.4
    };

    public static void main(String[] args) {
        SortDouble bsort = new SimpleSortDouble();
        SortMetrics metrics = bsort.sort(testData);
        System.out.println("Metrics: " + metrics);
        for (int i = 0; i < testData.length; i++) {
            System.out.println("\t" + testData[i]);
        }
    }
}
