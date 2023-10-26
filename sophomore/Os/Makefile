pathTo = pthreads/988_labq1.c
dirname = $(shell echo ${pathTo} | cut -d "/" -f1)
# nameOnly = $(cut -d "/" ${pathTo} -f2)
nameOnly = $(shell echo $(pathTo) | cut -d "/" -f2 | cut -d "." -f1)
args = 5

# nameOnly = cut -d "." ${nameOnly} -f1
lab:
# gcc -o $ -lpthread
# echo ${dirname}
# echo ${nameOnly}

	gcc -o ${dirname}/${nameOnly} ${pathTo} && ./${dirname}/${nameOnly} ${args}
# gcc -o ${dirname}/${nameOnly} ${pathTo} ${args} && ./${dirname}/${nameOnly}
# echo ${pathTo}
# echo ${pathTo}
# gcc -o 988_labq1 988_labq1.c -lpthread