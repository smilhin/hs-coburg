//@ts-check
import { loadDataFromURL, loadBinaryDataStreamFromURL } from "./../lib/js/http.js";
import { SimpleMeshModelIO } from "./../lib/js/SimpleMeshModelIO.js"
import GLSLProgram from "./GLSLProgram.js";
import { Matrix4 } from "./Matrix4.js";
import { TriangleMeshGL } from "./TriangleMeshGL.js"
import { Vec3 } from "./Vec3.js"

export class Mesh3DApp {
  /**
   * The sychronous constructor.
   */ 
  constructor() {
    this.mCanvas = document.querySelector("#canvas");
    if (!this.mCanvas) {
      throw new NullArgumentError("No canvas object has been given!");
    }

    /** @type {WebGL2RenderingContext} */
    //@ts-ignore
    this.gl = this.mCanvas.getContext("webgl2");
    this.mGlslProgram = null;
    this.triangleMeshGL = null;    
  }

  /**
   * Call this method, whenever a resize is necessary.
   */
  resize() {
    let w = this.mCanvas.clientWidth;
    let h = this.mCanvas.clientHeight;
    if (this.mCanvas.width != w || this.mCanvas.height != h) {
      this.mCanvas.width = w;
      this.mCanvas.height = h;
      this.gl.viewport(0, 0, this.gl.canvas.width, this.gl.canvas.height);
    }
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
   * Draws a single frame. Call your WebGL functions here.
   * The last line of this function should be this.nextFrame();
   */
  draw() {
    this.resize();

    // Read Data from user interface.
    let translation = Vec3.createFromElementIds("TranslateX", "TranslateY", "TranslateZ");
    let rotation = Vec3.createFromElementIds("RotationX", "RotationY", "RotationZ");
    let nearPlaneDistance = parseFloat(document.getElementById("NearPlane").value);
    let farPlaneDistance = parseFloat(document.getElementById("FarPlane").value);
    let fieldOfViewRadians = parseFloat(document.getElementById("FieldOfView").value);
    let ambientColor = Vec3.createFromColorElement("AmbientColor");
    let diffuseColor = Vec3.createFromColorElement("DiffuseColor");
    let specularColor = Vec3.createFromColorElement("SpecularColor");
    let specularExponent = parseFloat(document.getElementById("SpecularExponent").value);
        
    // Compute matrices.
    // Assignment 3b: Compute perspective matrix
    let projectionMatrix = Matrix4.perspective(
      fieldOfViewRadians, 
      this.gl.canvas.width / this.gl.canvas.height,
      nearPlaneDistance, 
      farPlaneDistance);    

    // Assignment 5b: Compute translation matrix
    let translationMatrix = Matrix4.translation(translation.x, translation.y, translation.z);
    // Assignment 5c: Compute rotation matrices
    let rotationMatrixX = Matrix4.rotationX(rotation.x);
    let rotationMatrixY = Matrix4.rotationY(rotation.y);
    let rotationMatrixZ = Matrix4.rotationZ(rotation.z);
    //  Assignment 5d: Compute model-view matrix
    let modelViewMatrix = Matrix4.multiply(
      Matrix4.multiply(
        Matrix4.multiply(
           rotationMatrixZ, rotationMatrixY
        ), rotationMatrixX
      ), translationMatrix
    );
    // Assignment 5e: Compute model-view-projection matrix
    let modelViewProjMatrix = Matrix4.multiply(projectionMatrix, modelViewMatrix);
    // Clear Background.
    this.gl.clearColor(1.0, 1.0, 1.0, 1.0);
    this.gl.clear(this.gl.COLOR_BUFFER_BIT | this.gl.DEPTH_BUFFER_BIT);

    // Bind Shader 
    this.mGlslProgram.use();

    // Configure Draw Call: Matrices
    
    // Assignment 3g: Pass Projection matrix to shader
    this.mGlslProgram?.setUniformMatrix4f("u_mvp", modelViewProjMatrix);

    // Assignment 7a: Pass Model-View matrix to shader 
    this.mGlslProgram?.setUniformMatrix4f("u_mvm", modelViewMatrix);
    
    // Assignment 8b: Pass parameters of Blinn-Phong model to fragment-shader
    this.mGlslProgram?.setUniform1f("u_spec", specularExponent);
    this.mGlslProgram?.setUniform3f("u_ambient", ambientColor);
    this.mGlslProgram?.setUniform3f("u_diffuse", diffuseColor);
    this.mGlslProgram?.setUniform3f("u_scol", specularColor);
    
    // Assignment 1i: Draw mesh
    this.gl.drawElements(this.gl.TRIANGLES, this.triangleMeshGL?.nTriangleIndices, this.gl.UNSIGNED_INT, 0);
    this.nextFrame();
  }

  /**
   * Call this function explicitly after the synchronous constructor.
   * After called from the outside, wait 
   */
  async setup() {    
    // load shader    
    this.mGlslProgram = new GLSLProgram(this.gl, await loadDataFromURL(document.querySelector("#vertexShader").src), await loadDataFromURL(document.querySelector("#fragmentShader").src));
    this.gl.enable(this.gl.DEPTH_TEST);
    // Load file.    
    const mesh = await SimpleMeshModelIO.load(await loadBinaryDataStreamFromURL("./../data/bunny.smm"));
    
    // Assignemt 1f: Create TriangleMeshGL
    this.triangleMeshGL = new TriangleMeshGL(this.gl, mesh);
  }
};

let t = new Mesh3DApp();
await t.setup();
t.nextFrame();





