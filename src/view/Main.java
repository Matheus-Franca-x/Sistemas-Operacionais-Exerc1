package view;

import controller.RedesController;

public class Main 
{
	public static void main(String[] args)
	{
		RedesController redeControll = new RedesController();
//		String os = redeControll.callOS();
		
//		System.out.println(os);
		
		redeControll.IP();
		
		String process = "ping google.com.br";
		redeControll.readProcess(process);
	}
	
}
