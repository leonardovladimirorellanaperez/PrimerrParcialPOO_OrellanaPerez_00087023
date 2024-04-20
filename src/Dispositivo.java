public class Dispositivo extends Articulo {
    private String marca;
    private String sistemaOperativo;

    public Dispositivo(String nombre, String modelo, String descripcion, float precio, String marca, String sistemaOperativo) {
        super(nombre, modelo, descripcion, precio);
        this.marca = marca;
        this.sistemaOperativo = sistemaOperativo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public void setSistemaOperativo(String sistemaOperativo) {
        this.sistemaOperativo = sistemaOperativo;
    }
}
