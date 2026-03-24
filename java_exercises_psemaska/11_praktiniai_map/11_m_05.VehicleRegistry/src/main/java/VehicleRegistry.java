import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class VehicleRegistry {

    private HashMap<LicensePlate, String> hashMap = new HashMap<>();

    public boolean add(LicensePlate licensePlate, String owner) {
        if(hashMap.isEmpty()) {
            hashMap.put(licensePlate, owner);
            return true;
        } else {
            if(hashMap.get(licensePlate) == null) {
                hashMap.put(licensePlate, owner);
                return true;
            } else {
                return false;
            }
        }
    }

    public String get(LicensePlate licensePlate) {
        if(!hashMap.isEmpty()) {
            for(LicensePlate lp : hashMap.keySet()) {
                if(lp.equals(licensePlate)) {
                    return hashMap.get(licensePlate);
                }
            }
        }
        return null;
    }

    public boolean remove(LicensePlate licensePlate) {
        if(!hashMap.isEmpty()) {
            for(LicensePlate lp : hashMap.keySet()) {
                if (lp.equals(licensePlate)) {
                    hashMap.remove(licensePlate);
                    return true;
                }
            }
        }
        return false;
    }

    public void printLicensePlates() {
        if(!hashMap.isEmpty()) {
            for(LicensePlate lp : hashMap.keySet()) {
                System.out.println(lp);
            }
        }
    }

    public void printOwners() {
        Set<String> owners = new HashSet<>();
        if(!hashMap.isEmpty()) {
            for(LicensePlate lp : hashMap.keySet()) {
                owners.add(hashMap.get(lp));
            }
        }
        for(String owner : owners) {
            System.out.println(owner);
        }
    }
}
