#!/bin/bash

java -jar jflex-full-1.8.2.jar lexer.jflex

java -jar java-cup-11b.jar parser.cup


