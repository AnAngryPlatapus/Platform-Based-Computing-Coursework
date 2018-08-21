/*
    StackMenuABDriver.java      by Sam Miller

    Sample use of the Array bounded stack, displays a menu for different stack options.
    Menu for flexible testing of stack and it's methods
 */

package ch02.apps;

import ch02.stacks.StackInterface;
import ch02.stacks.SuperLStack;

import java.util.Scanner;


public class StackMenuLLDriver {

    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);

        boolean isRunning = true;

        System.out.println("Menu Options: ");
        System.out.println("1. Push Element to Stack");
        System.out.println("2. Pop Element from Stack");
        System.out.println("3. Show top element from Stack");
        System.out.println("4. Find out if stack is empty");
        System.out.println("5. Find out if stack is full");
        System.out.println("6. Print out contents of Stack");
        System.out.println("7. Find out how many elements are in the Stack");
        System.out.println("8. Pop a specified amount of elements from the Stack");
        System.out.println("9. Swap the top two elements of the stack");
        System.out.println("10. Removes and returns the top element");
        System.out.println("11. Reprint the Menu");
        System.out.println("12. Quit Program");


        StackInterface<String> myStack;
        myStack = new SuperLStack<>();

        String element;
        int numInput;

        do {
            String option;
            System.out.print("Choose a menu option > ");
            option = scan.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter an element: ");
                    element = scan.nextLine();
                    myStack.push(element);
                    break;
                case "2":
                    System.out.println("Pop element from stack > ");
                    myStack.pop();
                    break;
                case "3":
                    element = myStack.top();
                    System.out.println(element);
                    break;
                case "4":
                    if (myStack.isEmpty()) {
                        System.out.println("Stack is empty");
                    } else {
                        System.out.println("Stack is has elements");
                    }
                    break;
                case "5":
                    if (myStack.isFull()) {
                        System.out.println("Stack is full");
                    } else {
                        System.out.println("Stack is not full");
                    }
                    break;
                case "6":
                    String stackString = myStack.toString();
                    System.out.println(stackString);
                    break;
                case "7":
                    int sizeVar = myStack.size();
                    System.out.println("The stack size is: " + sizeVar);
                    break;
                case "8":
                    System.out.print("How many elements would you like to pop? ");
                    String numInputToBeParsed;
                    numInputToBeParsed = scan.nextLine();
                    int numPopped = Integer.parseInt(numInputToBeParsed);
                    myStack.popSome(numPopped);
                    break;
                case "9":
                    if(myStack.swapStart()) {
                        System.out.println("Top two elements of stack are swapped");
                    } else {
                        System.out.println("Can't swap the start of a stack with less than two elements");
                    }
                    break;
                case "10":
                    element = myStack.popTop();
                    System.out.println(element + " was popped");
                    break;
                case "11":
                    System.out.println("1. Push Element to Stack");
                    System.out.println("2. Pop Element from Stack");
                    System.out.println("3. Show top element from Stack");
                    System.out.println("4. Find out if stack is empty");
                    System.out.println("5. Find out if stack is full");
                    System.out.println("6. Print out contents of Stack");
                    System.out.println("7. Find out how many elements are in the Stack");
                    System.out.println("8. Pop a specified amount of elements from the Stack");
                    System.out.println("9. Swap the top two elements of the stack");
                    System.out.println("10. Removes and returns the top element");
                    System.out.println("11. Reprint the Menu");
                    System.out.println("12. Exit Program");
                    break;
                case "12":
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;


            }
        } while(isRunning);
        System.out.println("Thanks for using Sam's awesome stack");

    }
}

