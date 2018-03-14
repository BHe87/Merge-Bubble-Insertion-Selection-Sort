import static org.junit.Assert.*;
import org.junit.Test;

public class ArrayTest {

  public static int[] createArray(int size) {
    int[] result = new int[size];
    for (int i = 0; i < result.length; i++) {
      result[i] = (int)(Math.random() * 1000);
    }
    return result;
  }
  
  public static boolean isSorted(int[] array) {
    for (int i = 1; i < array.length; i++) {
      if (array[i - 1] > array[i]) {
        return false;
      }
    }
    return true;
  }
  
  @Test
  public void testSort() {
    int[] array = createArray(10);
    //BubbleSorter sorter = new BubbleSorter();
    //InsertionSorter sorter = new InsertionSorter();
    //SelectionSorter sorter = new SelectionSorter();
    MergeSorter sorter = new MergeSorter();
    sorter.init(array);
    sorter.sort();
    System.out.println("\nMoves: " + sorter.getMoves());
    assertTrue(isSorted(array));
  }
}