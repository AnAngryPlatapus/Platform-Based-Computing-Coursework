//----------------------------------------------------------------------------
// StackInterface.java           by Dale/Joyce/Weems                 Chapter 3
//
// Interface for a class that implements a stack of <T>.
// A stack is a last-in, first-out structure.
//----------------------------------------------------------------------------

package ch02.stacks;

public interface StackInterface<T>

{
    void push(T element) throws StackOverflowException;
    // Throws StackOverflowException if this stack is full,
    // otherwise places element at the top of this stack.

    void pop() throws StackUnderflowException;
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.

    T top() throws StackUnderflowException;
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element from this stack.

    boolean isEmpty();
    // Returns true if this stack is empty, otherwise returns false.

    boolean isFull();
    // Returns true if this stack is full, otherwise returns false.

    String toString();
    // Returns string of stack

    int size();
    // Returns number of elements in stack

    void popSome(int count);
    // pops count items in stack, if stack has less than count items then it throws StackUnderflowException

    boolean swapStart();
    // if there are less than two elements return false, else reverse the order of the top two elements and return true

    T popTop();
    // classic pop, returns tops element and pops stack
}
