package com.company;

import java.util.List;

public class BusStop {

  String name;
  double lat;
  double lon;
  List<String> lines;


  public double distanceFrom(BusStop busStop) {
    Double distance = Utils.distance(this.getLat(),this.getLon(),busStop.getLat(),busStop.getLon());
    return distance;
  }

  public BusStop() {
  }

  public BusStop(String name, double lat, double lon, List<String> lines) {
    this.name = name;
    this.lat = lat;
    this.lon = lon;
    this.lines = lines;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getLat() {
    return lat;
  }

  public void setLat(double lat) {
    this.lat = lat;
  }

  public double getLon() {
    return lon;
  }

  public void setLon(double lon) {
    this.lon = lon;
  }

  public List<String> getLines() {
    return lines;
  }

  public void setLines(List<String> lines) {
    this.lines = lines;
  }
}

