// @ts-check
import { CograError } from "../lib/js/CograError.js";
import { Matrix4 } from "./Matrix4.js";


/**
 * A helper class for GLSL programs. It aggregate the vertex and the fragment shader in a single program.
 */
export default class GLSLProgram {
  /**
   * Creates an GLSL Program.
   * @param gl  The OpenGL contex.
   * @param{string} vertexShaderSrc Vertex Shader source code.
   * @param{string} fragmentShaderSrc Fragment Shader source code.
   */

  constructor(gl, vertexShaderSrc, fragmentShaderSrc) {
    this.gl = gl;
    this.program = null;

    if (!this.gl) {
      throw new CograError("No valid canvas object has been given");
    }

    let vertexShader = gl.createShader(this.gl.VERTEX_SHADER);
    gl.shaderSource(vertexShader, vertexShaderSrc);
    gl.compileShader(vertexShader);      

    let fragmentShader = gl.createShader(this.gl.FRAGMENT_SHADER);
    gl.shaderSource(fragmentShader, fragmentShaderSrc);
    gl.compileShader(fragmentShader);      
        
    this.program = createProgram(this.gl, vertexShader, fragmentShader)
  }

  /**
   * Returns an index to the location of the uniform variable named "name".
   * @param {string} name Name of the uniform variable.
   * @returns{number} Index of the uniform variable.
   */
  getUniformLocation(name) {
    return this.gl.getUniformLocation(this.program, name);
  }

  /**
   * Use (also know as a "Bind") the shader program.    
   */
  use() {
    this.gl.useProgram(this.program);
  }

  /**
   * Sets a single float number to a uniform variable named "name".
   * @param {string} name Name of the uniform variable.
   * @param {number} value Value of the uniform variable.
   */
    setUniform1f(name, value)
    {
      // Assignment 8a: Implement this
      let floatLocation = this.gl.getUniformLocation(this.program, name);
      this.gl.uniform1f(floatLocation, value);
    }

  /**
   * Sets a 4x4 matrix to the shader. Matrix must be row-major
   * @param {string} name Name of the uniform variable.
   * @param {number[]} values 4x4 matrix as a 16-element are of numbers. Matrix is organized row-major.
   */
  setUniformMatrix4f(name, values)
  {
    // Assignment 3f: Transform a_position to Clip-Space
    let matrixLocation = this.gl.getUniformLocation(this.program, name);
    this.gl.uniformMatrix4fv(matrixLocation, true, values);
  }

  /**
   * Sets a 4x4 matrix to the shader. Matrix must be row-major
   * @param {string} name Name of the uniform variable.
   * @param {Vec3} values A vector with three floats.
   */  
  setUniform3f(name, values)
  {
    //4x4 Matrix? Ein Fehler?
    let vecLocation = this.gl.getUniformLocation(this.program, name);
    this.gl.uniform3f(vecLocation, values.x, values.y, values.z);
  }
}

function createProgram(gl, vertexShaderHandle, fragmentShaderHandle) {
  const program = gl.createProgram();

  gl.attachShader(program, vertexShaderHandle);
  gl.attachShader(program, fragmentShaderHandle);
  gl.linkProgram(program);

  if (!gl.getProgramParameter(program, gl.LINK_STATUS)) {
    const programInfo = gl.getProgramInfoLog(program);
    const vertexShaderInfo = gl.getShaderInfoLog(vertexShaderHandle);
    const fragmentShaderInfo = gl.getShaderInfoLog(fragmentShaderHandle);

    console.log(`Error while creating glsl program. \n
                 Program Log: ${programInfo} \n
                 VertexShader Log: ${vertexShaderInfo} \n
                 FragmentShader Log: ${fragmentShaderInfo}`)
    gl.deleteProgram(program);
    throw new CograError(`
      Error while creating glsl program. \n
      Program Log: ${programInfo} \n
      VertexShader Log: ${vertexShaderInfo} \n
      FragmentShader Log: ${fragmentShaderInfo}
    `);

  }
  return program;
}
