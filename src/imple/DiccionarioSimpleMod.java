package imple;

import interf.DiccionarioSimpleModTDA;
import tda.ConjuntoTDA;

public class DiccionarioSimpleMod implements DiccionarioSimpleModTDA {

    class NodoClave{
        int clave;
        int valor;
        int modificaciones;
        NodoClave sigClave;
    }

    NodoClave origen;

    @Override
    public void inicializarDiccionario() {
        origen = null;
    }

    @Override
    public void agregar(int clave, int valor) {
        NodoClave viajero = clave2NodoClave(clave);

        if(viajero == null){
            viajero = new NodoClave();
            viajero.clave = clave;
            viajero.sigClave = origen;
            viajero.modificaciones = 0;
            viajero.valor = valor;
            origen = viajero;
        }else{
            viajero.valor = valor;
            viajero.modificaciones = viajero.modificaciones + 1;
        }

    }

    @Override
    public void eliminar(int clave) {
        if(origen != null){
            if(origen.clave == clave){
                origen = origen.sigClave;
            }else{
                NodoClave viajero = origen;
                while(viajero != null && viajero.sigClave.clave != clave){
                    viajero = viajero.sigClave;
                }
                if(viajero.sigClave != null){
                    viajero.sigClave = viajero.sigClave.sigClave;
                }else viajero.sigClave = null;
            }
        }

    }

    @Override
    public int recuperar(int clave) {
        NodoClave aux = clave2NodoClave(clave);
        return aux.valor;
    }

    @Override
    public int recuperarMod(int clave) {
        NodoClave aux = clave2NodoClave(clave);
        return aux.modificaciones;
    }

    @Override
    public ConjuntoTDA claves() {
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();

        NodoClave viajero = origen;

        while(viajero != null) {
            claves.agregar(viajero.clave);
            viajero = viajero.sigClave;
        }

        return claves;
    }

    private NodoClave clave2NodoClave(int clave){
        NodoClave viajero = origen;
        while(viajero != null && viajero.clave != clave){
            viajero = viajero.sigClave;
        }
        return viajero;
    }


}
