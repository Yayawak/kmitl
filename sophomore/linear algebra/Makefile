GPP=g++
GCC=gcc
# ProgName=determinantCalculator
invProgName=inverseMatrixFinder
# ProgName=app
SrcFiles=src/*/*.cpp src/*.cpp
buildDir=bin

all: ttest
# all: 
# ${GPP} -g ${SrcFiles} main.cpp -o && ./a.out
# ${GPP} -g ${SrcFiles} main.cpp -o bin/testFile && ./a.out

ttest:
	${GPP} -g ${SrcFiles} main.cpp -o bin/testFile && ./bin/testFile
# ${GPP} -g utils/* main.cpp  && ./a.out
# ${GPP} -g utils/Mat.cpp utils/prints.cpp main.cpp  && ./a.out
makeinverse:
	${GPP} -g ${SrcFiles} main.cpp -o bin/${invProgName} && ./bin/${invProgName}

makedet:
	${GPP} -g ${SrcFiles} main.cpp -o bin/${determinantCalculator} && ./bin/${determinantCalculator}

makeguassElimination:
	${GPP} -g ${SrcFiles} main.cpp -o bin/guassElim && ./bin/guassElim


gui:
# ${GCC} -o main.cpp $(pkg-config --cflags --libs gtk+-3.0) main.cpp
# ${GPP} `pkg-config --cflags gtk+-3.0` -o main main.cpp `pkg-config --libs gtk+-3.0`
	${GPP} -I/usr/local/opt/gtk+3/include -I/usr/local/include/glib-2.0 -I/usr/local/lib/glib-2.0/include -I/usr/local/include/pango-1.0 -I/usr/local/include/cairo -I/usr/local/include/gdk-pixbuf-2.0 -I/usr/local/include/atk-1.0 -o {ProgName} main.cpp -L/usr/local/opt/gtk+3/lib -L/usr/local/lib -lgtk-3 -lgdk-3 -lpangocairo-1.0 -lpango-1.0 -latk-1.0 -lcairo-gobject -lcairo -lgdk_pixbuf-2.0 -lgio-2.0 -lgobject-2.0 -lglib-2.0
gl:
	${GPP} -Wno-deprecated-declarations ./usegl/helloGl.cpp

# ${GCC} main.c $(pkg-config --cflags --libs gtk+-3.0)
