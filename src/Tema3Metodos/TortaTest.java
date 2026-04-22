package Tema3Metodos;

public class TortaTest {
    public static void main(String[] args) {
        
        try {

            Usuario usuario1 = new Usuario("Juan");

            String[] ingredientes = {"jamon", "queso", "lechuga"};
            Torta torta = new Torta("Cubana", ingredientes, 75.0f);

            Pedido pedido = new Pedido(usuario1, torta);

            Orden orden = new Orden(pedido, 1, false, "cocina");

            System.out.println("DATOS DEL PEDIDO");
            System.out.println("Usuario: " + pedido.getNombreDeUsuario());
            System.out.println("Torta: " + pedido.getNombreDeTorta());
            System.out.println("Precio: $" + pedido.getPrecio());

            System.out.println("\n DATOS DE LA ORDEN ");
            System.out.println(orden);

            orden.setPago(true);
            orden.setEstatus("pago");

            System.out.println("\n ORDEN ACTUALIZADA ");
            System.out.println(orden);

            Usuario usuario2 = new Usuario("Juan");
        
            if(usuario1.equals(usuario2)){
                System.out.println("Los usuarios son iguales");
            }else{
                System.out.println("Los usuarios no son iguales");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
    
}