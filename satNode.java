/*
Jack Pharies
CSC 372
A3


SatNode

Used to construct the tree for the DPLL search.
Contains an Integer and a parent satNode.

*/

import java.util.*;

public class satNode {

    private int val;
    private satNode parent;
    private int charge;

    /*
    Constructor for the satNode
    Params: int val that is the value of the current node
            satNode parent that is the parent of this current node
    Example: Used to make a satNode within a DPLL search.
    */
    public satNode(int val, satNode parent)
    {
        this.val = val;
        this.parent = parent;
        this.charge = 0;

    }
    

    /*
    getVal return the val of node
    Return: global var val
    Example: Used to get the value to check for clause accetability
    */
    public int getVal()
    {
        return this.val;
    }


    /*
    getParent return the parent of node
    Return: global var parent
    Example: Used to get the parent of the current node
    */
    public satNode getParent()
    {
        return this.parent;
    }

    public void changeCharge()
    {
        this.val = this.val * -1;
    }
}