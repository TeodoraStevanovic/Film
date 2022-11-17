package domain;

import java.util.Objects;

public class Glumac {
    int idg;
    String ime;
    String prezime;
    int godinaRodjenja;

    public Glumac(int idg, String ime, String prezime, int godinaRodjenja) {
        this.idg = idg;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
    }

    public Glumac() {

    }

    public int getIdg() {
        return idg;
    }

    public void setIdg(int idg) {
        this.idg = idg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public void setGodinaRodjenja(int godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Glumac glumac = (Glumac) o;
        return idg == glumac.idg && godinaRodjenja == glumac.godinaRodjenja && Objects.equals(ime, glumac.ime) && Objects.equals(prezime, glumac.prezime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idg, ime, prezime, godinaRodjenja);
    }

    @Override
    public String toString() {
        return "id: " + idg +", ime: " + ime  + ", prezime: " + prezime + ", godinaRodjenja: " + godinaRodjenja ;
    }
}
