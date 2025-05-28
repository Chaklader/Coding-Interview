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
	public bool LinkedListLoop(ListNode head)
	{
		ListNode slow = head;
		ListNode fast = head;

		// Check both 'fast' and 'fast.Next' to avoid null pointer
		// exceptions when we perform 'fast.Next' and 'fast.Next.Next'.
		while (fast != null && fast.Next != null)
		{
			slow = slow.Next;
			fast = fast.Next.Next;

			if (fast == slow)
				return true;
		}

		return false;
	}
}