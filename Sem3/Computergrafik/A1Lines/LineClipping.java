public final class LineClipping
{
  public static final int left   = 0B1000;
  public static final int right   = 0B0100;
  public static final int top     = 0B0010;
  public static final int bottom = 0B0001;

  public static int outcode(int2 p, int x_max, int y_max)
  {
    return
      (p.x <  0 ? left   : 0B0000) |
      (p.x >  x_max ? right  : 0B0000) |
      (p.y <  0 ? top    : 0B0000) |
      (p.y >  y_max ? bottom : 0B0000);
  }

  public static final ClipResult clip(int2 a, int2 b, int x_max, int y_max)
  {    
    ClipResult result = new ClipResult();
    result.cull = false;
    result.a = new int2(a.x, a.y);   
    result.b = new int2(b.x, b.y);
    return result;
  }
}
