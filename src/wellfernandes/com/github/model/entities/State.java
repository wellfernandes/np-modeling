package wellfernandes.com.github.model.entities;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import org.graphstream.graph.Graph;

public class State implements Serializable {

	private static final long serialVersionUID = 1L;
	private String nameState;
	private List<String> transitions = new LinkedList<>();
	private Graph graph;

	public State() {

	}

	public State(String nameState, List<String> transitions, Graph graph) {
		super();
		this.nameState = nameState;
		this.transitions = transitions;
		this.graph = graph;
	}

	public String getNameState() {
		return nameState;
	}

	public void setNameState(String nameState) {
		this.nameState = nameState;
	}

	public Graph getGraph() {
		return graph;
	}

	public void setGraph(Graph graph) {
		this.graph = graph;
	}

	public List<String> getTransitions() {
		return transitions;
	}
}