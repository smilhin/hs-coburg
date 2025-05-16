import { loadDataFromURL } from "./../lib/js/http.js";

export class Triangle {

  /**
   * The sychronous constructor.
   */ 
  constructor() {
    this.mCanvas = document.getElementById("canvas");
    /** @type {WebGL2RenderingContext} */
    this.gl = WebGLDebugUtils.makeDebugContext(this.mCanvas.getContext("webgl2"));
  }

  /**
   * Draws a single frame. Call your WebGL functions here.
   * The last line of this function should be this.nextFrame();
   */
  draw() {

    this.gl.clearColor(1.0, 1.0, 1.0, 1.0);
    this.gl.clear(this.gl.COLOR_BUFFER_BIT);

    this.resize();

    this.gl.bindVertexArray(this.vao);

    this.gl.drawElements(this.gl.TRIANGLES, this.indices.length - 1, this.gl.UNSIGNED_INT, 0);  

    this.nextFrame();
  }

  /**
   * Call this function to trigger rendering of the next frame.
   * You must call it
   * - Right after setup() has finished.
   * - To issue the next frame, at the very bottom of your draw()-method.
   */
  nextFrame() {
    requestAnimationFrame(this.draw.bind(this));
  }

  

  /**
   * Call this function explicitly after the synchronous constructor.
   * After called from the outside, wait 
   */
  async setup() {

    // 1. Create Mesh on the CPU
    this.positions = [
      //First Triangle
      -1.0, -1.0, 0.0, 1.0,
      1.0, -1.0, 0.0, 1.0,
      0.0, 1.0, 0.0, 1.0,
      //Second Triangle
      0.0, 1.0, 0.0, 1.0,
      1.0, -1.0, 0.0, 1.0,
      1.0, 1.0, 0.0, 1.0 
    ];

    // CPU Array for Colors

    this.colors = [
      1.0, 0.0, 0.0, 1.0, 
      0.0, 1.0, 0.0, 1.0, 
      0.0, 0.0, 1.0, 1.0, 
      1.0, 1.0, 0.0, 1.0, 
      0.0, 0.0, 0.0, 1.0, 
      1.0, 0.0, 0.0, 1.0  
    ];

    this.indices = [
      0, 1, 2, 3, 4, 5, 6
    ];  

    //Create and Bind Index Buffer and Vertex Buffer
    this.vao = this.gl.createVertexArray();
    this.gl.bindVertexArray(this.vao);

    
    //Adjust Index Buffer
    this.pb = this.gl.createBuffer();
    this.gl.bindBuffer(this.gl.ARRAY_BUFFER, this.pb);
    this.gl.bufferData(this.gl.ARRAY_BUFFER, new Float32Array(this.positions), this.gl.STATIC_DRAW);

    //Adjust Vertex Buffer
    this.ib = this.gl.createBuffer();
    this.gl.bindBuffer(this.gl.ELEMENT_ARRAY_BUFFER, this.ib);
    this.gl.bufferData(this.gl.ELEMENT_ARRAY_BUFFER, new Uint32Array(this.indices), this.gl.STATIC_DRAW);
    
    //Create Shaders
    this.vertexShaderUrl = document.querySelector("#vertexShader").src;
    this.fragmentShaderUrl = document.querySelector("#fragmentShader").src;

    const vertexShaderSrc = await loadDataFromURL(this.vertexShaderUrl);
    const fragmentShaderSrc = await loadDataFromURL(this.fragmentShaderUrl);

    this.vertexShader = this.gl.createShader(this.gl.VERTEX_SHADER);
    this.fragmentShader = this.gl.createShader(this.gl.FRAGMENT_SHADER);
    
    //Compile Shaders
    this.gl.shaderSource(this.vertexShader, vertexShaderSrc);
    this.gl.compileShader(this.vertexShader);

    if(!this.gl.getShaderParameter(this.vertexShader, this.gl.COMPILE_STATUS)) {
      const compileError = this.gl.getShaderInfoLog(this.vertexShader);
      console.log(compileError);
    }

    this.gl.shaderSource(this.fragmentShader, fragmentShaderSrc);
    this.gl.compileShader(this.fragmentShader);

    if(!this.gl.getShaderParameter(this.fragmentShader, this.gl.COMPILE_STATUS)) {
      const compileError = this.gl.getShaderInfoLog(this.fragmentShader);
      console.log(compileError);
    }
    //Attach Shaders to Program
    this.program = this.gl.createProgram();
    this.gl.attachShader(this.program, this.vertexShader);
    this.gl.attachShader(this.program, this.fragmentShader);
    this.gl.linkProgram(this.program);

    if(!this.gl.getProgramParameter(this.program, this.gl.LINK_STATUS)) {
      const linkError = this.gl.getProgramInfoLog(this.program);
      console.log(linkError);
    }
    
    //Connect Vertex Buffer with Vertex Array Object
    this.posAttrLocation = this.gl.getAttribLocation(this.program, "inVertex");
    console.log(this.posAttrLocation);
    
    this.gl.useProgram(this.program);
    this.gl.enableVertexAttribArray(this.posAttrLocation);

    this.gl.vertexAttribPointer(this.posAttrLocation, 4, this.gl.FLOAT, false, 0, 0);

    //Adjust Color Array
    this.colb = this.gl.createBuffer();
    this.gl.bindBuffer(this.gl.ARRAY_BUFFER, this.colb);
    this.gl.bufferData(this.gl.ARRAY_BUFFER, new Float32Array(this.colors), this.gl.STATIC_DRAW);

    //Connect Color Buffer with Vertex Array Object
    this.colAttribLocation = this.gl.getAttribLocation(this.program, "inColor");

    this.gl.useProgram(this.program);
    this.gl.enableVertexAttribArray(this.colAttribLocation);
    this.gl.bindBuffer(this.gl.ARRAY_BUFFER, this.colb);

    this.gl.vertexAttribPointer(this.colAttribLocation, 3, this.gl.FLOAT, false, 0, 0);

    //Set Uniform Variables
    let colorScaleLocation = this.gl.getUniformLocation(this.program, "u_colorScale");
    this.gl.uniform1f(colorScaleLocation, 0.8);

    let vertexScaleLocation = this.gl.getUniformLocation(this.program, "u_vertexScale");
    this.gl.uniform1f(vertexScaleLocation, 1.0);
  } 

/**
 * Resize function to avoid jaggies 
 */
  resize() {
    
    this.width = this.mCanvas.clientWidth;
    this.height = this.mCanvas.clientHeight;

    if(this.mCanvas.width != this.width || this.mCanvas.height != this.height) {
      this.mCanvas.width = this.width;
      this.mCanvas.height = this.height;
      this.gl.viewport(0, 0, this.gl.canvas.width, this.gl.canvas.height);
    }

  }

}


let t = new Triangle();
let setupDone = t.setup();

await setupDone;
t.nextFrame();



