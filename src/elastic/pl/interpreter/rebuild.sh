#!/bin/sh

dir=../../../dist

if [[ ! -e $dir ]]; then
    mkdir $dir
elif [[ ! -d $dir ]]; then
    echo "$dir already exists but is not a directory" 1>&2
fi

java -cp ../../../../javacc-bin/lib/javacc.jar jjtree ElasticPL.jjt; java -cp ../../../../javacc-bin/lib/javacc.jar javacc ElasticPL.jj
cp JJTElasticPLParserState.recovery JJTElasticPLParserState.java


