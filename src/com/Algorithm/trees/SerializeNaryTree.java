package com.Algorithm.trees;

import java.util.ArrayList;
import java.util.List;

public class SerializeNaryTree {

	public static void main(String[] args) {
		
		List<NaryNode> list = new ArrayList<NaryNode>();
	    list.add(new NaryNode(3));
	    list.add(new NaryNode(2));
	    list.add(new NaryNode(4));
	    NaryNode node = new NaryNode(1, list);
	    System.out.println(serialize(node));
	}

	public static String serialize(NaryNode node) {
		StringBuilder sb = new StringBuilder();
		if (node == null)
			return sb.toString();
		serialize(node, sb);

		return sb.toString();
	}

	public static void serialize(NaryNode node, StringBuilder sb) {
		if (node == null) {
			sb.append("#");
			return;
		}

		sb.append((char)(node.val + '0'));
		for (NaryNode child : node.children) {
			serialize(child, sb);
		}
	}
	
	public static NaryNode Deserialize(String data) {
		if(data == null) return null;
		
		return Deserialize(data, new int[1]);
	}
	
	public static NaryNode Deserialize(String data, int []idx) {
		if(idx[0] == data.length()) return null;
		
		NaryNode node = new NaryNode(data.charAt(idx[0]) - '0', new ArrayList<NaryNode>());
		idx[0]++;
		while(data.charAt(idx[0]) != '#') {
			node.children.add(Deserialize(data, idx));
		}
		idx[0]++;
	 return node;
	}
}
