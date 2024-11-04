package imple;
//1 ConjuntoEspecialTDA
import interf.ConjuntoEspecialTDA;

public class ConjuntoEspecial implements ConjuntoEspecialTDA {

    int [] elementos;
    int indice;

    @Override
    public void inicializarConjunto() {
        indice = 0;
        elementos = new int[100];
    }

    @Override
    public Respuesta agregar(int valor) {
        Respuesta respuesta = new Respuesta();

        if(!this.pertenece(valor)){
            respuesta.error = false;
            elementos[indice] = valor;
            indice++;
        }
        else{
            respuesta.error = true;
        }
        return respuesta;
    }

    @Override
    public Respuesta sacar(int valor) {
        Respuesta respuesta = new Respuesta();

        int i = 0;

        while (i < indice && elementos[i] != valor) i++;
        if(i<indice){
            respuesta.error = false;
            elementos[i] = elementos[indice-1];
            indice--;
        }else respuesta.error = true;

        return respuesta;
    }

    @Override
    public Respuesta elegir() {
        int max = indice-1;
        int min = 0;
        int pos = (int)(Math.random() * (max-min+1) + min);

        Respuesta respuesta = new Respuesta();

        if (!this.conjuntoVacio()){
            respuesta.error = false;
            respuesta.rta = elementos[pos];
        }
        else {
            respuesta.error = true;
        }
        return respuesta;
    }

    @Override
    public boolean pertenece(int valor) {
        int i = 0;

        while(i<indice && elementos[i]!=valor) {
            i++;
        }

        return i<indice;
    }

    @Override
    public boolean conjuntoVacio() {
        return indice==0;
    }
}
