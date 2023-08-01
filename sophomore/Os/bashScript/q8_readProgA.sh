# prog_name -> remove .c extension
prog_name=$(echo $1 | cut -d'.' -f1)
gcc -o $prog_name $1
# gcc $1 -o $progname $1
# gcc $($progname.c)-o $progname
if [ -f $1 ]
then
    # ans=$(./$prog_name)
    ans=`./$prog_name`
else
    ans=5
fi
printf "XXX %s : %s XXX\n" $1 $ans
./$prog_name
