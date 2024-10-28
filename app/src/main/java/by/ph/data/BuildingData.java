package by.ph.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class BuildingData {
    private String name;
    private String city;
    private Integer id;

    public BuildingData getAll(){
        return new BuildingData(getName(), getCity(), getId());
    }

}
