//@ts-check
/**
 * A class for 3D vectors.
 */
export class Vec3 {
    /**
     * Creates a vector of three components
     * @param {number} x the first component.
     * @param {number} y the second component
     * @param {number} z the third component
     */
    constructor(x = 0, y = 0, z = 0) {
      this.x = x;
      this.y = y;
      this.z = z;
    }
  
    /**
     * Creates a Vec3D from three different element Ids.
     * @param {string} elementIdX Element id of the x component.
     * @param {string} elementIdY Element id of the y component.
     * @param {string} elementIdZ Element id of the z component.
     * @returns {Vec3} A new 3D vector.
     */
    static createFromElementIds(elementIdX, elementIdY, elementIdZ) {
      let result = new Vec3();
      result.x = parseFloat(document.getElementById(elementIdX).value);
      result.y = parseFloat(document.getElementById(elementIdY).value);
      result.z = parseFloat(document.getElementById(elementIdZ).value);
      return result;
    }
  
    /**
     * Creates a Vec3D from a color ui element Ids.
     * @param {string} colorElementId Element id of the color ui element.      
     * @returns {Vec3} A new 3D vector.
     */
    static createFromColorElement(colorElementId) {
      let color = document.getElementById(colorElementId).value;
      let result = new Vec3();
      result.x = parseInt(color.substr(1, 2), 16) / 255.0;
      result.y = parseInt(color.substr(3, 2), 16) / 255.0;
      result.z = parseInt(color.substr(5, 2), 16) / 255.0;
      return result;
    }
  
  
    /**
     * Reads three numbers from the index i*3 of array a.
     * @param {number[]} a An array with the three consecutive numbers making up a vector. 
     * @param {number} i Index of the vector to be extracted.
     * @returns A vec3.
     */
    static createFromArray(a, i) {
      return new Vec3(a[i * 3 + 0], a[i * 3 + 1], a[i * 3 + 2]);
    }
  
    /**
     * Computes the dot product between two vectors.
     * @param {Vec3} a Left Operand
     * @param {Vec3} b Right Operand
     * @returns {number} The dot product.
     */
    static dot(a, b) {
      return a.x * b.x + a.y * b.y + a.z * b.z;
    }
  
    /**
     * Computes the Euclidean length of vector.
     * @param {Vec3} a The vector of which to compute the length.
     * @returns The Euclidean length.
     */
    static euclideanLength(a) {
      return Math.sqrt(this.dot(a, a));
    }
  
    /**
     * Adds two vectors and returns the sum.
     * @param {Vec3} a Left operand of the addition.
     * @param {Vec3} b Right operand of the addition.
     * @returns The vector sum of the vectors a and b.
     */
    static add(a, b) {
      return new Vec3(a.x + b.x, a.y + b.y, a.z + b.z);
    }
  
    /**
     * Subtracts two vectors and returns the difference.
     * @param {Vec3} a Left operand of the difference.
     * @param {Vec3} b Right operand of the difference.
     * @returns The vector difference of the vectors a and b.
     */
    static sub(a, b) {
      return new Vec3(a.x - b.x, a.y - b.y, a.z - b.z);
    }
  
    /**
     * Computes the cross product. 
     * @param {Vec3} a 
     * @param {Vec3} b 
     * @returns The cross product as a Vec3.
     */
    static cross(a, b) {
      return new Vec3(a.y * b.z - a.z * b.y,
        a.z * b.x - a.x * b.z,
        a.x * b.y - a.y * b.x
      );
    }
  
    /**
     * Scales a vector by a constant vector
     * @param {number} s The constant factor.
     * @param {Vec3} a The vector to be scaled
     * @returns The scaled vector.
     */
    static scale(s, a) {
      return new Vec3(s * a.x, s * a.y, s * a.z);
    }
  
    /**
     * Scales vector to unit length.
     * @param {Vec3} a The vector that we wish to normalize.
     * @returns A vector pointing in the same direction of a, but which has unit length.
     */
    static normalize(a) {
      let inverseLength = 1.0 / this.euclideanLength(a);
      return this.scale(inverseLength, a);
    }
  }