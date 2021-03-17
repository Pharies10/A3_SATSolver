/*
Jack Pharies
CSC 372
A3


clauseNode

Node class that holds a clause of a SAT in DIMACS format and a boolean variable.
The boolean variable is whether the clause is solved or not.
Used to check whether a certain clause is solved or not.

*/

import java.util.*;

public class clauseNode {

    private boolean solved;
    private ArrayList<Integer> clause;

    /*
    Constructor for the ClauseNode
    Params: ArrayList of integers that correspond to a clause in a SAT problem
    Example: Used to make a clauseNode within a DPLL search.
    */
    public clauseNode(ArrayList<Integer> literals)
    {
        this.solved = false;
        this.clause = new ArrayList<Integer>();

        /* for items in literals 
                add item into clause
        */
    }


    /*
    checkVar takes an int and checks whether that inegter (negated or not) is in the clause
    Params: Int that is the var that we want to check for
    Return: boolean whether the symbol is found or not (true == found)
    Example: Used if a search algorithm needs to know whether a variable is in a clause
    */
    public boolean checkVar(int var)
    {
        /* for items in clause
            check if var == |x|
            if so return true*/
        return false;
    } 

    /*
    checkSolved takes in an integer and sees if that integer turns the statement true
        the statement will only turn true if var matches a variable within clause
    Params: Int that is the variable that we are checking that makes the clause true
    Return: Boolean. If solved true if not false if it makes the statement false
    Example: Used to check whether a variable within the DPLL can solve a clause
    */
    public boolean checkSolved(int var)
    {
        /* for items in clause
            check if var == x
            if so set solved to true
            return true*/

        return false;
    }



    /*
    getSolved returns whether this clause has been solved or not
    Return: global var solved
    Example: Used to see if a certain clause has been solved or not
    */
    public boolean getSolved()
    {
        return this.solved;
    }

    /*
    getClause returns the clause that clause node is currently holding
    Return: global var clause
    Example: Used to get the clause from outside clauseNode
    */
    public ArrayList<Integer> getClause()
    {
        return this.clause;
    }

    
}