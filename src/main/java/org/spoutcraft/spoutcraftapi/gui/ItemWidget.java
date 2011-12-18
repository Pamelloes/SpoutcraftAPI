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

import org.spoutcraft.spoutcraftapi.UnsafeClass;

@UnsafeClass
public interface ItemWidget extends Widget {
	/**
	 * Sets the type id of this item widget
	 * 
	 * @param id
	 * @return ItemWidget
	 */
	public ItemWidget setTypeId(int id);

	/**
	 * Gets the type id of this item widget
	 * 
	 * @return type id
	 */
	public int getTypeId();

	/**
	 * Sets the data of this item widget
	 * 
	 * @param data to set
	 * @return ItemWidget
	 */
	public ItemWidget setData(short data);

	/**
	 * Gets the data of this item widget, is zero by default
	 * 
	 * @return data
	 */
	public short getData();

	/**
	 * Sets the z render depth for this 3-d item widget
	 * 
	 * @param depth to render at
	 * @return ItemWidget
	 */
	public ItemWidget setDepth(int depth);

	/**
	 * Gets the z render depth for this 3-d item widget
	 * 
	 * @return depth
	 */
	public int getDepth();
    
	/**
	 * Sets the amount of items. 1 by default.
	 *
	 * @param amount
	 * @return ItemWidget
	 */
	 public ItemWidget setAmount(int amount);

	/**
	 * Gets the amount of items. 1 by default.
	 *
	 * @return amount
 	 */
	public int getAmount();

	public ItemWidget setWidth(int width);

	public ItemWidget setHeight(int height);
}
