package TextualGame;

/**
 * Cenas coloridas para jogo textual, feitas somente com caracteres do teclado (ASCII).
 *
 * Use assim, de qualquer lugar do jogo:
 *
 *   ArteAscii.desenharCasa();
 *   ArteAscii.desenharPipa();
 *   ArteAscii.desenharGaragem();
 *   ArteAscii.desenharCorredorAssombrado();
 *   ArteAscii.desenharPortaBranca();
 *   ArteAscii.desenharFonte();
 *
 * As cores usam codigos ANSI de 16 cores. Se o seu terminal nao mostrar as cores
 * (ex.: console de algumas IDEs), mude COLORIDO para false e as cenas saem em preto e branco.
 *
 * Nas linhas das cenas, os marcadores {x} mudam a cor do texto que vem depois:
 *   r=vermelho g=verde y=amarelo b=azul m=magenta c=ciano w=cinza-claro k=cinza
 *   (maiuscula = versao brilhante: R G Y B M C W)
 */

public class ArteAscii {

    /** Coloque false para desenhar sem cores. */
    public static final boolean COLORIDO = true;

    // =====================================================================
    //  CENAS
    // =====================================================================

    /** Casa com chamine, arvore, sol e caminho. */
    public static void desenharCasa() {
        imprimir(new String[]{
            "                                {k}o",
            "  {Y}\\ | /                        {k}O",
            " {Y}-- O --                     {r}___",
            "  {Y}/ | \\          {r}/\\         {r}|   |",
            "                {r}/  \\_______________\\",
            "               {r}/    \\               \\",
            "              {r}/      \\               \\",
            "             {r}/________\\_______________\\",
            "   {g}.:::.     {W}|        |{k}               |",
            "  {g}:::::::    {W}|{Y}   __   {W}|{k}  {c}___{k}    {c}___{k}   |",
            "   {g}':::'     {W}|{Y}  |  |  {W}|{k} {c}|   |{k}  {c}|   |{k}  |",
            "     {y}||      {W}|{Y}  | o|  {W}|{k} {c}|___|{k}  {c}|___|{k}  |",
            "     {y}||      {W}|__{Y}|__|{W}__|{k}_______________|",
            "{g},.,',.,',.,',.,',.,',.,',.,',.,',.,',.,'",
            "               {y}/    \\",
            "              {y}/      \\",
            "             {y}/        \\"
        });
    }
  
