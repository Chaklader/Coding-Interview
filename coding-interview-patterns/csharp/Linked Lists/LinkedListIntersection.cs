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
	public ListNode LinkedListIntersection(ListNode headA, ListNode headB)
	{
		ListNode ptrA = headA;
		ListNode ptrB = headB;

		// Traverse through list A with 'ptrA' and list B with 'ptrB' until they meet.
		while (ptrA != ptrB)
		{
			// Traverse list A -> list B by first traversing 'ptrA' and
			// then, upon reaching the end of list A, continue the 
			// traversal from the head of list B.
			ptrA = ptrA != null ? ptrA.Next : headB;

			// Simultanously, traverse list B -> list A.
			ptrB = ptrB != null ? ptrB.Next : headA;
		}

		// At this point, 'ptrA' and 'ptrB' either point to the 
		// intersection node or both are null if the lists do not 
		// intersect. Return either pointer.
		return ptrA;
	}
}
