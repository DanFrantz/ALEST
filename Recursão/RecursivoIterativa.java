/*Para todos exercícios, faça uma versão
iterativa, usando laços, e uma versão
recursiva.
1. Escreva um método que some todos elementos de um array
de inteiros.
2. Escreva um método que calcula 𝑥
𝑦
(onde x e y são inteiros).
Considere que x e y são parâmetros do método.
3. Escreva um método que inverta os elementos de um array. */

//Versão com array e laço de repetição da Soma
public int somaArraylaco(int[] arrayInteiros){ 
    int soma=0; 
    for(int i=0; i<arrayInteiros.length;i++){
        soma+=arrayInteiros[i];
    }
    return soma;
}


//Versão com recursividade soma de array
public int somaArrayRecursao(int [] arrayInteiros){
    
}