package com.appian.cards;

import java.math.BigDecimal;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Represents the physical dimensions of the card according to the unit of measurement.
 * 
 * @author bclar
 *
 */
@Getter
public class Dimensions 
{
	private final UnitOfMeasurement unitOfMeasurement;
	
	private final BigDecimal width;
	private final BigDecimal height;
	private final BigDecimal depth;
	
	/**
	 * Creates an immutable Dimensions object.
	 * 
	 * @param unitOfMeasurement
	 * @param width
	 * @param height
	 * @param depth
	 */
	public Dimensions(UnitOfMeasurement unitOfMeasurement, BigDecimal width, BigDecimal height, BigDecimal depth)
	{
		this.unitOfMeasurement = unitOfMeasurement;
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
}
