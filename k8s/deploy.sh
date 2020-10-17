#!/bin/bash

kubectl delete namespace simple-app

kubectl create namespace simple-app
kubectl config set-context --current --namespace=simple-app

kubectl apply -f simple-app.yml