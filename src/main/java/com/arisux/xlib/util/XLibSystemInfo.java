package com.arisux.xlib.util;

import org.apache.commons.lang3.SystemUtils;
import org.lwjgl.opengl.GL11;

public class XLibSystemInfo
{
    public static String gpu()
    {
        return GL11.glGetString(GL11.GL_RENDERER);
    }

    public static String gpuVendor()
    {
        return GL11.glGetString(GL11.GL_VENDOR);
    }

    public static String cpu()
    {
        return System.getenv("processor.identifier");
    }

    public static int cpuCores()
    {
        return Runtime.getRuntime().availableProcessors();
    }

    public static String javaVersion()
    {
        return SystemUtils.JAVA_VERSION;
    }

    public static String osName()
    {
        return System.getProperty("os.name");
    }

    public static String osVersion()
    {
        return System.getProperty("os.version");
    }

    public static String osArchitecture()
    {
        return System.getProperty("os.arch");
    }

    public static long vmMemoryTotalBytes()
    {
        return Runtime.getRuntime().totalMemory();
    }

    public static long vmMemoryMaxBytes()
    {
        return Runtime.getRuntime().maxMemory();
    }

    public static long vmMemoryFreeBytes()
    {
        return Runtime.getRuntime().freeMemory();
    }
}
