package operator;

/**
 * Created by Jorge on 11-06-2016.
 */
public interface Exp {

    public void replace(Exp b, Exp a);
    public Object clone();
}
