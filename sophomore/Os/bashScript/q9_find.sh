for file in $(find . -type f -name "*.c")
do
    # trimmed_name=`echo $file | cut -d'/' -f2` -> prog*.c
    # trimmed_name=`echo $file | cut -d'/' -f2 | cut -d'.' -f1` -> "prog*" no .c
    trimmed_name=`echo $file | cut -d'/' -f2 | cut -d'.' -f1`
    echo $trimmed_name
done
