public class Test {
    public static void main(String[] args) {
        CircularList list = new CircularList();
        
        // .add sin argumento agregar al final
        // .add  con argumento lo agrega en el index indicado

        // .remove sin argumento elimina el ultimo Nodo
        // .remove con argumento elimina el Nodo de acuerod al index indicado

        // get con arumento devuelve el Nodo con sus respectivos atributos Link, Value

        list.add(5);
        list.add(6);
        list.add(1);

        list.add(0, 7);
        list.add(3, 2);
        list.add(3);
        
        list.remove();
        list.remove(1);
        list.remove(2);

        list.show();
    }
}
