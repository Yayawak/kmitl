rwildcard=$(foreach d,$(wildcard $(1:=/*)),$(call rwildcard,$d,$2) $(filter $(subst *,%,$2),$d))
dir_of_makefile := `pwd`
CXX := /usr/bin/clang++ 
FLAGS := -g -fcolor-diagnostics -fansi-escape-codes -std=c++17 
LibsFiles := $(call rwildcard, ../Libs,*.cpp)
GL_LIBS := -L /opt/homebrew/Cellar/glew/2.2.0_1/lib -L /opt/homebrew/Cellar/glfw/3.3.9/lib -l glew -l glfw -framework Cocoa -framework OpenGL -framework IOKit -framework CoreVideo 
all: general

general:
	$(CXX) $(FLAGS) -g $(LibsFiles) -g $(dir_of_makefile)/*.cpp $(GL_LIBS) -o $(dir_of_makefile)/main && $(dir_of_makefile)/main 

debug:
	chmod +x ./main && lldb ./main