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
    private int repeat;
    private boolean used;

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
        this.repeat = 0;
        this.used = false;
       

    }
    

    /*
    getters and setters for the attributes
    */
    public int getVal()
    {
        return this.val;
    }

    public void setRepeat(int var)
    {
        this.repeat = var;
    }

    public int getRepeat()
    {
        return this.repeat;
    }

    public satNode getParent()
    {
        return this.parent;
    }

    public void setParent(satNode newParent)
    {
        this.parent = newParent;
    }

    public boolean getUsed()
    {
        return this.used;
    }

    public void setUsed(boolean change)
    {
        this.used = change;
    }

    public void changeCharge()
    {
        this.val = this.val * -1;
    }
}