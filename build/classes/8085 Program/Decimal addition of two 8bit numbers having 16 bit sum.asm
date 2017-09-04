// DECIMAL ADDITION OF TWO 8BIT NUMBERS, SUM 16 BITS
// Manually strore 1st no in the memory location C050
// Manually store 2nd no in the memory location C051
// Result is stored in C052, & C053
	   LXI H,C050
	   MVI C,00
	   MOV A,M
	   INX H
	   ADD M
	   DAA
	   JNC AHEAD
	   INR C

AHEAD:	   STA C053
	   MOV A,C
	   STA C052
	   HLT
// EXAMPLE -> C050 = 56H, C051 = 97H
// ANSWER -> C052 = 01H, C053 = 53H

# ORG C050
# DB 56H,97H
