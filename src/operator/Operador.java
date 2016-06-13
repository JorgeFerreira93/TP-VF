package operator;

/**
 * Created by Jorge on 11-06-2016.
 */
public class Operador implements Exp{
    private Exp left;
    private String op;
    private Exp right;

    public Operador(String op, Exp left, Exp right){
        this.left = left;
        this.op = op;
        this.right = right;
    }

    public Exp getLeft() {
        return left;
    }

    public Exp getRight() {
        return right;
    }

    public String getOp() {
        return op;
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

            String res = "";
            if(left instanceof Int || left instanceof Id){
                res += left.toString();
            }
            else{
                res += "(" + left.toString() + ")";
            }

            res += " " + op + " ";

            if(right instanceof Int || right instanceof Id){
                res += right.toString();
            }
            else{
                res += "(" + right.toString() + ")";
            }

            return res;
        }
    }

    @Override
    public Object clone() {
        return new Operador(this.op, (Exp)this.left.clone(), (Exp) this.right.clone());
    }
}
