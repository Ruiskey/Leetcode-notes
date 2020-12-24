package DS;
import java.util.NoSuchElementException;


public class SingleLinkedList<E> {
    /**
     * 链表头节点
     */
    private Node<E> head;

    /**
     * 构造方法：创建空链表
     * @param void
     */
    public SingleLinkedList() {
        this.head = new Node<E>();
    }

    /**
     * 向链表头部添加一个新的元素（头插法）。
     * @param element
     * @return void
     */
    public void addFirst(E element) {
        Node<E> node = new Node<E>(element, null);
        node.setNext(head.getNext());
        head.setNext(node);
    }

    /**
     * 向链表尾部添加一个新的元素（尾插法）。
     * @param element
     * @return void
     */
    public void addLast(E element) {
        Node<E> node = new Node<E>(element, null);
        Node<E> tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        tail.setNext(node);
    }

    /**
     * 取得链表头部第一个元素，链表为空则抛出异常。
     * @param void
     * @return First element of {@code LinkedList}.
     * @throws NoSuchElementException if this {@code LinkedList} is empty.
     */
    public E getFirst() throws NoSuchElementException {
        if (head.getNext() == null) {
            throw new NoSuchElementException();
        }
        return head.getNext().getElem();
    }

    /**
     * 取得链表尾部最后一个元素，链表为空则抛出异常。
     * @param void
     * @return Last element of {@code LinkedList}.
     * @throws NoSuchElementException if this {@code LinkedList} is empty.
     */
    public E getLast() throws NoSuchElementException {
        Node<E> tail = head;
        while (tail.getNext() != null) {
            tail = tail.getNext();
        }
        if (tail == head) {
            throw new NoSuchElementException();
        }
        return tail.getElem();
    }

    /**
     * 计算链表存储元素数量。
     * @param void
     * @return Size of elements in {@code LinkedList}.
     */
    public int size() {
        int cnt = 0;
        for (Node<E> n = head; n.getNext() != null; n = n.getNext()) {
            ++cnt;
        }
        return cnt;
    }

    /**
     * 检查链表是否为空。
     * @param void
     * @return Boolean {@code true} or {@code false}.
     */
    public boolean isEmpty() {
        return head.getNext() == null ? true : false;
    }

    /**
     * 检查链表是否为空。
     * @param void
     * @return Boolean {@code true} or {@code false}.
     */
    public boolean _isEmpty() {
        return this.size() > 0 ? false : true;
    }

    /**
     * 返回并移除链表头部第一个元素。
     * @param void
     * @return First element of this {@code Linked List}.
     * @throws NoSuchElementException
     */
    public E removeFirst() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> first = head.getNext();
        head.setNext(
                first.getNext()
        );
        return first.getElem();
    }

    /**
     * 返回并移除链表尾部最后一个元素。
     * @param void
     * @return Last element of this {@code Linked List}.
     * @throws NoSuchElementException
     */
    public E removeLast() throws NoSuchElementException {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }
        Node<E> prev = head;
        while (prev.getNext().getNext() != null) {
            prev = prev.getNext();
        }
        Node<E> last = prev.getNext();
        prev.setNext(null);
        return last.getElem();
    }

    /**
     * 检查链表中是否包含目标元素，
     * 元素相等使用 {@code o.equals(obj)} 判断。
     * @param element
     * @return Boolean
     */
    public boolean contains(E element) {
        for (Node<E> current = head.getNext();
             current != null;
             current = current.getNext()) {
            if (element.equals(current.getElem())) {
                return true;
            }
        }
        return false;
    }

    /**
     * 返回指定元素所在链表的索引。
     * @param element
     * @return The index of element in {@code LinkedList},
     *  return {@code -1} if element does not found.
     */
    public int indexOf(E element) {
        int index = 0;
        for (Node<E> current = head.getNext();
             current != null;
             current = current.getNext()) {
            if (element.equals(current.getElem())) {
                return index;
            }
            ++index;
        }
        return -1;
    }

    /**
     * 获取链表指定索引的元素。
     * @param index
     * @return element
     * @throws IndexOutOfBoundsException
     */
    public E get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = head.getNext();
        while (index > 0) {
            n = n.getNext();
            --index;
        }
        return n.getElem();
    }

    /**
     * 为链表指定索引位置的元素设新值。
     * @param index
     * @param element
     * @return Previous element in the index.
     * @throws IndexOutOfBoundsException
     */
    public E set(int index, E element) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> n = head.getNext();
        while (index > 0) {
            n = n.getNext();
            --index;
        }
        E oldValue = n.getElem();
        n.setElem(element);
        return oldValue;
    }

    /**
     * 移除链表指定索引下标元素。
     * @param index
     * @return Removed element
     * @throws IndexOutOfBoundsException
     */
    public E remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size()) {
            throw new IndexOutOfBoundsException();
        }
        index -= 1;
        Node<E> prev = head;
        while (index >= 0) {
            prev = prev.getNext();
            --index;
        }
        Node<E> current = prev.getNext();
        Node<E> next = current.getNext();
        prev.setNext(next);
        return current.getElem();
    }

    /**
     * 移除链表指定元素，
     * 操作成功返回{@code true}，不存在目标元素则返回{@code false}。
     * @param element
     * @return Boolean
     */
    public boolean remove(E element) {
        int index = indexOf(element);
        return index == -1 ?
                false : element.equals(remove(index));
    }

    /**
     * 向列表指定位置插入一个新的元素。
     * @param index
     * @param element
     * @return Previous element
     * @throws IndexOutOfBoundsException
     */
    public E insert(int index, E element)
            throws IndexOutOfBoundsException {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException();
        }
        index -= 1;
        Node<E> prev = head;
        while (index >= 0) {
            prev = prev.getNext();
            --index;
        }
        Node<E> current = prev.getNext();
        Node<E> node = new Node<E>(element, null);
        node.setNext(current);
        prev.setNext(node);
        return current == null ? null : current.getElem();
    }

    /**
     * 清空链表。
     * @param void
     * @return void
     */
    public void clear() {
        while (head != null) {
            Node<E> n = head;
            head = head.getNext();
            n.setElem(null);
            n.setNext(null);
        }
        head = new Node<E>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (Node<E> current = head.getNext();
             current != null;
             current = current.getNext()) {
            sb.append(current.getElem().toString());
            sb.append(", ");
        }
        sb.append(']');
        return sb.toString();
    }
}
