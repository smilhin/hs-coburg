#version 300 es
precision highp float;

in vec4 outColor;

out vec4 fColor;

uniform float u_colorScale;


void main() 
{ 
  fColor = u_colorScale * outColor;
}