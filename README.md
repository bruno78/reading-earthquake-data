# Reading Live Earthquake data

<div style="text-align:center"><img src="https://cdn.rawgit.com/bruno78/reading-earthquake-data/06df4cb8/data/earthquakemap.png" alt="Earthquakes by Magnitude"/></div>

This program reads Earthquake data either from a file or live from the government website: http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom. It displays a map showing magnitude and its intensity in different locations around the globe.
It uses:
* [Android Geolocation](http://developer.android.com/reference/android/location/Location.html) api, and is under The [Apache 2.0 license](http://www.apache.org/licenses/LICENSE-2.0). This API uses Geolocation to display data in different points of the map.
* [Unfolding Maps](http://unfoldingmaps.org) api. It provides maps from several sources. ex. Google, Microsoft, Yahoo, etc.
* [Processing](https://processing.org) Library. Applet to display graphics on the screen.
* [edu.duke](http://www.dukelearntoprogram.com/course2/doc/javadoc/edu/duke/package-summary.html#package.description) Library. It provides a very simple way to access directory and file resources.
* [Apache Commons](https://commons.apache.org/proper/commons-csv/) Library. It reads and parse CSV files.

## Brief description of packages

* **earthquakeMap**
  Contains the class EarthQuakeMap used to display earthquake data related to the location.

* **filter**
  Contains several filters methods provided by an interface Filter to filter data for analysis.
  - It filters by depth of earthquake
  - It filters by distance of earthquake from a given location
  - It filters by Magnitude
  - It filters by phrase based on data's description
  - it filters based on Minimum magnitude.
* **parsing**
  Contains methods to parse RSS feed data.

* **searchEarthQuakeData**
  Contains methods to find Largest earthquakes and closest earthquakes.
