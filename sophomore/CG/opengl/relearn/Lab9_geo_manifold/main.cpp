#undef GLFW_DLL
#define GL_SILENCE_DEPRECATION
#include "../includes/nemo.h"


const GLint WIDTH = 800, HEIGHT = 600;
// float pitch = 0.0f, yaw = -90.0f;
Window mainWindow;
std::vector<Mesh*> meshList;
// std::vector<Shader*> shaderList;

static const char* vShader = "Shaders/shader.vert";
static const char* fShader = "Shaders/shader.frag";

glm::vec3 lightcolour = glm::vec3(1.0f, 1.0f, 1.0f);
// glm::vec3 lightcolour = glm::vec3(0.3, 0, 0);
glm::vec3 lightPos = glm::vec3(-1.0f, 1.0f, 0.0f);


Shader *objectShader = NULL;
void CreateShaders()
{
    Shader* shader1 = new Shader();
    shader1->CreateFromFiles(vShader, fShader);
    // shaderList.push_back(shader1);
    objectShader = shader1;
}



int main()
{
    mainWindow = Window(WIDTH, HEIGHT, 3, 3);
    mainWindow.initialise();

    CreateShaders();

    GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;

    SceneObject cube("../Textures/uvmap.png", "../Models/cube.obj", GL_RGBA, objectShader);

    initMainCamera(&mainWindow);
    Camera *camera = getMainCamera();


    while (!mainWindow.getShouldClose())
    {
        objectShader->UseShader();
        glfwPollEvents();
        keyboardControl(mainWindow, camera);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        // // checkMouse(mainWindow, &yaw, &pitch);
        camera->updateCamera();


        glm::mat4 view (1.0f);
        view = glm::lookAt(camera->position, camera->position + camera->cameraDirection, camera->cameraUp);

        uniformView = objectShader->GetUniformLocation("view");
        glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));
        cube.renderObject();
        cube.translateXYZObject(sin(glfwGetTime() * 4) * 1 * GetTikTok()->getDt(), 0, 0);
        glUseProgram(0);

        GetTikTok()->setNewFrame();
        mainWindow.swapBuffers();
    }

    return 0;
}
