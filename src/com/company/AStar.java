package com.company;

import java.util.*;

public class AStar {

  Graph graph;

  public AStar(Graph graph) {
    this.graph = graph;
  }

  public State search(Coordinates start, Coordinates goal){
    List<State> statesForProcessing = new ArrayList<>();
    Set<State> history = new HashSet<>();

    BusStop startPoint = new BusStop("START",start.getLat(), start.getLon(), Collections.emptyList());
    BusStop goalPoint = new BusStop("GOAL",goal.getLat(), goal.getLon(), Collections.emptyList());

        //BusStop(String name, double lat, double lon, List<String> lines
    statesForProcessing.add(new State(startPoint));
    while (statesForProcessing.size() > 0){
      State currentlyProcessing = getBest(statesForProcessing, goalPoint);
      if(!history.contains(currentlyProcessing)){
        if(currentlyProcessing.getBusStop() == goalPoint){
          return currentlyProcessing;
        }
        history.add(currentlyProcessing);
        for (State s : currentlyProcessing.possibleNextStates(graph)){
          statesForProcessing.add(s);
        }
      }
      statesForProcessing.remove(currentlyProcessing);
    }
    return null;
  }

  private State getBest(List<State> statesForProcessing, BusStop goalPoint) {

    State best = statesForProcessing.get(1);

    for (State s : statesForProcessing)
    {

      if (s.getCost() + s.calculateHeuristics(goalPoint) < best.getCost() + best.calculateHeuristics(goalPoint))
      {
        best = s;
      }
    }
    return best;
  }

}