package com.giantank.ds.heap;

public class MaxHeap<Item extends Comparable> {
    private Item[] data;
    private int count;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        data = (Item[]) new Comparable[capacity + 1];
        count = 0;
    }

    public MaxHeap(Item[] arr) {
        int n = arr.length;
        data = (Item[])new Comparable[n + 1];
        capacity = n;

        for(int i = 0; i < n; i ++) {
            data[i + 1] = arr[i];
        }

        count = n;

        for (int i = count / 2; i >= 1; i --)
            shiftDown(i);
    }

    //返回堆中的元素个数
    public int size() {
        return count;
    }

    // 返回一个布尔值，表示堆中是否为空
    public boolean isEmpty() {
        return count == 0;
    }

    // 插入一个元素
   public void insert(Item item) {
        if (count + 1 > capacity) {
            throw new IllegalArgumentException("heap is full");
        }
        data[count + 1] = item;
        count ++;
        shiftUp(count);
   }

   //从最大堆中取出堆顶元素， 即堆中所存储的最大数据
    public Item extractMax() {
        if (count <= 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        Item result = data[1];
        swap(1, count);
        count --;
        shiftDown(1);
        return result;
    }

    // 获取最大堆中的堆顶元素
    public Item getMax() {
        if (count <= 0) {
            throw new IllegalArgumentException("heap is empty");
        }
        return data[1];
    }
   // 最大堆核心辅助函数
   private void shiftUp(int k) {
        while(k > 1 && data[k/2].compareTo(data[k]) < 0) {
            swap(k, k/2);
            k /= 2;
        }
   }
   private void shiftDown(int k) {
        while (2*k <= count) {
            int j = 2 * k; //在此轮循环中， data[k] 和 data[j]交换位置
            if (j + 1 <= count && data[j+1].compareTo(data[j]) > 0) {
                j ++;
                // data[j]是data[2*k]和data[2*k+1]中的最大值
            }
            if (data[k].compareTo(data[j]) >= 0)
                break;
            swap(k, j);
            k = j;
        }
   }

   // 交换两个元素
   private void swap(int i , int j) {
        Item t = data[i];
        data[i] = data[j];
        data[j] = t;
   }

   // 以树状打印整个堆结构
   public void treePrint() {
        if (size() >= 100) {
            System.out.println("the print function can only work for less than 100 Integer");
            return;
        }
        System.out.println("The max heap size is: " + size());
        System.out.println("Data in the max heap: ");
        for (int i = 1; i <= size(); i ++) {
            assert (Integer)data[i] >= 0 && (Integer)data[i] < 100;
            System.out.println(data[i] + " ");
        }
        System.out.println();
        int n = size();
        int maxLevel = 0;
        int numbePerLevel = 1;
        while ( n > 0) {
            maxLevel += 1;
            n -= numbePerLevel;
            numbePerLevel *= 2;
        }

        System.out.println("maxLevel:" + maxLevel);
        System.out.println("numberPerLevel:"+numbePerLevel);

        int maxLevelNumber = (int)Math.pow(2, maxLevel - 1);
        int curTreeMaxLevelNumber = maxLevelNumber;
        int index = 1;
        for (int level = 0; level <maxLevel; level++) {
            String line1 = new String(new char[maxLevelNumber*3-1]).replace('\0', ' ');

            int curLevelNumber = Math.min(count-(int)Math.pow(2,level)+1,(int)Math.pow(2,level));
            boolean isLeft = true;
            for( int indexCurLevel = 0 ; indexCurLevel < curLevelNumber ; index ++ , indexCurLevel ++ ){
                line1 = putNumberInLine( (Integer)data[index] , line1 , indexCurLevel , curTreeMaxLevelNumber*3-1 , isLeft );
                isLeft = !isLeft;
            }
            System.out.println(line1);

            if( level == maxLevel - 1 )
                break;

            String line2 = new String(new char[maxLevelNumber*3-1]).replace('\0', ' ');
            for( int indexCurLevel = 0 ; indexCurLevel < curLevelNumber ; indexCurLevel ++ )
                line2 = putBranchInLine( line2 , indexCurLevel , curTreeMaxLevelNumber*3-1 );
            System.out.println(line2);

            curTreeMaxLevelNumber /= 2;
        }
   }

    private String putNumberInLine( Integer num, String line, int indexCurLevel, int curTreeWidth, boolean isLeft){

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int offset = indexCurLevel * (curTreeWidth+1) + subTreeWidth;
        assert offset + 1 < line.length();
        if( num >= 10 )
            line = line.substring(0, offset+0) + num.toString()
                    + line.substring(offset+2);
        else{
            if( isLeft)
                line = line.substring(0, offset+0) + num.toString()
                        + line.substring(offset+1);
            else
                line = line.substring(0, offset+1) + num.toString()
                        + line.substring(offset+2);
        }
        return line;
    }

    private String putBranchInLine( String line, int indexCurLevel, int curTreeWidth){

        int subTreeWidth = (curTreeWidth - 1) / 2;
        int subSubTreeWidth = (subTreeWidth - 1) / 2;
        int offsetLeft = indexCurLevel * (curTreeWidth+1) + subSubTreeWidth;
        assert offsetLeft + 1 < line.length();
        int offsetRight = indexCurLevel * (curTreeWidth+1) + subTreeWidth + 1 + subSubTreeWidth;
        assert offsetRight < line.length();

        line = line.substring(0, offsetLeft+1) + "/" + line.substring(offsetLeft+2);
        line = line.substring(0, offsetRight) + "\\" + line.substring(offsetRight+1);

        return line;
    }

   public static void main(String[] args) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(100);
        int N = 63;
        int M = 100;
        for (int i = 0; i < N; i ++) {
            maxHeap.insert(new Integer((int)(Math.random()*M)));
        }
        System.out.println(maxHeap.size());
        maxHeap.treePrint();

        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i ++) {
            arr[i] = maxHeap.extractMax();
            System.out.print(arr[i] + " ");
        }
       System.out.println();

        //确保arr数组是从大到小排列的
       for (int i = 1; i < N; i ++) {
           assert arr[i -1] >= arr[i];
       }

       Integer[] brr = {1,3,13,24,28,23,13,24,55};
       MaxHeap<Integer> bHeap = new MaxHeap<>(brr);
       bHeap.treePrint();
       System.out.println();
       for (int i = 0; i < brr.length; i ++) {
           System.out.print(bHeap.extractMax() + " ");
       }
   }
}
