package controllers;

import java.util.List;

import models.Station;
import models.Reading;
import play.Logger;
import play.mvc.Controller;

public class StationCtrl extends Controller {
  public static void index(Long id) {
    Station station = Station.findById(id);
    Logger.info("Rendering Station: " + station.name);
    render("station.html", station);
  }

  public static void addReading(Long id, int code, double temperature, double windSpeed, int windDirection, int pressure) {
    Reading reading = new Reading(code, temperature, windSpeed, windDirection, pressure);
    Station station = Station.findById(id);
    station.readings.add(reading);
    station.save();
    Logger.info("Adding Reading: " + station.name);
    redirect("/stations/" + id);
  }
}
