// #undef GLFW_DLL
// #include <iostream>
// #include <stdio.h>
// #include <string>
// #include <string.h>

// #include <GL/glew.h> 
// #include <GLFW/glfw3.h>

// #include <vector>
// #include <cmath>

// #include "Libs/Shader.h"
// #include "Libs/Window.h"
// #include "Libs/Mesh.h"
// #include "Libs/stb_image.h"

// #include <glm/glm.hpp>
// #include <glm/gtc/matrix_transform.hpp>
// #include <glm/gtc/type_ptr.hpp>


// const GLint WIDTH = 800, HEIGHT = 600;
// float pitch = 0.0f, yaw = -90.0f;
// Window mainWindow;
// std::vector<Mesh*> meshList;
// std::vector<Shader*> shaderList;

// //Vertex Shader
// static const char* vShader = "Shaders/shader.vert";

// //Fragment Shader
// static const char* fShader = "Shaders/shader.frag";

// glm::vec3 lightcolour = glm::vec3(1.0f, 1.0f, 1.0f);

// Mesh* light;
// static const char* lightVShader = "Shaders/lightShader.vert";
// static const char* lightFShader = "Shaders/lightShader.frag";


// void CreateTriangle()
// {
//     GLfloat vertices[] =
//     {
//         -1.0f, -1.0f, 0.0f,   0.0f, 0.0f,
//         0.0f, -1.0f, 1.0f,   0.5f, 0.0f,
//         1.0f, -1.0f, 0.0f,   1.0f, 0.0f,
//         0.0f, 1.0f, 0.0f,   0.5f, 1.0f
//     };
    
//     unsigned int indices[] = 
//     {
//         0, 3, 1,
//         1, 3, 2,
//         2, 3, 0,
//         0, 1, 2
//     };

//     Mesh *obj1 = new Mesh();
//     obj1->CreateMesh(vertices, indices, 20, 20);

//     meshList.push_back(obj1);
    
// }
// void CreateOBJ(){
//     Mesh *obj1 = new Mesh();
//     bool loaded = obj1 -> CreateMeshFromOBJ("Models/conan (1).obj");

//     if(loaded){
//         meshList.push_back(obj1);
//     }else{
//         std::cout << "Failed to load models";
//     }

//     light = new Mesh();
//     loaded = light -> CreateMeshFromOBJ("Models/cube.obj");
//     if(!loaded){
//         std::cout << "Failed to load models";
//     }
//     meshList.push_back(light);

//     Mesh *table = new Mesh();
//     loaded = table -> CreateMeshFromOBJ("Models/table_conan_tri.obj");
//     if(!loaded){
//         std::cout << "Failed to load models";
//     }
//     meshList.push_back(table);

//     Mesh *pic = new Mesh();
//     loaded = pic -> CreateMeshFromOBJ("Models/pic.obj");
//     if(!loaded){
//         std::cout << "Failed to load models";
//     }
//     meshList.push_back(pic);


// }
// void CreateShaders()
// {
//     Shader* shader1 = new Shader();
//     shader1->CreateFromFiles(vShader, fShader);
//     shaderList.push_back(shader1);

//     Shader* shader2 = new Shader();
//     shader2->CreateFromFiles(lightVShader, lightFShader);
//     shaderList.push_back(shader2);
// }
// void checkMouse() 
// {
//     float xoffset, yoffset;
//     double xpos, ypos;
//     glfwGetCursorPos(mainWindow.getWindow(), &xpos, &ypos);

//     static float lastX = xpos;
//     static float lastY = ypos;

//     xoffset = xpos - lastX;
//     yoffset = lastY - ypos;

//     lastX = xpos;
//     lastY = ypos;

//     float sensitivity = 0.12f;
//     xoffset *= sensitivity;
//     yoffset *= sensitivity;

//     yaw += xoffset;
//     pitch += yoffset;

//     if (pitch > 89) pitch = 89;
//     if (pitch < -89) pitch = -89;
    
// }
// int main()
// {
//     mainWindow = Window(WIDTH, HEIGHT, 3, 3);
//     mainWindow.initialise();

//     CreateOBJ();
//     CreateShaders();

//     GLuint uniformModel = 0, uniformProjection = 0, uniformView = 0;
//     glm::mat4 projection = glm::perspective(45.0f, (GLfloat)mainWindow.getBufferWidth() / (GLfloat)mainWindow.getBufferHeight(), 0.1f, 100.0f);
    
