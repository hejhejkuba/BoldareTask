import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.round;

public class Main {
    private float[][] denomination;
    public void setDenomination(float[][] nominaly) {
        this.denomination = nominaly;
    }

    // not needed but required to add
    public float[][] getNominaly() {
        return denomination;
    }
    // for looking into array changes during loops
    public void printDenomination()
    {
        System.out.println(Arrays.deepToString(denomination));
    }

    // specific position GET if needed ;3
    public float getDenomination(int i, int j) {
        return denomination[i][j];
    }
    public void giveNominal(float reszta)
    {

        String wynik = "Remnant for " + reszta + ":\n";
        for (int i = 0; ((i < denomination.length) && (reszta > 0.00)); i++) {
            if(getDenomination(denomination.length-1, 1) == 0)
            {
                wynik = "No cash sory ";
                break;
            }
            if (reszta >= denomination[i][0]&&denomination[i][1] > 0.0) {

                int liczbaMonet = (int)Math.min(denomination[i][1], (reszta / denomination[i][0]));
                wynik += denomination[i][0] + " PLN x " + liczbaMonet + "\n";
                reszta = (float) round(100*(reszta-(liczbaMonet*denomination[i][0])))/100;
                //System.out.println("error : " + nominaly[i][1]);
                denomination[i][1] = denomination[i][1] - liczbaMonet;
            }
        }
        System.out.println(wynik);
    }

    public static void main(String[] args) {
        float [][] startDenomination = {
            {5.0f, 1},
            {2.0f, 3},
            {1.0f, 5},
            {0.5f, 10},
            {0.2f, 20},
            {0.1f, 200},
            {0.05f, 100},
            {0.02f, 100},
            {0.01f, 10000}
        };
        Main main = new Main();
        main.setDenomination(startDenomination);

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Input : (Example '1,30')");
            try {
                main.giveNominal(scanner.nextFloat());
            }
            catch (Exception e)
            {
                System.out.println("bad input ;) ");
                //cleaning buffor
                scanner.nextLine();
                main.giveNominal(scanner.nextFloat());
            }

        }
//        main.giveNominal(1.30f);
//
//        main.giveNominal(11.70f);
//
//        main.giveNominal(6.70f);
//
//        main.giveNominal(4.30f);

    }
}