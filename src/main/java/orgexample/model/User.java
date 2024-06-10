package orgexample.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import javax.persistence.*;

@Entity
@Table(name = "users_mvc")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Имя может содержать от 2 до 30 символов")
    @Column(name = "firstname")
    private String firstName;

    @NotEmpty(message = "Поле не должно быть пустым")
    @Size(min = 2, max = 30, message = "Фамилия может содержать от 2 до 30 символов")
    @Column(name = "lastname")
    private String lastName;

    @Email(message = "Не корректный Email")
    @NotEmpty(message = "Поле не должно быть пустым")
    @Column(name = "email")
    private String email;

    public User(){};

    public User(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
