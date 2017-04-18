package com.Watson.Multimodules;

import java.util.Scanner;

/**
 * Created by Long on 3/17/2017.
 */
public class runSubtraction {

    public static void main(String[] args) {
        Subtraction subObject = new Subtraction();
        Scanner input = new Scanner(System.in);

        System.out.print("Please enter the first amount: ");
        int firstInteger = input.nextInt();
        subObject.setInt1(firstInteger);
        System.out.print("Please enter the amount to subtract: ");
        int secondInteger = input.nextInt();
        subObject.setInt2(secondInteger);
        if(subObject.getInt1() >= subObject.getInt2() ) {
            System.out.println("Answer is: " + subObject.subtract());
        }
        else
        {
            System.out.println("Error: Numbers are invalid");
            System.exit(-1);
        }
    }
}
