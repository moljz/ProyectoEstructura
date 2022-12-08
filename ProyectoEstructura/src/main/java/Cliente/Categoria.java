
package Cliente;

/**
 *
 * @author Jafet Araya 
 */
public enum Categoria {
    Bronce,
    Plata, 
    Oro,
    Zafiro;
    
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
