package model;

public class Fraction {
    private int counter;
    private int numerator;
    private float decimal;

    public Fraction(int counter, int numerator)
    {
        this.counter = counter;
        this.numerator = numerator;
        this.decimal = (float) counter / (float) numerator;
    }

    public float getDecimal() {
        return decimal;
    }

    public boolean equals(Fraction other)
    {
        if (this.decimal == other.getDecimal())
        {
           return true;
        }
        return false;
    }

    public int getCounter() {
        return counter;
    }

    public int getNumerator() {
        return numerator;
    }

    //Euklid algorithm
    public Fraction reduce()
    {
        int a;
        int b;
        if(this.counter > this.numerator)
        {
            a = Math.abs(this.counter);
            b = Math.abs(this.numerator);
        }
        else
        {
            a = Math.abs(this.numerator);
            b = Math.abs(this.counter);
        }
        int bnew;
        while(b > 1)
        {
            bnew = a % b;
            a = b;
            b = bnew;
        }
        if(b == 1) { return this; }
        return new Fraction((this.counter / a), (this.numerator / a));
    }

    public Fraction add(Fraction other)
    {
        return new Fraction(((this.counter * other.getNumerator()) + (other.getCounter() * this.numerator)), (this.numerator * other.getNumerator())).reduce();
    }

    public Fraction subtract(Fraction other)
    {
        return new Fraction(((this.counter * other.getNumerator()) - (other.getCounter() * this.numerator)), (this.numerator * other.getNumerator())).reduce();
    }

    public Fraction multiply(Fraction other)
    {
        return new Fraction(this.counter * other.getCounter(), this.numerator * other.getNumerator()).reduce();
    }

    public Fraction divide(Fraction other)
    {
        return new Fraction(this.counter * other.getNumerator(), this.numerator * other.getCounter()).reduce();
    }
}
