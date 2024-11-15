package by.ph.data;

import android.graphics.drawable.Drawable;

import lombok.Setter;

@Setter
public class BuildingData {

    private String name;
    private String city;
    private Integer id;
    private Drawable place;
    private String funData;
    public double chords[] = new double[2];


    public double[] getChords() {
        return chords;
    }

    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public Drawable getPlace() {
        return place;
    }

    public String getFunData() {
        return funData;
    }

    public BuildingData(String name, String city, Integer id){
        this.name = name;
        this.city = city;
        this.id = id;
        this.place = place;
        this.funData = funData;
    }

   /* public BuildingData getAll(){
        return new BuildingData(getName(), getCity(), getId());
    }*/
}
