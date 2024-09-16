/**
 * Classe que implementa uma lista linear usando arranjo.
 * @author Isabel H. Manssour, Luan Garcia, Daniel Frantz
 */

 public class ListOrdArray {

    // Atributos
    private static final int TAM_DEFAULT = 10;
    private Integer[] data;
    private int count;

    /**
     * Construtor da lista.
     */
    public ListOrdArray() {
        this(TAM_DEFAULT);
    }

    /**
     * Construtor da lista.
     * @param tam tamanho inicial a ser alocado para data[]
     */
    public ListOrdArray(int tam) {
        if (tam <= 0) {
            tam = TAM_DEFAULT;
        }
        data = new Integer[tam];
        count = 0;
    }

    /*
     * Método para imprimir a lista como uma string.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int pos = 0; pos < count; pos++)
            sb.append(data[pos]).append(" ");
        sb.append("]");
        return sb.toString();
    }

    /**
     * Retorna o numero de elementos armazenados na lista.
     * @return o numero de elementos da lista
     */
    public int size() {
        return count ;
    }

    /**
     * Adiciona um elemento ao final da lista.
     * @param element elemento a ser adicionado ao final da lista
     */
    public void add(Integer element) {
        if(count<data.length){
            data[count]=element;
            count++;
        }

    }

    /**
     * Adiciona um elemento na posicao passada como parametro.
     * @param index
     * @param element
     */
    public void add(int index, Integer element)
    {
        int salvo;
        if(index<=count && index>=0 && index<data.length){
            for(int i=index;i<data.length;i++){
                salvo=data[i];
                data[i]=element;
                element=salvo;
                count++;
            }
        }
    }

    /**
     * Retorna o elemento de uma determinada posicao da lista.
     * @param index a posicao da lista
     * @return o elemento da posicao especificada
     */
    public int get(int index) {
        if(index>=0 && index<count){
            return data[index];
        }
        else{
            return -1;
        }
    }

    /**
     * Esvazia a lista.
     */
    public void clear() {
        for(int i=data.length-1;i>-1;i--){
            data[i]=0;
            count=0;
        }
    }

    /**
     * Retorna true se a lista nao contem elementos.
     * @return true se a lista nao contem elementos
     */
    public boolean isEmpty() {
        if(count==0){
            return true;
        }
        else return false;
    }

    /**
     * Retorna a posição na qual está armazenado o valor passado por parâmetro.
     * @param element O elemento a ser procurado
     * @return A posição do elemento na lista ou -1 caso não esteja na lista.
     */
    public int indexOf(Integer element)
    {
        for(int i=0;i<count;i++){
            if(data[i]==element){
                return i;
            }
            
        }
        return -1;
    }

    /**
     * Procura e remove o primeiro elemento com valor passado como 
     * parâmetro no array.
     * @param element o elemento a ser removido
     * @return true caso tenha sido removido, false caso não tenha removido
     */
    public boolean remove(Integer element){
        for(int i=0;i<count;i++){
            if(element==data[i]){
                for(int j=i;j>count-1;j++){
                    data[j]=data[j+1];
                }
                count--;
                return true;    
            }
        }
        return false;



    }

    /**
     * Substitui o elemento armazenado em uma determinada posicao da lista pelo
     * elemento passado por parametro, retornando o elemento que foi substituido.
     * @param index a posicao da lista
     * @param element o elemento a ser armazenado na lista
     * @return o elemento armazenado anteriormente na posicao da lista
     */
     public int set(int index, Integer element) {
       if(index>=count){
       return -1;}
       else{
           int nroOriginal=data[index];
           data[index]=element;
           return nroOriginal;}
       }

   /**
    * Procura pelo elemento passado por parametro na lista e retorna true se a 
    * lista contem este elemento.
    * @param element o elemento a ser procurado
    * @return true se a lista contem o elemento passado por parametro
    */
   public boolean contains(Integer element) {
       for(int i=0;i<count;i++){
           if(data[i]==element){
               return true;
           }
       }
       return false;
   }


   /**
    * Este método recebe como parâmetro um valor inteiro e modifica o tamanho
   máximo da lista para o valor recebido. Analise a complexidade do método e
   acrescente a notação O como comentário no código fonte junto da assinatura do
   método. Tem complexidade Linear
    */
   public void setCapacity(int tamNovo){
       if(tamNovo>=count){
           Integer[] dataNovo=new Integer[tamNovo];
           for(int i=0;i<count;i++){
               dataNovo[i]=data[i];
           }
           data=dataNovo;
           return;
       }
       else if(tamNovo<count){
           count=tamNovo;
           Integer[] dataNovo=new Integer[tamNovo];
           for(int i=0;i<tamNovo;i++){
               dataNovo[i]=data[i];
           }
           data=dataNovo;
           return;
       }
   }

   /**Acrescente na classe ListArray o seguinte método: public void reverse(). Este
   método deve inverter o conteúdo da lista. Teste a sua implementação para este
   método na classe App. Analise a complexidade do método e acrescente a
   notação O como comentário no código fonte junto da assinatura do método. Complexidade-Linear*/
   public void reverse(){
       Integer reserva;
       int head=0;
       if(count%2==1){
           for(int i=count-1;i>count/2;i--){
               reserva=data[head];
               data[head]=data[i];
               data[i]=reserva;
               head++;
           }
        }
        else if(count%2==0){
            for(int i=count-1;i>=count/2;i--){
                reserva=data[head];
                data[head]=data[i];
                data[i]=reserva;
                head++;
            }
        }
    }
}
