using ds.MultiLevelListNode;

/*
	Definition of MultiLevelListNode:
	class MultiLevelListNode
	{
		public MultiLevelListNode(
			int val, MultiLevelListNode next = null, MultiLevelListNode child = null)
		{
			Val = val;
			Next = next;
			Child = child;
		}

		public int Val { get; set; }

		public MultiLevelListNode Next { get; set; }
		
		public MultiLevelListNode Child { get; set; }
	}
*/

public class Solution
{
	public MultiLevelListNode FlattenMultiLevelList(MultiLevelListNode head)
	{
		if (head == null)
			return null;

		MultiLevelListNode tail = head;

		// Find the tail of the linked list at the first level.
		while (tail.Next != null)
			tail = tail.Next;

		MultiLevelListNode curr = head;

		// Process each node at the current level. If a node has a child linked list,
		// append it to the tail and then update the tail to the end of the extended
		// linked list. Continue until all nodes at the current level are processed.
		while (curr != null)
		{
			if (curr.Child != null)
			{
				tail.Next = curr.Child;

				// Disconnect the child linked list from the current node.
				curr.Child = null;
				while (tail.Next != null)
					tail = tail.Next;
			}
			
			curr = curr.Next;
		}

		return head;
	}
}
