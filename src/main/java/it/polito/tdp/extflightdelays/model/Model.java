package it.polito.tdp.extflightdelays.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.extflightdelays.db.ExtFlightDelaysDAO;

public class Model {
	
	private Graph<Airport, DefaultWeightedEdge> grafo;
	private ExtFlightDelaysDAO dao;
	private Map<Integer, Airport> airports;
	private List<Arco> edges;
	
	public Model() {
		dao = new ExtFlightDelaysDAO();
		airports = new HashMap<>();
		edges = new ArrayList<>();
	}
	
	public Graph<Airport, DefaultWeightedEdge> creaGrafo(int distanzaMinima) {
		grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		
		dao.loadAllAirports(airports);
		
		//Aggiungo i vertici
		
		Graphs.addAllVertices(this.grafo, airports.values());
		
		List<Arco> adiacenze = dao.getAdiacenze();
		
		for(Arco a : adiacenze) {
			if(a.getPeso()>distanzaMinima) {
				Graphs.addEdge(this.grafo, airports.get(a.getOriginAirId()), airports.get(a.getDestinationAirId()), a.getPeso());
				edges.add(a);
			}
		}
		
		return grafo;
		
	}
	
	public List<Arco> getEdges(){
		return this.edges;
	}

	public Map<Integer, Airport> getAirports(){
		return airports;
	}
}
