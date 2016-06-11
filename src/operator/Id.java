package operator;

/**
 * Created by Jorge on 11-06-2016.
 */
public class Id implements Exp {
    String name;

    public Id(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void replace(Exp b, Exp a) {
        if(name.equals(b.toString())){
            name = a.toString();
        }
    }

    @Override
    public Object clone() {
        return new Id(name);
    }
}
