package visitor;

/**
 * Created by Jorge on 10-06-2016.
 */
public class Value {

    private Object v;

    public Value(Object v){
        this.v = v;
    }

    public Object getValue(){
        return this.v;
    }
}
