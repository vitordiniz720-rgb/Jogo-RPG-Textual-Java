package TextualGame;

import java.util.Scanner;

public class DeepMemories {

    // Quantas vezes a personagem já morreu
    static int mortes = 0;

    // Regras do renascimento (mudem aqui se ficar difícil ou fácil demais)
    static final double PERDA_VIDA_MAXIMA = 0.10; // perde 10% da vida máxima a cada morte
    static final double VIDA_AO_RENASCER = 0.70; // volta com 70% da vida máxima
    static final int VIDA_MAXIMA_MINIMA = 50; // a vida máxima nunca cai abaixo disso

    // ======================================= Main ===============================


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Personagem personagem = new Personagem();
        Inventario inventario = new Inventario();
        MenuCombate menuCombate = new MenuCombate();
        Bau bau = new Bau();

        personagem.pNome = "Sophie";

        MenuInicial.exibir(sc);



        // =-=-=-=-=-=-=-=-=-=-=-=-=-=- CENAS -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=//
        executarIntroducao(sc);
        executarAndar1(sc,inventario,personagem,menuCombate,bau);
        executarAndar2(sc,inventario,personagem,menuCombate,bau);
        executarAndar3(sc,inventario,personagem,menuCombate,bau);
        executarAndar4(sc,inventario,personagem,menuCombate,bau);
        executarAndar5(sc,inventario,personagem,menuCombate,bau);

        //final(A Fonte)

        // =-=-=-=-=-=-=-=-=-=-=-=-=-=- CENAS -=-=-=-=-=-=-=-=-=-=-=-=-=-=-=//





        // Exemplo de como usar o lutarAteVencer (Lutar com um boss, se a personagem
        // morrer ela renasce com o hp nerfado e fica na luta ate ganhar
        // --->lutarAteVencer(sc, personagem, inventario, menuCombate, "Eco da Culpa",
        // 50, 8);
        // Scanner, personagem, inventario, menuCombate, Nome do inimigo, Vida do
        // inimigo, Dano do inimigo
    }
    // ==================================Main ========================================


    //==========================METODOS E ANDARES A BAIXO=============================


    // ==============COMBATE COM RENASCIMENTO (não precisa mexer) =============

    // Repete a luta até a personagem vencer. Se ela morrer, renasce mais fraca.

    public static void lutarAteVencer(Scanner sc, Personagem personagem, Inventario inventario, MenuCombate menuCombate,
                                      String nome, int vida, int dano) {

        boolean venceu = false;

        while (!venceu) {
            Inimigo inimigo = new Inimigo(nome, vida, dano); // inimigo novo a cada tentativa
            menuCombate.iniciarCombate(personagem, inimigo, inventario, sc);

            if (personagem.pHp <= 0) {
                renascer(personagem);
            } else if (inimigo.hp <= 0) {
                venceu = true;
            } else {
                System.out.println("Não há para onde fugir. O medo te alcança de novo...");
            }
        }
    }

    // Penalidade da morte: perde vida máxima e volta com parte da vida
    public static void renascer(Personagem personagem) {
        mortes++;

        System.out.println("");
        System.out.println("Tudo escurece... mas a fonte não deixa você partir.");

        personagem.pMaxHp = Math.max(VIDA_MAXIMA_MINIMA, (int) (personagem.pMaxHp * (1 - PERDA_VIDA_MAXIMA)));
        personagem.pHp = Math.max(1, (int) (personagem.pMaxHp * VIDA_AO_RENASCER));

        System.out.println("Você acorda mais fraca. Vida: " + personagem.pHp + "/" + personagem.pMaxHp);
    }

    // PAUSA ENTRE TEXTOS (para o jogador ler com calma)
    public static void pausar(Scanner sc) {
        System.out.println("(pressione ENTER para continuar)");
        sc.nextLine();
        sc.nextLine();
    }

    // Mostra cada parágrafo do array e exibe a cada 2.5 segundos
    public static void exibirParagrafos(Scanner scanner, String[] paragrafos) {
        for (String paragrafo : paragrafos) {
            System.out.println();
            System.out.println(paragrafo);
            System.out.println();

            try {
                // Pausa de 2.5 segundos (2500 milissegundos) entre os parágrafos
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // Caso a thread seja interrompida, exibe o erro e interrompe o loop
                Thread.currentThread().interrupt();
                System.out.println("A exibição do prólogo foi interrompida.");
                return;
            }

            //Os textos estavam passando sem dar para ler direito por ser muita coisa, por enquanto desativei o com delay
            //mas se quiserem usar no final do projeto a gente ativa a parte do try catch
            /*
            try {
                // Pausa de 2.5 segundos (2500 milissegundos) entre os parágrafos
                Thread.sleep(4500);
            } catch (InterruptedException e) {
                // Caso a thread seja interrompida, exibe o erro e interrompe o loop
                Thread.currentThread().interrupt();
                System.out.println("A exibição do prólogo foi interrompida.");
                return;
            }

             */
        }
    }

    // =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-= INICIO =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-

