package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

  private HashMap<BusStop, List<BusStop>> connections;


  public Graph() {

  }

  public List<BusStop> findConnections(BusStop busStop){
    return connections.get(busStop);
  }

  public HashMap<BusStop, List<BusStop>> getConnections() {
    return connections;
  }

  public void setConnections(HashMap<BusStop, List<BusStop>> connections) {
    this.connections = connections;
  }
}