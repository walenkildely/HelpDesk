package main;

import controller.ControladorHelpDesk;

import javax.swing.*;

public class SistemaHelpDesk {
    public static void main(String[] args) {
        ControladorHelpDesk controlador = new ControladorHelpDesk();
        String[] opcoes = {"Cadastrar Funcionário", "Cadastrar Técnico", "Criar Chamado", "Atribuir Técnico", "Listar Chamados", "Atualizar Status", "Sair"};
        int opcao;

        do {
            opcao = JOptionPane.showOptionDialog(null, "Sistema de Help Desk", "Menu",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);

            switch (opcao) {
                case 0 -> controlador.cadastrarFuncionario();
                case 1 -> controlador.cadastrarTecnico();
                case 2 -> controlador.criarChamado();
                case 3 -> controlador.atribuirTecnico();
                case 4 -> controlador.listarChamados();
                case 5 -> controlador.atualizarStatus();
            }
        } while (opcao != 6);
    }
}
