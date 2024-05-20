package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Controller.Conexao;
import Model.ClienteModel;

public class ClienteDAO {
    
    private Connection obterConexao() throws SQLException {
        return Conexao.obterConexao();
    }

    public void cadastrarCliente(ClienteModel cliente) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;

        try {
            conexao = obterConexao();
            String sql = "INSERT INTO cliente (codigo, nome, cpf, data_nascimento, email) VALUES (?, ?, ?, ?, ?)";
            pstmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            pstmt.setInt(1, cliente.getCodigo());
            pstmt.setString(2, cliente.getNome());
            pstmt.setString(3, cliente.getCpf());
            pstmt.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
            pstmt.setString(5, cliente.getEmail());

            pstmt.executeUpdate();
        } finally {
            fecharRecursos(pstmt, conexao);
        }
    }


    public boolean excluirCliente(int codigo) throws SQLException {
        try (Connection conexao = obterConexao();
             PreparedStatement stmt = conexao.prepareStatement("DELETE FROM cliente WHERE codigo=?")) {
            stmt.setInt(1, codigo);
            int linhasAfetadas = stmt.executeUpdate();
            return linhasAfetadas > 0;
        }
    }


    
    public boolean atualizarCliente(ClienteModel cliente) throws SQLException {
        try (Connection conexao = obterConexao();
             PreparedStatement stmt = conexao.prepareStatement("UPDATE cliente SET nome=?, cpf=?, data_nascimento=?, email=? WHERE codigo=?")) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
            stmt.setString(4, cliente.getEmail());
            stmt.setInt(5, cliente.getCodigo());
            int linhasAfetadas = stmt.executeUpdate();
            // Se uma linha foi afetada, significa que o cliente foi atualizado com sucesso
            return linhasAfetadas > 0;
        }
    }

    public ClienteModel consultarCliente(int codigo) throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conexao = obterConexao();
            pstmt = conexao.prepareStatement("SELECT * FROM cliente WHERE codigo=?");
            pstmt.setInt(1, codigo);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dataNascimento = rs.getDate("data_nascimento");
                String email = rs.getString("email");
                return new ClienteModel(codigo, nome, cpf, dataNascimento, email);
            } else {
                return null; // Cliente não encontrado
            }
        } finally {
            fecharRecursos(pstmt, conexao);
            if (rs != null) {
                rs.close();
            }
        }
    }
    
    
    public List<ClienteModel> buscarTodosClientes() throws SQLException {
        Connection conexao = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<ClienteModel> clientes = new ArrayList<>();
        try {
            conexao = obterConexao();
            pstmt = conexao.prepareStatement("SELECT * FROM cliente");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int codigo = rs.getInt("codigo");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                Date dataNascimento = rs.getDate("data_nascimento");
                String email = rs.getString("email");
                ClienteModel cliente = new ClienteModel(codigo, nome, cpf, dataNascimento, email);
                clientes.add(cliente);
            }
        } finally {
            fecharRecursos(pstmt, conexao);
            if (rs != null) {
                rs.close();
            }
        }
        return clientes;
    }
    
    private void fecharRecursos(PreparedStatement pstmt, Connection conexao) {
        try {
            if (pstmt != null) {
                pstmt.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }    
    
}
