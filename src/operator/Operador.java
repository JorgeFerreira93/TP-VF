package operator;

/**
 * Created by Jorge on 11-06-2016.
 */
public class Operador implements Exp{
    Exp left;
    String op;
    Exp right;

    public Operador(String op, Exp left, Exp right){
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public void replace(Exp b, Exp a){
        if(b.toString().equals(left.toString())){
            left = (Exp) a.clone();
        }
        else{
            left.replace(b, a);
        }

        if(b.toString().equals(right.toString())){
            right = (Exp) a.clone();
        }
        else{
            right.replace(b, a);
        }
    }

    @Override
    public String toString() {
        if(left == null){
            return op + right.toString();
        }
        else{
            return left.toString() + op + right.toString();
        }
    }

    @Override
    public Object clone() {
        return new Operador(this.op, (Exp)this.left.clone(), (Exp) this.right.clone());
    }
}
