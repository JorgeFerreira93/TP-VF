package operator;

/**
 * Classe que representa um identificador.
 *
 * @author jorge
 */
public class Id implements Exp {
    private String name;

    public Id(String name){
        this.name = name;
    }

    public String getName() {
        return name;
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
