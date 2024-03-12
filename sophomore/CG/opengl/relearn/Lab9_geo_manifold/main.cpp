#undef GLFW_DLL
#define GL_SILENCE_DEPRECATION
#include "../includes/nemo.h"


const GLint WIDTH = 800, HEIGHT = 600;
float pitch = 0.0f, yaw = -90.0f;
Window mainWindow;
std::vector<Mesh*> meshList;
std::vector<Shader*> shaderList;

static const char* vShader = "Shaders/shader.vert";
static const char* fShader = "Shaders/shader.frag";

glm::vec3 lightcolour = glm::vec3(1.0f, 1.0f, 1.0f);
// glm::vec3 lightcolour = glm::vec3(0.3, 0, 0);
glm::vec3 lightPos = glm::vec3(-1.0f, 1.0f, 0.0f);

// Mesh* light = new Mesh();
static const char* lightVShader = "Shaders/lightShader.vert";
static const char* lightFShader = "Shaders/lightShader.frag";



void CreateShaders()
{
    Shader* shader1 = new Shader();
    shader1->CreateFromFiles(vShader, fShader);
    shaderList.push_back(shader1);

    Shader* shader2 = new Shader();
    shader2->CreateFromFiles(lightVShader, lightFShader);
    shaderList.push_back(shader2);
}
// struct SBunder *bunder = new SBunder();

int main()
{
    mainWindow = Window(WIDTH, HEIGHT, 3, 3);
    mainWindow.initialise();

    CreateOBJ(meshList);
    CreateShaders();
    float lastFrame;

    GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;
    // glm::mat4 projection = glm::perspective(45.0f, (GLfloat)mainWindow.getBufferWidth() / (GLfloat)mainWindow.getBufferHeight(), 0.1f, 100.0f);
    glm::mat4 projection = glm::perspective(45.0f, (GLfloat)mainWindow.getBufferWidth() / (GLfloat)mainWindow.getBufferHeight(), 0.1f, 500.0f);
    
    // glm::vec3 cameraPos = glm::vec3(0.0f, 0.0f, 5.0f);
    // glm::vec3 cameraPos = glm::vec3(0.0f, 2.0f, 10.0f);
    glm::vec3 cameraPos = glm::vec3(0.0f, 2.0f, 7.0f);
    glm::vec3 cameraTarget = glm::vec3(0.0f, 0.0f, -1.0f);
    glm::vec3 cameraDirection = glm::normalize(cameraTarget - cameraPos);
    
    glm::vec3 up = glm::vec3(0.0f, 1.0f, 0.0f);
    glm::vec3 cameraRight = glm::normalize(glm::cross(cameraDirection, up));
    glm::vec3 cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));

    
    SceneObject ratata("../Textures/rattata.png", "../Models/rattata.obj", GL_RGBA);
    ratata.scaleXYZObject(0.1);

    SceneObject light("../Textures/uvmap.png", "../Models/cube.obj", GL_RGBA);
    SceneObject cube("../Textures/uvmap.png", "../Models/cube.obj", GL_RGBA);

    SceneObject sky("../Textures/SkyTexture_PNG/SkyBoxTextureLayer4.png", "../Models/cube.obj", GL_RGBA);
    sky.scaleXYZObject(100);

    // SceneObject plane("Textures/piper_diffuse.jpg","Models/plane_2.obj", GL_RGB);

    while (!mainWindow.getShouldClose())
    {
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  
        // todo : Time & Camera ----------------------------------------------------------------------------------------------
        //Get + Handle user input events
        glfwPollEvents();
        keyboardControl(mainWindow, cameraPos, cameraDirection, cameraRight, &lastFrame);
        // checkMouse(mainWindow, &yaw, &pitch);

        glm::vec3 direction;
        direction.x = cos(glm::radians(pitch)) * cos(glm::radians(yaw));
        direction.y = sin(glm::radians(pitch));
        direction.z = cos(glm::radians(pitch)) * sin(glm::radians(yaw));
        cameraDirection = glm::normalize(direction);

        glm::vec3 cameraRight = glm::normalize(glm::cross(cameraDirection, up));
        glm::vec3 cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));

        // lightPos.x = sin(glfwGetTime()) *0.8f;
        // lightPos.y = sin(glfwGetTime() / 2.0f) *0.8f;
        glm::mat4 view (1.0f);
        view = glm::lookAt(cameraPos, cameraPos+cameraDirection, cameraUp);

        // todo general  ----------------------------------------------------------------------------------------------

        //Clear window
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

        shaderList[0]->UseShader();
        uniformView = shaderList[0]->GetUniformLocation("view");
        uniformModel = shaderList[0]->GetUniformLocation("model");
        uniformProjection = shaderList[0]->GetUniformLocation("projection");

        bunder()->view = &view;
        bunder()->projection = &projection;
        bunder()->uniformModel = &uniformModel;
        bunder()->uniformView = &uniformView;
        bunder()->uniformProjection = &uniformProjection;

        // printvec3<int>(lightcolour, "light color is ");
        glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightcolour);
        glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat*)&lightPos);


        // todo : rendering
        cube.renderObject();


        glUseProgram(0);

        GetTikTok()->setNewFrame();
        mainWindow.swapBuffers();
    }

    return 0;
}