    public static void desenharGirassol3D() {
        imprimir(new String[]{
            "                     {Y}##     %%",
            "              {Y}%%     ##{r}%%%%%{Y}%%     ##",
            "              {y}▒{Y}%%%%{r}%%%#{R}**{r}###@%%%{Y}####{y}▒",
            "        {Y}###   {y}▒▒▒{Y}%{r}%#{R}*{r}#{R}*{r}#{R}*{r}##@#@#@%{Y}#{y}▒▒▒   %%%",
            "        {y}▒▒▒{Y}######{r}%%#{R}*{r}#{R}*{r}#{R}*{r}@@#@#@#%%{y}%%%%%%▒▒▒",
            "        {y}▒▒▒▒▒▒▒▒{Y}#{r}▓%@#@#@##@#@#@#%▓{y}%▒▒▒▒▒▒▒▒",
            "      {Y}%%%%%%%%%%%{r}▓▓%%%@###@@#%%%▓▓{y}###########",
            "      {y}▒▒▒▒▒▒▒▒▒▒{Y}##{r}▓▓▓▓▓%%%%%▓▓▓▓▓{y}%%▒▒▒▒▒▒▒▒▒▒",
            "      {y}▒▒▒▒▒{Y}########{r}▓▓▓▓▓▓▓▓▓▓▓▓▓{y}%%%%%%%%▒▒▒▒▒",
            "        {Y}###{y}▒▒▒▒▒▒%%%%▒#{r}▓▓▓▓▓{y}%▒####▒▒▒▒▒▒%%%",
            "        {y}▒▒▒▒▒▒▒%%%%▒▒####▒%%%%▒▒####▒▒▒▒▒▒▒",
            "        {y}▒▒▒   %%▒▒▒▒▒###▒▒▒%%%▒▒▒▒▒##   ▒▒▒                  {W}░",
            "              {y}▒▒▒▒▒  ##▒▒{g}█{y}▒▒%%  ▒▒▒▒▒              {W}░░░░░░░░░░▓░░░░░",
            "              {y}▒▒     ▒▒▒{G}▓{g}█▒{y}▒▒▒     ▒▒             {W}░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░                    ░░░░░",
            "                     {y}▒▒ {G}▓{g}█▒ {y}▒▒                   {w}▒{W}▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░{w}▒           {W}░░░░░░░▓▓▓▓▓░░░",
            "                        {G}▓{g}█▒                       {w}▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒          {W}░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░",
            "                        {G}▓{g}█▒                                                   {w}▒{W}▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒░",
            "                        {G}▓{g}█▒{G}▓▓▓▓                                      {W}░░░░░     {w}▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒",
            "                        {G}▓{g}█▒░{G}▓▓▓▓▓▓▓                             {W}░░░░░▓▓▓▓▓░░░░░",
            "                        {G}▓{g}█▒▒▒░░░{G}▓▓▓▓▓                    {W}░░░░░░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░░░░░░",
            "                        {G}▓{g}█▒ ▒▒▒▒░░░{G}▓▓▓▓                {W}░░▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓░░",
            "                    {G}▓▓▓▓▓{g}█▒   ▒▒▒▒▒░░░{G}▓▓▓             {W}░▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓░",
            "                {G}▓▓▓▓▓▓▓{g}░{G}▓{g}█▒     ▒▒▒▒▒▒▒░░             {w}▒▒{W}▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒{w}▒▒",
            "              {G}▓▓▓▓▓{g}░░░▒▒{G}▓{g}█▒         ▒▒▒▒▒               {w}▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒",
            "            {G}▓▓▓▓{g}░░░▒▒▒▒ {G}▓{g}█▒",
            "          {G}▓▓▓{g}░░░▒▒▒▒▒   {G}▓{g}█▒                          {G}────────── {Y}DEEP {G}──────────",
            "          {g}░░▒▒▒▒▒▒▒     {G}▓{g}█▒                                   {G}────────── {Y}MEMORIES {G}──────────",
            "          {g}▒▒▒▒▒         {G}▓{g}█▒",
            "                        {G}▓{g}█▒",
            "                        {G}▓{g}█▒",
            "                        {G}▓{g}█▒",
            "{C}▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓",
            "{c}▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓"
        });
    }
    /** Casa com chamine, arvore, sol e caminho. */
    public static void desenharMapa() {

        System.out.println();
        System.out.println("              MAPA DO JOGO");
        System.out.println();
        System.out.println("     ┌──────────┐");
        System.out.println("    ╱░░░░░░░░░░╱│");
        System.out.println("   ┌──────────┐▒│");
        System.out.println("   │   CASA   │▒│");
        System.out.println("   │          │╱");
        System.out.println("   └──────────┘");
        System.out.println("         │");
        System.out.println("         │");
        System.out.println("         ● ESCOLA");
        System.out.println("         │");
        System.out.println("         └──────────┐");
        System.out.println("                    │");
        System.out.println("                    ▼");
        System.out.println("              ┌──────────┐            ┌─────────────┐");
        System.out.println("             ╱░░░░░░░░░░╱│           ╱░░░░░░░░░░░░░╱│");
        System.out.println("            ┌──────────┐▒│          ┌─────────────┐▒│");
        System.out.println("            │  A PIPA  │╱───────────│  A GARAGEM  │╱");
        System.out.println("            └──────────┘            └─────────────┘");
        System.out.println("                                           │");
        System.out.println("                                           │");
        System.out.println("                                           │");
        System.out.println("                                           ▼");
        System.out.println("     ┌──────────────────┐             ┌──────────────┐");
        System.out.println("    ╱░░░░░░░░░░░░░░░░░░╱│            ╱░░░░░░░░░░░░░░╱│");
        System.out.println("   ┌──────────────────┐▒│           ┌──────────────┐▒│");
        System.out.println("   │  A PORTA BRANCA  │╱ ◄──────────│  O CORREDOR  │╱");
        System.out.println("   └──────────────────┘             └──────────────┘");
        System.out.println("            ▲");
        System.out.println("            │");
        System.out.println("            │");
        System.out.println("        ┌────────────┐");
        System.out.println("       ╱░░░░░░░░░░░░╱│");
        System.out.println("      ┌────────────┐▒│");
        System.out.println("      │  A FONTE   │╱");
        System.out.println("      └────────────┘");

    }
      public static void cacaPalavras() {

        System.out.println("        ┌────────────────────────────────────┐");
        System.out.println("        │            CAÇA-PALAVRAS           │");
        System.out.println("        │                                    │");
        System.out.println("        │  E U Q G Z Q E F V F M I N R N C   │");
        System.out.println("        │  M J F L F I O P Y N J O F K Q P   │");
        System.out.println("        │  I D N F D V B Y L X Z F U U D Q   │");
        System.out.println("        │  K I S C J K F I I C A N Y I N A   │");
        System.out.println("        │  B D H A J D D V R S L K Y O T U   │");
        System.out.println("        │  U W T B M K T G T O N V D V L Q   │");
        System.out.println("        │  V I M J L B X W N A J W K J X Y   │");
        System.out.println("        │  Z D J Y N K S A R K G R B X D F   │");
        System.out.println("        │  T D D B E Q L T C U J A N S E L   │");
        System.out.println("        │  N M M H Y N V H O E F R A V W R   │");
        System.out.println("        │  V R M I Z E H A R I R P N I K E   │");
        System.out.println("        │  U S C F R B U Q A K U Q Y X K B   │");
        System.out.println("        │  V A U H P B H V G E X M W L Z H   │");
        System.out.println("        │  R I K G L L O U E R Z P Z V S J   │");
        System.out.println("        │  G F U N E P A L M W N Z B U F C   │");
        System.out.println("        │                                    │");
        System.out.println("        └────────────────────────────────────┘");

    }

