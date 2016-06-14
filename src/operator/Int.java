package operator;

/**
 * Classe que representa um inteiro.
 *
 * @author jorge
 */
public class Int implements Exp{
    private int n;

    public Int(int n){
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }

    @Override
    public void replace(Exp b, Exp a) {    }

    @Override
    public Object clone() {
        return new Int(n);
    }
}
