package com.company.mathematical_methods;

public class Series {
    public static int nSum(int upperNumber){
        int sum = 0;
        for(int i=0;i<=upperNumber;i++){
            sum += i;
        }
        System.out.println("After adding all number consecutively up to:"+ upperNumber +", we received " + sum);
        return sum;
    }

    public static int factorial(int upperNumber){
        if(upperNumber == 0){
            System.out.println("It's just 0 don't even bother...");
        }
        int factorial = 1;
        for (int i = 1; i<=upperNumber; i++){
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int fibonacciNumbers(int upperbound){
        int firstN=0;
        int secoundN = 1;
        int fibonacciNumber = 0;
        if(upperbound == 0 || upperbound ==1) {
            switch (upperbound) {
                case 0:
                    fibonacciNumber = 0;
                    break;
                case 1:
                    fibonacciNumber = 1;
                    break;
            }
        }else{
                for (int i = 1; i < upperbound; i++) {
                    fibonacciNumber = firstN + secoundN;
                    firstN = secoundN;
                    secoundN = fibonacciNumber;
                }
            }
            return fibonacciNumber;
        }
    }