//     glm::vec3 cameraPos = glm::vec3(0.0f, 0.0f, 5.0f);
//     glm::vec3 cameraTarget = glm::vec3(0.0f, 0.0f, -1.0f);
//     glm::vec3 cameraDirection = glm::normalize(cameraTarget - cameraPos);
    
//     glm::vec3 up = glm::vec3(0.0f, 1.0f, 0.0f);
//     glm::vec3 cameraRight = glm::normalize(glm::cross(cameraDirection, up));
//     glm::vec3 cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));
    
//     float deltaTime, lastFrame;
//     int width, height, nrChannels;
//     unsigned char *data = stbi_load("Textures/conan_texture.png", &width, &height, &nrChannels,0);

//     //texture1
//     unsigned int texture;
//     glGenTextures(1, &texture);
//     glBindTexture(GL_TEXTURE_2D, texture);

//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

//     if (data)
//     {
//         glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE,
//         data);
//         glGenerateMipmap(GL_TEXTURE_2D);
//     }
//     else
//     {
//         std::cout<<"Failed to load texture"<<std::endl;
//     }
//     stbi_image_free(data);

//     //texture2
//     data = stbi_load("Textures/R.jpeg", &width, &height, &nrChannels,0);
//     unsigned int texture2;
//     glGenTextures(1, &texture2);
//     glBindTexture(GL_TEXTURE_2D, texture2);

//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

//     if (data)
//     {
//         glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE,
//         data);
//         glGenerateMipmap(GL_TEXTURE_2D);
//     }
//     else
//     {
//         std::cout<<"Failed to load texture"<<std::endl;
//     }
//     stbi_image_free(data);

//     //texture3
//     data = stbi_load("Textures/wood_table.jpg", &width, &height, &nrChannels,0);
//     unsigned int texture3;
//     glGenTextures(1, &texture3);
//     glBindTexture(GL_TEXTURE_2D, texture3);

//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

//     if (data)
//     {
//         glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE,
//         data);
//         glGenerateMipmap(GL_TEXTURE_2D);
//     }
//     else
//     {
//         std::cout<<"Failed to load texture"<<std::endl;
//     }
//     stbi_image_free(data);

//     //texture4
//     data = stbi_load("Textures/pottriat.jpg", &width, &height, &nrChannels,0);
//     unsigned int texture4;
//     glGenTextures(1, &texture4);
//     glBindTexture(GL_TEXTURE_2D, texture4);

//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR_MIPMAP_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
//     glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);

//     if (data)
//     {
//         glTexImage2D(GL_TEXTURE_2D, 0, GL_RGB, width, height, 0, GL_RGB, GL_UNSIGNED_BYTE,
//         data);
//         glGenerateMipmap(GL_TEXTURE_2D);
//     }
//     else
//     {
//         std::cout<<"Failed to load texture"<<std::endl;
//     }
//     stbi_image_free(data);

//     //Loop until window closed
//     while (!mainWindow.getShouldClose())
//     {
//         // todo : Time & Camera ----------------------------------------------------------------------------------------------
//         float curentFrame = glfwGetTime();
//         deltaTime = curentFrame - lastFrame;
//         lastFrame = curentFrame;
//         //Get + Handle user input events
//         glfwPollEvents();

//         // if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_W) == GLFW_PRESS){
//         //     cameraPos += cameraDirection * deltaTime * 5.0f;
//         // }
//         // if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_S) == GLFW_PRESS){
//         //     cameraPos -= cameraDirection* deltaTime * 5.0f;
//         // }
//         // if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_A) == GLFW_PRESS){
//         //     cameraPos -= cameraRight * deltaTime * 5.0f;
//         // }
//         // if(glfwGetKey(mainWindow.getWindow(), GLFW_KEY_D) == GLFW_PRESS){
//         //     cameraPos += cameraRight * deltaTime * 5.0f;
//         // }
//         // checkMouse();

//         glm::vec3 direction;
//         direction.x = cos(glm::radians(pitch)) * cos(glm::radians(yaw));
//         direction.y = sin(glm::radians(pitch));
//         direction.z = cos(glm::radians(pitch)) * sin(glm::radians(yaw));
//         cameraDirection = glm::normalize(direction);

//         glm::vec3 cameraRight = glm::normalize(glm::cross(cameraDirection, up));
//         glm::vec3 cameraUp = glm::normalize(glm::cross(cameraRight, cameraDirection));

