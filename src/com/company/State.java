package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class State {

  private BusStop busStop;

  private State parent;

  private double cost;

  public State() {
  }

  public State(BusStop busStop) {
    this.busStop = busStop;
    this.cost = 0;
    this.parent = null;
  }

  public State newState(BusStop busStop, Transportaion transportaion) {

    State newState = new State();
    newState.setBusStop(busStop);
    if (transportaion == transportaion.WALKING) {
      newState.setCost(this.cost + this.busStop.distanceFrom(busStop) / 4);
    } else
      newState.setCost(this.cost + this.busStop.distanceFrom(busStop) / 40);
    return newState;
  }

  public List<State> possibleNextStates(Graph graph) {
    List<State> ret = new ArrayList<>();
    List<BusStop> sorted = graph.getConnections().keySet().stream()
        .sorted((stop1, stop2) -> Double.compare(this.busStop.distanceFrom(stop1), this.busStop.distanceFrom(stop2)))
        .collect(Collectors.toList());

    //todo
    return null;
  }

  public double calculateHeuristics(BusStop goalPoint) {
    return this.busStop.distanceFrom(goalPoint) / 40;
  }

  public BusStop getBusStop() {
    return busStop;
  }

  public void setBusStop(BusStop busStop) {
    this.busStop = busStop;
  }

  public State getParent() {
    return parent;
  }

  public void setParent(State parent) {
    this.parent = parent;
  }

  public double getCost() {
    return cost;
  }

  public void setCost(double cost) {
    this.cost = cost;
  }

}
