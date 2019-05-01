import java.util.*;
public class MyHeap{

  //swap 2 values in an array
  private static void swap(int[] data, int idx1, int idx2){
    int old = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = old;
  }

  private static void pushDown(int[]data,int size,int index){
    //only run if has children
    while (index * 2 + 1 < size){
      //check if has second child
      if (index * 2 + 2 < size){
        int og = data[index];
        int c1 = data[index * 2 + 1];
        int c2 = data[index * 2 + 2];
        //compare the two children
        //if child 1 is bigger than child 2 and greater than the original
        if (c1 > og && c1 > c2){
            swap(data,index,index*2+1);
            //update index
            index = index * 2 + 1;
        }
        //if child 2 is bigger than child 1 and greater than the original
        else if (c2 > og && c2 >= c1){
          //swap with child 2
          swap(data,index,index*2+2);
          //update index
          index = index * 2 + 2;
        }
      }
      //if only 1 child
      else if (data[index * 2 + 1] > data[index]){
        //swap child and index
        swap(data,index,index*2+1);
        //update index
        index = index * 2 + 1;
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
    }
  }

  public static void main(String[] args){
    int[] arr = new int[]{16,100,90,7,18,60,50,3,2,17};

    //pushDown(arr,10,0);
    //System.out.println(Arrays.toString(arr));
  }
}
