/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.correntista;

import java.sql.SQLException;
import org.bd.Banco;

/**
 *
 * @author willi
 */
public class Teste {
    public static void main(String[] args) throws SQLException {
        Banco bd = new Banco();
        bd.conexao();
        System.out.println(bd.coletarDados("101010"));
    }
          
    
}
