package ifmt.tsi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOPessoa {
    
    public void inserir(Pessoa pessoa){
        String url = "jdbc:postgresql://localhost:5432/ifmt";
        String user = "postgres", pass = "123456";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            
            String sql = "insert into pessoa (cpf, nome) values ("
                    + pessoa.getCpf() + ", '"+pessoa.getNome() + "')";
            System.out.println(sql);
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
    
    public void excluir(int cpf){
        String url = "jdbc:postgresql://localhost:5432/ifmt";
        String user = "postgres", pass = "123456";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            
            String sql = "delete from pessoa where cpf=" + cpf;
            System.out.println(sql);
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
        
    public void alterar(Pessoa pessoa){
        String url = "jdbc:postgresql://localhost:5432/ifmt";
        String user = "postgres", pass = "123456";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
                        
            String sql = "update pessoa set nome = '" + pessoa.getNome()
                    + "' where cpf = "+pessoa.getCpf();
            System.out.println(sql);
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            st.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }
    public void consultar() {
        String url = "jdbc:postgresql://localhost:5432/ifmt";
        String user = "postgres", pass = "123456";
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            String sqlSelect = "select * from pessoa";
            con = DriverManager.getConnection(url, user, pass);
            st = con.createStatement();
            rs = st.executeQuery(sqlSelect);
            while (rs.next()) {
                String nome = rs.getString("nome");
                int cpf = rs.getInt("cpf");
                System.out.println(nome + " - " + cpf);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                st.close();
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

}
