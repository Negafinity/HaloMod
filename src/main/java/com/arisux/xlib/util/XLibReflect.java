package com.arisux.xlib.util;

import java.lang.reflect.Field;

import com.arisux.xlib.XLib;

public class XLibReflect
{
    public static double getDouble(Object obj, String deobfName, String obfName)
    {
        return ((Double) get(obj, deobfName, obfName)).doubleValue();
    }

    public static float getFloat(Object obj, String deobfName, String obfName)
    {
        return ((Float) get(obj, deobfName, obfName)).floatValue();
    }

    public static int getInt(Object obj, String deobfName, String obfName)
    {
        return ((Integer) get(obj, deobfName, obfName)).intValue();
    }

    public static boolean getBoolean(Object obj, String deobfName, String obfName)
    {
        return ((Boolean) get(obj, deobfName, obfName)).booleanValue();
    }

    public static long getLong(Object obj, String deobfName, String obfName)
    {
        return ((Long) get(obj, deobfName, obfName)).longValue();
    }

    public static byte getByte(Object obj, String deobfName, String obfName)
    {
        return ((Byte) get(obj, deobfName, obfName)).byteValue();
    }

    public static String getString(Object obj, String deobfName, String obfName)
    {
        return (String) get(obj, deobfName, obfName);
    }

    public static void set(Object obj, String deobfName, String obfName, Object value)
    {
        String fieldName = XLib.isDevEnvironment() ? deobfName : obfName;

        try
        {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        }
        catch (Exception e)
        {
        	XLib.logger().warning("Failed setting field %s to %s: %s", fieldName, value, e);
        }
    }

    public static Object get(Object obj, String deobfName, String obfName)
    {
        String fieldName = XLib.isDevEnvironment() ? deobfName : obfName;

        try
        {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        }
        catch (Exception e)
        {
        	XLib.logger().warning("Failed getting field %s: %s", fieldName, e);
        }
        return null;
    }
}