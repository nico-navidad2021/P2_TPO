package imple;

import interf.DiccionarioSimple2TDA;
import tda.ColaPrioridadTDA;
import tda.ConjuntoTDA;

public class DiccionarioSimple2 implements DiccionarioSimple2TDA {

    ColaPrioridadTDA valores;

    @Override
    public void InicializarDiccionario() {
        valores.inicializarCola();
    }

    @Override
    public void Agregar(int key, int value) {
        ColaPrioridadTDA colaAux = copiarCola(valores);

        //TODO


    }

    @Override
    public void Eliminar(int key) {

    }

    @Override
    public int Recuperar(int clave) {
        return 0;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA claves = new Conjunto();
        claves.inicializarConjunto();

        ColaPrioridadTDA aux = copiarCola(valores);

        while (!aux.colaVacia()) {
            int clave = aux.prioridad();
            claves.agregar(clave);
            aux.desacolar();
        }

        return claves;
    }

    private static ColaPrioridadTDA copiarCola(ColaPrioridadTDA colaOriginal) {
        ColaPrioridadTDA aux = new ColaPrioridad();
        aux.inicializarCola();

        ColaPrioridadTDA copiado = new ColaPrioridad();
        copiado.inicializarCola();

        while(!colaOriginal.colaVacia()){
            int elemento = colaOriginal.primero();
            int prioridad = colaOriginal.prioridad();

            aux.acolarPrioridad(elemento,prioridad);
            copiado.acolarPrioridad(elemento,prioridad);

            colaOriginal.desacolar();
        }

        while(!aux.colaVacia()){
            int elemento = aux.primero();
            int prioridad = aux.prioridad();

            colaOriginal.acolarPrioridad(elemento,prioridad);
        }
        return copiado;
    }


}
