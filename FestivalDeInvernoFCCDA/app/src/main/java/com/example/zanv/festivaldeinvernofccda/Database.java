package com.example.zanv.festivaldeinvernofccda;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by André on 29/06/2015.
 *
 * A classe Database provem um vetor estático interno com os eventos utilizados no programa.
 * Os mesmos são acessados através dos métodos estáticos:
 *
 *  public static ArrayList<Evento> getList(int categoria);
 *  O valor categoria pode ser qualquer um dos valores:
 *
 *      Evento.CATEGORIA_MUSICA;
 *      Evento.CATEGORIA_CINEMA;
 *      Evento.CATEGORIA_LITERATURA;
 *      Evento.CATEGORIA_OFICINAS;
 *      Evento.CATEGORIA_CULTURA;
 *      Evento.CATEGORIA_TODOS;
 *      Evento.CATEGORIA_HOJE;
 *
 *  O método retorna um ArrayList<Evento> de todos os eventos disponíveis da categoria selecionada.
 *
 *  public static Evento getEvento(int identificador);
 *  Retorna o evento associado ao identificador.
 *
 *      Essa função só pode ser usada após uma chamada á Database.getList(), pois é durante esse método
 *      que os identificadores são relacionados aos seus eventos.
 */

public class Database {
    private static Evento [] database = {
        new Evento("Oficina de escultura com papel reutilizado – papietagem",
                    "Centro de Tradições - Distrito de Senhora do Carmo", "06/07", "9:00",
                            "Oficina de escultura com papel reutilizado - papietagem\n" +
                            "Oficina “Uma flor no cotidiano”\n" +
                            "Ministrante: Wânia Lage\n" +
                            "Turma 1\n" +
                            "Data: 6 a 10 de julho | 9h às 12h\n" +
                            "Local: Centro de Tradições - Distrito de Senhora do Carmo\n" +
                            "Vagas: 20\n" +
                            "Público-alvo: a partir de 15 anos\n" +
                            "Valor: Gratuito\n" +
                            "Turma 2\n" +
                            "Data: 6 a 10 de julho | 14h às 17h\n" +
                            "Local: Museu do Tropeiro - Distrito de Ipoema\n" +
                            "Vagas: 20" +
                            "Público alvo: a partir de 15 anos\n" +
                            "Valor: Gratuito\n\n" +
                            "Os participantes da oficina irão aprender as técni" +
                            "cas de papietagem para utilizar tiras de papel na " +
                            "criação de objetos e esculturas. Inspirados no tema " +
                            "“A rosa e o povo, o eu e o mundo”, irão confec" +
                            "cionar objetos de decoração de diversos modelos " +
                            "e tamanhos",
                           Evento.CATEGORIA_OFICINAS, Evento.FAIXA_ETARIA_16, R.drawable.g12),

            new Evento("Oficina de pintura de oratórios e objetos com técnicas especiais",
                        "Casa de Drummond", "13/07", "13:00", "Ministrante: Cybelle Curty\n" +
                    "Data: " +
                    "13 a 17 de julho | 13h às 17h\n" +
                    "Local: " +
                    "Casa de Drummond\n" +
                    "Vagas: " +
                    "10\n" +
                    "Público alvo: " +
                    "a partir de 15 anos\n" +
                    "Valor: " +
                    "R$10,00\n\n" +
                            "Esta oficina ensinará aos participantes a origem dos " +
                            "oratórios no Brasil, sua utilização e variedade artística. " +
                            "Os alunos aprenderão desde a preparação da peça crua " +
                            "até o acabamento artístico final, serão capazes de iden" +
                            "tificar tipos de tintas, massas e materiais de acabamen" +
                            "to, bem como suas aplicações para criar peças únicas. " +
                            "A reflexão poética dará fundamentos para o processo " +
                            "de criação, inspirando-se na beleza, no lirismo e na " +
                            "emoção dos textos de Drummond.",
                    Evento.CATEGORIA_OFICINAS, Evento.FAIXA_ETARIA_16, R.drawable.g12),

            new Evento("Oficina “De tudo fica um pouco”",
                    "FIDE/Sebrae - R. Dr. Sizenando de Barros, 27", "13/07", "09:00",
                    "Ministrante: Ana Cristina Azevedo\n" +
                    "Data: " +
                    "13 a 14 de julho | 9h às 11h\n" +
                    "Local: " +
                    "FIDE/Sebrae - R. Dr. Sizenando de Barros, 27\n" +
                    "Vagas: " +
                    "20\n" +
                    "Público-alvo: " +
                    "a partir de 6 anos\n" +
                    "Valor: " +
                    "R$10,00",
                    Evento.CATEGORIA_OFICINAS, Evento.FAIXA_ETARIA_LIVRE, R.drawable.g2),

            new Evento( "Jésus Henrique",
                        "Praça do Areão", "05/07", "18:00",
                        "Local: Praça do Areão | 18h\n" +
                                "Gratuito\n\n" +
                                "Sucesso de crítica e público no último The Voice Brasil, o itabirano Jésus Henrique é, hoje, referência de voz doce, " +
                                "afinada e envolvente. O jovem cantor descobriu o talento muito cedo, e de lá pra cá não parou mais. A potência " +
                                "vocal conquistou importantes cantores brasileiros como Daniel, Luiza Possi e Lulu Santos",
                    Evento.CATEGORIA_MUSICA, Evento.FAIXA_ETARIA_LIVRE, R.drawable.g5),

            new Evento( "Recital de Saxofone",
                        "Casa do Brás | Escola Livre de Música",
                        "06/07", "18:30",
                                "Local: Casa do Brás | Escola Livre de Música | 18h30\n" +
                                "Gratuito\n\n" +
                                "Os recitais de alunos da Escola Livre de Música já fazem parte da agenda mensal de eventos da Fundação Cultural " +
                                "Carlos Drummond de Andrade. Neles, os alunos demonstram os conhecimentos adquiridos ao longo dos meses " +
                                "de estudo. Nesta apresentação especial, a classe de saxofone mostra a versatilidade musical do instrumento com " +
                                "um repertório variado de canções de Charles Chaplin, Tom Jobim, Vinicius de Moraes e Chiquinha Gonzaga, entre " +
                                "outros.",
                    Evento.CATEGORIA_MUSICA, Evento.FAIXA_ETARIA_LIVRE, R.drawable.g5),

            new Evento( "Mesa-Redonda \"A Rosa do Povo: 70 Anos\"",
                        "Memorial Carlos Drummond de Andrade",
                        "06/07", "19:30",
                                "Local: Casa do Brás | Escola Livre de Música | 18h30\n" +
                                "Gratuito\n" +
                                "Local: Memorial Carlos Drummond de Andrade | 19h30\n" +
                                "Gratuito\n\n" +
                                "Mediada pelo jornalista e escritor Edmílson Caminha, esta mesa-redonda pretende discutir a importância histórica " +
                                "e literária do livro “A Rosa do Povo”, de Carlos Drummond de Andrade. Participam o jornalista monlevadense Wir " +
                                "Caetano, o professor da Unifei, Milton Zamboni, o integrante da Academia Itabirana da Letras, Marconi Ferreira " +
                                "e a pesquisadora literária, especialista em Drummond, Solange Alvarenga.",
                    Evento.CATEGORIA_CULTURA, Evento.FAIXA_ETARIA_LIVRE, R.drawable.g6),

            new Evento( "Exposição literária itinerante “A Rosa o Povo, o eu e o mundo”",
                        "Galeria da Fundação Cultural", "07/07", "8:00",
                                "Local: " +
                                "Galeria da Fundação Cultural\n" +
                                "Período expositivo: " +
                                "7 de julho a 7 de agosto | 8h " +
                                "às 19h\n\n" +
                                "Com curadoria da Biblioteca Pública Luiz Camillo " +
                                "de Oliveira Netto, esta exposição reúne banners " +
                                "com poemas especialmente selecionados do livro “A " +
                                "Rosa do Povo”, de Carlos Drummond de Andrade, " +
                                "para comemorar os 70 anos de seu lançamento. O " +
                                "visitante poderá conhecer mais de perto os textos " +
                                "que fazem deste livro uma obra icônica.",
                    Evento.CATEGORIA_LITERATURA, Evento.FAIXA_ETARIA_LIVRE, R.drawable.g7),

            new Evento("Os sons da madeira - Exposição de luthieria com Luiz Cássio",
                        "Foyer da Fundação Cultural", "08/07", "19:30",
                        "Abertura: " +
                        "19h30\n" +
                        "Local: " +
                        "Foyer da Fundação Cultural\n" +
                        "Período expositivo: " +
                        "8 a 25 de julho | 8h às 19h\n\n" +
                        "O luthier e marceneiro itabirano Luiz Cássio de Alvarenga Martins Cruz " +
                        "descobriu a aptidão para a arte de fazer violão ainda na adolescência, " +
                        "com o pai, José Martins Cruz, também luthier. Violonista de formação " +
                        "erudita, Luiz Cássio mostra nesta exposição que a inspiração no pai " +
                        "rendeu bons frutos, e uma longa e conhecida carreira como luthier de " +
                        "violões e violas.",
                        Evento.CATEGORIA_CULTURA, Evento.FAIXA_ETARIA_LIVRE, R.drawable.g7),

            new Evento("Projeto “Claro Enigma” – sessão comentada",
                    "Memorial Carlos Drummond de Andrade",
                    "22/07", "20:00",
                    "Local: Memorial Carlos Drummond de Andrade | 20h\n" +
                    "Filme: “O vestido”, de Paulo Thiago (Drama | 120’ | 2004)\n" +
                    "Classificação indicativa: 14 anos\n" +
                    "Gratuito\n\n" +
                    "Entre os projetos de descentralização da cultura, a Extensão Cultural levará " +
                    "ao bairro Praia uma animada programação, com espetáculo do Circo Vira " +
                    "Volta e pintura facial para a criançada.\n" +
                    "Ao transpor o famoso poema de Drummond, “Caso do vestido”, para uma " +
                    "linguagem cinematográfica, o diretor Paulo Thiago e o roteirista Haroldo " +
                    "Marinho venceram um grande desafio. Em uma narrativa carregada de " +
                    "drama, duas irmãs encontram um vestido de festa no porão, e, ao questio" +
                    "narem a descoberta, concluem que foi aquele vestido a causa da separação " +
                    "dos pais.",
                    Evento.CATEGORIA_CINEMA, Evento.FAIXA_ETARIA_14, R.drawable.g6),

            new Evento("Palestra com Carlos Felipe",
                        "Galeria da Fundação Cultural", "16/07", "19:00",
                        "Local: Galeria da Fundação Cultural | 19h\n" +
                        "Classificação: livre\n\n" +
                        "O escritor Carlos Felipe faz uma palestra em " +
                        "que reflete sobre o período após a edição do " +
                        "livro “A Rosa do Povo”, de Carlos Drummond " +
                        "de Andrade. A ideia do escritor é falar sobre o " +
                        "momento político em que Drummond estava " +
                        "inserido quando publicou o livro, além de todo " +
                        "o contexto social e histórico da época.",
                        Evento.CATEGORIA_LITERATURA, Evento.FAIXA_ETARIA_LIVRE, R.drawable.g6)
    };

