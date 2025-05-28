using ds.ListNode;

/*
	Definition of ListNode:
	class ListNode
	{
		public ListNode(int val, ListNode next = null)
		{
			Val = val;
			Next = next;
		}

		public int Val { get; set; }

		public ListNode Next { get; set; }
	}
*/

public class Solution
{
	public ListNode LinkedListReversalRecursive(ListNode head)
	{
		// Base cases.
		if (head == null || head.Next == null)
			return head;

		// Recursively reverse the sublist starting from the next node.
		ListNode newHead = LinkedListReversalRecursive(head.Next);

		// Connect the reversed linked list to the head node to fully reverse the entire linked list.
		head.Next.Next = head;
		head.Next = null;

		return newHead;
	}
}
