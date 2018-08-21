//--------------------------------------------------------------------------
// BSTTestDriver.java          by Sam Miller
//
// Inorder/Postorder/Preorder code written by professor, the rest is of
// original design
//--------------------------------------------------------------------------
package ch07.apps;

import ch07.trees.*;
import java.util.Iterator;
import java.util.Scanner;

public class BSTTestDriver
{
    public static void main(String[] args)
    {

        BinarySearchTree<Character> myBST = new BinarySearchTree<Character>();
        Iterator<Character> iter;

        System.out.println("The BST is sorted in alphabetical order");


        Scanner scan = new Scanner(System.in);
        char node;
        boolean isRunning = true;

        do {
            String option;
            System.out.println("Menu Options: ");
            System.out.println("1. Add a node (char) to the tree");
            System.out.println("2. Print the number of leaves on the tree");
            System.out.println("3. Print the number of nodes with one child");
            System.out.println("4. Show the In-order Traversal");
            System.out.println("5. Show the Pre-Order Traversal");
            System.out.println("6. Show the Post-order Traversal");
            System.out.println("7. Exit the program");

            System.out.println("Choose a menue option> ");
            option = scan.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter a character: ");
                    String charToBeParsed;
                    charToBeParsed = scan.nextLine();
                    char newNode = charToBeParsed.charAt(0);
                    myBST.add(newNode);
                    break;
                case "2":
                    int leaves = myBST.numLeaves();
                    System.out.println("The number of leaves are: " + leaves);
                    break;
                case "3":
                    int singleMoms = myBST.numSingPars();
                    System.out.println("The number of nodes with one child are: " + singleMoms);
                    break;
                case "4":
                    System.out.print("Inorder:   ");
                    iter = myBST.getIterator(BSTInterface.Traversal.Inorder);
                    while (iter.hasNext())
                        System.out.print(iter.next());
                        System.out.println();
                    break;
                case "5":
                    System.out.print("\nPreorder:  ");
                    iter = myBST.getIterator(BSTInterface.Traversal.Preorder);
                    while (iter.hasNext())
                        System.out.print(iter.next());
                    break;
                case "6":
                    System.out.print("\nPostorder: ");
                    iter = myBST.getIterator(BSTInterface.Traversal.Postorder);
                    while (iter.hasNext())
                        System.out.print(iter.next());
                    break;
                case "7":
                    isRunning= false;
                    break;
                default:
                    System.out.println("Invalid Option");
                    break;
            }


       }while(isRunning);



    }

}