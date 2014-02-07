import java.util.Random;

class RandomPermutation {
    private int[] arr;

    /* Constructor */

    public RandomPermutation(int rows, int cols) {
        int size;
        size = rows*cols;
        this.arr = new int[size];
        for (int i=0;i<size;i++) {
            if (i+1 < size)
                this.arr[i] = i+1;
            else
                this.arr[i] = 0;
        }
    }

    /* Public Methods */

    public void shuffle() {
        Random generator = new Random();
        // Starts at the end of the array (minus 1 so the space is always at the
        // end), randomly selecting an earlier index in the array and switching
        // the values at the current point and the randomly selected point
        for (int k = arr.length - 2;k>0; k--) {
            int i = generator.nextInt(k);
            int itemid = this.arr[i];
            this.arr[i] = this.arr[k];
            this.arr[k] = itemid;
        }

    }

    public int[] toArray() {
        return this.arr;
    }
}
