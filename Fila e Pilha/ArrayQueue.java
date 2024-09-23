
public class ArrayQueue {
        private static int TAM_DEFAULT=8; //Tamanho padrão de uma fila
        private Integer[] data;
        private int count;
        /**
        * Construtor da lista.
        */
        public ArrayQueue() {
                this(TAM_DEFAULT);
        }

        /**
         * Construtor da lista.
         * @param tam tamanho inicial a ser alocado para data[]
         */
        public ArrayQueue(int tam) {
                if (tam <= 0) {
                tam = TAM_DEFAULT;
                }
                data = new Integer[tam];
                count = 0;
        }
        /**
         * Adiciona um elemento no final da fila.
         * @param element
         */
        public void enqueue(int element){
            if(count==data.length){
                Integer[] replaceData= new Integer[data.length+1];
                for(int i=0;i<replaceData.length;i++){
                        if(i>data.length){
                                replaceData[i]=data[i];
                        }
                        else{
                                replaceData[i]=element;
                                count++;
                        }
                }data=replaceData;
            }
            else{
                data[count]=element;
                count++;
            }
        }
    
        /**
         * Remove o elemento no início da fila e retorna ele.
         * @return O elemento que estava no início da fila.
         */
        public int dequeue(){
                data[0]=
        }
    
        /**
         * @return O tamanho da fila.
         */
        public int size(){

        }
    
        /**
         * @return true se a fila estiver vazia, false caso contrário.
         */
        public boolean isEmpty(){

        }
    
        /**
         * Remove todos elementos da fila.
         */
        public void clear(){

        }
    
        /**
         * Retorna o elemento no início da fila, sem removê-lo.
         * @return O primeiro elemento da fila.
         */
        public int head(){

        }





}
    

