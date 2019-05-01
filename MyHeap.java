public class MyHeap{

  //swap 2 values in an array
  private static void swap(int[] data, int idx1, int idx2){
    int old = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = old;
  }

  private static void pushDown(int[]data,int size,int index){
    //only run if has children
    while (index * 2 + 1 < size - 1){
      //check if has second child
      if (index * 2 + 2 < size - 1){
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

}
