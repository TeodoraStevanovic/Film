package db;

import domain.Film;
import domain.Glumac;
import domain.Glumi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseBroker {
    private Connection connection;
    public void connect() throws SQLException {
        if (connection==null || connection.isClosed()){
            try {
                String url="jdbc:mysql://localhost:3306/filmovi";
                connection= DriverManager.getConnection(url,"root","root");
                  connection.setAutoCommit(false);
            }catch (SQLException e) {
                System.out.println("Neuspesno uspostavljanje konekcije" + e.getMessage());
                throw e;
            }
        }

    }

    public void disconnect() throws SQLException {
        if (connection!=null){
            try {
                connection.close();
            }catch (SQLException e) {
                System.out.println("Neuspesno raskidanje konekcije" + e.getMessage());
                throw e;
            }
        }

    }
    public void commit() throws SQLException {
        if (connection!=null){
            try {
                connection.commit();
                System.out.println("Uspesno potvrdjena transakcija");
            }catch (SQLException e) {
                System.out.println("Neuspesno potvrdjena  transkacija" + e.getMessage());
                throw e;
            }
        }

    }
    public void rollback() throws SQLException {
        if (connection!=null){
            try {
                connection.rollback();
                System.out.println("Uspesno ponistena transakcija");
            }catch (SQLException e) {
                System.out.println("Neuspesno ponistena  transkacija" + e.getMessage());
                throw e;
            }
        }

    }
    public void addGlumca(Glumac glumac) throws SQLException{
        try {
            String upit="INSERT INTO glumac (ime,prezime,godinaRodjenja) VALUES (?,?,?)";
            PreparedStatement statement=connection.prepareStatement(upit,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,glumac.getIme());
            statement.setString(2,glumac.getPrezime());
            statement.setDouble(3,glumac.getGodinaRodjenja());
statement.executeUpdate();
            ResultSet rs=statement.getGeneratedKeys();
            if(rs.next()){
                glumac.setIdg(rs.getInt(1));
            }
commit();
rs.close();
            statement.close();
            System.out.println("Uspesno dodat novi glumac!");
        } catch (SQLException ex) {
            rollback();
            System.out.println("Neuspesno dodavanje glumca!\n"+ex);
            throw ex;
        }
    }
//brisanje filma
public void deleteFilm(int sifra) throws SQLException {
    try {
        String upit = "DELETE FROM film WHERE sifra=? ";
        PreparedStatement ps = connection.prepareStatement(upit);
        // Statement statement = connection.createStatement();

        ps.setInt(1, sifra);
        ps.executeUpdate();
        commit();
        System.out.println("Uspesno obrisan film!");
    } catch (SQLException ex) {
        System.out.println("Neuspesno brisanje filma!");
        ex.printStackTrace();
        rollback();
        throw ex;
    }
}

    public List<Film> getAllFilmovi(int idglumca) throws SQLException{
        List<Film> filmovi=new ArrayList<>();
        try{
            String upit="SELECT *  FROM film f INNER JOIN glumi g ON f.sifra=g.sifra  INNER JOIN glumac gl ON gl.idg=g.idg WHERE gl.idg="+idglumca;
//,g.idg AS gidg,g.sifra AS gsifra,g.uloga AS guloga, g.honorar AS ghonorar
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery(upit);
            while(rs.next()){



                int sifra=rs.getInt("sifra");
                String naziv=rs.getString("naziv");
                int godina=rs.getInt("godina");
                String zanr=rs.getString("zanr");
                Film film=new Film(sifra,naziv,godina,zanr);
                int id=rs.getInt("idg");
                String ime=rs.getString("ime");
                int godinar=rs.getInt("godinaRodjenja");
                String prezime=rs.getString("prezime");
                Glumac glumac=new Glumac(id,ime,prezime,godinar);

                String uloga=rs.getString("uloga");;
                Double honorar=rs.getDouble("honorar");
                Glumi glumi=new Glumi(glumac,film,uloga,honorar);

                        filmovi.add(film);
            }
            rs.close();
            statement.close();
            System.out.println("Uspesno ucitavanje liste Glumaca!");
        }catch(SQLException ex){
            System.out.println("Neuspesno ucitavanje liste Glumaca!");
            throw ex;
        }


        return filmovi;
    }

//izmena honorara glumcu za film u kom glumi

public void editHonorar(   int idglumca, int sifrafilma,double novHonorar) throws SQLException {
   try{ String upit = "UPDATE glumi SET honorar=? where idg ="+idglumca+" AND sifra="+sifrafilma;

    PreparedStatement ps = connection.prepareStatement(upit);
    ps.setDouble(1, novHonorar);

    ps.executeUpdate();
    commit();
       System.out.println("uspesna izmena!");
   }catch(SQLException ex){
       System.out.println("Neuspesna izmena!");
       rollback();
       throw ex;
   }
}




}
