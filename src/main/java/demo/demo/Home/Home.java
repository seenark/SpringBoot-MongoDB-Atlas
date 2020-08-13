package demo.demo.Home;

public class Home {
    private String name;
    private String link;
    private String description;
    private UserExample user;


    public Home(String name, String link, String description) {
        this.name = name;
        this.link = link;
        this.description = description;
    }
    public Home(String name, String link, String description,UserExample user) {
        this.name = name;
        this.link = link;
        this.description = description;
        this.user = user;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return this.link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserExample getUser() {
        return this.user;
    }

    public void setUser(UserExample user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", link='" + getLink() + "'" +
            ", description='" + getDescription() + "'" +
            ", user='" + getUser() + "'" +
            "}";
    }

}