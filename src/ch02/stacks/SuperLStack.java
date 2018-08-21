package ch02.stacks;

import support.LLNode;

public class SuperLStack<T> extends LinkedStack<T> {

    // prints out contents of the stack
    public String toString() {
        if (isEmpty()) {
            String stackInfo = "";
            return stackInfo;
        } else {
            LLNode<T> currNode = top.getLink();
            String stackInfo = top.getInfo() + " ";
            while (currNode != null) {
                stackInfo += currNode.getInfo().toString() + " ";
                currNode = currNode.getLink();
            }
            return stackInfo;
        }
    }

    // shows the size of the stack
    public int size() {
        int count = 0;
        if(isEmpty())
            return count;
        else {
            LLNode<T> currNode = top.getLink();
            count++;
            while(currNode != null){
                currNode = currNode.getLink();
                count++;
            }
            return count;
        }
    }

    // pops count elements, if there are less than count elements throw exception
    public void popSome(int count) {
        if( count > size())
            throw new StackUnderflowException("Can't pop more elements than are in the stack");
        else {
            while(count > 0) {
                top = top.getLink();
                count--;
            }
        }

    }

    // swap top two elements
    public boolean swapStart() {
        if(size() < 2)
            return false;
        else {
            LLNode<T> topElement = top;
            LLNode<T> secondElement = topElement.getLink();

            // make the top element link to second elements link
            topElement.setLink(secondElement.getLink());
            // set second element to link to the top
            secondElement.setLink(top);
            // set the top to the second element
            top = secondElement;

            return true;
        }
    }

    // classic pop function, pops the stack and returns element
    public T popTop(){
        if(top != null) {
            T topElement = top.getInfo();
            top = top.getLink();
            return topElement;
        }
        else
            throw new StackUnderflowException("pop attempted on empty stack");
    }
}
