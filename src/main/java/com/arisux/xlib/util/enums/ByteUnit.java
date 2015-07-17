package com.arisux.xlib.util.enums;

public enum ByteUnit
{
    BIT(1),
    BYTE(8),
    KILOBYTE(BYTE.bits() * 1024),
    KILOBIT(KILOBYTE.bits() / BYTE.bits()),
    MEGABYTE(KILOBYTE.bits() * 1024),
    MEGABIT(MEGABYTE.bits() / BYTE.bits()),
    GIGABYTE(MEGABYTE.bits() * 1024),
    GIGABIT(GIGABYTE.bits() / BYTE.bits()),
    TERABYTE(GIGABYTE.bits() * 1024),
    TERABIT(TERABYTE.bits() / BYTE.bits()),
    PETABYTE(TERABYTE.bits() * 1024),
    PETABIT(PETABYTE.bits() / BYTE.bits()),
    EXABYTE(PETABYTE.bits() * 1024),
    EXABIT(EXABYTE.bits() / BYTE.bits()),
    ZETTABYTE(EXABYTE.bits() * 1024),
    ZETTABIT(ZETTABYTE.bits() / BYTE.bits()),
    YOTTABYTE(ZETTABYTE.bits() * 1024),
    YOTTABIT(YOTTABYTE.bits() / BYTE.bits());

    private long bits;

    ByteUnit(long bits)
    {
        this.bits = bits;
    }

    public long bits()
    {
        return this.bits;
    }

    public long bytes()
    {
        return this.bits() / BYTE.bits();
    }

    public double convert(ByteUnit unitTo, double value)
    {
        return ByteUnit.convert(unitTo, this, value);
    }

    public static double convert(ByteUnit unitTo, ByteUnit unitFrom, double value)
    {
        return ((value * unitFrom.bits()) / (unitTo.bits()));
    }

    @Override
    public String toString()
    {
        return "%s { %s }".format(this.name(), this.bits());
    }
}
