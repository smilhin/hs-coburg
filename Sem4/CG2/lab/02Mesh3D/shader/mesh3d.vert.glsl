#version 300 es
precision highp float;

// Assignment 1g: Vertex Attribute for positions
layout (location = 0)
in vec3 a_position;
// Assignment 6b: Vertex Attribute for normals
layout (location = 2)
in vec3 a_normal;
// Assignment 6c: out-variable for normals
out vec3 fs_normal;
// Assignment 7b: out-variable for positions
out vec4 fs_position;
// Assignment 3c: Declare model-view projection matrix here in the shader.
uniform mat4 u_mvp;
// Assignment 7a: Pass Model-View matrix to shader 
uniform mat4 u_mvm;

void main()
{   
    
    gl_Position =u_mvp * vec4(a_position, 1);

    // Assignment 6c: Pass a_normal to fs_normal
    fs_normal = mat3(transpose(inverse(u_mvm))) * a_normal;;

    // Assignment 7b: transform normal and position to camera-space.
    fs_position = u_mvm * vec4(a_position, 1);
}