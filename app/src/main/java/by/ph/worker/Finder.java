package by.ph.worker;

import static by.ph.data.ArrayData.buildings;
import static by.ph.data.ArrayData.favorites;

public class Finder {
    public static int findBuildingByName(String name) {
        for (int i = 0; i < buildings.size(); i++) {
            if (name.equals(buildings.get(i).getName().toLowerCase()) || name.equals(buildings.get(i).getName())) {
                return i;
            }
        } return -1;
    }

    public static int findFavoriteByName(String name) {
        for (int i = 0; i < favorites.size(); i++) {
            if (name.equals(favorites.get(i).getName().toLowerCase()) || name.equals(favorites.get(i).getName())) {
                return i;
            }
        } return -1;
    }
}
