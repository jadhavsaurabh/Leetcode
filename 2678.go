package main

import (
	"fmt"
	"sync"
	"time"
)

func countSeniors(details []string) int {
    res := 0;

	for _, detail := range details{
		if(detail[11] >= '6' && detail[12] >= '0') {
			if(detail[11] == '6' && detail[12] == '0') {
				continue
			}
			res++
		}
	}
	return res;
}
