package it.unibo.oop.lab06.generics1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {

	/*
	 * Each node is stored into a Map<N, List<N>> in order to have a list of adjacent nodes for each node
	 * */
	
	private final Map<N, List<N>> graphEdges = new HashMap<>();
	
	@Override
	public void addNode(N node) {
		if(node != null && this.graphEdges.get(node) == null) {
			this.graphEdges.put(node, new LinkedList<N>());
		}
	}

	@Override
	public void addEdge(N source, N target) {
		if(source != null && target != null && !this.graphEdges.get(source).contains(target)) {
			this.graphEdges.get(source).add(target);
		}
	}

	@Override
	public Set<N> nodeSet() {
		return graphEdges.keySet();
	}

	@Override
	public Set<N> linkedNodes(N node) {
		Set<N> resultSet = new HashSet<N>();
		
		if(node != null && this.graphEdges.containsKey(node)) {
			for(N elem : this.graphEdges.get(node)) {
				resultSet.add(elem);
			}
		}
		
		return resultSet;
	}

	@Override
	public List<N> getPath(N source, N target) {
		
		List<N> path = new ArrayList<N>();
		
		if(source != null && target != null && this.graphEdges.containsKey(source)) {
			path = findPath(source, target);
		}
		
		return path;
	}
	
	private List<N> findPath(N source, N target) {
		
		Queue<N> queue = new ArrayDeque<>();
		Set<N> visited = new HashSet<>();
		Map<N, N> parentMap = new HashMap<>(); //child - parent
		
		//adding source to Q
		
		queue.add(source);
		visited.add(source);
		
		while(!queue.isEmpty()) {
			N vertex = queue.poll();
			
			
			if(vertex.equals(target)) {
				break;
			}
			
			
			for(N elem : this.graphEdges.get(vertex)) {
				if(!visited.contains(elem)) {
					queue.add(elem);
					visited.add(elem);
					parentMap.put(elem, vertex);
				}
			}
			
		}
		
		
		List<N> resultPath = new LinkedList<N>();
		resultPath.add(target);
		N temp = target;
		
		while((temp = parentMap.get(temp)) != source) {
			resultPath.add(temp);
		}
		
		resultPath.add(source);
		Collections.reverse(resultPath);
		
		return resultPath;
		
	}

	
	
}
