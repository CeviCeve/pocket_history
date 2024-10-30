package by.ph.data;

public class BuildingData {
    private String name;
    private String city;
    private Integer id;



    public Integer getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getName() {
        return name;
    }

    public BuildingData(String name, String city, Integer id){
        this.name = name;
        this.city = city;
        this.id = id;
    }

   /* public BuildingData getAll(){
        return new BuildingData(getName(), getCity(), getId());
    }*/



}
