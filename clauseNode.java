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
        
        for (int i = 0; i < literals.size(); i++)
        {
            this.clause.add(literals.get(i));
        }
                
        
    }


    /*
    checkVar takes an int and checks whether that inegter (negated or not) is in the clause
    Params: Int that is the var that we want to check for
    Return: boolean whether the symbol is found or not (true == found)
    Example: Used if a search algorithm needs to know whether a variable is in a clause
    */
    public boolean checkVar(int var)
    {
        for (int i = 0; i < this.clause.size(); i++)
        {
            if (var == clause.get(i))
            {
                return true;
            }
        }
        return false;
    } 



    /*
    checkHighest takes an int and checks whether that inegter is the largest value
    Params: Int that is the var that we want to check for
    Return: boolean whether the symbol is high or not (true == high)
    Example: Used if a search algorithm needs to know whether a clause cannot be solved
    */
    public boolean checkHighest(int var)
    {
        int highest = Math.abs(this.clause.get(0));
        int varHigh = Math.abs(var);
        for (int i = 0; i < this.clause.size(); i++)
        { 
            if (highest < Math.abs(clause.get(i)))
            {
                highest = Math.abs(clause.get(i));
            }
        }

        if (varHigh > highest)
        {
            return true;
        }
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
        
        
        for (int i = 0; i < this.clause.size(); i++)
        {
            
            if (var == clause.get(i) && this.solved != true)
            {
                this.solved = true;
                return true;
            }
            
                

        }

        return false;
    }



    /*
    getters and setters for the attributes
    */
    public boolean getSolved()
    {
        return this.solved;
    }
    public void setSolved()
    {
        this.solved = false;
    }

    public ArrayList<Integer> getClause()
    {
        return this.clause;
    }

    
}