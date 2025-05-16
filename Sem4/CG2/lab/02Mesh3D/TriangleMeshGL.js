// @ts-check
import { SimpleMeshModelIO } from "./../lib/js/SimpleMeshModelIO.js"

/**
 * A class that holds a single WebGL Triangles Mesh consisting of an 
 * - index buffer and
 * - a buffer for position
 * and optionally a 
 * and is able to render them.
 */
export class TriangleMeshGL {

    /**
     * Creates a triangle mesh with positions, colors and texture coordinates
     * drawable with WebGL2.
     * 
     * @param {WebGL2RenderingContext} gl WebGL Rendering Context
     * @param {SimpleMeshModelIO} simpleMeshIO Simple Mesh IO
     */ 
    constructor(gl, simpleMeshIO) {
        this.gl = gl;        
        this.vao = 0;
        
        const triangles     = simpleMeshIO.indices;
        const positions     = simpleMeshIO.positions;        
        const normals       = simpleMeshIO.normals;

        const positionAttributeLocation = 0;        
        const normalAttributeLocation = 2;

        this.nTriangleIndices = simpleMeshIO.indices.length;

        // Assignment 1a: Create and bind vertex array object.
        this.vao = this.gl.createVertexArray();
        this.gl.bindVertexArray(this.vao);
        // Assignment 1b: Create, bind, and upload buffer for position data on the GPU
        this.posBuffer = this.gl.createBuffer();
        this.gl.bindBuffer(this.gl.ARRAY_BUFFER, this.posBuffer);
        this.gl.bufferData(this.gl.ARRAY_BUFFER, new Float32Array(positions), this.gl.STATIC_DRAW);

        // Assignment 1c: Enable position buffer and tell WebGL that a position consists of three floats.
        this.gl.enableVertexAttribArray(positionAttributeLocation);
        this.gl.vertexAttribPointer(positionAttributeLocation, 3, this.gl.FLOAT, false, 0, 0);
        // Assignment 1d: Creae, bind, and upload index buffer on the GPU.
        this.indexBuffer = this.gl.createBuffer();
        this.gl.bindBuffer(this.gl.ELEMENT_ARRAY_BUFFER, this.indexBuffer);
        this.gl.bufferData(this.gl.ELEMENT_ARRAY_BUFFER, new Uint32Array(triangles), this.gl.STATIC_DRAW); 

        // Assignment 6a: Add Buffer for Normal-Vectors and put it to the attribute location normalAttributeLocation.
        this.normalBuffer = this.gl.createBuffer();
        this.gl.bindBuffer(this.gl.ARRAY_BUFFER, this.normalBuffer);
        this.gl.bufferData(this.gl.ARRAY_BUFFER, new Float32Array(normals), this.gl.STATIC_DRAW);

        this.gl.enableVertexAttribArray(normalAttributeLocation);
        this.gl.vertexAttribPointer(normalAttributeLocation, 3, this.gl.FLOAT, false, 0, 0);
    }

    /**
    * Draws a mesh with solid.
    */
    draw()
    {
        // Assignment 1d
        this.gl.bindVertexArray(this.vao);
        this.gl.drawElements(this.gl.TRIANGLES, this.nTriangleIndices, this.gl.UNSIGNED_INT, 0);
    }
}