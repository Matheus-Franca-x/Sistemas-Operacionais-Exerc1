package controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	
	public RedesController() 
	{
		super();
	}
	
	private String OS()
	{
		String os = System.getProperty("os.name");
		String arch = System.getProperty("os.arch");
		String version = System.getProperty("os.version");
		
		return os + " - v. " + version + " - arch. " + arch;
	}
	
	public void callOS()
	{
		System.out.println(OS());
	}
	
	public void IP()
	{
		String process = null;
		if(OS().contains("Windows"))
		{
			process = "ipconfig";
		}
		else if(OS().contains("Linux"))
		{
			process = "ifconfig";
		}
		
		readProcess(process);
		
	}
	
	public void ping()
	{
		String process = null;
		if(OS().contains("Windows"))
		{
			process = "ping -4 -n 10 www.google.com.br";
		}
		else if(OS().contains("Linux"))
		{			
			process = "ping -4 -c 10 www.google.com.br";
		}
		
		readProcess(process);
		
	}
	
	
	public void readProcess(String process)
	{
		try {
				Process p = Runtime.getRuntime().exec(process);
				InputStream fluxo = p.getInputStream();
				InputStreamReader leitor = new InputStreamReader(fluxo);
				BufferedReader buffer = new BufferedReader(leitor);
				String linha = buffer.readLine();
				while (linha != null)
				{
					if(process == "ipconfig" || process == "ifconfig")
					{
						if (linha.contains("Adaptador") || linha.contains("IPv4") || linha.contains("Ethernet adapter") || linha.contains("IPv4") || linha.contains("mtu") || linha.contains("inet "))
						{
							System.out.println(linha);
						}
						linha = buffer.readLine();
					}
					else if(process.contains("ping"))
					{
						if(linha.contains("ms"))
						{
							System.out.println(linha);
						}
						linha = buffer.readLine();
					}
					else
					{
						System.out.println(linha);
						linha = buffer.readLine();
					}
				}
				buffer.close();
				leitor.close();
				fluxo.close();
			
			} catch (Exception e) {
			String msgErro = e.getMessage();
			System.out.println(msgErro);
		}
	}
}
