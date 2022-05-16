package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1991 {

	/**
	 * 문제
	 * 이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하라.
	 *  - 이진 트리의 노드의 개수 N(1 ≤ N ≤ 26)
	 *  - 노드의 이름은 A부터 차례대로 알파벳 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 
	 *  - 자식 노드가 없는 경우에는 .으로 표현
	 * 
	 * => 문자열 비교 시 == 이 아닌 equlas() 사용 잊지말기!
	 * 
	 * 시간 : 80 ms
	 * 메모리 : 11596 kb
	 */
	
	private static class Node {
		String vertex;
		Node left, right;
		
		public Node(String vertex) {
			this.vertex = vertex;
			this.left = null;
			this.right = null;
		}
	}
	
	private static class Tree {
		private Node root;
		
		public Tree(String main, String left, String right) {
			root = new Node(main);
			if (!left.equals(".")) root.left = new Node(left);
			if (!right.equals(".")) root.right = new Node(right);
		}
		
		public void addNode(String main, String left, String right) {
			// main을 가진 부모 노드를 찾으로 탐색을 진행한다.
			searchNode(root.left, main, left, right);
			searchNode(root.right, main, left, right);
		}
		
		public void searchNode(Node node, String main, String left, String right) {
			// 기저조건 : 더 이상 탐색할 수 없는 경우
			if (node == null) return ;
			
			if (node.vertex.equals(main)) {
				// main을 가진 부모 노드를 찾았다면 자식 노드 추가
				if (!left.equals(".")) node.left = new Node(left);
				if (!right.equals(".")) node.right = new Node(right);
			} else {
				// main을 가진 부모 노드 찾기 위해 왼쪽, 오른쪽으로 탐색 진행
				searchNode(node.left, main, left, right);
				searchNode(node.right, main, left, right);
			}
		}
		
		// 전위 순회 (루트) (왼쪽 자식) (오른쪽 자식)
		public void preOrder(Node root) {
			if (root != null) {
				System.out.print(root.vertex);
				preOrder(root.left);
				preOrder(root.right);
			}
		}
		
		// 중위 순회 (왼쪽 자식) (루트) (오른쪽 자식)
		public void inOrder(Node root) {
			if (root != null) {
				inOrder(root.left);
				System.out.print(root.vertex);
				inOrder(root.right);
			}
		}
		
		// 후위 순회 (왼쪽 자식) (오른쪽 자식) (루트)
		public void postOrder(Node root) {
			if (root != null) {
				postOrder(root.left);
				postOrder(root.right);
				System.out.print(root.vertex);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int N = Integer.parseInt(br.readLine());
		String[] data = br.readLine().split(" ");
		
		Tree tree = new Tree(data[0], data[1], data[2]);
		
		for (int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			String main = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			
			tree.addNode(main, left, right);
		}
		
		tree.preOrder(tree.root);
		System.out.println();
		tree.inOrder(tree.root);
		System.out.println();
		tree.postOrder(tree.root);
	}

}
