package com.plane.element;

public class MoveWay {
	public static int gox(int type,int x_)
	{
		int x=x_;
		switch(type)
		{
		case 1:
			x++;break;
		case 2:
			x++;break;
		case 3:
			x--;break;
		case 4:
			x--;break;
		case 5:
			break;
		case 6:
			x=x_%700+50;
			if(x_>400)
			{
				x=750-x_;
			}
			
		}
		return x;
	}

	public static int track(int type, int x0, int y0, int x_) {
		int y = 0;
		switch (type) {
		case 1:
			y = (int)(x_ + x0)^2 + y0;
			break;
		case 2:
			y = x_ + x0 + y0;
			break;
		case 3:
			y = (int)(x_ + x0)^2 + y0;
			break;
		case 4:
			y = -(x_ + x0) + y0;
			break;
		case 5:
			y=y0;
			break;
		case 6:
			y=100;
			break;
		}
		
		return y;
	}
	
}
