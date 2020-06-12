package dbUtils;

import dbObjects.*;
import oracle.jdbc.OracleTypes;

import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

public class CallableStatementParameter {

    public Connection getDBConnectionFromPropertiesFile() {
        Connection ret = null;

        try
        {
            // Create Properties object.
            Properties props = new Properties();

            File dbPropsFile = new File("src/main/resources/JDBCSettings.properties");

            FileReader fileReader = new FileReader(dbPropsFile);

            // Load jdbc related properties in above file.
            props.load(fileReader);

            // Get each property value.
            String dbDriverClass = props.getProperty("db.driver.class");

            String dbConnUrl = props.getProperty("db.conn.url");

            String dbUserName = props.getProperty("db.username");

            String dbPassword = props.getProperty("db.password");

            /* Register jdbc driver class. */
            Class.forName(dbDriverClass);

            // Get database connection object.
            ret = DriverManager.getConnection(dbConnUrl, dbUserName, dbPassword);

        }catch(Exception ex)
        {
            ex.printStackTrace();
        }finally
        {
            return ret;
        }
    }






    //TYP_LACZA
    public String proceduraZapiszRodzajLacza(String nazwa) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.RODZAJ_LACZA(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, nazwa);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<RodzajLacza> widokRodzajowLacza() {
        List<RodzajLacza> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "SELECT * FROM RODZAJ_LACZA";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nazwa = rs.getString("NAZWA");


                arrayList.add(new RodzajLacza(id,nazwa));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunRodzajLacza(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.RODZAJ_LACZA(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //USLUGE
    public String proceduraZapiszUsluge(String nazwa, Integer predkosc, Integer rodzaj_id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.USLUGE(?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, nazwa);
            cStmt.setInt(2,predkosc);
            cStmt.setInt(3,rodzaj_id);
            cStmt.registerOutParameter(4, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(4);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public String proceduraZapiszUsluge2(String nazwa) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.USLUGE(?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, nazwa);
            System.out.println("java sql integer "+java.sql.Types.INTEGER);
            cStmt.setNull(2, java.sql.Types.INTEGER);
            cStmt.setNull(3,java.sql.Types.INTEGER);
            cStmt.registerOutParameter(4, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(4);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Usluga> widokUslug() {
        List<Usluga> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select usluga.id, usluga.nazwa,predkosc_lacza, rodzaj_lacza.nazwa as nazwalacza from usluga left join rodzaj_lacza on usluga.rodzaj_lacza_id=rodzaj_lacza.id";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String nazwa = rs.getString("NAZWA");
                Integer predkosc = rs.getInt("PREDKOSC_LACZA");
                String rodzaj = rs.getString("nazwalacza");
                arrayList.add(new Usluga(id,nazwa,predkosc,rodzaj));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunUsluge(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.USLUGE(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //MIEJSCOWOSC
    public String proceduraZapiszMiejscowosc(String kod_pocztowy, String nazwa) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.MIEJSCOWOSC(?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, kod_pocztowy);
            cStmt.setString(2, nazwa);
            cStmt.registerOutParameter(3, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(3);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Miejscowosc> widokMiejscowosci() {
        List<Miejscowosc> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "SELECT * FROM MIEJSCOWOSC";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String kod = rs.getString("KOD_POCZTOWY");
                String nazwa = rs.getString("NAZWA");


                arrayList.add(new Miejscowosc(kod,nazwa));
            }
        } catch (SQLException e ) {
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunMiejscowosc(String kod) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.MIEJSCOWOSC(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, kod);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //KLIENT
    public String proceduraZapiszKlienta(String imie, String nazwisko, String kod_pocztowy, String ulica, String numer_lokalu, String tel_kontakt) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.KLIENTA(?,?,?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setString(1, imie);
            cStmt.setString(2,nazwisko);
            cStmt.setString(3,kod_pocztowy);
            cStmt.setString(4, ulica);
            cStmt.setString(5,numer_lokalu);
            cStmt.setString(6,tel_kontakt);
            cStmt.registerOutParameter(7, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(7);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Klient> widokKlientow() {
        List<Klient> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select klient.id,imie,nazwisko,klient.kod_pocztowy,ulica,numer_lokalu,tel_kontakt,miejscowosc.nazwa from klient\n" +
                        "join miejscowosc on miejscowosc.kod_pocztowy = klient.kod_pocztowy";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("ID");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String kod_pocztowy = rs.getString("kod_pocztowy");
                String ulica = rs.getString("ulica");
                String numer_lokalu = rs.getString("numer_lokalu");
                String tel_kontakt = rs.getString("tel_kontakt");
                String nazwa_miejscowosci = rs.getString("NAZWA");

                arrayList.add(new Klient(id,imie,nazwisko,kod_pocztowy,ulica,numer_lokalu,tel_kontakt,nazwa_miejscowosci));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunKlienta(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.KLIENTA(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //UMOWA
    public String proceduraZapiszUmowe(Integer id_uslugi, Integer id_klienta, Date data_start, Date data_koniec, String kwota_zobowiazania) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call DODAJ.UMOWE(?,?,?,?,?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id_uslugi);
            cStmt.setInt(2,id_klienta);
            cStmt.setDate(3, (java.sql.Date) data_start);
            cStmt.setDate(4, (java.sql.Date) data_koniec);
            cStmt.setString(5,kwota_zobowiazania);
            cStmt.registerOutParameter(6, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(6);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            //ex.printStackTrace();
            return "Error - wprowadzona wartość musi być liczbą!";
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    public List<Umowa> widokUslugaUmowa() {
        List<Umowa> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select umowa.id,data_start,data_koniec, klient.imie,klient.nazwisko, usluga.nazwa as nazwauslugi, usluga.predkosc_lacza, ro.nazwa as nazwarodzajulacza from umowa\n" +
                        "join klient on umowa.id_klienta = klient.id\n" +
                        "join usluga on umowa.id_uslugi=usluga.id\n" +
                        "left join rodzaj_lacza ro on usluga.rodzaj_lacza_id = ro.id";

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_umowy = rs.getInt("id");
                Date dataStart = rs.getDate("data_start");
                Date dataKoniec = rs.getDate("data_koniec");
                String imie = rs.getString("imie");
                String nazwisko = rs.getString("nazwisko");
                String nazwauslugi = rs.getString("nazwauslugi");
                String predkosc_lacza = String.valueOf(rs.getInt("predkosc_lacza"));
                String nazwarodzajulacza = rs.getString("nazwarodzajulacza");
                arrayList.add(new Umowa(id_umowy,dataStart,dataKoniec,imie,nazwisko,nazwauslugi,predkosc_lacza,nazwarodzajulacza));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String usunUmowe(int id) {
        String error = "";
        try {
            Connection dbConn = this.getDBConnectionFromPropertiesFile();
            String storedProcedureCall = "{call USUN.UMOWE(?,?)}";
            CallableStatement cStmt = dbConn.prepareCall(storedProcedureCall);

            cStmt.setInt(1, id);
            cStmt.registerOutParameter(2, Types.VARCHAR);

            cStmt.executeUpdate();
            error = cStmt.getString(2);

            System.out.println("Błędy\n" + error);

            cStmt.close();
            dbConn.close();
        }catch(Exception ex) {
            ex.printStackTrace();
        }finally {
            try {
                getDBConnectionFromPropertiesFile().close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return error;
    }

    //OPLATA
    public List<Oplata> widokOplat(int id) {
        List<Oplata> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "select * from OPLATA_ZA_USLUGE where ID_UMOWY="+id;

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id_oplaty = rs.getInt("ID");
                Integer id_umowy = rs.getInt("id_umowy");
                Integer czy_zaplacone = rs.getInt("czy_zaplacone");
                Date data = rs.getDate("termin_platnosci");


                arrayList.add(new Oplata(id_oplaty,id_umowy,czy_zaplacone,data));
            }
        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }

        return arrayList;
    }

    public String oznaczJakoOplacone(int id) {
        List<Umowa> arrayList = new ArrayList<>();
        Statement stmt = null;
        String query =
                "UPDATE OPLATA_ZA_USLUGE set CZY_ZAPLACONE=CZY_ZAPLACONE*(-1) where ID="+id;

        try {
            Connection con = this.getDBConnectionFromPropertiesFile();
            stmt = con.createStatement();
            stmt.executeQuery(query);
        } catch (SQLException e ) {
            e.printStackTrace();
            System.out.println("Coś się zjebało");
        } finally {
            if (stmt != null) {
                try {
                    getDBConnectionFromPropertiesFile().close();
                    stmt.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        }
        return "ok";
    }


}
