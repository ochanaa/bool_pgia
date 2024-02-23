import java.util.Scanner;

public class Boolpgia {
	public static Scanner in = new Scanner(System.in);
	public static void main(String[] args) {
		//����� ������ ���� ������ ������
		/*System.out.println("Enter a 4-digit number:");*/
		int secret = getSecretNum();
		int numGuesses = 0;
		while (numGuesses < 10) {
			System.out.println("Enter a 4-digit number:");
			int guess = in.nextInt();
			int pgia = getPgia(secret, guess);
			int bool = getBool(secret, guess);
			if (bool == 4){
				System.out.println("victory!!");
				break;}
			else{
				System.out.println("bool: " + bool);
				System.out.println("pgia: " + pgia);
			}
			numGuesses++;
			if (numGuesses == 10)
				System.out.println("You didn't win, try again.");

		} 

	}


	/**������ ������ ��� &quot;������&quot;
	�� ����� ������, ����
	����� �����.*/
	public static int getPgia(int secret, int guess){
		int pgia = 0;
		for (int index = 1; index < 5; index++)
			if (isDigitInNumber(secret, getDigit(guess, index)) == true)
				pgia++;
		return pgia;
	}


	/**������ ������ ��� &quot;�����&quot;
�� ����� ������, ����
����� �����.*/
	public static int getBool(int secret, int guess){
		int bool = 0;
		for (int index = 1; index < 5; index++)
			if (getDigit(secret, index) == getDigit(guess, index))
				bool++;

		return bool;
	}

	/**������ ������ ���� ����-

����� ���� ����� �����
�� �����, ������� ����.*/

	public static int getSecretNum(){

		int secret = 1000+(int)(Math.random()*9000);
		while(isDifferentDigits(secret) != true){
			secret = 1000+(int)(Math.random()*9000);
		}
		return secret;
	}


	/**������ ����� ��� �� �����
����� ����� �� ���. �� �� -
������ ���. ���� - ������
���.*/
	public static boolean isDifferentDigits(int number){
		int digit = number%10;
		int a = countDigitInNumber(number,digit);
		digit = number/10%10;
		int b = countDigitInNumber(number,digit);
		digit = number/100%10;
		int c = countDigitInNumber(number,digit);
		digit = number/1000;
		int d = countDigitInNumber(number,digit);
		if (a + b + c + d == 4)
			return true;
		else 
			return false;
	}






	/**   ������ ������ ��� �����
	������ ����� ���� �����.*/
	public static int countDigitInNumber(int number, int digit){
		int count = 0;
		if (digit == number%10)
			count++;
		if (digit == number/10%10)
			count++;
		if ( digit == number/100%10)
			count++;
		if (digit == number/1000)
			count++;
		return count;



	}



	/**   ������ ����� �� �����
	������ �����. �� �� -
	������ ���. ���� - ������
	���.*/
	public static boolean isDigitInNumber(int number, int digit){

		if (digit == number%10 || digit == number/10%10 || digit == number/100%10 || digit == number/1000)

			return true;

		else 
			return false;



	}


	/**
	 ����� �� ����� ���� ����-
����� ������� ����� ����
��� 1-4
������ ������ �� �����
���� �����, ������
������ ������� �������.
������ - �� ������� ��� 1
����� ����� ������ �����
(������) �� �����, ��
������� ��� 2 - ����� ����
������ �� �����, ��� ����
	 */
	public static int getDigit(int number, int index)
	{
		if (index ==1)
			return number%10;
		if (index ==2)
			return number/10%10;
		if (index ==3)
			return number/100%10;
		if (index ==4)
			return number/1000;

		return -1;



	}
}