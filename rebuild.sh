#!/bin/sh

dir=dist

if [[ ! -e $dir ]]; then
    mkdir $dir
elif [[ ! -d $dir ]]; then
    echo "$dir already exists but is not a directory" 1>&2
fi

bin/jjtree ElasticPL.jjt; bin/javacc ElasticPL.jj
javac -cp "lib/*" -d dist/ *.java
cd dist
jar cvfm test_compiler.jar ../Manifest *.class
cd ..
cp dist/test_compiler.jar .

java -jar test_compiler.jar sqrt.spl 
