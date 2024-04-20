import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Articulo> listaArticulos = new ArrayList<>();

    public void agregarArticulo(Articulo articulo) {
        listaArticulos.add(articulo);
    }

    public ArrayList<Articulo> getListaArticulos() {
        return listaArticulos;
    }

    public Articulo buscarArticulo(String modelo) {
        for (Articulo articulo : listaArticulos) {
            if (articulo.getModelo().equals(modelo)) {
                return articulo;
            }
        }
        return null;
    }
}
