package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Station extends Model {
  public String name;
  public double latitude;
  public double longitude;
  @OneToMany(cascade = CascadeType.ALL)
  public List<Reading> readings = new ArrayList<Reading>();

  public Station(String name, double latitude, double longitude) {
    this.name = name;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Reading latestReading() {
    Reading latestReading = null;
    if (readings.size() != 0) {
      latestReading = readings.get(readings.size() - 1);
    }
    return latestReading;
  }

  public double maxTemperature() {
    double maxTemperature = 0;
    if (readings.size() != 0) {
      maxTemperature = readings.get(0).temperature;
      for (int i = 1; i < readings.size(); i++) {
        if (readings.get(i).temperature > maxTemperature) {
          maxTemperature = readings.get(i).temperature;
        }
      }
    }
    return maxTemperature;
  }

  public double minTemperature() {
    double minTemperature = 0;
    if (readings.size() != 0) {
      minTemperature = readings.get(0).temperature;
      for (int i = 1; i < readings.size(); i++) {
        if (readings.get(i).temperature < minTemperature) {
          minTemperature = readings.get(i).temperature;
        }
      }
    }
    return minTemperature;
  }

  public double maxWindSpeed() {
    double maxWindSpeed = 0;
    if (readings.size() != 0) {
      maxWindSpeed = readings.get(0).windSpeed;
      for (int i = 1; i < readings.size(); i++) {
        if (readings.get(i).windSpeed > maxWindSpeed) {
          maxWindSpeed = readings.get(i).windSpeed;
        }
      }
    }
    return maxWindSpeed;
  }

  public double minWindSpeed() {
    double minWindSpeed = 0;
    if (readings.size() != 0) {
      minWindSpeed = readings.get(0).windSpeed;
      for (int i = 1; i < readings.size(); i++) {
        if (readings.get(i).windSpeed < minWindSpeed) {
          minWindSpeed = readings.get(i).windSpeed;
        }
      }
    }
    return minWindSpeed;
  }

  public int maxPressure() {
    int maxPressure = 0;
    if (readings.size() != 0) {
      maxPressure = readings.get(0).pressure;
      for (int i = 1; i < readings.size(); i++) {
        if (readings.get(i).pressure > maxPressure) {
          maxPressure = readings.get(i).pressure;
        }
      }
    }
    return maxPressure;
  }

  public int minPressure() {
    int minPressure = 0;
    if (readings.size() != 0) {
      minPressure = readings.get(0).pressure;
      for (int i = 1; i < readings.size(); i++) {
        if (readings.get(i).pressure < minPressure) {
          minPressure = readings.get(i).pressure;
        }
      }
    }
    return minPressure;
  }

}
