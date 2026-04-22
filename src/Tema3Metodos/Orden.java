package Tema3Metodos;

public class Orden {
    private Pedido pedido;
    private int prioridad;
    private boolean pago;
    private String estatus;

    public Orden(Pedido pedido, int prioridad, boolean pago, String estatus) {
        this.pedido = pedido;
        this.prioridad = prioridad;
        this.pago = pago;
        this.estatus = estatus;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        if (!estatus.equals("cocina")&& !estatus.equals("pago")){
            throw new IllegalArgumentException("Estautus debe ser cocinada o pagada");
        }
        this.estatus = estatus;
    }

    @Override
    public String toString() {
        return "Orden{" + "pedido=" + pedido + ", prioridad=" + prioridad + ", pago=" + pago + ", estatus=" + estatus + '}';
    }
    
    
}
