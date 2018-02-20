package Zbior;

public class Zad5DzienTygodnia {
    public static void main(String[] args) {
        RunAlgorithmEnumVersion("Sr", 5);
        RunAlgorithmTableVersion("Sr", 5);
    }


    private static final String[] _daysOfWeek = new String[] {"Pn", "Wt", "Sr", "Czw", "Pt", "Sb", "Nd"};

    public enum DaysOfWeekEnum {
        Pn("Pn", 0),
        Wt("Wt", 1),
        Sr("Sr", 2),
        Czw("Czw", 3),
        Pt("Pt", 4),
        Sb("Sb", 5),
        Nd("Nd", 6);

        private final String name;
        private final int number;

        DaysOfWeekEnum(String s, int i) {
            name = s;
            number = i;
        }

        public String toString() {
            return this.name;
        }

        public static int getIntValueFromString(String name){
            for (DaysOfWeekEnum dayOfWeek : DaysOfWeekEnum.values()) {
                if(dayOfWeek.toString().equals(name))
                    return dayOfWeek.number;
            }
            // throw an IllegalArgumentException or return null
            throw new IllegalArgumentException("the given number doesn't match any Status.");
        }
    }

    public static void RunAlgorithmTableVersion(String dayOfTheWeek, int daysAhead){

        int daysToAdd = daysAhead % 7;
        int givenDay = 0;

        for(int i=0; i < _daysOfWeek.length; i++){
            if(dayOfTheWeek.equals(_daysOfWeek[i])){
                givenDay = i;
            }
        }

        System.out.println(_daysOfWeek[(givenDay + daysToAdd)%7]);
    }

    public static void RunAlgorithmEnumVersion(String dayOfTheWeek, int daysAhead){
        int daysToAdd = daysAhead % 7;

        int givenDay = DaysOfWeekEnum.getIntValueFromString(dayOfTheWeek);

        System.out.println(_daysOfWeek[(givenDay + daysToAdd)%7]);
    }
}