// INTRODUÇÃO (manhã do primeiro dia), já inicia o prólogo no final da introdução, então nao precisa chamar o executar prologo
// =========================================

    public static void executarIntroducao(Scanner scanner) {
        ArteAscii.desenharCasa();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {

        }

        System.out.println("§§§§§§§§§§§§§§§§§§§§§§§§§§§§" + " PRIMEIRO DIA " + "§§§§§§§§§§§§§§§§§§§§§§§§§§§§");
        

        String[] paragrafos = {
                "Sophie acorda devagar, como quem sobe do fundo de um lago. No sonho que ainda\nnão largou, havia uma risada alta, dessas que enchem a casa inteira. Uma risada\nque ela conhece bem, mas que faz tempo que não ouve.",

                "O quarto já está claro. O despertador toca pela segunda vez, e um peso quente se\nmexe em cima dos seus pés. É Mr. Cuddles, o cachorro dela desde que era filhote,\nolhando como quem pergunta se já pode começar o dia.",

                "Sophie: \"Tô acordada, tô acordada.\"",

                "Ela estica a mão até o celular na mesa de cabeceira. Hoje é o primeiro dia na\nescola nova, e ela passou a noite abrindo e fechando o site do colégio. Na foto\nde capa, o portão aparece pequeno e simpático, cercado de alunos sorrindo, todo\nmundo parecendo ter nascido ali dentro.",

                "Sophie olha a foto por tempo demais. Ela é do tipo que sente muito e fala pouco,\ne sabe que, no portão de verdade, ninguém vai adivinhar o que passa pela cabeça\ndela.",

                "Em outra época, ela teria corrido até a mãe para contar do nervosismo. Mas a\ncasa mudou. Helena, a mãe de Sophie, tem uma doença sem cura, e cada dia pede um\npouco mais de descanso dela.",

                "Sophie desce a escada com Mr. Cuddles atrás, as unhas dele batendo no chão a\ncada degrau.",

                "Na sala, Helena está deitada no sofá, coberta com a manta que agora vive ali.\nPálida e cansada, ela abre os olhos assim que ouve os passos da filha.",

                "Helena: \"Hoje é o grande dia, hein, Sô?\"",

                "Sophie: \"É... acho que sim.\"",

                "Helena: \"Você vai se sair bem. Só não se esconde, tá?\"",

                "Sophie promete com a cabeça, sem ter certeza de que vai conseguir cumprir.",

                "Na cozinha, o pai está sentado à mesa, cercado de papéis que separa em pilhas\nsem parar. Marcos nunca foi de falar muito, mas ultimamente parece ainda mais\nlonge, como se estivesse na mesa e em outro lugar ao mesmo tempo.",

                "Marcos: \"Bom dia.\"",

                "Só isso. Ele não pergunta do primeiro dia, nem se ela está nervosa. Para Sophie,\naquele silêncio é uma parede, e ela não sabe se ele não vê o que está\nacontecendo ou se não quer ver.",

                "Uma xícara de leite espera no lugar dela, ainda quente. Sophie bebe em pé, sem\npensar muito em quem a deixou ali.",

                "Ela pega a mochila, aperta a alça com força e para na porta. Mr. Cuddles se\nsenta ao lado dela, com o rabo varrendo o chão, como quem acha que também vai.",

                "Sophie: \"Hoje não, amigão. Fica de olho na mãe, tá?\"",

                "Ele inclina a cabeça, como se entendesse cada palavra, e volta devagar para\njunto do sofá.",

                "Sophie olha uma última vez para dentro da casa: a mãe de olhos fechados outra\nvez, o pai entre os papéis, o cachorro deitado ao lado dela. Respira fundo e\nsai.",

                "No caminho, o medo de ser a nova vai ficando mais pesado a cada quarteirão. Ela\nrepete para si mesma que é só um portão, só um dia, e pensa na foto do site, tão\npequena e tranquila. Quando finalmente chega, descobre que a foto não contava\ntudo."
        };

        exibirParagrafos(scanner, paragrafos);

        // Continua direto na história que já existe (arte + cenas do prólogo)
        executarPrologo(scanner);
    }

    // =========================================
    // PRÓLOGO
    // =========================================

    public static void executarPrologo(Scanner scanner) {

        // Arte inicial
        ArteAscii.desenharGirassol3D();

        String[] paragrafos = {
                "O portão da escola parece maior do que no site. Sophie aperta a alça da mochila.\nAo redor, grupos riem, se abraçam, se reconhecem. Ninguém olha para ela, e de\nalgum jeito isso dói mais.",

                "No pátio, todas as mesas parecem ter dono. Uma garota de cabelo bagunçado acena\ncom a mão inteira.",

                "Lia: \"Você é a novata, né? Senta aí, essa mesa é neutra. Eu falo demais, mas\nprometo que não mordo.\"",

                "Do outro lado da mesa, um garoto desenha em um caderno e não levanta os olhos.\nTheo, alguém apresenta. Ele acena com o lápis. Só isso. Estranhamente, é\nconfortável.",

                "Assim que Sophie abre a porta de casa, Mr. Cuddles vem correndo, com o rabo\nbalançando tão forte que o corpo inteiro balança junto. Ele é o único da casa\nque ainda age como se nada tivesse mudado.",

                "Ele encosta o focinho no rosto dela. É só um momento de respiro.",

                "Mr. Cuddles a segue até a sala e se deita nos pés de Helena, como se soubesse\nque o lugar dele agora é ali. Helena está deitada no sofá, mais magra do que na\nsemana passada. Ela sorri antes de abrir os olhos.",

                "Helena: \"E aí, filha? Como foi o primeiro dia?\"",

                "Na cozinha, Marcos separa papéis sem olhar para ela. Sophie para na porta.",

                "Marcos: \"Tô. Vai descansar.\" Ele responde sem levantar a cabeça. Sophie\ninterpreta o silêncio do jeito mais duro.",

                "Dias depois, na biblioteca, Sophie encontra um recorte antigo sobre uma fonte\nescondida na mata, além do fim da cidade. Diz a lenda que quem se aproxima dela\nrevê suas memórias mais profundas.",

                "Lia e Theo estão na mesa ao lado.",

                "A mata. A fonte de pedra coberta de musgo. A água parada reflete um céu que não\né o de hoje.",

                "Sophie toca a superfície. O mundo se dobra."
        };

        exibirParagrafos(scanner, paragrafos);

        System.out.println();
        System.out.println("Sophie mergulha na fonte...");
        System.out.println();
    }

    // =========================================
    // ANDAR 1
    // =========================================

    public static void executarAndar1(Scanner scanner, Inventario inventario, Personagem personagem,
                                      MenuCombate menuCombate, Bau bau) {
        ArteAscii.desenharMapa();
        String[] paragrafos = {
                "Sophie abre os olhos em um quintal de sol alto e grama molhada. É a casa antiga.\nO cheiro é de bolo no forno. Ela sabe onde está antes de ver: uma tarde de\ndomingo de muito tempo atrás.",

                "No meio do gramado, uma menina de uns oito anos corre segurando o carretel de\numa pipa. Atrás dela, Helena, saudável, com o cabelo preso de qualquer jeito, ri\nalto. Um filhote de Mr. Cuddles pula atrás da linha.",

                "Helena: \"Segura firme, Sô! Deixa o vento puxar!\"",

                "Ninguém a vê. Sophie é só uma sombra na beira do quintal."
        };

        exibirParagrafos(scanner, paragrafos);

        /*System.out.println();
        System.out.println("O que deseja fazer?");
        System.out.println();
        System.out.println("1. Chegar perto e assistir a cena até o fim.");
        System.out.println("2. Ficar de longe, sem se mexer.");
        System.out.println("3. Correr até a mãe e tentar falar com ela.");
        */

        //
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                                                                                         |");
        System.out.println("                                                                                         !");
        System.out.println("  O que deseja fazer?                                                                    |");
        System.out.println("                                                                                         !");
        System.out.println("1. Chegar perto e assistir a cena até o fim.                                             |");
        System.out.println("2. Ficar de longe, sem se mexer.                                                         !");
        System.out.println("3. Correr até a mãe e tentar falar com ela.                                              |");
        System.out.println("                                                                                         !");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        //
        int opcao = 0;
        while (opcao < 1 || opcao > 3) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3")) {
                opcao = Integer.parseInt(entrada);
            } else {
                System.out.println("Escolha 1, 2 ou 3.");
            }
        }

        String[] reacao;

        switch (opcao) {
            case 1:
                reacao = new String[] {
                        "Sophie dá um passo, depois outro, até sentir a grama úmida roçar nos tornozelos.\nEla para a poucos metros e fica ali, quieta, olhando.",

                        "A pipa sobe devagar, depois de uma vez só, e a menina grita de alegria. Helena\njoga a cabeça para trás e ri, e Mr. Cuddles late para o céu como se pudesse\nalcançá-la.",

                        "Sophie sente o peito apertar e aquecer ao mesmo tempo. Faz muito tempo que ela\nnão via a mãe rir assim, e ela deixa a cena acontecer inteira, sem desviar o\nolhar."
                };
                break;
            case 2:
                reacao = new String[] {
                        "Sophie não se mexe. Os pés parecem presos na sombra da árvore, e de lá ela vê a\ncena como quem olha por uma janela.",

                        "O riso de Helena chega abafado, a pipa é só um ponto colorido lá em cima. Sophie\nobserva, mas mantém a distância, como se aquilo ainda pudesse machucar.",

                        "A tarde segue sem ela. Ninguém sente falta de alguém que nunca esteve ali."
                };
                break;
            default:
                reacao = new String[] {
                        "Sophie corre pelo gramado, e o coração bate mais rápido do que os passos. A\nmenina passa por ela sem desviar.",

                        "Sophie: \"Mãe! Mãe, sou eu!\"",

                        "Helena continua olhando para o céu, rindo, com os dedos firmes na linha da pipa.\nSophie estica a mão e não sente nada. Nem o calor, nem o tecido da blusa, nem o\npeso de um abraço.",

                        "A mãe não a vê. As cores tremem e a voz de Sophie não chega.",

                        "Ela não pode mudar o que já aconteceu."
                };
                break;
        }

        exibirParagrafos(scanner, reacao);

        System.out.println();
        System.out.println(
                "Sophie confusa pelo o que aconteceu, coloca a mão em seu bolso e encontra algo\nque não estava lá: uma coleira azul do Mr. Cuddles filhote, ainda com o guizo.");
        System.out.println();
        inventario.adicionarItem(new Item("Coleira", "sorte", 15));
        
        //Pra testar o item
        //inventario.adicionarItem(new Item("Apanhador dos sonhos", "fraqueza_inimigos", 2));

        System.out.println(
                "Item obtido: Coleira. Item que trás boas lembranças em momentos oportunos. \n(A lembrança é a arma mais forte)");

        paragrafos = new String[] {
                "A pipa sobe. Sophie ri sem perceber. Então o vento para. As cores desbotam como\numa foto",

                "Esquecida no sol. A voz de Helena vira eco.",

                "Da grama sobe uma névoa que toma forma de mulher: cabelo preso de qualquer\njeito, braços abertos, rosto sem traços. É a SAUDADE.",

                "Sophie fica um pouco assustada pela mulher ter um rosto sem traços, e por ficar\nsempre com braços abertos como se fosse um espantalho",

                "A mulher vem em direção a Sophie de forma muito rápida flutuando por ter um\ncorpo que aparenta ser uma nevoa",

                "A mulher agarra a Sophie sem deixar ela fugir, Sophie assustada mas ao mesmo\ntempo com uma sensação boa, começa a relembrar todas as suas boas memórias que\nviveu com a sua Mãe e Mr. Cuddles",

                "Sophie se sente confortável e gosta daquelas memórias, porem algo não parece\nestá certo, seu corpo parece estar ficando cade vez mais fraco como se a mulher\nestivesse sugando sua energia Vital",

                "E cada vez mais Sophie se sente mais fraca e com menos força para navegar nas\nboas memórias que lhe é mostrada, como se o chão estivesse puxando seus pés como\numa areia movediça",

                "Então Sophie agoniada com toda essa situação tentando se livrar do abraço,\nlembrou-se de uma fala que sua Mãe disse para ela quando estava triste em seu\nquarto por não entender o porque a vida não pode ser vivida sempre por momentos\nfelizes",

                "Lembrança: Sua mãe entra no quarto, se senta na beira da cama e afasta o cabelo\nmolhado do rosto de Sophie. Ela não diz nada por um instante, só espera a filha\nparar de chorar.",

                "Helena: \"Filha, a vida não é feita só de dias de sol. Os dias felizes nos\naquecem, mas são os difíceis que nos ensinam a ficar de pé. Cada dor que você\natravessa vira uma força que ninguém mais consegue tirar de você. Então não\ntenha medo de sentir saudade, só não deixe que ela te prenda. É com o que você\naprendeu nos dias ruins que você vence os dias difíceis.\"",

                "A voz da mãe ecoa dentro de Sophie, mais firme do que qualquer abraço. Ela\nentende que aquelas memórias são preciosas, mas que ficar presa nelas não é\nhonrar a mãe. É se esconder.",

                "Sophie fecha os olhos, respira fundo e sente algo acender no peito: não é só\ntristeza, é força. Ela apoia as mãos nos braços sem traços da SAUDADE e empurra.",

                "Então a nevoa em forma de mulher começa a chorar de maneira estranha e parte em\ndireção a Sophie, ela coloca a mão em seu bolso e tira a Coleira de seu cachorro\npara enfrentar a mulher."
        };

        exibirParagrafos(scanner, paragrafos);

        ArteAscii.desenharPipa();
        lutarAteVencer(scanner, personagem, inventario, menuCombate, "A Saudade", 105, 11);
        System.out.println();

        String[] final1 = {
                "A névoa se desfaz devagar, sem gritos, como o vapor de uma xícara esfriando.\nOnde a SAUDADE estava, sobra só a grama molhada e um silêncio manso.",

                "Sophie respira fundo. O peito ainda dói, mas é uma dor diferente: não pesa mais\ncomo uma âncora, aquece como uma lembrança guardada no bolso.",

                "Sophie: \"Eu ainda vou sentir sua falta. Mas agora eu sei carregar isso comigo,\nsem me perder nisso.\"",

                "Ela aperta a coleira com carinho e sorri, de leve. Saudade não é inimiga de quem\nama: é só o amor que continua depois que o momento passou.",

                "Lá no fim do quintal, a luz muda de cor. Uma porta se abre na memória, e Sophie\ncaminha até ela, de cabeça erguida.",

                "Depois de entrar na porta Sophie se depara com uma escada de pedra coberta de\nmusgo que parece descer mais fundos em suas memórias",

                "Porem logo no começo da escada aparece um bau na cor verde brilhando, como se\nfosse uma recompensa a chamando para abrir",

        };
        exibirParagrafos(scanner, final1);
        System.out.println();

        System.out.println("Deseja abrir o baú? (1- Sim) (2- Não)");
        opcao = scanner.nextInt();

        if (opcao < 0 || opcao > 2) {
            System.out.println("Digite uma opção válida!");
        } else if (opcao == 1) {
            bau.abrir(inventario, personagem);
            System.out.println();

            pausar(scanner);

            System.out.println(
                    "No fundo do baú coberto por um pano amarelo, Sophie encontra uma Espada de Cobre\nque será muito útil para o próximo andar!");

            inventario.adicionarItem(new Item("Espada de Cobre", "dano", 20));
        } else {
            System.out.println("Você não abre o baú e perde algo importante para a jornada");
        }
    }

    // =========================================
    // ANDAR 2
    // =========================================

    public static void executarAndar2(Scanner scanner, Inventario inventario, Personagem personagem,
                                      MenuCombate menuCombate, Bau bau) {

        System.out.println("\n\n§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ A GARAGEM §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n");

        String[] paragrafos = {
                "A escada termina em uma porta que Sophie reconhece: a da cozinha da casa dela,\nsó que com a luz amarela demais e o relógio parado. É uma noite de poucas\nsemanas atrás.",

                "Uma Sophie de olhos vermelhos está parada diante de Marcos, que separa papéis\nsobre a mesa.",

                "Sophie (memória): \"A mãe piorou e você nem fala disso! Você nem liga!\"",

                "Marcos: \"Agora não, Sophie.\"",

                "Ele pega a chave do carro e sai pela porta dos fundos. A porta bate. A Sophie da\nmemória fica sozinha com a cozinha vazia.",

                "Só que, desta vez, a Sophie de agora pode ir atrás.",

                "Pela fresta da porta, a garagem está escura. Marcos está sentado no carro\nparado, com as mãos no volante. Mr. Cuddles se deitou nos pés dele, sem ninguém\npedir."
        };

        exibirParagrafos(scanner, paragrafos);

        // Arte da garagem
        ArteAscii.desenharGaragem();
        System.out.println();

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                                                                                         |");
        System.out.println("                                                                                         !");
        System.out.println("O que deseja fazer?                                                                      |");
        System.out.println("                                                                                         !");
        System.out.println("1. Ficar olhando pela fresta até ele sair.                                               |");
        System.out.println("2. Virar as costas e voltar para a cozinha. \"Não quero ver isso.\"                        !");
        System.out.println("                                                                                         |");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        int opcao = 0;
        while (opcao < 1 || opcao > 2) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equals("1") || entrada.equals("2")) {
                opcao = Integer.parseInt(entrada);
            } else {
                System.out.println("Escolha 1 ou 2.");
            }
        }

        String[] reacao;

        switch (opcao) {
            case 1:
                reacao = new String[] {
                        "Sophie fica quieta, com os olhos colados na fresta da porta.",

                        "Ele não liga o motor. Os ombros tremem uma vez. Ele passa a mão no rosto,\nrespira fundo e desce do carro com a cara de sempre, como se nada tivesse\nacontecido."
                };
                break;
            default:
                reacao = new String[] {
                        "Sophie vira as costas e volta para a cozinha. Não quer ver isso.",

                        "A garagem fica escura e a imagem do pai no carro se apaga. Fica só o barulho da\nporta batendo."
                };
                break;
        }

        exibirParagrafos(scanner, reacao);

        paragrafos = new String[] {
                "A cozinha esquenta. As paredes ganham um tom de brasa e o ar cheira a algo\nqueimado.",

                "Do chão sobe uma figura feita de estática vermelha, com a silhueta de Sophie, só\nque mais alta e com os punhos fechados. É a RAIVA."
        };

        exibirParagrafos(scanner, paragrafos);

        lutarAteVencer(scanner, personagem, inventario, menuCombate, "A Raiva", 80, 12);
        System.out.println();

        String[] final2 = {
                "A Raiva esfria em brasa e depois em cinza.",

                "Na fresta da porta, a luz da garagem volta por um instante. Sophie guarda o\nsilêncio do pai, agora com outro peso.",

                "A parede da cozinha se abre em uma passagem de pedra molhada, que desce mais\nfundo. Sophie respira fundo e segue por ela."
        };
        exibirParagrafos(scanner, final2);
    }

    // =========================================
    // ANDAR 3
    // =========================================

    public static void executarAndar3(Scanner scanner, Inventario inventario, Personagem personagem,
                                      MenuCombate menuCombate, Bau bau) {
        String[] paragrafos = {
                "\n\n§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ O CORREDOR §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n\n",


                "A passagem de pedra termina em um corredor de armários azuis, iluminado por\nlâmpadas que piscam.",

                " É o corredor da escola, mas vazio, com um zumbido abafado, como se o som viesse\nde dentro d'água. ",

                "No portão, Lia e Theo esperam. Sophie, um pouco mais nova, com a mochila\napertada contra o peito, hesita.",

                "Lia:\nSábado é meu aniversário! Vai lá em casa. Bolo, filme, essas coisas. Lá é sempre\ntão silencioso que vai ser bom ter gente.",

                "Theo:\n Vai. Eu levo um desenho de bolo.",

                "Sophie pensa na mãe deitada no sofá, e em ter que explicar por que não pode\nficar até tarde. Pensa nos olhares de pena que ainda nem existem.",

                "Sophie (memória):\n Não posso. Tenho que ir.",

                "Ela sai correndo. Lia fica com o sorriso congelado, sem entender. Theo olha para\no chão. O caderno dele ficou aberto no banco.",

                "\n"

        };

        exibirParagrafos(scanner, paragrafos);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println("                                                                                         |");
        System.out.println("                                                                                         !");
        System.out.println("Agora a Sophie de hoje está sozinha no corredor, no lugar onde tudo aconteceu.           |");
        System.out.println("                                                                                         !");
        System.out.println("O que deseja fazer?                                                                      |");
        System.out.println("                                                                                         !");
        System.out.println("1. Pegar o caderno do Theo e abrir.                                                      |");
        System.out.println("2. Olhar para o rosto da Lia até o fim.                                                  !");
        System.out.println("3. Desviar o olhar e fixar os armários.                                                  |");
        System.out.println("                                                                                         !");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        int opcao = 0;
        while (opcao < 1 || opcao > 3) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equals("1") || entrada.equals("2") || entrada.equals("3")) {
                opcao = Integer.parseInt(entrada);
            } else {
                System.out.println("Escolha 1, 2 ou 3.");
            }
        }

        String[] reacao;

        switch (opcao) {
            case 1:
                reacao = new String[] {
                        "=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=> CADERNO DE THEO <=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=",

                        "Resultado: a primeira página é o desenho cuidadoso de uma senhora de cabelos\nbrancos, com uma anotação pequena:",

                        "pra não esquecer o rosto dela.",

                        " Algumas páginas depois, um desenho de Sophie sentada sozinha no pátio, com o\nnome escrito embaixo. Ele estava reparando.",

                        "Sophie retorna seu foco ao caminho, segue pelo corredor."

                };
                break;
            case 2:
                reacao = new String[] {
                        "Sophie segue o corredor, apreensiva, buscando apoio no olhar de Lia.",

                        "Seguindo pelo corredor, A presença de Lia desaparece.",

                        "Sophie está sozinha agora. "

                };
                break;
            default:
                reacao = new String[] {
                        "Sophie corre pelo corredor.",

                        "Sem coragem de manter o olhar a diante."

                };
                break;
        }

        exibirParagrafos(scanner, reacao);

        paragrafos = new String[] {
                "As lâmpadas se apagam uma a uma.",

                "As sombras dos armários se esticam pelo chão e se juntam, formando uma figura\nalta, sem contornos, com dezenas de olhos abertos e fechados.",

                "No portão, Lia e Theo esperam. Sophie, um pouco mais nova, com a mochila\napertada contra o peito, hesita.",

                "Ouve-se cochicho por todo o corredor. É o MEDO."

        };
        exibirParagrafos(scanner, paragrafos);

        ArteAscii.desenharCorredorAssombrado();
        lutarAteVencer(scanner, personagem, inventario, menuCombate, "O Medo", 67, 10);

        paragrafos = new String[] {
                "\n\nApós derrotar O Medo, as sombras se dissipam.",

                "Os olhos assombrosos somem no ar.",

                "A medida que o medo se dissolve, As lâmpadas voltam a funcionar.",

                "O corredor agora está iluminado.",

                "Em rumo ao fim do corredor, Você avista um báu azulado, Porém, ao tentar\nabrí-lo, nota estar trancado.",

                "Olhando ao redor,Um dos armário chama sua atenção, Um deles está aberto.",

                "Você se aproxima, E encontra dentro, uma caixinha de madeira, está trancada por\num cadeado de padrão em letras.",

                "colado á caixa, você encontra um caça-palvras.\n"

        };
        exibirParagrafos(scanner, paragrafos);


        ArteAscii.cacaPalavras();
        String palavra = "";
        System.out.println("          <Encontre a palavra escondida.>\n\n");

        while(!palavra.equalsIgnoreCase("coragem")){
            palavra = scanner.nextLine();
            if(palavra.equalsIgnoreCase("coragem")){
                System.out.println("\n\nVocê encontra a palavra, e digita a senha.\n\nDentro, Encontra uma chave enferrujada.\n\nRetornando ao báu você bota a chave e abre. \n\n");
                //item aleatório do báu
                bau.abrir(inventario, personagem);
                System.out.println();
                //item obrigatório de pegar
                inventario.adicionarItem(new Item("Capa de Chuva", "defesa", 30));
                System.out.println("No fundo do báu, Enrolado, Sophie encontra uma capa de chuva resistênte.");
                System.out.println();
            }
            else{
                System.out.println("Palavra errada, Continue tentando. ");
                System.out.println();
            }
        }

        paragrafos = new String[]{
                "No fim do corredor, uma porta branca com um cheiro conhecido, de álcool e de\nsala de espera.",

                "Sophie sabe o que há do outro lado.",

                "Ela hesita, Mas respira fundo.",

                "Pensa em tudo que já enfrentou até então.",

                "Cria coragem e segue adiante."
        };
        exibirParagrafos(scanner, paragrafos);

        pausar(scanner);

    }
    public static int lerOpcao(Scanner scanner, int max) {
        int opcao = 0;
        while (opcao < 1 || opcao > max) {
            String entrada = scanner.nextLine().trim();
            if (entrada.equals("1") || entrada.equals("2") || (max == 3 && entrada.equals("3"))) {
                opcao = Integer.parseInt(entrada);
            } else {
                System.out.println("Escolha um número de 1 a " + max + ".");
            }
        }
        return opcao;
    }

    // =========================================
    // ANDAR 4
    // =========================================

    public static void executarAndar4(Scanner scanner, Inventario inventario, Personagem personagem,
                                      MenuCombate menuCombate, Bau bau) {

        System.out.println("\n\n§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ O QUARTO §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n");

        ArteAscii.desenharPortaBranca();

        //Separei com o nome de cada parte porque esse andar é separado por partes no roteiro e usa um estilo de combate meio diferente ali mas no fim usa o combate normal de menu

        // ---------- A4-1: O quarto ----------
        String[] paragrafos = {
                "A porta branca se abre sem ranger. O quarto é pequeno, com uma janela por onde\nentra uma luz de fim de tarde.",

                "Helena está na cama, muito mais frágil do que Sophie lembrava, e ainda assim\nsorri quando a vê.",

                "Pela janelinha da porta, a silhueta de Marcos, parado no corredor, sem entrar.",

                "Helena: \"Vem cá, filha. Senta aí.\"",

                "Sophie senta e segura a mão dela. Está fria.",

                "Helena: \"Eu não quero que você passe o resto da vida com medo de me perder.\nQuero que continue estudando. Faça amigos. Ame. Erre. Sonhe. Viva. E cuida do\nMr. Cuddles por mim, tá?\""
        };
        exibirParagrafos(scanner, paragrafos);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println("O que deseja fazer?");
        System.out.println();
        System.out.println("1. \"Eu tô com medo, mãe.\"");
        System.out.println("2. \"Você vai melhorar. Para de falar isso.\"");
        System.out.println("3. Ficar em silêncio, segurando a mão.");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        int opcao = lerOpcao(scanner, 3);

        String[] reacao;
        switch (opcao) {
            case 1:
                reacao = new String[] {
                        "Helena aperta a mão dela.",

                        "Helena: \"Eu também, filha. E tá tudo bem.\""
                };
                break;
            case 2:
                reacao = new String[] {
                        "Helena sorri, cansada, e não discute. Só continua segurando a mão dela."
                };
                break;
            default:
                reacao = new String[] {
                        "Sophie não diz nada. Helena também não. As duas ficam ali, com as mãos juntas, e\no silêncio é suficiente."
                };
                break;
        }
        exibirParagrafos(scanner, reacao);

        // ---------- A4-2: A despedida ----------
        paragrafos = new String[] {
                "O tempo no quarto fica mais lento. A luz da janela muda de cor.",

                "Helena fecha os olhos, ainda com um sorriso pequeno no rosto.",

                "Sophie não vê o momento. Só sente que a mão que segurava a dela deixou de\napertar.",

                "O quarto fica em silêncio.",

                "Do lado de fora, a silhueta de Marcos encosta a testa na porta."
        };
        exibirParagrafos(scanner, paragrafos);

        // ---------- A4-3: A Tristeza e a Culpa ----------
        paragrafos = new String[] {
                "A luz da janela esfria e escurece. As paredes brancas ficam cinzentas, e o\ncheiro de álcool se mistura ao de chuva.",

                "Duas formas se levantam do chão do quarto: uma, feita de água escura, sem rosto,\nque pinga sem parar. A outra, uma sombra com o dedo apontado. São a TRISTEZA e a\nCULPA.",

                "Na mesa de cabeceira, um envelope com o nome de Sophie escrito à mão."
        };
        exibirParagrafos(scanner, paragrafos);

        int aceites = 0;

        paragrafos = new String[] {
                "Tristeza: \"Ela se foi. Tudo que sobrou foi silêncio.\"",

                "Culpa: \"Você devia ter ficado mais tempo com ela.\""
        };
        exibirParagrafos(scanner, paragrafos);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println("O que deseja fazer?");
        System.out.println();
        System.out.println("1. \"Não vou chorar. Eu tenho que ser forte.\"");
        System.out.println("2. \"Eu tô triste. Muito. E posso sentir isso.\"");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        opcao = lerOpcao(scanner, 2);

        if (opcao == 2) {
            aceites++;
            reacao = new String[] {
                    "Os ombros de Sophie cedem. A água escura da Tristeza continua pingando, mas já\nnão parece tão alta."
            };
        } else {
            reacao = new String[] {
                    "Sophie engole o choro. A Tristeza pinga mais rápido, e o peito dela aperta como\nse alguém tivesse fechado a mão ali dentro."
            };
        }
        exibirParagrafos(scanner, reacao);

        paragrafos = new String[] {
                "Culpa: \"Você gritou com seu pai enquanto ela piorava.\"",

                "Tristeza: \"Você desperdiçou os dias que tinha.\""
        };
        exibirParagrafos(scanner, paragrafos);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println("O que deseja fazer?");
        System.out.println();
        System.out.println("1. \"É tudo culpa minha.\"");
        System.out.println("2. \"Eu errei. Mas eu também estava com medo. Isso não me faz culpada.\"");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        opcao = lerOpcao(scanner, 2);

        if (opcao == 2) {
            aceites++;
            reacao = new String[] {
                    "O dedo da Culpa treme, e por um instante abaixa."
            };
        } else {
            reacao = new String[] {
                    "O dedo da Culpa cresce, apontando para ela de todos os lados do quarto."
            };
        }
        exibirParagrafos(scanner, reacao);

        paragrafos = new String[] {
                "Tristeza: \"Ninguém entende o que você sente.\"",

                "Culpa: \"Se você tivesse falado com ela antes, talvez...\""
        };
        exibirParagrafos(scanner, paragrafos);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println("O que deseja fazer?");
        System.out.println();
        System.out.println("1. \"Ninguém entende. Melhor ficar sozinha.\"");
        System.out.println("2. \"Ainda que ninguém entenda tudo, eu posso pedir ajuda.\"");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        opcao = lerOpcao(scanner, 2);

        if (opcao == 2) {
            aceites++;
            reacao = new String[] {
                    "Sophie pensa em Lia, em Theo, no pai parado do outro lado da porta. O quarto\nparece um pouco menos fundo."
            };
        } else {
            reacao = new String[] {
                    "Sophie se encolhe. As paredes cinzentas parecem se aproximar, e o quarto fica\nmenor."
            };
        }
        exibirParagrafos(scanner, reacao);

        paragrafos = new String[] {
                "As duas formas se fundem em uma só sombra azul-acinzentada que ocupa o quarto\ninteiro.",

                "Tristeza e Culpa (juntas): \"Se você aceitar que ela partiu, é como se você a\ndeixasse ir de vez.\""
        };
        exibirParagrafos(scanner, paragrafos);

        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println();
        System.out.println("O que deseja fazer?");
        System.out.println();
        System.out.println("1. \"Então eu não aceito.\"");
        System.out.println("2. \"Deixar ir não é esquecer. Eu levo ela comigo.\"");
        System.out.println();
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

        opcao = lerOpcao(scanner, 2);

        if (opcao == 2) {
            aceites++;
            reacao = new String[] {
                    "A sombra estremece. Sophie sente o quarto inteiro prender a respiração."
            };
        } else {
            reacao = new String[] {
                    "A sombra ri sem som e avança."
            };
        }
        exibirParagrafos(scanner, reacao);

        lutarAteVencer(scanner, personagem, inventario, menuCombate, "A Tristeza e a Culpa", 100, 12);
        System.out.println();

        if (aceites >= 3) {
            paragrafos = new String[] {
                    "A sombra se desfaz em chuva fina. A janela volta a ter luz.",

                    "Sophie pega o envelope e, pela primeira vez, consegue abrir.",

                    "=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=> A CARTA <=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-+-=",

                    "\"Minha querida, você é mais forte e corajosa do que jamais poderia imaginar.\n\n"
                            + "Se você está lendo isto, é porque já não posso estar aí. Quero que saiba que\nnada do que você fez, ou deixou de fazer, causou isso. Você não precisa carregar\nculpa por mim.\n\n"
                            + "Você me deu os dias mais felizes que eu tive. Não fique presa ao medo de perder.\nEstude, faça amigos, ame, erre, sonhe.\n\n"
                            + "Cuide do seu pai: ele ama você do jeito difícil dele. E dê um abraço no Mr.\nCuddles por mim.\n\n"
                            + "Mesmo que não possa mais segurar sua mão, meu amor sempre estará ao seu lado.\n\n"
                            + "Mamãe\"",

                    "Sophie dobra a carta com cuidado e guarda junto ao peito. Fragmento obtido: o\namor da mãe."
            };
        } else {
            paragrafos = new String[] {
                    "A sombra recua, mas não vai embora.",

                    "Sophie abre o envelope e aperta a carta contra o peito. As letras tremem e se\nembaralham. Ela só consegue ler a primeira linha:",

                    "\"Minha querida, você é mais forte e corajosa do que jamais poderia imaginar.\"",

                    "A carta continua com ela até o final."
            };
        }
        exibirParagrafos(scanner, paragrafos);

        paragrafos = new String[] {
                "A porta branca se dissolve.",

                "À frente, a escada sobe por uma mata escura. No fim dela, uma água parada\nreflete um céu que não é o de hoje.",

                "A fonte."
        };
        exibirParagrafos(scanner, paragrafos);
    }
