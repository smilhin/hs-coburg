// @ts-check
// Use previous assignment

    // Assignment 4b

    // Assignment 4c
    
    // Assignment 4d

    // Assignment 2d
    
    // Assignment 4b
    this.triangleMeshGL.draw();

    // Assignment 2d

    // Assignment 4b

    this.nextFrame();
  }

   /***
   * Run once one startup.
   */
   async setup() {
    // load shader
    this.mGlslProgram = new GLSLProgram(this.gl, await loadDataFromURL(document.querySelector("#vertexShader").src), await loadDataFromURL(document.querySelector("#fragmentShader").src));
    this.gl.enable(this.gl.DEPTH_TEST);    
    // Load file.
    const mesh = await SimpleMeshModelIO.load(await loadBinaryDataStreamFromURL("./../data/bunnyUV.smm"));
    this.triangleMeshGL = new TriangleMeshGL(this.gl, mesh);    
    
    // Assignemt 2c
    // Assignment 4b
  }
  
}

let t = new Mesh3DApp();
await t.setup();
t.nextFrame();
// End Solution