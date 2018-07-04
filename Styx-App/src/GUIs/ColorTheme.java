package GUIs;

import java.awt.Color;

public enum ColorTheme {
	
	
	
	BRIGHT(44, 47, 51, 153, 170, 181),
	DARK(153, 170, 181, 44, 47, 51);
	
	int foreground_r; int foreground_g; int foreground_b; int background_r; int background_g; int background_b;
	
	private ColorTheme(int foreground_r, int foreground_g, int foreground_b, int background_r, int background_g, int background_b) {
		this.foreground_r = foreground_r;
		this.foreground_g = foreground_g;
		this.foreground_b = foreground_b;
		
		this.background_r = background_r;
		this.background_g = background_g;
		this.background_b = background_b;
	}
	
	public Color getForeground() {
		return new Color(foreground_r, foreground_g, foreground_b);
	}
	
	public Color getBackground() {
		return new Color(background_r, background_g, background_b);
	}
	
}
