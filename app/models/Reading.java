package models;

import javax.persistence.Entity;

import play.db.jpa.Model;
import play.Logger;

import java.util.HashMap;

@Entity
public class Reading extends Model {
  public int code;
  public double temperature;
  public double windSpeed;
  public int windDirection;
  public int pressure;

  public Reading(int code, double temperature, double windSpeed, int windDirection, int pressure) {
    this.code = code;
    this.temperature = temperature;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
    this.pressure = pressure;
  }

  public double getFahrenheit(double celsius) {
    return celsius * 1.8 + 32;
  }

  public int getBeaufort() {
    int beaufort = 12;
    if (this.windSpeed < 1) {
      beaufort = 0;
    } else if (this.windSpeed < 6) {
      beaufort = 1;
    } else if (this.windSpeed < 12) {
      beaufort = 2;
    } else if (this.windSpeed < 20) {
      beaufort = 3;
    } else if (this.windSpeed < 29) {
      beaufort = 4;
    } else if (this.windSpeed < 39) {
      beaufort = 5;
    } else if (this.windSpeed < 50) {
      beaufort = 6;
    } else if (this.windSpeed < 62) {
      beaufort = 7;
    } else if (this.windSpeed < 75) {
      beaufort = 8;
    } else if (this.windSpeed < 89) {
      beaufort = 9;
    } else if (this.windSpeed < 103) {
      beaufort = 10;
    } else if (this.windSpeed < 118) {
      beaufort = 11;
    }
    return beaufort;
  }

  public String getDirection() {
    String direction = null;
    if (this.windDirection < 11.25) {
      direction = "North";
    } else if (this.windDirection < 33.75) {
      direction = "North North East";
    } else if (this.windDirection < 56.25) {
      direction = "North East";
    } else if (this.windDirection < 78.75) {
      direction = "East North East";
    } else if (this.windDirection < 101.25) {
      direction = "East";
    } else if (this.windDirection < 123.75) {
      direction = "East South East";
    } else if (this.windDirection < 146.25) {
      direction = "South East";
    } else if (this.windDirection < 168.75) {
      direction = "South South East";
    } else if (this.windDirection < 191.25) {
      direction = "South";
    } else if (this.windDirection < 213.75) {
      direction = "South South West";
    } else if (this.windDirection < 236.25) {
      direction = "South West";
    } else if (this.windDirection < 258.75) {
      direction = "West South West";
    } else if (this.windDirection < 281.25) {
      direction = "West";
    } else if (this.windDirection < 303.75) {
      direction = "West North West";
    } else if (this.windDirection < 326.25) {
      direction = "North West";
    } else if (this.windDirection < 348.75) {
      direction = "North North West";
    } else {
      direction = "North";
    }
    return direction;
  }

  public double getWindChill() {
    return ((13.12) + (this.temperature * 0.6215) - (11.37 * Math.pow(this.windSpeed, 0.16)) + (this.temperature * 0.3965 * Math.pow(this.windSpeed, 0.16)));
  }

  public String getWeather() {
    String weather = null;
    HashMap<Integer, String> weatherCodes = new HashMap<Integer, String>();
    weatherCodes.put(100, "Clear");
    weatherCodes.put(200, "Partial clouds");
    weatherCodes.put(300, "Cloudy");
    weatherCodes.put(400, "Light showers");
    weatherCodes.put(500, "Heavy showers");
    weatherCodes.put(600, "Rain");
    weatherCodes.put(700, "Snow");
    weatherCodes.put(800, "Thunder");
    weather = weatherCodes.get(this.code);
    return weather;
  }


  public String getWeatherIcon() {
    String weatherIcon;
    HashMap<Integer, String> weatherCodes = new HashMap<Integer, String>();
    weatherCodes.put(100, "big yellow sun icon");
    weatherCodes.put(200, "big cloud sun icon");
    weatherCodes.put(300, "big grey cloud icon");
    weatherCodes.put(400, "big yellow cloud sun rain icon");
    weatherCodes.put(500, "big grey cloud showers heavy icon");
    weatherCodes.put(600, "big grey cloud rain icon");
    weatherCodes.put(700, "big white snowflake icon");
    weatherCodes.put(800, "big yellow bolt icon");
    weatherIcon = weatherCodes.get(this.code);
    return weatherIcon;
  }

}