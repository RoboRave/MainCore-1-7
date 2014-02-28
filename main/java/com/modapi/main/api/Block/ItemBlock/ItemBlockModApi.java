package com.modapi.main.api.Block.ItemBlock;

import com.modapi.main.Utils.StringUtils;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockModApi extends ItemBlock {

        public ItemBlockModApi(Block id) {
                super(id);
        }

        @Override
        public int getMetadata(int i) {
                return i;
        }


        public String getItemDisplayName(ItemStack itemstack) {
                return StringUtils.localize(getUnlocalizedName(itemstack));
        }
}