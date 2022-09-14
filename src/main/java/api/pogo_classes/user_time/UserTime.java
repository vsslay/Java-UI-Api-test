package api.pogo_classes.user_time;

public class UserTime {
    private final String name;
    private final String job;

    public UserTime(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
