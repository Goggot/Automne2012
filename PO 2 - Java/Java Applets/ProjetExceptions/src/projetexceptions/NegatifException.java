package projetexceptions;

public class NegatifException extends Exception{
    private String nomVariable;
    
    public NegatifException(String nomVariable){
        super("Cette valeur est négative");  
        this.nomVariable = nomVariable;
    }

    public String getNomVariable() {
        return nomVariable;
    }
}
