package interf;

import tda.ConjuntoTDA;

public interface DiccionarioSimple2TDA {
    void InicializarDiccionario();
    void Agregar(int key, int value);
    void Eliminar(int key);
    int Recuperar(int clave);
    ConjuntoTDA Claves();
}
