/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import org.correntista.Correntista;

/**
 *
 * @author willi
 * @throws IOException if an I/O error occurs
 */
@WebService(endpointInterface = "org.inter.Servico")
public class Impl implements Servico {

   

    @Override
    public Correntista Ted(String codigo, String saldo) {
        Correntista c = new Correntista();
        try {            
            String valor = "";
            String sql;
            sql = "SELECT saldo FROM correntista WHERE codigo = '" + codigo + "'";
            Connection con;
            PreparedStatement stmt;
            String driver = "org.postgresql.Driver";
            String caminho = "jdbc:postgresql://localhost:5432/bancoWebService";
            String user = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(caminho, user, senha);           
            ResultSet rs;
            Statement st;
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                valor = rs.getString("saldo");
            }
            int valorInteiro = Integer.parseInt(valor) + Integer.parseInt(saldo);
            sql = "update correntista "
                    + "set saldo = ? where  codigo = '" + codigo + "'";
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Integer.toString(valorInteiro));
            stmt.execute();
            stmt.close();
            sql = "SELECT saldo FROM correntista WHERE codigo = '" + codigo + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                c.setSaldo(rs.getString("saldo"));
            }
           sql = "SELECT nome FROM correntista WHERE codigo = '" + codigo + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
              c.setNome(rs.getString("nome"));;
            }
             sql = "SELECT codigo FROM correntista WHERE codigo = '" + codigo + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
              c.setCodigo(rs.getString("codigo"));;
            }
           
        } catch (SQLException ex) {
            System.out.println("Deu bosta no banco" + ex.getMessage());
        } catch (ClassNotFoundException ex) {
             System.out.println("Deu bosta na classe" + ex.getMessage());
        }
     

        return c;
    }

    @Override
    public Correntista returnObj(String codigo) {
        Correntista c = new Correntista();
        try {            
            String valor = "";
            String sql;
            sql = "SELECT saldo FROM correntista WHERE codigo = '" + codigo + "'";
            Connection con;
            PreparedStatement stmt;
            String driver = "org.postgresql.Driver";
            String caminho = "jdbc:postgresql://localhost:5432/bancoWebService";
            String user = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(caminho, user, senha);
            ResultSet rs;
            Statement st;            
            sql = "SELECT saldo FROM correntista WHERE codigo = '" + codigo + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                c.setSaldo(rs.getString("saldo"));
            }
           sql = "SELECT nome FROM correntista WHERE codigo = '" + codigo + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
              c.setNome(rs.getString("nome"));;
            }
             sql = "SELECT codigo FROM correntista WHERE codigo = '" + codigo + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
              c.setCodigo(rs.getString("codigo"));;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Impl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
     

        return c;
    }
    @Override
    public Correntista Cadastro(String nome){
        Correntista c = new Correntista();
        try{
            String valor = "";
            String sql;            
            Connection con;
            PreparedStatement stmt;
            String driver = "org.postgresql.Driver";
            String caminho = "jdbc:postgresql://localhost:5432/bancoWebService";
            String user = "postgres";
            String senha = "postgres";
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(caminho, user, senha);
            ResultSet rs;
            Statement st;  
            Random random = new Random();
            int temp = random.nextInt();
            if(temp < 0){
            temp = temp*-1;
            }
            sql = "insert into correntista (nome,codigo,saldo)" + "values(?,?,?)";
           stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, Integer.toString(temp) );
            stmt.setString(3, "0");           
            stmt.execute();
            stmt.close();                       
            sql = "SELECT saldo FROM correntista WHERE codigo = '" + Integer.toString(temp) + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                c.setSaldo(rs.getString("saldo"));
            }
           sql = "SELECT nome FROM correntista WHERE codigo = '" + Integer.toString(temp) + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
              c.setNome(rs.getString("nome"));;
            }
             sql = "SELECT codigo FROM correntista WHERE codigo = '" + Integer.toString(temp) + "'";
            st = (Statement) con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
              c.setCodigo(rs.getString("codigo"));;
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(Impl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Impl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return c;
    }

}

   
    
