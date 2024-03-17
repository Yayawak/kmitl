//Fragment Shader
#version 330 core

in vec4 vCol;
in vec2 TexCoord;
in vec3 FragPos;
in vec3 Normal;


uniform sampler2D texture2D;
uniform vec3 lightPos;
uniform vec3 lightColour;
uniform float ambientStrength = 1;

uniform vec3 cameraPos;

out vec4 colour;

// ความมันเงา
vec3 specularLight()
{
    float specularStrength = 0.8;
    float shininess = 64.0f;

    vec3 viewDir  = normalize(cameraPos - FragPos);
    vec3 lightDir  = normalize(lightPos - FragPos);
    vec3 norm = normalize(Normal);
    // * the more far away the light is, the less it affects the specular
    vec3 reflectDir = reflect(-lightDir, norm);
    // ! this is Phong Shading
    // float spec = max(dot(reflectDir, viewDir), 0.0);
    // spec = pow(spec, shininess);
    // ! this is Blinn-Phong Shading
    vec3 halfDir = (viewDir + lightDir) / 2;
    float spec = max(dot(halfDir, norm), 0.0);
    spec = pow(spec, shininess);


    vec3 specular = specularStrength * lightColour * spec;
    return specular;
}

vec3 diffuseLight()
{
    // * fragPos is each vertices
    vec3 lightDir = normalize(lightPos - FragPos);
    vec3 norm = normalize(Normal); // ? prevent if input Normal vector is not really normal
    // * need angle between lightDir and norm so we get theta angle
    // * use dot product to get cosine of angle
    float scalarAngle = dot(lightDir, norm);
    // ? prevent negative angle (neg angle mean 2 vector are run away from each other)
    // ? so we need to prevent that case to use darkest value as 0
    scalarAngle = max(scalarAngle, 0.0f);

    // * calculate real light-color
    // ? the more near the light source is, the more the light-color will be
    // ? the less angle the more light intensity
    vec3 diffuseColorVec = scalarAngle * lightColour;
    // * add some strenght of diffuse light
    float strength = 0.8f;
    // float strength = 10;
    // float strength = 20;
    diffuseColorVec *= strength;
    return diffuseColorVec;
}

vec3 ambientLight()
{
    // float ambientStrength = 0.5;
    vec3 amb = lightColour * ambientStrength;
    return amb;
}

vec3 compoundLight()
{
    vec3 ret = ambientLight() + diffuseLight() + specularLight();
    return ret;
}

void main()
{
    colour = texture(texture2D, TexCoord) * vec4(compoundLight(), 1.0f);
    // colour = texture(texture2D, TexCoord) * vec4(specularLight(), 1);
    // colour = texture(texture2D, TexCoord) * vec4(ambientLight() + diffuseLight(), 1.0f);
    // colour = texture(texture2D, TexCoord) * vec4(diffuseLight(), 1.0f);
}