package instrs;

import operator.Exp;

/**
 * Created by Jorge on 10-06-2016.
 */
public class Atrib implements Instrucao {
    private Exp id;
    private Exp atrib;

    public  Atrib(Exp id, Exp atrib){
        this.id = id;
        this.atrib = atrib;
    }

    public Exp getId() {
        return id;
    }

    public Exp getAtrib() {
        return atrib;
    }
}
