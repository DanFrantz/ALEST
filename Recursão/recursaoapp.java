public class recursaoapp {
    public static void main(String args[]){
        int[] arrayInteiros={2,7,1,1,9};
        RecursivoIterativa rec= new RecursivoIterativa();
        int inverteArray[];
    
        inverteArray=rec.recInverteArray(arrayInteiros);
        for(int i=0;i<inverteArray.length;i++){
            System.out.print("{"+inverteArray[i]+"} ");
        }
    }
}
