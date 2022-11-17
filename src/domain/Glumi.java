package domain;

import java.util.Objects;

public class Glumi {
    Glumac glumac;
    Film film;
    String uloga;
    Double honorar;

    public Glumac getGlumac() {
        return glumac;
    }

    public void setGlumac(Glumac glumac) {
        this.glumac = glumac;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public Double getHonorar() {
        return honorar;
    }

    public void setHonorar(Double honorar) {
        this.honorar = honorar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glumi glumi = (Glumi) o;
        return Objects.equals(glumac, glumi.glumac) && Objects.equals(film, glumi.film) && Objects.equals(uloga, glumi.uloga) && Objects.equals(honorar, glumi.honorar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(glumac, film, uloga, honorar);
    }

    @Override
    public String toString() {
        return "Glumi{" +
                "glumac=" + glumac.getIme() +glumac.getPrezime()  + " u filmu" + film + ", ima ulogu:" + uloga  + ", honorar:" + honorar ;
    }

    public Glumi(Glumac glumac) {
        this.glumac = glumac;
    }

    public Glumi(Glumac glumac, Film film, String uloga, Double honorar) {
        this.glumac = glumac;
        this.film = film;
        this.uloga = uloga;
        this.honorar = honorar;
    }
}
