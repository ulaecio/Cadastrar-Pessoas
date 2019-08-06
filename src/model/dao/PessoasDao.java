/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;

import connection.ConnectionFactory;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Pessoas;
/**
 *
 * @author ulaecio
 */
public class PessoasDao {
    
    //FAZ O "INSERT" NO BANCO DE DADOS
    
    public void create(Pessoas p) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO Pessoas (idade,nome)VALUES(?,?)");
            
            stmt.setInt(1,p.getIdade());
            stmt.setString(2,p.getNome());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar!");
            Logger.getLogger(PessoasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }
    public void delete(Pessoas p) throws SQLException{
        
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM pessoas WHERE id =(?)");
            
            stmt.setInt(0,p.getId());
                      
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir!");
            Logger.getLogger(PessoasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            
            ConnectionFactory.closeConnection(con, stmt);
            
        }
        
    }

        /*
    
        Connection con = null;
        PreparedStatement stmt;
        stmt = con.prepareStatement("DELETE FROM db_cadastro.pessoas where id = ?");

        stmt.setInt(0, p.getId());
        stmt.executeUpdate();

        stmt.close();
        con.close();
        }
*/
    //COLOCA OS DADOS DA "INTERFACE"
    
    public ArrayList<Pessoas> read() throws SQLException{
    
        Connection con = ConnectionFactory.getConnection();        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        ArrayList<Pessoas> pessoa = new ArrayList<>();
        try {
            stmt = con.prepareStatement("SELECT * FROM Pessoas");
            rs = stmt.executeQuery();
            while (rs.next()) {                
                Pessoas pessoas = new Pessoas();
                pessoas.setId(rs.getInt("id"));
                pessoas.setNome(rs.getString("nome"));
                pessoas.setIdade(rs.getInt("idade"));
                pessoa.add(pessoas);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(PessoasDao.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        
        ConnectionFactory.closeConnection(con, stmt, rs);
            
        }
        
        return pessoa;
    }
}
    