//         glm::vec3 lightPos = glm::vec3(-1.0f, 1.0f, 0.0f);
//         // lightPos.x = sin(glfwGetTime()) *0.8f;
//         // lightPos.y = sin(glfwGetTime() / 2.0f) *0.8f;

//         // todo  ----------------------------------------------------------------------------------------------

//         //Clear window
//         glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
//         glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

//         // todo : Drawing Conan  ----------------------------------------------------------------------------------------------
//         //draw here
//         // conan
//         shaderList[0]->UseShader();
//         uniformView = shaderList[0]->GetUniformLocation("view");
//         uniformModel = shaderList[0]->GetUniformLocation("model");
//         uniformProjection = shaderList[0]->GetUniformLocation("projection");

//         glm::mat4 view (1.0f);
//         view = glm::lookAt(cameraPos, cameraPos+cameraDirection, cameraUp);

//         //Object
//         glm::mat4 model (1.0f);
//         model = glm::translate(model, glm::vec3(0.0f, -1.0f, 2.5f));
//         model = glm::scale(model, glm::vec3(0.8f, 0.8f, 1.0f));
//         // model = glm::scale(model, glm::vec3(5.0f, 5.0f, 5.0f));

//         glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
//         glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));
//         glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

//         // glm::mat4 affineMat (1.0f);
//         // glm::mat4 affineMat = model * projection * view;
//         // glUniformMatrix4fv(uniformAffine, 1, GL_FALSE, glm::value_ptr(affineMat));

//         glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightcolour);
//         glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat*)&lightPos);

//         glActiveTexture(GL_TEXTURE0);
//         glBindTexture(GL_TEXTURE_2D, texture);

//         meshList[0]->RenderMesh();
        

//         // todo : Drawing Box  ----------------------------------------------------------------------------------------------

//         // box
//         model = glm::translate(model, glm::vec3(0.0f, 5.0f, 0.0f));
//         model = glm::scale(model, glm::vec3(10.0f, 10.0f, 10.0f));

//         glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
//         glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));
//         glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

//         glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightcolour);
//         glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat*)&lightPos);

//         glActiveTexture(GL_TEXTURE0);
//         glBindTexture(GL_TEXTURE_2D, texture2);

//         meshList[1]->RenderMesh();

//         //table
//         model = glm::translate(model, glm::vec3(-0.3f, -0.5f, -0.4f));
//         model = glm::scale(model, glm::vec3(0.2f, 0.2f, 0.2f));

//         glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
//         glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));
//         glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

//         glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightcolour);
//         glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat*)&lightPos);

//         glActiveTexture(GL_TEXTURE0);
//         glBindTexture(GL_TEXTURE_2D, texture3);

//         meshList[2]->RenderMesh();

//         // todo : Potraint Box  ----------------------------------------------------------------------------------------------

//         //potriat
//         model = glm::translate(model, glm::vec3(2.0f, 1.0f, -0.4f));
//         model = glm::scale(model, glm::vec3(0.5f, 0.5f, 0.5f));

//         glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
//         glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));
//         glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));

//         glUniform3fv(shaderList[0]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightcolour);
//         glUniform3fv(shaderList[0]->GetUniformLocation("lightPos"), 1, (GLfloat*)&lightPos);

//         glActiveTexture(GL_TEXTURE0);
//         glBindTexture(GL_TEXTURE_2D, texture4);

//         meshList[3]->RenderMesh();

//         // }

//         //light
//         // shaderList[1]->UseShader();
//         // uniformView = shaderList[1]->GetUniformLocation("view");
//         // uniformModel = shaderList[1]->GetUniformLocation("model");
//         // uniformProjection = shaderList[1]->GetUniformLocation("projection");
        
//         // // glm::mat4 model (1.0f);
//         // model = glm::translate(model, lightPos);
//         // model = glm::scale(model, glm::vec3(0.1f, 0.1f, 0.1f));

//         // glUniformMatrix4fv(uniformModel, 1, GL_FALSE, glm::value_ptr(model));
//         // glUniformMatrix4fv(uniformProjection, 1, GL_FALSE, glm::value_ptr(projection));
//         // glUniformMatrix4fv(uniformView, 1, GL_FALSE, glm::value_ptr(view));
//         // glUniform3fv(shaderList[1]->GetUniformLocation("lightColour"), 1, (GLfloat*)&lightcolour);

//         // light -> RenderMesh();

//         glUseProgram(0);
//         //end draw

//         mainWindow.swapBuffers();
//     }

//     return 0;
// }
