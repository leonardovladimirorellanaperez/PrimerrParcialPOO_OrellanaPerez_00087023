import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        Scanner sn = new Scanner(System.in);

        class MenuPrincipal {
            private final Inventario inventario;
            private final Scanner sn;

            public MenuPrincipal(Inventario inventario, Scanner sn) {
                this.inventario = inventario;
                this.sn = sn;
            }

            public void iniciar() {
                int opcion;
                while (true) {
                    try {
                        imprimirMenu();
                        opcion = sn.nextInt();
                        sn.nextLine();

                        if (opcion == 5) {
                            System.out.println("\nGracias por usar nuestro inventario. Hasta Pronto.");
                            break;
                        }

                        switch (opcion) {
                            case 1:
                                agregarArticulo();
                                break;
                            case 2:
                                modificarArticulo();
                                break;
                            case 3:
                                mostrarArticulo();
                                break;
                            case 4:
                                mostrarListaArticulos();
                                break;
                            default:
                                System.out.println("\nSelecciona una opcion valida.\n");
                                break;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("\nPor favor, ingrese un dato válido.\n");
                        sn.nextLine();
                    }
                }
            }

            private void mostrarListaArticulos() {
                ArrayList<Articulo> listaArticulos = inventario.getListaArticulos();
                System.out.println("\n#\t|Nombre\t\t|Modelo\t\t|Descripcion\t\t|Precio");
                for (int i = 0; i < listaArticulos.size(); i++) {
                    Articulo articulo = listaArticulos.get(i);
                    System.out.println(
                            (i + 1)
                                    + "\t|" + articulo.getNombre()
                                    + "\t|" + articulo.getModelo()
                                    + "\t|" + articulo.getDescripcion()
                                    + "\t|$" + articulo.getPrecio()
                    );
                }
                System.out.println("\n");
            }

            private void mostrarArticulo() {
                System.out.println("Digite el modelo del artículo a mostrar:");
                String modelo = sn.nextLine();

                Articulo articulo = inventario.buscarArticulo(modelo);
                if (articulo != null) {
                    System.out.println("NOMBRE: " + articulo.getNombre());
                    System.out.println("MODELO: " + articulo.getModelo());
                    System.out.println("DESCRIPCIÓN: " + articulo.getDescripcion());
                    System.out.println("PRECIO: $" + articulo.getPrecio() + "\n");
                } else {
                    System.out.println("El artículo no se encuentra en nuestro inventario.\n");
                }
            }

            private void modificarArticulo() {
                System.out.println("Ingrese el modelo del artículo que desea modificar:");
                String modelo = sn.nextLine();

                Articulo articulo = inventario.buscarArticulo(modelo);
                if (articulo != null) {
                    System.out.println("Ingrese el nuevo precio del artículo:");
                    float nuevoPrecio = sn.nextFloat();
                    sn.nextLine();
                    articulo.setPrecio(nuevoPrecio);

                    System.out.println("Ingrese la nueva descripción del artículo:");
                    String nuevaDescripcion = sn.nextLine();
                    articulo.setDescripcion(nuevaDescripcion);

                    System.out.println("El artículo ha sido modificado exitosamente.\n");
                } else {
                    System.out.println("El artículo no se encuentra nuestro inventario.\n");
                }
            }

            private void agregarArticulo() {
                System.out.println("Digite el nombre del artículo:");
                String nombre = sn.nextLine();
                System.out.println("Digite el modelo del artículo:");
                String modelo = sn.nextLine();
                System.out.println("Digite la descripción del artículo:");
                String descripcion = sn.nextLine();
                System.out.println("Digite el precio del artículo:");
                float precio = sn.nextFloat();
                sn.nextLine();

                //Atributos "inventados
                System.out.println("Digite la marca del artículo:");
                String marca = sn.nextLine();
                System.out.println("Digite el sistema operativo del artículo:");
                String sistemaOperativo = sn.nextLine();

                inventario.agregarArticulo(new Dispositivo(nombre, modelo, descripcion, precio, marca, sistemaOperativo));

                System.out.println("Artículo agregado exitosamente.\n");
            }

            private void imprimirMenu() {
                System.out.println("------------------MENÚ-----------------");
                System.out.println("Seleccione una opción:\n"
                        + "\t1. AGREGAR ARTÍCULO\n"
                        + "\t2. MODIFICAR ARTÍCULO\n"
                        + "\t3. MOSTRAR INFORMACIÓN DE UN ARTÍCULO\n"
                        + "\t4. MOSTRAR TODA LA LISTA DE ARTÍCULOS\n"
                        + "\t5. SALIR\n"
                );
                System.out.print("Tu opción -> ");
            }
        }

        MenuPrincipal menu = new MenuPrincipal(inventario, sn);
        menu.iniciar();
        sn.close();
    }
}