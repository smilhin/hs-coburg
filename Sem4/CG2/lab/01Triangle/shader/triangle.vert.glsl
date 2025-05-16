#version 300 es

layout (location = 0) 
in vec4 inVertex;
in vec4 inColor;

out vec4 outColor;

uniform float u_vertexScale;

void main() 
{

  gl_Position = vec4(u_vertexScale * inVertex.xyz, 1.0);
  outColor = inColor;

}