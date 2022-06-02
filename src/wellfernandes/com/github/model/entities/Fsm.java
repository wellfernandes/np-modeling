package wellfernandes.com.github.model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Fsm implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<State> states = new LinkedList<>();
	private List<String> events = new ArrayList<>();
	private State currentState;
	private State lastState;
	private String currentEvent;

	public Fsm() {

	}

	public Fsm(List<State> states, List<String> events, State currentState, State lastState, String currentEvent) {
		super();
		this.states = states;
		this.events = events;
		this.currentState = currentState;
		this.lastState = lastState;
		this.currentEvent = currentEvent;
	}

	public List<State> getStates() {
		return states;
	}

	public void setStates(List<State> states) {
		this.states = states;
	}

	public State getLastState() {
		return lastState;
	}

	public void setLastState(State lastState) {
		this.lastState = lastState;
	}

	public List<String> getEvents() {
		return events;
	}

	public State getCurrentState() {
		return currentState;
	}

	public String getCurrentEvent() {
		return currentEvent;
	}
}
