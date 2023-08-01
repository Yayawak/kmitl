#in
echo "is it moring ? Y|N"
read time
if [ $time = "Y" ]
then
    echo "Good Moring"
elif [ $time = "N" ]
then
    echo "Good Afternoon"
else
    echo "Sorry you must type Y or N."
    exit 1
fi
exit 0
