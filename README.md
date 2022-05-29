# WeatherTop: Release 3
https://evening-headland-60193.herokuapp.com/

This is **Release 3** of the WeatherTop web application, which meets the following criteria:

Implemented:
- **Readings**: Meets Release 3. Code, temperature, wind speed, wind direction and pressure fields are all used. A date/timestamp is included.
- **Stations**: Meets Release 2. The station name and current readings are displayed for each station in a grid. This uses text terms for the weather, and displays the temperature in °C and °F, the wind speed in the Beaufort scale, the wind direction as a compass bearing, the wind chill in °C and °F, and pressure in hPa. The maximum and minimum temperature in °C and °F, wind speed in km/hand pressure in hPa are also displayed. A table listing all readings for that station appears below the grid.
- **Member**: Meets Release 2. Member class created with email, password, firstname and lastname fields. Used for logging in, signing up, and linking stations to specific members.
- **Features**: Meets Release 3, except for sorting. Initial member details, station details and readings are read from `/conf/data.yml`; from then on by ElephantSQL database. The Dashboard page displays a station list with current readings for each station, buttons to go into a station's page and to delete the station, and a section to add a new station (name only). The Station pages allow deletion of readings and include a section to add readings for that station.
- **Code**: Meets Release 3. Files have been pushed to a Github repo using SmartGit (Sourcetree is sadly not available on Linux). Database has been pushed to ElephantSQL (I had to use `...?sslmode=disable` to get this working). The site has been deployed to Heroku: https://evening-headland-60193.herokuapp.com/

Not implemented:
- **Stations**: From Release 3: Trends for Temperature, Wind Speed and Pressure displayed with the latest readings.
- **Member**: From Release 3: Users to be able to edit their details.
- **Features**: From Release 3: Sorting stations alphabetically.
