package com.parzivail.pswm.blocks;

import net.minecraft.block.material.Material;

import com.parzivail.pswm.StarWarsMod;
import com.parzivail.util.block.BlockMultiTexture;
import com.parzivail.util.world.HarvestLevel;

public class BlockDeathStar extends BlockMultiTexture
{
	public BlockDeathStar()
	{
		super("deathStarBlock", new String[] { "HangarFloor", "HangarCrate", "CorridorFloor", "CautionFloor", "HangarWallPanel", "CorridorWallPanel", "ShieldGeneratorConsole", "Extra1", "Extra2", "Extra3" }, Material.rock);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setHardness(4.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
		this.setStepSound(soundTypeMetal);
	}
}