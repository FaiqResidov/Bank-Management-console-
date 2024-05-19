public class User {
    public User(int id, String name, String surname, String email, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    public int id;
    public String name;
    public String surname;
    public String email;
    public String password;


@Override
    public String toString(){
        return "Id: %d Name: %s Surname: %s Email: %s Password: %s".formatted(id,name,surname,email,password);
    }

}
