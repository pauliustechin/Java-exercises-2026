import java.util.ArrayList;
import java.util.HashMap;

public class StorageFacility {

    private HashMap<String, ArrayList<String>> storage = new HashMap<>();

    public void add(String unit, String item) {

        boolean found = false;

        if(storage.isEmpty()) {
            ArrayList<String> translations = new ArrayList<>();
            translations.add(item);
            storage.put(unit, translations);
        }
        else {
            for (String w : storage.keySet()) {
                if(w.equals(unit)) {
                    ArrayList<String> arrayToUpdate = storage.get(unit);
                    arrayToUpdate.add(item);
                    storage.put(unit, arrayToUpdate);
                    found = true;
                    break;
                }
            }
            if(!found) {
                ArrayList<String> translations = new ArrayList<>();
                translations.add(item);
                storage.put(unit, translations);
            }
        }

    }

    public ArrayList<String> contents(String storageUnit) {
        if(!storage.isEmpty()) {
            for(String su : storage.keySet()) {
                if(su.equals(storageUnit)) {
                    return storage.get(su);
                }
            }
        }
        return new ArrayList<>();
    }

    public void remove(String storageUnit, String item) {
        if(!storage.isEmpty()) {
            for(String su : storage.keySet()) {
                if(su.equals(storageUnit)) {
                    ArrayList<String> items = storage.get(storageUnit);
                    // cia toks sudetingesnis gavos, is pradziu dariau, kad jei vienas item remove storageUnit is vis.
                    // tada pamaciau, kad dar reikia patikrinti ar item name sutampa. Tai gavos toks > storage.get(storageUnit).get(0).equals(item)
                    // vistiek nepraejo, tai galiausiai suvedziau, kad reikia palikt storageUnit su empty array, o ne removit is vis.
                    if(items.size() == 1 && storage.get(storageUnit).get(0).equals(item)) {
                        storage.put(storageUnit, new ArrayList<>());
                    } else {
                        for(String i : items) {
                            if(i.equals(item)) {
                                items.remove(item);
                                break;
                            }
                        }
                        storage.put(storageUnit, items);
                    }

                }
            }
        }
    }

    public ArrayList<String> storageUnits() {
        if(storage.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<String> storageUnits = new ArrayList<>();
        for(String su : storage.keySet()){
            if(!storage.get(su).isEmpty()) {
                storageUnits.add(su);
            }
        }
        return storageUnits;
    }

}
