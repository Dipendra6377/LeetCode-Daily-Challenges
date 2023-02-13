//{ Driver Code Starts
//Initial Template for Java


import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = null;
		right = null;
	}
}

class GfG {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t > 0) {
			String s = br.readLine();
			int target = Integer.parseInt(br.readLine());
			Node root = buildTree(s);

			Solution g = new Solution();
			System.out.println(g.minTime(root, target));
			t--;

		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static int findTreeBurnTime(HashMap<Node,Node> map,Node target){
        Queue<Node> q=new LinkedList<>();
        q.offer(target);
        HashMap<Node,Boolean> vis = new HashMap<>();
        int time=0;
        
        while(!q.isEmpty()){
            int size=q.size();
            int flag=0;
            
            for(int i=0;i<size;i++){
                Node node = q.poll();
                
                if(node.left!=null && vis.get(node.left)==null){
                    flag=1;
                    vis.put(node.left,true);
                    q.offer(node.left);
                }
                
                if(node.right!=null && vis.get(node.right)==null){
                    flag=1;
                    vis.put(node.right,true);
                    q.offer(node.right);
                }
                
                if(map.get(node)!=null && vis.get(map.get(node))==null){
                    flag=1;
                    vis.put(map.get(node),true);
                    q.offer(map.get(node));
                }
            }
            if(flag==1){
                time++;
            }
        }
        return time;
    }
    public static Node mapchildToparent(Node root,HashMap<Node,Node> map,int target){
        Queue<Node> q=new LinkedList<>();
        q.offer(root);
        Node res=null;
        while(!q.isEmpty()){
            Node curr=q.poll();
            if(curr.data==target) res=curr;
            if(curr.left!=null){
                map.put(curr.left,curr);
                q.offer(curr.left);
            }
            
            if(curr.right!=null){
                map.put(curr.right,curr);
                q.offer(curr.right);
            }
        }
        return res;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        
        HashMap<Node,Node> map=new HashMap<>();
        Node start=mapchildToparent(root,map,target);
        int time =findTreeBurnTime(map,start);
        return time;
    }
}