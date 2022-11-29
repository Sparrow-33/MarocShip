package Controllers;

import java.util.HashMap;

public class ManageDelivery {

    public static int internationalDeliveryPrice(String zone, int poids) {
      final  HashMap<String, Integer > zones = new HashMap<>();
        zones.put("europe", 160);
        zones.put("amerique", 220);
        zones.put("asie", 240);
        zones.put("australie", 260);

        for (String z : zones.keySet()) {
            if (z.equals(zone)) {
                return zones.get(z) * poids;
            }
        }
        return 0;
    }

    public static int localDeliveryPrice(int poids) {
        if (poids > 3) {
            return (poids - 3) * 5 + 3 * 40;
        }
        return poids *  40;
    }
}
