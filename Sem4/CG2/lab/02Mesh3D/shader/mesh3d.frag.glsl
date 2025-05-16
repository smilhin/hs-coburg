#version 300 es
precision highp float;

// Assignment 6c: in-variable for normals
in vec3 fs_normal;
// Assignment 7b: in-variable for positions
in vec4 fs_position;
// Assignment 8b: Parameters of Blinn-Phong model as uniform variables.
uniform float u_spec;
uniform vec3 u_ambient;
uniform vec3 u_diffuse;
uniform vec3 u_scol;

out vec4 fragColor;

void main()
{
	//Normalize the normals
	vec3 normal = normalize(fs_normal);

	/* 
	* Compute the Light Direction - lightDir, normalize: Light Position (0, 0, 0) - Position = -fs.position
	* Compute View Direction - viewDir, , normalize: Camera Position (0, 0, 0) - Position = -fs.position
	*/
    vec3 lightDir = normalize(-fs_position.xyz);
    vec3 viewDir = normalize(-fs_position.xyz);

	vec3 ambient = u_ambient;
    
    float diff = max(dot(normal, lightDir), 0.0);
    vec3 diffuse = diff * u_diffuse;
    
    vec3 halfwayDir = normalize(lightDir + viewDir);
    float spec = pow(max(dot(normal, halfwayDir), 0.0), u_spec);
    vec3 specular = spec * u_scol;
       
    vec3 color = ambient + diffuse + specular;
    
    // Output Final Color
    fragColor = vec4(color, 1.0);

}