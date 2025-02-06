package Week_days; 


// Enum representing days of the week
enum Days {
    SUNDAY("Weekend"),
    MONDAY("Weekday"),
    TUESDAY("Weekday"),
    WEDNESDAY("Weekday"),
    THURSDAY("Weekday"),
    FRIDAY("Weekday"),
    SATURDAY("Weekend");

    private final String type;

    // Constructor
    Days(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}

// Superclass
class WeekDays {
    protected String name;

    public WeekDays(String name) {
        this.name = name;
    }

    public void displayInfo() {
        System.out.println(name + " is a week day.");
    }
}

// Subclass for weekdays
class Workday extends WeekDays {
    public Workday(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " is a working day.");
    }
}

// Subclass for weekends
class Weekend extends WeekDays {
    public Weekend(String name) {
        super(name);
    }

    @Override
    public void displayInfo() {
        System.out.println(name + " is a relaxing weekend!");
    }
}

// Main class
public class EnumWeekDays {
    public static void main(String[] args) {
        // Loop through the days and categorize them
        for (Days day : Days.values()) {
            WeekDays dayType;
            
            if (day.getType().equals("Weekday")) {
                dayType = new Workday(day.name());
            } else {
                dayType = new Weekend(day.name());
            }

            dayType.displayInfo();
        }
    }
}
