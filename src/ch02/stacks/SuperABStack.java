/*
    SuperABStack.java      by Sam Miller

    Additional methods for ArrayBoundedStack class
 */

package ch02.stacks;

//import java.util.ArrayList;

public class SuperABStack<T> extends ArrayBoundedStack<T> {


    // prints contents of the stack
    public String toString() {
        String stackString = "";
        if (isEmpty())
            throw new StackUnderflowException("Tried to print an empty stack.");
        else {
                for(int i=0; i <= topIndex; i++){
                    String temp = elements[i].toString();
                    stackString += temp + " ";
                }
        }
        return stackString;
    }

    // shows the size of the stack
    public int size() {
        int stackSize = 0;
        if (isEmpty())
            return stackSize;
        else {
            //stackSize++; // if there is one el
            for( int i=0; i<= topIndex; i++){
                stackSize++;
            }
            return stackSize;
        }
    }

    // pops count elements, if there are less than count elements in stack throw exception
    public void popSome(int count){
        if (size() < count)
            throw new StackUnderflowException("Can't pop more elements than the stack has");
        else {
            while(count > 0){
                elements[topIndex] = null;
                topIndex--;
                count--;
            }
        }
    }

    // swap top two elements
    public boolean swapStart(){
        T temp;
        if (size() < 2)
            return false;
        else {
            temp = elements[topIndex];
            elements[topIndex] = elements[(topIndex - 1)];
            elements[(topIndex - 1)] = temp;
            return true;
        }
    }

    // classic pop function, pops and returns element
    public T popTop(){
        T topElement = elements[topIndex];
        elements[topIndex] = null;
        topIndex--;

        return topElement;
    }
}
