package instrs;

import operator.Exp;

/**
 * Classe que representa uma atribuição.
 *
 * @author jorge
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
