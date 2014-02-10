package teste;

import java.io.File;

public class EncontrDir {
	
	public static void main(String[] args) {
		System.out.println(retornaDiretorio("IPSEC_VPN"));
		System.out.println(getCaminho("IPSEC_VPN"));
		System.out.println(getBasePath());
	}

	private static File retornaDiretorio(String diretorio) {

		File dir = null;
		File[] root;

		try {
			// Retorna um array de nós primários do SO
			root = File.listRoots();
			

			for (int i = 0; i < root.length; i++) {
				/*
				 * Esse teste é para o drive de disquete, pois quando ele tenta
				 * acessar o drive de disquete e que não existe nenhum disquete
				 * la dentro, então ele pede para: "Continuar",
				 * "Tentar Novamente" ou "Cancelar" ( no Windows é assim ). Alem
				 * de ser altamente inviável para o usuário que apareça essa
				 * mensagem, caso o mesmo clique em "Cancelar" então o programa
				 * é abortado, o que não é nem um pouco conveniente! Esse teste
				 * abaixo elimina isso ( pelo menos no Windows )!
				 */
				System.out.println(root[i].toString());
				if (root[i].toString().equalsIgnoreCase("C:/Program Files/VPN")) {
					continue;
				}
				// Testa se tem permissão de escrita

				if (root[i].canWrite()) {
					dir = new File(root[i] + diretorio);

					if (dir.exists()) {
						return dir;
					} else {
						dir = null;
					}
				}

			}

		} catch (Exception e) {
			System.out.println("Mensagem Default" + e.toString());
		}

		return dir;
	}
	 public static String getCaminho(String arquivo) { 
     File f = new File(arquivo); 
     //f.
     return f.getAbsolutePath(); 
     } 
	 public static String getBasePath() {  
	        return EncontrDir.class.getClassLoader().getResource(".").getFile();  
	    }  
}