    public static ArrayList<Evento> getList(int categoria)
    {
        ArrayList<Evento> ret = new ArrayList<Evento>();

        if(categoria == Evento.CATEGORIA_TODOS) {
            for(int c=0; c<database.length; ++c) {
                database[c].identificador = c;
                ret.add(database[c]);
            }
        }
        else if(categoria == Evento.CATEGORIA_HOJE)
        {
            Calendar calendar;
            calendar = Calendar.getInstance();
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            int mes = calendar.get(Calendar.MONTH);
            mes++;

            /*
            //Para testes, faz como que a data atual seja o dia 13/07.
            dia = 13;
            mes = Calendar.JULY;
            mes++;
            */
            for(int c=0; c<database.length; ++c) {
                database[c].identificador = c;
                String [] buffer = database[c].data.split("/");
                if(Integer.parseInt(buffer[0]) == dia &&
                   Integer.parseInt(buffer[1]) == mes)
                    ret.add(database[c]);
            }
        }
        else
        {
            for(int c=0; c<database.length; ++c) {
                database[c].identificador = c;
                if(database[c].categoria == categoria)
                    ret.add(database[c]);
            }
        }
        return ret;
    }
    public static Evento getEvento(int identificador)
    {
        for(int c=0; c<database.length; ++c)
            if(database[c].identificador == identificador)
                return database[c];
        return database[0];
    }
}
