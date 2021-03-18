/*
Jack Pharies
CSC 372
A3


forwardSearch

forwardSearch is an attempt at a constarint solving with forward search.

The idea right now is to have a hash table where the index correlates with a literal.
Each hash table will hold a list of clauseNodes that have the literal in it
Trying to emulate a forward search where we can tell the best move forward by being able to solve the clauses with the most literals
will backtrack if we run into conflict at any point
will terminate if we find that we cannot satisfy the equation


may run a quick heuristic at the beginning to check for satisfiability

*/
import java.util.*;

public class forwardSearch
{

    private ArrayList<clauseNode> unsolved;
    private Stack<clauseNode> solved;
    private Stack<satNode> forTree;



/*
My idea for this is to keep a list of all the variable and the number of clauses those variables are in. 
We will look ahead and add the satNode to the stack that is in the most clauses
We eliminate the negation
We then recalculate for the remainig clauses and repeat.

This should work


*/






}