//@ts-check
/**
 * A class that clears the screen of a WebGL2 rendering context.
 */


export class ClearScreen {  
  /**
   * The sychronous constructor.
   */

  constructor()
  { 
    this.mCanvas = document.getElementById('canvas');
    /** @type { WebGL2RenderingContext } */ 
    //@ts-ignore
    this.gl = this.mCanvas.getContext("webgl2"); 
  }

  /**
   * Call this function explicitly after the synchronous constructor.
   * After called from the outside, wait 
   */
  async setup() 
  {    

    let mCanvas = null;

  }

  /**
   * Call this function to trigger rendering of the next frame.
   * You must call it
   * - Right after setup() has finished.
   * - To issue the next frame, at the very bottom of your draw()-method.
   */
  nextFrame()
  {
    requestAnimationFrame(this.draw.bind(this));
  }

  /**
   * Draws a single frame. Call your WebGL functions here.
   * The last line of this function should be this.nextFrame();
   */
  draw() {    
    // Assignment 4b)
    this.gl.clearColor(1.0, 1.0, 0.0, 1.0);
    this.gl.clear(this.gl.COLOR_BUFFER_BIT);

    // Issue the draw command as often as possible.
    this.nextFrame();
    
  }
}

let t = new ClearScreen();
let setupDone = t.setup();

await setupDone;

t.nextFrame();

