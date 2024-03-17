#version 330

layout (location = 0) in vec3 pos;
uniform mat4 model;
// uniform mat4 view;
uniform mat4 projection;

out vec4 vColour;

void main()
{
    // gl_Position = vec4(pos, 1.0);
    // gl_Position = model * view * projection * vec4(pos, 1.0);
    gl_Position = projection * model * vec4(pos, 1.0);
    // gl_Position = model * vec4(pos, 1.0);
    // gl_Position = model * vec4(pos, 1.0);
    // gl_Position = model * view * vec4(pos, 1.0);
    // vColour = vec4(pos, 1.0);
    // vColour = vec4(pos, 1.0);
    vColour = vec4(clamp(pos, 0, 1), 1.0);
}