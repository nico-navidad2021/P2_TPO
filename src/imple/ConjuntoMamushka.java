package imple;
//2 ConjuntoMamushkaTDA
import interf.ConjuntoMamushkaTDA;

public class ConjuntoMamushka implements ConjuntoMamushkaTDA {

    int [] elementos;
    int indice;

    @Override
    public void inicializar() {
        indice = 0;
        elementos = new int[100];
    }

    @Override
    public void guardar(int dato) {
        elementos[indice] = dato;
        indice++;
    }

    @Override
    public void sacar(int valor) {
        int i = 0;

        while (i < indice && elementos[i] != valor) i++;
        if(i<indice){
            elementos[i] = elementos[indice-1];
            indice--;
        }
    }

    @Override
    public int elegir() {
        int max = indice-1;
        int min = 0;
        int pos = (int)(Math.random() * (max-min+1) + min);

        return elementos[pos];
    }

    @Override
    public int perteneceCant(int dato) {
        int x = 0;

        for(int i=0;i<indice;i++){
            if(elementos[i] == dato)x++;
        }

        return x;
    }

    @Override
    public boolean estaVacio() {
        return indice==0;
    }
}
