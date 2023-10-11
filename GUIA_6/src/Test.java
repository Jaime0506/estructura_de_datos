public class Test {
    public static void main(String[] args) {
        CircularList list = new CircularList();

        // .add sin argumento agregar al final
        // .add con argumento lo agrega en el index indicado

        // .remove sin argumento elimina el ultimo Nodo
        // .remove con argumento elimina el Nodo de acuerod al index indicado

        // getNode con index como argumento devuelve el Nodo con sus respectivos atributos Link, Value

        list.add(3);
        list.add(0, 6);
        list.add(0, 4);
        list.add(0, 2);
        list.add(0, -2);
        list.add(0, 1);
        list.add(0, 6);
        list.add(0, 7);
        list.update(2, 8);
        list.update(0, 10);

        list.show();
        list.order();
        
        list.getNodeByIndex(7);
    }
}
