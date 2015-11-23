package com.idiot.rudra.mapper;

/**
 * This interface should be used to map a object <code>S</code> to another
 * object <code>D</code>.
 * 
 * @author IdiotRudra
 * 
 * @param <S>
 * @param <D>
 */
public interface IMapper<S, D> {

	public D map(S s, D d);
}
