package com.parzivail.pswm.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;

public class ArmorRebelPilot extends ItemArmor
{
	private String[] names = { "Helmet", "Chestplate", "Leggings", "Boots" };

	public ArmorRebelPilot(ItemArmor.ArmorMaterial par2EnumArmorMaterial, int par3, int par4)
	{
		super(par2EnumArmorMaterial, par3, par4);
		this.setUnlocalizedName(Resources.MODID + "." + "rebelPilot" + this.names[par4]);
		this.setTextureName(Resources.MODID + ":" + "rebelPilot" + this.names[par4]);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == StarWarsMod.rebelPilotHelmet || stack.getItem() == StarWarsMod.rebelPilotChest || stack.getItem() == StarWarsMod.rebelPilotBoots)
			return Resources.MODID + ":" + "textures/models/rebelPilotArmorLayer1.png";
		if (stack.getItem() == StarWarsMod.rebelPilotLegs)
			return Resources.MODID + ":" + "textures/models/rebelPilotArmorLayer2.png";
		return "";
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\armor\ArmorRebelPilot.class Java
 * compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */