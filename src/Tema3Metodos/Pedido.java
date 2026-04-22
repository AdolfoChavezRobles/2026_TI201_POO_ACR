package Tema3Metodos;

public class Pedido {
    private Usuario usuario;
    private Torta torta;

    public Pedido(Usuario usuario, Torta torta) {
        this.usuario = usuario;
        this.torta = torta;
    }

    public String getNombreDeUsuario() {
        return usuario.getNombre();
    }

    public String getNombreDeTorta() {
        return torta.getNombre();
    }
    
    public float getPrecio() {
        return torta.getPrecio();
    }

    @Override
    public String toString() {
        return "Pedido{" + "usuario=" + usuario + ", torta=" + torta + '}';
    }
}
