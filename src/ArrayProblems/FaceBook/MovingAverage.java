package ArrayProblems.FaceBook;

class MovingAverage {
    private int[] buffer;
    private int size;
    private int count;
    private int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        this.buffer = new int[size];
        this.size = size;
        this.count = 0;
        this.sum = 0;
    }

    public double next(int val) {
        // Update the circular buffer
        int index = count % size;
        sum = sum - buffer[index] + val;
        buffer[index] = val;

        // Increment count
        count++;

        // Calculate and return the moving average
        return (double) sum / Math.min(count, size);
    }
}
