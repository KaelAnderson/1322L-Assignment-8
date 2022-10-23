package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String decimal2Binary(int inputNum){
        if (inputNum == 0)
            return Integer.toString(0);
        else
            return Integer.toString(inputNum % 2 + 10 * Integer.parseInt(decimal2Binary(inputNum / 2)));
    }
    public static String decimal2Hexadecimal(int inputNum){
        String result = "";
        int remainder = inputNum % 16;

        if (inputNum == 0) {
            return "";
        } else {
            switch (remainder) {
                case 10:
                    result = "A";
                    break;
                case 11:
                    result = "B";
                    break;
                case 12:
                    result = "C";
                    break;
                case 13:
                    result = "D";
                    break;
                case 14:
                    result = "E";
                    break;
                case 15:
                    result = "F";
                    break;
                default:
                    result = remainder + result;
                    break;
            }
            return decimal2Hexadecimal(inputNum / 16) + result;
    }}
    public static String convertIpAddress(String[] strings, int index){
        String temp = strings[index];
        int temp2 = Integer.parseInt(temp);
        if(index < 3){
            return decimal2Binary(temp2) + (".") + (convertIpAddress(strings, index + 1));
        }else return decimal2Binary(temp2);
    }
    public static String convertMacAddress(String[] strings, int index){
        if(index < 5){
            return decimal2Hexadecimal(Integer.parseInt(strings[index])) + ":" + (convertMacAddress(strings, index+1));
        }else return decimal2Hexadecimal(Integer.parseInt(strings[index]));
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        boolean cont = true;
	do{
        System.out.println("1 – Convert Decimal Number to Binary Number\n" +
                "2 – Convert Decimal Number to Hexadecimal Number\n" +
                "3 – Convert Decimal IP Address to Binary IP Address\n" +
                "4 – Convert Decimal MAC Address to Hexadecimal MAC Address\n" +
                "5 – Exit\n" +
                "Enter Choice:");
        int input = scan.nextInt();
        int dec = 0;
        switch (input){
            case 1:
                System.out.println("Enter Decimal Integer: ");
                dec = scan.nextInt();
                System.out.println("Decimal Number: " + dec);
                System.out.println("Binary Number: " + decimal2Binary(dec));
                System.out.println("");
                break;
            case 2:
                System.out.println("Enter Decimal Integer: ");
                dec = scan.nextInt();
                System.out.println("Decimal Number: " + dec);
                System.out.println("Binary Number: " + decimal2Hexadecimal(dec));
                System.out.println("");
                break;
            case 3:
                System.out.println("Enter Decimal IP Address (i.e. 192.168.35.10):");
                String[] decip = new String[4];
                for (int i = 0; i < 3; i++){
                    decip[i] = scan.next();
                    System.out.print(".");
                }
                decip[3] = scan.next();
                System.out.print("Decimal Number: ");
                for (int i = 0; i < 3; i++){
                    System.out.print(decip[i] + ".");
                }
                System.out.print(decip[3]);
                System.out.println("\nBinary Number: " + convertIpAddress(decip, 0));
                System.out.println("");
                break;
            case 4:
                System.out.println("Enter Decimal MAC Address (i.e. 203:65:157:93:13:7): ");
                String[] decmac = new String[6];
                for (int i = 0; i < 5; i++){
                    decmac[i] = scan.next();
                    System.out.print(":");
                }
                decmac[5] = scan.next();
                System.out.print("Decimal MAC Address: ");
                for (int i = 0; i < 5; i++){
                    System.out.print(decmac[i] + ":");
                }
                System.out.print(decmac[5]);
                System.out.println("\nHexadecimal MAC Address: " + convertMacAddress(decmac, 0));
                System.out.println("");
                break;
            case 5:
                cont = false;
                break;
            default:
                System.out.println("Error: Please Enter Valid Input");
                break;
        }
    }while(cont == true);




    }
}
