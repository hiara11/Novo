package br.sc.senac.mcap.dao;

import br.sc.senac.mcap.model.Login;
import br.sc.senac.mcap.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LoginDao {

    public static ArrayList<Login>buscarLogin() throws SQLException{
        ArrayList<Login>LoginAux = new ArrayList<>();

        String sql = "select log_nome, log_senha from login";
        Connection conexao = ConnectionFactory.getConexao();
        PreparedStatement ps = conexao.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Login login = new Login();
            login.setLogin(rs.getString("log_nome"));
            login.setSenha(rs.getString("log_senha"));
            LoginAux.add(login);
        }
       return LoginAux;
    }
}
