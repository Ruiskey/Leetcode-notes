package DS;

public class LinkedListTest {
    public static void main(String[] args) {
        System.out.println("[INFO]: Test SingleLinkedList() ...");
        SingleLinkedList<String> SList = new SingleLinkedList<String>();
        for (int i = 0; i < 10; ++i) {
            SList.addLast(String.valueOf(i));
        }
        System.out.println(SList);
        System.out.println(
                "SList.size(): " +
                        SList.size()
        );
    }
}
