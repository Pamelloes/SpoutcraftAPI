/*
 * This file is part of SpoutcraftAPI (http://wiki.getspout.org/).
 * 
 * SpoutcraftAPI is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * SpoutcraftAPI is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.spoutcraft.spoutcraftapi.gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import org.spoutcraft.spoutcraftapi.Spoutcraft;
import org.spoutcraft.spoutcraftapi.UnsafeClass;
import org.spoutcraft.spoutcraftapi.inventory.ItemStack;

@UnsafeClass
public class GenericItemWidget extends GenericWidget implements ItemWidget {
	protected int material = -1;
	protected short data = -1;
	protected int depth = 8;
	protected int amount = 1;
	protected ItemStack toRender = null;
	
	private net.minecraft.src.ItemStack is = null;

	public GenericItemWidget() {
		is = new net.minecraft.src.ItemStack(material, amount, data);
	}

	public GenericItemWidget(ItemStack item) {
		this.material = item.getTypeId();
		this.data = item.getDurability();
		this.amount = item.getAmount();
		is = new net.minecraft.src.ItemStack(material, amount, data);
	}

	public int getNumBytes() {
		return super.getNumBytes() + 10;
	}

	public int getVersion() {
		return super.getVersion() + 0;
	}

	@Override
	public void readData(DataInputStream input) throws IOException {
		super.readData(input);
		this.setTypeId(input.readInt());
		this.setData(input.readShort());
		this.setDepth(input.readInt());
		this.setAmount(input.readInt());
	}

	@Override
	public void writeData(DataOutputStream output) throws IOException {
		super.writeData(output);
		output.writeInt(getTypeId());
		output.writeShort(getData());
		output.writeInt(getDepth());
		output.writeInt(getAmount());
	}

	public ItemWidget setTypeId(int id) {
		this.material = id;
		is = new net.minecraft.src.ItemStack(material, amount, data);
		return this;
	}

	public int getTypeId() {
		return material;
	}

	public ItemWidget setData(short data) {
		this.data = data;
		is.setItemDamage(data);
		return this;
	}

	public short getData() {
		return data;
	}

	public ItemWidget setDepth(int depth) {
		this.depth = depth;
		return this;
	}

	public int getDepth() {
		return depth;
	}

	public ItemWidget setAmount(int amount) {
		this.amount=amount;
		is = new net.minecraft.src.ItemStack(material, amount, data);
		return this;
	}
	
	public int getAmount() {
		return amount;
	}
	
	public net.minecraft.src.ItemStack getItemStack() {
		return is;
	}
	
	public ItemWidget setHeight(int height) {
		super.setHeight(height);
		return this;
	}

	public ItemWidget setWidth(int width) {
		super.setWidth(width);
		return this;
	}

	public WidgetType getType() {
		return WidgetType.ItemWidget;
	}

	@Override
	public ItemWidget copy() {
		return ((ItemWidget)super.copy()).setTypeId(getTypeId()).setData(getData()).setDepth(getDepth());
	}

	public void render() {
		Spoutcraft.getClient().getRenderDelegate().render(this);
	}

}
