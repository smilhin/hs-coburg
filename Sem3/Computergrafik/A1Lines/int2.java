/** //<>//
 * A class that represents 2D vectors with integer numbers components.
 */
public final class int2
{
  /** x component of the vector. */
  public int x;

  /** y component of the vector. */
  public int y;

  /**
   * Constructs a zero vector.
   */
  public int2()
  {
    x = 0;
    y = 0;
  }

  /**
   * Constructs a int2 vector
   * @param x_ The first component of this vector.
   * @param y_ The second component of this vector.
   */
  public int2(int x_, int y_)
  {
    x = x_;
    y = y_;
  }

  /**
   * Returns true, if all components of this and rhs differ by less than 1e-6f.
   */
  boolean equals(int2 rhs)
  {
    return this.x == rhs.x && this.y == rhs.y;
  }

  /**
   * Prints the vector the console and starts a new line.
   */
  void println()
  {
    System.out.println(x + "\t" + y + "\t");
  }

  /**
   * Subtracts two vectors and returns the differences.
   * This method does not modify any members.
   * @param rhs Right-hand side of subtraction. Left-hand side is this.
   * @return int2 A new vector containing the difference.
   */
  public int2 sub(int2 rhs)
  {
    return new int2(this.x - rhs.x, this.y - rhs.y);
  }

  /**
   * Computes and returns the dot product (inner product, scalar product) between this vector and the vector given in rhs.
   * This method does not modify any members.
   * @param rhs The rhs of the dot product
   * @return float The value of the dot product.
   */
  public int dot(int2 rhs)
  {
    return this.x * rhs.x + this.y * rhs.y;
  }

  /**
   * Computes the cross product of this.
   * This method does not modify any members.
   * @return int2 The cross product between this x rhs.
   */
  public int2 cross()
  {
    return new int2(-this.y, this.x);
  }
}
