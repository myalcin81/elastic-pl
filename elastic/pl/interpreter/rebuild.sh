#!/bin/sh

dir=../../../dist

if [[ ! -e $dir ]]; then
    mkdir $dir
elif [[ ! -d $dir ]]; then
    echo "$dir already exists but is not a directory" 1>&2
fi

../../../bin/jjtree ElasticPL.jjt; ../../../bin/javacc ElasticPL.jj
javac -cp "../../../lib/*" -d "../../../" *.java ../../../TestCompiler.java

cd ../../../dist
pwd
jar cvfm ElasticPL.jar ../Manifest ../elastic/pl/interpreter/*.class ../TestCompiler.class
cd ..
cp dist/ElasticPL.jar .

java -jar ElasticPL.jar sqrt.spl 
