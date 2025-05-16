import java.lang.Math;


public final class LineRasterizer
{
  
  private static final void drawLine(int[] framebuffer, int w, int2 b, int col) {
    
    int y = 0;
    int err = 0;
    
    for(int x = 0; x <= b.x; x++) 
    {
      if(err >= b.x) 
      {
        y++;
        err += -2 * b.x;
      }
      err += 2 * b.y;
      framebuffer[y * w + x] = col;
    }
    
  }

  // draline_x_fast und draline_y_fast in einer Funktion zusammengefasst
  private static final void drawLine_fast(int[] framebuffer, int w, int2 a, int2 b, int col)
  {
  
        int dx = Math.abs(b.x - a.x);
        int dy = Math.abs(b.y - a.y);

        // Richtung des Inkrements bestimmen
        int sx = (b.x > a.x) ? 1 : -1;
        int sy = (b.y > a.y) ? 1 : -1;

        // dx und dy tauschen, wenn die Steigung steil ist
        boolean swap = dy > dx;
        if (swap) {
            int temp = dx;
            dx = dy;
            dy = temp;
        }

        // error init
        int err = 0;

        // startpunkt
        int x = a.x;
        int y = a.y;

        // von 0 bis dx iterieren
        for (int i = 0; i <= dx; i++) {
            // punkt einfärben
           framebuffer[y * w + x] = col;
            //error und punkte aktualisieren
            if (err >= 0) {
                if (swap) {
                    x += sx;
                } else {
                    y += sy;
                }
                err += -2 * dx;
            }

            if (swap) {
                y += sy;
            } else {
                x += sx;
            }
            err += 2 * dy;
        }
    
    
  }
  

  public static final void drawLine(int[] framebuffer, int w, int h, int2 a, int2 b, int col)
  {
    ClipResult clip = LineClipping.clip(a, b, w-1, h-1);
    if (clip.cull)
    {
      return;
    }

     drawLine_fast(framebuffer, w,a, b, col); 
   
  }
}
