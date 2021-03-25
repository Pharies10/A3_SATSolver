/*
Jack Pharies
CSC 372
A3


A3_SAT

A3_SAT is the testing hub. It will create a DPLL and ___ object and run their solve methods. 
Decided to make a seperate Test hub so that command line usage could be at a min.

*/


public class A3_SAT {

public static void main(String[] args)
{

// start the SAT solving algorithms

DPLL dpllSolver = new DPLL();
/*
System.out.println("test1");
dpllSolver.solve("A3_tests/10.40.160707067.cnf");
System.out.println("test2");
dpllSolver.solve("A3_tests/10.40.967323288.cnf");
System.out.println("test3");
dpllSolver.solve("A3_tests/10.42.504071595.cnf");
System.out.println("test4");
dpllSolver.solve("A3_tests/10.42.1465130262.cnf");
System.out.println("test5 Un");
dpllSolver.solve("A3_tests/10.44.1247388329.cnf");
System.out.println("test6");
dpllSolver.solve("A3_tests/10.44.1667358355.cnf");
System.out.println("test7");
dpllSolver.solve("A3_tests/10.46.183405239.cnf");
System.out.println("test8");
dpllSolver.solve("A3_tests/10.46.623142927.cnf");
System.out.println("test9 Un");
dpllSolver.solve("A3_tests/10.48.640112774.cnf");
System.out.println("test10");
dpllSolver.solve("A3_tests/10.48.1494607484.cnf");
System.out.println("");
System.out.println("");
*/

for (int i = 0; i < 5; i++) {
System.out.println("test20-1-s");
dpllSolver.solve("A3Formulas/f0020.01.s.cnf");
System.out.println("");

System.out.println("test20-1-u");
dpllSolver.solve("A3Formulas/f0020.01.u.cnf");
System.out.println("");

System.out.println("test20-2-s");
dpllSolver.solve("A3Formulas/f0020-02-s.cnf");
System.out.println("");

System.out.println("test20-2-u");
dpllSolver.solve("A3Formulas/f0020-02-u.cnf");
System.out.println("");

System.out.println("test20-3-s");
dpllSolver.solve("A3Formulas/f0020-03-s.cnf");
System.out.println("");

System.out.println("test20-3-u");
dpllSolver.solve("A3Formulas/f0020-03-u.cnf");
System.out.println("");

System.out.println("test20-4-s");
dpllSolver.solve("A3Formulas/f0020-04-s.cnf");
System.out.println("");

System.out.println("test20-4-u");
dpllSolver.solve("A3Formulas/f0020-04-u.cnf");
System.out.println("");

System.out.println("test20-5-s");
dpllSolver.solve("A3Formulas/f0020-05-s.cnf");
System.out.println("");

System.out.println("test20-5-u");
dpllSolver.solve("A3Formulas/f0020-05-u.cnf");
System.out.println("");

System.out.println("test20-6-s");
dpllSolver.solve("A3Formulas/f0020-06-s.cnf");
System.out.println("");

System.out.println("test20-6-u");
dpllSolver.solve("A3Formulas/f0020-06-u.cnf");
System.out.println("");


System.out.println("test20-7-s");
dpllSolver.solve("A3Formulas/f0020-07-s.cnf");
System.out.println("");

System.out.println("test20-7-u");
dpllSolver.solve("A3Formulas/f0020-07-u.cnf");
System.out.println("");

System.out.println("test20-8-s");
dpllSolver.solve("A3Formulas/f0020-08-s.cnf");
System.out.println("");

System.out.println("test20-8-u");
dpllSolver.solve("A3Formulas/f0020-08-u.cnf");
System.out.println("");



}

for (int i = 0; i < 5; i++) {
    System.out.println("test2=40-1-s");
    dpllSolver.solve("A3Formulas/f0040-01-s.cnf");
    System.out.println("");
    
    System.out.println("test40-1-u");
    dpllSolver.solve("A3Formulas/f0040-01-u.cnf");
    System.out.println("");
    
    System.out.println("test40-2-s");
    dpllSolver.solve("A3Formulas/f0040-02-s.cnf");
    System.out.println("");
    
    System.out.println("test40-2-u");
    dpllSolver.solve("A3Formulas/f0040-02-u.cnf");
    System.out.println("");
    
    System.out.println("test40-3-s");
    dpllSolver.solve("A3Formulas/f0040-03-s.cnf");
    System.out.println("");
    
    System.out.println("test40-3-u");
    dpllSolver.solve("A3Formulas/f0040-03-u.cnf");
    System.out.println("");
    
    System.out.println("test40-4-s");
    dpllSolver.solve("A3Formulas/f0040-04-s.cnf");
    System.out.println("");
    
    System.out.println("test40-4-u");
    dpllSolver.solve("A3Formulas/f0040-04-u.cnf");
    System.out.println("");
    
    System.out.println("test40-5-s");
    dpllSolver.solve("A3Formulas/f0040-05-s.cnf");
    System.out.println("");
    
    System.out.println("test40-5-u");
    dpllSolver.solve("A3Formulas/f0040-05-u.cnf");
    System.out.println("");
    
    System.out.println("test40-6-s");
    dpllSolver.solve("A3Formulas/f0040-06-s.cnf");
    System.out.println("");
    
    System.out.println("test40-6-u");
    dpllSolver.solve("A3Formulas/f0040-06-u.cnf");
    System.out.println("");
    
    
    System.out.println("test40-7-s");
    dpllSolver.solve("A3Formulas/f0040-07-s.cnf");
    System.out.println("");
    
    System.out.println("test40-7-u");
    dpllSolver.solve("A3Formulas/f0040-07-u.cnf");
    System.out.println("");
    
    System.out.println("test40-8-s");
    dpllSolver.solve("A3Formulas/f0040-08-s.cnf");
    System.out.println("");
    
    System.out.println("test40-8-u");
    dpllSolver.solve("A3Formulas/f0040-08-u.cnf");
    System.out.println("");
    
    
    
    }




///System.out.println("");



//dpllSolver.solve("10.40.160707067.cnf");

}
    
}