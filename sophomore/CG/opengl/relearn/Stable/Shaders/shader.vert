#version 330 core

layout (location = 0) in vec3 pos;
layout (location = 1) in vec2 aTexCoord;
layout (location = 2) in vec3 aNormal; // * not really use in vertex shader but need to pass to fragment shader

out vec4 vCol;
out vec2 TexCoord;
out vec3 FragPos;
out vec3 Normal;

uniform mat4 model;
uniform mat4 view;
uniform mat4 projection;

void main()
{
    gl_Position = projection * view * model * vec4(pos, 1.0);
    FragPos = vec3(model * vec4(pos, 1.0));
    vCol = vec4(clamp(pos, 0.0f, 1.0f), 1.0f);
    TexCoord = aTexCoord;
    Normal = aNormal;
}