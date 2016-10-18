package io.github.bi0qaw.vector;

import ch.njol.skript.lang.Expression;
import ch.njol.skript.lang.SkriptParser;
import ch.njol.skript.lang.util.SimpleExpression;
import ch.njol.util.Kleenean;
import org.bukkit.Location;
import org.bukkit.event.Event;
import org.bukkit.util.Vector;

public class ExprVectorBetweenLocations extends SimpleExpression<Vector> {

	private Expression<Location> location1;
	private Expression<Location> location2;

	public boolean isSingle() {
		return true;
	}

	public String toString(Event event, boolean b) {
		return "between locations";
	}

	public Class<? extends Vector> getReturnType() {
		return Vector.class;
	}

	public boolean init(Expression<?>[] expressions, int i, Kleenean kleenean, SkriptParser.ParseResult parseResult) {
		location1 = (Expression<Location>)expressions[0];
		location2 = (Expression<Location>)expressions[1];
		return true;
	}

	@Override
	protected Vector[] get(Event event) {
		Location l1 = location1.getSingle(event);
		Location l2 = location2.getSingle(event);
		if (l1 == null || l2 == null){
			return null;
		}
		return new Vector[]{ new Vector(l2.getX() - l1.getX(), l2.getY() - l1.getY(), l2.getZ() - l1.getZ())};
	}
}
