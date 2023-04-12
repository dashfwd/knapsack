#!/bin/bash
docker image build -t knapsack:latest . && \
  docker run knapsack:latest