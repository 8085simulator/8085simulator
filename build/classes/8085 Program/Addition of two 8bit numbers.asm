// ADDITION OF TWO 8 BIT NUMBERS
// Manually strore 1st no in the memory location C050
// Manually store 2nd no in the memory location C051
// Result is stored in C053
	   LXI H,C050
	   MOV A,M
	   INX H
	   ADD M
	   STA C052
	   HLT
// EXAMPLE-> C050 = 55H, C051 =66H
// ANSWER -> C052 = BBH

# ORG C050
# DB 55H,66H
