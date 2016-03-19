package io.github.hsyyid.halocraft.items;

import io.github.hsyyid.halocraft.items.firearms.ItemSniperRifle;

import java.util.TimerTask;

public class SniperRifleTask extends TimerTask
{
	public ItemSniperRifle item;

	public SniperRifleTask(ItemSniperRifle i)
	{
		this.item = i;
	}

	@Override
	public void run()
	{
		item.canShoot = true;
	}
}