//=======================================================
//ANDAR 5
//=======================================================
public static void executarAndar5(Scanner scanner, Inventario inventario, Personagem personagem,
                                  MenuCombate menuCombate, Bau bau) {

    System.out.println("\n\n§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§ A FONTE §§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§§\n");

    ArteAscii.desenharFonte();

    // ---------- F1: A clareira ----------
    String[] paragrafos = {
            "A mata termina em uma clareira redonda. No centro, a fonte: uma bacia de pedra\ncoberta de musgo, com a água parada refletindo um céu que não é o de hoje.",

            "Sophie segura a carta com as duas mãos.",

            "Voz da água: \"Diga o que você veio buscar.\""
    };
    exibirParagrafos(scanner, paragrafos);

    exibirParagrafos(scanner, new String[] {
            "Três luzes pequenas flutuam sobre a água: a risada da mãe, o silêncio do pai, o\nlugar guardado na mesa. Sophie sente que o amor de Helena também está ali, na\ncarta que ela segura.",

            "Na borda da clareira, Lia e Theo esperam a alguns passos, sem dizer nada."
    });

    // ---------- F2: A escolha ----------
    paragrafos = new String[] {
            "A água mostra Helena de novo: saudável, rindo, com a pipa na mão, sem tosse, sem\ncansaço. Ela olha para Sophie como quem convida.",

            "Voz da água: \"Você pode se aproximar. Eu mostro o que você quiser rever.\""
    };
    exibirParagrafos(scanner, paragrafos);

    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    System.out.println();
    System.out.println("O que deseja fazer?");
    System.out.println();
    System.out.println("1. Voltar para os dias em que ela estava bem.");
    System.out.println("2. Aceitar as memórias e seguir com elas.");
    System.out.println();
    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

    int opcao = lerOpcao(scanner, 2);

    if (opcao == 2) {
        // ================= FINAL BOM =================
        paragrafos = new String[] {
                "Sophie abre a carta e lê em voz alta, devagar. A cada frase, a água acende um\npouco mais. As três luzes sobem da superfície e entram nela, uma a uma.",

                "Sophie: \"Eu não vou esquecer você, mãe. Mas eu não vou ficar aqui.\"",

                "A imagem de Helena sorri e se desfaz em ondas. A água fica clara, e no reflexo\nhá só Sophie, de olhos vermelhos e com o rosto de quem acabou de respirar fundo."
        };
        exibirParagrafos(scanner, paragrafos);

        exibirParagrafos(scanner, new String[] {
                "Lia e Theo esperam na saída da mata. Lia não fala nada, o que, para ela, é um\nrecorde. Só abraça Sophie."
        });

        paragrafos = new String[] {
                "§§§ SEMANAS DEPOIS: A COZINHA §§§",

                "Sophie e Marcos estão na mesa. Mr. Cuddles dorme aos pés dos dois.",

                "Sophie: \"Pai, eu tô com saudade dela.\"",

                "Marcos demora a responder. Depois, pela primeira vez, olha nos olhos dela.",

                "Marcos: \"Eu também. Eu não sabia como te falar isso.\"",

                "Ele a abraça. Mr. Cuddles se enfia entre os dois.",

                "§§§ A ESCOLA §§§",

                "O portão da escola parece menor do que no primeiro dia. Lia acena com a mão\ninteira. Theo levanta o caderno: um desenho novo de Sophie, Lia e ele na mesa\nneutra e, ao fundo, uma pipa no céu.",

                "Sophie sente a saudade da mãe. Mas, desta vez, sorri ao lembrar dela. Ela\nentende que seguir em frente não significa esquecer alguém. Significa continuar\nvivendo levando consigo aquilo que essa pessoa deixou."
        };
        exibirParagrafos(scanner, paragrafos);

        System.out.println();
        System.out.println("=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-> MEMÓRIAS QUE PERMANECEM <=-+-=-+-=-+-=-+-=-+-=-+-=-+-=");
        System.out.println();
        System.out.println("Algumas pessoas permanecem conosco através das memórias, das escolhas e daquilo\nque aprendemos com elas.");
        System.out.println();

    } else {
        // ================= FINAL RUIM =================
        paragrafos = new String[] {
                "Sophie dá um passo para dentro da água. A pipa sobe, Helena ri, Marcos sai da\ngaragem, Lia sorri.",

                "Mas tudo se mistura: a pipa aparece na cozinha, a risada de Helena vem do\ncorredor da escola, o quarto branco se abre no meio do quintal.",

                "Sophie corre atrás de uma cena e encontra outra. Já não sabe distinguir o que\naconteceu do que gostaria que tivesse acontecido.",

                "Sophie: \"Só mais um pouquinho.\"",

                "A água não muda nada. Não há latido, não há passos. Só a água.",

                "Sophie senta sozinha na borda da fonte, com a carta nas mãos. Ao fundo,\nbaixinha, a voz de Helena:",

                "Helena: \"Você precisa continuar vivendo, filha.\"",

                "Sophie fecha os olhos. A tela escurece antes de mostrar se ela vai conseguir."
        };
        exibirParagrafos(scanner, paragrafos);

        System.out.println();
        System.out.println("=-+-=-+-=-+-=-+-=-+-=-+-=-+-=-> PRESA NAS MEMÓRIAS <=-+-=-+-=-+-=-+-=-+-=-+-=-+-=");
        System.out.println();
        System.out.println("Quando a dor é reprimida e a pessoa se prende ao passado, as memórias podem\ndeixar de ser um lugar de carinho e se transformar em uma prisão.");
        System.out.println();
    }
}
}



// FIM DO JOGO