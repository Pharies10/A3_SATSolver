/*
Jack Pharies
CSC 372
A3


DPLL

DPLL search object. When called upon, DPLL opens a predetermined file and solves the SAT inside.
Will be called in A3_SAT.
SAT is formatted in DIMACS form.
Will go file by file and solve the SATS.

*/

import java.util.*;

import javax.swing.plaf.TreeUI;

import java.io.*;

public class DPLL {


    private ArrayList<clauseNode> unsolved;
    private Stack<clauseNode> solved;
    private Stack<satNode> dpllTree;
    private int recent;
    private int numOfVars;
    private int numOfClauses;
    private int currClauseNum;
    private int currLitNum;
    private int globalCount;


    /*
    Constructor for the DPLL
    Example: Used to make a DPLL search object within a testHub.
    */
    public DPLL()
    {
        this.unsolved = new ArrayList<clauseNode>();
        this.solved = new Stack<clauseNode>();
        this.dpllTree = new Stack<satNode>();
        this.recent = 0;
        this.currClauseNum = 0;
        this.currLitNum = 0;
        this.globalCount = 0;

    }


    /*
    Method that is called to start the search. Will open the files and run DPLL.
    Example: called within a testhub to start the DPLL search
    */
    public void solve(String file)
    {
        this.globalCount = 0;
        this.solved = new Stack<clauseNode>();
        this.unsolved = new ArrayList<clauseNode>();
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
            System.out.println("solved");
            
        }
        System.out.println(globalCount);
        System.out.println("completed");
        

    }

    /*
    Starts the recursion for the DPLL search
    Returns: the boolean whether the search succeeded
    Example: used to start recursion in solve()
    */
    private boolean start()
    {
            satNode newNode = new satNode(-1, null);

            boolean solved = dpll(newNode);

            if (solved == true)
            {
                return true;
            }
            
            newNode.changeCharge();
           

            solved = dpll(newNode);

            if (solved == true)
            {
                return true;
            }

            
        return false;
    }


    /*
    The main recursion method in DPLL
    Returns: the boolean whether the search succeeded
    Example: used to recurse
    */
    private boolean dpll(satNode currNode)
    {
        globalCount++;
        int currVal = currNode.getVal();
        //System.out.println(currVal);
        
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
        
        


        

        // if every clause is T	w.r.t.	model,	then return T
        if (this.solved.size() == numOfClauses)
        {
            //this.printNodes(currNode);
            
            return true;
            
        }
        // if some clause is F,	then return F
        for (int i = 0; i < unsolved.size(); i++)
        {
            if (unsolved.get(i).checkHighest(currVal) == true && unsolved.get(i).getSolved() == false)
            {
            for(i = 0; i < solvedCounter; i++)
            {
                clauseNode removed = this.solved.pop();
                removed.setSolved();
                //this.unsolved.add(removed);
            }
            return false;
            }
        }
        boolean pure = pureSymbol(currVal);
        if (pure == true)
        {
            //this.printNodes(currNode);
            return true;
        }
        int absCurrVal = Math.abs(currVal);
        if (absCurrVal + 1 <= numOfVars)
        {
            
            absCurrVal++;
            absCurrVal = absCurrVal * -1;
            satNode newNode = new satNode(absCurrVal, currNode);

            boolean solved = dpll(newNode);

            if (solved == true)
            {
                return true;
            }

            newNode.changeCharge();

            solved = dpll(newNode);

            if (solved == true)
            {
                return true;
            }

            

        }
        for(int i = 0; i < solvedCounter; i++)
            {
                clauseNode removed = this.solved.pop();
                removed.setSolved();
                //this.unsolved.add(removed);
            }

        return false;
        /*

        basic alg taken from rubrik


(Sym,	value)	=	FIND-PURE-SYMBOL(	symbols,	clauses,	model	)
if Sym,	then return DPLL(	clauses,	symbols − Sym,	model ∪ {Sym	=	value} )
(Sym,	value)	=	FIND-UNIT-CLAUSE(	 clauses,	model	)
if Sym,	then return DPLL(	clauses,	symbols − Sym,	model ∪ {Sym	=	value} )
Sym =	FIRST(symbols);	rest	=	REST(symbols)
return DPLL(	clauses,	rest,	model ∪ {Sym	= True} )	or
DPLL( clauses,	rest,	model ∪ {Sym	=	False} )


        */
        
    }

    private void printNodes(satNode node)
    {
        int absolutVal = Math.abs(node.getVal());
        
        if (absolutVal < numOfVars)
        {
            for(int i = numOfVars; i > absolutVal; i--)
            {
                System.out.println(i);
            }
        }
        while(node.getParent() != null)
        {
            System.out.println(node.getVal());
            node = node.getParent();
        }
        System.out.println(node.getVal());
    }

    /*
    Pure-Symbol-Heuristic that looks at all unsolved clauses and sees if val
    is the same literal (positive or negated) in all of them. If so the rest of the 
    clauses can be solved.
    Params: int val that is the litera that is being checked
    Return: boolean whether the val is in all remaining clauses
    Example: used to stop the DFS early and solve the SAT problem
    */
    private boolean pureSymbol(int val)
    {
        int count = 0;
        for (int i = 0; i < unsolved.size(); i++)
        {
            if (unsolved.get(i).checkVar(val) == true && unsolved.get(i).getSolved() == false)
            {
                count++;
            }
        }

        if (count == unsolved.size())
        {
            return true;
        }
        return false;
    }



    /*
    Unit-Clause-Heuristic that looks at every clause for a negative and positive in the same sentence
    Not sure how I will implement this yet, or if thsi will be more natural
    Param: int val that will be searched for
    Return: boolean whether the val is in a unit clause form
    Example: used to stop the DFS early and solve the SAT problem
    */
    private boolean unitClause(int val)
    {
        return false;
    }
    
}