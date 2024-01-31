CXX=gcc
bin=bin
foo?=

all:

pipe:
# ${CXX} ipc/pipe/mockpipe.cpp  -o ${bin}/mockpipe && ${bin}/mockpipe
	${CXX} ipc/pipe/pipe${foo}.cpp  -o ${bin}/pipe${foo} && ${bin}/pipe${foo}

sem:
	${CXX} ./sem/sem0.c -o sem/sem0 && ${bin}/sem0
	

.PHONY:all sem