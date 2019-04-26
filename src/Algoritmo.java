import java.math.BigInteger;
import java.time.format.TextStyle;
import java.util.Locale;
import java.util.Scanner;

public class Algoritmo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		sc.useLocale(Locale.ENGLISH);
		Locale.setDefault(new Locale("en", "US"));

		System.out.print("Digite um número para saber se ele é primo: ");
		Long n = sc.nextLong(), eneMenosUm, potenciaK = (long) 0, q = (long) 0, a;
		String eneMenosUm_Binario;

		if (n % 2 == 0 || n == 0 || n == 1) {
			System.out.printf("%d NÃO É um número PRIMO.\n");
		} else {
			// (n – 1 = 2k * q) => Encontrar o k e o q

			eneMenosUm = n - 1;
			eneMenosUm_Binario = Long.toBinaryString(eneMenosUm);

			while ((eneMenosUm & 1) != 1) {

				if (eneMenosUm_Binario.charAt(eneMenosUm_Binario.length() - 1) == '0') {
					eneMenosUm_Binario = eneMenosUm_Binario.substring(0, eneMenosUm_Binario.length() - 1);
					eneMenosUm = Long.parseLong(eneMenosUm_Binario, 2);
					potenciaK++;
				}
				q = Long.parseLong(eneMenosUm_Binario, 2);
			}

			System.out.println("k= " + potenciaK + ", q= " + q);

			for (Long i = (long) 2; i < n - 1; i++) {
				testeIC(n, i, potenciaK, q);
			}

			// for (int i = 2; i < n - 1; i++) {
			// a = i;
			// System.out.println(i);
			// System.out.println("============>" + Math.pow(a, q) % n);
			//
			// if (Math.pow(a, q) % n == 1 || Math.pow(a, q) % n == n - 1) {
			// System.out.printf("INCONCLUSIVE mod==1\n");
			// }
			//
			// for (int j = 0; j < potenciaK - 1; j++) {
			// double potencia = Math.pow(2, j) * q;
			//
			// if (Math.pow(a, potencia) % n == (n - 1)) {
			// System.out.printf("INCONCLUSIVE\n", n);
			// } else {
			// System.out.printf("COMPOSITE\n", n);
			// }
			// }
			// }

			/*
			 * System.out.print("Digite o s: "); int s = sc.nextInt();
			 * 
			 * for(int i = 1; i < s; i++) { System.out.printf("Rodada %d .Digite o a: ", i);
			 * a = sc.nextInt();
			 * 
			 * double z = Math.pow(a, q) % n;
			 * 
			 * if(z != 1 && z != -1) { for(int j = 1; j < potenciaK - 1; j++) { z =
			 * Math.pow(z, 2) % n;
			 * 
			 * if(z == 1) { System.out.println("n is composite"); } } } }
			 */
		}
	}

	public static boolean testeIC( Long n, Long cont, Long k, Long q) {
		Long a = cont;
		System.out.println(cont);
		System.out.println("============>" + Math.pow(a, q) % n);

		if (Math.pow(a, q) % n == 1 || Math.pow(a, q) % n == n - 1) {
			System.out.printf("INCONCLUSIVE\n");
			return false;
		}

		for (int j = 0; j < k - 1; j++) {
			double potencia = Math.pow(2, j) * q;

			if (Math.pow(a, potencia) % n == (n - 1)) {
				System.out.printf("INCONCLUSIVE\n", n);
				return false;
			}
			System.out.printf("COMPOSITE\n", n);
			return true;
		}
		return false;
	}
}
