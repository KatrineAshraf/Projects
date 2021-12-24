package Java.SS;

public class Cell {
    public String name;
    public int  distance,order;
    public double heuristicCost, finalCost;
    public Cell parent =null ,ChildL = null,ChildR =null;
    public boolean solution;
    public Cell (String name){
        this.name = name;
    }
    @Override
    public String toString(){
       return name;
     }
}
