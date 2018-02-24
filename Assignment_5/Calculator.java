package Assignment_5;

import java.util.Scanner;
/*
 * Name: Zhihao Li
 * Date: 2/23/2018
 * Assignment_5
 */
public class Calculator extends Solution {

	public Calculator() {
	}

	public void calculate() {
		Scanner key = new Scanner(System.in);
		while (true) {
			System.out.println("Welcome! please enter the integer to select your choice");
			System.out.println("1.calculate sum of two number");
			System.out.println("2.calculate subtraction of two number");
			System.out.println("3.calculate multiplication of two number");
			System.out.println("4.calculate division of two number");
			System.out.println("5.calculate square root");
			System.out.println("6.calculate square");
			System.out.println("7.calculate cub");
			System.out.println("8.covert fahrenhet to celsius");
			System.out.println("9.covert celsius to fahrenhet");
			System.out.println("0. exit");
			int k = key.nextInt();

			if (k > 9 || k < 0) {
				System.err.println("Enter error. please try again");
				continue;
			}
			if (k == 0) {
				System.out.println("Thank you! :)");
				break;
			}
			System.out.println("please enter your first number");
			double n1 = key.nextDouble();
			if (k <= 4) {
				System.out.println("please enter your second number");
				double n2 = key.nextDouble();
				switch (k) {
				case 1:
					System.out.printf("%.3f + %.3f = %.3f %n", n1, n2, addition(n1, n2));
					break;
				case 2:
					System.out.printf("%.3f - %.3f = %.3f %n", n1, n2, subtraction(n1, n2));
					break;
				case 3:
					System.out.printf("%.3f * %.3f = %.3f %n", n1, n2, multiplication(n1, n2));
					break;
				case 4:
					if (n2 == 0) {
						System.err.println("denominator can not be zero");
						break;
					}
					System.out.printf("%.3f / %.3f = %.3f %n", n1, n2, division(n1, n2));
					break;
				}

			} else {
				switch (k) {
				case 5:
					if (n1 < 0) {
						System.err.println("square root can't take negative number");
						break;
					}
					System.out.printf("square root of %.3f  is %.3f %n", n1, squareRoot(n1));
					break;
				case 6:
					System.out.printf("%.3f ^2 = %.3f %n", n1, square(n1));
					break;
				case 7:
					System.out.printf("%.3f ^3 = %.3f %n", n1, cub(n1));
					break;
				case 8:
					System.out.printf("%.3f oF -> %.3f oC%n ", n1, fahrenhetToCelsius(n1));
					break;
				case 9:
					System.out.printf("%.3f oC -> %.3f oF%n ", n1, celsiusToFahrenhet(n1));
					break;
				}

			}
		}

	}

	public double addition(double n1, double n2) {
		return n1 + n2;

	}

	public double subtraction(double n1, double n2) {
		return n1 - n2;

	}

	public double multiplication(double n1, double n2) {
		return n1 * n2;

	}

	public double division(double numerator, double denominator) {
		if (denominator == 0) {
			throw new NullPointerException("denominator can not be zero");
		}
		return numerator / denominator;
	}

	public double squareRoot(double num) {
		return Math.sqrt(num);
	}

	public double square(double num) {
		return num * num;
	}

	public double cub(double num) {
		return num * num * num;
	}

	public double fahrenhetToCelsius(double degree) {
		return (degree - 32) * 5 / 9;
	}

	public double celsiusToFahrenhet(double degree) {
		return (degree * 1.8) + 32;
	}

	public double feetToInches(double feet) {
		return feet * 12;
	}

	public double inchesTofeet(double feet) {
		return feet / 12;
	}

}
