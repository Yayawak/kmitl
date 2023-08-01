myvar="Hi there"
echo $myvar
echo 1 "$myvar"
echo 2 '$myvar'
echo 3 'myvar contains ""$myvar""'
echo 4 \$myvar
echo 5 "myvar contains \"$myvar\""
echo Enter some text
read myvar
echo '$myvar' value now is $myvar
exit 0
