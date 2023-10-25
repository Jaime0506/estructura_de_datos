package orderTree;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node add(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (current.value > value) {
            // Si mi nodo actual es mayor que el que quiero agregar va a la izquierda,
            current.childLeft = add(current.childLeft, value);
        } else {
            // Si es mayor el valor respecto a mi nodo actual, lo mando a la derecha
            current.childRight = add(current.childRight, value);
        }

        return current;
    }

    public void in_order() {
        in_order(root);
    }

    private void in_order(Node current) {
        if (current != null) {
            in_order(current.childLeft);
            System.out.println(current.value);
            in_order(current.childRight);
        }
    }

    public void pre_order() {
        pre_order(root);
    }

    private void pre_order(Node current) {
        if (current != null) {
            System.out.println(current.value);
            pre_order(current.childLeft);
            pre_order(current.childRight);
        }
    }

    public void post_order() {
        post_order(root);
    }

    private void post_order(Node current) {
        if (current != null) {
            post_order(current.childLeft);
            post_order(current.childRight);
            System.out.println(current.value);
        }
    }

    public static void main(String[] args) {
        
        // Funciones que debe tener
        // a. Crear un Nodo. ✅
        // b. Crear un árbol binario. ✅
        // c. Insertar datos en el árbol. ✅
        // d. Buscar un nodo 
        // e. Borrado de un nodo
        // f. Recorrer un árbol binario: in-orden, pre-orden y post-orden ✅

        BinaryTree tree = new BinaryTree();

        tree.add(45);
        tree.add(30);
        tree.add(50);

        tree.in_order();

        System.out.println();

        tree.pre_order();

        System.out.println();

        tree.post_order();
    }
}
