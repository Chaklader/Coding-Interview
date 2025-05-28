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
	public bool LinkedListLoopNaive(ListNode head)
	{
		ISet<ListNode> visited = new HashSet<ListNode>();
		ListNode curr = head;

		while (curr != null)
		{
			//Cycle detected if the current node has already been visited.
			if (visited.Contains(curr))
				return true;

			visited.Add(curr);
			curr = curr.Next;
		}

		return false;
	}
}