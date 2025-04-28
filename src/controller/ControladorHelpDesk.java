package controller;

import model.*;
import javax.swing.*;
import java.util.ArrayList;

public class ControladorHelpDesk {
    private ArrayList<Funcionario> funcionarios = new ArrayList<>();
    private ArrayList<Tecnico> tecnicos = new ArrayList<>();
    private ArrayList<Chamado> chamados = new ArrayList<>();

    public void cadastrarFuncionario() {
        String nome = JOptionPane.showInputDialog("Nome do funcionário:");
        String email = JOptionPane.showInputDialog("Email:");
        String setor = JOptionPane.showInputDialog("Setor:");
        funcionarios.add(new Funcionario(nome, email, setor));
    }

    public void cadastrarTecnico() {
        String nome = JOptionPane.showInputDialog("Nome do técnico:");
        String especialidade = JOptionPane.showInputDialog("Especialidade:");
        tecnicos.add(new Tecnico(nome, especialidade));
    }

    public void criarChamado() {
        String titulo = JOptionPane.showInputDialog("Título do chamado:");
        String descricao = JOptionPane.showInputDialog("Descrição:");
        String emailFuncionario = JOptionPane.showInputDialog("Email do funcionário solicitante:");
        Funcionario f = funcionarios.stream().filter(func -> func.getEmail().equals(emailFuncionario)).findFirst().orElse(null);

        if (f != null) {
            chamados.add(new Chamado(titulo, descricao, f));
        } else {
            JOptionPane.showMessageDialog(null, "Funcionário não encontrado.");
        }
    }

    public void atribuirTecnico() {
        String tituloChamado = JOptionPane.showInputDialog("Título do chamado:");
        String nomeTecnico = JOptionPane.showInputDialog("Nome do técnico:");

        Chamado chamado = chamados.stream().filter(c -> c.getTitulo().equals(tituloChamado)).findFirst().orElse(null);
        Tecnico tecnico = tecnicos.stream().filter(t -> t.getNome().equals(nomeTecnico)).findFirst().orElse(null);

        if (chamado != null && tecnico != null) {
            chamado.setTecnicoResponsavel(tecnico);
        } else {
            JOptionPane.showMessageDialog(null, "Chamado ou Técnico não encontrado.");
        }
    }

    public void listarChamados() {
        StringBuilder sb = new StringBuilder();
        for (Chamado c : chamados) {
            sb.append(c).append("\n\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    public void atualizarStatus() {
        String tituloChamado = JOptionPane.showInputDialog("Título do chamado:");
        Chamado chamado = chamados.stream().filter(c -> c.getTitulo().equals(tituloChamado)).findFirst().orElse(null);

        if (chamado != null) {
            String[] statusOpcoes = {"Aberto", "Em atendimento", "Resolvido"};
            String novoStatus = (String) JOptionPane.showInputDialog(null, "Novo status:", "Atualizar Status",
                    JOptionPane.QUESTION_MESSAGE, null, statusOpcoes, chamado.getStatus());
            chamado.setStatus(novoStatus);
        } else {
            JOptionPane.showMessageDialog(null, "Chamado não encontrado.");
        }
    }
}
