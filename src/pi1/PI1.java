package pi1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class PI1 {
    
    
	
	static Scanner sc = new Scanner(System.in);
	
	public static void participacaoJogo() {
		//exibe o tÃ­tulo e ao clicar enter o jogo inicia
		String confirmacao;
		int x = 0;
		
		System.out.println("                                                                                                                 \n" + 
				"88b           d88                       88        88                          88                                 \n" + 
				"888b         d888                ,d     88        88                          88                                 \n" + 
				"88`8b       d8'88                88     88        88                          88                                 \n" + 
				"88 `8b     d8' 88  ,adPPYYba,  MM88MMM  88aaaaaaaa88  ,adPPYYba,   ,adPPYba,  88   ,d8    ,adPPYba,  8b,dPPYba,  \n" + 
				"88  `8b   d8'  88  \"\"     `Y8    88     88\"\"\"\"\"\"\"\"88  \"\"     `Y8  a8\"     \"\"  88 ,a8\"    a8P_____88  88P'   \"Y8  \n" + 
				"88   `8b d8'   88  ,adPPPPP88    88     88        88  ,adPPPPP88  8b          8888[      8PP\"\"\"\"\"\"\"  88          \n" + 
				"88    `888'    88  88,    ,88    88,    88        88  88,    ,88  \"8a,   ,aa  88`\"Yba,   \"8b,   ,aa  88          \n" + 
				"88     `8'     88  `\"8bbdP\"Y8    \"Y888  88        88  `\"8bbdP\"Y8   `\"Ybbd8\"'  88   `Y8a   `\"Ybbd8\"'  88          \n" + 
				"                                                                                                              ");
		while (x != 1) {
			System.out.println("\n\t\t\t\t\tClique enter para jogar");
			confirmacao = sc.nextLine();
			
			if (confirmacao.equals("")) {
				x = 1;
			} else {
				x = 0;
			}
		}
	}
	
	public static String[] definiPersonagem() {
		//usuÃ¡rio insere as informaÃ§Ãµes do funcionÃ¡rio e armazena em um array
		String nomePersonagem = "";
		int idade = 0,
			x = 0,
			z = 0;
		char sexo = 0;
		String resultado[] = new String[3];
		
		System.out.println("Bem-vindo ao MatHacker!");
		System.out.println("\nVamos escolher como serÃ¡ seu personagem");
		
		//confere se o sexo passado pelo usuÃ¡rio Ã© um tipo vÃ¡lido, M ou F
		while (z != 1) {
			System.out.println("\nQual o sexo? \nM - Masculino \nF - Feminino");
			sexo = sc.next().toUpperCase().charAt(0);
			if (sexo != 'M' && sexo != 'F') {
				System.out.println("OpÃ§Ã£o inexistente!\nInsira uma opÃ§Ã£o disponÃ­vel!");
				z = 0;
			} else {
				z = 1;
			}
		}
		
		//confere se o personagem tem idade maior que 18 anos
		System.out.print("\nQual o nome desejado? ");
		nomePersonagem = sc.next();
		
		while (x != 1) {
			System.out.print("\nQual a idade? ");
			idade = sc.nextInt();
			if (idade < 18) {
				System.out.println("O personagem precisa ser 18+ \nInsira uma idade vÃ¡lida!");
				x = 0;
			} else {
				x = 1;
			}
		}
		
		resultado[0] = String.valueOf(sexo); 
		resultado[1] = nomePersonagem;
		resultado[2] = String.valueOf(idade);
		
		return resultado;
	}
	

	public static String confereInformacoes(String informacoes[]) {
		//funÃ§Ã£o que observa se todos as informaÃ§Ãµes inseridas pelo funcionÃ¡rio foram colocadas dentro do array
		String resultado = "";
		if ((informacoes[0] != "") && (informacoes[1] != "") && (informacoes[2] != "")) {
			resultado = "ok";
		} else {
			resultado = "error";
		}
		return resultado;
	}
	
	public static String selecionaBoneco(char sexo) {
		//defini a partir da entrada do sexo no array de informaÃ§Ãµes qual serÃ¡ o personagem do usuÃ¡rio
		String boneco = "";
		switch (sexo) {
			case 'M': 
				boneco = "      ////^\\\\\\\\\n" + 
						"      | ^   ^ |\n" + 
						"     @ (o) (o) @\n" + 
						"      |   <   |\n" + 
						"      |  ___  |\n" + 
						"       \\_____/\n" + 
						"     ____|  |____\n" + 
						"    /    \\__/    \\\n" + 
						"   /              \\\n" + 
						"  /\\_/|        |\\_/\\\n" + 
						" / /  |________|  \\ \\\n";
				break;
			case 'F':
				boneco = " /////////////\\\\\\\\\n" + 
						"(((((((((((((( \\\\\\\\\n" + 
						"))) ~~      ~~  (((\n" + 
						"((( (*)     (*) )))\n" + 
						")))     <       (((\n" + 
						"((( '\\______/`  )))\n" + 
						")))\\___________/(((\n" + 
						"       _) (_\n" + 
						"      / \\_/ \\\n" + 
						"     /(     )\\\n" + 
						"    // )___( \\\\\n";
				break;
		}
		return boneco;
	}
	
	/******************************************************************INÃ?CIO FASE 1****************************************************************/
	public static void carregarInicio(String status) {
		//mÃ©todo que marca o inÃ­cio da primeira fase
		switch(status) {
			case "ok":
				System.out.println("\nVocÃª estÃ¡ pronto? O jogo vai comeÃ§ar");
				System.out.println("Mostre suas habilidades");
				System.out.println("Tente vencer os desafios");
				try {
					//programa aguarda 60 segundos para exibir que comeÃ§o o jogo
					Thread.sleep(6000);
					System.out.println("\n\n â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?          â–ˆâ–ˆâ€? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?      â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€? â–ˆâ–ˆâ–ˆâ€?   â–ˆâ–ˆâ–ˆâ€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?      â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€? \n" + 
										   "â–ˆâ–ˆâ€?â€?â€?â€?â–ˆâ–ˆâ€?         â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â€?â€?â€? â–ˆâ–ˆâ€?â€?â€?â€?â–ˆâ–ˆâ€?    â–ˆâ–ˆâ€?â€?â€?â€?â€?â€?â–ˆâ–ˆâ€?â€?â€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ–ˆâ–ˆâ€? â–ˆâ–ˆâ–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â€?â€?â€?â–ˆâ–ˆâ€?â€?â€?â€?â€?â€?â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?    â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â€?â€?â€? â–ˆâ–ˆâ€?â€?â€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?\n" + 
										   "â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?         â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?  â–ˆâ–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?    â–ˆâ–ˆâ€?     â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?  â–ˆâ–ˆâ€?     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?    â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â–ˆâ–ˆâ€?  â–ˆâ–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?\n" + 
										   "â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?    â–ˆâ–ˆ   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?    â–ˆâ–ˆâ€?     â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â€?  â–ˆâ–ˆâ€?     â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?    â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?   â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ€?\n" + 
										   "â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?    â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?    â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ€? â€?â€?â€? â–ˆâ–ˆâ€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â–ˆâ–ˆâ€?  â–ˆâ–ˆâ€?    â–ˆâ–ˆâ€?  â–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â€?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ€?â€?â–ˆâ–ˆâ€?  â–ˆâ–ˆâ€?â–ˆâ–ˆâ€?  â–ˆâ–ˆ");
					//marca o inicio da primeira faase
					System.out.println("\n\t\t\t\t\t\t\t\tFASE I");
				} catch (InterruptedException e) {
					System.out.println("Mexeu");
				}
				
				break;
			case "error":
				break;
		}
	}
	
	public static void historiaInicial(String nome, int idade, char sexo) {
		//metodo que traz a contextualizaÃ§Ã£o e a histÃ³ria inicial do jogo 
		String genero = "",
			   artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if (sexo == 'M') {
			genero = "Ã© um homem de "+idade+" anos";
			artigo = "O";
		} else {
			genero = "Ã© uma mulher "+idade+" anos";
			artigo = "A";
		}
		//escreve histÃ³ria utilizando o nome e o artigo
		String pt1[] = 
			{
					"\n\nNossa", "histÃ³ria", "se", "passa", "em", "SÃ£o Paulo.", "O sÃ©culo XXI", "estÃ¡ em seu", "Ã¡pice,",
					"a globalizaÃ§Ã£o", "se torna", "cada vez", "mais notÃ¡vel.", "Os avanÃ§os tecnolÃ³gicos", 
					"comeÃ§am a ser percebidos e", "diversos grupos", "de malfeitores se aproveitam", "destes avanÃ§os para",
					"cometer crimes", "no ambiente virtual.", "Inserido neste contexto", nome, "comeÃ§a a se", "interessar",
					"pelos conhecimentos tecnolÃ³gicos.\n",nome, genero, "que mora em", "um condomÃ­nio",
					"com seu pai,", "sua mÃ£e", "e sua irmÃ£.", "ApÃ³s obter o interesse", "nos conhecimentos da", 
					"Ã¡rea de tecnologia,", nome, "investiu em aprender", "e dominar esta arte,", 
					"com um Ãºnico", "objetivo em mente:", "SE TORNAR",artigo, "MELHOR HACKER", "DE SÃƒO PAULO"
			};
		String pt2[] = 
			{
				"\n\nPara se tornar", artigo.toLowerCase(), "melhor hacker", "era necessÃ¡rio", "testar seus conhecimentos,", "para ver se as habilidades", "haviam sido desenvolvidas",
				"da melhor maneira.", "Os testes comeÃ§aram a ser realizados", "e", nome, "se mostrou muito talentoso.", "PorÃ©m, passados os desafios iniciais,",
				"as coisas se tornaram mais difÃ­ceis", "e", nome, "comeÃ§ou a ter mais dificuldades."
			};
		//exibi cada frase ou palavra do array um apÃ³s o outro com delay de 5 segundos
		for (int i = 0; i <= pt1.length-1; i++) {
			if(pt1[i].contains(".") || pt1[i].contains(":")) {
				System.out.print(pt1[i]+"\n");
			} else {
				System.out.print(pt1[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
		for (int i = 0; i <= pt2.length-1; i++) {
			if(pt2[i].contains(".") || pt2[i].contains(":")) {
				System.out.print(pt2[i]+"\n");
			} else {
				System.out.print(pt2[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static String desafio1(String nome, char sexo, String personagem) {
		int resposta = 0,
			cont = 1;
		String artigo = "",
			   status = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		//contextualizaÃ§Ã£o e histÃ³ria do primeiro desafio, utilizando o nome e o artigo
		String desafio[] = 
			{
				"\nEm um certo dia", nome, "com o objetivo de", "testar seus conhecimentos", "decide abrir", "a porta do quarto da irmÃ£.",
				"O quarto tinha", "uma fechadura eletrÃ´nica", "com senha de trÃªs dÃ­gitos.", "Por sempre observar", "a irmÃ£ digitar a senha de desbloqueio",
				artigo,"jÃ¡ sabia", "que os dois primeiros dÃ­gitos eram,", "respectivamente,", "2 e 3.", "Resta agora para descobrir,", "apenas o terceiro dÃ­gito.",
				"Para descobrir", "ele entrou no sistema", "da fechadura,", "ao abrir o sistema ele se deparou", "com o algoritmo de criaÃ§Ã£o do Ãºltimo digito", 
				"que era:", "\nTERCEIRO DÃ?GITO = (((SEGUNDO DÃ?GITO x 8) + PRIMEIRO DÃ?GITO) - (PRIMEIRO DÃ?GITO x 6)) / PRIMEIRO DÃ?GITO .", "\nPor jÃ¡ saber os primeiros digitos,", nome,
				"organizou a funÃ§Ã£o", "para descobrir com mais facilidade,", "desta forma a funÃ§Ã£o ficou:", "\nTERCEIRO DÃ?GITO = (((3 x 8) + 2) - (2 x 6)) / 2"
			};
		//exibiÃ§Ã£o do array com dela de 5 segundos 
		for (int i = 0; i <= desafio.length-1; i++) {
			if(desafio[i].contains(".") || desafio[i].contains(":")) {
				System.out.print(desafio[i]+"\n");
			} else {
				System.out.print(desafio[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		//mostra o personagem e a senha com a incÃ³gnita
		System.out.println("\n\n"+personagem+"  _____    _____    _____\n"
				          +" |     |  |     |  |     |\n"
				          + " |  2  |  |  3  |  |  ?  |\n"
				          + " |_____|  |_____|  |_____|\n");
		
		System.out.println(nome+" tem apenas 2 tentativas");
		// pede para o usuÃ¡Å•io entrar com a resposta da incÃ³gnita e exibe
		do {
			System.out.print("\nQual dÃ­gito que estÃ¡ faltando? ");
			resposta = sc.nextInt();
			
			System.out.println("  _____    _____    _____\n"
			          +" |     |  |     |  |     |\n"
			          + " |  2  |  |  3  |  |  "+resposta+"  |\n"
			          + " |_____|  |_____|  |_____|\n");
			if(cont == 2) {
				if(resposta == 7) {
					System.out.println("Porta desbloqueada!");
					status = "correta";
				} else {
					System.out.println("Senha incorreta!");
					status = "incorreta";
				}
			} else {
				if(resposta == 7) {
					System.out.println("Porta desbloqueada!");
					status = "correta";
				} else {
					System.out.println("Resposta Incorreta! Tente novamente.");
					status = "incorreta";
				}
			}
			cont++;
			//este laÃ§o Ã© exibido no mÃ¡ximo duas vezes, parando a exibiÃ§Ã£o tambÃ©m se o usuÃ¡rio acertar na primeira tentativa
		} while (resposta != 7 && cont <= 2);
		
		return status;
		
	}
	
	public static void historiaDesafio2(String nome, char sexo) {
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		//historia do segundo desafio
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				nome, "comeÃ§ou a perceber", "que suas contas de luz", "estavam atingindo", "valores exorbitantes,", "muito maiores do que", "a famÃ­lia",
				"poderia pagar.", "Ele procurou", "em seus arquivos", "e observou uma brecha", "onde poderia agir.", "Havia uma parte do cÃ³digo", "que permitia",
				"que com algumas mudanÃ§as", nome, "determinasse aonde","o relÃ³gio medidor de luz","pararia de contar", "os kWh(kilowatt) gastos.",
				"Para determinar", "ele precisa", "estipular o valor mÃ¡ximo a ser pago.",nome,"conversou", "com sua famÃ­lia e", "juntos decidiram que", 
				"R$250,00 era o mÃ¡ximo que", "conseguiriam pagar.", "Com o valor mÃ¡ximo determinado,", nome, "entrou no sistema do", "relÃ³gio medidor",
				"e descobriu que", "o preÃ§o do kWh era de R$0,4.", "Sabendo disso restava descobrir apenas", "aonde aonde o relÃ³gio pararia de contar",
				"para isso", nome, "escreveu a seguinte funÃ§Ã£o:", "\nMÃ?XIMO KWH x PREÃ‡O KWH = VALOR MÃ?XIMO .", "\nCruzando com as informaÃ§Ãµes", "que",artigo,
				"jÃ¡ tinha,", nome, "reescreveu a funÃ§Ã£o da seguinte maneira:", "\nMÃ?XIMO KWH x 0,4 = 250 .",nome, "tem apenas 2 tentativas."
				
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
		
	}
	
	public static String desafio2() {
		int correta = 0;
		int cont = 1;
		String status = "";
		char resposta = 0;
		ArrayList<String> alternativas = new ArrayList<String>();
		//adicionando as alternativas ao arraylist
		alternativas.add("620");
		alternativas.add("625");
		alternativas.add("650");
		alternativas.add("600");
		alternativas.add("575");
		
		 do {
			System.out.println("\nDescobrir o mÃ¡ximo de kWh => MÃ?XIMO KWH x 0,4 = 250");
			System.out.println("\nO relÃ³gio terÃ¡ que parar de registrar ao chegar a marca de quantos kWh?");
			//troca as alternativas de posiÃ§Ã£o
			Collections.shuffle(alternativas);
			//exie todas as alternatias do arraylist 
			for(int i = 0; i <= alternativas.size()-1; i++) {
				switch (i) {
					case 0:
						System.out.println("a) "+alternativas.get(i));
						break;
					case 1:
						System.out.println("b) "+alternativas.get(i));
						break;
					case 2:
						System.out.println("c) "+alternativas.get(i));
						break;
					case 3:
						System.out.println("d) "+alternativas.get(i));
						break;
					case 4:
						System.out.println("e) "+alternativas.get(i));
						break;
				}
			}
				resposta = sc.next().toUpperCase().charAt(0);
			//observa se a resposta inputada pelo usuÃ¡rio estÃ¡ correta
				switch(resposta) {
				case 'A':
					if (alternativas.get(0).equals("625")) {
						System.out.println("Quantidade de kWh correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Quantidade de kWh incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
				case 'B':
					if (alternativas.get(1).equals("625")) {
						System.out.println("Quantidade de kWh correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Quantidade de kWh incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
				case 'C':
					if (alternativas.get(2).equals("625")) {
						System.out.println("Quantidade de kWh correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Quantidade de kWh incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
				case 'D':
					if (alternativas.get(3).equals("625")) {
						System.out.println("Quantidade de kWh correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Quantidade de kWh incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
				case 'E':
					if (alternativas.get(4).equals("625")) {
						System.out.println("Quantidade de kWh correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Quantidade de kWh incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
			}
				cont++;
				//este laÃ§o tem sua execuÃ§Ã£o interrompida apÃ³s a realizaÃ§Ã£o das duas tentativas ou respota correta
		} while (correta != 1 && cont <= 2);
		 return status;
	}
	
	public static void historiaDesafio3(char sexo, String nome) {
		//historia do desafio 3
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				"ApÃ³s realizar", "estes testes mais simples", nome, "decide realizar um", "teste mais desafiador.", nome, "precisava entrar no", "computador",
				"do zelador do prÃ©dio", "onde morava.", "Para isso", "ele precisa descobrir o", "horÃ¡rio que a sala", "do zelador estÃ¡ vazia", "entrar e", 
				"hackear a senha", "do computador.", nome, "comeÃ§ou a observar o zelador", "e descobriu que", "todo dia no horÃ¡rio", "das 7 da noite", 
				"o zelador saÃ­a", "para jantar", "e a sala ficava sozinha", "por meia hora.", "Oportunidade perfeita", "para agir sem ser descoberto.",
				nome, "se preparou e", "Ã s 7 da noite, se dirigiu a sala", "chegando lÃ¡", "se deparou com o seguinte algoritmo para determinar a senha:", 
				"Senha composta por", "4 dÃ­gitos,", "o nÃºmero formado", "pelos quatro dÃ­gitos unidos", "constava na classe", "dos nÃºmeros naturais e",
				"na casa dos milhares.", nome, "nÃ£o entendeu muito este algoritmo de formaÃ§Ã£o,", "para entender ele", "comeÃ§ou a procurar", "um exemplo e",
				artigo, "achou.", "O exemplo foi o seguinte :", "\nSe o algoritmo da senha for", "\n1 x 1000", "+ 7 x 100", "+ 0 x 10", "+ 9 x 1", "\nA senha",
				"serÃ¡ 1709.", nome, "entendeu a explicaÃ§Ã£o e foi tentar acertar", "a senha do zelador", artigo, "pode tentar atÃ© acertar."
				
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	public static String desafio3(String personagem) {
		String senha = "",
			   senhaInserida = "",
			   status = "";
		int digito1 = 0,
			digito2 = 0,
			digito3 = 0,
			digito4 = 0,
			correta = 0;
		Random variavel = new Random();
		//determina que o valor da senha do zelador terÃ¡ que ser entre 1000 e 9999
		senha = String.valueOf(variavel.nextInt((9999 - 1000) + 1) + 1000);
		do {
			System.out.println("\nQual Ã© a senha para entrar no computador?");
			System.out.print("O algoritmo de formaÃ§Ã£o da senha do zelador Ã©: ");
			//exibe o algoritmo de formaÃ§Ã£o da senha atravÃ©s do tratamento via substring da senha do zelador
			System.out.println(senha.substring(0, 1) + " x 1000 + " + 
							   senha.substring(1, 2) + " x 100 + " + 
							   senha.substring(2, 3) + " x 10 + " + 
							   senha.substring(3) + " x 1");
			//exibe todas os dÃ­gitos da senha como incÃ³gnitas
			System.out.println("\n"+personagem+"  _____    _____    _____    _____\n"
			          +" |     |  |     |  |     |  |     |\n"
			          + " |  ?  |  |  ?  |  |  ?  |  |  ?  |\n"
			          + " |_____|  |_____|  |_____|  |_____|\n");
			System.out.print("Entre com o primeiro dÃ­gito: ");
				digito1 = sc.nextInt();
			System.out.print("Entre com o segundo dÃ­gito: ");
				digito2 = sc.nextInt();
			System.out.print("Entre com o terceiro dÃ­gito: ");
				digito3 = sc.nextInt();
			System.out.print("Entre com o quarto dÃ­gito: ");
				digito4 = sc.nextInt();
			//observa se os valores inutados pelo usuÃ¡rio sÃ£o vÃ¡lidos 
			if ((digito1 >= 0 && digito1 < 10) && (digito2 >= 0 && digito2 < 10) && (digito3 >= 0 && digito3 < 10) && (digito4 >= 0 && digito4 < 10)) {
				//exibe as entradas dousuÃ¡rio no lugar das incÃ³gnitas
				System.out.println("  _____    _____    _____    _____\n"
				          +" |     |  |     |  |     |  |     |\n"
				          + " |  "+digito1+"  |  |  "+digito2+"  |  |  "+digito3+"  |  |  "+digito4+"  |\n"
				          + " |_____|  |_____|  |_____|  |_____|\n");
				//concatena todas as entradas do usuÃ¡rio e transforma em um Ãºnica String
				senhaInserida = String.valueOf(digito1)+String.valueOf(digito2)+String.valueOf(digito3)+String.valueOf(digito4);
				//compara se a senha original do zelador Ã© igual a senha inserida pelo usuÃ¡rio
				if (senha.equals(senhaInserida)) {
					System.out.println("Senha Correta! Computador desbloqueado!");
					correta = 1;
					status = "correta";
				} else {
					System.out.println("Senha Incorreta! Tente novamente!");
				}
			} else {
				System.out.println("Algum valor inserido Ã© invÃ¡lido, por ser maior que 9 ou negativo");
			}
			//este laÃ§o sÃ³ te sua exibiÃ§Ã£o interrompida quando o usuÃ¡rio acerta a resposta
		} while(correta != 1);
		return status;
	}
	
	public static void historiaDesafio4(char sexo, String nome) {
		//historia do desafio 4
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				"O acesso ao computador", "do zelador", "foi um sucesso,", "porÃ©m tinha um problema,", "para descobrir a senha", artigo, "tinha demorado",
				"10 minutos.", "EntÃ£o sÃ³ restavam", "mais 20 minutos para o", "zelador voltar,", "por isso", nome, "tinha que agir", "com muita velocidade.", 
				"Tinham duas coisas", "que", nome, "queria fazer,", "acessar o servidor de cÃ¢meras do prÃ©dio", "e acessar", "o servidor de alarmes.",
				"Com o acesso", "ao servidor de cÃ¢meras", "ele vai conseguir saber tudo", "o que estÃ¡ acontecendo", "no prÃ©dio.", "EntÃ£o", nome, 
				"comeÃ§ou por esse servidor,", "para conseguir acessar", "era necessÃ¡rio obter a senha", "do servidor,", "para isso", artigo, "tinha que",
				"analisar o cÃ³digo.", nome, "observou que a senha", "era guardada dentro do sistema", "com uma criptografia", "de hexadecimal,", "no",
				"sistema havia um comentÃ¡rio", "que exemplificava a", "criptografia:", "\nSENHA = 64202 .", "SENHA GUARDADA NO SISTEMA = FACA .", "Logo",
				artigo, "percebeu que", "para descobrir a senha do servidor era sÃ³", "converter a senha que estava no sistema", "em base hexadecimal", 
				"para base decimal.", "Essa senha Ã©", "composta por", "5 dÃ­gitos.", nome, "tem 2 tentativas."
				
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	public static String desafio4(String personagem) {
		//estrutura desafio 4
		Random posicao = new Random();
		String senhaServidor = "",
			   senhaInserida = "";
		int elevado = 0;
		int senhaDecimal = 0,
			correta = 0,
			tentativa = 1;
		String digito1 = "",
			   digito2 = "",
			   digito3 = "",
			   digito4 = "",
			   digito5 = "",
			   status = "";
		String[] possibilidadeSenha = new String[5];
		//adicionando possÃ­veis senhas
		possibilidadeSenha[0] = "CADA";
		possibilidadeSenha[1] = "BABA";
		possibilidadeSenha[2] = "FADA"; 
		possibilidadeSenha[3] = "DADA"; 
		//escolhendo uma das opÃ§Ãµes de senha de dentro do array
		senhaServidor = possibilidadeSenha[posicao.nextInt(4)];
		
		
			
			//transformando a senha escolhida de hexadecimal para decimal
			for (int i = 0; i < senhaServidor.length(); i++) {
				if (i == 0) {
					elevado = 3;
				} else if (i == 1) {
					elevado = 2;
				} else if (i == 2) {
					elevado = 1;
				} else if (i == 3) {
					elevado = 0;
				}
			 	if (senhaServidor.substring(i, (i+1)).equals("A")) {
			 		senhaDecimal += 10 * (int)Math.pow(16, elevado);
			 	} else if (senhaServidor.substring(i, (i+1)).equals("B")) {
			 		senhaDecimal += 11 * (int)Math.pow(16, elevado);
			 	} else if (senhaServidor.substring(i, (i+1)).equals("C")) {
			 		senhaDecimal += 12 * (int)Math.pow(16, elevado);
			 	} else if (senhaServidor.substring(i, (i+1)).equals("D")) {
			 		senhaDecimal += 13 * (int)Math.pow(16, elevado);
			 	} else if (senhaServidor.substring(i, (i+1)).equals("F")) {
			 		senhaDecimal += 15 * (int)Math.pow(16, elevado);
			 	}
			}
			//pedindo para o usuÃ¡rio inputar a senha correta
			do {
			System.out.println("\nA senha que estÃ¡ no servidor Ã©: "+senhaServidor);
			System.out.println("Qual a senha para acessar o servidor?");
			System.out.println("\n"+personagem+"  _____    _____    _____    _____    _____\n"
			          +" |     |  |     |  |     |  |     |  |     |\n"
			          + " |  ?  |  |  ?  |  |  ?  |  |  ?  |  |  ?  |\n"
			          + " |_____|  |_____|  |_____|  |_____|  |_____|\n");
			System.out.print("Entre com o primeiro dÃ­gito: ");
				digito1 = sc.next();
			System.out.print("Entre com o segundo dÃ­gito: ");
				digito2 = sc.next();
			System.out.print("Entre com o terceiro dÃ­gito: ");
				digito3 = sc.next();
			System.out.print("Entre com o quarto dÃ­gito: ");
				digito4 = sc.next();
			System.out.print("Entre com o quinto dÃ­gito: ");
				digito5 = sc.next();
			
			senhaInserida = digito1 +""+ digito2 +""+ digito3 +""+ digito4 +""+ digito5; 
			System.out.println("  _____    _____    _____    _____    _____\n"
			          +" |     |  |     |  |     |  |     |  |     |\n"
			          + " |  "+digito1+"  |  |  "+digito2+"  |  |  "+digito3+"  |  |  "+digito4+"  |  |  "+digito5+"  |\n"
			          + " |_____|  |_____|  |_____|  |_____|  |_____|\n");
			if(senhaInserida.equals(String.valueOf(senhaDecimal))) {
				System.out.println("Senha correta! Servidor pode ser acessado!");
				correta = 1;
				status = "correta";
			} else {
				System.out.println("Senha Incorreta! NÃ£o foi possÃ­vel conectar ao servidor!");
				correta = 0;
				status = "incorreta";
			}
			tentativa++;
			//laÃ§o de repetiÃ§Ã£o para a execuÃ§Ã£o se a alternativa estiver correta ou o nÃºmero de tentativas extrapole
		}while(correta != 1 && tentativa <= 2);
		return status;
	}
	
	public static void historiaDesafio5(char sexo, String nome) {
		//historia do desafio 5
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				"Para tentar achar", "a senha do servidor de", "cÃ¢meras,", nome, "gastou mais 10 minutos.", "Por isso as",
				"coisas tinham se dificultado,", "sÃ³ restavam mais 10 minutos", "para", artigo, "conseguir descobrir a senha do", 
				"servidor de alarmes.", "Se tudo correr bem,", nome, "termina de acessar", "e consegue sair da sala do", 
				"zelador antes dele voltar.", nome, "quer o acesso aos", "alarmes", "porque", "com os acessos em mÃ£os,",
				"ele vai conseguir", "programar o sistema", "para enviar alertas de movimento", "prÃ³ximos ao seu", "andar.",
				"Conseguindo desta forma", "estar preparado e", "antecipado a qualquer pessoa", "que se aproxime de sua casa.",
				nome, "comeÃ§ou a procurar", "no cÃ³digo", "o algoritmo de formaÃ§Ã£o da senha", "do servidor de cÃ¢meras.", "Quando", artigo,
				"achou, ele percebeu", "que esta seria a", "resoluÃ§Ã£o que traria mais dificuldade,", "pois o algoritmo de formaÃ§Ã£o", "era o seguinte:",
				"Primeiro dÃ­gito do produto de 12345679 pela chave gerada pelo sistema,", "onde para cada dÃ­gito serÃ¡ fornecido uma chave.",
				"A senha Ã© formada por", "4 dÃ­gitos.", nome, "nÃ£o entendeu",
				"muito, por isso", "continuou procurando", "e achou um exemplo mais claro", "que era:", "\nDÃ?GITO 1 =>", "12345679 x 9 =>", "1", 
				"(onde 9 foi a chave fornecida pelo sistema", "e 1 o primeiro dÃ­gito do produto)", "\nDÃ?GITO 2 =>", "12345679 x 63 =>", "7", 
				"(onde 63 foi a chave fornecida pelo sistema", "e 7 o primeiro dÃ­gito do produto)", "\nDÃ?GITO 3 =>", "12345679 x 0 =>", "0", 
				"(onde 0 foi a chave fornecida pelo sistema", "e 0 o primeiro dÃ­gito do produto)","\nDÃ?GITO 4 =>", "12345679 x 9 =>", "1", 
				"(onde 9 foi a chave fornecida pelo sistema", "e 1 o primeiro dÃ­gito do produto)", "\nA senha seria => 1701 .", nome,
				"pode tentar atÃ© acertar.\n"
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	public static String desafio5(String personagem) {
		String senha = "",
			   status = "",
			   senhaInserida = "";
		int digito1 = 0,
			digito2 = 0,
			digito3 = 0,
			digito4 = 0,
			correta = 0,
			tentativas = 0;
		Random variavel = new Random();
		int digitos[] = new int[4];
		//determina que o valor da senha do zelador terÃ¡ que ser entre 1000 e 9999
		senha = String.valueOf(variavel.nextInt((9999 - 1000) + 1) + 1000);
		do {
			//pede a entrada de cada dÃ­gito individualmente
			System.out.println("\nQual a senha para acessar o servidor?\n");
			//gera as chaves da senha baseado na senha gerada automaticamente 
			for(int i = 0; i <= digitos.length-1; i++) {
				digitos[i] = Integer.parseInt(senha.substring(i, (i+1)));
				System.out.println("A chave para o "+(i+1)+"Â° dÃ­gito => "+(digitos[i]*9));
			}
			System.out.println("\n"+personagem+"  _____    _____    _____    _____\n"
			          +" |     |  |     |  |     |  |     |\n"
			          + " |  ?  |  |  ?  |  |  ?  |  |  ?  |\n"
			          + " |_____|  |_____|  |_____|  |_____|\n");
			System.out.print("Entre com o primeiro dÃ­gito: ");
				digito1 = sc.nextInt();
			System.out.print("Entre com o segundo dÃ­gito: ");
				digito2 = sc.nextInt();
			System.out.print("Entre com o terceiro dÃ­gito: ");
				digito3 = sc.nextInt();
			System.out.print("Entre com o quarto dÃ­gito: ");
				digito4 = sc.nextInt();
			
			//transforma a senha em uma String
			senhaInserida = String.valueOf(digito1) + String.valueOf(digito2) + String.valueOf(digito3) + String.valueOf(digito4);
			System.out.println("  _____    _____    _____    _____\n"
			          +" |     |  |     |  |     |  |     |\n"
			          + " |  "+digito1+"  |  |  "+digito2+"  |  |  "+digito3+"  |  |  "+digito4+"  |\n"
			          + " |_____|  |_____|  |_____|  |_____|\n");
			
			//compara a senha gerada no inÃ­cio com a senha inserida pelo usuÃ¡rio
			if(senha.equals(senhaInserida)) {
				System.out.println("Senha correta! Servidor pode ser acessado!");
				correta = 1;
				status = "correta";
			}  else {
				System.out.println("Senha incorreta! NÃ£o foi possÃ­vel conectar ao servidor!\n");
				correta = 0;
				status = "incorreta";
			}
		}while(correta != 1 && tentativas <= 2);
		System.out.println("\t\t\t\t\t\t\tFIM FASE 1\n");
		return status;
	}
	
	//detalha com o usuÃ¡ri se saiu em cada desafio(acerto ou erro)
	public static String feedbackFase1(String array[]) {
		String retorno = "";
		//percorre o array e verifica cada posicao
		for(int i = 0; i <= array.length-1; i++) {
			//checa a correspodencia das posiÃ§Ãµes do arrya com as questÃµes ex: posicao 0 do array == desafio1
			if (i == 0) {
				//verifica se o usuÃ¡rio acertou ou errou o desafio, adicionando a String retorno se foi acerto ou erro
				if(array[i].equals("correta")) {
					retorno += "\t\t\t\t\t\t __________________________\n";
					retorno += "\t\t\t\t\t\t|                          |\n";
					retorno += "\t\t\t\t\t\t| VocÃª acertou o desafio "+(i+1)+" |\n";
				} else {
					retorno += "\t\t\t\t\t\t __________________________\n";
					retorno += "\t\t\t\t\t\t|                          |\n";
					retorno += "\t\t\t\t\t\t| VocÃª errou o desafio "+(i+1)+"   |\n";
				}
			} else if (i == 1) {
				if(array[i].equals("correta")) {
					retorno += "\t\t\t\t\t\t| VocÃª acertou o desafio "+(i+1)+" |\n";
				} else {
					retorno += "\t\t\t\t\t\t| VocÃª errou o desafio "+(i+1)+"   |\n";
				}
			} else if (i == 2) {
				if(array[i].equals("correta")) {
					retorno += "\t\t\t\t\t\t| VocÃª acertou o desafio "+(i+1)+" |\n";
				} else {
					retorno += "\t\t\t\t\t\t| VocÃª errou o desafio "+(i+1)+"   |\n";
				}
			} else if (i == 3) {
				if(array[i].equals("correta")) {
					retorno += "\t\t\t\t\t\t| VocÃª acertou o desafio "+(i+1)+" |\n";
				} else {
					retorno += "\t\t\t\t\t\t| VocÃª errou o desafio "+(i+1)+"   |\n";
				}
			} else if (i == 4) {
				if(array[i].equals("correta")) {
					retorno += "\t\t\t\t\t\t| VocÃª acertou o desafio "+(i+1)+" |\n";
					retorno += "\t\t\t\t\t\t|__________________________|\n";
				} else {
					retorno += "\t\t\t\t\t\t| VocÃª errou o desafio "+(i+1)+"   |\n";
					retorno += "\t\t\t\t\t\t|__________________________|\n";
				}
			}
		}
		//retorna a String retorno, que contÃ©m o feedback geral do usuÃ¡rio dizendo onde errou ou acertou
		return retorno;
	}
	
	//se na funÃ§Ã£o feedbackFase1 o usuÃ¡rio tiver algum erro, essa funÃ§Ã£o Ã© exibida para ele tentar refazer o desafio que foi errado
	public static String[] necessidadeRefazer(String dados[], String nome, char sexo, String visual) {
		String retorno[] = new String[5];
		String retDesafio = "";
		int x = 0;
		for(int i = 0; i <= dados.length-1; i++) {
			//confere se o array tem alguma posiÃ§Ã£o incorreta
			if(dados[i].equals("incorreta")) {
				x++;
			}
		}
		
		if(x != 0) {
			//se existir alguma posiÃ§Ã£o marcada como errada aqui Ã© permitido refaze-la
			System.out.println("\nVocÃª terÃ¡ uma chance de realizar apenas os desafios que vocÃª errou!");
			System.out.println("Se nÃ£o conseguir acertar todos...\n");
			System.out.println("GAME OVER\n");
			for (int i = 0; i <= dados.length-1; i++) {
				if(dados[i].equals("incorreta")) {
					//exibe o desafio que foi errado de acordo com a posiÃ§Ã£o do array
					System.out.println("VocÃª nÃ£o acertou o desafio "+(i+1)+".\nFaÃ§a novamente!");
					if(i == 0) {
						retDesafio = desafio1(nome, sexo, visual);
					} else if(i == 1) {
						retDesafio = desafio2();
					} else if(i == 2) {
						retDesafio = desafio3(visual);
					} else if(i == 3) {
						retDesafio = desafio4(visual);
					} else {
						retDesafio = desafio5(visual);
					}
					retorno[i] = retDesafio;
				} else {
					retorno[i] = dados[i];
				}
			}
		}
		return retorno;
	}
	
	//funÃ§Ã£o que demarca o fim da fase 1
	public static String fimFase1(String dados[]) {
		int x = 0;
		String retorno = "";
		//confere se o array passado contÃ©m alguma resposta incorreta
		for(int i = 0; i <= dados.length-1; i++) {
			if(dados[i].equals("incorreta")) {
				x++;
			}
		}
		
		if(x == 0) {
			//se nÃ£o tem nenhuma incorreta, o personagem vira o melhor hacker de sp
			System.out.println("\n");
			System.out.println("â–ˆâ–ˆâ–ˆâ•—   â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•—     â–ˆâ–ˆâ•—  â–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—     â–ˆâ–ˆâ•—  â–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•—  â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—    â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— \n" + 
							   "â–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•‘     â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—    â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•‘ â–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—    â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?    â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
							   "â–ˆâ–ˆâ•”â–ˆâ–ˆâ–ˆâ–ˆâ•”â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ•‘     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?    â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?    â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—      â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?\n" + 
							   "â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?  â–ˆâ–ˆâ•‘     â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—    â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘     â–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•— â–ˆâ–ˆâ•”â•?â•?â•?  â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—    â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?      â•šâ•?â•?â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•? \n" + 
							   "â–ˆâ–ˆâ•‘ â•šâ•?â•? â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘    â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘    â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—    â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘     \n" + 
							   "â•šâ•?â•?     â•šâ•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?  â•šâ•?â•? â•šâ•?â•?â•?â•?â•?â•? â•šâ•?â•?  â•šâ•?â•?    â•šâ•?â•?  â•šâ•?â•?â•šâ•?â•?  â•šâ•?â•? â•šâ•?â•?â•?â•?â•?â•?â•šâ•?â•?  â•šâ•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?  â•šâ•?â•?    â•šâ•?â•?â•?â•?â•?â•? â•šâ•?â•?â•?â•?â•?â•?â•?    â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?    ");
			//demarca o inÃ­cio da fase 2
			System.out.println("\t\t\t\t\t\t\t\tFASE II");
			retorno = "ok";
		} else {
			//se tiver questÃ£o incorreta no array, determina o fim do jogo
			System.out.println("\t\t\t\t â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ•—   â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•—   â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— \n" + 
							   "\t\t\t\tâ–ˆâ–ˆâ•”â•?â•?â•?â•?â•? â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?    â–ˆâ–ˆâ•”â•?â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
							   "\t\t\t\tâ–ˆâ–ˆâ•‘  â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â–ˆâ–ˆâ–ˆâ–ˆâ•”â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?\n" + 
							   "\t\t\t\tâ–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•”â•?â•?â•?  â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
							   "\t\t\t\tâ•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘ â•šâ•?â•? â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—    â•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â•šâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘\n" + 
							   "\t\t\t\t â•šâ•?â•?â•?â•?â•?â•? â•šâ•?â•?  â•šâ•?â•?â•šâ•?â•?     â•šâ•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?     â•šâ•?â•?â•?â•?â•?â•?   â•šâ•?â•?â•?â•?  â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?  â•šâ•?â•?");
			retorno = "back";
		}
		return retorno;
	}
	/******************************************************************FIM FASE 1****************************************************************/
	
	/******************************************************************INÃ?CIO FASE 2*************************************************************/
	
	public static void historiaInicialFase2(char sexo, String nome) {
		//historia inicial da segunda fase
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				nome, "conseguiu provar", "a toda a comunidade dos hackers", "que ele era o melhor,", "podendo se entitular como:",
				"O MELHOR HACKER DE SÃƒO  PAULO.", "Por ter tamanha capacidade,", artigo, "comeÃ§ou a ser", "invejado por outros", 
				"hackers.", "Na tentativa de", "se tornar melhor que ele", "um grupo de hackers se uniu,", "porÃ©m, esse grupo",
				"nÃ£o fazia coisas", "que nÃ£o faziam mal a ninguÃ©m", "como", nome, "fazia.", "O grupo realizava", "aÃ§Ãµes que eram",
				"prejudiciais a comunidade", "como roubo de informaÃ§Ãµes", "e atÃ© mesmo em casos extremos,", "roubo de bitcoins,",
				"moeda valiosa no mundo dos hackers.", "Esses delitos comeÃ§aram a", "ser mais frequentes", "e a polÃ­cia", "precisou intervir.",
				"A equipe de defesa cibernÃ©tica", "da polÃ­cia, foi chamada", " e tentou de diversas maneiras", "impedir este grupo,", "porÃ©m as tentativas foram",
				"todas por Ã¡gua abaixo.", "E a cada embate com a polÃ­cia,","que eles venciam,","o grupo de hackers", "se tornava cada vez mais forte.",
				"Com a forÃ§a do grupo aumentando,", "e a forÃ§a da polÃ­cia para", "combatÃª-los cada", "vez mais fraca,","o grupo se prepara",
				"para o ataque de maior", "intensidade:","ATACAR TODA A BASE DE DADOS", "DO FACEBOOK.", "Uma vez dentro da base", "o grupo teria acesso",
				"a informaÃ§Ãµes pessoais de 500 milhÃµes de usuÃ¡rios", "e conseguiria vender tudo na", "deep web, recebendo muito dinheiro", "com a venda.",
				"A polÃ­cia comeÃ§ou a suspeitar", "sobre um ataque maior,", "devido o crescimento", "na dificuldade dos Ãºltimos desafios.",
				"Pensando nisso,", "a polÃ­cia sabendo que", "nÃ£o tinha forÃ§as para combater o","grupo, decide procurar", "um hacker bom para combatÃª-los.",
				"ApÃ³s procurar muito", "a polÃ­cia achou", nome, "que era cohecido", "como o melhor hacker de SÃ£o Paulo,", "se encaixando", 
				"perfeitamente no que a polÃ­cia", "procurava.", "A polÃ­cia", "fez a proposta e", nome, "aceitou, agora o melhor hacker fazia",
				"parte da equipe da polÃ­cia."
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	public static void historiaDesafio1Fase2(char sexo, String nome) {
		//historia do desafio 1 fase 2
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				"Chegou o dia em que", "o grupo de hackers", "iam realizar entrada nos servidores", "do Facebook, para o roubo", "das informaÃ§Ãµes.",
				nome, "estava acompanhando", "as movimentaÃ§Ãµes", "do servidor do Facebook pois,", "ele havia sido contratado", "para realizar este monitoramento.",
				"O grupo iniciou o ataque", "a estratÃ©gia do grupo era simples", "entrar no servidor", "pegar as senhas que estavam", "criptografadas",
				"e roubar as informaÃ§Ãµes.", "PorÃ©m eles nÃ£o", "contavam que a polÃ­cia", "havia se reforÃ§ado", "e estava preparada.", nome, "sabia",
				"qual seria o plano de aÃ§Ã£o", "do grupo de hackers,", "pois jÃ¡ tinha hackeado um servidor parecido antes.", "Por estar sozinho,", nome,
				"teve que estudar como se defender,", "ele sabia que o grupo estava preparado fortemente.", "Para se defender",artigo ,"precisava descobrir",
				"qual era essa criptografia.", nome, "comeÃ§ou a observar","e percebeu que por padrÃ£o", "a senha era composta por 8 dÃ­gitos numÃ©ricos", 
				"e no servidor esta senha era criptgrafada", "da seguinte maneira:", "SENHA DO USUÃ?RIO => 12345678 .", "SENHA NO SERVIDOR => ABCDEFGH .",
				nome, "tem 2 tentativas para acertar."
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	public static String desafio1Fase2() {
		int correta = 0;
		int cont = 1;
		String status = "";
		char resposta = 0;
		ArrayList<String> alternativas = new ArrayList<String>();
		//adicionando as alternativas ao arraylist
		alternativas.add("NÃºmero => Caractere correspondente");
		alternativas.add("Caractere correspondente => NÃºmero");
		alternativas.add("NÃºmero => Hexadecimal");
		alternativas.add("NÃºmero => Caractere sortido");
		
		 do {
			System.out.println("\nQual a criptografia?");
			//troca as alternativas de posiÃ§Ã£o
			Collections.shuffle(alternativas);
			//exibe todas as alternatias do arraylist 
			for(int i = 0; i <= alternativas.size()-1; i++) {
				switch (i) {
					case 0:
						System.out.println("a) "+alternativas.get(i));
						break;
					case 1:
						System.out.println("b) "+alternativas.get(i));
						break;
					case 2:
						System.out.println("c) "+alternativas.get(i));
						break;
					case 3:
						System.out.println("d) "+alternativas.get(i));
						break;
				}
			}
				resposta = sc.next().toUpperCase().charAt(0);
			//observa se a resposta inputada pelo usuÃ¡rio estÃ¡ correta
				switch(resposta) {
				case 'A':
					if (alternativas.get(0).equals("NÃºmero => Caractere correspondente")) {
						System.out.println("Criptografia correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Criptografa incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
				case 'B':
					if (alternativas.get(1).equals("NÃºmero => Caractere correspondente")) {
						System.out.println("Criptografia correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Criptografa incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
				case 'C':
					if (alternativas.get(2).equals("NÃºmero => Caractere correspondente")) {
						System.out.println("Criptografia correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Criptografa incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
				case 'D':
					if (alternativas.get(3).equals("NÃºmero => Caractere correspondente")) {
						System.out.println("Criptografia correta!");
						correta = 1;
						status = "correta";
					} else {
						System.out.println("Criptografa incorreta!");
						correta = 0;
						status = "incorreta";
					}
					break;
			}
				cont++;
				//este laÃ§o tem sua execuÃ§Ã£o interrompida apÃ³s a realizaÃ§Ã£o das duas tentativas ou respota correta
		} while (correta != 1 && cont <= 2);
		 return status;
	}
	
	static void historiaDesafio2Fase2(char sexo, String nome) {
		//historia do desafio 4
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				"ApÃ³s descobrir", "como funcionava o", "sistema de criptografia do servidor,", nome, "precisava mudar esta criptografia.",
				"Por que", artigo, "tinha que fazer isso?", "Por jÃ¡ ter hackeado um servidor similar", artigo, "sabia que o grupo que estava",
				"enfrentando nÃ£o estava", "preparado para outro", "modelo de criptografia.", "Com isso para obter Ãªxito", "na disputa,",
				"mudar era sua Ãºltima opÃ§Ã£o.", nome, "resolveu inverter a criptografia, ficando desta maneira:", 
				"Critografia Invertida => SENHA DO USUÃ?RIO = ABCDEFGH |", "SENHA DO SERVIDOR = 12345678 ."
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":") || historia[i].contains("?")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	static String desafio2Fase2(String nome) {
		Random sort = new Random();
		String status = "";
		String senhaCripto1[][] = new String[3][2];
		int posicao = 0,
			resposta = 0,
			x = 0;
		
		//adiciona em uma matriz a senha e a senha criptografada
		senhaCripto1[0][0] = "ABCDFHG";
		senhaCripto1[0][1] = "1234687";
		senhaCripto1[1][0] = "BCAFDGH";
		senhaCripto1[1][1] = "2316478";
		senhaCripto1[2][0] = "BAHCFDG";
		senhaCripto1[2][1] = "2183647";
		
		//sorteia uma posicao da matriza
		posicao = sort.nextInt(3);
		
			System.out.println("\n");
			System.out.println("Ele implantou as mudanÃ§as no servidor e agora sÃ³ restava fazer um teste para ver se tudo tinha sido realizado de forma correta.");
			System.out.println("O teste consistia em pegar o seu prÃ³prio usuÃ¡rio e olhar a senha que estava no servidor, ele teria que fazer as conversÃµes"
								+ "\nmanualmente para ter certeza que a criptografia havia sido realizada com sucesso.");
			System.out.println("\n\nA senha do usuÃ¡rio Ã©: "+senhaCripto1[posicao][0]+" a senha no servidor Ã©: "+senhaCripto1[posicao][1]);
			//confere se o usuÃ¡rio colocou uma resposta vÃ¡lida
			do {
				
				System.out.println("A criptografa foi realizada de maneira correta? \n1 - Sim \n2 - NÃ£o");
				resposta = sc.nextInt();
				if(resposta == 1 || resposta == 2) {
					x = 1;
				} else {
					System.out.println("Valor inserido nÃ£o existe!");
				}
				//laÃ§o sÃ³ sai quando a opÃ§Ã£o inserida Ã© vÃ¡lida, 1 ou 2 
			}while(x != 1);
			//confere se a resposta inserida pelo usuÃ¡rio Ã© correta ou nÃ£o
			if(resposta == 1) {
				status = "correta";
			} else {
				status = "incorreta";
			}
			
		 return status;
	}
	
	static void historiaInicialFase3(String nome) {
		//historia do desafio 4
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				"As mudanÃ§as que", nome, "fez surtiram efeito e", "o grupo de hackers nÃ£o conseguiu", "roubar as informaÃ§Ãµes dos usuÃ¡rios do Facebook.",
				"Isso irritou muito", "o grupo", "pois, eles queriam", "muito o dinheiro que a venda das informaÃ§Ãµes trariam.", "Com toda esta irritaÃ§Ã£o causada",
				"o grupo arquitetou outro ataque,", "porÃ©m desta vez", nome, "nÃ£o conseguiu se preparar previamente."
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":") || historia[i].contains("?")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	static void historiaDesafioFase3(char sexo, String nome) {
		//historia do desafio 4
		String artigo = "";
		//define o a partir do sexo do personagem o artigo da frase
		if(sexo == 'M') {
			artigo = "ele";
		} else {
			artigo = "ela";
		}
		System.out.println("\n");
		//utiliza o nome e o artigo para escrever a histÃ³ria
		String historia[] = 
			{
				"O ataque foi muito bem orquestrado pelo grupo", "e uma parte importante do plano", "era pegar", nome, "despreparado.",
				"O ataque consistia em", "entrar em confronto", "com", nome, "no acesso ao servidor", "pois, se vencessem", nome, "logo na entrada",
				"nÃ£o teriam que enfrentar", artigo, "no resto da aÃ§Ã£o.", "Chegou o dia que o grupo de hackers", "havia se programado", "para",
				"atacar.", "Se", nome, "for derrotado perderÃ¡ tudo e o grupo de hackers", "dominarÃ¡ as informaÃ§Ãµes e", "a venda deles serÃ¡ concretizada.",
				"Ã‰ tudo ou nada para", nome
			};
		//exibiÃ§Ã£o com delay de 5 segundos
		for (int i = 0; i <= historia.length-1; i++) {
			if(historia[i].contains(".") || historia[i].contains(":") || historia[i].contains("?")) {
				System.out.print(historia[i]+"\n");
			} else {
				System.out.print(historia[i]+" ");
			}
			try {
				Thread.sleep(500);
			} catch(InterruptedException e) {
				System.out.println(e);
			}
		}
	}
	
	static String desafioFase3(String nome) {
		Random sort = new Random();
		String status = "";
		int user = 0, //p1
			acessoServidor = 0, // r
			grupoHacker = 0,
			x = 0; // cp
		
		//cria explicaÃ§Ã£o da corrida ao 20
		System.out.println("\n");
		System.out.println("Para conseguir o controle do servidor o grupo vai enfrentar um desafio contra "+nome);
		System.out.println("O desafio consiste em uma escolha simples:");
		System.out.println("Escolha entre 1 ou 2.");
		System.out.println("Se "+nome+" chegar ao 20 primeiro ele vence e impede o ataque");
		System.out.println("Se o grupo chegar primeiro ao 20, "+nome+" perde tudo e o grupo consegue todas as informaÃ§Ãµes.");
		System.out.println("\n");
		System.out.println("O embate comeÃ§a agora!");
		System.out.println("Escolha entre 1 ou 2. Quem chegar ao 20 primeiro ganha!");
		do {
			x = 0;
			//define que a jogada do hacker sÃ³ pode ser 1 ou 2
			grupoHacker = sort.nextInt(2)+1;
			
			//confere se o personagem entrou com 1 ou 2, qualquer coisa diferente disso Ã© invÃ¡lida
			while(x != 1) {
				System.out.println("\n");
				System.out.print("Entre com 1 ou 2: ");
				user = sc.nextInt();
				if(user == 1 || user == 2) {
					x = 1;
				} else {
					System.out.println("Valor inserido nÃ£o existe!");
				}
			}
			
			//observa qual nÃºmero foi escolhido pelo personagem
			switch(user) {
				case 1 :
					//incrementa ao total que no fim tem que ser 20
					acessoServidor += user;
					System.out.println("\n");
					System.out.println("JOGADA DO "+nome+" => "+user);
					System.out.println(" ________________________________________________ ");
					System.out.println("|                                                |");
					System.out.println("| A SOMA PARA ACESSAR O SERVIDO ESTÃ? EM => "+acessoServidor+"     |");
					System.out.println("|________________________________________________|");
					//confere se jÃ¡ chegou no 20
					if(acessoServidor >= 20) {
						System.out.println("\n");
						System.out.println(nome+" VENCEU!");
						System.out.println("O ataque foi parado. Tudo se resolveu.");
						status = "venceu";
						break;
					}
					System.out.println("\n");
					System.out.println("JOGADA DO GRUPO DE HACKERS => "+grupoHacker);
					acessoServidor += grupoHacker;
					System.out.println(" ________________________________________________ ");
					System.out.println("|                                                |");
					System.out.println("| A SOMA PARA ACESSAR O SERVIDO ESTÃ? EM => "+acessoServidor+"     |");
					System.out.println("|________________________________________________|");
					
					if(acessoServidor >= 20) {
						System.out.println("\n");
						System.out.println("O GRUPO DE HACKERS VENCEU!");
						System.out.println("O grupo conquistou seu objetivo, entrou nos servidores pegou as informaÃ§Ãµes e as vendeu no Mercado Negro.");
						status = "perdeu";
						break;
					}
					break;
				case 2:
					acessoServidor += user;
					System.out.println("\n");
					System.out.println("JOGADA DO "+nome+" => "+user);
					System.out.println(" ________________________________________________ ");
					System.out.println("|                                                |");
					System.out.println("| A SOMA PARA ACESSAR O SERVIDO ESTÃ? EM => "+acessoServidor+"     |");
					System.out.println("|________________________________________________|");
					if(acessoServidor >= 20) {
						System.out.println("\n");
						System.out.println(nome+" VENCEU!");
						System.out.println("O ataque foi parado. Tudo se resolveu.");
						status = "venceu";
						break;
					}
					System.out.println("\n");
					System.out.println("JOGADA DO GRUPO DE HACKERS => "+grupoHacker);
					acessoServidor += grupoHacker;
					System.out.println(" ________________________________________________ ");
					System.out.println("|                                                |");
					System.out.println("| A SOMA PARA ACESSAR O SERVIDO ESTÃ? EM => "+acessoServidor+"     |");
					System.out.println("|________________________________________________|");
					
					if(acessoServidor >= 20) {
						System.out.println("\n");
						System.out.println("O GRUPO DE HACKERS VENCEU!");
						status = "perdeu";
						break;
					}
					break;
			}
			
			//sÃ³ para de ser exibidoo quando o o acesso ao servidor for igual a 20
		} while(acessoServidor < 20);
		return status;
	}
	
	
	public static void main(String[] args) {
		//utilizamos a main como um maestro, apenas chamando as funÃ§Ãµes
		int idadePersonagem = 0,
			correta = 0,
			tentativaFase1 = 1,
			tentativaDesafio12 = 1,
			tentativaDesafio22 = 1,
			tentativaJogo = 1;
		char sexoPersonagem;
		String nomePersonagem = "",
			   condicaoInicioJogo = "",
			   visualPersonagem = "",
			   desafio1 = "",
			   desafio2 = "",
			   desafio3 = "",
			   desafio4 = "",
			   desafio5 = "",
			   resultadoDesafio1 = "",
			   desafio1Fase2 = "",
			   fimfase = "",
			   recomeco = "",
			   recomecoD12 = "",
			   desafio2Fase2 = "",
			   desafioFase3 = "";
		String informacoesPersonagem[] = new String[3];
		String statusDesafiosFase1[] = new String[5];
		String statusRefeito[] = new String[5];
		
		participacaoJogo();
		informacoesPersonagem = definiPersonagem();
		
		sexoPersonagem = informacoesPersonagem[0].charAt(0);
		nomePersonagem = informacoesPersonagem[1].substring(0, 1).toUpperCase().concat(informacoesPersonagem[1].substring(1).toLowerCase());
		idadePersonagem = Integer.parseInt(informacoesPersonagem[2]);
		
		condicaoInicioJogo = confereInformacoes(informacoesPersonagem);
		visualPersonagem = selecionaBoneco(sexoPersonagem);
		System.out.println("\n"+nomePersonagem +" seu personagem para participar do jogo serÃ¡: \n\n"+visualPersonagem);
		carregarInicio(condicaoInicioJogo);
			
		//comeÃ§a a fase 1
		do {
			if(tentativaFase1 > 1) {
				System.out.println("\n\nDESEJA RECOMEÃ‡AR O JOGO? (S/N)");
				recomeco = sc.next().toLowerCase();
				if(recomeco.contains("s")) {
					System.out.println("\nO JOGO VAI RECOMEÃ‡AR...");
					correta = 0;
					statusDesafiosFase1[0] = "";
					statusDesafiosFase1[1] = "";
					statusDesafiosFase1[2] = "";
					statusDesafiosFase1[3] = "";
					statusDesafiosFase1[4] = "";
				} else {
					System.exit(0);
				}
			}
			historiaInicial(nomePersonagem, idadePersonagem, sexoPersonagem);
			desafio1 = desafio1(nomePersonagem, sexoPersonagem, visualPersonagem);
			historiaDesafio2(nomePersonagem, sexoPersonagem);
			desafio2 = desafio2();
			historiaDesafio3(sexoPersonagem, nomePersonagem);
			desafio3 = desafio3(visualPersonagem);
			historiaDesafio4(sexoPersonagem, nomePersonagem);
			desafio4 = desafio4(visualPersonagem);
			historiaDesafio5(sexoPersonagem, nomePersonagem);
			desafio5 = desafio5(visualPersonagem);
			
			//armazena dentro do array se o usuÃ¡rio acertou ou errou os desafios, esse array serÃ¡ utilizado para fazer o feedback da primeira fase
			statusDesafiosFase1[0] = desafio1;
			statusDesafiosFase1[1] = desafio2;
			statusDesafiosFase1[2] = desafio3;
			statusDesafiosFase1[3] = desafio4;
			statusDesafiosFase1[4] = desafio5;
			
			resultadoDesafio1 = feedbackFase1(statusDesafiosFase1);
			System.out.println(resultadoDesafio1);
			statusRefeito = necessidadeRefazer(statusDesafiosFase1, nomePersonagem, sexoPersonagem, visualPersonagem);
			
			for(int i = 0; i <= statusDesafiosFase1.length-1; i++) {
				if(statusDesafiosFase1[i].equals("incorreta")) {
					//confere se o usuÃ¡rio acertou ou nÃ£o todos os desafios
					correta++;
				}
			}
			if(correta > 0) {
				//se ele nÃ£o acertou todas, passamos o array que retornou da funÃ§Ã£o necessidadeRefazer
				fimfase = fimFase1(statusRefeito);
			} else {
				//se ele acertou todas as questÃµes, passamos o array original statusDesafiosFase1
				fimfase = fimFase1(statusDesafiosFase1);
			}
			tentativaFase1++;
		} while(fimfase != "ok");
			//termina a fase 1
		//laÃ§o de recomeÃ§o caso o usuÃ¡rio nÃ£o ganhe o desafio final
		do {
			if(tentativaJogo > 1) {
				tentativaDesafio12 = 1;
			}
			//comeÃ§a a fase 2
			do {
				//testa se jÃ¡ foi realizado mais de uma vez o desafio
				if(tentativaDesafio12 > 1) {
					System.out.println("VocÃª nÃ£o acertou o desafio 1 da fase 2!");
					System.out.println("O jogo vai ser reiniciado na fase 2!");
					//confere se o usuÃ¡rio quer recomeÃ§ar
					System.out.println("\nDESEJA RECOMEÃ‡AR? (S/N)");
					recomecoD12 = sc.next().toLowerCase();
					if(recomecoD12.contains("s")) {
						System.out.println("\nREINICIANDO FASE...");
					} else {
						System.exit(0);
					}
				}
				//executa o primeiro desafio da segunda fase
				historiaInicialFase2(sexoPersonagem, nomePersonagem);
				historiaDesafio1Fase2(sexoPersonagem, nomePersonagem);
				desafio1Fase2 = desafio1Fase2();
				if(desafio1Fase2 != "correta") {
					System.out.println("\n");
					System.out.println("\t\t\t\t â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ•—   â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•—   â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— \n" + 
									   "\t\t\t\tâ–ˆâ–ˆâ•”â•?â•?â•?â•?â•? â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?    â–ˆâ–ˆâ•”â•?â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
									   "\t\t\t\tâ–ˆâ–ˆâ•‘  â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â–ˆâ–ˆâ–ˆâ–ˆâ•”â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?\n" + 
									   "\t\t\t\tâ–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•”â•?â•?â•?  â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
									   "\t\t\t\tâ•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘ â•šâ•?â•? â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—    â•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â•šâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘\n" + 
									   "\t\t\t\t â•šâ•?â•?â•?â•?â•?â•? â•šâ•?â•?  â•šâ•?â•?â•šâ•?â•?     â•šâ•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?     â•šâ•?â•?â•?â•?â•?â•?   â•šâ•?â•?â•?â•?  â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?  â•šâ•?â•?");
				}
				tentativaDesafio12++;
			} while(desafio1Fase2 != "correta");
			
			do {
				//confere a quantidade de vezes que jÃ¡ foi jogado o desafio
				if(tentativaDesafio22 > 1) {
					System.out.println("VocÃª nÃ£o acertou o desafio 2 da fase 2!");
					System.out.println("O jogo vai ser reiniciado no desafio 2 da fase 2!");
					//ver se a pessoa quer refazer a fase 
					System.out.println("\nDESEJA RECOMEÃ‡AR? (S/N)");
					recomecoD12 = sc.next().toLowerCase();
					if(recomecoD12.contains("s")) {
						System.out.println("\nREINICIANDO FASE...");
					} else {
						System.exit(0);
					}
				}
				//executa o segundo desafio da segunda fase
				historiaDesafio2Fase2(sexoPersonagem, nomePersonagem);
				desafio2Fase2 = desafio2Fase2(nomePersonagem);
				if(desafio2Fase2 != "correta") {
					System.out.println("\n");
					System.out.println("\t\t\t\t â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ•—   â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•—   â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— \n" + 
									   "\t\t\t\tâ–ˆâ–ˆâ•”â•?â•?â•?â•?â•? â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?    â–ˆâ–ˆâ•”â•?â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
									   "\t\t\t\tâ–ˆâ–ˆâ•‘  â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â–ˆâ–ˆâ–ˆâ–ˆâ•”â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?\n" + 
									   "\t\t\t\tâ–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•”â•?â•?â•?  â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
									   "\t\t\t\tâ•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘ â•šâ•?â•? â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—    â•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â•šâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘\n" + 
									   "\t\t\t\t â•šâ•?â•?â•?â•?â•?â•? â•šâ•?â•?  â•šâ•?â•?â•šâ•?â•?     â•šâ•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?     â•šâ•?â•?â•?â•?â•?â•?   â•šâ•?â•?â•?â•?  â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?  â•šâ•?â•?");
				}
				tentativaDesafio22++;
			} while(desafio2Fase2 != "correta");
			tentativaDesafio22 = 1;
			//termina a fase 2
			//comeÃ§a a fase 3
			System.out.println("\n\t\t\t\t\t\t\tFASE III");
			historiaInicialFase3(nomePersonagem);
			historiaDesafioFase3(sexoPersonagem, nomePersonagem);
			desafioFase3 = desafioFase3(nomePersonagem);
			
			if(desafioFase3 == "venceu") {
				System.out.println("\n");
				System.out.println("\t\t\t\tâ–ˆâ–ˆâ•—    â–ˆâ–ˆâ•—â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ•—   â–ˆâ–ˆâ•—     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ•—   â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—\n" + 
								    "\t\t\t\tâ–ˆâ–ˆâ•‘    â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ•‘    â–ˆâ–ˆâ•”â•?â•?â•?â•?â•? â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?\n" + 
								    "\t\t\t\tâ–ˆâ–ˆâ•‘ â–ˆâ•— â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â–ˆâ–ˆâ•— â–ˆâ–ˆâ•‘    â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â–ˆâ–ˆâ–ˆâ–ˆâ•”â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  \n" + 
								    "\t\t\t\tâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘    â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?  \n" + 
								    "\t\t\t\tâ•šâ–ˆâ–ˆâ–ˆâ•”â–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘ â•šâ–ˆâ–ˆâ–ˆâ–ˆâ•‘    â•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘ â•šâ•?â•? â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—\n" + 
								    "\t\t\t\t â•šâ•?â•?â•?â•šâ•?â•?â•? â•šâ•?â•?â•šâ•?â•?  â•šâ•?â•?â•?â•?     â•šâ•?â•?â•?â•?â•?â•? â•šâ•?â•?  â•šâ•?â•?â•šâ•?â•?     â•šâ•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?");
				System.exit(0);
			} else {
				System.out.println("\n");
				System.out.println("\t\t\t\t â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ•—   â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—     â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•—   â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•— \n" + 
								   "\t\t\t\tâ–ˆâ–ˆâ•”â•?â•?â•?â•?â•? â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ•— â–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?    â–ˆâ–ˆâ•”â•?â•?â•?â–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?â•?â•?â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
								   "\t\t\t\tâ–ˆâ–ˆâ•‘  â–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â–ˆâ–ˆâ–ˆâ–ˆâ•”â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—  â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?\n" + 
								   "\t\t\t\tâ–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•”â•?â•?â•?      â–ˆâ–ˆâ•‘   â–ˆâ–ˆâ•‘â•šâ–ˆâ–ˆâ•— â–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•”â•?â•?â•?  â–ˆâ–ˆâ•”â•?â•?â–ˆâ–ˆâ•—\n" + 
								   "\t\t\t\tâ•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•?â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘â–ˆâ–ˆâ•‘ â•šâ•?â•? â–ˆâ–ˆâ•‘â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—    â•šâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â•šâ–ˆâ–ˆâ–ˆâ–ˆâ•”â•? â–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ–ˆâ•—â–ˆâ–ˆâ•‘  â–ˆâ–ˆâ•‘\n" + 
								   "\t\t\t\t â•šâ•?â•?â•?â•?â•?â•? â•šâ•?â•?  â•šâ•?â•?â•šâ•?â•?     â•šâ•?â•?â•šâ•?â•?â•?â•?â•?â•?â•?     â•šâ•?â•?â•?â•?â•?â•?   â•šâ•?â•?â•?â•?  â•šâ•?â•?â•?â•?â•?â•?â•?â•šâ•?â•?  â•šâ•?â•?");
				System.out.println("VocÃª nÃ£o conseguiu vencer o desafio final.");
				System.out.println("Parece que vocÃª precis de mais uma chance para vencer o grupo de hackers.");
				System.out.println("O jogo serÃ¡ reiniciado da segunda fase.");
				System.out.println("Mostre seu valor e venÃ§a os desafios!");
				System.out.println("O jogo reinicia agora...");
			}
			//laÃ§o sÃ³ deixa de ser exibido se o usuÃ¡rio ganhar o desafio final
		}while(desafioFase3 != "venceu");
		//quando o usuÃ¡rio acerta o desafio final, termina a execuÃ§Ã£o do jogo
		System.exit(0);
	}
}