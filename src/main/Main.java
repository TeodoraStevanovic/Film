package main;

import db.DatabaseBroker;
import domain.Film;
import domain.Glumac;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        //////
        DatabaseBroker db=new DatabaseBroker();
        db.connect();
        //napravi novog glumca
        Glumac g1= new Glumac();
        g1.setIdg(6);
        g1.setIme("Kevin");
        g1.setPrezime("Hart");
        g1.setGodinaRodjenja(1979);

       // db.addGlumca(g1);


////////////////////////////////////////////////////////
        //obrisi glumca sa id 6
       // db.deleteFilm(6);
/////////////////////////////

        //prikaz filmova u kojima je glumio Kevin Hart
        //

        ArrayList<Film> filmovi= (ArrayList<Film>) db.getAllFilmovi(10);
        for (Film f: filmovi) {
            System.out.println("-"+f);

        }
         db.editHonorar(2,1,87560.000);
    }
}
