public class AppOrd {
    public static void main(String[] args) {
        /*
         * Remova os comentarios abaixo para chamar metodos que testam
         * as inplementacoes.
         * Os testes não são exaustivos e podem existir erros que os
         * testes não pegam!
         */
        ListOrdArray lista = new ListOrdArray();
        ListOrdArray lista2 = new ListOrdArray();
        ListOrdArray lista3 = new ListOrdArray();

        lista2.addIncreasingOrder(2);
        lista2.addIncreasingOrder(4);
        lista2.addIncreasingOrder(6);
        lista2.addIncreasingOrder(8);

        lista3.addIncreasingOrder(2);
        lista3.addIncreasingOrder(1);
        lista3.addIncreasingOrder(3);
        lista3.addIncreasingOrder(5);
        System.out.print(lista.fusaoTodos(lista2, lista3));
    /* 

        lista.add(2);
        lista.add(4);
        lista.add(6);
        lista.add(8);
        
        System.out.println(lista);
       
        System.out.println("Tamanho da lista: " + lista.size());

        System.out.println("Elemento armazenado na primeira posicao da lista: " +lista.get(0));
        
        System.out.println("Tamanho da lista: " + lista.size());
        System.out.println("Tentando remover elemento 9: " + lista.remove(9));
        System.out.println(lista);
        System.out.println("Tamanho da lista: " + lista.size());

        lista.add(16);
        System.out.println("Verificando inserção após ter removido elemento: " + lista);
        
        System.out.println("Adicionando o elemento 5 no indice 2, elemento aterior era: " + lista.set(2, 5));
        System.out.println(lista);
        
        System.out.println("Lista contem elemento 0? " + lista.contains(0));

        System.out.println("Tamanho da lista: " + lista.size());
        lista.add(19);
        lista.reverse();
        System.out.print(lista);
        lista.add(3);
        lista.add(3);
        lista.add(3);
        System.out.print(lista);
        lista.unique();
        System.out.print(lista);
        System.out.println("Limpando a lista... "  );lista.clear();
        System.out.println("Lista agora deve estar vazia. Tamanho da lista: " + lista.size());
        */
    }
}
