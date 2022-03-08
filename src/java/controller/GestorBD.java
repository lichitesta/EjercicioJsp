/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Gasto;

/**
 *
 * @author Lisandro
 */
public class GestorBD {
    
    
    String CONN = "jdbc:sqlserver://localhost:1433;databaseName=ExamenFinal";
    String USER = "sa";
    String PASS = "1234";
    
    public GestorBD(){
        try {
            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
            
    
    public ArrayList<Categoria> obtenerCategorias(){
        
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        
        try { 
            Connection conn = DriverManager.getConnection(CONN,USER,PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Categorias");
            
            while(rs.next()){
            int id = rs.getInt("idCategoria");
            String nombre = rs.getString("nombre");
            
            Categoria ca = new Categoria(id,nombre);
            listaCategorias.add(ca);
            
            }
            
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
        return listaCategorias;
    }
    
    
     public ArrayList<Gasto> obtenerGastos(){
       ArrayList<Gasto> listaGastos = new ArrayList<>();
       
         try { 
            Connection conn = DriverManager.getConnection(CONN,USER,PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Gastos");
            
            while(rs.next()){
            int id = rs.getInt("idGasto");
            int idCategoria = rs.getInt("idCategoria");
            float importe = rs.getFloat("importe");           
            
            Categoria ca = ObtenerCategoriaPorId(idCategoria);
            
            Gasto ga = new Gasto(id,ca,importe);
            listaGastos.add(ga);
            
            }                                 
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       return listaGastos;
    }
     
     
     
     public Categoria ObtenerCategoriaPorId(int idGasto){
      Categoria categoria  = new Categoria(1,"no se encontro la categoria");
       
         try { 
            Connection conn = DriverManager.getConnection(CONN,USER,PASS);
            
            PreparedStatement pstmt = conn.prepareStatement("select * from Categorias where idCategoria=?");
            pstmt.setInt(1, idGasto);  
            
            ResultSet rs = pstmt.executeQuery();
            
            if(rs.next()){
            String nombre = rs.getString("nombre");                 
            categoria = new Categoria(idGasto, nombre);
             
            }                                 
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       return categoria;
    }

    public void InsertarGasto(Gasto ga) {
        
         System.out.println(ga);
         
         
           try { 
            Connection conn = DriverManager.getConnection(CONN,USER,PASS);
            
            PreparedStatement pstmt = conn.prepareStatement("insert into Gastos(motivo, idCategoria, importe) values(?,?,?)");
            pstmt.setString(1, ga.getCategoria().getNombre());  
            pstmt.setInt(2, ga.getCategoria().getIdCategoria());  
            pstmt.setFloat(3, ga.getImporte());      
            
            pstmt.execute();   
            
            
            pstmt.close();
            conn.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(GestorBD.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       
    }
    
    
   
        
    }
    
    
    

