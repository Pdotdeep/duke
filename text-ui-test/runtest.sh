#!/usr/bin/env bash

# create bin directory if it doesn't exist
if [ ! -d "../bin" ]
then
    mkdir ../bin
fi

# delete output from previous run
if [ -e "./ACTUAL.TXT" ]
then
    rm ACTUAL.TXT
fi

# compile the code into the bin folder, terminates if error occurred
if ! javac -cp ../src -Xlint:none -d ../bin ../src/main/java/com/pradeep/duke/*.java ../src/main/java/com/pradeep/duke/Activities/*.java  ../src/main/java/com/pradeep/duke/Exceptions/*.java ../src/main/java/com/pradeep/duke/Processing/*.java
then
    echo "********** BUILD FAILURE **********"
    exit 1
fi

# run the program, feed commands from input.txt file and redirect the output to the ACTUAL.TXT
java -classpath ../bin com/pradeep/duke/Duke < input.txt > ACTUAL.TXT

# compare the output to the expected output
diff ACTUAL.TXT EXPECTED.TXT
if [ $? -eq 0 ]
then
    echo "Test result: PASSED"
    ! rm ./data/duke.txt
    exit 0
else
    echo "Test result: FAILED"
    ! rm ./data/duke.txt
    exit 1
fi

