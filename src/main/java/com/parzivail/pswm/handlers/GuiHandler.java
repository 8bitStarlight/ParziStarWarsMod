package com.parzivail.pswm.handlers;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.rendering.gui.ContainerClient;
import com.parzivail.pswm.rendering.gui.ContainerHoloTable;
import com.parzivail.pswm.rendering.gui.ContainerMV;
import com.parzivail.pswm.rendering.gui.GuiHoloTable;
import com.parzivail.pswm.rendering.gui.GuiJediSith;
import com.parzivail.pswm.rendering.gui.GuiMV;
import com.parzivail.pswm.rendering.gui.GuiScreenJediRobes;
import com.parzivail.pswm.tileentities.TileEntityHoloTableBase;
import com.parzivail.pswm.tileentities.TileEntityMV;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler
{
	@Override
	public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == Resources.GUI_MV)
			return new GuiMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		if (id == Resources.GUI_ROBES)
			return new GuiScreenJediRobes(player);
		if (id == Resources.GUI_JEDI_SITH)
			return new GuiJediSith(player);
		if (id == Resources.GUI_HOLOTABLE)
			return new GuiHoloTable(player, (TileEntityHoloTableBase)world.getTileEntity(x, y, z));
		return null;
	}

	@Override
	public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z)
	{
		if (id == Resources.GUI_MV)
			return new ContainerMV(player.inventory, (TileEntityMV)world.getTileEntity(x, y, z));
		if (id == Resources.GUI_ROBES)
			return new ContainerClient();
		if (id == Resources.GUI_JEDI_SITH)
			return new ContainerClient();
		if (id == Resources.GUI_HOLOTABLE)
			return new ContainerHoloTable((TileEntityHoloTableBase)world.getTileEntity(x, y, z));
		return null;
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\handlers\GuiHandler.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */