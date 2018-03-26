package dk.easj.anbo.bookstorerest;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Book implements Serializable {
    @SerializedName("Id") // Name of JSON attribute. Used for GSON de-serialization
    private int id;

    @SerializedName("Created")
    private String created;

    @SerializedName("BirdID")
    private int birdid;

    @SerializedName("Comment")
    private String comment;

    @SerializedName("Latitude")
    private double latitude;

    @SerializedName("Longitude")
    private double longitude;

    @SerializedName("Placename")
    private double placename;

    @SerializedName("Population")
    private int population;

    @SerializedName("UserID")
    private int userid;

    @SerializedName("NameDanish")
    private String namedanish;

    @SerializedName("NameEnglish")
    private String nameenglish;

    public Book() {
    }

    public Book(int id, String created, int birdid, String comment, double latitude, double longitude, double placename, int population, int userid, String namedanish, String nameenglish) {
        this.id = id;
        this.created = created;
        this.birdid = birdid;
        this.comment = comment;
        this.latitude = latitude;
        this.longitude = longitude;
        this.placename = placename;
        this.population = population;
        this.userid = userid;
        this.namedanish = namedanish;
        this.nameenglish = nameenglish;

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setBirdid(int birdid) {
        this.birdid = birdid;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPlacename(double placename) {
        this.placename = placename;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setNamedanish(String namedanish) {
        this.namedanish = namedanish;
    }

    public void setNameenglish(String nameenglish) {
        this.nameenglish = nameenglish;
    }


    public int getId() {
        return id;
    }

    public String getCreated() {
        return created;
    }

    public int getBirdid() {
        return birdid;
    }

    public String getComment() {
        return comment;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getPlacename() {
        return placename;
    }

    public int getPopulation() {
        return population;
    }

    public int getUserid() {
        return userid;
    }

    public String getNameDanish() { return namedanish; }

    public String getNameEnglish() { return nameenglish; }




    @Override
    public String toString() {
        return created;
    }
}