    /** Pipa colorida voando, com rabiola e uma pessoa segurando a linha. */
        /** Pipa colorida voando no céu, com rabiola e linha. */
    public static void desenharPipa() {
        imprimir(new String[]{
            "{b}''''`{W}*{b}.{c}'{W}*{b}..{c}.{W}*{b}''{c}.{b}.''.{W}.{c}.,.{b}',{c}'.,{b}.{c}'''{b}.{c},'.{W}*{c}'{b}.{W}*",
            "{c},'{B}`{W}*{b}.{c}.{W}*{b},{c},''.{B}``{c},.{b}`''{W}/|\\*{b},'{c}'.{b}`{c}.''{W}**{b}'''{c}.{b}.{B}`{c}'{B}`",
            "{b}.{c},.{b}'{c},{b}..{B}`{b}'{c},{b}`{c}.{b}.'{c}.{b}.{c},{b},{W}/{r}#{W}|{y}%{W}\\{c}'{b}'{B}`{b}.{c}..{B}`{b}''{c}'{b}.{c}.{b},,`.{c}.'",
            "{b}.,`{c}'{b},{c}..{b}'{W}*{b},..,{W}*{b}'{c},'{W}/{r}##{W}|{y}%%{W}\\{b},{B}``{b},.`.{c}'{b}.{c}..{b},`{c}'{W}*{c}'{b}.",
            "{b}.{c}..{b}.{c}.{b}`,{c}.{b}.{c}.'{b},{B}`{b}'`,{W}/{r}###{W}|{y}%%%{W}\\{c}'{b}'{c}'{B}`{b}'',{c}'{b}.{c}'{b}.'`{c}'{W}*{c},",
            "{c},,.{b},'.'{c}.{b}'{W}*{B}`{W}*{B}``{b}.{W}<----+---->{b}.`'{c}'{b}.''`{W}*{b},.`{c}..{B}`",
            "{b}.'{c}.{b}`{W}*{c}.{b}.{c}'{B}`{c}.{W}*{c}'.'{B}`{c}'{W}\\{b}+++{W}|{g}==={W}/{b}'{W}*{c}'{b}''''{c}'{b}''{c}.,{b}'{W}*{c},{b},",
            "{b}`,'{c}'{B}`{b},...,.{c},{b}',,{c}'.{W}\\{b}++{W}|{g}=={W}/{c}'{b},'{c}'{b}.{W}**{b}'{c}.'.{b},'`'{c},{B}`",
            "{b}''{c}'{b}`{c}.{B}`{c}'{b}'{W}*{c}.{b}.{c}.'{W}*{c},{b}'{c},{b}'{W}\\{b}+{W}|{g}={W}/{b}'{c}'{b},'{c},{b}.{c}'.',{B}`{b}`,{B}`{b}.{c}.{b}.{c}'",
            "{c}''{b}.{c}'{b}'{c}'.{B}`{b}.''{c}'{b}'{B}`{b}'{c}','{b}'{W}\\|/{b}'{c}'.{b},{c}',{B}`{W}*{c}'{b}`,'{B}`{b}'{W}*{b}'{c}.{B}`{c}.",
            "{b}.{c}'{b}.',{W}*{c}''{b}...{B}`{W}*{c}'{b}'{c}.{b}'{c}.''{W}'{b},'''{c}''{b}..``'.{c}'{B}`{b},{B}`{c}'{W}*{c}.,",
            "{b}.{W}*{c}'{b}..{c}',''',{W}*{c}.{W}***{B}`{b}'{B}`{W}.{c}'{W}~{b}`{c}'{B}`{W}*{b},{W}*{c}',{B}`{c},{b},`{W}*{B}`{b},{c}.{B}`{b}'{c}.",
            "{b},.{c}.'{b}`'{c}'.{b}'.,{c},''{b}'''{W}.{c}'{b}'{R}<{Y}>{b}...{c}'{b}`{c},{W}*{b}'{W}*{b}.{B}`{b}.{c}.{b},{c}''{b}'{c}'{W}*",
            "{b},{c},.'{b}'{c},{W}*{c}'{b}..{c}..{B}`{b}.{c}'{W}.{b}.{B}`{c}.{W}~{b},{B}``{b}'{c}.{b}.'{c}.'{b},{c}'{b}'`''{B}`{c}'{b}'..,",
            "{b}.'''{W}*{b}.{c}.'...'.{W}.{b}'{c}..,{B}<{G}>{c},{b}.{c}''{b}.{W}*{c}'{b},{W}*{c}.{b}.{W}**{b}.{c}'{b}'.{W}*{c}''{B}`",
            "{c}''{b}.'{c}''.'{b}'{c}.{B}`{W}.{b}.{c}','.{b}'..{W}~{c}''{b},{c}'..{b}`.{W}**{b}'.{c}.{b}.{c}'{b}'`{c},{b}'{B}`",
            "{c}.{b}`{c}...{b}'{W}*{c}.{b}'{W}.*{b},.'{c}.{b},.'{B}`{b},{c}'{M}<{Y}>{c},'{b}''{c}',..{b}''',{B}`{c}'{b}'{c}'{b}.{B}`",
            "{b}`{c}.,{b}..''{W}.{b}',{W}*{b}..{W}*{c}.{b}'{B}`{b}''{W}*{b},{c},{b}.'{c}'{b}.{c}'{W}*{c},,{b}`,.'.,{c}.{b}'{c}.{b},{W}*"

        });
    }

