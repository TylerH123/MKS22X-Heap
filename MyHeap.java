import java.util.*;
public class MyHeap{

  //swap 2 values in an array
  private static void swap(int[] data, int idx1, int idx2){
    int old = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = old;
  }

  private static void pushDown(int[]data,int size,int index){
    //only run if has children and children is greater than index
    while (index * 2 + 1 < size){
      //check if has second child
      if (index * 2 + 2 < size){
        int c1 = index * 2 + 1;
        int c2 = index * 2 + 2;
        //compare the two children
        //if child 1 is bigger than child 2 and greater than the original
        if (data[c1] > data[index] && data[c1] > data[c2]){
            swap(data,index,index*2+1);
            //update index
            index = index * 2 + 1;
        }
        //if child 2 is bigger than child 1 and greater than the original
        else if (data[c2] > data[index] && data[c2] >= data[c1]){
          //swap with child 2
          swap(data,index,index*2+2);
          //update index
          index = index * 2 + 2;
        }
        //if parent is greater than both children return to break loop
        else if (data[index] >= data[c1] && data[index] >= data[c2]){
          return;
        }
      }
      //if only 1 child
      else if (data[index * 2 + 1] > data[index]){
        //swap child and index
        swap(data,index,index*2+1);
        //update index
        index = index * 2 + 1;
      }
      //if parent is greater than the child return to stop loop
      else if (data[index] >= data[index * 2 + 1]){
        return;
      }
    }
  }

  private static void pushUp(int[]data,int index){
    //loop if index is not the root and there is parent, root is included
    while (index > 0 && (index - 1) / 2 >= 0){
      int parent = (index - 1) / 2;
       //compare against the parent
      if (data[parent] < data[index]){
        swap(data,parent,index);
        index = parent;
      }
      //if parent is greater return to stop loop
      else if (data[parent] >= data[index]){
        return;
      }
    }
  }

  public static void heapify(int[] data){
    for (int i = data.length-1; i >= 0; i--){
      //push the value down
      pushDown(data,data.length,i);
    }
  }

  public static void heapsort(int[] data){
    //first heapify the array
    heapify(data);
    //partition is the part where the array is already sorted
    int partition = data.length - 1;
    //loop only up to the sorted part
    for (int i = partition; i >= 0; i--){
      //swap the max with the last num
      swap(data,0,i);
      //pushdown till the max is correct
      pushDown(data,partition,0);
      //increase the partition 
      partition--;
    }
  }

  public static void main(String[] args){
    int[] arr = new int[]{16,100,90,7,18,60,50,3,2,17};
    int[] arr2 = new int[]{70,18,60,9,6,50,40,5,4,3,2,90,6};
    int[] arr3 = new int[]{100,18,60,9,6,50,40,5,4,3,2,90,6};
    int[] arr4 = new int[]{16,100,90,7,18,60,50,3,2,14};
    int[] arr5 = new int[]{2,5,20,3,9,18,11,7,8,11,6};
    heapsort(arr);
    System.out.println(Arrays.toString(arr));
    //heapify(arr5);
    //pushUp(arr3,11);
    //pushUp(arr2,11);
    //pushDown(arr,10,0);
    //pushDown(arr4,10,0);
    //System.out.println(Arrays.toString(arr);
    //System.out.println(Arrays.toString(arr2));
    //System.out.println(Arrays.toString(arr3));
    //System.out.println(Arrays.toString(arr4));
    //System.out.println(Arrays.toString(arr5));
  }
}
