package com.parzivail.pswm.items.weapons;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.parzivail.pswm.Resources;
import com.parzivail.pswm.Resources.ConfigOptions;
import com.parzivail.pswm.StarWarsMod;
import com.parzivail.pswm.network.PacketTogglePlayerLightsaber;
import com.parzivail.util.ui.TextUtils;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLightsaber extends ItemSword
{
	public String name = "lightsaber";
	private String[] colors = { "red", "green", "blue"/* , "redKyloRen" */};
	@SideOnly(Side.CLIENT)
	private IIcon[] icons;

	public ItemLightsaber()
	{
		super(StarWarsMod.materialPlasma);
		this.setUnlocalizedName(Resources.MODID + "." + this.name);
		this.setTextureName(Resources.MODID + ":" + this.name);
		this.setHasSubtypes(true);
		this.setCreativeTab(StarWarsMod.StarWarsTab);
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add(TextUtils.makeItalic("This is the formal weapon of a Jedi Knight."));
		list.add("Sneak + Right Click to disable.");
		list.add("Block to deflect blaster bolts.");
	}

	@Override
	public boolean canHarvestBlock(Block block, ItemStack stack)
	{
		return true;
	}

	@Override
	public IIcon getIconFromDamage(int par1)
	{
		return this.icons[par1];
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item par1, CreativeTabs par2CreativeTabs, List par3List)
	{
		for (int x = 0; x < this.colors.length; x++)
			par3List.add(new ItemStack(this, 1, x));
	}

	@Override
	public boolean hitEntity(ItemStack stack, EntityLivingBase a, EntityLivingBase b)
	{
		if (a instanceof EntityPlayer && b instanceof EntityPlayer)
		{
			EntityPlayer pa = (EntityPlayer)a;
			EntityPlayer pb = (EntityPlayer)b;
			if (pa.inventory.mainInventory[pa.inventory.currentItem] != null && pa.inventory.mainInventory[pa.inventory.currentItem].getItem() == StarWarsMod.lightsaber && pa.isBlocking() && pb.inventory.mainInventory[pb.inventory.currentItem] != null && pb.inventory.mainInventory[pb.inventory.currentItem].getItem() == StarWarsMod.lightsaber)
			{
				a.playSound(Resources.MODID + ":" + "item.lightsaber.crash", 1.0F, 1.0F);
				b.playSound(Resources.MODID + ":" + "item.lightsaber.crash", 1.0F, 1.0F);
			}
			if (pa.inventory.mainInventory[pa.inventory.currentItem] != null && pa.inventory.mainInventory[pa.inventory.currentItem].getItem() == StarWarsMod.sequelLightsaber && pa.isBlocking() && pb.inventory.mainInventory[pb.inventory.currentItem] != null && pb.inventory.mainInventory[pb.inventory.currentItem].getItem() == StarWarsMod.sequelLightsaber)
			{
				a.playSound(Resources.MODID + ":" + "item.lightsaber.crash", 1.0F, 1.0F);
				b.playSound(Resources.MODID + ":" + "item.lightsaber.crash", 1.0F, 1.0F);
			}
		}
		return super.hitEntity(stack, a, b);
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
	{
		entityLiving.playSound(Resources.MODID + ":" + "item.lightsaber.swing", 1.0F, 1.0F + (float)MathHelper.getRandomDoubleInRange(Item.itemRand, -0.2D, 0.2D));
		return super.onEntitySwing(entityLiving, stack);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (stack.stackTagCompound == null)
		{
			stack.stackTagCompound = new NBTTagCompound();
			stack.stackTagCompound.setInteger("timeout", 10);
		}
		if (!stack.stackTagCompound.hasKey("timeout"))
			stack.stackTagCompound.setInteger("timeout", 10);
		if (player.isSneaking() && stack.stackTagCompound.getInteger("timeout") == 0)
		{
			player.playSound(Resources.MODID + ":" + "item.lightsaber.close", 1.0F, 1.0F);
			StarWarsMod.network.sendToServer(new PacketTogglePlayerLightsaber(player.getCommandSenderName(), player.dimension));
		}
		return super.onItemRightClick(stack, world, player);
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int p_77663_4_, boolean p_77663_5_)
	{
		super.onUpdate(stack, worldIn, entityIn, p_77663_4_, p_77663_5_);
		if (!stack.hasTagCompound())
			stack.stackTagCompound = new NBTTagCompound();
		if (!stack.stackTagCompound.hasKey("timeout"))
			stack.stackTagCompound.setInteger("timeout", 10);
		if (stack.stackTagCompound.getInteger("timeout") > 0)
			stack.stackTagCompound.setInteger("timeout", stack.stackTagCompound.getInteger("timeout") - 1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.icons = new IIcon[this.colors.length];
		for (int i = 0; i < this.icons.length; i++)
			if (ConfigOptions.enableLightsaberStrobe)
				this.icons[i] = par1IconRegister.registerIcon(Resources.MODID + ":" + this.name + "_" + this.colors[i]);
			else
				this.icons[i] = par1IconRegister.registerIcon(Resources.MODID + ":" + this.name + "_" + this.colors[i] + "_static");
	}
}
/*
 * Location: C:\Users\Colby\Downloads\Parzi's Star Wars Mod
 * v1.2.0-dev7.jar!\com\parzi\starwarsmod\items\weapons\ItemLightsaber.class
 * Java compiler version: 6 (50.0) JD-Core Version: 0.7.1
 */