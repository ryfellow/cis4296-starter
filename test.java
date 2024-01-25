// Dongting Gao, Paul Sedra, Brian, Himanshi

import java.util.Scanner;

public class test {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int d=Integer.parseInt(scan.next());
        float r = 1.2F;
        int I = 7;
        int infected14 = I;
        int population = 39740;

        int tuition = 9972;
        for (int i=0; i<d; i++) {
            if ((int) (I + I*r)>population) { I=population; break; }
            I = (int) (I + I*r);
            if (i<=14) {
                infected14 = I;
            }
        }

        int lost = infected14*tuition;

        System.out.print("Infected: ");
        System.out.println(I);
        System.out.print("lost: $");
        System.out.println(lost);

    }

}


