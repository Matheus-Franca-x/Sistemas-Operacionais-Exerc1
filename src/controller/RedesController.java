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
	
	public String callOS()
	{
		return OS();
	}
	
	public void IP()
	{
//		String os = OS();
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
		
	}
	
	public void callProcess(String process) 
	{
		try
		{
			Runtime.getRuntime().exec(process);
		} catch(Exception e) {
			String msgErro = e.getMessage();
			if(msgErro.contains("740"))
			{
				StringBuffer buffer = new StringBuffer();
				buffer.append("cmd /c");
				buffer.append(" ");
				buffer.append(process);
				try {
					Runtime.getRuntime().exec(buffer.toString());
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			else 
			{
				System.err.println(msgErro);
			}
		}
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
				if (OS().contains("Windows"))
				{
					if (linha.contains("Adaptador") || linha.contains("IPv4") || linha.contains("Ethernet") || linha.contains("IPv4") || linha.contains("mtu") || linha.contains("inet "))
					{
						System.out.println(linha);
					}
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
