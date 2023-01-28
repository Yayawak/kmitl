# n=$1
n=5
fileName="MainV3.java"

for((i=1; i<=n; i++))
do
	echo $i
	# echo $fileName
	javac $fileName
	# java "Test.$fileName"
	java "$fileName"

	sleep 0.1
	clear
done
