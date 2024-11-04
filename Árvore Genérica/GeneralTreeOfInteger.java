
import java.util.LinkedList;

public class GeneralTreeOfInteger {

    // Classe interna Node
    private class Node {
        // Atributos da classe Node
        public Node parent;
        public Integer element;
        public LinkedList<Node> subtrees;
        // Métodos da classe Node
        public Node(Integer element) {  //Construtor
            parent = null;
            this.element = element;
            subtrees = new LinkedList<>();
        }
     
        private void addSubtree(Node n) {
            n.parent = this;
            subtrees.add(n);
        }
        private boolean removeSubtree(Node n) {
            if(subtrees.contains(n)){
            n.parent = null;
            subtrees.remove(n);
            return true;}
            return false;
        }
        /**
         * Retorna a sub-árvore da iésima posição da lista de sub-árvores
         * @param i índice da sub-árvore desejada
         * @return nodo raíz da sub-árvore desejada
         */
        public Node getSubtree(int i) {
            if ((i < 0) || (i >= subtrees.size())) {
                throw new IndexOutOfBoundsException();
            }
            return subtrees.get(i);
        }
        public int getSubtreesSize() {
            return subtrees.size();
        }
    }

    
    
    // Atributos da classe GeneralTreeOfInteger
    private Node root;
    private int count; //número de nodos na árvore

    
    
    // Metodos da classe GeneralTreeOfInteger
    
    /**
     * Metodo construtor.
     */
    public GeneralTreeOfInteger() {
        root = null;
        count = 0;
    }
    
    /**
     * Retorna o numero total de elementos da árvore.
     * @return count
     */
    public int size() {
        return count;
    }
    
    // Procura por "elem" a partir de "n" seguindo um
    // caminhamento pre-fixado. Retorna a referencia
    // para o nodo no qual "elem" esta armazenado.
    // Se não encontrar "elem", ele retorna NULL.
    private Node searchNodeRef(Integer elem, Node n) {
        if (n == null)
            return null;
        
        // Visita a raiz
        if (elem.equals(n.element))
            return n;
        
        // Visita os filhos
        Node aux = null;
        for (int i=0; i<n.getSubtreesSize(); i++) {
            aux = searchNodeRef(elem, n.getSubtree(i)); //chamada recursiva
            if (aux != null)//Se o retorno de searchNodeRef é diferente de null ele é igual ao element
                return aux;
        }
        return aux;//Se acabar o for sem encontrar nada retorna o aux, que vai ser null 
        //já que o getSubtree vai dar null, pois não vai ter mais nenhuma SubTree
    }
    
    
    /**
     * Adiciona elem como filho de elemFather. Caso elemFather seja nulo adiciona elem como raiz.
     * @param elem elemento a ser adicionado na arvore.
     * @param elemFather pai do elemento a ser adicionado.
     * @return true se encontrou elemFather e adicionou elem na arvore ou se adicionou como raiz,
     * false caso contrario.
     */
    public boolean add(Integer elem, Integer elemFather) {
        // Primeiro cria o nodo
        Node newNode= new Node(elem);
        if(elemFather==null && this.size()==0){
            root=newNode;
            count++;
            return true;
        }
        if(elemFather==null && this.size()>0){
            root.parent=newNode;
            newNode.addSubtree(root);
            root=newNode;
            return true;
        }
        if(elemFather!=null){
        Node fatherNode=searchNodeRef(elemFather, root);
        fatherNode.addSubtree(newNode);
        count++;
        return true;}
        return false;
    }
    

