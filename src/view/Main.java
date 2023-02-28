package view;

import javax.swing.JOptionPane;

import controller.RedesController;

public class Main 
{
	public static void main(String[] args)
	{
		RedesController redeControll = new RedesController();
		
		int opcao = -1;
		
		while(opcao != 9)
		{
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" 1 - Sistema Operacional. \n 2 - IPconfig. \n 3 - Ping google. \n 9 - Fechar programa."));

			switch(opcao)
			{
			case 1:
				redeControll.callOS();
				break;
			case 2:
				redeControll.IP();
				break;
			case 3:
				redeControll.ping();
				break;
			case 9:
				JOptionPane.showMessageDialog(null, "Obrigado por utilizar o nosso programa.");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcao invalida.");
			}
		}
	}
}
