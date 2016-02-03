#!/bin/sh -e

curl -XGET '127.0.0.1:9200/business_document/_count' -d '
{
  "query" : {
    match_all : {}
  }
}
'
