#!/bin/bash
set -eo pipefail

while true; do
  aws lambda invoke --function-name testeFunc out.json
  cat out.json
  echo ""
  sleep 2
done