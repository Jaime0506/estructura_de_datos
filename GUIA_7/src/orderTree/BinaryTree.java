package orderTree;

public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    public void add(int value) {
        // Antes de añadirlo verifico que no exista un nodo con el mismo valor
        if (getNode(root, value) != null) {
            // Si lo que retorna la funcion es diferente a null, significa que ya existe ese
            // nodo,
            // no puedo agregarlo
            System.out.println("No se puede agregar un nodo con el valor de: " + (value)
                    + " porque ya existe un nodo con ese valor");
            return;
        } else {
            root = add(root, value);
        }
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

    public void findNodeByValue(int value) {
        Node current = getNode(root, value);

        if (current == null) {
            System.out.println("El nodo a buscar no existe dentro del arbol");
        } else {
            System.out.println("El nodo ha sido encontrado con valor de " + (current.value));
            current.getChildrends();
        }
    }

    public void deleteNodeByValue(int value) {
        Node nodeToDelete = getNode(root, value);

        if (nodeToDelete != null) {
            Node father = getFather(root, nodeToDelete);

            // Caso 1, sin hijos
            if (nodeToDelete.childLeft == null && nodeToDelete.childRight == null) {
                // si ambos punteros del nodo hacia sus hijos, son nulos, entonces no tiene
                // hijos
                if (father.value > nodeToDelete.value) {
                    father.childLeft = null;
                    System.out.println("Se ha eliminado el nodo: " + (nodeToDelete.value) + " del arbol");
                } else {
                    father.childRight = null;
                    System.out.println("Se ha eliminado el nodo: " + (nodeToDelete.value) + " del arbol");
                }
            }

            // Caso 2, un hijo
            if ((nodeToDelete.childLeft == null && nodeToDelete.childRight != null) || (nodeToDelete.childLeft != null && nodeToDelete.childRight == null)) {
                String message = ("Se ha eliminado el nodo: " + (nodeToDelete.value) + " del arbol ");

                if (father.childLeft == nodeToDelete) {
                    if (nodeToDelete.childLeft != null) {
                        // Es el izquierdo al que debe apuntar el padre del nodo a eliminar
                        father.childLeft = nodeToDelete.childLeft;
                        System.out.print(message);
                        nodeToDelete.getChildrends();
                    } 

                    if (nodeToDelete.childRight != null) {
                        // Es al derecho al que debe apuntar el padre del nodo a liminar
                        father.childLeft = nodeToDelete.childRight;
                        System.out.print(message);
                        nodeToDelete.getChildrends();
                    }
                }

                if (father.childRight == nodeToDelete) {
                    if (nodeToDelete.childLeft != null) {
                        // Es el izquierdo al que debe apuntar el padre del nodo a eliminar
                        father.childRight = nodeToDelete.childLeft;
                        System.out.print(message);
                        nodeToDelete.getChildrends();
                    } 

                    if (nodeToDelete.childRight != null) {
                        // Es al derecho al que debe apuntar el padre del nodo a liminar
                        father.childRight = nodeToDelete.childRight;
                        System.out.print(message);
                        nodeToDelete.getChildrends();
                    }
                }
            }

            // Caso 3, 2 Hijos
        } else {
            System.out.println("El nodo a eliminar no existe");
        }

    }

    private Node getFather(Node root, Node children) {
        Node father = root;

        if (father.childLeft == children) {
            // Encontre al padre del hijo
            return father;
        } else if (father.childRight == children) {
            return father;
        } else {
            if (father.value > children.value) {
                father = getFather(father.childLeft, children);
            } else {
                father = getFather(father.childRight, children);
            }
        }

        return father;
    }

    private Node getNode(Node current, int value) {

        if (current == null) {
            return null;
        }

        if (current.value == value) {
            return current;
        } else {
            if (current.value > value) {
                current = getNode(current.childLeft, value);
            } else {
                current = getNode(current.childRight, value);
            }
        }

        return current;
    }

    public static void main(String[] args) {

        // Funciones que debe tener
        // a. Crear un Nodo. ✅
        // b. Crear un árbol binario. ✅
        // c. Insertar datos en el árbol. ✅
        // d. Buscar un nodo ✅
        // e. Borrado de un nodo

        // Existen 3 cassos para borrar un nodo
        // 3.1. Cuando el nodo a eliminar no tiene hijos ✅
        // 3.2. Cuando el nodo a eliminar tiene 1 hijo
        // 3.3. Cuando el nodo a eliminar tiene 2 hijos

        // f. Recorrer un árbol binario: in-orden, pre-orden y post-orden ✅

        BinaryTree tree = new BinaryTree();

        tree.add(45);
        tree.add(30);
        tree.add(58);
        tree.add(19);
        tree.add(12);
        tree.add(8);
        tree.add(67);
        tree.add(20);
        tree.add(35);
        tree.add(55);
        tree.add(53);
        tree.add(56);
        tree.add(13);
        tree.add(65);
        tree.add(66);
        tree.add(68);

        // tree.in_order();
        tree.deleteNodeByValue(65);
        tree.in_order();
    }
}
