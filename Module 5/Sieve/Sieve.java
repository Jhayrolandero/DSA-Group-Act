public class Sieve {
    public static void sieve_eratosthenes() {

        boolean[] isPrime = new boolean[100];
        int[] numArr = new int[100];

        int len = 100;

        // Initialize Num Array
        for (int i = 0; i < len; i++) {
            numArr[i] = i + 1;
        }

        // Initializa Bool Array
        for (int i = 0; i < len; i++) {
            isPrime[i] = true;
        }

        // Cross out what is not prime
        for (int i = 1; i * i < len; i++) {
            if (isPrime[i]) {
                int num = numArr[i];
                for (int j = num * num; j <= len; j += num) {
                    isPrime[j - 1] = false;
                }
            }
        }

        // Print out the result
        for (int i = 1; i < len; i++) {
            if (isPrime[i]) {
                System.out.println(numArr[i]);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("List of Prime Numbers");
        sieve_eratosthenes();
    }

}