import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Massives {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        TreeSet<Integer> arr = new TreeSet<>();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите длину первого массива");
        int leng1 = scan.nextInt();
        System.out.println("Введите длину второго массива");
        int leng2 =  scan.nextInt();
        System.out.println("Введите "+ leng1 + " чисел для первого массива");
        for (int i = 0; i < leng1; i++) arr1.add(scan.nextInt());

        System.out.println("Введите "+ leng2 + " чисел для второго массива");
        for (int i = 0; i < leng2; i++) arr2.add(scan.nextInt());

        for(int k : arr1)
        {
            if(arr2.contains(k)) arr.add(k);
        }

        for(int k : arr)
        {
            System.out.println(arr);
        }
    }
}
