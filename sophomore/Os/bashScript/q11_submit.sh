#!/bin/bash
a=progA.c
b=progB.c
c=progC.c

function runc() {
    # local output=$(gcc "$1" -o "$(echo "$1" | cut -d'.' -f1)")
    # local output=$(gcc "$1" -o "$(echo "$1" | cut -d'.' -f1)" 2>&1)
    local progName=$(echo "$1" | cut -d'.' -f1)
    # local output=$(gcc  -Wno-return-stack-address "$1" -o "$progName" && ./"$progName" 2>&1)
    # local output=$(gcc  -Wno-return-stack-address "$1" -o "$progName" && ./"$progName") # local output=$(gcc  -w "$1" -o "$progName" && ./"$progName" 2>&1) # if [] echo $(echo "$output" | cut -d' ' -f1)
    # local compileStatus=$(gcc -w "$1" -o "$progName")
    # gcc "$1" -o "$progName"
    gcc -w "$1" -o "$progName"
    local output=$(./"$progName") # local output=$(gcc  -w "$1" -o "$progName" && ./"$progName" 2>&1) # if [] echo $(echo "$output" | cut -d' ' -f1)
    # local compileStatus=$?

    # local compileStatus=$?
    # echo "compile status : $compileStatus"
    # echo "output : $output"
    # local score=0
    # if [ "$compileStatus" -ne 0 ] # failed compilation
    # if [ -n "$output" ]
    if [ "$output" == "" ]
    # if [[ $output -n ]]
    then
        score=5
    else
        if [ "$output" == "$2" ]
        # if [[ "$output" == "$2" ]]
        then
            score=10
        else
            score=7
        fi
    fi
    pnt $1 $score
}

function pnt() {
    # echo echo echo "$1" "$2"
    printf "\n%s \t %s\n" "$1" "$2"
}




if [ -f $a ]
then
    runc $a 20
fi

if [ -f $b ]
then
    runc $b 20
fi

if [ -f $c ]
then
    runc $c 999
fi
