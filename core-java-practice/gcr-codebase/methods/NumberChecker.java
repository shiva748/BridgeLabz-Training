import java.util.Arrays;

public class NumberChecker {
	
	public static int countDigit(int num) {
		return (int) Math.log10(num)+1;
	}
	
	public static int[] extractDigit(int num) {
		int digits[] = new int[countDigit(num)];
		int i = digits.length-1;
		while(num > 0) {
			digits[i--] = num%10;
			num /= 10;
		}
		return digits;
	}
	
	public static boolean isDuckNumber(int num) {
		int digits[] = extractDigit(num);
		for(int i = 0; i < digits.length; i++) {
			if(digits[i] != 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isArmstrong(int num) {
	    int count = countDigit(num);
	    int[] digits = extractDigit(num);
	    int sum = Arrays.stream(digits)
	                    .map(d -> (int) Math.pow(d, count))
	                    .sum();
	    return sum == num;
	}
	
	public static void largestSecondLargest(int num) {
		int digits[] = extractDigit(num);
		int largest = Integer.MIN_VALUE;
		int secondLargest = Integer.MIN_VALUE;
		for(int i = 0; i < digits.length; i++) {
			if(digits[i] > largest) {
				largest = digits[i];
			}else if(digits[i] > secondLargest && largest != digits[i]) {
				secondLargest = digits[i];
			}
		}
		System.out.printf("Largest digit is %d and second largest is %d", largest, secondLargest);	
	}
	
	public static void smallestSecondSmallest(int num) {
		int digits[] = extractDigit(num);
		int smallest = Integer.MAX_VALUE;
		int secondsmallest = Integer.MAX_VALUE;
		for(int i = 0; i < digits.length; i++) {
			if(digits[i] < smallest) {
				smallest = digits[i];
			}else if(digits[i] < secondsmallest && smallest != digits[i]) {
				secondsmallest = digits[i];
			}
		}
		System.out.printf("Smallest digit is %d and second smallest is %d", smallest, secondsmallest);	
	}
	
	public static int[] countAndExtractDigits(int num) {
		System.out.printf("There are %d digits in %d", countDigit(num), num);
		return extractDigit(num);
	}
	
	public static int digitSum(int num) {
		return Arrays.stream(extractDigit(num)).sum();
	}
	
	public static int digitSquareSum(int num) {
		return Arrays.stream(extractDigit(num)).map((a)->(int) Math.pow(a, 2)).sum();
	}
	
	public static boolean isHarshadNumber(int num) {
		return num%Arrays.stream(extractDigit(num)).sum() == 0;
	}
	
	public static int[][] digitFrequency(int num){
		int frequency[][] = new int[10][2];
		for(int i = 0; i < frequency.length; i++) {
			frequency[i][0] = i;
		}
		int digits[] = extractDigit(num);
		for(int i = 0; i < digits.length; i++) {
			frequency[digits[i]][1]++;
		}
		return frequency;
	}
	
	public static int[] reverseDigitArray(int digits[]) {
		int left = 0, right = digits.length-1;
		while(left < right) {
			digits[left] += digits[right];
			digits[right] = digits[left]-digits[right];
			digits[left] = digits[left]-digits[right];
		}
		return digits;
	}
	
	public static boolean compareArray(int array1[], int array2[]) {
		if(array1.length != array2.length) {
			return true;
		}
		for(int i = 0; i < array1.length; i++) {
			if(array1[i] != array2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPalindrome(int num) {
		int rev = 0;
		while(num >= rev) {
			rev = rev*10+num%10;
			num/=10;
		}
		if(num == rev || rev/10 == num) {
			return true;
		}else {
			return false;
		}
	}
	
	public static boolean isPrime(int num) {
		 if(num == 1){
	            return false;
	        }
	        if(num == 2 || num == 3){
	            return true;
	        }
	        if(num%2== 0 || num%3 == 0){
	            return false;
	        }
	        for(int i = 5;i*i <= num; i+=6){
	            if(num%i == 0 || num%(i+2) == 0){
	                return false;
	            }
	        }
	        return true;
	}
	
	public static boolean isNeon(int num) {
		return digitSum(num*num) == num;
	}
	
	public static boolean isSpy(int num) {
		return digitSum(num) == Arrays.stream(extractDigit(num)).reduce(1, (a, b)-> a = a*b);
	}
	
	public static boolean isAutomorphic(int num) {
        if(num == 0){
            return true;
        }
		return num == Math.pow(num, 2)%(Math.pow(10, (int) Math.log10(num)+1));
	}
	
	public static boolean isBuzzNumber(int num) {
		return num%7 == 0 || num%10 == 7;
	}
	
	public static boolean isPerfect(int num) {
		int sum = 0;
		for(int i = 1; i<num; i++) {
			if(num%i == 0) {
				sum += i;
			}
		}
		return sum == num;
	}
	public static boolean isAbundant(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			sum += num % i == 0 ? i : 0;
		}
		return sum > num;
	}
	public static boolean isDeficient(int num) {
		int sum = 0;
		for (int i = 1; i < num; i++) {
			sum += num % i == 0 ? i : 0;
		}
		return sum < num;
	}
	public static int factorial(int num) {
		if(num <= 0) {
			return 1;
		}
		return num*factorial(num-1);
	}
	public static boolean isStrong(int num) {
		return digitSum(factorial(num)) == num;
	}
}