    /**
     * Verifica se elem esta ou não na arvore.
     * @param elem a ser procurado.
     * @return true se achar elem, e false caso contrario.
     */
    public boolean contains (Integer elem) {
        // IMPLEMENTE ESTE METODO !!
        if(searchNodeRef(elem, root)!=null){
            return true;
        }
        return false;
    }
    
    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento em largura.
     * @return lista com os elementos da arvore na ordem do caminhamento em largura
     */
    public LinkedList<Integer> positionsWidth() {
        LinkedList<Integer> lista = new LinkedList<>();
        if (root != null) {
            Queue<Node> fila = new Queue<>(); 
            // Primeiro coloca a raiz na fila
            fila.enqueue(root);
            // Enquanto a fila nao estiver vazia
            while (!fila.isEmpty()) {
                // Retira o nodo da fila
                Node aux = fila.dequeue();
                // Coloca o elemento do nodo na lista
                lista.add(aux.element);
                // Coloca os filhos do nodo na fila
                for (int i=0; i<aux.getSubtreesSize(); i++) {
                    fila.enqueue(aux.getSubtree(i));
                }
            }
        }        
        return lista;
    }    
    

    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pre-fixado.
     * @return lista com os elementos da arvore na ordem do caminhamento pre-fixado
     */    
    public LinkedList<Integer> positionsPre() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPreAux(root,lista);
        return lista;
    }  
    private void positionsPreAux(Node n, LinkedList<Integer> lista) {
        if (n != null) {
            //Visita a raiz
            lista.add(n.element); //adiciona o elemento na lista ANTES de visitar os filhos, PRE-ORDEM
            // Visita os filhos
            for (int i=0; i<n.getSubtreesSize(); i++) {
                positionsPreAux(n.getSubtree(i), lista);
            }       
        }
    }


    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pos-fixado.
     * @return lista com os elementos da arvore na ordem do caminhamento pos-fixado
     */     
    public LinkedList<Integer> positionsPos() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPosAux(root, lista);
        return lista;
    }  
    
    private void positionsPosAux(Node n, LinkedList<Integer> lista) {
        //implemente este método
        for(int i=0;i<n.getSubtreesSize();i++){
            positionsPosAux(n.getSubtree(i), lista);
        }
        lista.add(n.element);
    }    
    

    /**
     * Retorna em que nivel o elem esta armazenado. 
     * @param element a ser buscado
     * @return nivel no qual element esta, ou -1 se 
     * nao encontrou element.
     */
    public int level(Integer element) {
        Node elementNode=searchNodeRef( element, root);
        if(elementNode!=null){
            int count=0;
            while(elementNode.parent!=null){
                elementNode=elementNode.parent;
                count++;
            }
            return count;        
        }
        
        return -1;
        
    }     
    
    
    /**
     * Remove o galho da arvore que tem element na raiz. A 
     * remocao inclui o nodo que contem "element".
     * @param element elemento que sera removido junto com sua 
     * subarvore.
     * @return true se achou element e removeu o galho, false 
     * caso contrario.
     */
    public boolean removeBranch(Integer element) { 
        Node elementNode=searchNodeRef(element, root).parent;
        if(elementNode==null){
            return false;}        
        elementNode.removeSubtree(elementNode);
        return true;

    }

    // Conta o numero de nodos da subarvore cuja raiz é passada por parametro
    private int countNodes(Node n) {
        
        // IMPLEMENTE ESTE METODO !!
        if(n==null){
            return 0;
        }
        int count=1;
        for(int i=0;i<n.getSubtreesSize();i++){
            count++;
        }
        return count;
        
    }    
    
    
    ///////////////////////////////////////////
    // Codigos abaixo geram saida para GraphViz
    
    public void geraNodosDOT(Node n)
    {
        System.out.println("node [shape = circle];\n");
        
        LinkedList<Integer> L = new LinkedList<>();
        L = positionsWidth();

        for (int i = 0; i< L.size(); i++ )
        {
            // node1 [label = "1"]
            System.out.println("node" + L.get(i) + " [label = \"" +  L.get(i) + "\"]") ;
        }
    }

    public void geraConexoesDOT(Node n)
    {
        for (int i=0; i<n.getSubtreesSize(); i++)
        {
            Node aux = n.getSubtree(i);
            System.out.println("node" + n.element + " -> " + "node" + aux.element + ";");
            geraConexoesDOT(aux);
        }
    }
    
    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    public void geraDOT()
    {
        if (root != null) {
            System.out.println("digraph g { \n");
            // node [style=filled];

            geraNodosDOT(root);

            geraConexoesDOT(root);
            System.out.println("}\n");
        }
    }    
}
