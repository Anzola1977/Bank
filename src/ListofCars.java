import java.util.ArrayList;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.concurrent.CopyOnWriteArrayList;

class List {

    public static void main(String[] args) {


            ArrayList<Integer> list = new ArrayList(Arrays.asList(4, 3, 52));

            for (int item : list) {
                --item;
                System.out.print(item + " ");
            }


        System.out.println(); // 4 3 52
        System.out.println("List size: " + list.size()); // 6
    }
}
