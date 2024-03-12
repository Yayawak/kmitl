//Fragment Shader
#version 330 core

in vec4 vCol;
in vec2 TexCoord;
out vec4 colour;
in vec3 Normal;

in vec3 FragPos;
uniform sampler2D texture2D;
uniform vec3 lightPos;
uniform vec3 lightColour;
uniform vec3 viewPos;

// ! ok tested
vec3 ambientLight(){
    float ambientStrength = 0.3f;
    vec3 ambient = ambientStrength * lightColour;
    // vec3 ambient = ambientStrength * vec3(1, 0, 0);
    return ambient;
}

// ! not ok lol
vec3 diffuseLight(){
    //lamberd's law ? maybe
    float diffuseStrength = 0.0f;
    vec3 norm = normalize(Normal);
    vec3 lightDir = normalize(lightPos - FragPos);

    float diff = max(dot(norm, lightDir), 0);
    vec3 diffuse = diffuseStrength * lightColour * diff;
    return diffuse;

    // vec3 norm = normalize(Normal);
    // vec3 lightDir = normalize(lightPos - FragPos);
    // float diffuseStrength = max(dot(norm, lightDir), 0.0);
    // vec3 diffuse = diffuseStrength * lightColor;
    // return diffuse;
}

// ! not ok lol
vec3 specularLight()
{
    // float specularStrength = 0.8f;
    // float shininess = 24.0f;
    float specularStrength = 0.1f;
    float shininess = 0;
    vec3 lightDir = normalize(lightPos - FragPos);
    vec3 norm = normalize(Normal);
    vec3 reflectDir = reflect(-lightDir, norm);
    vec3 viewDir = normalize(viewPos - FragPos);

    //phong
    float spec = pow(max(dot(viewDir, reflectDir), 1.0f), shininess);

    //blinn-phong
    // vec3 halfDir = (lightDir+viewDir) / 2.0f;
    // float spec = pow(max(dot(halfDir, norm), 0.0f), shininess);

    vec3 specular = specularStrength * lightColour * spec;
    return specular;
}

vec4 calculateProneLight()
{
    // * ambient light
    float ambientStrength = 0.7f;
    vec3 ambient = ambientStrength * lightColour;

    // * diffuse light
    vec3 norm = normalize(Normal);
    vec3 lightDir = normalize(lightPos - FragPos);
    float diffuseStrength = max(dot(norm, lightDir), 0.0);
    vec3 diffuse = diffuseStrength * lightColour;

    // * specular
    float specularStrength = 0.7f;
    vec3 viewDir = normalize(viewPos - FragPos);
    vec3 reflectDir = reflect(-lightDir, norm);
    float spec = pow(max(dot(viewDir, reflectDir), 0.0), 32);
    vec3 specular = specularStrength * spec * lightColour;

    // vec3 result = (ambient + diffuse + specular) * vec3(vCol.x, vCol.y, vCol.z);
    vec3 result = (ambient + diffuse + specular) * vec3(1);
    return (vec4(result, 1.0));
}


void main()
{
    //colour = vCol;
    // colour = texture(texture2D, TexCoord) * vec4(ambientLight(), 1.0f);
    // colour = texture(texture2D, TexCoord) * vec4(ambientLight() + diffuseLight(), 1.0f);
    // colour = texture(texture2D, TexCoord) * vec4(ambientLight()+diffuseLight()+specularLight(), 1.0f);
    // colour = texture(texture2D, TexCoord);
    // colour = texture(texture2D, TexCoord) * vec4(ambientLight() + specularLight(), 1.0f);

    colour = calculateProneLight() * texture(texture2D, TexCoord);
}