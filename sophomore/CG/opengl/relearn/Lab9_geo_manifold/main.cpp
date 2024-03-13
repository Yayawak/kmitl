#undef GLFW_DLL
#define GL_SILENCE_DEPRECATION
#include "../includes/nemo.h"


const GLint WIDTH = 800, HEIGHT = 600;
// float pitch = 0.0f, yaw = -90.0f;
Window mainWindow;
std::vector<Mesh*> meshList;
std::vector<Shader*> shaderList;

static const char* vShader = "Shaders/shader.vert";
static const char* fShader = "Shaders/shader.frag";

glm::vec3 lightcolour = glm::vec3(1.0f, 1.0f, 1.0f);
// glm::vec3 lightcolour = glm::vec3(0.3, 0, 0);
glm::vec3 lightPos = glm::vec3(-1.0f, 1.0f, 0.0f);


void CreateShaders()
{
    Shader* shader1 = new Shader();
    shader1->CreateFromFiles(vShader, fShader);
    shaderList.push_back(shader1);

    // Shader* shader2 = new Shader();
    // shader2->CreateFromFiles(lightVShader, lightFShader);
    // shaderList.push_back(shader2);
}

int main()
{
    mainWindow = Window(WIDTH, HEIGHT, 3, 3);
    mainWindow.initialise();

    // CreateOBJ(meshList);
    CreateShaders();
    float lastFrame;

    GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;
    glm::mat4 projection = glm::perspective(45.0f, (GLfloat)mainWindow.getBufferWidth() / (GLfloat)mainWindow.getBufferHeight(), 0.1f, 100.0f);
    // glm::mat4 projection = glm::perspective(45.0f, (GLfloat)mainWindow.getBufferWidth() / (GLfloat)mainWindow.getBufferHeight(), 0.1f, 500.0f);

    auto tt = getTexture("../Textures/uvmap.png", GL_RGBA);
    SceneObject cube("../Textures/uvmap.png", "../Models/cube.obj", GL_RGBA, shaderList[0]);
    Camera *camera = new Camera();
    // Mesh *triangle = CreateTriangleMesh();
    // AddTriangle(meshList);
    // AddTriangle(meshList);
    // AddTriangle(meshList);
    // std::cout << meshList.size() << std::endl;


    while (!mainWindow.getShouldClose())
    {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  
        // todo : Time & Camera ----------------------------------------------------------------------------------------------
        //Get + Handle user input events
        glfwPollEvents();
        keyboardControl(mainWindow, camera);
        // // checkMouse(mainWindow, &yaw, &pitch);

        camera->updateCamera();

        glm::mat4 view (1.0f);
        view = glm::lookAt(camera->position, camera->position + camera->cameraDirection, camera->cameraUp);

        // todo general  ----------------------------------------------------------------------------------------------

        //Clear window
        glClearColor(0.1f, 0.1f, 0.0f, 1.0f);
        // glClearColor(1.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        shaderList[0]->UseShader();
        uniformView = shaderList[0]->GetUniformLocation("view");
        // uniformModel = shaderList[0]->GetUniformLocation("model");

        uniformProjection = shaderList[0]->GetUniformLocation("projection");
        glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));

        glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

        // bunder()->view = &view;
        // bunder()->projection = &projection;
        // bunder()->uniformModel = &uniformModel;
        // bunder()->uniformView = &uniformView;
        // bunder()->uniformProjection = &uniformProjection;

        // printvec3<int>(lightcolour, "light color is ");
        // glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightcolour);
        // glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat*)&lightPos);

        // cube.translateXYZObject(0.1f, 0, 0);
        // cube.translateXYZObject(0.1f * GetTikTok()->getDt(), 0, 0);

        // todo : rendering
        cube.renderObject();
        // glActiveTexture(GL_TEXTURE0);
        // glBindTexture(GL_TEXTURE_2D, tt);
        // triangle->RenderMesh();
        // meshList[0]->RenderMesh();

        // std::cout << meshList.size() << std::endl;


        glUseProgram(0);

        GetTikTok()->setNewFrame();
        mainWindow.swapBuffers();
    }

    return 0;
}
