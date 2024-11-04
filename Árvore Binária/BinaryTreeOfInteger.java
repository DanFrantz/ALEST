
import java.util.LinkedList;


/**
 * Classe de arvore binaria de numeros inteiros.
 *
 * @author Isabel H. Manssour
 * @author Luan Fonseca Garcia
 */

public class BinaryTreeOfInteger {

    private static final class Node {

        public Node parent;
        public Node left;
        public Node right;
        private Integer element;

        public Node(Integer element) {
            parent = null;
            left = null;
            right = null;
            this.element = element;
        }
    }

    // Atributos
    private int count; //contagem do número de nodos
    private Node root; //referência para o nodo raiz

    // Metodos
    public BinaryTreeOfInteger() {
        count = 0;
        root = null;
    }

    // Metodo privado que procura por element a partir de target
    // e retorna a referencia para o nodo no qual element esta
    // armazenado. Retorna null se nao encontrar element.
    private Node searchNodeRef(Integer element, Node target) {
        if ( target == null)
            return null;
        // Visita a "raiz"
        if (element.equals(target.element))
            return target; // se achou element na "raiz"
        
        // Visita subarvore da esquerda
        Node aux = searchNodeRef(element, target.left);
        
        // Se nao encontrou, visita a subarvore da direita
        if (aux == null)
              aux = searchNodeRef(element, target.right);
        if(aux==null){
            return null;
        }      
        return aux;
    }
    
    /**
     * Remove todos os elementos da arvore.
     */
    public void clear() {
        //Implementar
        root=null;
    }

    /**
     * Verifica se a arvore esta vazia ou nao.
     *
     * @return true se arvore vazia e false caso contrario.
     */
    public boolean isEmpty() {
        //Implementar
        if(root!=null){
            return false;
        }
        return true;
    }

    /**
     * Retorna o total de elementos da arvore.
     *
     * @return total de elementos
     */
    public int size() {
        //Implementar
        return count;
        
    }

    /**
     * Retorna o elemento armazenado na raiz da arvore.
     *
     * @return elemento da raiz.
     */
    public Integer getRoot() {
       //Implementar
        return root.element;
    }

    /**
     * Retorna o elemento pai do elemento passado por parâmetro.
     *
     * @param element
     * @return pai de element
     */
    public Integer getParent(Integer element) {
     //Implementar
        return searchNodeRef(element, root).parent.element;
    }

    /**
     * Altera o elemento da raiz da árvore.
     *
     * @param element a ser colocado na raiz da árvore.
     */
    public void setRoot(Integer element) {
         // Implementar
         Node newNode=new Node(element);
         if(size()==0){ 
            root=newNode;
         }
         if(root!=null){
        root.element=element;
        }
        
    }

    /**
     * Insere o elemento como raiz da arvore, se a arvore estiver vazia.
     * @param element a ser inserido.
     * @return true se for feita a insercao, e false caso a arvore nao estiver
     * vazia e a insercao não for feita.
     */
    public boolean addRoot(Integer element) {
        //Implementar
        if(size()!=0){
            return false;
        }
        Node newNode=new Node(element);
        root=newNode;
        count++;
        return true;
    }

    /**
     * Insere element a esquerda de parentElement. Se não encontrar parent,
     * ou se parent já tiver um filho à esquerda, element não é
     * inserido.
     *
     * @param element a ser inserido
     * @param parentElement pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrário.
     */
    public boolean addLeft(Integer element, Integer parentElement) {
        // Implementar
        Node fatherNode=searchNodeRef(parentElement, root);
        Node newNode=new Node(element);
        if(fatherNode==null){
            return false;
        }
        if(fatherNode.left!=null){
            return false;
        }
        fatherNode.left=newNode;
        newNode.parent=fatherNode;
        count++;
        return true;
    }

    /**
     * Insere element a direita de parentElement. Se nao encontrar father,
     * ou se father ja tiver um filho a direita, element nao e´ 
     * inserido.
     *
     * @param element a ser inserido
     * @param parentElement pai do elemento a ser inserido
     * @return true se foi feita a inserção, e false caso contrario.
     */
    public boolean addRight(Integer element, Integer parentElement) {
        //ImplementarNode fatherNode=new Node(parentElement);
        Node newNode=new Node(element);
        Node fatherNode=searchNodeRef(parentElement, root);
        if(fatherNode==null){
            return false;
        }
        if(fatherNode.right!=null){
            return false;
        }
        fatherNode.right=newNode;
        newNode.parent=fatherNode;
        count++;
        return true;
    }

