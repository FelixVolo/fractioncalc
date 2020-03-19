package model;

public class Exercise {
    private Fraction solution;
    private String text;
    private int type;
    private String operator;

    public Exercise(int type, Fraction a, Fraction b)
    {
        this.type = type;
        if(type == 0) { this.solution = a.add(b).reduce(); this.text = "Addieren Sie die folgenden Brüche. Nur der kürzeste Bruch ist richtig."; this.operator = "+"; }
        if(type == 1) { this.solution = a.subtract(b).reduce(); this.text = "Subtrahieren Sie die folgenden Brüche. Nur der kürzeste Bruch ist richtig."; this.operator = "-"; }
        if(type == 2) { this.solution = a.multiply(b).reduce(); this.text = "Multiplizieren Sie die folgenden Brüche. Nur der kürzeste Bruch ist richtig."; this.operator = "*"; }
        if(type == 3) { this.solution = a.divide(b).reduce(); this.text = "Dividieren Sie die folgenden Brüche. Nur der kürzeste Bruch ist richtig."; this.operator = "/"; }
        if(type == 4) { this.solution = a.add(b); this.text = "Addieren Sie die folgenden Brüche."; this.operator = "+"; }
        if(type == 5) { this.solution = a.subtract(b); this.text = "Subtrahieren Sie die folgenden Brüche."; this.operator = "-"; }
        if(type == 6) { this.solution = a.multiply(b); this.text = "Multiplizieren Sie die folgenden Brüche."; this.operator = "*"; }
        if(type == 7) { this.solution = a.divide(b); this.text = "Dividieren Sie die folgenden Brüche."; this.operator = "/"; }
    }

    public String getText() { return text; }

    public String getOperator() { return operator; }

    public boolean checkSolution(Fraction other)
    {
        if (type < 4)
        {
            return solution.getCounter() == other.getCounter() && solution.getNumerator() == other.getNumerator();
        }
        else
        {
            return solution.equals(other);
        }
    }
}
