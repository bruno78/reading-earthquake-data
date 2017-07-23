# Reading Live Earthquake data

This program reads Earthquake data either from a file or live from the government website: http://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_week.atom It uses the Android Location class whose documentation can be found [here](http://developer.android.com/reference/android/location/Location.html), and is under The Apache 2.0 license, the info can be found [here](http://www.apache.org/licenses/LICENSE-2.0).

## Brief description of classes

* **class Location**, from the Android platform, is data class representing a geographic location. One of the constructors has parameters latitude and longitude, and one of the public methods is distanceTo.

* **class QuakeEntry**, is data class representing earthquake information. It contains methods: getLocation(), getMagnitude(), getInfo(), getDepth(), compareTo() and toString()

* **class EarthQuakeParser** has a read method with one String parameter that represents an XML(atom) earthquake data file and returns an ArrayList of QuakeEntry objects.

* **class EarthQuakeClient**, creates an EarthQuakeParser to read in an earthquake data file, creating an ArrayList of QuakeEntrys. You can test the program with the method createCSV to store an ArrayList of the earthquake data and print a CSV file.

## Methods

(coming soon)
