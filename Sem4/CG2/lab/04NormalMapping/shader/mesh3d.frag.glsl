#version 300 es
precision highp float;

uniform bool u_useUniformColor;
uniform vec3 u_uniformColor;

in vec3 fs_color;
in vec3 fs_normal;
in vec3 fs_position;
in vec2 fs_texCoord;
in vec3 fs_tangent;
in vec3 fs_biTangent;

uniform vec3 u_ambient;
uniform vec3 u_diffuse;
uniform vec3 u_specular;
uniform float u_specularExponent;	

uniform bool u_useNormalMapping;
uniform bool u_useGramSchmidt;

uniform sampler2D u_textureA;
uniform sampler2D u_textureB;

out vec4 fragColor;

vec3 blinnPhong(vec3 lightVector, vec3 viewVector, vec3 normal,
		        vec3 ambientColor, vec3 diffuseColor, vec3 specularColor, float specularExponent)
{
	float nDotl        = max(dot(normal, lightVector), 0.0);			
	vec3 halfwayVector = normalize(lightVector + viewVector);
	float nDoth		   = max(dot(normal, halfwayVector),  0.0);	
	return ambientColor + nDotl * diffuseColor + specularColor * pow(nDoth, specularExponent);	
}

vec3 proj(vec3 u, vec3 v)
{
	return dot(u, v) * u  / dot(u, u);
}

mat3 onb(mat3 v)
{
	mat3 u = mat3(0);
	u[0] = v[0];
	u[1] = normalize(v[1] - proj(u[0], v[1]));
	u[2] = normalize(v[2] - proj(u[0], v[2]) - proj(u[1], v[2]));
	return u;
}

void main()
{




	vec3 lightPosition		  	= vec3(0.0, 0.0, 1.0);
	vec3 viewPosition 			= vec3(0,0,0);
	vec3 lightVector			= normalize(lightPosition - fs_position);
	vec3 viewVector				= normalize(viewPosition - fs_position);
	vec3 normal					= normalize(fs_normal);	

	vec3 colorA = texture(u_textureA, fs_texCoord).xyz;
	vec3 colorB = texture(u_textureB, fs_texCoord).xyz;	
	vec3 t = normalize(fs_tangent);
	vec3 b = normalize(fs_biTangent);
	vec3 n = normalize(fs_normal);
	if(u_useNormalMapping)
	{
		vec3 normalFromNormalMap = normalize(colorB * 2.0 - 1.0);
		if(!u_useGramSchmidt)
		{
			normal = normalize(transpose(inverse(mat3(t, b, n))) * normalFromNormalMap);			
		
		} else
		{		
		mat3 u = onb(mat3(t, b, n));
		normal = normalize(u * normalFromNormalMap);
		}
	}

	fragColor = vec4(blinnPhong(lightVector, viewVector, normal, u_ambient, colorA, u_specular, u_specularExponent), 1.0);		

  	
}