    /** Garagem em 3D com portao semiaberto e carro dentro. */
    public static void desenharGaragem() {
        imprimir(new String[]{
            "      {W}+----------------------------+",
            "     {W}/{r}::::::::::::::::::::::::::::{W}/|",
            "    {W}/{r}::::::::::::::::::::::::::::{W}/ |",
            "   {W}+----------------------------+  |",
            "   {W}|{Y}          GARAGEM           {W}|  |",
            "   {W}|  {k}________________________  {W}|  |",
            "   {W}| {k}|{w}========================{k}| {W}|  |",
            "   {W}| {k}|------------------------| {W}|  |",
            "   {W}| {k}|{w}========================{k}| {W}|  |",
            "   {W}| {k}|       {R}   ____          {k}| {W}|  |",
            "   {W}| {k}|       {R}  /|__|\\         {k}| {W}|  +",
            "   {W}| {k}|       {R}|{Y}o{R} ==== {Y}o{R}|       {k}| {W}| /",
            "   {W}| {k}|       {R}|_{k}O{R}____{k}O{R}_|       {k}| {W}|/",
            "   {W}+----------------------------+",
            "    {k}/                          \\",
            "   {k}/                            \\",
            "  {k}/                              \\",
            "{g},.,',.,',.,',.,',.,',.,',.,',.,',.,',.,'"
        });
    }

