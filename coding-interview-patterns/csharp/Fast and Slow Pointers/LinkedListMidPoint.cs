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
	public ListNode LinkedListMidPoint(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;

		// When the fast pointer reaches the end of the list, the slow
		// pointer will be at the midpoint of the linked list.
		while (fast != null && fast.Next != null)
		{
			slow = slow.Next;
			fast = fast.Next.Next;
		}

		return slow;
	}
}