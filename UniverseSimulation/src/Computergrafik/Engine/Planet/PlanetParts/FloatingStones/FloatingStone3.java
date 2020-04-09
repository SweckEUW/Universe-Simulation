package Computergrafik.Engine.Planet.PlanetParts.FloatingStones;

import Computergrafik.Engine.Core.Math.Vector3f;
import Computergrafik.Engine.Core.Models.Model;
import Computergrafik.Engine.Core.Shaders.Core.Material;
import Computergrafik.Engine.Planet.Core.Planet;

public class FloatingStone3 extends FloatingStone {

	private static final String FILE = "PlanetParts/FloatingStone3";
	private static final float SIZE = 0.3f;
	private static final int NUMBER_OF_MODELS = 1;
	
	public FloatingStone3(Planet planet) {
		super(planet,NUMBER_OF_MODELS);
	}
	
	@Override
	public void calculateColors() {
		colors[0] = new float[models[0].getMesh().getVertices().length];
		for (int i = 0; i < colors[0].length; i+=3) {
			colors[0][i]=126f/255f*(0.7f+((float)Math.random()*(1f-0.7f)));
			colors[0][i+1]=156f/255f*(0.7f+((float)Math.random()*(1f-0.7f)));
			colors[0][i+2]=126f/255f*(0.7f+((float)Math.random()*(1f-0.7f)));
		}
		models[0].getMesh().setColorValues(colors[0]);
	}

	@Override
	protected void setModels() {
		Material material = new Material(new Vector3f(0.2f), new Vector3f(0.7f), new Vector3f(0,1,0), 10);
		
		models[0] = new Model(FILE,material);
		models[0].setScale(SIZE);
	}

	@Override
	public void setScale() {
		models[0].setScale(planet.getPlanetModel().getScale()*SIZE);
	}

}
