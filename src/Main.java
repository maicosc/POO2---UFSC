import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {


    public static void crivoErastostenes (){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o limite(ex: 1000): ");
        int limite = scan.nextInt();

        ArrayList<Boolean> numbers = new ArrayList<Boolean>();
        for(int i=0; i <= limite; i++){
            numbers.add(true);
        }
        numbers.set(0, false);
        numbers.set(1, false);
        int root = (int) Math.sqrt((double) limite);
        for (int m = 2; m <= root; m++){
            if(numbers.get(m)){
                for (int n = m*m; n <= limite; n += m){
                    numbers.set(n, false);
                }
            }
        }
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int p = 2; p <= limite; p++){
            if(numbers.get(p)){
                output.add(p);
            }
        }
        System.out.println(output);
    }
    public static void main(String[] args) {

        crivoErastostenes();

    }
}