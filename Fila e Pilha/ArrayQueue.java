
public class ArrayQueue implements QueueTAD {
        private static int TAM_DEFAULT=8; //Tamanho padrão de uma fila
        private Integer[] data;
        private int count;
        private int tirados=0;
        private int colocados=0;
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
                if(tirados>colocados){//Verifica se tem espaços vazios no array depois de dar dequeue do ínicio
                        data[colocados]=element;
                        colocados++;
                        count++;
                }
                else if(tirados==colocados ){
                int posNovo=0;
                Integer[] replaceData= new Integer[data.length+1];
                for(int i=0+tirados;i<replaceData.length;i++){
                        if(i<data.length){
                                replaceData[posNovo]=data[i];
                                posNovo++;
                        if(i==data.length){
                                for(int j=0;j<colocados;j++){
                                        replaceData[posNovo]=data[j];
                                        posNovo++;
                                }
                        }
                        }else{
                                replaceData[posNovo]=element;
                                count++;
                         }
                }data=replaceData;
                tirados=0;
                colocados=0;
            }
            
        }else{
                data[count]=element;
                count++;
            }
        }
    
        /**
         * Remove o elemento no início da fila e retorna ele.
         * @return O elemento que estava no início da fila.
         */
        public int dequeue(){
                if(tirados<data.length){
                tirados++;
                count--;
                return data[tirados-1];}   
                else{
                        return 0;
                }     
        }
    
        /**
         * @return O tamanho da fila.
         */
        public int size(){
                return count-tirados;
        }
    
        /**
         * @return true se a fila estiver vazia, false caso contrário.
         */
        public boolean isEmpty(){
                if(count==0){
                        return true;
                }
                else{
                        return false;
                }
        }
    
        /**
         * Remove todos elementos da fila.
         */
        public void clear(){
                for(int i=0;i<count;i++){
                        data[i]=0;

                }count=0;
                tirados=0;
        }
    
        /**
         * Retorna o elemento no início da fila, sem removê-lo.
         * @return O primeiro elemento da fila.
         */
        public int head(){
                return data[0+tirados];
        }

        public Integer indexOf(int index){
                return data[index];
        }
     



}
    

