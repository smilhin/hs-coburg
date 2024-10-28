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
  
  private static final void drawLine_x_fast(int[] framebuffer, int w, int2 a, int2 b, int col)
  {

    if(b.x < a.x)
    {
      int c = a.x;
      a.x = b.x;
      b.x = c;
    }
    
    int y = a.y;
    int err = 0;
    
    if(b.y < a.y) 
    {
      for(int x = a.x; x <= b.x; x++) 
      {
      if(err >= b.x - a.x) 
      {
        y--;
        err += -2 * (b.x - a.x);
      }
      err += 2 * (a.y - b.y);
      framebuffer[y * w + x] = col;
      }
   }
   else
    {
    for(int x = a.x; x <= b.x; x++) 
    {
      if(err >= b.x - a.x) 
      {
        y++;
        err += -2 * (b.x - a.x);
      }
      err += 2 * (b.y - a.y);
      framebuffer[y * w + x] = col;
    }
    }

    
  }

  public static final void drawLine(int[] framebuffer, int w, int h, int2 a, int2 b, int col)
  {
    ClipResult clip = LineClipping.clip(a, b, w-1, h-1);
    if (clip.cull)
    {
      return;
    }

    drawLine_x_fast(framebuffer, w,a, b, col);
  }
}
