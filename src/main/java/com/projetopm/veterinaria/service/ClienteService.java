package com.projetopm.veterinaria.service;

import com.projetopm.veterinaria.model.entities.Cliente;
import com.projetopm.veterinaria.model.repositories.ClienteRepository;
import dbutil.DBUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class ClienteService {

    int flag = 0;

    @Autowired
    private ClienteRepository repository;

    Connection connection;

    public ClienteService() throws SQLException {
        connection = DBUtil.getConnection();
    }

    public Cliente cadastroCliente(Cliente cliente){
       return repository.save(cliente);
    }

    public Cliente encontrarPorId(Integer id){
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public Cliente atualizarCliente(Integer id, Cliente clienteAtualizado){
        return repository.findById(id).map(cliente -> {
            cliente.setNome(clienteAtualizado.getNome());
            cliente.setCpf(clienteAtualizado.getCpf());
            cliente.setEmail(clienteAtualizado.getEmail());
            cliente.setSenha(clienteAtualizado.getSenha());
            return repository.save(cliente);
        }).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletarCliente(Integer id) {
        repository.findById(id).map(cliente -> {
            repository.delete(cliente);
            return Void.TYPE;
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public int validacaoLogin(String email, String senha){
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM veterinaria.tb_cliente WHERE email = '"+email+"';");
            ResultSet rs = statement.executeQuery();

            while(rs.next()){
                if(rs.getString(3).equals(email) && rs.getString(5).equals(senha)){
                    flag = 1;
                    System.out.println(flag);
                } else{
                    flag = 0;
                    System.out.println(flag);
                }
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return flag;
    }


    public Cliente buscarPorEmail(String email){
        return repository.findByEmail(email);
    }

}
