CLASSPATH=$CLASSPATH:/usr/share/java/junit.jar:.
export CLASSPATH
echo $CLASSPATH
alias junit="java -cp $CLASSPATH org.junit.runner.JUnitCore"
