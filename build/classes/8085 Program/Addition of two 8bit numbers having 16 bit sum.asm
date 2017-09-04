// ADDITION OF TWO 8 BIT NUMBERS HAVING 16 BIT SUM
// Manually strore 1st no in the memory location C050
// Manually store 2nd no in the memory location C051
// Result is stored in C052, & C053
	   LXI H,C050
	   MVI C,00
	   MOV A,M
	   INX H
	   ADD M
	   JNC AHEAD
	   INR C

AHEAD:	   STA C053
	   MOV A,C
	   STA C052
	   HLT
// EXAMPLE -> C050 = 98H, C051 = 9AH
// ANSWER-> C052 = 01H, C053 = 32H

# ORG C050
# DB 98H,9AH
