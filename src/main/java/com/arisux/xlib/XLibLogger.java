package com.arisux.xlib;

public class XLibLogger
{
	private static XLibLogger instance = new XLibLogger();
	
	public void info(String info, Object... args)
	{
		System.out.println(String.format("[XLib/INFO] %s", String.format(info, args)));
	}

	public void bug(String info, Object... args)
	{
		System.out.println(String.format("[XLib/BUG] %s. This should not happen.", String.format(info, args)));
	}

	public void warning(String warning, Object... args)
	{
		System.out.println(String.format("[XLib/WARNING] %s", String.format(warning, args)));
	}

	public static XLibLogger instance()
	{
		return instance;
	}
}