//----------------------------------------------------------------------
// LinkedStack.java         by Dale/Joyce/Weems                Chapter 2
//
// Implements StackInterface using a linked list to hold the elements.
//-----------------------------------------------------------------------

package ch02.stacks;

import support.LLNode;

public abstract class LinkedStack<T> implements StackInterface<T>
{
    protected LLNode<T> top;   // reference to the top of this stack

    public LinkedStack()
    {
        top = null;
    }

    public void push(T element)
    // Places element at the top of this stack.
    {
        LLNode<T> newNode = new LLNode<T>(element);
        newNode.setLink(top);
        top = newNode;
    }

    public void pop()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise removes top element from this stack.
    {
        if (!isEmpty())
        {
            top = top.getLink();
        }
        else
            throw new StackUnderflowException("Pop attempted on an empty stack.");
    }

    public T top()
    // Throws StackUnderflowException if this stack is empty,
    // otherwise returns top element from this stack.
    {
        if (!isEmpty())
            return top.getInfo();
        else
            throw new StackUnderflowException("Top attempted on an empty stack.");
    }

    public boolean isEmpty()
    // Returns true if this stack is empty, otherwise returns false.
    {
        return (top == null);
    }

    public boolean isFull()
    // Returns false - a linked stack is never full
    {
        return false;
    }

}