    /** Corredor escuro em perspectiva, com tochas, portas e um fantasma no fundo. */
   public static void desenharCorredorAssombrado() {
        imprimir(new String[]{
            "{M}##{w}========================================================={M}##",
            "{M}#####{w}==================================================={M}#####",
            "{M}########{m}:{w}-------------------------------------------{m}:{M}########",
            "{M}########{m}:::::{k}---------{R}o o{k}-----------{R}o o{k}---------{m}:::::{M}########",
            "{M}########{m}::::::#{k}#=============================#{m}#::::::{M}########",
            "{M}########{m}::{Y}^{m}:::#{k}##::#=====================#::##{m}#:::{Y}^{m}::{M}###{R}o o{M}##",
            "{M}########{m}::{y}|{m}:::#{k}##::##: {R}o o   {W}.-.       {k}:##::{R}o o{m}:::{y}|{m}::{M}########",
            "{M}##{R}o o{M}###{m}::{y}|{m}:::{R}o o{k}::##:      {W}({R}o o{W})  {R}o o {k}:##::##{m}#:::{y}|{m}::{M}########",
            "{M}########{m}::::::#{k}##::##:      {W}| O |      {k}:##::##{m}#::::::{M}########",
            "{M}########{m}::::::#{k}#{y}HHH{k}##: {R}o o  {W}'^^^'      {k}:##:#{y}HHH{k}#{m}:::::{M}#{R}o o{M}####",
            "{M}########{m}::::::#{k}#{y}HHH{k}##:   {R}o o     o o   {k}:##:#{y}HHH{k}#{m}:::::{M}########",
            "{M}########{m}::{R}o{m}:{R}o{m}:#{k}#{y}HHH{k}#...::::...::::....:::#:#{y}HHH{k}#{R}o{m}:{R}o{m}::{M}########",
            "{M}###{R}o o{M}##{m}::::::#{k}#.....:::::....:::::.....:::::{y}HH{k}#{m}:::::{M}########",
            "{M}########{m}:::{R}o{m}:{R}o{k}:::::......:::::......::::::......{m}:{R}o{m}:{R}o{m}:{M}########",
            "{M}########{m}:{W}:::::::.......:::{R}O{W}:{R}O{W}:........:::::::.......{m}:{M}########",
            "{M}#####{W}.........::::::::........:::::::::........:::::::::{M}#####",
            "{M}##{W}.........::::::::::.........::::::::::..........:::::::::{M}##"
        });
    }

    /** Sala em perspectiva com uma porta branca no fundo. */
    public static void desenharPortaBranca() {
        imprimir(new String[]{
            "{B}:{w}.............................{k}|{w}.............................{B}:",
            "{B}::::{w}..........................{k}|{w}..........................{B}::::",
            "{B}:::::::{w}.....................{Y}/___\\{w}.....................{B}:::::::",
            "{B}::::::::{b}::{k}.........................................{b}::{B}::::::::",
            "{B}::::::::{b}:::::{k}...................................{b}:::::{B}::::::::",
            "{B}::::::::{b}::::::::{k}.............................{b}::::::::{B}::::::::",
            "{B}::::::::{b}:::::::::::::::::::::::::::::::::::::::::::::{B}::::::::",
            "{B}::::::::{b}:{C}####{b}::::::::::::{w}#{W}_________{w}#{b}::::::::::::{Y}##{G}.{Y}#{b}:{B}::::::::",
            "{B}::::::::{b}:{C}#####{b}:::::::::::{W}|#########|{b}:::::::::::{G}....{Y}#{b}:{B}::::::::",
            "{B}::::::::{b}:{W}+++++{b}:::::::::::{W}|#.-----.#|{b}:::::::::::{G}....{Y}#{b}:{B}::::::::",
            "{B}::::::::{b}:{C}#####{b}:::::::::::{W}|#|{w}#####{W}|#|{b}:::::::::::{G}....{Y}#{b}:{B}::::::::",
            "{B}::::::::{b}:{C}#####{b}:::::::::::{W}|#'-----'{Y}o{W}|{b}:::::::::::::::::{B}::::::::",
            "{B}::::::::{b}:::::::::::::::::{W}|#.-----.#|{b}:::::::::::::::::{B}::::::::",
            "{B}::::::::{b}:::::::::::::::::{W}|#|{w}#####{W}|#|{b}:::::::::::::::::{B}::::::::",
            "{B}::::::::{b}:::::::::::::::::{W}|#'-----'#|{b}:::::::::::::::::{B}::::::::",
            "{B}::::::::{b}:::::{W}==={y}-----=====----=====-----====={W}==={b}:::::{B}::::::::",
            "{B}::::::::{b}::{W}==={y}======------=====------======------{W}==={b}::{B}::::::::",
            "{B}:::::::{W}==={y}====={Y}=={r}---------------------------{Y}=={y}-----{W}==={B}:::::::",
            "{B}:::{W}===={Y}------=={r}-------------------------------{Y}========{W}===={B}:::",
            "{W}===={Y}---------=========--------=========---------========={W}====",
            "{W}={Y}----------==========---------==========----------=========={W}="
        });
    }

