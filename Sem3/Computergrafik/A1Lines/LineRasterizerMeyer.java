public final class LineRasterizerMeyer
{
  private static final void drawLine(int[] framebuffer, int lu, int lv, int ru, int rv, int ofs, int col)
  {
    int l = lu;
    int err = lu;
    lv = - 2 * Math.abs(lv);
    lu *= 2;
    for (int u = 0; u <= l; u++)
    {
      int inc = err >> 31;    
      err += lv + (inc & lu); 
      ofs += ru + (inc & rv);
      framebuffer[ofs] = col;
    }
  }

  public static final void drawLine(int[] framebuffer, int w, int h, int2 a, int2 b, int col)
  {
    ClipResult clip = LineClipping.clip(a, b, w-1, h-1);
    if (clip.cull)
    {
      return;
    }

    int au = clip.a.x;
    int av = clip.a.y;
    int bu = clip.b.x;
    int bv = clip.b.y;

    boolean y_is_faster_than_x = Math.abs(bu - au) < Math.abs(bv - av);    
    if (y_is_faster_than_x)
    {
      au = clip.a.y;
      av = clip.a.x;
      bu = clip.b.y;
      bv = clip.b.x;
    }
   
    if (au > bu)
    {
      au = au ^ bu ^ (bu = au);
      av = av ^ bv ^ (bv = av);
    }
    
    int lu = bu - au;
    int lv = bv - av;    
    int ofs, ru, rv;
    if (y_is_faster_than_x)
    {
      ofs = au * w + av - w;
      ru = w;
      rv = lv >= 0 ? 1 : -1;
    } else
    {
      ofs = av * w + au - 1;
      ru = 1;
      rv = lv >= 0 ? w : -w;
    }        
    drawLine(framebuffer, lu, lv, ru, rv, ofs, col);
  }
}
