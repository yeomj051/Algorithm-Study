package BOJ_Problem.BOJ_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int N = 0;

	public static void main(String[] args) throws IOException {

		input();
		Long result = logic();

		System.out.println(result);
	}

	private static Long logic() {
		Long[] array = new Long[N+2];
		array[1] = 1L;
		array[2] = 2L;

		for (int i = 2; i <= N; i++) {
			array[i+1] = ((array[i]% 10007) + (array[i-1% 10007]))% 10007;
		}

		return array[N];
	}

	private static void input() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bufferedReader.readLine());
	}

}
