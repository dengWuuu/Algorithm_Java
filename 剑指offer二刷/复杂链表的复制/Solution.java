package 剑指offer二刷.复杂链表的复制;

/**
 * @author Wu
 * @date 2023年07月06日 13:35
 * @email dengwu.wu@foxmail.com
 */


// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node cur = head;
        // 所有节点插入一个重复
        while (cur != null) {
            Node newNode = new Node(cur.val);
            Node next = cur.next;
            newNode.next = next;
            cur.next = newNode;
            cur = next;
        }
        cur = head;
        while (cur != null) {
            if (cur.random != null) cur.next.random = cur.random.next;
            cur = cur.next.next;
        }
        // 拆分链表
        cur = head.next;
        Node pre = head;
        Node ans = head.next;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            cur.next = cur.next.next;
            cur = cur.next;
            pre = pre.next;
        }
        pre.next = null;
        return ans;
    }
}
