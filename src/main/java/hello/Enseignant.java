package hello;

public class Enseignant {

    public Enseignant(int idenseignant, String prenom, String nom) {
        this.idenseignant = idenseignant;
        this.nom = nom;
        this.prenom = prenom;
    }

    public int getIdenseignant() {
        return idenseignant;
    }

    public void setIdenseignant(int idenseignant) {
        this.idenseignant = idenseignant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    private int idenseignant;
    private String nom;
    private String prenom;
}
