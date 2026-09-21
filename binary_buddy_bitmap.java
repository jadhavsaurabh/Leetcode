void main() {
    BinaryBuddyBitMap b = new BinaryBuddyBitMap();

    b.print();
    b.set_bit(4, 1);
    b.print();
    b.clear_bit(10, 1);
    b.print();
}

/*
[0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]
[0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
[0, 0, 1, 1, 0, 1, 1, 1, 1, 1, 0, 1]

Process finished with exit code 0
*/
class BinaryBuddyBitMap {
    int[] tree;

    BinaryBuddyBitMap() {
        tree = new int[]{0,0,1,1,0,1,1,1,1,1,0,1};
    }

    BinaryBuddyBitMap(int[] initialTree) {
        tree = initialTree;
    }

    public void print() {
        System.out.println(Arrays.toString(tree));
    }

    private int getParent(int i) {
        if (i == 0) return -1;
        return (i - 1) / 2;
    }

    private int leftChild(int i) {
        return i * 2 + 1;
    }

    private int rightChild(int i) {
        return i * 2 + 2;
    }

    private void set(int i) {
        if (i >= tree.length) return;
        if (tree[i] == 1) return;

        tree[i] = 1;

        set(leftChild(i));
        set(rightChild(i));
    }

    public void set_bit(int offset, int length) {
        for (int i = offset;
             i < tree.length && i < offset + length;
             i++) {
            set(i);
        }
    }

    private void clear(int i) {
        if (i < 0 || tree[i] == 0) return;

        tree[i] = 0;
        clear(getParent(i));
    }

    public void clear_bit(int offset, int length) {
        for (int i = offset;
             i < tree.length && i < offset + length;
             i++) {
            clear(i);
        }
    }
}
