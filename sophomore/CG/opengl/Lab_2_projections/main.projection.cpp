#define GL_SILENCE_DEPRECATION

#undef GLFW_DLL
#include <iostream>
#include <stdio.h>
#include <string>
#include <string.h>

#include <GL/glew.h>
#include <GLFW/glfw3.h>

#include <vector>
#include <cmath>

#include "../Libs/Shader.h"
#include "../Libs/Window.h"
#include "../Libs/Mesh.h"

// #include "Libs/Shader.h"
// #include "Libs/Window.h"
// #include "Libs/Mesh.h"
#include <glm/glm.hpp>
#define GLM_FORCE_RADIANS
// * for translate / rotate / scale function
#include <glm/gtc/matrix_transform.hpp>
// * for glm::value_ptr
#include "glm/ext.hpp"

const GLint WIDTH = 800, HEIGHT = 600;

Window mainWindow;
std::vector<Mesh*> meshList;
std::vector<Shader> shaderList;

// static const char* vShader = "./Shaders/shader.vert";
// static const char* fShader = "./Shaders/shader.frag";

static const char* vShader = "/Users/kiokize/Desktop/kmitl/sophomore/CG/opengl/Lab_2_projections/Shaders/shader.vert";
static const char* fShader = "/Users/kiokize/Desktop/kmitl/sophomore/CG/opengl/Lab_2_projections/Shaders/shader.frag";

void CreateTriangle()
{
    GLfloat vertices[] =
    {
        -1.0f, -1.0f, 0.0f,
        1.0f, -1.0f, 0.0f,
        0.0f, 1.0f, 0.0f
    };

    // GLfloat colors[] = {
    //     1, 0, 0, 1,  // Red color, for the first vertex
    //     0, 1, 0, 1,  // Green color, for the second vertex
    //     0, 0, 1, 1   // Blue color, for the third vertex
    // };
    // GLuint vboColID;
    // glGenBuffers(sizeof(colors), &vboColID);
    // glBindBuffer(GL_ARRAY_BUFFER, vboColID);
    // glBufferData(GL_ARRAY_BUFFER, sizeof(colors), GL_STATIC_DRAW);

    // glVertexAttribPointer(1, 4, GL_FLOAT, false, 0, 0);
    // glEnableVertexAttribArray(1);

    unsigned int indices[] = 
    {
        0, 1, 2,
    };

    Mesh *obj1 = new Mesh();
    obj1->CreateMesh(vertices, indices, 9, 9);
    // meshList.push_back(obj1);

    for (int i = 0; i < 10; i++)
    {
        meshList.push_back(obj1);
    }
}

void CreateShaders()
{
    Shader* shader1 = new Shader();
    shader1->CreateFromFiles(vShader, fShader);
    shaderList.push_back(*shader1);
}

int main()
{
    mainWindow = Window(WIDTH, HEIGHT, 3, 3);
    mainWindow.initialise();

    CreateTriangle();
    CreateShaders();

    //for secret room 3 enter - https://forms.gle/U9VE4pkYAPNvUW1H9 

    // ? perspective prj
    glm::mat4 projection = glm::perspective(45.0f, (GLfloat) mainWindow.getBufferWidth() /
        (GLfloat)mainWindow.getBufferHeight(), 0.1f, 100.0f);
    // ? ortho prj
    // glm::mat4 projection = glm::ortho(-4.0f, 4.0f, -3.0f, 3.0f, 0.1f, 100.0f);

    //Loop until window closed
    while (!mainWindow.getShouldClose())
    {

        GLuint uniformModel = shaderList[0].GetUniformLocation("model");
        GLuint uniformProjection = shaderList[0].GetUniformLocation("projection");

        // Get + Handle user input events
        glfwPollEvents();

        // Clear window
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        // draw here
        shaderList[0].UseShader();


        // todo : this is centers of pyramid -> will be used when translatino next...
        glm::vec3 pyramidPositions[] =
        {
            glm::vec3(0.0f, 0.0f, -2.5f),
            glm::vec3(2.0f, 5.0f, -15.0f),
            glm::vec3(-1.5f, -2.2f, -2.5f),
            glm::vec3(-3.8f, -2.0f, -12.3f),
            glm::vec3(2.4f, -0.4f, -3.5f),
            glm::vec3(-1.7f, 3.0f, -7.5f),
            glm::vec3(1.3f, -2.0f, -2.5f),
            glm::vec3(1.5f, 2.0f, -2.5f),
            glm::vec3(1.5f, 0.2f, -1.5f),
            glm::vec3(-1.3f, 1.0f, -1.5f)
        };

        GLuint uniformView = shaderList[0].GetUniformLocation("view");
        glm::mat4 view (1.0f);
        // * this section is for cam
        // glm::vec3 cameraPos = glm::vec3(0.0f, 0.0f, 10.0f);
        glm::vec3 cameraPos = glm::vec3(1.0f, 0.5f, 2.0f);
        glm::vec3 cameraTarget = glm::vec3(0.0f, -0.3f, -1.0f);
        glm::vec3 up = glm::vec3(0.0f, 1.0f, 0.0f);
        glm::vec3 cameraDirection = glm::normalize(cameraTarget - cameraPos);
        glm::vec3 cameraRight = glm::normalize(glm::cross(cameraDirection, up));
        glm::vec3 cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));

        // glm::mat4 cameraPosMat (1.0f);
        // cameraPosMat[3][0] = -cameraPos.x;
        // cameraPosMat[3][1] = -cameraPos.y;
        // cameraPosMat[3][2] = -cameraPos.z;
        // glm::mat4 cameraRotateMat(1.0f);
        // cameraRotateMat[0] = glm::vec4(cameraRight.x, cameraUp.x, -cameraDirection.x, 0.0f);
        // cameraRotateMat[1] = glm::vec4(cameraRight.y, cameraUp.y, -cameraDirection.y, 0.0f);
        // cameraRotateMat[2] = glm::vec4(cameraRight.z, cameraUp.z, -cameraDirection.z, 0.0f);
        // view = cameraRotateMat * cameraPosMat;
        view = glm::lookAt(cameraPos, cameraPos + cameraDirection, cameraUp);
        // * end section for cam


        for (int i = 0; i < 10; i++)
        {
            glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

            glm::mat4 model(1.0f);
            model = glm::translate(model, pyramidPositions[i]);
            model = glm::rotate(model, glm::radians(2.0f * i), glm::vec3(1.0f, 0.3f, 0.5f));
            model = glm::scale(model, glm::vec3(0.8f, 0.8f, 1.0f));
            glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
            glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));
            meshList[i]->RenderMesh();
        }

        // Object
        // meshList[0]->RenderMesh();

        glUseProgram(0);
        // end draw

        // magic word - SAKURA

        mainWindow.swapBuffers();
    }

    return 0;
}
