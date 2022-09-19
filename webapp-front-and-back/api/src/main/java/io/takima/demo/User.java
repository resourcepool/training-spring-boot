package io.takima.demo;
import javax.persistence.*;
import java.util.Objects;

@Entity(name = "users")
public class User {
/*
Toutes les classes marquées de "@Entity" correspondent à une table en BDD, la table "users" ici.

Les champs marqués de "@Column" correspondent aux colonnes de ta table.
--> remplacé par "@Id" & "@GeneratedValue(strategy = GenerationType.IDENTITY)" pour le champ id de ta classe.

/!\ Chaque classe entitée à besoin au minimum pour fonctionner de :
     - un constructeur vide
     - des getter et setter associé à ses champs
/!\    (vous pouvez les générer automatiquement via IntelliJ, Clique droit n'importe où dans ta classe --> Generate)
 */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private Integer age;

    public User() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
