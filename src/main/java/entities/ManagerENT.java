package entities;

import jakarta.persistence.*;

@Entity
public class ManagerENT {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    @Basic
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;
    @Basic
    @Column(name = "email", nullable = true, length = 20)
    private String email;

    public ManagerENT(String nom, String prenom, String email, String password) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.password = password;
    }

    public ManagerENT() {
    }

    @Basic
    @Column(name = "password", nullable = true, length = -1)
    private String password;


}
