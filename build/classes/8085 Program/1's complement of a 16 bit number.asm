// 1's COMPLEMENT OF A 16-BIT NUMBER
// The 16bit number is stored in C050,C051
// The answer is stored in C052,C053
	   LXI H,C050
	   MOV A,M
	   CMA
	   STA C052
	   INX H
	   MOV A,M
	   CMA
	   STA C053
	   HLT
// EXAMPLE-> C050=85,C051=54
// Answer-> C052=7A,C053=AB

# ORG C050
# DB 85H,54H
