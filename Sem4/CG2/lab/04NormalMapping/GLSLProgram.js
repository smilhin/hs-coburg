// @ts-check
// Use previous assignment
  }

  /**
   * Sets a 4x4 matrix to the shader. Matrix must be row-major
   * @param {string} name Name of the uniform variable.
   * @param {number[]} values 4x4 matrix as a 16-element are of numbers. Matrix is organized row-major.
   */
  setUniformMatrix4f(name, values)
  {
    // Assignment 3f: Transform a_position to Clip-Space
  }

  /**
   * Sets a 4x4 matrix to the shader. Matrix must be row-major
   * @param {string} name Name of the uniform variable.
   * @param {Vec3} values A vector with three floats.
   */  
  setUniform3f(name, values)
  {
    // Assignment 8a: Implement this
  }


    /**
   * Sets a single integer number to a uniform variable named "name".
   * @param {string} name Name of the uniform variable.
   * @param {number} value Value of the uniform variable.
   */
    setUniform1i(name, value)
    {
      // Assignment 4c: Implement this
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
// End Solution