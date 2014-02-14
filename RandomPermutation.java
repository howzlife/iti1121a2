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
        // If we go all the way to the end, the permutation is unsolvable
        for (int k = arr.length - 2;k>1; k--) {
            int i = generator.nextInt(k);
            int itemid = this.arr[i];
            this.arr[i] = this.arr[k];
            this.arr[k] = itemid;
        }

    }

    //takes 2D array and transforms to 1D array
    public int[] toArray() {
        return this.arr;
    }

    //Takes 2D array and returns a string version of the array.
    public String toString() {
        String result;

        result = "";
        for (int i=0;i<9;i++) {
            result += "["+this.arr[i]+"]";
            if (i%3 == 0)
                result += "\n";
            else
                result += " ";
        }
        return result;
    }
}
