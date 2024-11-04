import imple.Conjunto;
import imple.DiccionarioSimpleMod;
import tda.ConjuntoTDA;

public class Main {
    public static void main(String[] args) {

        DiccionarioSimpleMod d1 = new DiccionarioSimpleMod();
        d1.inicializarDiccionario();

        System.out.println("Agrego...");

        d1.agregar(1,2);
        d1.agregar(2,6);
        d1.agregar(3,9);
        d1.agregar(4,8);

        mostrarDiccionario(d1);

        System.out.println("Elimino...");
        d1.eliminar(1);

        mostrarDiccionario(d1);

        System.out.println("Agrego otro valor para la clave 2...");
        d1.agregar(2,10);

        mostrarDiccionario(d1);
    }

    private static void mostrarDiccionario(DiccionarioSimpleMod diccionario){
        ConjuntoTDA claves = diccionario.claves();
        while (!claves.conjuntoVacio()){
            int clave = claves.elegir();
            int valor = diccionario.recuperar(clave);
            int modificaciones = diccionario.recuperarMod(clave);

            System.out.println("Clave: "+clave + " | Valor:" + valor + " | Modificaciones: " + modificaciones);

            claves.sacar(clave);
        }
    }

}