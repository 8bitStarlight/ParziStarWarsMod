package com.parzivail.pswm.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.tileentities.TileEntityHangingCauldron;
import com.parzivail.util.world.HarvestLevel;

public class BlockHangingCauldron extends BlockContainer
{
	public BlockHangingCauldron()
	{
		super(Material.iron);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
		this.setBlockName(Resources.MODID + "." + "cauldronHanging");
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		this.setHardness(50.0F);
		this.setHarvestLevel("pickaxe", HarvestLevel.IRON);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta)
	{
		return new TileEntityHangingCauldron();
	}

	@Override
	public int getRenderType()
	{
		return -1;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	@Override
	public void registerBlockIcons(IIconRegister icon)
	{
		this.blockIcon = icon.registerIcon(Resources.MODID + ":" + "iconCauldronHanging");
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	{
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\blocks\BlockTable.class Java compiler
 * version: 6 (50.0) JD-Core Version: 0.7.1
 */