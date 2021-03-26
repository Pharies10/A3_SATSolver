/*
Jack Pharies
CSC 372
A3


forwardSearch

forwardSearch is an attempt at a constarint solving with forward search.


A list holds all the variables, each recursion the weights of the indexes are recalculated.
forwardSearch chooses the variable that is in the most unsolved clauses and its inverse
Trying to emulate a forward search where we can tell the best move forward by being able to solve the clauses with the most literals
will backtrack if we run into conflict at any point
will terminate if we find that we cannot satisfy the equation

From what I can tell, this is a combinations of a greedy local search and a DFS

*/


import java.util.*;

import javax.swing.plaf.TreeUI;

import java.io.*;


public class forwardSearch
{

    private ArrayList<clauseNode> unsolved;
    private Stack<clauseNode> solved;
    private ArrayList<satNode> remaining;
    private Stack<satNode> forTree;
    private int numOfVars;
    private int numOfClauses;
    private int globalCount;



/*
    Constructor for the forwardSearch
    Example: Used to make a forwardSearch search object within a testHub.
    */
public forwardSearch()
{
        this.unsolved = new ArrayList<clauseNode>();
        this.solved = new Stack<clauseNode>();
        this.forTree = new Stack<satNode>();
        this.remaining = new ArrayList<satNode>();
        this.numOfClauses = 0;
        this.numOfVars = 0;
        this.globalCount = 0;

}
 /*
    Method that is called to start the search. Will open the files and run forward.
    Example: called within a testhub to start the forward search
    */
    public void solve(String file)
    {
        this.globalCount = 0;
        this.solved = new Stack<clauseNode>();
        this.unsolved = new ArrayList<clauseNode>();
        this.forTree = new Stack<satNode>();
        this.remaining = new ArrayList<satNode>();
        
        InputStream input = getClass().getResourceAsStream(file);
        Scanner reader = new Scanner(input);
        while (reader.hasNextLine())
        {
            
            String line = reader.nextLine();
            String[] clause = line.split(" ");
            if (clause[0].equals("p") == true)
            {
                this.numOfVars = Integer.valueOf(clause[2]);
                this.numOfClauses = Integer.valueOf(clause[3]);
            }
            if (clause[0].equals("c") != true && clause[0].equals("p") != true)
            {
            ArrayList<Integer> intList = new ArrayList<Integer>();
            for (int i = 0; i < 3; i++)
            {
                int number = Integer.valueOf(clause[i]);
                intList.add(number);
            }
            clauseNode node = new clauseNode(intList);
            unsolved.add(node);
            }

        }
       // System.out.println(numOfClauses);
        reader.close();

        boolean solved = start();

        if (solved == true)
        {
            //printNodes();
            System.out.println("solved");
            
            
            
        }
        System.out.println(globalCount);
        System.out.println("completed");
        

    }



    /*
    Starts the recursion for the forward search
    Returns: the boolean whether the search succeeded
    Example: used to start recursion in solve()
    */
    private boolean start()
    {
        satNode start = new satNode(0, null);
        forTree.push(start);
        for (int i=0; i < numOfVars; i++)
        {
            satNode newNode = new satNode(i+1, null);
            satNode newNodeMinus = new satNode((i+1)*-1, null);
            remaining.add(newNode);
            remaining.add(newNodeMinus);
        }

        boolean solved = this.forward();

        if (solved == true)
        {
            return true;
        }

        return false;
    }

    /*
    The main recursion method in forward
    Returns: the boolean whether the search succeeded
    Example: used to recurse
    */
    private boolean forward()
    {
        globalCount++;
        recalculate();
        satNode currNode = remaining.get(0);
        int count = 0;
        int pos = 0;
        int negPos = 0;
        for (int i = 0; i< remaining.size(); i++)
        {
            if (remaining.get(i).getRepeat() > count && remaining.get(i).getUsed() == false)
            {
                count = remaining.get(i).getRepeat();
                pos = i;
                currNode = remaining.get(i);
            }
        }
        int currVal = currNode.getVal();

        remaining.get(pos).setUsed(true);

        if (count == 0)
        {
            return false;
        }

        // find oppisite
        satNode negate = remaining.get(0);
        for (int i = 0; i< remaining.size(); i++)
        {
            if (remaining.get(i).getVal() == (currVal * -1))
            {
                negate = remaining.get(i);
                negPos = i;
            }
        }
        remaining.get(negPos).setUsed(true);
        int solvedCounter = 0;
        // solve the sectiosn that can be solved
        for (int i = 0; i < unsolved.size(); i++)
        {
            if (unsolved.get(i).checkSolved(currVal) == true)
            {
                clauseNode node = this.unsolved.get(i);
                this.solved.push(node);
                solvedCounter++;
            }
            
        }

        if (this.solved.size() == numOfClauses)
        {
            //this.printNodes(currNode);
            
            return true;
            
        }

            satNode newNode = new satNode(currVal, forTree.peek());
            forTree.push(newNode);
            

            boolean solved = forward();

            if (solved == true)
            {
                return true;
            }

            forTree.pop();
            for(int i = 0; i < solvedCounter; i++)
            {
                clauseNode removed = this.solved.pop();
                removed.setSolved();
                
            }

         solvedCounter = 0;
        // solve the sectiosn that can be solved
        for (int i = 0; i < unsolved.size(); i++)
        {
            if (unsolved.get(i).checkSolved(negate.getVal()) == true)
            {
                clauseNode node = this.unsolved.get(i);
                this.solved.push(node);
                solvedCounter++;
            }
            
        }
        if (this.solved.size() == numOfClauses)
        {
            //this.printNodes(currNode);
            
            return true;
            
        }
            satNode newNodeNegate = new satNode(negate.getVal(), forTree.peek());
            forTree.push(newNodeNegate);
            

            solved = forward();

            if (solved == true)
            {
                return true;
            }

            forTree.pop();
            for(int i = 0; i < solvedCounter; i++)
            {
                clauseNode removed = this.solved.pop();
                removed.setSolved();
            }
            remaining.get(pos).setUsed(false);
            remaining.get(negPos).setUsed(false);
            

        
            return false;
    }


    /*
    used to recalculate the weightes of each variable. 
    Example: use at begining gof recursion to recalculate the number of clauses each variable is in
    */
    private void recalculate()
    {
        int counter = 0;
        for (int i = 0; i < remaining.size(); i++)
        {
            counter = 0;
            for (int j = 0; j < unsolved.size(); j++)
            {
                if (unsolved.get(j).checkVar(remaining.get(i).getVal()) == true 
                    && unsolved.get(j).getSolved() == false)
                    {
                        counter++;
                    }
            }
            remaining.get(i).setRepeat(counter);
        }

    }

    // used to print nodes for debugging -- nots called as of now
    private void printNodes()
    {

        satNode peeked = forTree.peek();
       
        int absolutVal = Math.abs(peeked.getVal());
        
        while(forTree.isEmpty() != true)
        {
            
            satNode popped = forTree.pop();
            System.out.println(popped.getVal());
        }
        
    }
}