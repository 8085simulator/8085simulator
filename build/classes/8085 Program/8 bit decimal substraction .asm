// 8 BIT DECIMAL SUBSTRACTION
// if 2nd no is greater than 1st no then the answer will in 2's complement
// Manually strore 1st 8 bit no in the memory location C050
// Manually store 2nd 8 bit no in the memory location C051
// Result is stored in C052
	   LXI H,C051
	   MVI A,99
	   SUB M
	   INR A
	   DCX H
	   ADD M
	   DAA
	   STA C052
	   HLT
// EXAMPLE-> 99-48=51
// STORE-> C050=99,C051=48

# ORG C050
# DB 99H,48H
