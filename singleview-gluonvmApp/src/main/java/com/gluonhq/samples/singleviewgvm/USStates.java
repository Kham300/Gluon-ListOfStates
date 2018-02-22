package com.gluonhq.samples.singleviewgvm;

import com.gluonhq.charm.down.Services;
import com.gluonhq.charm.down.plugins.Cache;
import com.gluonhq.charm.down.plugins.CacheService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public class USStates {
    private static final Cache<String, Image> CACHE;

    static{
        CACHE = Services.get(CacheService.class)
                .map(cache -> cache.<String, Image>getCache("images"))
                .orElseThrow(() -> new RuntimeException("No CacheService available"));
    }

    private static final String URL_PATH = "https://upload.wikimedia.org/wikipedia/commons/thumb/";

    public static ObservableList<USStates> statesList = FXCollections.observableArrayList(
            new USStates("Alabama", "AL", "Montgomery", 4833722, 135767, URL_PATH + "5/5c/Flag_of_Alabama.svg/23px-Flag_of_Alabama.svg.png"),
            new USStates("Alaska", "AK", "Juneau", 735132, 1723337, URL_PATH + "e/e6/Flag_of_Alaska.svg/21px-Flag_of_Alaska.svg.png"),
            new USStates("Arizona", "AZ", "Phoenix", 6626624, 295233, URL_PATH + "9/9d/Flag_of_Arizona.svg/23px-Flag_of_Arizona.svg.png"),
            new USStates("Arkansas", "AR", "Little Rock", 2959373, 137733, URL_PATH + "9/9d/Flag_of_Arkansas.svg/23px-Flag_of_Arkansas.svg.png"),
            new USStates("California", "CA", "Sacramento", 38332521, 423968, URL_PATH + "0/01/Flag_of_California.svg/23px-Flag_of_California.svg.png"),
            new USStates("Colorado", "CO", "Denver", 5268367, 269602, URL_PATH + "4/46/Flag_of_Colorado.svg/23px-Flag_of_Colorado.svg.png"),
            new USStates("Connecticut", "CT", "Hartford", 3596080, 14356, URL_PATH + "9/96/Flag_of_Connecticut.svg/20px-Flag_of_Connecticut.svg.png"),
            new USStates("Delaware", "DE", "Dover", 925749, 6446, URL_PATH + "c/c6/Flag_of_Delaware.svg/23px-Flag_of_Delaware.svg.png"),
            new USStates("Florida", "FL", "Tallahassee", 19552860, 170312, URL_PATH + "f/f7/Flag_of_Florida.svg/23px-Flag_of_Florida.svg.png"),
            new USStates("Georgia", "GA", "Atlanta", 9992167, 153910, URL_PATH + "5/54/Flag_of_Georgia_%28U.S._state%29.svg/23px-Flag_of_Georgia_%28U.S._state%29.svg.png"),
            new USStates("Hawaii", "HI", "Honolulu", 1404054, 28314, URL_PATH + "e/ef/Flag_of_Hawaii.svg/23px-Flag_of_Hawaii.svg.png"),
            new USStates("Idaho", "ID", "Boise", 1612136, 216443, URL_PATH + "a/a4/Flag_of_Idaho.svg/19px-Flag_of_Idaho.svg.png"),
            new USStates("Illinois", "IL", "Springfield", 12882135, 149997, URL_PATH + "0/01/Flag_of_Illinois.svg/23px-Flag_of_Illinois.svg.png"),
            new USStates("Indiana", "IN", "Indianapolis", 6570902, 94327, URL_PATH + "a/ac/Flag_of_Indiana.svg/23px-Flag_of_Indiana.svg.png"),
            new USStates("Iowa", "IA", "Des Moines", 3090416, 145746, URL_PATH + "a/aa/Flag_of_Iowa.svg/22px-Flag_of_Iowa.svg.png"),
            new USStates("Kansas", "KS", "Topeka", 2893957, 213099, URL_PATH + "d/da/Flag_of_Kansas.svg/23px-Flag_of_Kansas.svg.png"),
            new USStates("Kentucky", "KY", "Frankfort", 4395295, 104656, URL_PATH + "8/8d/Flag_of_Kentucky.svg/23px-Flag_of_Kentucky.svg.png"),
            new USStates("Louisiana", "LA", "Baton Rouge", 4625470, 135658, URL_PATH + "e/e0/Flag_of_Louisiana.svg/23px-Flag_of_Louisiana.svg.png"),
            new USStates("Maine", "ME", "Augusta", 1328302, 91634, URL_PATH + "3/35/Flag_of_Maine.svg/23px-Flag_of_Maine.svg.png"),
            new USStates("Maryland", "MD", "Annapolis", 5928814, 32131, URL_PATH + "a/a0/Flag_of_Maryland.svg/23px-Flag_of_Maryland.svg.png"),
            new USStates("Massachusetts", "MA", "Boston", 6692824, 27335, URL_PATH + "f/f2/Flag_of_Massachusetts.svg/23px-Flag_of_Massachusetts.svg.png"),
            new USStates("Michigan", "MI", "Lansing", 9895622, 250488, URL_PATH + "b/b5/Flag_of_Michigan.svg/23px-Flag_of_Michigan.svg.png"),
            new USStates("Minnesota", "MN", "St. Paul", 5420380, 225163, URL_PATH + "b/b9/Flag_of_Minnesota.svg/23px-Flag_of_Minnesota.svg.png"),
            new USStates("Mississippi", "MS", "Jackson", 2991207, 125438, URL_PATH + "4/42/Flag_of_Mississippi.svg/23px-Flag_of_Mississippi.svg.png"),
            new USStates("Missouri", "MO", "Jefferson City", 6021988, 180540, URL_PATH + "5/5a/Flag_of_Missouri.svg/23px-Flag_of_Missouri.svg.png"),
            new USStates("Montana", "MT", "Helena", 1015165, 380832, URL_PATH + "c/cb/Flag_of_Montana.svg/23px-Flag_of_Montana.svg.png"),
            new USStates("Nebraska", "NE", "Lincoln", 1868516, 200330, URL_PATH + "4/4d/Flag_of_Nebraska.svg/23px-Flag_of_Nebraska.svg.png"),
            new USStates("Nevada", "NV", "Carson City", 2790136, 286380, URL_PATH + "f/f1/Flag_of_Nevada.svg/23px-Flag_of_Nevada.svg.png"),
            new USStates("New Hampshire", "NH", "Concord", 1323459, 24214, URL_PATH + "2/28/Flag_of_New_Hampshire.svg/23px-Flag_of_New_Hampshire.svg.png"),
            new USStates("New Jersey", "NJ", "Trenton", 8899339, 22592, URL_PATH + "9/92/Flag_of_New_Jersey.svg/23px-Flag_of_New_Jersey.svg.png"),
            new USStates("New Mexico", "NM", "Santa Fe", 2085287, 314917, URL_PATH + "c/c3/Flag_of_New_Mexico.svg/23px-Flag_of_New_Mexico.svg.png"),
            new USStates("New York", "NY", "Albany", 19651127, 141297, URL_PATH + "1/1a/Flag_of_New_York.svg/23px-Flag_of_New_York.svg.png"),
            new USStates("North Carolina", "NC", "Raleigh", 9848060, 139391, URL_PATH + "b/bb/Flag_of_North_Carolina.svg/23px-Flag_of_North_Carolina.svg.png"),
            new USStates("North Dakota", "ND", "Bismarck", 723393, 183107, URL_PATH + "e/ee/Flag_of_North_Dakota.svg/21px-Flag_of_North_Dakota.svg.png"),
            new USStates("Ohio", "OH", "Columbus", 11570808, 116099, URL_PATH + "4/4c/Flag_of_Ohio.svg/23px-Flag_of_Ohio.svg.png"),
            new USStates("Oklahoma", "OK", "Oklahoma City", 3850568, 181038, URL_PATH + "6/6e/Flag_of_Oklahoma.svg/23px-Flag_of_Oklahoma.svg.png"),
            new USStates("Oregon", "OR", "Salem", 3930065, 254800, URL_PATH + "b/b9/Flag_of_Oregon.svg/23px-Flag_of_Oregon.svg.png"),
            new USStates("Pennsylvania", "PA", "Harrisburg", 12773801, 119279, URL_PATH + "f/f7/Flag_of_Pennsylvania.svg/23px-Flag_of_Pennsylvania.svg.png"),
            new USStates("Rhode Island", "RI", "Providence", 1051511, 4002, URL_PATH + "f/f3/Flag_of_Rhode_Island.svg/18px-Flag_of_Rhode_Island.svg.png"),
            new USStates("South Carolina", "SC", "Columbia", 4774839, 82931, URL_PATH + "6/69/Flag_of_South_Carolina.svg/23px-Flag_of_South_Carolina.svg.png"),
            new USStates("South Dakota", "SD", "Pierre", 844877, 199730, URL_PATH + "1/1a/Flag_of_South_Dakota.svg/23px-Flag_of_South_Dakota.svg.png"),
            new USStates("Tennessee", "TN", "Nashville", 6495978, 109152, URL_PATH + "9/9e/Flag_of_Tennessee.svg/23px-Flag_of_Tennessee.svg.png"),
            new USStates("Texas", "TX", "Austin", 26448193, 695660, URL_PATH + "f/f7/Flag_of_Texas.svg/23px-Flag_of_Texas.svg.png"),
            new USStates("Utah", "UT", "Salt Lake City", 2900872, 219882, URL_PATH + "f/f6/Flag_of_Utah.svg/23px-Flag_of_Utah.svg.png"),
            new USStates("Vermont", "VT", "Montpelier", 626630, 24905, URL_PATH + "4/49/Flag_of_Vermont.svg/23px-Flag_of_Vermont.svg.png"),
            new USStates("Virginia", "VA", "Richmond", 8260405, 110787, URL_PATH + "4/47/Flag_of_Virginia.svg/22px-Flag_of_Virginia.svg.png"),
            new USStates("Washington", "WA", "Olympia", 6971406, 184661, URL_PATH + "5/54/Flag_of_Washington.svg/23px-Flag_of_Washington.svg.png"),
            new USStates("West Virginia", "WV", "Charleston", 1854304, 62755, URL_PATH + "2/22/Flag_of_West_Virginia.svg/23px-Flag_of_West_Virginia.svg.png"),
            new USStates("Wisconsin", "WI", "Madison", 5742713, 169634, URL_PATH + "2/22/Flag_of_Wisconsin.svg/23px-Flag_of_Wisconsin.svg.png"),
            new USStates("Wyoming", "WY", "Cheyenne", 582658, 253335, URL_PATH + "b/bc/Flag_of_Wyoming.svg/22px-Flag_of_Wyoming.svg.png"));

    public static Image getUSFlag(){
        return getImage(URL_PATH + "a/a4/Flag_of_the_United_States.svg/320px-Flag_of_the_United_States.svg.png");
    }

    public static Image getImage(String image){
        if (image == null || image.isEmpty()){
            return null;
        }
        Image cachedImage = CACHE.get(image);
        if (cachedImage == null){
            cachedImage = new Image(image, true);
            CACHE.put(image, cachedImage);
        }
        return cachedImage;
    }


    private String name;
    private String abbr;
    private String capital;
    private int population;
    private int area;
    private String flag;

    public USStates(String name, String abbr, String capital, int population, int area, String flag) {
        this.name = name;
        this.abbr = abbr;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.flag = flag;
    }

    // setters and getters

    public double getDensity() {
        if (area > 0) {
            return (double) population / (double) area;
        }
        return 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbr() {
        return abbr;
    }

    public void setAbbr(String abbr) {
        this.abbr = abbr;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }
    public int getPopulation() {
        return population;
    }
    public int getArea() {
        return area;
    }

    public String getFlag() {
        return flag;
    }
}
