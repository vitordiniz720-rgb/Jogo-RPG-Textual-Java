# Deep Memories 🌻

RPG textual de masmorra feito em Java, para o terminal. Projeto em grupo da matéria de Projeto Integrador (ADS – Senac SP).

## Sobre o jogo

Sophie é uma adolescente que lida com a doença da mãe e com sentimentos que não consegue expressar. Ao encontrar uma fonte mágica na mata, ela mergulha nas próprias memórias.

Cada andar da masmorra é uma memória, e cada memória guarda uma emoção que precisa ser enfrentada ou aceita para seguir adiante:

| Andar | Lugar | Emoção |
|-------|-------|--------|
| 1 | A Pipa | Saudade |
| 2 | A Garagem | Raiva |
| 3 | O Corredor | Medo |
| 4 | O Quarto | Tristeza e Culpa |
| 5 | A Fonte | Escolha final |

As escolhas do jogador mudam o desfecho: existem **dois finais** (bom e ruim).

## Como funciona

- **Combate por turnos** inspirado em Pokémon: Atacar, Item ou Fugir.
- **Renascimento:** se Sophie morre, ela volta mais fraca (perde vida máxima) e luta até vencer. Não existe game over.
- **Inventário e itens:** poções de cura, força e crítico, equipamentos e itens especiais.
- **Baús** que sorteiam itens, e um caça-palavras para abrir um deles.
- **Arte ASCII colorida** em cada cena (cores ANSI).

## Tecnologias e conceitos

- Java
- Programação Orientada a Objetos (classes `Personagem`, `Inimigo`, `Item`, `Inventario`, `Bau`, `MenuCombate`, `MenuInicial`, `ArteAscii`)
- `ArrayList`, vetores de `String`, `switch`, laços e métodos estáticos
- Entrada de dados com `Scanner`

## Equipe

- Vitor Diniz Vasconcelos – Criei todos os objetos usados no jogo para facilitar a criação de todo o jogo textual, além também da criação dos andares 1,3 e 4 para contar a história do jogo
- João Pedro Silva Leite
- Matheus de Oliveira Quaresma
- Danilo Soares da Silva
- Gabriel Reimberg Bezerra
- Paulo Henrique Pereira Rosa
