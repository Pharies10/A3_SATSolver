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


public class DPLL {


    private ArrayList<clauseNode> unsolved;
    private Stack<clauseNode> solved;
    private Stack<satNode> dpllTree;
    private int recent;
    private int currClauseNum;
    private int currLitNum;


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

    }


    /*
    Method that is called to start the search. Will open the files and run DPLL.
    Example: called within a testhub to start the DPLL search
    */
    public void solve()
    {

    }

    /*
    Starts rthe recursion for the DPLL search
    Returns: the boolean whether the search succeeded
    Example: used to start recursion in solve()
    */
    private boolean start()
    {
        return false;
    }


    /*
    The main recursion method in DPLL
    Returns: the boolean whether the search succeeded
    Example: used to recurse
    */
    private boolean dpll()
    {
        /*

        basic alg taken from rubrik

if every clause is T	w.r.t.	model,	then return T
if some clause is F,	then return F
(Sym,	value)	=	FIND-PURE-SYMBOL(	symbols,	clauses,	model	)
if Sym,	then return DPLL(	clauses,	symbols − Sym,	model ∪ {Sym	=	value} )
(Sym,	value)	=	FIND-UNIT-CLAUSE(	 clauses,	model	)
if Sym,	then return DPLL(	clauses,	symbols − Sym,	model ∪ {Sym	=	value} )
Sym =	FIRST(symbols);	rest	=	REST(symbols)
return DPLL(	clauses,	rest,	model ∪ {Sym	= True} )	or
DPLL( clauses,	rest,	model ∪ {Sym	=	False} )


        */
        return false;
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