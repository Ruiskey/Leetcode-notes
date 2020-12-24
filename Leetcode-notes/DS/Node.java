package DS;

class Node<E> {
    /**
     * shujuyu
     */
    private E elem;
    /**
     * zhizhengyu
     */
    private Node<E> next;
    /**
     * gou zao fang fa
     */
    public Node(E element, Node<E> next) {
        this.elem = element;
        this.next = next;
    }
    /**
     * wu can gou zao fang fa
     */
    public Node() {
        this(null, null);
    }
    /* Setter & Getter */
    public void setElem(E element) {
        this.elem = element;
    }
    public E getElem() {
        return this.elem;
    }
    public void setNext(Node<E> next) {
        this.next = next;
    }
    public Node<E> getNext() {
        return this.next;
    }
}