package ms.paint;

import java.io.Serializable;

public class Product implements Serializable {
    private String nazwa;
    private String opis;
    private int cena;

    // Konstruktor bezargumentowy jest WYMAGANY dla JAX-WS [cite: 233]
    public Product() {}

    public Product(String nazwa, String opis, int cena) {
        this.nazwa = nazwa;
        this.opis = opis;
        this.cena = cena;
    }

    // Gettery i Settery są niezbędne do poprawnego generowania XML [cite: 233]
    public String getNazwa() { return nazwa; }
    public void setNazwa(String nazwa) { this.nazwa = nazwa; }
    public String getOpis() { return opis; }
    public void setOpis(String opis) { this.opis = opis; }
    public int getCena() { return cena; }
    public void setCena(int cena) { this.cena = cena; }
}
