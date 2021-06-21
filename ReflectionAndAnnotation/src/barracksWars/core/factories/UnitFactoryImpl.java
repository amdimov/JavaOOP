package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;
		try {
			Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			Constructor<?> unitClassCst = unitClass.getDeclaredConstructor();
			unit = (Unit) unitClassCst.newInstance();
		} catch (NoSuchMethodException | IllegalAccessException
				| InstantiationException | InvocationTargetException
				| ClassNotFoundException e) {
			throw new IllegalStateException(e);
		}
		return unit;
	}
}
