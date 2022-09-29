package JOL_Problem.JOL_1828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int chemicalCount = Integer.parseInt(bufferedReader.readLine());

        Chemical[] chemicals = new Chemical[chemicalCount];

        for (int i = 0; i < chemicalCount; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int low = Integer.parseInt(stringTokenizer.nextToken());
            int high = Integer.parseInt(stringTokenizer.nextToken());
            chemicals[i] = new Chemical(low, high);
        }

        System.out.println(getRefrigerator(chemicals));

    }

    static class Chemical implements Comparable<Chemical>{
        int low, high;

        public Chemical(int low, int high) {
            this.low = low;
            this.high = high;
        }

        @Override
        public int compareTo(Chemical o) {
            return this.high != o.high ? this.high - o.high : this.low-o.low;
        }
    }

    private static int getRefrigerator(Chemical[] chemicals){
        int count = 1;

        Arrays.sort(chemicals);
        int high = chemicals[0].high;

        for (int i = 1; i < chemicals.length; i++) {
            if (high < chemicals[i].low){
                high = chemicals[i].high;
                count++;
            }
        }

        return count;
    }
}