    /**
     * Verifica se element esta ou nao armazenado na arvore.
     *
     * @param element
     * @return true se element estiver na arvore, false caso contrario.
     */
    public boolean contains(Integer element) {
        //Implementar
        if(searchNodeRef(element,root)!=null){
            return true;
        }
        return false;

    }

    /**
     * Remove um galho da arvore a partir do elemento recebido por parametro.
     *
     * @param element raiz da subarvore a ser removida.
     * @return true se for feita a remocao.
     * @return false se não tiver na árvore.
     */
    public boolean removeBranch(Integer element) {
        //Implementar
        Node removido=searchNodeRef(element, root);
        if(removido!=null){//Vê se é um elemento na árvore
            count-=countNodes(removido);
            if(removido.parent.left==removido){//Verifica qual dos lados do pai é o que eu quero remover
                removido.parent.left=null;
                return true;
            }
            if(removido.parent.right==removido){
                removido.parent.right=null;
                return true;
            }
            
        }
        return false;
    }

    // Conta o numero de nodos a partir de "n"
    public  int countNodes(Node n) {
        if (n == null) {
            return 0;
        }
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /**
     * Troca um elemento da arvore pelo elemento passado por parametro.
     *
     * @param old elemento a ser encontrado para ser substituido.
     * @param element elemento a ser colocado no lugar de old.
     * @return true se fez a troca, false caso contrario.
     */
    public boolean set(Integer old, Integer element) {
        // Implementar
        Node oldNode=searchNodeRef(old, root);
        if(oldNode!=null){
            oldNode.element=element;
            return true;
        }    
        return false;
    }

    /**
     * Retorna true se element esta armazenado em um nodo externo.(Nodo que não tem filho)
     *
     * @param element
     * @return true se element esta em um nodo externo.
     */
    public boolean isExternal(Integer element) {
        // Implementar
        Node nodoExterno=searchNodeRef(element, root);
        if(nodoExterno.left!=null || nodoExterno.right!=null){
            return false;
        }
        return true;
    }

    /**
     * Retorna true se element esta armazenado em um nodo interno.(O nodo que tem filho)
     *
     * @param element
     * @return true se element esta em um nodo interno.
     */
    public boolean isInternal(Integer element) {
        // Implementar
        Node nodoInterno=searchNodeRef(element, root);
        if(nodoInterno.left!=null || nodoInterno.right!=null){
            return true;
        }
        return false;
    }

    /**
     * Retorna true se element tem um filho a esquerda.
     *
     * @param element
     * @return true se element tem um filho a esquerda, false caso contrario.
     */
    public boolean hasLeft(Integer element) {
        // Implementar
        Node temEsquerda=searchNodeRef(element, root);
        if(temEsquerda.left!=null){
            return true;
        }
        return false;
    }

    /**
     * Retorna true se element tem um filho a direita.
     *
     * @param element
     * @return true se element tem um filho a direita, false caso contrario.
     */
    public boolean hasRight(Integer element) {
         // Implementar
         Node temDireito=searchNodeRef(element, root);
         if(temDireito.right!=null){
             return true;
         }
         return false;
     }

    /**
     * Retorna o filho a esquerda de element.
     *
     * @param element
     * @return o filho a esquerda, ou null se nao tiver filho a esquerda.
     */
    public Integer getLeft(Integer element) {
        // Implementar
        Node pegaEsquerda=searchNodeRef(element, root);
        if(pegaEsquerda.left!=null){
            return pegaEsquerda.left.element;
        }
        return null;
    }

    /**
     * Retorna o filho a direita de element.
     *
     * @param element
     * @return o filho a direita, ou null se nao tiver filho a direita.
     */
    public Integer getRight(Integer element) {
      // Implementar
      Node pegaDireita=searchNodeRef(element, root);
      if(pegaDireita.right!=null){
          return pegaDireita.right.element;
      }
      return null;
  }


    /**
     * Retorna a altura da árvore binária ( O maior nível)
     * @return Altura da árvore
     */
    public int height() {
        // Implementar
        return height(root);       
    }
    private int height(Node nodo){
        
        if(isExternal(nodo.element)){
            return level(nodo.element);
        }
        int esquerda=0;
        if(nodo.left!=null){
            esquerda=height(nodo.left);
        }
        int direita=0;
        if(nodo.right!=null){
            direita=height(nodo.right);
        }
       return Math.max(esquerda, direita);
    }

    /**
     * 
     * @param element em que se deseja saber o nível do nodo
     * @return o nível do nodo que armazena o elemento (O número de arestas até a raiz)
     */
    public int level(Integer element) {
        //Implementar
        Node nodoNivelado=searchNodeRef(element, root);
        if(nodoNivelado==null){
            return -1;
        }

        int count=0;
        while(nodoNivelado.parent!=null){
            count++;
            nodoNivelado=nodoNivelado.parent;//Enquanto o nodo não for a raiz, vai aumentar o nível e
                                             // mudar o nodo pro pai
        }
        return count;
    }

    /**
     * Conta quantos nodos folhas existem na árvore binária.(nodos sem filhos)
     * @return Total de nodos folhas
     */
   public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node nodo){
        if(isExternal(nodo.element)){
            return 1;
        }
        return countLeaves(nodo.right)+countLeaves(nodo.left);
        
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
                if(aux.left!=null)
                    fila.enqueue(aux.left);
                if(aux.right!=null)
                    fila.enqueue(aux.right);
                }
        }    
        return lista;
    }    
    

    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pre-fixado.(Visita o elemento primeiro)
     * @return lista com os elementos da arvore na ordem do caminhamento pre-fixado
     */    
    public LinkedList<Integer> positionsPre() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPreAux(root,lista);
        return lista;
    }  
    private void positionsPreAux(Node n, LinkedList<Integer> lista) {
        //Implemente este método
        lista.add(n.element);
        if(n.left!=null){
            positionsPreAux(n.left,lista);
        }
        if(n.right!=null){
            positionsPreAux(n.right,lista);
        }    
    }


    /**
     * Retorna uma lista com todos os elementos da árvore numa ordem de 
     * caminhamento pos-fixado.(Visita as subarvores primeiro)
     * @return lista com os elementos da arvore na ordem do caminhamento pos-fixado
     */     
    public LinkedList<Integer> positionsPos() {  
        LinkedList<Integer> lista = new LinkedList<>();
        positionsPosAux(root, lista);
        return lista;
    }  
    
    private void positionsPosAux(Node n, LinkedList<Integer> lista) {
        //Implemente este método
        if(n.left!=null){
            positionsPosAux(n.left,lista);
        }
        if(n.right!=null){
            positionsPosAux(n.right, lista);
        }
        lista.add(n.element);
    }    

    // Gera uma saida no formato DOT
    // Esta saida pode ser visualizada no GraphViz
    // Versoes online do GraphViz pode ser encontradas em
    // http://www.webgraphviz.com/
    // http://viz-js.com/
    // https://dreampuf.github.io/GraphvizOnline 
    private void GeraConexoesDOT(Node nodo) {
        if (nodo == null) {
            return;
        }

        GeraConexoesDOT(nodo.left);
        //   "nodeA":esq -> "nodeB" [color="0.650 0.700 0.700"]
        if (nodo.left != null) {
            System.out.println("\"node" + nodo.element + "\":esq -> \"node" + nodo.left.element + "\" " + "\n");
        }

        GeraConexoesDOT(nodo.right);
        //   "nodeA":dir -> "nodeB";
        if (nodo.right != null) {
            System.out.println("\"node" + nodo.element + "\":dir -> \"node" + nodo.right.element + "\" " + "\n");
        }
        //"[label = " << nodo->hDir << "]" <<endl;
    }

    private void GeraNodosDOT(Node nodo) {
        if (nodo == null) {
            return;
        }
        GeraNodosDOT(nodo.left);
        //node10[label = "<esq> | 10 | <dir> "];
        System.out.println("node" + nodo.element + "[label = \"<esq> | " + nodo.element + " | <dir> \"]" + "\n");
        GeraNodosDOT(nodo.right);
    }

    public void GeraConexoesDOT() {
        GeraConexoesDOT(root);
    }

    public void GeraNodosDOT() {
        GeraNodosDOT(root);
    }

    public void GeraDOT() {
        System.out.println("digraph g { \nnode [shape = record,height=.1];\n" + "\n");

        GeraNodosDOT();
        System.out.println("");
        GeraConexoesDOT(root);
        System.out.println("}" + "\n");
    }

}
