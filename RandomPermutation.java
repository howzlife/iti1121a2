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
        
    }

    public int[] toArray() {
        return this.arr;
    }
}
