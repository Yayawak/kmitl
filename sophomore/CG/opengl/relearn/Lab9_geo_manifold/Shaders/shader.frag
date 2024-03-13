//Fragment Shader
#version 330 core

in vec4 vColour;

out vec4 colour;

uniform sampler2D texture2D;

void main()
{
    colour = vColour;
    // colour = texture(texture2D, TexCoord);
    // colour = vec4(1.0, 1.0, 0.0, 1.0);
}