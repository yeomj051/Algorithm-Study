package SWEA_Problem.Solution_1208;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String args[]) throws Exception{
		System.setIn(new FileInputStream("res/input(1208).txt"));
		BufferedReader in = new BufferedReader(new InputStreamReader((System.in)));

		int T;
		T=10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int DumpCount = Integer.parseInt(in.readLine());
			StringTokenizer DumpBox = new StringTokenizer(in.readLine());
			int[] DumpBoxArr = new int[100];
			for (int i = 0; i < 100; i++) {
				DumpBoxArr[i] = Integer.parseInt(DumpBox.nextToken());
			}

			System.out.println("#"+test_case+" "+flattenBox(DumpBoxArr,DumpCount));

		}


	}

	private static int flattenBox(final int[] boxes, final int dumpCount) {
		Arrays.sort(boxes);
		int index = 0;

		while (boxes[boxes.length - 1] - boxes[0] > 1 && index < dumpCount) {
			boxes[0]++;
			boxes[boxes.length - 1]--;

			Arrays.sort(boxes);
			index++;
		}

		return boxes[boxes.length - 1] - boxes[0];
	}


}
