package InterviewQuestions;

import java.util.HashMap;
        import java.util.Map;

class DesignUndergroundSystem {
    private Map<Integer, CheckInInfo> checkIns;  // {id: CheckInInfo}
    private Map<String, TravelInfo> travelTimes; // {(startStation + "->" + endStation): TravelInfo}

    public DesignUndergroundSystem() {
        checkIns = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkIns.get(id);
        String key = checkInInfo.station + "->" + stationName;

        if (travelTimes.containsKey(key)) {
            TravelInfo travelInfo = travelTimes.get(key);
            travelInfo.totalTime += t - checkInInfo.time;
            travelInfo.totalCount++;
        } else {
            travelTimes.put(key, new TravelInfo(t - checkInInfo.time, 1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String key = startStation + "->" + endStation;
        TravelInfo travelInfo = travelTimes.get(key);
        return (double) travelInfo.totalTime / travelInfo.totalCount;
    }

    private static class CheckInInfo {
        String station;
        int time;

        public CheckInInfo(String station, int time) {
            this.station = station;
            this.time = time;
        }
    }

    private static class TravelInfo {
        int totalTime;
        int totalCount;

        public TravelInfo(int totalTime, int totalCount) {
            this.totalTime = totalTime;
            this.totalCount = totalCount;
        }
    }

    public static void main(String[] args) {
        DesignUndergroundSystem undergroundSystem = new DesignUndergroundSystem();
        undergroundSystem.checkIn(45, "Leyton", 3);
        undergroundSystem.checkIn(32, "Paradise", 8);
        undergroundSystem.checkIn(27, "Leyton", 10);
        undergroundSystem.checkOut(45, "Waterloo", 15);
        undergroundSystem.checkOut(27, "Waterloo", 20);
        undergroundSystem.checkOut(32, "Cambridge", 22);
        System.out.println(undergroundSystem.getAverageTime("Paradise", "Cambridge")); // Output: 14.0
        System.out.println(undergroundSystem.getAverageTime("Leyton", "Waterloo"));    // Output: 11.0
    }
}
