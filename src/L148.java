public class L148 {
    /**
     * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
     */
    public static void main(String[] args) {

        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        L148 l148 = new L148();
        ListNode listNode = l148.sortList(node1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
        System.out.println("======================");
    }

    /**
     * 使用归并排序对链表进行排序
     *
     * @param head 需要排序的链表的头节点
     * @return 排序后的链表的头节点
     */
    public ListNode sortList(ListNode head) {
        // 如果链表为空或只有一个节点，则已经排序，直接返回
        if (head == null || head.next == null)
            return head;

        // 初始化快慢指针，快指针从头节点的下一个节点开始，慢指针从头节点开始
        ListNode fast = head.next, slow = head;
        // 使用快慢指针找到链表的中间节点
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 将链表从中间节点分成两半
        ListNode tmp = slow.next;
        slow.next = null;

        // 递归排序左右两半链表
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 创建一个哑节点，用于构建排序后的链表
        ListNode h = new ListNode(0);
        ListNode res = h;

        // 合并两个排序的链表
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }

        // 将剩余的节点接到链表末尾
        h.next = left != null ? left : right;

        // 返回排序后的链表的头节点
        return res.next;
    }



    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
