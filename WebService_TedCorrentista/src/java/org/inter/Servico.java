/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.inter;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import org.correntista.Correntista;

/**
 *
 * @author willi
 */
@WebService
@SOAPBinding(style = Style.RPC)
public interface Servico {
    @WebMethod Correntista Ted(String codigo, String saldo);
    @WebMethod Correntista Cadastro(String nome) ;   
    @WebMethod Correntista returnObj(String codigo);
    
}
