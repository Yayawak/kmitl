#undef GLFW_DLL
#define GL_SILENCE_DEPRECATION
#include "../includes/nemo.h"



const GLint WIDTH = 800, HEIGHT = 600;
Window mainWindow;
std::vector<Mesh*> meshList;
std::vector<Shader*> shaderList;

static const char* vShader = "Shaders/shader.vert";
static const char* fShader = "Shaders/shader.frag";

glm::vec3 lightColour = glm::vec3(1.0f, 1.0f, 1.0f);
glm::vec3 lightPos = glm::vec3(3, 2, 0);

static const char* lightVShader = "Shaders/lightShader.vert";
static const char* lightFShader = "Shaders/lightShader.frag";
Shader *lightShader;
static std::vector<SceneObject*> objectList;


void CreateShaders()
{
    Shader* shader1 = new Shader();
    shader1->CreateFromFiles(vShader, fShader);
    shaderList.push_back(shader1);

    // Shader* shader2 = new Shader();
    // shader2->CreateFromFiles(lightVShader, lightFShader);
    // shaderList.push_back(shader2);

    lightShader = new Shader();
    lightShader->CreateFromFiles(lightVShader, lightFShader);
}

void createSuzannes()
{
    size_t n = 10;
    for (size_t i = 0; i < n; i++)
    {
        float degree = i * (360.f / n);
        float radius = 5.f;
        SceneObject* suz = new SceneObject(
            "../Textures/uvmap.png", "../Models/suzanne.obj", GL_RGBA, shaderList[0]);
        suz->position = glm::vec3(
            radius * cos(glm::radians(degree)),
            radius * sin(glm::radians(degree)),
            0
        );
        objectList.push_back(suz);
    }
}


int main()
{
    mainWindow = Window(WIDTH, HEIGHT, 3, 3);
    mainWindow.initialise();

    // light->CreateMeshFromOBJ("Models/cube.obj");
    CreateShaders();
    createSuzannes();
    


    SceneObject earth( "../Textures/cloth.jpg", "../Models/earth_triangulated.obj", GL_RGB, shaderList[0]);
    SceneObject light("../Textures/Set A/wood_table_001_diff_4k.jpg", "../Models/Wood block/block.obj", GL_RGB, lightShader);
    SceneObject madara("../Textures/_Madara_texture_main_mAIN.png","../Models/Madara_Uchiha.obj", GL_RGBA, shaderList[0]);
    SceneObject grass("../Textures/Grass2.jpg", "../Models/Grass.obj", GL_RGB, shaderList[0]);
    grass.position = glm::vec3(0.0f, -3.0f, 0.0f);
    // SceneObject tree("../Textures/Tree/Leaves0120_35_S.png", "../Models/Tree1.obj", GL_RGBA, shaderList[0]);
    // SceneObject tree("../Textures/uvmap.png", "../Models/Tree1.obj", GL_RGBA, shaderList[0]);


    initMainCamera(&mainWindow);
    Camera *camra = getMainCamera();
    while (!mainWindow.getShouldClose())
    {
        // * ------------- OBJECT SHADER  ---------------------
        shaderList[0]->UseShader();
        mainCamera->updateCamera();

        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);  
        // todo : Time & Camera ----------------------------------------------------------------------------------------------
        //Get + Handle user input events
        glfwPollEvents();
        keyboardControl(&mainWindow, mainCamera, shaderList[0]);

        // todo general  ----------------------------------------------------------------------------------------------

        //Clear window
        // glClearColor(0.9f, 0.9f, 0.9f, 1.0f);
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        // glClearColor(113.f/255.f, 203.f/255.f, 240.f/255.f, 1.0f); // blue
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);


        // printvec3<int>(lightcolour, "light color is ");
        glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightColour);
        glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat*)&lightPos);
        
        earth.position = glm::vec3(10, 10, -50);
        // earth.scale = glm::vec3(1, 1, 1);

        // lightPos += glm::vec3(0, 0, 1.f) * (100 * GetTikTok()->getDt());
        // float k = (1.f * GetTikTok()->getDt());
        // lightPos.y += k;
        // light.position = lightPos;
        // light.renderObject();
        // sky.renderObject();
        // plane.renderObject();
        
        // getMainWorld()->infinity();
        earth.renderObject();
        madara.renderObject();
        grass.renderObject();
        // tree.renderObject();

        for (size_t i = 0; i < objectList.size(); i++)
        {
            objectList[i]->renderObject();
        }

        // * ------------- LIGHT SHADER  ---------------------
        lightShader->UseShader();
        float k0 = (0.1 * sin(glfwGetTime()));
        float k1 = (0.1 * cos(glfwGetTime()));
        lightPos.x += k0;
        // lightPos.y += k1;
        // printf("z pos light : %f\n", lightPos.z);
        light.position = lightPos;
        glUniform3fv(lightShader->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightColour);
        light.renderObject();


        glUseProgram(0);

        GetTikTok()->setNewFrame();
        mainWindow.swapBuffers();
    }

    return 0;
}