    /** Fonte de duas bacias com jatos de agua. */
    public static void desenharFonte() {
        imprimir(new String[]{
            "                {C}.  '  .  {W}|  {C}.  '  .",
            "                {C}'  .  \\  {W}|  {C}/  .  '",
            "                 {C}.  '  \\ {W}| {C}/  '  .  ",
            "                        {C}\\{W}|{C}/",
            "                        {w}_|_",
            "                  {w}_.-'{C}~~~~~~~{w}'-._",
            "                  {w}'-.__{C}~~~~~{w}__.-'",
            "                        {w}| |",
            "                        {w}| |",
            "                       {w}_| |_",
            "       {w}_.-''{C}~~~~~~~~~~~~~~~~~~~~~~~~~~~{w}''-._",
            "       {w}/  {C}~~~~ ~~~ ~~ ~~~~ ~~~ ~~ ~~~~ ~~  {w}\\",
            "       {w}| {C}~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ {w}|",
            "       {w}\\_{C}~~ ~~~~ ~~~ ~~~~ ~~~ ~~~~ ~~~ ~~~{w}_/",
            "        {w}'-._____________________________.-' ",
            "{g},.,',.,',.,',.,',.,',.,',.,',.,',.,',.,',.,',.,',.,"
        });
    }

    // =====================================================================
    //  AUXILIARES
    // =====================================================================

    private static void imprimir(String[] linhas) {
        for (String linha : linhas) {
            System.out.println(colorir(linha));
        }
    }

    /** Troca os marcadores {x} por codigos de cor ANSI (ou remove, se COLORIDO = false). */
    private static String colorir(String linha) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < linha.length(); i++) {
            char ch = linha.charAt(i);
            if (ch == '{' && i + 2 < linha.length() && linha.charAt(i + 2) == '}') {
                if (COLORIDO) sb.append(codigo(linha.charAt(i + 1)));
                i += 2;
            } else {
                sb.append(ch);
            }
        }
        if (COLORIDO) sb.append("\u001B[0m");
        return sb.toString();
    }

    private static String codigo(char c) {
        switch (c) {
            case 'r': return "\u001B[31m";
            case 'g': return "\u001B[32m";
            case 'y': return "\u001B[33m";
            case 'b': return "\u001B[34m";
            case 'm': return "\u001B[35m";
            case 'c': return "\u001B[36m";
            case 'w': return "\u001B[37m";
            case 'k': return "\u001B[90m";
            case 'R': return "\u001B[91m";
            case 'G': return "\u001B[92m";
            case 'Y': return "\u001B[93m";
            case 'B': return "\u001B[94m";
            case 'M': return "\u001B[95m";
            case 'C': return "\u001B[96m";
            case 'W': return "\u001B[97m";
            default:  return "\u001B[0m";
        }
    }

    // =====================================================================
    //  MENU DE TESTE (pode apagar)
    // =====================================================================

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        while (true) {
            System.out.println("\n1) Casa  2) Pipa  3) Garagem  4) Corredor  5) Porta branca  6) Fonte  0) Sair");
            System.out.print("> ");
            String op = sc.nextLine().trim();
            switch (op) {
                case "1": desenharCasa(); break;
                case "2": desenharPipa(); break;
                case "3": desenharGaragem(); break;
                case "4": desenharCorredorAssombrado(); break;
                case "5": desenharPortaBranca(); break;
                case "6": desenharFonte(); break;
                case "0": return;
                default: System.out.println("Opcao invalida.");
            }
        }
    }
}