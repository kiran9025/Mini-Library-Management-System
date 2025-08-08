import java.util.Objects;

public class Users {
    private String name;
    private String email;
    private int id;

    public Users(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public int getId() {
        return this.id;
    }
    public void setId( int id){
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "'}";
    }
    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Users)) return false;
        Users user = (Users) o;
        return id == user.id;
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }
}

