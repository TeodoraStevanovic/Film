package domain;

import java.util.Objects;

public class Film {

    int sifra;
    String naziv;
    int godina;
    String zanr;

    public int getSifra() {
        return sifra;
    }

    public void setSifra(int sifra) {
        this.sifra = sifra;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getGodina() {
        return godina;
    }

    public void setGodina(int godina) {
        this.godina = godina;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return sifra == film.sifra && godina == film.godina && Objects.equals(naziv, film.naziv) && Objects.equals(zanr, film.zanr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifra, naziv, godina, zanr);
    }

    @Override
    public String toString() {
        return "Sifra filma: " + sifra + ", naziv: " + naziv  + ", godina: " + godina + ", zanr:" + zanr ;
    }

    public Film(int sifra) {
        this.sifra = sifra;
    }

    public Film(int sifra, String naziv, int godina, String zanr) {
        this.sifra = sifra;
        this.naziv = naziv;
        this.godina = godina;
        this.zanr = zanr;
    }
}
