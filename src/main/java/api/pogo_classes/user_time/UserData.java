package api.pogo_classes.user_time;

public class UserData {
    private Integer id;
    public String email;
    public String first_name;
    public String last_name;
    public String avatar;

    public UserData() {
    }

    public Integer getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
    public String getFirst_name() {
        return first_name;
    }

    @SuppressWarnings("unused")
    public String getLast_name() {
        return last_name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
