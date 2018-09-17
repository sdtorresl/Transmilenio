#!/bin/bash

spring scaffold -n "inv_entrada:Entrada" -p \
"inv_entrada_nivel:nivel:String\
 inv_entrada_largo:largo:Double\
 inv_entrada_ancho:ancho:Double"\
 -t src/main/resources/scaffold-templates
