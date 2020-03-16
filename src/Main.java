import model.Fraction;

public class Main {

    public static void main(String[] args)
    {
        //THIS CLASS HAS BEEN USED TO TEST SOME THINGS SO FAR!
        Fraction a = new Fraction(1, 3);
        Fraction b = new Fraction(-3, 9);

        if (a.equals(b))
        {
            System.out.println("1/3 is equal to 3/9" + "\n" + a.getDecimal() + "\n" + b.getDecimal());
        }
        Fraction c = b.reduce();
        System.out.println(c.getCounter() + "/" + c.getNumerator());
        Fraction d = new Fraction(1, 7);
        Fraction e = d.reduce();
        System.out.println(e.getCounter() + "/" + e.getNumerator());


        Fraction f = d.add(a);
        System.out.println(f.getCounter() + "/" + f.getNumerator());
    }
}
