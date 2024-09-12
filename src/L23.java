public class L23 {
    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     *
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     */
    public static void main(String[] args) {

        L23.ListNode node1 = new L23.ListNode(1);
        L23.ListNode node2 = new L23.ListNode(2);
        L23.ListNode node3 = new L23.ListNode(3);
        L23.ListNode node4 = new L23.ListNode(4);
        L23.ListNode node5 = new L23.ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        L23.ListNode node6 = new L23.ListNode(1);
        L23.ListNode node7 = new L23.ListNode(3);
        L23.ListNode node8 = new L23.ListNode(4);
        node6.next = node7;
        node7.next = node8;
        L23.ListNode node9 = new L23.ListNode(2);
        L23.ListNode node10 = new L23.ListNode(6);
        node9.next = node10;
        L23 l23 = new L23();
        L23.ListNode listNode = l23.mergeKLists(new L23.ListNode[]{node1, node6, node9});
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {

        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) {
            return lists[left];
        }
        int mid = (left + right) / 2;
        return mergeTwoLists(merge(lists, left, mid), merge(lists, mid + 1, right));
    }

    /**
     * 合并两个有序链表
     * 将两个升序排序的链表合并为一个升序排序的链表
     * 合并后的链表依然保持升序排序
     *
     * @param merge  第一个有序链表
     * @param merge1 第二个有序链表
     * @return 合并后的有序链表头节点
     */
    private ListNode mergeTwoLists(ListNode merge, ListNode merge1) {
        // 如果第一个链表为空，则直接返回第二个链表作为合并后的链表
        if (merge == null) {
            return merge1;
        }
        // 如果第二个链表为空，则直接返回第一个链表作为合并后的链表
        if (merge1 == null) {
            return merge;
        }
        // 如果第一个链表的当前节点值小于第二个链表的当前节点值，则将第一个链表的下一个节点与第二个链表合并
        if (merge.val < merge1.val) {
            merge.next = mergeTwoLists(merge.next, merge1);
            return merge;
        } else {
            // 否则，将第二个链表的下一个节点与第一个链表合并
            merge1.next = mergeTwoLists(merge, merge1.next);
            return merge1;
        }
    }

    public static class ListNode {
        int val;
        L23.ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, L23.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
