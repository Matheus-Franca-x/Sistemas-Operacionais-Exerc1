package view;

import controller.RedesController;

public class Main 
{
	public static void main(String[] args)
	{
		RedesController redeControll = new RedesController();
		String os = redeControll.callOS();
		
		System.out.println(os);
		

		
//		String process = "ipconfig";
//		redeControll.readProcess(process);
	}
}
