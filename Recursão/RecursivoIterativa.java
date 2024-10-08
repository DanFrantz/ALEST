/*Para todos exercícios, faça uma versão
iterativa, usando laços, e uma versão
recursiva.
1. Escreva um método que some todos elementos de um array
de inteiros.
2. Escreva um método que calcula 𝑥elvado a 𝑦
(onde x e y são inteiros).
Considere que x e y são parâmetros do método.
3. Escreva um método que inverta os elementos de um array. */

//Versão com array e laço de repetição da Soma
public class RecursivoIterativa{
    public int somaArraylaco(int[] arrayInteiros){ 
    int soma=0; 
    for(int i=0; i<arrayInteiros.length;i++){
        soma+=arrayInteiros[i];
    }
    return soma;
    }


//Versão com recursividade soma de array
    public int somaArrayRecursao(int[] arrayInteiros){
        return somaArrayRecursao(arrayInteiros,0);
    }
    private int somaArrayRecursao(int[] arrayInteiros,int pos){
        //Tenho que ter uma informação que diz o que foi somado do array e qual posição ir
        
        if(pos+1>=arrayInteiros.length){
            return arrayInteiros[pos];
        }
        
        return arrayInteiros[pos]+somaArrayRecursao(arrayInteiros, pos+1);
    }

//Um método recursivo para calcular x elevado a y

public int recElevado(int x, int y){
    return x*recElevado(x, y,1);
}

private int recElevado(int x, int y, int count){
    

        if(count<y){
        return x*recElevado(x, y, count+1);
        }
    
        return 1;
        
    }

//Método iterativo para elevar x por y
    public int itElevado(int x,int y){
        int mult=1;
        for(int i=0;y>i;i++){
            mult=mult*x;
        }
        return mult;
    }

    //Inverter os elementos do array com loop
    public int[] inverteArray(int[] arrayElements){
        int inverte=arrayElements.length-1,segura;
            for(int i=0;i<arrayElements.length/2;i++){
                segura=arrayElements[i];
                arrayElements[i]=arrayElements[inverte];
                arrayElements[inverte]=segura;
                inverte=inverte-1;
            }
            return arrayElements;  }

//Inverter o array com recursão
    public int[] recInverteArray(int[] arrayElements){
        return recInverteArray(arrayElements,0,arrayElements.length-1);
    }

    public int[] recInverteArray(int[] arrayOriginal,int pos,int posInv){
        int temp;
        if(pos<arrayOriginal.length/2){
            temp=arrayOriginal[pos];
            arrayOriginal[pos]=arrayOriginal[posInv];
            arrayOriginal[posInv]=temp;
            return recInverteArray(arrayOriginal, pos+1, posInv-1);
        }
        return arrayOriginal;

    }
}
