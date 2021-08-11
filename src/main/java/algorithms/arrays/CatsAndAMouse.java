package algorithms.arrays;

import java.util.Scanner;

/**
 * Create by davidmateo
 * Date: 2021-08-08
 * Time: 11:26 PM
 * Algorithm URL: https://www.hackerrank.com/challenges/cats-and-a-mouse
 */

public class CatsAndAMouse {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){

            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();

            int distanceFromCatAToMouse = Math.abs(x - z);
            int distanceFromCatBToMouse = Math.abs(y - z);

            if(distanceFromCatAToMouse == distanceFromCatBToMouse) {
                System.out.println("Mouse C");
            } else if(distanceFromCatAToMouse < distanceFromCatBToMouse) {
                System.out.println("Cat A");
            } else {
                System.out.println("Cat B");
            }
        }
    }
}
