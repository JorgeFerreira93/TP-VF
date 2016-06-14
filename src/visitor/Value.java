package visitor;

/**
 * Classe usada para transferẽncia de valores durante a visita da AST.
 *
 * @author jorge
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
