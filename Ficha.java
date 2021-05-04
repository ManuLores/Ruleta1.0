package Ejercicio005;

import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Ficha extends Rectangle{
	public static final int DIM = 50;
	int precio;
	Image imagen;
	java.util.List<Integer> numeros_apostados;

	public Ficha(int posx, int posy, int v, Image img) {
		super(posx, posy, DIM, DIM);
		precio = v;
		imagen = img;
		numeros_apostados = new java.util.ArrayList<Integer>();
    }

	public void dibujar(Graphics g, Applet a) {
		g.drawImage(imagen, x, y, width, height, a);
		/*
		 * for(int i=0; i<numeros_apostados.size(); i++) g.drawString("" +
		 * numeros_apostados.get(i), x + (i*10), y);
		 */
    }

	public void actualizar(int posx, int posy) {
		x = posx - (DIM / 2);
		y = posy - (DIM / 2);
    }

	public void cargar_apostados(Casilla casillas[][]) {
		numeros_apostados.clear();
		for (int i = 0; i < Ruleta.FILAS; i++)
			for (int j = 0; j < Ruleta.COLUMNAS; j++)
				if (this.intersects(casillas[i][j]))
					numeros_apostados.add(new Integer(casillas[i][j].valor));
    }

}