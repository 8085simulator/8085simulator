// 2's COMPLEMENT OF A 16-BIT NUMBER
// The 16bit number is stored in C050,C051
// The answer is stored in C052,C053
	   LXI H,C050
	   MVI B,00
	   MOV A,M
	   CMA
	   ADI 01
	   STA C052
	   JNC GO
	   INR B

GO:	   INX H
	   MOV A,M
	   CMA
	   STA C053
	   HLT
// EXAMPLE-> C050=8C,C051=5B
// Answer-> C052=74,C053=A4

# ORG C050
# DB 8CH,5BH
 
