package TextualGame;

import java.util.Random;

public class Bau {
    public Random gerador = new Random();

    public void abrir(Inventario inventarioJogador, Personagem personagem) {
        int sorteio = gerador.nextInt(4);
        Item itemSorteado = null;

        if (sorteio == 0) {
            System.out.println("O baú brilhou em vermelho! Você encontrou uma Poção de Vida.");
            itemSorteado = new Item("Poção de Vida", "cura", 25);

        } else if (sorteio == 1) {
            System.out.println("O baú tremeu! Você ganhou uma Poção de Força.");
            itemSorteado = new Item("Poção de Força", "aumento_dano", 10);

        } else if (sorteio == 2) {
            System.out.println("O baú fez um som metálico! Você ganhou uma Poção de Crítico.");
            itemSorteado = new Item("Poção de Crítico", "aumento_critico", 10);
            
        } else {
            
            if(personagem.bonusLuck > 0) {
                itemSorteado = new Item("Apanhador de sonhos", "fraqueza_inimigos", 2);
                System.out.println("O baú fez um som místico! Você ganhou um Apanhador de sonhos.");
            } else {
                System.out.println("O baú estava vazio.");
            }
            System.out.println("O baú estava vazio");

        }

        if (itemSorteado != null) {
            inventarioJogador.adicionarItem(itemSorteado);
        }
    }
}
