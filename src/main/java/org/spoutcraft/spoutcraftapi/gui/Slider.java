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
import org.spoutcraft.spoutcraftapi.event.screen.SliderDragEvent;

@UnsafeClass
public interface Slider extends Control, Label {

	/**
	 * Gets the slider position (between 0.0f and 1.0f)
	 * 
	 * @return slider position
	 */
	public float getSliderPosition();

	/**
	 * Sets the slider position. Values below 0.0f are rounded to 0, and values above 1.0f are rounded to 1
	 * 
	 * @param value to set
	 * @return slider
	 */
	public Slider setSliderPosition(float value);

	public boolean isDragging();

	public Slider setDragging(boolean dragged);
	
	public Slider setText(String text);
	
	public Slider setTextColor(Color color);

	public Slider setAuto(boolean auto);
	
	public Slider setAlign(WidgetAnchor align);

	/**
	 * Fires when this slider is dragged on the screen.
	 * 
	 * This event is also sent to the screen listener, afterwards.
	 * 
	 * @param event
	 */
	public void onSliderDrag(SliderDragEvent event);
}
