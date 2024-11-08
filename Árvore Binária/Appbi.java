/**
 * Classe App.
 * @author Isabel H. Manssour
 * @author Luan Fonseca Garcia
 */

public class Appbi {

    public static void main(String[] args) {
        BinaryTreeOfInteger b = new BinaryTreeOfInteger();
        b.addRoot(1);
        b.addLeft(2, 1);
        b.addRight(3, 1);
        b.addRight(0, 3);
        b.addLeft(4, 2);
        b.addRight(5, 2);
        b.addRight(6, 5);
        b.addRight(7, 6);
        System.out.println("Total de nodos da arvore: " + b.size());

        System.out.println("Caminhamento pos:");
        System.out.println(b.positionsPos());

        System.out.println("Caminhamento em largura:");
        System.out.println(b.positionsWidth());

        System.out.println("Caminhamento pre:");
        System.out.println(b.positionsPre());
        b.removeBranch(5);
        System.out.print(b.size());
        System.out.println("---------------------");
        b.GeraDOT();
    }
}
