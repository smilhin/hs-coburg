// @ts-check
export class TextureMap {
    /**
     * 
     * @param {WebGL2RenderingContext} gl WebGL rendering context
     * @param {number} unitParameter Zero-based index of the texture unit.
     */
    constructor(gl, unitParameter) {
        
        /** @type {WebGL2RenderingContext} */
        this.gl = gl;
    
        this.unit = unitParameter;
        this.useBilinearInterpolation = false;
        this.useMIPMapping = false;        
        this.width = 1;
        this.height = 1;
        
        this.texture = gl.createTexture();
        this.bind();
        let mipMapLevel = 0;
        let internalFormat  = this.gl.RGBA;
        let border = 0;
        let cpuData = new Uint8Array([255, 255, 255, 255]);
        let bytesPerChannel = gl.UNSIGNED_BYTE;
        let format = gl.RGBA;
        gl.texImage2D(gl.TEXTURE_2D, mipMapLevel, internalFormat, this.width, this.height, border, format,
                      bytesPerChannel, 
                      cpuData);        
        this.unbind();
    }

    /**
     * Loads a texture from a file
     * @param {string} filename Path to a texture filename.
     * @returns A promise that will return as soon as the texture has been loaded.
     */
    async loadTexture(filename)
    {     
        return new Promise(resolve => 
        {
            this.image = new Image();
            this.image.onload = () =>
            {
                this.loadTextureData();
                resolve(true);
            };
            this.image.src = filename;
        });
    }

    /**
     * Create a WebGL Texture from this.image.
     */
    loadTextureData  () {
        // Assignment 2b
       }

    /**
     * Binds the texture.
     */
    bind() {
        // Assignment 4b
        // Assignment 2a

        // Assignment 3b
    }

    /**
     * Binds the texture.
     */
    unbind() {
        // Assignment 4b
        // Assignment 2a
    }

    /**
     * Creates a texture that creates a checkerboard texture for in a different color.
     * @param {number} maxLevel Maximum number of MIP Map Levels
     */
    createDebugTexture(maxLevel)
    {
        // Assignment 4e
    }
}